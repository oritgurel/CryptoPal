package com.cryptopal.android.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cryptopal.android.CryptoPalApplication;
import com.cryptopal.android.R;
import com.cryptopal.android.adapters.MessageListAdapter;
import com.cryptopal.android.chatmodels.Message;
import com.cryptopal.android.eventbus.SendMessageEvent;
import com.cryptopal.android.networking.NetworkAPI;
import com.cryptopal.android.networking.requests.ReqSendMessage;
import com.cryptopal.android.networking.responses.RespSendMessage;
import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements TextWatcher {

    private final static String TAG = "ChatActivity";
    private List<Message> messageList = new ArrayList<Message>();
    FloatingActionButton sendButton;
    EditText editMessage;
    MessageListAdapter messageListAdapter;
    RecyclerView recyclerViewChat;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    boolean isMike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        messageList.add(new Message(getString(R.string.welcome_message), true));

        getWindow().setTitle("Your Trading Assistant");

        EventBus.getDefault().register(this);
        messageListAdapter = new MessageListAdapter(this, messageList);
        recyclerViewChat = findViewById(R.id.reyclerview_message_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewChat.setLayoutManager(linearLayoutManager);
        recyclerViewChat.setAdapter(messageListAdapter);
//


        sendButton = findViewById(R.id.button_chatbox_send);
        editMessage = findViewById(R.id.edittext_chatbox);
        editMessage.addTextChangedListener(this);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editMessage.getText().toString();

                if (!isMike) {

                    //add user message to chat
                    messageList.add(new Message(message, false));
                    messageListAdapter.notifyDataSetChanged();
                    recyclerViewChat.scrollToPosition( messageList.size() - 1);

                    //call for bot reply from network
                    ReqSendMessage reqSendMessage = new ReqSendMessage();

                        reqSendMessage.setMessage(message);
                        String token = ((CryptoPalApplication) getApplication()).getmAccesToken();

                        NetworkAPI.getInstance().sendMessage(token,
                                reqSendMessage);
                } else {

                    promptSpeachInput();
                }
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_exchanges: {
                Intent intentExchangeList;
                intentExchangeList = new Intent(ChatActivity.this, ChooseExchangeActivity.class);
                startActivity(intentExchangeList);

                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void onEvent(SendMessageEvent aSendMessageEvent){
        Log.d( TAG, "bot reply : " + aSendMessageEvent.getReply());
        RespSendMessage botResponse = new RespSendMessage();
        botResponse.setMessage(aSendMessageEvent.getReply());
        Message message = new Message(botResponse.getMessage(), true);

        messageList.add(message);
        messageListAdapter.notifyDataSetChanged();
        recyclerViewChat.scrollToPosition( messageList.size() - 1);
    }

    public void promptSpeachInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", new String[]{"en"});
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "SAY SOMETHING");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Speach not supported", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    messageList.add(new Message(result.get(0), false));
                    messageListAdapter.notifyDataSetChanged();
                    recyclerViewChat.scrollToPosition( messageList.size() - 1);
                }
            }break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (charSequence != null) {

            if (charSequence.toString() != null && charSequence.length() > 0) {

                sendButton.setImageResource(R.drawable.ic_send_copy);
                isMike = false;

            } else {
                sendButton.setImageResource(R.drawable.dictation_glyph);
                isMike = true;
            }
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

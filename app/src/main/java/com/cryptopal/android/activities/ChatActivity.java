package com.cryptopal.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class ChatActivity extends AppCompatActivity {

    private final static String TAG = "ChatActivity";
    private List<Message> messageList = new ArrayList<Message>();
    Button sendButton;
    EditText editMessage;
    MessageListAdapter messageListAdapter;
    RecyclerView recyclerViewChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        messageList.add(new Message(getString(R.string.welcome_message), true));

        getWindow().setTitle("Your Trading Assistant");

        EventBus.getDefault().register(this);
        messageListAdapter = new MessageListAdapter(this, messageList);
        recyclerViewChat = findViewById(R.id.reyclerview_message_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewChat.setLayoutManager(linearLayoutManager);
        recyclerViewChat.setAdapter(messageListAdapter);
//


        sendButton = findViewById(R.id.button_chatbox_send);
        editMessage = findViewById(R.id.edittext_chatbox);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editMessage.getText().toString();
                //add user message to chat
                messageList.add(new Message(message, false));


                        //call for bot reply from network
                ReqSendMessage reqSendMessage = new ReqSendMessage();
                reqSendMessage.setMessage(message);
                String token = ((CryptoPalApplication) getApplication()).getmAccesToken();

                NetworkAPI.getInstance().sendMessage(token,
                        reqSendMessage);
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


    }

}

package com.cryptopal.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cryptopal.android.R;
import com.cryptopal.android.chatmodels.Message;

import java.util.List;

/**
 * Created by user2 on 16/03/2018.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private static final int VIEW_TYPE_USER_MESSAGE = 10;
    private static final int VIEW_TYPE_BOT_MESSAGE = 20;
    private static final int VIEW_TYPE_ADMIN_MESSAGE = 30;

    private Context mContext;
    private List<Message> mMessageList;


    public MessageListAdapter(Context context, List<Message> messageList) {
        mContext = context;
        mMessageList = messageList;

    }

    void setMessageList(List<Message> messages) {
        mMessageList = messages;
        notifyDataSetChanged();
    }


    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_USER_MESSAGE) {
            View itemView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_message_sent, parent, false);

            return new MessageViewHolder(itemView);
        }
        else if (viewType == VIEW_TYPE_BOT_MESSAGE) {
            View itemView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_message_recived, parent, false);

            return new MessageViewHolder(itemView);
        } else if (viewType == VIEW_TYPE_ADMIN_MESSAGE) {
            //
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {

        holder.bind(mMessageList.get(position));

    }

    @Override
    public int getItemViewType(int position) {

      Message message = mMessageList.get(position);
      boolean isBot = message.isBot();

      if (isBot) {
          return VIEW_TYPE_BOT_MESSAGE;
      } else {
          return VIEW_TYPE_USER_MESSAGE;
      }

    }

    @Override
    public int getItemCount() {
        return this.mMessageList.size();
    }

    public void updateList(List<Message> data) {
        mMessageList = data;
        notifyDataSetChanged();
    }

    public void addMessage(Message message)
    {
        mMessageList.add(message);
        notifyItemInserted(mMessageList.size()-1);
    }
}

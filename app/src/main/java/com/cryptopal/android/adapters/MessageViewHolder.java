package com.cryptopal.android.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cryptopal.android.R;
import com.cryptopal.android.chatmodels.Message;

/**
 * Created by user2 on 16/03/2018.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {


    TextView messageText, timeText, nameText;
    ImageView profileImage;

    MessageViewHolder(View itemView) {
        super(itemView);
        messageText = itemView.findViewById(R.id.text_message_body);
        timeText = itemView.findViewById(R.id.text_message_time);
//        nameText = itemView.findViewById(R.id.text_message_name);
//        profileImage = itemView.findViewById(R.id.image_message_profile);
    }

    void bind(Message message) {
        messageText.setText(message.getMessage());
    }


}

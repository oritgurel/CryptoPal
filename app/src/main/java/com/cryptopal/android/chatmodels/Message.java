package com.cryptopal.android.chatmodels;


import com.firebase.ui.auth.data.model.*;
import com.firebase.ui.auth.data.model.User;

/**
 * Created by user2 on 16/03/2018.
 */

public class Message {

    String message;
    com.firebase.ui.auth.data.model.User sender;
    boolean isBot;
    long createdAt;
    long messageId;

    public Message(String message, boolean isBot) {
        this.message = message;
        this.isBot = isBot;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(com.firebase.ui.auth.data.model.User sender) {
        this.sender = sender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }
}

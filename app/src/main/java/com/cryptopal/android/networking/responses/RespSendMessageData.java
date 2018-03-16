package com.cryptopal.android.networking.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by user2 on 16/03/2018.
 */

public class RespSendMessageData {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("reply")
    @Expose
    private String reply;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("message", message).append("reply", reply).toString();
    }

}
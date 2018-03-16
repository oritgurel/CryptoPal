package com.cryptopal.android.eventbus;

import com.cryptopal.android.networking.responses.RespSendMessageData;

/**
 * Created by user2 on 16/03/2018.
 */

public class SendMessageEvent {

    public final String reply;

    public SendMessageEvent(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }
}

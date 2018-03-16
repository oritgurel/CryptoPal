package com.cryptopal.android.eventbus;

import com.cryptopal.android.networking.responses.RespSendMessageData;

/**
 * Created by user2 on 16/03/2018.
 */

public class SendMessageEvent {

    public final RespSendMessageData data;

    public SendMessageEvent(RespSendMessageData data) {
        this.data = data;
    }

    public RespSendMessageData getData() {
        return data;
    }
}

package com.cryptopal.android.eventbus;

import com.cryptopal.android.networking.responses.RespUserCreateData;

/**
 * Created by user2 on 16/03/2018.
 */

public class CreateUserEvent {

    public final RespUserCreateData data;

    public CreateUserEvent(RespUserCreateData data) {
        this.data = data;
    }

    public RespUserCreateData getData() {
        return data;
    }
}

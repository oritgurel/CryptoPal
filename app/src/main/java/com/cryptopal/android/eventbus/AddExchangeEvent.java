package com.cryptopal.android.eventbus;

/**
 * Created by user2 on 16/03/2018.
 */

public class AddExchangeEvent {

    public final Object data;

    public AddExchangeEvent(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}

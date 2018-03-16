package com.cryptopal.android.eventbus;

/**
 * Created by user2 on 16/03/2018.
 */

public class AddExchangeEvent {

    public boolean isSuccess() {
        return success;
    }

    public final boolean success;

    public AddExchangeEvent(boolean success) {
        this.success = success;
    }


}

package com.cryptopal.android.eventbus;

/**
 * Created by user2 on 16/03/2018.
 */

public class UpdateFCMTokenEvent {

    public UpdateFCMTokenEvent(Object data) {
        this.data = data;
    }

    public final Object data;

    public Object getData() {
        return data;
    }
}

package com.cryptopal.android.eventbus;

import com.cryptopal.android.networking.responses.ModelExchange;

import java.util.List;

/**
 * Created by user2 on 16/03/2018.
 */

public class GetExchangesEvent {

    public final List<ModelExchange> data;

    public GetExchangesEvent(List<ModelExchange> data) {
        this.data = data;
    }

    public List<ModelExchange> getData() {
        return data;
    }
}


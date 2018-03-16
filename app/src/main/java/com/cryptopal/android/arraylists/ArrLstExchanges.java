package com.cryptopal.android.arraylists;

import com.cryptopal.android.eventbus.GetExchangesEvent;
import com.cryptopal.android.networking.responses.ModelExchange;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by danielszasz on 15/03/2018.
 */

public class ArrLstExchanges extends ArrayList<ModelExchange> {

    public ArrLstExchanges() {
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(GetExchangesEvent aGetExchangesEvent) {
        clear();
        addAll(aGetExchangesEvent.getData());
    }
}











package com.cryptopal.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cryptopal.android.eventbus.AddExchangeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Test on 15/03/2018.
 */

public class UserAndPassForExchange extends AppCompatActivity{

    public boolean isLoggedIn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exchange);

        EventBus.getDefault().register( this);

    }

    @Subscribe
    public void onEvent(AddExchangeEvent aAddExchangeEvent){

        Log.d( "UserAndPassForExchange", "added exchange : " + aAddExchangeEvent.isSuccess());

    }
}

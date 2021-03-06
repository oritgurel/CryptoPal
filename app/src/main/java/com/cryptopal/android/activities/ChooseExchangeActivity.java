package com.cryptopal.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cryptopal.android.R;
import com.cryptopal.android.adapters.ExchangeAdapter;
import com.cryptopal.android.arraylists.ArrLstExchanges;
import com.cryptopal.android.entiteis.Exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user2 on 15/03/2018.
 */

public class ChooseExchangeActivity extends AppCompatActivity {

    ArrLstExchanges arrLstExchanges;



    private RecyclerView recyclerView;
    private ExchangeAdapter mAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.myTheme);
        setContentView(R.layout.activity_choose_exchange);
        List<Exchange> exchangeList = new ArrayList<>();
        exchangeList.add(new Exchange("BITTREX",true));

        exchangeList.add(new Exchange("KRAKEN",false));
        exchangeList.add(new Exchange("COINBASE",false));

        setTitle("Choose Exchange");

        recyclerView = (RecyclerView) findViewById(R.id.exchange);



        arrLstExchanges = new ArrLstExchanges();
        mAdapter = new ExchangeAdapter( this, exchangeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }


}

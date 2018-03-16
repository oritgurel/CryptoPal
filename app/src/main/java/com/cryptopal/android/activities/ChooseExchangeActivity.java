package com.cryptopal.android.activities;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
 import android.widget.Toast;

import com.cryptopal.android.CryptoPalApplication;
import com.cryptopal.android.R;
import com.cryptopal.android.arraylists.ArrLstExchanges;
import com.cryptopal.android.enteteis.Exchange;

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
        setContentView(R.layout.activity_choose_exchange);
        List<Exchange> exchangeList = new ArrayList<>();
        exchangeList.add(new Exchange("BITTREX",false));

        exchangeList.add(new Exchange("KRAKEN",false));
        exchangeList.add(new Exchange("COINBASE",false));

        setTitle("Choose Exchange");

        recyclerView = (RecyclerView) findViewById(R.id.exchange);



        arrLstExchanges = new ArrLstExchanges();
        mAdapter = new ExchangeAdapter(exchangeList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//        listViewExchange.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int postion, long Id) {
//                Toast.makeText( ChooseExchangeActivity.this, "selected : " + exchange[postion], Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
    }


}

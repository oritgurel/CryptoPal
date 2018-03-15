package com.cryptopal.android;

import android.app.Fragment;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by Test on 15/03/2018.
 */

public class ChooseExchangeAdapter extends ListActivity  {

    String [] exchange = new String[]{
            "one",
            "two",
            "tree",
            "for",
            "five",
            "sixs",
            "seven",
    };

    protected  void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_choose_exchange);

        ListView exchange = (ListView)findViewById(R.id.exchange);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout .activity_list_item);
        exchange.setAdapter(adapter);

        exchange.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int postion, long Id){

            }

        });
    }

}

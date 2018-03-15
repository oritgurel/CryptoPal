package com.cryptopal.android.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cryptopal.android.R;

/**
 * Created by user2 on 15/03/2018.
 */

public class ChooseExchangeActivity extends AppCompatActivity {

    String[] exchange = new String[]{
            "one",
            "two",
            "tree",
            "for",
            "five",
            "six",
            "seven"
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exchange);

        final ListView listViewExchange = (ListView) findViewById(R.id.exchange);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, exchange);
        listViewExchange.setAdapter(adapter);

        listViewExchange.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int postion, long Id) {
                Toast.makeText( ChooseExchangeActivity.this, "selected : " + exchange[postion], Toast.LENGTH_SHORT).show();
            }

        });
    }


}

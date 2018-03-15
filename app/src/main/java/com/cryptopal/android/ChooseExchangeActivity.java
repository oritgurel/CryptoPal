package com.cryptopal.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by user2 on 15/03/2018.
 */

public class ChooseExchangeActivity extends AppCompatActivity {

    String [] exchange = new String[]{
            "one",
            "two",
            "tree",
            "for",
            "five",
            "six",
            "seven",

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exchange);

        ListView exchange = (ListView) findViewById(R.id.exchange);

        ArrayAdapter adapter = new ArrayAdapter()
    }


}

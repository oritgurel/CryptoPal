package com.cryptopal.android.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cryptopal.android.R;
import com.cryptopal.android.enteteis.Exchange;

import java.util.List;

/**
 * Created by Test on 16/03/2018.
 */

public class ExchangeAdapter extends RecyclerView.Adapter<ExchangeAdapter.MyViewHolder> {
    public ExchangeAdapter(List<Exchange> exchangeList) {
        this.exchangeList = exchangeList;
    }

    private List<Exchange> exchangeList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView isConfirmed;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.item_title);
            isConfirmed = view.findViewById(R.id.item_img);

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itam_exchange_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Exchange exchange = exchangeList.get(position);
        holder.title.setText(exchange.getName());
        if (exchange.isConfirmed()) {
            holder.isConfirmed.setVisibility(View.VISIBLE);
        }else{
            holder.isConfirmed.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return exchangeList.size();
    }

}
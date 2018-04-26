package com.cryptopal.android.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cryptopal.android.R;
import com.cryptopal.android.UserAndPassForExchange;
import com.cryptopal.android.entiteis.Exchange;

import java.util.List;

/**
 * Created by Test on 16/03/2018.
 */

public class ExchangeAdapter extends RecyclerView.Adapter<ExchangeAdapter.MyViewHolder> {
    private List<Exchange> exchangeList;
    private Context mContext;

    public ExchangeAdapter(Context aContext, List<Exchange> exchangeList) {
        this.exchangeList = exchangeList;
        mContext = aContext;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        private LinearLayout mLinearLayoutMain;
        ImageView isConfirmed;


        public MyViewHolder(View view) {
            super(view);
            mLinearLayoutMain = view.findViewById(R.id.lolinItemExchangeClick);
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
        } else {
            holder.isConfirmed.setVisibility(View.INVISIBLE);
        }
        holder.mLinearLayoutMain.setTag( exchange.getName());
        holder.mLinearLayoutMain.setOnClickListener(onClickExchange);

    }

    private View.OnClickListener onClickExchange = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Toast.makeText( view.getContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//            openExchangeDetailsActivity(((TextView)view).getText());
            openExchangeDetailsDialog(view.getTag().toString());
        }
    };


    private void openExchangeDetailsDialog(String aExchangeName) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

        //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle( "Credentials for : " + aExchangeName);

        alertDialog.setView( R.layout.dlg_exchange_credentials);

//        // Setting Icon to Dialog
//        alertDialog.setIcon(R.drawable.key);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
//                        Toast.makeText(mContext, "Password Matched", Toast.LENGTH_SHORT).show();
//                        NetworkAPI.getInstance().addExchange(((CryptoPalApplication)CryptoPalApplication.APP_INSTANCE).getAccesToken(), new ReqExchangeAdd( ));

                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.cancel();
                    }
                });

        // closed

        // Showing Alert Message
        alertDialog.show();
    }


    private void openExchangeDetailsActivity(String aExchangeName) {
        Intent i = new Intent(mContext, UserAndPassForExchange.class);
        mContext.startActivity(i);
    }


    @Override
    public int getItemCount() {
        return exchangeList.size();
    }


}

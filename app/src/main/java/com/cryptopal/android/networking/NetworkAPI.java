package com.cryptopal.android.networking;

import android.widget.Toast;

import com.cryptopal.android.CryptoPalApplication;
import com.cryptopal.android.eventbus.AddExchangeEvent;
import com.cryptopal.android.eventbus.CreateUserEvent;
import com.cryptopal.android.eventbus.GetExchangesEvent;
import com.cryptopal.android.eventbus.SendMessageEvent;
import com.cryptopal.android.eventbus.UpdateFCMTokenEvent;
import com.cryptopal.android.networking.requests.ReqExchangeAdd;
import com.cryptopal.android.networking.requests.ReqSendMessage;
import com.cryptopal.android.networking.requests.ReqUpdateFCMToken;
import com.cryptopal.android.networking.requests.ReqUserCreate;
import com.cryptopal.android.networking.responses.RespExchangeAdd;
import com.cryptopal.android.networking.responses.RespExchanges;
import com.cryptopal.android.networking.responses.RespSendMessage;
import com.cryptopal.android.networking.responses.RespUpdateFCMToken;
import com.cryptopal.android.networking.responses.RespUserCreate;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danielszasz on 15/03/2018.
 */

public class NetworkAPI{

    static final String BASE_URL = "http://cryptopalapi.heroapps.co.il";

    static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    static Retrofit retrofit;
    static INetworkAPI networkAPI;

    private static final NetworkAPI ourInstance = new NetworkAPI();

    public static NetworkAPI getInstance() {
        return ourInstance;
    }

    private NetworkAPI() {

            retrofit = retrofitBuilder.build();
            networkAPI = retrofit.create(INetworkAPI.class);
    }

    public void userCreate(ReqUserCreate reqUserCreate){
        Call<RespUserCreate> respUserCreateCall = networkAPI.userCreate(reqUserCreate);
        respUserCreateCall.enqueue(new Callback<RespUserCreate>() {
            @Override
            public void onResponse(Call<RespUserCreate> call, Response<RespUserCreate> response) {

                    if (response.body().getSuccess()) {
                        EventBus.getDefault().post(new CreateUserEvent(
                                response.body().getData())
                        );
                    } else {
                        Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Error : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<RespUserCreate> call, Throwable t) {
                Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Network Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getExchanges(String authorization) {
        Call<RespExchanges> respExchangesCall = networkAPI.getExchanges(authorization);
        respExchangesCall.enqueue(new Callback<RespExchanges>() {
            @Override
            public void onResponse(Call<RespExchanges> call, Response<RespExchanges> response) {
                if (response.body().getSuccess()) {
                    EventBus.getDefault().post(new GetExchangesEvent(
                            response.body().getData()
                    ));
                } else {
                    Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Error : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespExchanges> call, Throwable t) {
                Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Network Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addExchange(String authorization, ReqExchangeAdd aReqExchangeAdd) {
        Call<RespExchangeAdd> respExchangeAddCall = networkAPI.addExchange(authorization, aReqExchangeAdd);
        respExchangeAddCall.enqueue(new Callback<RespExchangeAdd>() {
            @Override
            public void onResponse(Call<RespExchangeAdd> call, Response<RespExchangeAdd> response) {
                if (response.body().getSuccess()) {
                    EventBus.getDefault().post(new AddExchangeEvent(
                            response.body().getData()
                    ));
                } else {
                    Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Error : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespExchangeAdd> call, Throwable t) {
                Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Network Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateFCMToken(ReqUpdateFCMToken aReqUpdateFCMToken) {
        Call<RespUpdateFCMToken> respUpdateFCMTokenCall = networkAPI.updateFCMToken(aReqUpdateFCMToken);
        respUpdateFCMTokenCall.enqueue(new Callback<RespUpdateFCMToken>() {
            @Override
            public void onResponse(Call<RespUpdateFCMToken> call, Response<RespUpdateFCMToken> response) {
                if (response.body().getSuccess()) {
                    EventBus.getDefault().post(new UpdateFCMTokenEvent(
                            response.body().getData()));
                }
                else {
                    Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Error : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespUpdateFCMToken> call, Throwable t) {
                Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Network Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void sendMessage(String authorization, ReqSendMessage aReqSendMessage) {
        Call<RespSendMessage> respSendMessageCall = networkAPI.sendMessage(authorization, aReqSendMessage);
        respSendMessageCall.enqueue(new Callback<RespSendMessage>() {
            @Override
            public void onResponse(Call<RespSendMessage> call, Response<RespSendMessage> response) {
                if (response.body().getSuccess()) {
                    EventBus.getDefault().post(new SendMessageEvent(
                            response.body().getData()
                    ));
                }
                else {
                    Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Error : " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespSendMessage> call, Throwable t) {
                Toast.makeText(CryptoPalApplication.APP_INSTANCE, "Network Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

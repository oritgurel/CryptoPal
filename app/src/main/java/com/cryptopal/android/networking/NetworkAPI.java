package com.cryptopal.android.networking;

import com.cryptopal.android.networking.requests.ReqUserCreate;
import com.cryptopal.android.networking.responses.RespUserCreate;

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



//    @POST("/user/create")
//    @Headers("Content-Type:application/json")
//    Call<RespUserCreate> userCreate(@Body ReqUserCreate aReqUserCreate);
//
//    @GET("/exchanges")
//    Call<RespExchanges> getExchanges(@Header("Authorization") String authorization);
//
//    @POST("/exchanges/add")
//    @Headers("Content-Type:application/json")
//    Call<RespExchangeAdd> addExchange(@Header("Authorization") String authorization, @Body ReqExchangeAdd aReqExchangeAdd);
//
//
//    @POST("/user/updateFCMToken")
//    @Headers("Content-Type:application/json")
//    Call<RespUpdateFCMToken> updateFCMToken(@Body ReqUpdateFCMToken aReqUpdateFCMToken);
//
//    @POST("/ask")
//    @Headers("Content-Type:application/json")
//    Call<RespSendMessage> sendMessage(@Header("Authorization") String authorization, @Body ReqSendMessage aReqSendMessage);


    public void userCreate(ReqUserCreate reqUserCreate){
        Call<RespUserCreate> respUserCreate = networkAPI.userCreate(reqUserCreate);
        respUserCreate.enqueue(new Callback<RespUserCreate>() {
            @Override
            public void onResponse(Call<RespUserCreate> call, Response<RespUserCreate> response) {

            }

            @Override
            public void onFailure(Call<RespUserCreate> call, Throwable t) {

            }
        });
    }




}

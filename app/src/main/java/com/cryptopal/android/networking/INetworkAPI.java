package com.cryptopal.android.networking;

import com.cryptopal.android.networking.requests.ReqExchangeAdd;
import com.cryptopal.android.networking.requests.ReqSendMessage;
import com.cryptopal.android.networking.requests.ReqUpdateFCMToken;
import com.cryptopal.android.networking.requests.ReqUserCreate;
import com.cryptopal.android.networking.responses.RespExchangeAdd;
import com.cryptopal.android.networking.responses.RespExchanges;
import com.cryptopal.android.networking.responses.RespSendMessage;
import com.cryptopal.android.networking.responses.RespUpdateFCMToken;
import com.cryptopal.android.networking.responses.RespUserCreate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by danielszasz on 15/03/2018.
 */

public interface INetworkAPI {

    @POST("/user/create")
    @Headers("Content-Type:application/json")
    Call<RespUserCreate> userCreate(@Body ReqUserCreate aReqUserCreate);

    @GET("/exchanges")
    Call<RespExchanges> getExchanges(@Header("Authorization") String authorization);

    @POST("/exchanges/add")
    @Headers("Content-Type:application/json")
    Call<RespExchangeAdd> addExchange(@Header("Authorization") String authorization, @Body ReqExchangeAdd aReqExchangeAdd);


    @POST("/user/updateFCMToken")
    @Headers("Content-Type:application/json")
    Call<RespUpdateFCMToken> updateFCMToken(@Body ReqUpdateFCMToken aReqUpdateFCMToken);

    @POST("/ask")
    @Headers("Content-Type:application/json")
    Call<RespSendMessage> sendMessage(@Header("Authorization") String authorization, @Body ReqSendMessage aReqSendMessage);

}


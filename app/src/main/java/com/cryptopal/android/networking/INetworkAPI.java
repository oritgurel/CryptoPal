package com.cryptopal.android.networking;

import com.cryptopal.android.networking.requests.ReqUserCreate;
import com.cryptopal.android.networking.responses.RespUserCreate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by danielszasz on 15/03/2018.
 */

public interface INetworkAPI {

    @POST("/user/create")
    @Headers("Content-Type:application/json")
    Call<RespUserCreate> userCreate(@Body ReqUserCreate aReqUserCreate);

}


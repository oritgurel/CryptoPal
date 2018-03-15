package com.cryptopal.android.networking.responses;

/**
 * Created by danielszasz on 15/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class RespUserCreateData implements Serializable {

    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    private final static long serialVersionUID = -3689184151949946576L;

    /**
     * No args constructor for use in serialization
     */
    public RespUserCreateData() {
    }

    /**
     * @param accessToken
     */
    public RespUserCreateData(String accessToken) {
        super();
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accessToken", accessToken).toString();
    }

}

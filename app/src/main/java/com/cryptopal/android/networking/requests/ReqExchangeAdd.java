package com.cryptopal.android.networking.requests;

/**
 * Created by user2 on 15/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ReqExchangeAdd {

    @SerializedName("exchangeID")
    @Expose
    private Integer exchangeID;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public ReqExchangeAdd(Integer aExchangeID, String aUsername, String aPassword) {
        exchangeID = aExchangeID;
        username = aUsername;
        password = aPassword;
    }

    public Integer getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(Integer exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("exchangeID", exchangeID).append("username", username).append("password", password).toString();
    }

}

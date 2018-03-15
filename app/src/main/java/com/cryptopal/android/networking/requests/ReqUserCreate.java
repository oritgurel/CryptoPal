package com.cryptopal.android.networking.requests;

/**
 * Created by danielszasz on 15/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ReqUserCreate implements Serializable
{

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fcmToken")
    @Expose
    private String fcmToken;
    private final static long serialVersionUID = -1829080884748843094L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ReqUserCreate() {
    }

    /**
     *
     * @param userID
     * @param email
     * @param fcmToken
     */
    public ReqUserCreate(String userID, String email, String fcmToken) {
        super();
        this.userID = userID;
        this.email = email;
        this.fcmToken = fcmToken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userID", userID).append("email", email).append("fcmToken", fcmToken).toString();
    }

}
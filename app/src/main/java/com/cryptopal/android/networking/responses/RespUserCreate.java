package com.cryptopal.android.networking.responses;

/**
 * Created by danielszasz on 15/03/2018.
 */
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RespUserCreate implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private RespUserCreateData data;
    private final static long serialVersionUID = -2520438251865949845L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RespUserCreate() {
    }

    /**
     *
     * @param message
     * @param data
     * @param success
     */
    public RespUserCreate(Boolean success, String message, RespUserCreateData data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RespUserCreateData getData() {
        return data;
    }

    public void setData(RespUserCreateData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("success", success).append("message", message).append("data", data).toString();
    }

}


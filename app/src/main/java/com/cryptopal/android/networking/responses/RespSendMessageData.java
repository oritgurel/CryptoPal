package com.cryptopal.android.networking.responses;

/**
 * Created by user2 on 15/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RespSendMessageData {

    @SerializedName("answer")
    @Expose
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("answer", answer).toString();
    }

}
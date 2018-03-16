package com.cryptopal.android;

import android.app.Service;
import android.util.Log;

import com.cryptopal.android.networking.NetworkAPI;
import com.cryptopal.android.networking.requests.ReqUserCreate;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by user2 on 15/03/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "FirebaseIDService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

    }

    //this method will be called
    //when the token is generated
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        //now we will have the token
        String token = FirebaseInstanceId.getInstance().getToken();

        NetworkAPI.getInstance().userCreate( new ReqUserCreate(
                FirebaseAuth.getInstance().getCurrentUser().getUid(),
                FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                token
        ));

        //for now we are displaying the token in the log
        //copy it as this method is called only when the new token is generated
        //and usually new token is only generated when the app is reinstalled or the data is cleared
        Log.d(TAG, token);
    }
}

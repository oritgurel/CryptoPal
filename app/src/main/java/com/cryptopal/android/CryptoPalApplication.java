package com.cryptopal.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.EventLog;
import android.util.Log;
import android.widget.TextView;

import com.cryptopal.android.activities.LoginActivity;
import com.cryptopal.android.arraylists.ArrLstExchanges;
import com.cryptopal.android.eventbus.AddExchangeEvent;
import com.cryptopal.android.eventbus.CreateUserEvent;
import com.cryptopal.android.eventbus.GetExchangesEvent;
import com.cryptopal.android.eventbus.SendMessageEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.cryptopal.android.helper.Helper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CryptoPalApplication extends Application {

    private static final String TAG = "CryptoPalApplication";
    public static Context APP_INSTANCE;

    private ArrLstExchanges mArrLstExchanges;

    public FirebaseAuth firebaseAuth;

    public FirebaseAuth.AuthStateListener mAuthListener;
    private String mAccesToken;

    public FirebaseAuth getFirebaseAuth(){
        return firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        EventBus.getDefault().register( this);

        APP_INSTANCE = this;

        mArrLstExchanges = new ArrLstExchanges();
    }

    public String getFirebaseUserAuthenticateId() {
        String userId = null;
        if(firebaseAuth.getCurrentUser() != null){
            userId = firebaseAuth.getCurrentUser().getUid();
        }
        return userId;
    }

    public void checkUserLogin(final Context context){
        if(firebaseAuth.getCurrentUser() != null){
//            Intent profileIntent = new Intent(context, ProfileActivity.class);
//            context.startActivity(profileIntent);
        }
    }

    public void isUserCurrentlyLogin(final Context context){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(null != user){
//                    Intent profileIntent = new Intent(context, ProfileActivity.class);
//                    context.startActivity(profileIntent);
                }else{
                    Intent loginIntent = new Intent(context, LoginActivity.class);
                    context.startActivity(loginIntent);
                }
            }
        };
    }

    public void createNewUser(Context context, String email, String password, final TextView errorMessage){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                if (!task.isSuccessful()) {
                    errorMessage.setText("Failed to login. Invalid user");
                }
            }
        });
    }

    public void loginAUser(final Context context, String email, String password, final TextView errorMessage){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            errorMessage.setText("Failed to login");
                        }else {
                            Helper.displayMessageToast(context, "User has been login");
//                            Intent profileIntent = new Intent(context, ProfileActivity.class);
//                            context.startActivity(profileIntent);
                        }
                    }
                });
    }

    public ArrLstExchanges getArrLstExchanges() {
        return mArrLstExchanges;
    }

    @Subscribe
    public void onEvent(CreateUserEvent aCreateUserEvent){
        Log.d( TAG, "got authentication for our server : " + aCreateUserEvent.getData().getAccessToken());
        mAccesToken = aCreateUserEvent.getData().getAccessToken();
    }

    @Subscribe
    public void onEvent(SendMessageEvent aSendMessageEvent){
        Log.d( TAG, "bot reply : " + aSendMessageEvent.getReply());

    }

    public String getAccesToken() {
        return mAccesToken;
    }
}

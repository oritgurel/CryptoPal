package com.cryptopal.android.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cryptopal.android.CryptoPalApplication;
import com.cryptopal.android.R;
import com.google.firebase.auth.FirebaseAuth;
import com.cryptopal.android.helper.Helper;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText emailInput;

    private EditText passwordInput;

    private TextView signUpText;

    private TextView loginError;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        mAuth = ((CryptoPalApplication)getApplication()).getFirebaseAuth();
        ((CryptoPalApplication)getApplication()).checkUserLogin(LoginActivity.this);

        loginError = (TextView)findViewById(R.id.login_error);

        emailInput = (EditText)findViewById(R.id.email);
        passwordInput = (EditText)findViewById(R.id.password);

        signUpText = (TextView)findViewById(R.id.register);

        final Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = emailInput.getText().toString();
                String enteredPassword = passwordInput.getText().toString();

                if(TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)){
                    Helper.displayMessageToast(LoginActivity.this, "Login fields must be filled");
                    return;
                }
                if(!Helper.isValidEmail(enteredEmail)){
                    Helper.displayMessageToast(LoginActivity.this, "Invalidate email entered");
                    return;
                }

                ((CryptoPalApplication)getApplication()).loginAUser(LoginActivity.this, enteredEmail, enteredPassword, loginError);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(((CryptoPalApplication)getApplication()).mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (((CryptoPalApplication)getApplication()).mAuthListener != null) {
            //mAuth.removeAuthStateListener(((CryptoPalApplication)getApplication()).mAuthListener);
        }
    }
}

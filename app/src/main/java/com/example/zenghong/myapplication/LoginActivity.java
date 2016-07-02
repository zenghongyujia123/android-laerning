package com.example.zenghong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.EditText;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }

    private void findViews() {
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUsername = (EditText) findViewById(R.id.etUsername);
        webView = (WebView) findViewById(R.id.webView);
        etPassword.setText("DPlily");
        etUsername.setText("DPlily2016/5/16");
    }

    public void onSubmitLoginClick(View view) {
        Log.e("MyAdnroid", "=======================");
        Log.e("MyAdnroid", "Username : " + etUsername.getText());
        Log.e("MyAdnroid", "Password : " + etPassword.getText());
        Log.e("MyAdnroid", "=======================");

        LoginModel loginModel = new LoginModel();
        loginModel.Username = etUsername.getText().toString();
        loginModel.Password = etPassword.getText().toString();

        final AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("Password", loginModel.Password);
        params.put("Username", loginModel.Username);
        final PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        client.setCookieStore(cookieStore);
        CookieSyncManager.createInstance(this);

        client.post("https://onesfa.parrowtech.com/api/NativeAccount/Login", params, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                Log.e("MyAdnroid", "=======================");
                Log.e("MyAdnroid", "onStart");
                Log.e("MyAdnroid", "=======================");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                CustomerHttpResult result = new Gson().fromJson(response.toString(), CustomerHttpResult.class);
                Log.e("MyAdnroid", "=======================");
                Log.e("MyAdnroid", "statusCode : " + String.valueOf(statusCode));
                Log.e("MyAdnroid", "responese : " + response.toString());
                Log.e("MyAdnroid", "result : " + result.toString());
                Log.e("MyAdnroid", "headers : " + headers.toString());
                Log.e("MyAdnroid", "=======================");
                gotoDpView();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String errorResponse, Throwable e) {
                Log.e("MyAdnroid", "=======================");
                Log.e("MyAdnroid", "statusCode : " + String.valueOf(statusCode));
                Log.e("MyAdnroid", "errorResponese : " + errorResponse);
                Log.e("MyAdnroid", "headers : " + headers.toString());
                Log.e("MyAdnroid", "=======================");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject errorResponse) {
                Log.e("MyAdnroid", "=======================");
                Log.e("MyAdnroid", "statusCode : " + String.valueOf(statusCode));
                Log.e("MyAdnroid", "errorResponese : " + errorResponse.toString());
                Log.e("MyAdnroid", "headers : " + headers.toString());
                Log.e("MyAdnroid", "=======================");
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });
    }

    private void gotoDpView(){
        Intent intent = new Intent(this,DPViewActivity.class);
        startActivity(intent);
    }

    public class LoginModel {
        public String Username;
        public String Password;
    }

    public class CustomerHttpResult {
        public int Status;
        public String Message;
        public boolean Data;
    }
}



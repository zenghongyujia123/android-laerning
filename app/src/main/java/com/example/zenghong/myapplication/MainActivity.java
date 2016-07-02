package com.example.zenghong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUser;
    private EditText etPassword;
    private EditText etPhone;
    private EditText etAge;
    private Button btClear;
    private Button btSubmit;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etAge = (EditText) findViewById(R.id.etAge);
        etUser = (EditText) findViewById(R.id.etUser);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);

        btClear = (Button) findViewById(R.id.btClear);
        btSubmit = (Button) findViewById(R.id.btSubmit);

        tvMessage = (TextView) findViewById(R.id.tvMessage);

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAge.setText(null);
                etUser.setText(null);
                etPhone.setText(null);
                etPassword.setText(null);
                tvMessage.setText(null);
                Toast.makeText(MainActivity.this, R.string.msg_ClearAllFields, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onSubmitClick(View view) {
        String user = etUser.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String text = "";

        text += "user name : " + user + "\n";
        text += "password : " + password + "\n";
        text += "phone number : " + phone + "\n";
        text += "user age : " + age + "\n";
        tvMessage.setText(text);
    }

    public void gotoSecondPage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void gotoThirdPage(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void gotoFourthPage(View view) {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void gotoFifthPage(View view) {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }

    public void gotoSixthPage(View view) {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

    public void gotoSeventhPage(View view) {
        Intent intent = new Intent(this, SeventhActivity.class);
        startActivity(intent);
    }

    public void gotoEighthPage(View view) {
        Intent intent = new Intent(this, EighthActivity.class);
        startActivity(intent);
    }

    public void gotoNighthPage(View view) {
        Intent intent = new Intent(this, NighthActivity.class);
        startActivity(intent);
    }

    public void gotoTenthPage(View view) {
        Intent intent = new Intent(this, TenthActivity.class);
        startActivity(intent);
    }

    public void gotoLoginPage(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

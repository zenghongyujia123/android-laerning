package com.example.zenghong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvCount;
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private int count = 0;
    private int style = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViews();
    }

    public void findViews() {
        tvCount = (TextView) findViewById(R.id.tvCount);
        scrollView = (ScrollView) findViewById(R.id.secondPageScrollView);
        linearLayout = (LinearLayout) findViewById(R.id.secondPageScrollViewLinerlayout);
        tvCount.setText(String.valueOf(count));
    }

    public void onAddClick(View view) {
        count++;
        tvCount.setText(String.valueOf(count));
        TextView textView = new TextView(this);
        textView.setText(String.valueOf(count));
        setTextViewStyle(textView);
        linearLayout.addView(textView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    public void setTextViewStyle(TextView textView) {
        if (style == 0) {
            if (Build.VERSION.SDK_INT < 23) {
                textView.setTextAppearance(this, R.style.styles_second_page_red);
            } else {
                textView.setTextAppearance(R.style.styles_second_page_red);
            }
        } else {
            if (Build.VERSION.SDK_INT < 23) {
                textView.setTextAppearance(this, R.style.styles_second_page_yellow);
            } else {
                textView.setTextAppearance(R.style.styles_second_page_yellow);
            }
        }
        style = style == 0 ? 1 : 0;
    }
}

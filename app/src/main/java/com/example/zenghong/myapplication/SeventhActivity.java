package com.example.zenghong.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class SeventhActivity extends AppCompatActivity {
    private GeometricView geometricView;
    private int offset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        findViews();
    }

    private void findViews(){
        geometricView = (GeometricView)findViewById(R.id.geometricView);
    }

    public void onOffsetClick(View view){
        if(geometricView!=null){
            offset+=10;
            geometricView.setOffset(offset);;
            geometricView.invalidate();
        }
    }
}


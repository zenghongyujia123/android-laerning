package com.example.zenghong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.PublicKey;

public class FifthActivity extends AppCompatActivity {
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        findViews();
    }

    public void findViews() {
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        Spinner sp1 = (Spinner) findViewById(R.id.id_fourth_page_array_1);
        sp1.setSelection(0, true);
        sp1.setOnItemSelectedListener(listener);

        Spinner sp2 = (Spinner) findViewById(R.id.id_fourth_page_array_2);
        String[] places = {"hhaa1", "sdaf2", "sadfafd3", "asdfasdf4"};
        ArrayAdapter<String> adapterPlace = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, places);
        adapterPlace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp2.setAdapter(adapterPlace);
        sp2.setSelection(0, true);
        sp2.setOnItemSelectedListener(listener);


    }

    Spinner.OnItemSelectedListener listener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            tvMessage.setText(parent.getItemAtPosition(pos).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            tvMessage.setText("Nothing selected");
        }
    };
}

package com.example.zenghong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        tvMessage = (TextView) findViewById(R.id.tvMessage);
        unregisterForContextMenu(tvMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message;
        switch (item.getItemId()) {
            case R.id.text_title_1_item_1:
                message = getString(R.string.text_item_title_1) + ">" + getString(R.string.text_title_1_item_1);
                break;
            case R.id.text_title_1_item_2:
                message = getString(R.string.text_item_title_1) + ">" + getString(R.string.text_title_1_item_2);
                break;
            case R.id.text_item_title_1:
                message = getString(R.string.text_item_title_1);
                break;
            case R.id.text_item_title_2:
                message = getString(R.string.text_item_title_2);
                break;
            case R.id.text_item_title_3:
                message = getString(R.string.text_item_title_3);
                break;
            case R.id.text_item_title_4:
                message = getString(R.string.text_item_title_4);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        tvMessage.setText(message);

        return true;
    }

}

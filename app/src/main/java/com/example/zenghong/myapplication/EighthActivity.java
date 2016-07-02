package com.example.zenghong.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ProviderInfo;
import android.nfc.Tag;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Toast;

public class EighthActivity extends AppCompatActivity {
    private static String TAG = "fragment";
//    private FragmentManager manager ;
//    private FragmentTransaction transaction ;
//    private Fragment fragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);
    }

//    private void findViews(){
//
//    }

    public void onAddClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentById(R.id.fragmentFirstLayout);

        if (fragment == null) {
            String title = "Fragment A";
            FirstFragment fragment1 = new FirstFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            fragment1.setArguments(bundle);
            transaction.add(R.id.fragmentFirstLayout, fragment1, TAG);
            transaction.commit();
        } else {
            showToast("fragment exists");
        }
    }

    public void onReplaceClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        String title = "Fragment B";

        FirstFragment fragment2 = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment2.setArguments(bundle);

        transaction.replace(R.id.fragmentFirstLayout, fragment2);
        transaction.commit();

    }

    public void onAttachClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = manager.findFragmentById(R.id.fragmentFirstLayout);
        if (fragment == null) {
            showToast("fragment doesno't exists");
        } else {
            if (fragment.isDetached()) {
                transaction.attach(fragment);
                transaction.commit();
            } else {
                showToast("fragement attached");
            }
        }
    }

    public void onDetachClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentById(R.id.fragmentFirstLayout);

        if (fragment == null) {
            showToast("fragment not existed");
        } else {
            if (!fragment.isDetached()) {
                transaction.detach(fragment);
            } else {
                showToast("fragment detached");
            }
        }
    }

    public void onRemoveClick(View view) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentById(R.id.fragmentFirstLayout);

        if (fragment != null) {
            transaction.remove(fragment);
            transaction.commit();
        } else {
            showToast("fragment not existed");
        }
    }

    public void onFinishClick(View view) {
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.zenghong.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class TenthActivity extends AppCompatActivity {
    private ImageView imageView;
    private File file;
    private static final int REQUEST_TAKE_PICTURE_SMALL = 0;
    private static final int REQUEST_TAKE_PICTURE_LARGE = 1;
    private static final int REQUEST_PICK_PICTURE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        imageView = (ImageView) findViewById(R.id.ivImage);
    }

    public void onTakePictureSmallClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (isIntentAvailable(this, intent)) {
            startActivityForResult(intent, REQUEST_TAKE_PICTURE_SMALL);
        } else {
            Toast.makeText(this, "没有照相机", Toast.LENGTH_SHORT).show();
        }
    }

    public void onTakePictureLargeClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        file = new File(file, "picture.jpg");

        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));

        if (isIntentAvailable(this, intent)) {
            startActivityForResult(intent, REQUEST_TAKE_PICTURE_LARGE);
        } else {
            Toast.makeText(this, "没有照相机", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPickPictureClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_PICK_PICTURE);

    }

    public boolean isIntentAvailable(Context context, Intent intent) {
        PackageManager manager = context.getPackageManager();
        List<ResolveInfo> list = manager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Bitmap picture;
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_TAKE_PICTURE_SMALL:
                    picture = (Bitmap) intent.getExtras().get("data");
                    imageView.setImageBitmap(picture);
                    break;
                case REQUEST_TAKE_PICTURE_LARGE:
                    picture = BitmapFactory.decodeFile(file.getPath());
                    imageView.setImageBitmap(picture);
                    break;
                case REQUEST_PICK_PICTURE:
                    Uri uri = intent.getData();
                    String[] columns = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(uri, columns, null, null, null);
                    if (cursor.moveToFirst()) {
                        String imagePath = cursor.getString(0);
                        cursor.close();
                        picture = BitmapFactory.decodeFile(imagePath);
                        imageView.setImageBitmap(picture);
                    }
                    break;
            }
        }
    }
}

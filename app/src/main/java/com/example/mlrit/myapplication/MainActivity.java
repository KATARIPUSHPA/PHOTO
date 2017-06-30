package com.example.mlrit.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView photo;
    Button capture;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo=(ImageView)findViewById(R.id.imageView);
        capture=(Button)findViewById(R.id.button);
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

    public void dispatchTakePictureIntent(){
        Intent takePictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

protected void onActivityResult(int requestCode,int resultCode,Intent data)
{
    if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
    {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap=(Bitmap) extras.get("data");
        photo.setImageBitmap(imageBitmap);
    }
}
}

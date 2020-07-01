package com.example.test20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int Requestcodeforcam=22;
int RequestcodStorage=11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button one=(Button)findViewById(R.id.LocBtn);
        Button two=(Button)findViewById(R.id.StorageBtn);
 // -----------     FoR ONE---------------------------------
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permission Already granted!!", Toast.LENGTH_SHORT).show();
                }else{
                    Requestcamera();
                }

            }
        });
    //--------------For TWO------------------------------------
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permission Already granted!!", Toast.LENGTH_SHORT).show();

                }else{
                    RequestStorage();
                }

            }
        });


    }
    public void Requestcamera(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this).setTitle("Permission Needed").setMessage("this permission is needed for this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

             ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},Requestcodeforcam);


                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},Requestcodeforcam);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if(requestCode==Requestcodeforcam){
           if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
               Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "Permission in not granted", Toast.LENGTH_SHORT).show();
           }


       }
    }
    public void RequestStorage(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            new AlertDialog.Builder(this).setTitle("Permission Needed").setMessage("this permission is needed for this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Requestcodeforcam);


                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        }else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Requestcodeforcam);
        }
        }



    }


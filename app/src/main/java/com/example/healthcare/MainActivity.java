package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    EditText user;
    EditText pass;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=(VideoView) findViewById(R.id.videoViewbg);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bgvideo);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        user=(EditText) findViewById(R.id.editTextuser);
        pass=(EditText) findViewById(R.id.editTextpass);
        login=(Button) findViewById(R.id.buttonlogin);
    }
    public void click(View view) {
        Intent intent = new Intent(MainActivity.this, home.class);
        startActivity(intent);
    }

//    public void click(View view){
//        if(user.equals("saayan") && pass.equals("2003")){
//            Intent intent=new Intent(MainActivity.this,home.class);
//            startActivity(intent);
//        }
//        else{
//            Toast.makeText(MainActivity.this,"Sorry!! Login failed",Toast.LENGTH_LONG).show();
//        }
//    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        videoView.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoView.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        videoView.stopPlayback();
        super.onDestroy();
    }
}
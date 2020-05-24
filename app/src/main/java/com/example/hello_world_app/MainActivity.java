package com.example.hello_world_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    VideoView myvideo;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btn_Play);
        myvideo = (VideoView) findViewById(R.id.videoPlayer);

        mediaController = new MediaController( this);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String videoPath = "android.resource://com.example.hello_world_app/" + R.raw.androidvsiphone;
                Uri uri = Uri.parse(videoPath);
                myvideo.setVideoURI(uri);
                myvideo.setMediaController(mediaController);
                mediaController.setAnchorView(myvideo);
                myvideo.start();
            }
        });
    }
}

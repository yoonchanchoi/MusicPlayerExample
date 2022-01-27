package com.example.musicplayerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_play;
    Button btn_stop;

    MediaPlayer mediaPlayer;


    //액티비티가 종료될때 실행함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);

        //재생버튼 눌렸을때
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
                mediaPlayer.start();
            }
        });



        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.reset();

                }
            }
        });



    }
}
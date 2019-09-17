package com.example.administrator.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MP4Activity extends BaseActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private VideoView videoView;

    public static void actionStart(Context context){
        Intent intent = new Intent(context, MP4Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp4);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        TitleLayout titleLayout = (TitleLayout) findViewById(R.id.myTitleLayout);
        titleLayout.setTitle("MP4");

        videoView = (VideoView) findViewById(R.id.video_view);

        Button play_music = (Button) findViewById(R.id.play_music);
        Button pause_music = (Button) findViewById(R.id.pause_music);
        Button stop_music = (Button) findViewById(R.id.stop_music);
        Button play_video = (Button) findViewById(R.id.play_video);
        Button pause_video = (Button) findViewById(R.id.pause_video);
        Button stop_video = (Button) findViewById(R.id.stop_video);

        play_music.setOnClickListener(this);
        pause_music.setOnClickListener(this);
        stop_music.setOnClickListener(this);
        play_video.setOnClickListener(this);
        pause_video.setOnClickListener(this);
        stop_video.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(MP4Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MP4Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initMediaPlayer();
            initVideoPath();
        }
    }

    private void initMediaPlayer(){
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "test/music.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(), "test/video.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.play_music:
                if (!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
                break;
            case R.id.pause_music:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                break;
            case R.id.stop_music:
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();
                }
                break;
            case R.id.play_video:
                if (!videoView.isPlaying()){
                    videoView.start();
                }
                break;
            case R.id.pause_video:
                if (videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.stop_video:
                if (videoView.isPlaying()){
                    videoView.resume();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "你拒绝了授权！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if (videoView != null){
            videoView.suspend();
        }
    }
}

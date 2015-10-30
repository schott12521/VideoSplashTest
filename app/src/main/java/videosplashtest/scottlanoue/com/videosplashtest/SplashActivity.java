package videosplashtest.scottlanoue.com.videosplashtest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class SplashActivity extends Activity implements View.OnTouchListener {

    VideoView mainVideoView;

    @Override
    protected void onPause() {
        super.onPause();
        try {
            Thread.sleep(MainActivity.timeToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();
        Log.d("HA" ," HA");
        VideoDream.showPopup = true;
        Intent intent = new Intent(SplashActivity.this, VideoDream.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("So did this happen", "?");
        mainVideoView = (VideoView) findViewById(R.id.splashVideoView);
        initVideo();
        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        mainVideoView.setOnTouchListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_video);

        Log.v("started this!", "please lord");

        mainVideoView = (VideoView) findViewById(R.id.splashVideoView);
        initVideo();

//        mainVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
////                initVideo();
//            }
//        });

        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        mainVideoView.setOnTouchListener(this);
    }

    public void initVideo() {
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mp4cut);
        mainVideoView.setVideoURI(video);
        mainVideoView.setZOrderOnTop(true);
        mainVideoView.start();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.v("We clicked", " the dream!");

        transitionVideo();

        return false;
    }

    public void transitionVideo() {

        // I don't know if this actually does anything but it should keep the UI hidden after clicking...
        // but...

        mainVideoView.stopPlayback();

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.transition);
        mainVideoView.setVideoURI(video);
        mainVideoView.setZOrderOnTop(true);
        mainVideoView.start();

        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
            }
        });

        mainVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.setLooping(false);
                mainVideoView.stopPlayback();
                VideoDream.showPopup = true;
                Intent youtubeIntent = new Intent(Intent.ACTION_MAIN);
                youtubeIntent.setComponent(ComponentName.unflattenFromString("com.google.android.youtube"));
                youtubeIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(youtubeIntent);
            }
        });

        mainVideoView.setOnTouchListener(null);

//        mainVideoView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                mainVideoView.suspend();
//                mainVideoView.stopPlayback();
//                return false;
//            }
//        });
    }


}

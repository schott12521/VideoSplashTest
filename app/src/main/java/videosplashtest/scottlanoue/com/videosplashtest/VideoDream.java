package videosplashtest.scottlanoue.com.videosplashtest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class VideoDream extends Service {

    private Timer tShow = new Timer();

    public static boolean showPopup = false;

    @Override
    public void onCreate() {
        super.onCreate();

//        Intent newIntent = new Intent(getApplicationContext(), SplashActivity.class);
//        newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(newIntent);

        if (showPopup) {
            tShow.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent newIntent = new Intent(getApplicationContext(), AlertActivity.class);
                    newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(newIntent);
                }
            }, MainActivity.timeToWait, MainActivity.timeToWait);

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "We should stop, did we?", Toast.LENGTH_SHORT).show();
    }

    //    VideoView mainVideoView;
//
//    @Override
//    public void onAttachedToWindow() {
//        setContentView(R.layout.splash_video);
//
//        Log.v("started this!", "please lord");
//
//        mainVideoView = (VideoView) findViewById(R.id.splashVideoView);
//        initVideo();
//
////        mainVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
////            @Override
////            public void onCompletion(MediaPlayer mp) {
//////                initVideo();
////            }
////        });
//
//        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
//
//        mainVideoView.setOnTouchListener(this);
//    }
//
//    public void initVideo() {
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mp4cut);
//        mainVideoView.setVideoURI(video);
//        mainVideoView.setZOrderOnTop(true);
//        mainVideoView.start();
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        Log.v("We clicked", " the dream!");
//
//        transitionVideo();
//
//        return false;
//    }
//
//    public void transitionVideo() {
//
//        // I don't know if this actually does anything but it should keep the UI hidden after clicking...
//        // but...
//
//        mainVideoView.stopPlayback();
//
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.transition);
//        mainVideoView.setVideoURI(video);
//        mainVideoView.setZOrderOnTop(true);
//        mainVideoView.start();
//
//        mainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(false);
//            }
//        });
//
//        mainVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mp.setLooping(false);
//                mainVideoView.stopPlayback();
//            }
//        });
//
//        mainVideoView.setOnTouchListener(null);
//
////        mainVideoView.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                mainVideoView.suspend();
////                mainVideoView.stopPlayback();
////                return false;
////            }
////        });
//    }
}

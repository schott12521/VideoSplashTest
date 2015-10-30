package videosplashtest.scottlanoue.com.videosplashtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    public static long timeToWait = 5 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

//        Intent intent = new Intent(this, VideoDream.class);
//        startService(intent);

        Intent newIntent = new Intent(getApplicationContext(), SplashActivity.class);
//        newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(newIntent);
    }
}

package videosplashtest.scottlanoue.com.videosplashtest;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlertActivity extends AppCompatActivity {

    private AlertDialog popUpDialog;
    private boolean defaultToSplashActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_alert);

        final AlertDialog.Builder popUpDialogBuilder = new AlertDialog.Builder(AlertActivity.this);
        popUpDialogBuilder.setTitle("Done?");
        popUpDialogBuilder.setMessage("Are you still interacting with the app? (10 sec)");
        popUpDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
                        defaultToSplashActivity = true;
                        Intent youtubeIntent = new Intent(Intent.ACTION_MAIN);
                        youtubeIntent.setComponent(ComponentName.unflattenFromString("com.google.android.youtube"));
                        youtubeIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        startActivity(youtubeIntent);
                    }
                });
        popUpDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        defaultToSplashActivity = false;
                        VideoDream.showPopup = false;
                        Intent newIntent = new Intent(getApplicationContext(), SplashActivity.class);
                        startActivity(newIntent);
                    }
                });

        popUpDialog = popUpDialogBuilder.create();
        popUpDialog.show();

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                popUpDialog.setMessage("Are you still interacting with the app? (" +
                        (millisUntilFinished/1000) + " sec)");
            }

            @Override
            public void onFinish() {
                popUpDialog.dismiss();
                VideoDream.showPopup = false;
                if (!defaultToSplashActivity) {
                    Intent newIntent = new Intent(getApplicationContext(), SplashActivity.class);
                    startActivity(newIntent);
                }
            }
        }.start();
    }
}

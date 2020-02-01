package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ChronoActivity extends AppCompatActivity {


    TextView texthours,textmin,textsec,textmil;
    Button start,resume;
    Handler handler;
    private ProgressBar progressBar;
    AnimationDrawable rocketAnimation;

    int started =0;
ImageView imageView;
    private long pausedtime,startedtime,k=0;

    private  BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        imageView=findViewById(R.id.ddd);


        progressBar=findViewById(R.id.progressBarCircle);

         resume=findViewById(R.id.resume);
        texthours=findViewById(R.id.hours);
        textmin=findViewById(R.id.minutes);
        textsec=findViewById(R.id.seconds);
        textmil=findViewById(R.id.mill);

        start=findViewById(R.id.startchro);
        handler=new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(ctx, ""+SystemClock.elapsedRealtime(), Toast.LENGTH_SHORT).show();

                if(started ==0)
                {


                 /* Intent i=new Intent(ChronoActivity.this,ChronometerService.class);
                  i.putExtra("newtime",SystemClock.elapsedRealtime());
                  startService(i);*/
                    started=1;
                    rocketAnimation = (AnimationDrawable) start.getBackground();

                    rocketAnimation.start();

                    startedtime=SystemClock.elapsedRealtime();
                    handler.postDelayed(runnable,0);
                    return;
       //             handler.postDelayed(runnable,0);
                }
                if(started==1){
                    started=2;
                    handler.removeCallbacks(runnable);
                    /*rocketAnimation.stop();
                    rocketAnimation.start();
                  */ ((AnimationDrawable)(start.getBackground())).stop();
                    start.setBackgroundDrawable(null);
                    start.setBackgroundResource(R.drawable.play);
                    return;
               }
                if(started==2)
                {
                    started=1;
                    k=s;
                    startedtime=SystemClock.elapsedRealtime();
                    handler.postDelayed(runnable,0);
                    rocketAnimation = (AnimationDrawable) start.getBackground();
                    rocketAnimation.start();
                }


            }
        });




        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                started=0;
                k=0;
                handler.removeCallbacks(runnable);

                   ((AnimationDrawable)(start.getBackground())).stop();
                start.setBackgroundDrawable(null);
                start.setBackgroundResource(R.drawable.play);

                progressBar.setProgress(0);

                textmil.setText("00");
                textsec.setText("00");
                textmin.setText("00");
                texthours.setText("00");


            }
        });

    }

    long s;
    public Runnable runnable=new Runnable() {
        @Override
        public void run() {


             s = SystemClock.elapsedRealtime() - startedtime+k;

            int seconds = (int) (s / 1000);
            int minutes = seconds / 60;
            int hours= (minutes/60)%24;
            seconds = seconds % 60;
            minutes=minutes%60;
            int milliseconds = (int) (s % 1000);

            progressBar.setProgress(1+progressBar.getProgress()%60);

            textmil.setText(String.format("%03d",milliseconds));

            textsec.setText(String.format("%02d",seconds));
            textmin.setText(String.format("%02d",minutes));
           texthours.setText(String.format("%02d",hours));
            handler.postDelayed(this, 0);

             /* textsec.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));
          */
        }
    };



  /*  public void uptext(String txt)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                texthours.setText(txt);
            }
        });
    }
*/



    @Override
    protected void onResume() {

        super.onResume();

  /*      if(broadcastReceiver!=null)
        {
            broadcastReceiver=new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    Toast.makeText(context, "w"+intent.getExtras().getString("distance"), Toast.LENGTH_SHORT).show();
                }
            };
        }registerReceiver(broadcastReceiver,new IntentFilter("Dist"));
*/

    }

    @Override
    protected void onStop() {
        super.onStop();
    }




}

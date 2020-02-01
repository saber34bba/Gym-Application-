package com.example.fitness;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.Settings;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ChronometerService extends Service {
     private LocationManager locationManager;
     private LocationListener locationListener;
     long time;
private ArrayList<Location> arrayList=new ArrayList<>(2);

    public ChronometerService() {
        super();

    }



    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "ssss", Toast.LENGTH_SHORT).show();
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
          if(location.hasAccuracy() && location.getAccuracy()<3)
          {
              Toast.makeText(ChronometerService.this, "location", Toast.LENGTH_SHORT).show();

              arrayList.add(location);

              if(arrayList.size()==2)
              {
                   float t=arrayList.get(0).distanceTo(arrayList.get(1));
                  if(!(t%1000>15))
                  {
                      //delete the large value
                      arrayList.clear();
                  }
                  else {
                      sendBroadcast(new Intent("Dist").putExtra("distance",t));
                  }
                  arrayList.clear();

              }
          }
          else {
              Toast.makeText(ChronometerService.this, ""+location.getAccuracy(), Toast.LENGTH_SHORT).show();
          }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        };

        locationManager =(LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,0,locationListener);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }



    /*@Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent i= new Intent();
        i.setAction("com.example.fitness");
        i.putExtra("chrono", ".com");
        sendBroadcast(i);
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();
        if(locationManager!=null)
        {
            locationManager.removeUpdates(locationListener);
        }


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

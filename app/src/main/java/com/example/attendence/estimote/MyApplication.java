package com.example.attendence.estimote;

import android.app.Application;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.List;
import java.util.UUID;

/**
 * Created by Wafaa Ghareeb on 3/7/2016.
 */
public class MyApplication extends Application {
    private BeaconManager beaconManager;

    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region
                        (
                                "monitored region",
                                UUID.fromString("B9407F30-E5E8-466E-AFF9-25556B57FE6D"),
                                32858, 37578 ));
            }
        });

        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener()
        {

            @Override
            public void onEnteredRegion(Region region, List<Beacon> list)
            {
                 Toast.makeText(getApplicationContext(), "Enter", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onExitedRegion(Region region)
            {
                Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
            }
        });
    }
}
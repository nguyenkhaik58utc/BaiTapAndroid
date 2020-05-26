package com.example.bigexample.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Charger Plugged In", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Toast.makeText(context, "Charger airplane", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Charger Plugged Out", Toast.LENGTH_SHORT).show();
        }
    }
}

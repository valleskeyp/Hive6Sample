package com.valleskeyp.notificationsample;

import java.util.Random;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;

public class DisplayNotification extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		PowerManager.WakeLock wakeLock = pm.newWakeLock(
		        pm.SCREEN_DIM_WAKE_LOCK, "My wakelook");
		wakeLock.acquire(5000);
		
		int ID = getIntent().getExtras().getInt("ID");
		String event = getIntent().getExtras().getString("event");
 
        Intent i = new Intent("com.valleskeyp.notificationsample.notificationDetails");
        i.putExtra("ID", ID);  
        i.putExtra("event", event);
        i.setAction(ID+"");
        
        PendingIntent detailsIntent = PendingIntent.getActivity(this, ID, i, 0);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentIntent(detailsIntent)
        		.setSmallIcon(R.drawable.ic_launcher)
        		.setAutoCancel(true)
        		.setContentText(event)
        		.setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
        		.setContentTitle("Reminder!");
        Notification n = builder.build();
        Log.i("TESTING", ID + "");
        nm.notify(ID, n);
        wakeLock.release();
        finish();
	}
}

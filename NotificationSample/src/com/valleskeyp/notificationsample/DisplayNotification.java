package com.valleskeyp.notificationsample;

import java.util.Random;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class DisplayNotification extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Random random = new Random();
		int ID = random.nextInt(10000000) + 1;
		String event = getIntent().getExtras().getString("event");
 
        Intent i = new Intent("com.valleskeyp.notificationsample.notificationDetails");
        i.putExtra("ID", ID);  
        i.putExtra("event", event);
        
        PendingIntent detailsIntent = PendingIntent.getActivity(this, ID, i, 0);
 
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentIntent(detailsIntent)
        		.setSmallIcon(R.drawable.ic_launcher)
        		.setAutoCancel(true)
        		.setContentText(event)
        		.setContentTitle("Reminder!");
        Notification n = builder.build();
       
        nm.notify(ID, n);
        //---destroy the activity---
        finish();
	}
}

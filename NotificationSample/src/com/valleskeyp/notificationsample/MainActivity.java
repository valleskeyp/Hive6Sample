package com.valleskeyp.notificationsample;

import com.valleskeyp.pickers.DatePickerFragment;
import com.valleskeyp.pickers.TimePickerFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DialogFragment;

public class MainActivity extends FragmentActivity {
	EditText eventInfo;
	TextView dateField;
	TextView timeField;
	
	Button pickDateButton;
	Button pickTimeButton;
	Button submitButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        eventInfo = (EditText)findViewById(R.id.eventInfo);
        dateField = (TextView)findViewById(R.id.dateField);
        timeField = (TextView)findViewById(R.id.timeField);
        
        pickDateButton = (Button)findViewById(R.id.selectDate);
        pickTimeButton = (Button)findViewById(R.id.selectTime);
        submitButton = (Button)findViewById(R.id.submit);
        
        pickDateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DialogFragment dateFragment = new DatePickerFragment();
        	    dateFragment.show(getFragmentManager(), "datePicker");
			}
        });

        pickTimeButton.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		DialogFragment timeFragment = new TimePickerFragment();
        		timeFragment.show(getFragmentManager(), "timePicker");
        	}
        });

        submitButton.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		if (eventInfo.length() > 0) {
					if (dateField.length() > 0) {
						if (timeField.length() > 0) {
							Toast.makeText(getApplicationContext(),
									"Submitted event", Toast.LENGTH_SHORT)
									.show();
							eventInfo.setText("");
							dateField.setText("");
							timeField.setText("");
						} else {
							Toast.makeText(getApplicationContext(), "Please select a time",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						Toast.makeText(getApplicationContext(), "Please select a date",
								Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(getApplicationContext(), "Please input event info",
							Toast.LENGTH_SHORT).show();
				}
        	}
        });
    }
    
}

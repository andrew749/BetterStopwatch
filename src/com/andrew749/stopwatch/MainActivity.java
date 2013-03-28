package com.andrew749.stopwatch;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	// state of the timer to do laps
	int timerstate;
	// clear state
	int stopstate;
	// start and stop buttons
	Button start, stop;
	// display time
	TextView tv;
	// time variables
	int millis, seconds, minutes, hours, starttime;
	// to update time
	Handler changetime;
	// list view storing laps
	ListView lv;
	// String with time values=
	String timem, times;
	// String array to hold lap times
	String[] laps;
	// vlaue to hold the spot of the array
	int spot = 0;
	// final time put together
	String finaltime;
	// array adapter for list
	SpecialAdapter a;
	// thread to update time
	Runnable r = new Runnable() {
		public void run() {
			// running time engine to calculate time
			timeengine();
			// updating time
			changetime.postDelayed(r, 1000);
			// updating string value of minutes
			if (minutes < 10) {
				timem = "0" + minutes + ":";
			} else {
				timem = minutes + ":";
			}
			// updating seconds
			if (seconds < 10) {
				times = "0" + seconds;
			} else {
				times = "" + seconds;
			}
			// setting format the time
			finaltime = timem + times;
			// display time
			tv.setText(finaltime);

		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// initialize variables
		initialize();
		// set time to 00:00
		tv.setText("00:00");
		// list adapter
		lv.setAdapter(a);
		// need to use a layout inflater to make a custom listview with position
		// # and time value
		// what happens on start button click
		start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (timerstate == 0) {
					start.setText("Lap");
					starttime = (int) System.currentTimeMillis();
					r.run();
					timerstate = 1;
				}
				// laps logic
				else if (timerstate == 1) {
					laps[spot]=finaltime;
					lv.setAdapter(a);
					++spot;
				}
			}
		});
		// what happens when stop is clicked
		stop.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if (stopstate == 0 && timerstate == 1) {
					changetime.removeCallbacks(r);
					stopstate = 1;
					stop.setText("Reset");
				} else if (stopstate == 1) {
					tv.setText("00:00");
					timerstate = 0;
					lv.postInvalidate();
					stop.setText("Stop");
					start.setText("Start");
					stopstate = 0;
				}
			}
		});
	}

	public void timeengine() {
		// mathematical operations to calculate time
		millis = (int) System.currentTimeMillis() - starttime;
		seconds = millis / 1000;
		minutes = seconds / 60;
		seconds = seconds % 60;
	}

	public void initialize() {
		// initialize variables
		start = (Button) findViewById(R.id.button1);
		stop = (Button) findViewById(R.id.button2);
		changetime = new Handler();
		timerstate = 0;
		stopstate = 0;
		laps = new String[100];
		a = new SpecialAdapter(getApplicationContext(),laps);
		tv = (TextView) findViewById(R.id.textView1);
		lv = (ListView) findViewById(R.id.listView1);
	}

	@Override
	protected void onPause() {
		super.onPause();
		//still keeping time while the app is paused
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();
	}
	

}

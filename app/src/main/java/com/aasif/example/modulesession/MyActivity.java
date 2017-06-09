package com.aasif.example.modulesession;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;

import com.aasif.database.MyDatabaseAdapter;
import com.aasif.utility.MyPreference;
import com.aasif.utility.Utitlity;

public class MyActivity extends Activity{
	
	Calendar calStart, calEnd;
	int sessionNo;
	
	@Override
	protected void onStop() {
		super.onStop();
		//Utitlity.activityTracer(this, ""+Utitlity.modulePlayed, 1);
		
		finish();
	}
	@Override
	protected void onResume() {

		super.onResume();
		Utitlity.modulePlayed++;
		Utitlity.activityTracer(this, ""+Utitlity.modulePlayed, 1);
		
	}
	
	@SuppressLint("SimpleDateFormat")
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
		calStart = Utitlity.getCurrentTime();
		String str = MyPreference.getStringValue(this, "ActivityStatus", "StartTime");
		String []st = str.split(":");
		calStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(st[0]));
		calStart.set(Calendar.MINUTE, Integer.parseInt(st[1]));
		Date givenDate1 = calStart.getTime();
		
		
		
		calEnd = Utitlity.getCurrentTime();
		SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");
		Date date = calEnd.getTime();
		String time = forTime.format(date);
		
		
		MyPreference.saveStringInPreference(this, "ActivityStatus", "EndTime", time);	
		long end = calEnd.getTimeInMillis();
		long strt = calStart.getTimeInMillis();
		 
		System.out.println(end+"  ------  "+strt);
		
		int sessionDuration  = (int) ((calEnd.getTimeInMillis() - calStart.getTimeInMillis())/(60 * 1000));
		MyPreference.saveIntInPreference(this, "ActivityStatus", "SessionDuration", sessionDuration);
		saveAllData();
		clearPreference();

	}

	private void clearPreference() {
		
		String keys[] = {"SessionDuration", "StartTime", "Activity 1", "Activity 2", "Activity 3", "Activity 4", "EndTime", };
		MyPreference.removeKeys(this, "ActivityStatus", keys);
	}
	private void saveAllData() {
		
		ContentValues values = new ContentValues();
		
		values.put(MyDatabaseAdapter.KEY_CONTENT_1,   MyPreference.getStringValue(this, "ActivityStatus", "Date"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_2, ""+MyPreference.getIntValue(this, "ActivityStatus", "SessionNo"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_3, "<6");
		values.put(MyDatabaseAdapter.KEY_CONTENT_4, MyPreference.getStringValue(this, "ActivityStatus", "StartTime")+" - "+MyPreference.getStringValue(this, "ActivityStatus", "EndTime"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_5, ""+MyPreference.getIntValue(this, "ActivityStatus", "SessionDuration")+" mins");
		values.put(MyDatabaseAdapter.KEY_CONTENT_6, ""+Utitlity.modulePlayed);

		values.put(MyDatabaseAdapter.KEY_CONTENT_7, ""+MyPreference.getIntValue(this, "ActivityStatus", "Activity 1"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_8, ""+MyPreference.getIntValue(this, "ActivityStatus", "Activity 2"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_9, ""+MyPreference.getIntValue(this, "ActivityStatus", "Activity 3"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_10, ""+MyPreference.getIntValue(this, "ActivityStatus", "Activity 4"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_11, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_12, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_13, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_14, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_15, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_16, "1");
		values.put(MyDatabaseAdapter.KEY_CONTENT_17, ""+MyPreference.getIntValue(this, "ActivityStatus", "Activity 7"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_18, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_19, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_20, "0");
		values.put(MyDatabaseAdapter.KEY_CONTENT_21, "0");
				
		MyDatabaseAdapter adapter = new MyDatabaseAdapter(this);
		adapter.openToWrite();
		adapter.insertData(MyDatabaseAdapter.DATABASE_TABLE_1, values);		
		adapter.close();		
		
	}

}

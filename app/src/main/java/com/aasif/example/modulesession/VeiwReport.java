package com.aasif.example.modulesession;




import java.io.IOException;
import java.text.DecimalFormat;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.aasif.database.MyDatabaseAdapter;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.exportDBToCSV;

public class VeiwReport extends Activity{
	
	int duration;
	String dateLast;
	String dateFirst;
	
	TextView fromto,sessions,avgDuration;
	
	public void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asif);
        
        fromto = (TextView) findViewById(R.id.fromto_txt);
        sessions = (TextView) findViewById(R.id.no_sessions_txt);
        avgDuration = (TextView) findViewById(R.id.avg_duration_txt);
        
        showData();

	}
	
	private void showData() {
		int total = getDataFromDB();
		
		fromto.setText(dateFirst+"  "+dateLast);
		sessions.setText(""+total);
		
		 DecimalFormat df2 = new DecimalFormat("###.##");
		 
		 double d = (double)this.duration/total;
		 
	     Double.valueOf(df2.format(d));
	        
		avgDuration.setText(""+Double.valueOf(df2.format(d))+ " minutes");
		
	}

	private int getDataFromDB() {
		
		String duration;
		
		
		MyDatabaseAdapter adapter = new MyDatabaseAdapter(this);		
		adapter.openToRead();
		
		Cursor cursor = adapter.selectData(MyDatabaseAdapter.DATABASE_TABLE_1, null, null, null);
		int total = cursor.getCount();
		
		if(cursor != null){
			
			if(cursor.moveToFirst()){
				
				for (int i = 0; i < total; i++) {
					
					if( i == 0 ){
						
						dateFirst = cursor.getString((cursor.getColumnIndex("Date")));
						//session = cursor.getString((cursor.getColumnIndex("Session_no")));
						duration = cursor.getString((cursor.getColumnIndex("Session_duration")));
						addRecords( duration);
						
					}
					else if(i == total-1){
						dateLast = cursor.getString((cursor.getColumnIndex("Date")));
						duration = cursor.getString((cursor.getColumnIndex("Session_duration")));
						addRecords( duration);
					}
					else{												
						//session = cursor.getString((cursor.getColumnIndex("Session_no")));
						duration = cursor.getString((cursor.getColumnIndex("Session_duration")));
						addRecords( duration);
					}
					
					
									
					cursor.moveToNext();
				}					
			}
			cursor.close();
		}		
		adapter.close();
		
		return total;
	
	}
	
	private void addRecords(String duration) {
		
		this.duration = 	this.duration + Integer.parseInt(duration.substring(0, duration.indexOf(' ')));
		
	}
	
	
	public void csv(View view){
		
    	try {
			   new exportDBToCSV().dbToCsv(VeiwReport.this);
		} catch (IOException e) {
			
		Toast.makeText(VeiwReport.this, "Sorry Could not create CSV file !", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
    	
    	Toast.makeText(VeiwReport.this,"CSV file is saved in : \n"+Environment.getExternalStorageDirectory()+"/PetPuja Folder", Toast.LENGTH_LONG).show();
	}

}

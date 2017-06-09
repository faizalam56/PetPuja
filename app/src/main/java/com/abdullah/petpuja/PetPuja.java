package com.abdullah.petpuja;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aasif.database.MyDatabaseAdapter;
import com.aasif.utility.MyPreference;
import com.aasif.utility.Utitlity;
import com.abdullah.activities.DOB;
import com.abdullah.activities.Game1;
import com.abdullah.activities.Game2;
import com.abdullah.activities.Game3;
import com.abdullah.activities.Game4;
import com.abdullah.activities.Module2Link1;
import com.abdullah.activities.StoryPart_1;
import com.abdullah.activities.StoryPart_2;
import com.abdullah.activities.StoryPart_3;
import com.abdullah.activities.StoryPart_4;
import com.abdullah.activities.StoryPart_5;
import com.abdullah.activities.StoryPart_6;
import com.abdullah.activities.StoryPart_7;
import com.abdullah.canvas.Module2Link1Canvas;
import com.zmq.utility.GlobalVariables;

public class PetPuja extends Activity{
ImageView imageViewChild,imageViewYes,imageViewNo;
TextView myTextView;
Button yesBtn,noBtn;
int index=0;
Thread thread;
int stopTimeOnScreen=0;
Intent replayIntent;
int replayIndex;
int LinkToGo=0;
////////////// TRACKER //////////////////////////
Calendar calStart, calEnd;
int sessionNo;
protected PowerManager.WakeLock mWakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        printSecreenInfo();
        setContentView(R.layout.start);
        new Constant(PetPuja.this);
        
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "Pet Puja");
        this.mWakeLock.acquire();
        
        Intent intent =new Intent();

    	intent.setClass(PetPuja.this,DOB.class);
    	startActivityForResult(intent,0);
        replayIntent=intent;
        replayIndex=0;

    	Utitlity.activityTracer(this,"PP CALC", 1);

    	Constant.HEADER=1;
    	
//    	intent.setClass(PetPuja.this,StoryPart_1.class);
//    	startActivityForResult(intent,1);
//        replayIntent=intent;
//        replayIndex=1;
    	
//    	intent.setClass(PetPuja.this,StoryPart_2.class);
//    	startActivityForResult(intent,30);
//        replayIntent=intent;
//        replayIndex=30;

//    	intent.setClass(PetPuja.this,Game1.class);
//    	startActivityForResult(intent,3);
//        replayIntent=intent;
//        replayIndex=3;

//    	intent.setClass(PetPuja.this,StoryPart_3.class);
//    	startActivityForResult(intent,4);
//        replayIntent=intent;
//        replayIndex=4;
        
//    	intent.setClass(PetPuja.this,StoryPart_4.class);
//    	startActivityForResult(intent,6);
//        replayIntent=intent;
//        replayIndex=6;
        
//      intent.setClass(PetPuja.this,Game2.class);
//    	startActivityForResult(intent,5);
        
//    	intent.setClass(PetPuja.this,StoryPart_5.class);
//    	startActivityForResult(intent,8);
//        replayIntent=intent;
//        replayIndex=8;
        
//      intent.setClass(PetPuja.this,Game3.class);
//    	startActivityForResult(intent,7);
//        replayIntent=intent;
//        replayIndex=7;
    	
//    	intent.setClass(PetPuja.this,StoryPart_6.class);
//    	startActivityForResult(intent,10);
//      replayIntent=intent;
//      replayIndex=10;
        
//      intent.setClass(PetPuja.this,Game4.class);
//    	startActivityForResult(intent,11);
//      replayIntent=intent;
//      replayIndex=11;
        
//        intent.setClass(PetPuja.this,StoryPart_7.class);
//    	  startActivityForResult(intent,12);
//        replayIntent=intent;
//        replayIndex=12;


//      intent.setClass(PetPuja.this,Module2Link1.class);
//    	startActivityForResult(intent,8);
//        replayIntent=intent;
//        replayIndex=8;

    	///////////////////  tRACKER ////////////////////////////////
    	SimpleDateFormat forDate = new SimpleDateFormat("dd-MMM-yy");
		SimpleDateFormat forTime = new SimpleDateFormat("HH:mm");
		calStart = Utitlity.getCurrentTime();
		Date date = calStart.getTime();
		String formatedDate = forDate.format(date);	
		
		SimpleDateFormat forDate1 = new SimpleDateFormat("dd-MM-yyyy");//88
		Date date1 = calStart.getTime();//88
		String formatedDate1 = forDate1.format(date1);	//88

		String dateInPreference = MyPreference.getStringValue(this, "ActivityStatus", "Date");
		
		if(dateInPreference != null){
						
			if(formatedDate.equals(dateInPreference)){
				int counter = MyPreference.getIntValue(this, "ActivityStatus", "SessionNo");
				counter++;
				MyPreference.saveIntInPreference(this, "ActivityStatus","SessionNo", counter);
			}else{
				MyPreference.saveIntInPreference(this, "ActivityStatus","SessionNo", 1);				
			}
		}else{			
			MyPreference.saveIntInPreference(this, "ActivityStatus","SessionNo", 0);
		}	
		String time = forTime.format(date);
		System.out.println("DATE "+formatedDate);
		MyPreference.saveStringInPreference(this, "ActivityStatus", "StartTime", time);	
		MyPreference.saveStringInPreference(this, "ActivityStatus", "Date", formatedDate);
		MyPreference.saveStringInPreference(this, "ActivityStatus", "Date1", formatedDate1);	//88
		MyPreference.saveStringInPreference(this, "ActivityStatus", "password", "bbc@1234");
	}

	@Override
		protected void onResume() {
		super.onResume();
		}
	
	@Override
		protected void onStop() {
			super.onStop();
		}

	@Override
		protected void onDestroy() {
				
		 this.mWakeLock.release();
		 Constant.APPLICATION=0;
			
			calStart = Utitlity.getCurrentTime();
			String str = MyPreference.getStringValue(this, "ActivityStatus", "StartTime");
			String []st = str.split(":");
			
			String strDate = MyPreference.getStringValue(this, "ActivityStatus", "Date1");//88
			String []stDate = strDate.split("-");
			
			calStart.set(Calendar.DAY_OF_MONTH, Integer.parseInt(stDate[0]));//88
			calStart.set(Calendar.MONTH, (Integer.parseInt(stDate[1])-1));//88
			calStart.set(Calendar.YEAR, Integer.parseInt(stDate[2]));//88
			calStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(st[0]));
			calStart.set(Calendar.MINUTE, Integer.parseInt(st[1]));
			
//			calStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(st[0]));
//			calStart.set(Calendar.MINUTE, Integer.parseInt(st[1]));
//			Date givenDate1 = calStart.getTime();
			
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
			MyPreference.saveIntInPreference(this, "ActivityStatus", "playedModule", playedModule());
			
			
			saveAllData();
			clearPreference();

			super.onDestroy();
		}


	private void replayModule(String key) {
		
		int value = MyPreference.getIntValue(this, "ActivityStatus", key);
		value++;
		System.out.println("REPLAY VALUE Counter"+value);
		 MyPreference.saveIntInPreference(this, "ActivityStatus", key, value);
	}
	
	private void clearPreference() {
		
		String keys[] = {
				
				"Child specs",
				"StartTime",
				"EndTime",
				"SessionDuration",				
				"playedModule",
				"PP CALC",
				"DR A LINK 1",
				"ADD REPLAY 1",
				"DR A LINK 2",
				"GAME 1",
				"DR A LINK 3",
				"GAME 2",
				"DR A LINK 4",
				"GAME 3",
				"DR A LINK 5",
				"ADD REPLAY 2",
				"DR A LINK 6",
				"GAME 4",
				"DR A LINK 7",
				"VIDEO DIARY 1",
				"VIDEO DIARY 2",
				"VIDEO DIARY 3",
				
				"Date1"
				
				};
		MyPreference.removeKeys(this, "ActivityStatus", keys);
	}


	private int  playedModule() {
		
		int total = MyPreference.getIntValue(this, "ActivityStatus", "PP CALC")+
					MyPreference.getIntValue(this, "ActivityStatus", "GAME 1")+
					MyPreference.getIntValue(this, "ActivityStatus", "GAME 2")+
					MyPreference.getIntValue(this, "ActivityStatus", "GAME 3")+
					MyPreference.getIntValue(this, "ActivityStatus", "GAME 4")+
					MyPreference.getIntValue(this, "ActivityStatus", "ADD REPLAY 1")+
					MyPreference.getIntValue(this, "ActivityStatus", "ADD REPLAY 2")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 1")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 2")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 3")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 4")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 5")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 6")+
					MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 7")+
					MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 1")+
					MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 2")+
					MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 3");
		
		return total;
				 
	}


	@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			
			if (resultCode==RESULT_OK) {   // 6 months or above
				
				MyPreference.saveStringInPreference(this, "ActivityStatus", "Child specs", "<6");
				Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_1.class);
		    	startActivityForResult(intent,1);
		    	Utitlity.activityTracer(this,"DR A LINK 1", 1);
                LinkToGo=1;
		    	replayIntent=intent;
		    	replayIndex=1;
			}
			else if(resultCode==RESULT_CANCELED){  // less than 6 months
//				Utitlity.activityTracer(this,"PP CALC", 1);
				MyPreference.saveStringInPreference(this, "ActivityStatus", "Child specs", ">6");
				Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Module2Link1.class);
		    	startActivityForResult(intent,100);
                LinkToGo=1;
                replayIntent=intent;
                replayIndex=100;
		    	Utitlity.activityTracer(this,"DR A LINK 1", 1);
		    	
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}
		   else{
			   closeDialogBox();
			}
			break;
		case 1:
			if (resultCode==RESULT_OK) {
				Utitlity.activityTracer(this,"ADD REPLAY 1", 1);
				Intent intent=new Intent();
				intent.setClass(PetPuja.this,VideoPlayNew.class);
				intent.putExtra("VIDEOPATH","android.resource://"+getPackageName()+"/"+R.raw.video1);
				intent.putExtra("SWITCHINDEX",0);
				startActivityForResult(intent,2);
				replayIntent=intent;
		    	replayIndex=2;
				
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			} else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 1");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_1.class);
		    	startActivityForResult(intent,1);
		     }else
		  	{
		    	 closeDialogBox();
			}
			break;
		case 2:
			if (resultCode==RESULT_OK) {
				
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_2.class);
		    	startActivityForResult(intent,30);
		    	replayIntent=intent;
		    	replayIndex=30;
		    	Utitlity.activityTracer(this,"DR A LINK 2",1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else{
				 closeDialogBox();
			}
			break;
		case 30:
			if (resultCode==RESULT_OK) {
				
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,Game1.class);
		    	startActivityForResult(intent,3);
		    	replayIntent=intent;
		    	replayIndex=3;
		    	Utitlity.activityTracer(this,"GAME 1",1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 2");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_2.class);
		    	startActivityForResult(intent,30);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 3:
			if (resultCode==RESULT_OK) {
				
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_3.class);
		    	startActivityForResult(intent,4);
		    	replayIntent=intent;
		    	replayIndex=4;
		    	Utitlity.activityTracer(this,"DR A LINK 3", 1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("GAME 1");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Game1.class);
		    	startActivityForResult(intent,3);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 4:
			if (resultCode==RESULT_OK) {
				
				Intent intent =new Intent();
//		    	intent.setClass(PetPuja.this,StoryPart_3.class);
		    	intent.setClass(PetPuja.this,Game2.class);
		    	startActivityForResult(intent,5);
		    	replayIntent=intent;
		    	replayIndex=5;
		    	Utitlity.activityTracer(this,"GAME 2",1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 3");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_3.class);
		    	startActivityForResult(intent,4);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 5:
			if(resultCode==RESULT_OK) {
				
				Intent intent =new Intent();
				intent.setClass(PetPuja.this,StoryPart_4.class);
		    	startActivityForResult(intent,6);
		    	replayIntent=intent;
		    	replayIndex=6;
		    	Utitlity.activityTracer(this,"DR A LINK 4", 1);
				
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("GAME 2");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Game2.class);
		    	startActivityForResult(intent,5);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 6:
			if (resultCode==RESULT_OK) {
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,Game3.class);
		    	startActivityForResult(intent,7);
		    	replayIntent=intent;
		    	replayIndex=7;
		    	Utitlity.activityTracer(this,"GAME 3",1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 4");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_4.class);
		    	startActivityForResult(intent,6);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 7:
			if (resultCode==RESULT_OK) {
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_5.class);
		    	startActivityForResult(intent,8);
		    	replayIntent=intent;
		    	replayIndex=8;
		    	Utitlity.activityTracer(this,"DR A LINK 5", 1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("GAME 3");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Game3.class);
		    	startActivityForResult(intent,7);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 8:
			if (resultCode==RESULT_OK){
				Utitlity.activityTracer(this,"ADD REPLAY 2", 1);
				Intent intent=new Intent();
//				intent.setClass(PetPuja.this,VedioPlay.class);
				intent.setClass(PetPuja.this,VideoPlayNew.class);
				intent.putExtra("VIDEOPATH","android.resource://"+getPackageName()+"/"+R.raw.video1);
				intent.putExtra("SWITCHINDEX",1);
				startActivityForResult(intent,9);
				replayIntent=intent;
		    	replayIndex=9;

			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 5");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_5.class);
		    	startActivityForResult(intent,8);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 9:
			if (resultCode==RESULT_OK){
				
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_6.class);
		    	startActivityForResult(intent,10);
		    	replayIntent=intent;
		    	replayIndex=10;
		    	Utitlity.activityTracer(this,"DR A LINK 6", 1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else{
				 closeDialogBox();
			}
			break;
		case 10:
			if (resultCode==RESULT_OK){
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,Game4.class);
		    	startActivityForResult(intent,11);
		    	replayIntent=intent;
		    	replayIndex=11;
		    	Utitlity.activityTracer(this,"GAME 4",1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 6");
//				(get story six valu add 1)
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_6.class);
		    	startActivityForResult(intent,10);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 11:
			if (resultCode==RESULT_OK) {
				Intent intent =new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_7.class);
		    	startActivityForResult(intent,12);
		    	replayIntent=intent;
		    	replayIndex=12;
		    	Utitlity.activityTracer(this,"DR A LINK 7", 1);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("GAME 4");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Game4.class);
		    	startActivityForResult(intent,11);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 12:
			if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 7");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,StoryPart_7.class);
		    	startActivityForResult(intent,12);
                replayIntent=intent;
                replayIndex=12;
		     }
			else closeDialogBox();
			break;
		case 100: //last scene
			if (resultCode==RESULT_OK) {
				Utitlity.activityTracer(this,"ADD REPLAY 1", 1);
				Intent intent=new Intent();
				intent.setClass(PetPuja.this,VideoPlayNew.class);
				intent.putExtra("VIDEOPATH","android.resource://"+getPackageName()+"/"+R.raw.video1);
				intent.putExtra("SWITCHINDEX",1);
				startActivityForResult(intent,2);
			}else if(resultCode==Constant.CLOSE_WITH_MESSAGE){
				finish();
			}else if(resultCode==Constant.REPLAY){
				replayModule("DR A LINK 1");
		    	Intent intent=new Intent();
		    	intent.setClass(PetPuja.this,Module2Link1.class);
		    	startActivityForResult(intent,100);
		     }else{
		    	 closeDialogBox();
			}
			break;
		case 101:
			if (resultCode==RESULT_OK) {
				finish();
			}
			break;
		default:
			break;
		}
	}
	
	public void aleartForCloseApplication(){
	}
	
	


	private void saveAllData() {
		
		ContentValues values = new ContentValues();
		
		values.put(MyDatabaseAdapter.KEY_CONTENT_1, MyPreference.getStringValue(this, "ActivityStatus", "Date"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_2, ""+MyPreference.getIntValue(this, "ActivityStatus", "SessionNo"));
		
		if(MyPreference.getStringValue(this, "ActivityStatus", "Child specs").equals("DEFAULT")){
			
			values.put(MyDatabaseAdapter.KEY_CONTENT_3, "Not Played");
			
		}else{
			values.put(MyDatabaseAdapter.KEY_CONTENT_3, MyPreference.getStringValue(this, "ActivityStatus", "Child specs"));
		}
		
		
		values.put(MyDatabaseAdapter.KEY_CONTENT_4, MyPreference.getStringValue(this, "ActivityStatus", "StartTime")+" - "+MyPreference.getStringValue(this, "ActivityStatus", "EndTime"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_5, ""+MyPreference.getIntValue(this, "ActivityStatus", "SessionDuration")+" mins");
		values.put(MyDatabaseAdapter.KEY_CONTENT_6, ""+MyPreference.getIntValue(this, "ActivityStatus", "playedModule"));

		values.put(MyDatabaseAdapter.KEY_CONTENT_7, ""+MyPreference.getIntValue(this, "ActivityStatus", "PP CALC"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_8, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 1"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_9, ""+MyPreference.getIntValue(this, "ActivityStatus", "ADD REPLAY 1"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_10, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 2"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_11, ""+MyPreference.getIntValue(this, "ActivityStatus", "GAME 1"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_12, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 3"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_13, ""+MyPreference.getIntValue(this, "ActivityStatus", "GAME 2"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_14, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 4"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_15, ""+MyPreference.getIntValue(this, "ActivityStatus", "GAME 3"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_16, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 5"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_17, ""+MyPreference.getIntValue(this, "ActivityStatus", "ADD REPLAY 2"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_18, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 6"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_19, ""+MyPreference.getIntValue(this, "ActivityStatus", "GAME 4"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_20, ""+MyPreference.getIntValue(this, "ActivityStatus", "DR A LINK 7"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_21, ""+MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 1"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_22, ""+MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 2"));
		values.put(MyDatabaseAdapter.KEY_CONTENT_23, ""+MyPreference.getIntValue(this, "ActivityStatus", "VIDEO DIARY 3"));
				
		MyDatabaseAdapter adapter = new MyDatabaseAdapter(this);
		adapter.openToWrite();
		adapter.insertData(MyDatabaseAdapter.DATABASE_TABLE_1, values);		
		adapter.close();
		
		
	}
    void printSecreenInfo(){

        Display display = getWindowManager().getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        Log.i("", "density :" + metrics.density);
        float a=metrics.densityDpi;
//        GlobalVariables.xScale_factor=1;
        GlobalVariables.xScale_factor=(float) (metrics.widthPixels/1280.0);
//        if(metrics.heightPixels==320.0){
//        	GlobalVariables.yScale_factor=1;
//        }else
//        GlobalVariables.yScale_factor=1;
        GlobalVariables.yScale_factor=(float) (metrics.heightPixels/800.0);
        // density interms of dpi
        Log.i("", "D density :" +  metrics.densityDpi);

        // horizontal pixel resolution
        Log.i("", "width pix :" +  metrics.widthPixels);
        GlobalVariables.width=metrics.widthPixels;
        // vertical pixel resolution
        Log.i("", "height pix :" +  metrics.heightPixels);
        GlobalVariables.height=metrics.heightPixels;
        // actual horizontal dpi
        Log.i("", "xdpi :" +  metrics.xdpi);

        // actual vertical dpi
        Log.i("", "ydpi :" + metrics.ydpi);

    }

    public void closeDialogBox(){
        AlertDialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        dialog = builder.create();
        dialog.setCancelable(false);

//  		ImageView imageView = new ImageView(this);
//  		imageView.setBackgroundResource(R.drawable.dates_bg);
//  		dialog.setView(imageView);

        dialog.setButton2("नही", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                startActivityForResult(replayIntent, replayIndex);
            }
        });

        dialog.setButton3("हाँ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        //**************************************************************************************
        LinearLayout layout = new LinearLayout(this);
        //layout.setLayoutParams(params);
        Bitmap set_cancel_bgTemp=Constant.decodeSampledBitmapFromResource(this.getResources(), R.drawable.set_cancel_bg);
        Drawable set_cancel_bg =new BitmapDrawable(this.getResources(), set_cancel_bgTemp);

        layout.setBackground(set_cancel_bg);
//  		layout.setBackgroundResource(R.drawable.set_cancel_bg);
        layout.setGravity(Gravity.CENTER_VERTICAL);

        Bitmap small_iconTemp=Constant.decodeSampledBitmapFromResource(this.getResources(), R.drawable.small_icon);
        Drawable small_icon =new BitmapDrawable(this.getResources(), small_iconTemp);

        ImageView imageView = new ImageView(this);
        imageView.setBackground(small_icon);
//  		imageView.setBackgroundResource(R.drawable.small_icon);

        TextView textView = new TextView(this);
        textView.setText(R.string.closeAppHeading);
        textView.setTextSize(30);
        //textView.setGravity(Gravity.CENTER_VERTICAL);
        layout.setPadding(10, 10, 10, 10);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(20, 10, 10, 10);
        layout.addView(imageView);
        layout.addView(textView);

        dialog.setCustomTitle(layout);
        dialog.setIcon(R.drawable.small_icon);
        //***********************************************************************************************
        LinearLayout layout1 = new LinearLayout(this);

        Bitmap exit_bg_nwTemp=Constant.decodeSampledBitmapFromResource(this.getResources(), R.drawable.exit_bg_nw);
        Drawable exit_bg_nw =new BitmapDrawable(this.getResources(), exit_bg_nwTemp);

        layout1.setBackground(exit_bg_nw);
//  		layout1.setBackgroundResource(R.drawable.exit_bg_nw);
        TextView textView1 = new TextView(this);
        textView1.setText(R.string.closeAppString);
        textView1.setTextSize(30);
        textView1.setTextColor(Color.WHITE);
//        textView1.setPadding(10, 15, 5, 5);
        layout1.setGravity(Gravity.CENTER);

        layout1.addView(textView1);
        dialog.setView(layout1);

        dialog.show();

        //**************************************************************
        Bitmap set_cancel_bg_nwTemp=Constant.decodeSampledBitmapFromResource(this.getResources(), R.drawable.set_cancel_bg_nw);
        Drawable set_cancel_bg_nw =new BitmapDrawable(this.getResources(), set_cancel_bg_nwTemp);

        Button b = dialog.getButton(AlertDialog.BUTTON2);
        b.setBackground(set_cancel_bg_nw);
//  		b.setBackground(this.getResources().getDrawable(
//  				R.drawable.set_cancel_bg_nw));
        b.setTextSize(30);
        b.setTextColor(Color.WHITE);

        Button b1 = dialog.getButton(AlertDialog.BUTTON3);
        b1.setBackground(set_cancel_bg_nw);
//  		b1.setBackground(this.getResources().getDrawable(
//  				R.drawable.set_cancel_bg_nw));
        b1.setTextSize(30);
        b1.setTextColor(Color.WHITE);

        int dividerId = this.getResources().getIdentifier(
                "android:id/titleDivider", null, null);
        View divider = dialog.findViewById(dividerId);
        divider.setBackgroundResource(R.drawable.divider);
    }
}

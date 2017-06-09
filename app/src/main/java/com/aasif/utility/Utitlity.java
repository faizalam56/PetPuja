package com.aasif.utility;

import java.util.Calendar;
import java.util.HashMap;

import android.content.Context;

public class Utitlity {
	
	public static Calendar start;
	public static Calendar end;
	public static int modulePlayed;
	public static HashMap<String,String> sessionMap = new HashMap<String,String>();
	
	
	
	public static void activityTracer(Context context, String actvityNo, int status) {
		
		MyPreference.saveIntInPreference(context, "ActivityStatus", actvityNo, status);		

	}
	
	public static void setStringData(Context context, String key, String value) {
		
		MyPreference.saveStringInPreference(context, "ActivityStatus", key, value);		

	}

	public static  Calendar  getCurrentTime() {
		
		Calendar c = Calendar.getInstance(); 	
		return c;		
	}
	
	public static void removeKeys(String keys[]) {
		
		for (String string : keys) {
			
		}
		
	}
	
	
	
	
}

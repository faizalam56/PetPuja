package com.aasif.utility;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.Preference;

public class MyPreference {
	
	String fileName;
	static SharedPreferences mPreferences;		
	
	public static void saveStringInPreference(Context context, String fileName, String key, String value) {
		mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);		
		Editor editor = mPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public static String getStringValue(Context context, String fileName, String key){
		
		mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);		
		String value = mPreferences.getString(key, "DEFAULT");
		return value;
		
	}
	
	public static void saveIntInPreference(Context context, String fileName, String key, int value) {
		mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);		
		Editor editor = mPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	public static int getIntValue(Context context, String fileName, String key){
		
		mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);		
		int value = mPreferences.getInt(key, 0);
		return value;
		
	}
	
	public static void removeKeys(Context context, String fileName, String keys[]) {
		
		mPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);		
		Editor editor = mPreferences.edit();		
		for (String string : keys) {
	
			if(mPreferences.contains(string)){
			editor.remove(string);
			System.out.println("remove key preference "+ string);
			}
		}
		editor.commit();
		
		Map m = mPreferences.getAll();
		
		Set st=m.entrySet();
		Iterator itr=st.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry entry=(Map.Entry)itr.next();
			System.out.println("REMAIN KEY ----  "+entry.getKey()+"	"+entry.getValue());
		}
		
	}
	
	
}

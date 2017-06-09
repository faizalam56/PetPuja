package com.aasif.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDatabaseAdapter {

	public static String DATABASE_NAME 		= 	"PetPuja";
	public static int DATABASE_VERSION 		= 	1;
	
	MyHelper myHelper;
	SQLiteDatabase sqLiteDatabase;
	Context context;
	
	public MyDatabaseAdapter(Context c) {
		context = c;
	}
	
	public MyDatabaseAdapter openToRead() {
		
		myHelper = new MyHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqLiteDatabase = myHelper.getReadableDatabase();	
		return this;	
	}
	public MyDatabaseAdapter openToWrite() {
		myHelper = new MyHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqLiteDatabase = myHelper.getWritableDatabase();
		return this;		
	}
	
	public void close() {
		
		if(myHelper != null){
			myHelper.close();
		}
	}
	

	
//////////////////////COMMAN_FUNCTION//////////////////////////////
	
	public long insertData(String tableName, ContentValues contentValues) {
		// TODO Auto-generated method stub
		long index = sqLiteDatabase.insert(tableName, null, contentValues);
		return index;
	}
	
	public Cursor selectData(String tableName, String[] columns, String whereClause, String[] matchValue){
		
		Cursor c = sqLiteDatabase.query(tableName, columns, whereClause, matchValue, null, null, null);
		return c;
		
	}
	
	public int deleteData(String tableName, String whereClouse){
		int rowAffected = sqLiteDatabase.delete(tableName, whereClouse, null);		
		System.out.println("All rows Deleted Successfully");
		return rowAffected;		
	}
	
	public int updateData(String tableName, String whereClause, ContentValues values, String[] strings){
		int rowAffected = sqLiteDatabase.update(tableName, values, whereClause, strings);//(tableName, whereClouse, null);		
		System.out.println("All rows Updated Successfully");
		return rowAffected;		
	}
	
	public Cursor selectSpecificData(String tableName, String[] columns, String whereClause){
		
		Cursor c = sqLiteDatabase.query(tableName, columns, null, null, null, null, null);
		return c;
		
	}
	
	//////////////////// TABLE => PATIENT_REPORT ///////////////////////////
		
	public static final String DATABASE_TABLE_1 = "PetPuja_Report";
	public static final String KEY_ID = "_id";
	public static final String KEY_CONTENT_1 = "Date";
	public static final String KEY_CONTENT_2 = "Session_no";
	public static final String KEY_CONTENT_3 = "Child_specs";
	public static final String KEY_CONTENT_4 = "StartEnd_timestamp";
	public static final String KEY_CONTENT_5 = "Session_duration";
	public static final String KEY_CONTENT_6 = "Played_modules";
	public static final String KEY_CONTENT_7 = "PP_Calc";
	public static final String KEY_CONTENT_8 = "Dr_A_link_1";
	public static final String KEY_CONTENT_9 = "Ad_replay";
	public static final String KEY_CONTENT_10 = "Dr_A_link_2";
	public static final String KEY_CONTENT_11 = "Gm_1";
	public static final String KEY_CONTENT_12 = "Dr_A_link_3";
	public static final String KEY_CONTENT_13 = "Gm_2";
	public static final String KEY_CONTENT_14 = "Dr_A_link_4";
	public static final String KEY_CONTENT_15 = "Gm_3";
	public static final String KEY_CONTENT_16 = "Dr_A_link_5";
	public static final String KEY_CONTENT_17 = "Ad_replay1";
	public static final String KEY_CONTENT_18 = "Dr_A_link_6";
	public static final String KEY_CONTENT_19 = "Gm_4";
	public static final String KEY_CONTENT_20 = "Dr_A_link_7";
	public static final String KEY_CONTENT_21 = "Video_Diary_1";
	public static final String KEY_CONTENT_22 = "Video_Diary_2";
	public static final String KEY_CONTENT_23 = "Video_Diary_3";
	
	
	public static final String SCRIPT_CREATE_TABLE_1 = 
			
			"CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE_1 + "("
			+ KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
			+ KEY_CONTENT_1 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_2 + " TEXT NOT NULL, "
			+ KEY_CONTENT_3 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_4 + " TEXT NOT NULL, "
			+ KEY_CONTENT_5 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_6 + " TEXT NOT NULL, "
			+ KEY_CONTENT_7 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_8 + " TEXT NOT NULL, "
			+ KEY_CONTENT_9 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_10 + " TEXT NOT NULL, "
			+ KEY_CONTENT_11 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_12 + " TEXT NOT NULL, "
			+ KEY_CONTENT_13 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_14 + " TEXT NOT NULL, "
			+ KEY_CONTENT_15 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_16 + " TEXT NOT NULL, "
			+ KEY_CONTENT_17 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_18 + " TEXT NOT NULL, "
			+ KEY_CONTENT_19 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_20 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_21 + " TEXT NOT NULL, "  
			+ KEY_CONTENT_22 + " TEXT NOT NULL, " 
			+ KEY_CONTENT_23 + " TEXT NOT NULL );";
	
	
	

	///////////////////////////////////////////////////////////////////
	
//public static final String SCRIPT_CREATE_TABLE_1 = 
//
//"CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE_1 + "("
//+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//+ KEY_CONTENT_1 + " TEXT NOT NULL, "  
//+ KEY_CONTENT_2 + " TEXT NOT NULL, "
//+ KEY_CONTENT_3 + " TEXT NOT NULL, "  
//+ KEY_CONTENT_4 + " TEXT NOT NULL, "
//+ KEY_CONTENT_5 + " TEXT NOT NULL, "  
//+ KEY_CONTENT_6 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_7 + " INTEGER DEFAULT 0, " 
//+ KEY_CONTENT_8 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_9 + " INTEGER DEFAULT 0, " 
//+ KEY_CONTENT_10 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_11 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_12 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_13 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_14 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_15 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_16 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_17 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_18 + " INTEGER DEFAULT 0, "
//+ KEY_CONTENT_19 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_20 + " INTEGER DEFAULT 0, "  
//+ KEY_CONTENT_21 + " INTEGER DEFAULT 0,  );";
//
	
	
}

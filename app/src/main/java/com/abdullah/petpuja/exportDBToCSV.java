package com.abdullah.petpuja;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aasif.database.MyDatabaseAdapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.AvoidXfermode.Mode;
import android.os.Environment;
import android.util.Log;

public class exportDBToCSV
{
	Context context;
	File myFile;  
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	String TimeStampDB = sdf.format(cal.getTime()); 
	SQLiteDatabase myDb;
	MyDatabaseAdapter adapter;
    public void dbToCsv(Context context) throws IOException{
    
	this.context=context;
	
	  String[] tableColumnsName={
	    		MyDatabaseAdapter.KEY_CONTENT_1,
	    		MyDatabaseAdapter.KEY_CONTENT_2,
	    		MyDatabaseAdapter.KEY_CONTENT_3, 
	    		MyDatabaseAdapter.KEY_CONTENT_4,
	    		MyDatabaseAdapter.KEY_CONTENT_5,  
	    		MyDatabaseAdapter.KEY_CONTENT_6,
	    		MyDatabaseAdapter.KEY_CONTENT_7,  
	    		MyDatabaseAdapter.KEY_CONTENT_8,
	    		MyDatabaseAdapter.KEY_CONTENT_9,  
	    		MyDatabaseAdapter.KEY_CONTENT_10,
	    		MyDatabaseAdapter.KEY_CONTENT_11,  
	    		MyDatabaseAdapter.KEY_CONTENT_12,
	    		MyDatabaseAdapter.KEY_CONTENT_13,  
	    		MyDatabaseAdapter.KEY_CONTENT_14,
	    		MyDatabaseAdapter.KEY_CONTENT_15,  
	    		MyDatabaseAdapter.KEY_CONTENT_16,
	    		MyDatabaseAdapter.KEY_CONTENT_17,
	    		MyDatabaseAdapter.KEY_CONTENT_18,
	    		MyDatabaseAdapter.KEY_CONTENT_19, 
	    		MyDatabaseAdapter.KEY_CONTENT_20, 
	    		MyDatabaseAdapter.KEY_CONTENT_21,  
	    		MyDatabaseAdapter.KEY_CONTENT_22, 
	    		MyDatabaseAdapter.KEY_CONTENT_23
	     };
	    
	    String  tableColumnsForCSV=
		        "Date"+","+
				"Session No"+","+
				"Child Specs"+","+
				"Start End"+","+
				"Duration"+","+
				"Modules Played"+","+
				"Date Calculator"+","+
				"Dr Anita link 1"+","+
				"Ad Replay"+","+
				"Dr Anita link 2"+","+
				"GAME 1"+","+
				"Dr Anita link 3"+","+
				"GAME 2"+","+
				"Dr Anita link 4"+","+
				"GAME 3"+","+
				"Dr Anita link 5"+","+
				"Ad Replay 2"+","+
				"Dr Anita link 6"+","+
				"GAME 4"+","+
				"Dr Anita link 7"+","+
				"Video Diary 1"+","+ 
				"Video Diary 2"+","+
				"Video Diary 3";
	    
	

try {
	
	File folder = new File(Environment.getExternalStorageDirectory() + "/PetPuja");
	boolean success = true;
	if (!folder.exists()) {
	    success = folder.mkdir();
	}
	if (success) {
		 myFile = new File(Environment.getExternalStorageDirectory()+"/PetPuja/"+TimeStampDB+".csv");
		    myFile.createNewFile();
	} else {
	    // Do something else on failure 
	}
	

   
    FileOutputStream fOut = new FileOutputStream(myFile);
    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
   
    
    
    myOutWriter.append(tableColumnsForCSV);
    myOutWriter.append("\n");
    
  
    
   
    adapter = new MyDatabaseAdapter(this.context);
	adapter.openToRead();
	Cursor c= adapter.selectSpecificData(MyDatabaseAdapter.DATABASE_TABLE_1,tableColumnsName,null);	
	

  

    if (c != null) {
        if (c.moveToFirst()) {
            do {
          
            	String Date= c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_1));
            	String Session_no= c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_2));
            	String Child_specs=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_3)); 
            	String StartEnd_timestamp=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_4));
            	String Session_duration=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_5));  
            	String Played_modules=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_6));
            	String PP_Calc=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_7));  
            	String Dr_A_link_1=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_8));
            	String Ad_replay=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_9));  
				String Dr_A_link_2=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_10));
				String Gm_1=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_11));  
				String Dr_A_link_3=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_12));
				String Gm_2=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_13));  
				String Dr_A_link_4=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_14));
				String Gm_3=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_15));  
				String Dr_A_link_5=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_16));
				String Ad_replay1=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_17));  
				String Dr_A_link_6=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_18));
				String Gm_4=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_19));  
				String Dr_A_link_7=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_20));  
				String Video_Diary_1=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_21));  
				String Video_Diary_2=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_22)); 
				String Video_Diary_3=c.getString(c.getColumnIndex(MyDatabaseAdapter.KEY_CONTENT_23));
            	
				
            	
            	
                myOutWriter.append(
                		Date+","+
                		Session_no+","+
                		Child_specs+","+
                		StartEnd_timestamp+","+
                		Session_duration+","+
                		Played_modules+","+
                		PP_Calc+","+
                		Dr_A_link_1+","+
                		Ad_replay+","+
                		Dr_A_link_2+","+
                		Gm_1+","+
                		Dr_A_link_3+","+
                		Gm_2+","+
                		Dr_A_link_4+","+
                		Gm_3+","+
                		Dr_A_link_5+","+
                		Ad_replay1+","+
                		Dr_A_link_6+","+
                		Gm_4+","+
                		Dr_A_link_7+","+
                		Video_Diary_1+","+
                		Video_Diary_2+","+
                		Video_Diary_3)
                		;
                myOutWriter.append("\n");
                
            } while (c.moveToNext());
        }

        c.close();
        myOutWriter.close();
        fOut.close();

    }
} catch (SQLiteException se) 
{
    Log.e(getClass().getSimpleName(),"Could not create or Open the database");
}

finally {

	adapter.close();

}



}


}
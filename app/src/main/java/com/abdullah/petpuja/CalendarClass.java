package com.abdullah.petpuja;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

public class CalendarClass {

	private  Context context;
	private  int year, month, day;
	private  Calendar calendar;
 
	public CalendarClass(Context context){
		this.context=context;
	}
//	public  void showDialogGameCompleted() {
//		
//		calendar = Calendar.getInstance();
//		year = calendar.get(Calendar.YEAR);
//		month = calendar.get(Calendar.MONTH);
//		day = calendar.get(Calendar.DAY_OF_MONTH);
//
//		DatePickerDialog dialog = new DatePickerDialog(context, myDateListener,
//				year, month, day);
//		dialog.show();
//
//	}
//	private   DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
//
//		@Override
//		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
//			// TODO Auto-generated method stub
//			// arg1 = year
//			// arg2 = month
//			// arg3 = day
//			// arg0.setBackgroundColor(Color.rgb(165, 42, 42));
//			// arg0.setBackground( getResources().getDrawable(
//			// R.drawable.ic_launcher ));
//			Toast.makeText(context, "ca="+arg1+"/"+arg2+"/"+arg3, Toast.LENGTH_SHORT)
//		      .show();
//		}
//	};
}

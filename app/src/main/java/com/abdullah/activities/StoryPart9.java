package com.abdullah.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.abdullah.canvas.StoryPart_1_Canvas;
import com.abdullah.canvas.StoryPart_2_Canvas;
import com.abdullah.canvas.StoryPart_3_Canvas;
import com.abdullah.canvas.StoryPart_7_Canvas;
import com.abdullah.canvas.StoryPart9Canvas;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;

public class StoryPart9 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new StoryPart9Canvas(StoryPart9.this));
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		new AlertDialog.Builder(this)
		.setIcon(R.drawable.girl1)
		.setTitle(R.string.closeAppHeading)
		.setMessage(R.string.closeAppString)
		.setCancelable(false)
		.setPositiveButton(R.string.haanString, new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id){
//			finish();
		}})
		.setNegativeButton(R.string.nahiString,  new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){
//				Intent intent =new Intent();
//		    	intent.setClass(PetPuja.this,StoryPart_1.class);
//		    	startActivityForResult(intent,0);
			}}).show();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
	}

}
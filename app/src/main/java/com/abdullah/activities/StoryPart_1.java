package com.abdullah.activities;

import com.abdullah.canvas.*;
import com.abdullah.petpuja.Constant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class StoryPart_1 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new StoryPart_1_Canvas(StoryPart_1.this));
	}
	
	@Override
	protected void onResume() {
		 super.onResume();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
	}
	
	
	
	@Override
	protected void onStop() {
		finish();
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}

package com.abdullah.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.abdullah.canvas.StoryPart_1_Canvas;
import com.abdullah.canvas.StoryPart12Canvas;
import com.abdullah.canvas.StoryPart_2_Canvas;
import com.abdullah.canvas.StoryPart_3_Canvas;
import com.abdullah.canvas.StoryPart_7_Canvas;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;

public class StoryPart12 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new StoryPart12Canvas(StoryPart12.this));
	}
	
	@Override
	protected void onStop() {
		finish();
		super.onStop();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
	}

}
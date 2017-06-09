package com.abdullah.activities;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


import com.abdullah.canvas.StoryPart_2_Canvas;
import com.abdullah.canvas.StoryPart_3_Canvas;
import com.abdullah.canvas.StoryPart_4_Canvas;
import com.abdullah.canvas.StoryPart_5_Canvas;
import com.abdullah.canvas.Game3Canvas;
import com.abdullah.petpuja.Constant;

public class Game3 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new Game3Canvas(Game3.this));
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
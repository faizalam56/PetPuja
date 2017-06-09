package com.zmq.game1;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.abdullah.activities.Game1;
import com.abdullah.petpuja.R;
import com.zmq.utility.GlobalVariables;

public class Scene1Activity extends Activity {
    Scene1 scene1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

//		GlobalVariables.getResource=getResources();
		setVolumeControlStream(AudioManager.STREAM_MUSIC);		
		Boolean gheeFlag =getIntent().getBooleanExtra("gheeFlag", false);
		setContentView(R.layout.activity_main);
	    scene1=(Scene1) findViewById(R.id.scene1);
		scene1.gheeFlag=gheeFlag;
	}
	void printSecreenInfo(){
   
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        Log.i("", "density :" +  metrics.density);
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
        Log.i("", "ydpi :" +  metrics.ydpi);
 
    }
	@Override
    public void onBackPressed() {
        scene1.thread.running=false;
        SharedInfo.images.clear();
        SharedInfo.images=null;
        scene1.clear();
        scene1.images.clear();
        ((Activity)this).setResult(Activity.RESULT_CANCELED);
        ((Activity)this).finish();
        super.onBackPressed();
    }
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

    @Override
    protected void onDestroy() {
        scene1=null;
        super.onDestroy();
    }
}

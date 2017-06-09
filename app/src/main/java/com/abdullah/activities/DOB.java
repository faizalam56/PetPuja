package com.abdullah.activities;

import com.abdullah.canvas.DOBCanvas;
import com.abdullah.canvas.StoryPart_1_Canvas;
import com.abdullah.petpuja.Constant;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import java.util.Locale;

public class DOB extends Activity{
    Locale myLocale;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setLocale("hi",this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(new DOBCanvas(DOB.this));
	}
	
	@Override
	protected void onResume() {
		 super.onResume();
	}
	
	@Override
	public void onBackPressed() {
		setResult(Constant.CLOSE_WITH_MESSAGE);
		finish();
		super.onBackPressed();
	}
	
	@Override
 	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

    public static void setLocale(String language, Activity activity)
    {
        Locale locale= new Locale(language);
        Locale.setDefault(locale);
//        Locale[] templocal=  Locale.getAvailableLocales();
        Configuration config = new Configuration();
//        for (Locale l:templocal){
//            System.out.println(l.toString());
//        }
//        final Locale[] availableLocales=Locale.getAvailableLocales();
//        for(final Locale locale1 : availableLocales)
//            System.out.println("Applog"+":"+locale1.getDisplayName()+":"+locale1.getLanguage()+":"
//                    +locale1.getCountry()+":values-"+locale1.toString().replace("_","-r"));
        config.locale = locale;
//        thisActivity = activity;
        activity.getBaseContext().getResources().updateConfiguration(config, activity.getBaseContext().getResources().getDisplayMetrics());
    }
}
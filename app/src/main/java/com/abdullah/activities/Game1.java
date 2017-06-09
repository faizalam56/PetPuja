package com.abdullah.activities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.zmq.game1.Images;
import com.zmq.game1.PlateSurfaceView;
import com.zmq.game1.Scene1Activity;
import com.zmq.game1.SharedInfo;
import com.zmq.utility.GlobalVariables;

public class Game1 extends Activity  implements OnClickListener,OnCompletionListener{

	int gradientBtnIds[] ={
			R.id.toggleButton001, R.id.ToggleButton002, 
			R.id.ToggleButton003,R.id.ToggleButton004, R.id.ToggleButton005,
			R.id.ToggleButton006,R.id.ToggleButton007			
			};;
	int ctrlBtnIds[]={R.id.gheebutton,R.id.chalopakae
			};  
	boolean touchEnable=false; 
	boolean gheeEnable_flag;
	public static	ArrayList<Integer> pressedBtnCollection=new ArrayList<Integer>(2);
	PlateSurfaceView plateSurfaceView;
    Bitmap thali;
	Hashtable<Integer, Integer> zIndex=new Hashtable(7){{ 
		put(R.id.ToggleButton005,7);//egg
		put(R.id.ToggleButton004,6);//potato
		put(R.id.ToggleButton003,5);//mix-veg
		put(R.id.ToggleButton007,4);//rice
		put(R.id.ToggleButton006,3);//roti
		put(R.id.ToggleButton002,2);//dal 
		put(R.id.toggleButton001,1);//sag	 
		}};  
	public static int[] zOrder; 
	private long game01_vo01_delay=2000; 
	private long game01_vo02_delay=500;
	private long nextScreen_delay=5; 
	private MediaPlayer game01_vo02,game01_vo01;
	public	static Context self;
	boolean oneTouch;
	Intent intent;

	@Override    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		self=getApplicationContext();
		SharedInfo.context=(Context)self;
		pressedBtnCollection=new ArrayList<Integer>(2);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
        GlobalVariables.getResource=getResources();
        printSecreenInfo();
		setContentView(R.layout.activity_main1);

        RelativeLayout gheeRelativeLayout2= (RelativeLayout) findViewById(R.id.relativeLayout2);
        ViewGroup.MarginLayoutParams gheeRelativeLayout2Params= (ViewGroup.MarginLayoutParams) gheeRelativeLayout2.getLayoutParams();
        gheeRelativeLayout2Params.leftMargin=(int)(gheeRelativeLayout2Params.leftMargin*GlobalVariables.xScale_factor);
        gheeRelativeLayout2Params.topMargin=(int)(gheeRelativeLayout2Params.topMargin*GlobalVariables.yScale_factor);


        Bitmap ghee=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.ghee);
        Drawable gheeDrawable=new BitmapDrawable(getResources(),ghee);
        Button   button=(Button)findViewById(R.id.gheebutton);
        button.setBackground(gheeDrawable);

        thali=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.thali);
        Drawable thaliDrawable=new BitmapDrawable(getResources(),thali);
        RelativeLayout thaliRelativeLayout1= (RelativeLayout) findViewById(R.id.RelativeLayout1);
        thaliRelativeLayout1.setBackground(thaliDrawable);
        ViewGroup.MarginLayoutParams thaliRelativeLayout1Params= (ViewGroup.MarginLayoutParams) thaliRelativeLayout1.getLayoutParams();
        thaliRelativeLayout1Params.leftMargin=(int)(thaliRelativeLayout1Params.leftMargin*GlobalVariables.xScale_factor);
        thaliRelativeLayout1Params.rightMargin=(int)(thaliRelativeLayout1Params.rightMargin*GlobalVariables.xScale_factor);
        thaliRelativeLayout1Params.topMargin=(int)(thaliRelativeLayout1Params.topMargin*GlobalVariables.yScale_factor);
        thaliRelativeLayout1Params.bottomMargin=(int)(thaliRelativeLayout1Params.bottomMargin*GlobalVariables.yScale_factor);
        if(GlobalVariables.xScale_factor!=1.0 && GlobalVariables.yScale_factor!=1.0){
//            android:paddingTop="20dp"
//            android:paddingBottom="25dp"
            thaliRelativeLayout1.setPadding(0,20,0,25);
        }

        LinearLayout linearLayout1= (LinearLayout) findViewById(R.id.linearLayout1);
        ViewGroup.MarginLayoutParams linearLayout1Params= (ViewGroup.MarginLayoutParams) linearLayout1.getLayoutParams();
        linearLayout1Params.leftMargin=(int)(linearLayout1Params.leftMargin*GlobalVariables.xScale_factor);
        linearLayout1Params.rightMargin=(int)(linearLayout1Params.rightMargin*GlobalVariables.xScale_factor);
        linearLayout1Params.topMargin=(int)(linearLayout1Params.topMargin*GlobalVariables.yScale_factor);
        linearLayout1Params.bottomMargin=(int)(linearLayout1Params.bottomMargin*GlobalVariables.yScale_factor);

		plateSurfaceView=(PlateSurfaceView)findViewById(R.id.plateSurfaceView1);
		plateSurfaceView.setPressedBtnCollection(pressedBtnCollection);
		addListenerOnButton();		


		// sound 		
		game01_vo01=MediaPlayer.create(getApplicationContext(), R.raw.game01_vo01);		
		if(game01_vo01!=null){
			game01_vo01.setOnCompletionListener(this);
		}
		Handler tempHandler=new Handler();
		tempHandler.postDelayed(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub	
				if(game01_vo01!=null)
				game01_vo01.start();
			}
		}, game01_vo01_delay);				
	}
	
	private void addListenerOnButton(){
		for (int i = 0; i < gradientBtnIds.length; i++) {
			ToggleButton   button=(ToggleButton)findViewById(gradientBtnIds[i]);
			button.setOnClickListener(this);
			button.setClickable(false);
		}
		for (int i = 0; i < ctrlBtnIds.length; i++) {
			Button button=(Button)findViewById(ctrlBtnIds[i]);
			button.setOnClickListener(this);
		}
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(touchEnable){
			switch (v.getId()) {
			case R.id.ToggleButton007:// rice
				pressRiceButton(v);
				break;
			case R.id.ToggleButton006:// roti
				pressRotiButton(v);
				break;
			case R.id.chalopakae:
				if(touchEnable){
//					v.setVisibility(View.INVISIBLE);
					if(game01_vo01!=null){
						if(game01_vo01.isPlaying())game01_vo01.stop();
						game01_vo01.release();
						game01_vo01=null;
					}					
					v.setEnabled(false);
					touchEnable=false;
					gheeEnable_flag=true;
					disableAllgradient();				
					// ghee  sound
					bottleSound();
					
					//Load next screen image
					Handler tempHandler=new Handler();
					tempHandler.postDelayed(new Runnable() {			
						@Override
						public void run() {
							// TODO Auto-generated method stub	
							SharedInfo.images=new Images();
					}
					}, 5);
				}			
				
				break;
			default:
				pressVegDalButton(v);
				break;
			}
		} else {
			switch (v.getId()) {// ghee butoon
			case R.id.gheebutton:
				if(gheeEnable_flag)	{
					if (game01_vo02 != null && game01_vo02.isPlaying())
						game01_vo02.stop();
					game01_vo02.release();
					game01_vo02 = null;
								
				if(plateSurfaceView!=null){
					plateSurfaceView.gheeFlag=true;
				}
				gheeEnable_flag = false;
				v.setEnabled(false);

				}
				break;
			case R.id.chalopakae:
				if (game01_vo02 != null) {
					if (game01_vo02.isPlaying())
						game01_vo02.stop();
					game01_vo02.release();
					game01_vo02 = null;
				}
//									
//					if(plateSurfaceView!=null){
//						plateSurfaceView.gheeFlag=false;
//					}
					gheeEnable_flag = false;
					v.setEnabled(false);
                    callScreen2Activity();
					//play game01_vokoi_bat_nahi audio
//					if(plateSurfaceView.gheeFlag){
//						callScreen2Activity();
//					}else{
//					 koi_bat_nahiSound();
//					}
		
				break;
			}
		}
		oneTouch=true;
		if(game01_vo01!=null){
			if(game01_vo01.isPlaying())game01_vo01.stop();
			game01_vo01.release();
			game01_vo01=null;
		}
		//****************z-order**************************
		zOrder=new int[pressedBtnCollection.size()];
		for (int i = 0; i < zOrder.length; i++) {
			int temp=pressedBtnCollection.get(i);
			zOrder[i]=zIndex.get(temp);
		}  
		//****************************************** 
		Arrays.sort(zOrder);
		
		Canvas canvas =plateSurfaceView.surfaceHolder.lockCanvas(null);		
		plateSurfaceView. drawSomething(canvas);
		plateSurfaceView.surfaceHolder.unlockCanvasAndPost(canvas);	
		//play clicked sound
		SharedInfo.playClickSound(getApplicationContext(),R.raw.touch);
	}
	//rice
	private void pressRiceButton(View v){
		ToggleButton b=(ToggleButton)v;
		if (b.isChecked()) {
			b.setChecked(true);
			this.setRotiButton(false);//disable roti
			Integer tempInteger=Integer.valueOf(b.getId());
			pressedBtnCollection.add(tempInteger);
			 
		} else {
			b.setChecked(false);
			this.setRotiButton(true);//enable roti
			Integer tempInteger=Integer.valueOf(b.getId());	
			/* remove position index of that butn*/
//			int btnIndexinCollectionArray=pressedBtnCollection.indexOf(tempInteger);					
			pressedBtnCollection.remove(tempInteger);//remove btn collection					
		}				
		enableButtons();//enable back button
	}
	//roti 
	private void pressRotiButton(View v){
		ToggleButton b=(ToggleButton)v;
		if (b.isChecked()) {
			b.setChecked(true);
			setRiceButton(false);//disable rice 
			Integer tempInteger=Integer.valueOf(b.getId());
			pressedBtnCollection.add(tempInteger);
		} else {
			b.setChecked(false);
			setRiceButton(true);// enable rice
			Integer tempInteger=Integer.valueOf(b.getId());									
			pressedBtnCollection.remove(tempInteger);//remove btn collection					
		}				
		enableButtons();//enable back button
	}
	
	private void pressVegDalButton(View v){
		ToggleButton b=(ToggleButton)v;
		if (b.isChecked()) {
			b.setChecked(true);
			pressedBtnCollection.add(Integer.valueOf(b.getId()));
		} else {
			b.setChecked(false);
			Integer tempInteger=Integer.valueOf(b.getId());				
			pressedBtnCollection.remove(tempInteger);//remove btn collection
		}
//		b.setEnabled(false);				
		enableButtons();//enable back button		
	}
		
	/* handle enabling/diablig of button*/
	private void enableButtons(){
			
		Button tempchalopakayeinButton=(Button)findViewById(R.id.chalopakae);
		if((getRiceButtonCheckedStatus()||getRotiButtonCheckedStatus())&&(pressedBtnCollection.size()>=2)){//when rice button selected and 1 more icon selected so enable chalo pakayen			
			tempchalopakayeinButton.setVisibility(View.VISIBLE);
		}else{
			tempchalopakayeinButton.setVisibility(View.INVISIBLE);
		}
		if ((getRiceButtonCheckedStatus()||getRotiButtonCheckedStatus())/*&& (pressedBtnCollection.size() == 1||pressedBtnCollection.size()==2||pressedBtnCollection.size()==3)*/) {			
		}else if ((getRiceButtonCheckedStatus()||getRotiButtonCheckedStatus())&& pressedBtnCollection.size() == 4) {
//			this.disableAllgradientExceptSelected();
			if(game01_vo01!=null){
				if(game01_vo01.isPlaying())game01_vo01.stop();
				game01_vo01.release();
				game01_vo01=null;
			}
			touchEnable=false;
			gheeEnable_flag=true;
//			tempchalopakayeinButton.setVisibility(View.INVISIBLE);	
			tempchalopakayeinButton.setEnabled(false);
			disableAllgradient();			
			// ghee sound
			bottleSound();
		}
//		else if((!getRiceButtonCheckedStatus()&&!getRotiButtonCheckedStatus())){ 
//			disableAllgradientExceptSelected_and_RiceRoti();
//		}
//		else{
//			enableAllgradient();
//		}
	}
	
	private void disableAllgradientExceptSelected(){
		for (int i = 0; i < gradientBtnIds.length; i++) {
			ToggleButton button=(ToggleButton)findViewById(gradientBtnIds[i]);
			if(pressedBtnCollection.contains(Integer.valueOf(button.getId()))){
				continue;
			}
			button.setEnabled(false);
		}
	}
	
	private void disableAllgradientExceptSelected_and_RiceRoti(){
		for (int i = 0; i < gradientBtnIds.length-2; i++) {			
			ToggleButton button=(ToggleButton)findViewById(gradientBtnIds[i]);
			if(pressedBtnCollection.contains(Integer.valueOf(button.getId()))){
				continue;
			}
			button.setEnabled(false);
		}
	}
	
	private void enableAllgradient(){
		for (int i = 0; i < gradientBtnIds.length; i++) {
			ToggleButton button=(ToggleButton)findViewById(gradientBtnIds[i]);			
			button.setEnabled(true);
			button.setClickable(true);
		}
	}
	
	private void disableAllgradient(){
		for (int i = 0; i < gradientBtnIds.length; i++) {
			ToggleButton button=(ToggleButton)findViewById(gradientBtnIds[i]);			
			button.setEnabled(false);
		}
	}
	
	private void disableSelectedGradient(){
		if(pressedBtnCollection.size()<=0)return;
		Object[] ids=pressedBtnCollection.toArray(); 
		for (int i = 0; i < gradientBtnIds.length; i++) {
		 boolean mach=false;
			
			for (int j = 0; j < ids.length; j++) {
				if(gradientBtnIds[i]==(Integer)ids[j]){
					mach=true;
					break;
				} 
			}
			if(mach)continue;
			ToggleButton button=(ToggleButton)findViewById(gradientBtnIds[i]);
			button.setEnabled(true);
		}
	}	
	//rice enable/diable
	private void setRiceButton(boolean checked){
		ToggleButton b=(ToggleButton)findViewById(R.id.ToggleButton007);		
		b.setEnabled(checked);
	}
	//roti enable/disable
	private void setRotiButton(boolean checked){
		ToggleButton b=(ToggleButton)findViewById(R.id.ToggleButton006);		//roti
		b.setEnabled(checked);
	}
	//rice checked status
	private boolean getRiceButtonCheckedStatus(){
		ToggleButton b=(ToggleButton)findViewById(R.id.ToggleButton007);		//rice
		return b.isChecked();
	}
	//roti checked status
	private boolean getRotiButtonCheckedStatus(){
		ToggleButton b=(ToggleButton)findViewById(R.id.ToggleButton006);		//roti
		return b.isChecked();
	}
	
	public void callScreen2Activity() {
		
		intent = new Intent(getApplicationContext(), Scene1Activity.class);
		intent.putExtra("gheeFlag", plateSurfaceView.gheeFlag);
		intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivityForResult(intent, 10);
//		startActivity(intent);		
//		this.finish();
		Handler tempHandler=new Handler();
		tempHandler.postDelayed(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub	
				plateSurfaceView.clear();
			}
		}, 100);
		
	}
	
	@Override
	protected void onResume() {		
//		for (Integer id : pressedBtnCollection) {
//			ToggleButton button = (ToggleButton) findViewById(id);
//			button.setChecked(true);
//		}
//		enableButtons();
		if((!oneTouch && !gheeEnable_flag)){
			game01_vo01=MediaPlayer.create(getApplicationContext(), R.raw.game01_vo01);
			if(game01_vo01!=null){
				game01_vo01.setOnCompletionListener(this);
				game01_vo01.start();
				}	
		}
		if(!touchEnable && gheeEnable_flag){
			game01_vo02=MediaPlayer.create(getApplicationContext(), R.raw.game01_vo02);
			if(game01_vo02!=null){
				game01_vo02.setOnCompletionListener(this);
				game01_vo02.start();
				}
		}
//		if(!touchEnable && !gheeEnable_flag && !plateSurfaceView.gheeFlag && oneTouch){
//			game01_vokoi_bat_nahi=MediaPlayer.create(getApplicationContext(), R.raw.game01_vokoi_bat_nahi_dummy);
//			if(game01_vokoi_bat_nahi!=null){
//				game01_vokoi_bat_nahi.setOnCompletionListener(this);
//				game01_vokoi_bat_nahi.start();
//				}
//		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		System.out.println("i m in pause"); 
		if(game01_vo01!=null){
			if(game01_vo01.isPlaying())game01_vo01.stop();
			game01_vo01.release();
			game01_vo01=null;
		}
		if(game01_vo02!=null){
			if(game01_vo02.isPlaying())game01_vo02.stop();
			game01_vo02.release();
			game01_vo02=null;
		}
//		if(game01_vokoi_bat_nahi!=null){
//			if(game01_vokoi_bat_nahi.isPlaying())game01_vokoi_bat_nahi.stop();
//			game01_vokoi_bat_nahi.release();
//			game01_vokoi_bat_nahi=null;
//		}
		
		super.onPause();
	}

    @Override
    protected void onDestroy() {
        plateSurfaceView=null;
        for (int i = 0; i < gradientBtnIds.length; i++) {
            unbindDrawables(findViewById(gradientBtnIds[i]));
            System.gc();
        }
        for (int i = 0; i < ctrlBtnIds.length; i++) {
            unbindDrawables(findViewById(gradientBtnIds[i]));
            System.gc();
        }
        super.onDestroy();
    }
    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            try
            {
                ((ViewGroup) view).removeAllViews();
            }
            catch(UnsupportedOperationException ignore)
            {
                //if can't remove all view (e.g. adapter view) - no problem
            }
        }
    }
    @Override
	protected void onSaveInstanceState(Bundle outState) {
	   super.onSaveInstanceState(outState);

	  outState.putIntegerArrayList("pressedBtnCollection", pressedBtnCollection);
	
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedState) {
	   super.onRestoreInstanceState(savedState);
		System.out.println(" i m in onRestoreInstanceState");
		pressedBtnCollection = savedState.getIntegerArrayList("pressedBtnCollection");
		enableButtons();		
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

//	private void koi_bat_nahiSound(){
//		game01_vokoi_bat_nahi=MediaPlayer.create(getApplicationContext(),R.raw.game01_vokoi_bat_nahi_dummy);
//		if(game01_vokoi_bat_nahi!=null){
//			game01_vokoi_bat_nahi.start();
//			game01_vokoi_bat_nahi.setOnCompletionListener(this);
//		}
//	}
	private void bottleSound(){
		Button tempchalopakayeinButton = (Button) findViewById(R.id.chalopakae);
//		tempchalopakayeinButton.setVisibility(View.INVISIBLE);
		tempchalopakayeinButton.setEnabled(false);		
		game01_vo02 = MediaPlayer.create(getApplicationContext(),R.raw.game01_vo02);
		if(game01_vo02!=null)
			game01_vo02.start();

		if (game01_vo02 != null) {
			game01_vo02.setOnCompletionListener(this);

		}
	}
	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		if(!touchEnable && !gheeEnable_flag&&!oneTouch){			
			game01_vo01=null;
			touchEnable=true;
			enableAllgradient();
		}
		if(touchEnable&&!oneTouch){
			game01_vo01=MediaPlayer.create(getApplicationContext(), R.raw.game01_vo01);		
			if(game01_vo01!=null){
				game01_vo01.setOnCompletionListener(this);
			}
			Handler tempHandler=new Handler();
			tempHandler.postDelayed(new Runnable() {			
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(game01_vo01!=null)
					game01_vo01.start();
				}
			}, SharedInfo.repeated_sound_delay);
		}
		
		if(!touchEnable && gheeEnable_flag){
			gheeEnable_flag = true;
			Button tempchalopakayeinButton = (Button) findViewById(R.id.chalopakae);
			tempchalopakayeinButton.setEnabled(true);
			game01_vo02=null;
			game01_vo02=MediaPlayer.create(getApplicationContext(), R.raw.game01_vo02);
			Handler tempRepeated_soundMyHandler = new Handler();
			tempRepeated_soundMyHandler.postDelayed(new Runnable() {					
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(game01_vo02!=null && gheeEnable_flag)
						game01_vo02.start();
				}
			}, SharedInfo.repeated_sound_delay);
			game01_vo02.setOnCompletionListener(this);
			Button tempGheeButton = (Button) findViewById(R.id.gheebutton);
			tempGheeButton.setEnabled(true);
		}
		if(!touchEnable && !gheeEnable_flag && !plateSurfaceView.gheeFlag){
			callScreen2Activity();
		}
				
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	if(requestCode==10){
		if(resultCode==Activity.RESULT_OK){
			this.setResult(Activity.RESULT_OK);
			this.finish();
			zIndex=null;
			plateSurfaceView.clear();
		}
        if(resultCode==Constant.REPLAY){
            this.setResult(Constant.REPLAY);
            this.finish();
            zIndex=null;
            plateSurfaceView.clear();
        }
        if(resultCode==Activity.RESULT_CANCELED){
            this.setResult(Activity.RESULT_CANCELED);
            this.finish();
        }
	}

	}
	@Override
    public void onBackPressed() {
        ((Activity)this).setResult(Activity.RESULT_CANCELED);
        ((Activity)this).finish();
        super.onBackPressed();
    }
}

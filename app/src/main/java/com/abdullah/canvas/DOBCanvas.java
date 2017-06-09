package com.abdullah.canvas;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.abdullah.activities.Login;
import com.abdullah.petpuja.CalendarClass;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.ObjectFall;
import com.abdullah.petpuja.ObjectMove;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.VedioPlay;
import com.abdullah.petpuja.ZoomInZoomOut;
import com.zmq.utility.GlobalVariables;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class DOBCanvas extends SurfaceView implements SurfaceHolder.Callback,Runnable,SurfaceView.OnLongClickListener{
	String versionName;
	int versonShow=0;
    DatePicker datePicker;//by shah
    TextView mMonthNameTv=null;
    boolean monthNameThread_boolean;

	private DatePickerDialog.OnDateSetListener mDateSetListener;
	boolean storyOK=false;
	GameThread gameThread;
	int timeInSecond=0;
	int zoomIn,ZoomOut=200;
	float xDpi,yDpi;
	float xScale,yScale;
	float xMultiplyer,yMultiplyer;
	int lineLength=0;
	Bitmap waitingStar,girl1,backGround,ageChale,sprite,numberSprite,/*triangleUp,triangleDown,*/image4;
	Bitmap link1_1a,link1_2a,link1_3a;
	private RectF ageChaleRectF,imageRectF,LockF,datef;
//	private RectF dayUpF,dayDownF,monthUpF,monthDownF,yearUpF,yearDownF;
	private Rect buttonRectS,imageRectS;
	private int xPoint;
	private int yPoint;
	Canvas canvas;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false,spriteSwitcher;
	Context context;
	Sprite drawMidSprite,spriteNumberObj;
	int canvasWidth,canvasHeight;
    ZoomInZoomOut zio;
	int whichScene=0,subSwichIndex=0;
	int threadTimeController=1;
	int sleepTime=5;
	
	Sprite[] spriteNumberArrayObj;
	int day,month,year;
	
	Calendar calendar,calendar2;
	
	ObjectFall fallObj;
	ObjectMove moveObj;
	Constant myConstantObj;
    Sound mySound;
	
    Bitmap janamtithiImage;
    
    Bitmap link1_4a,link1_4b;
    Sprite spritelink1_4bObj;
    int link1_4bSpriteIndex;

    Bitmap link1_5a,link1_5b;
    Bitmap link1_11a,link1_11b;
    Bitmap link1_12a;
    Bitmap link1_13a,link1_13b;

   MediaPlayer mediaPlayerTouch,mediaPlayerIntro;
    
    Paint paintfadeInOut,paintWhite;
    int fadeInOutIndex=0;
    
	    public DOBCanvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		backGround =Constant.backGround;
		waitingStar=Constant.waitingStar;
		
		calendar=Calendar.getInstance();
		calendar2=Calendar.getInstance();
		
		day=calendar.get(Calendar.DAY_OF_MONTH);
		month=calendar.get(Calendar.MONTH);
		year=calendar.get(Calendar.YEAR);
		
		paintfadeInOut=new Paint(Paint.ANTI_ALIAS_FLAG);
		paintWhite=new Paint(Paint.ANTI_ALIAS_FLAG);
		paintWhite.setARGB(255,255,255, 255);
		paintWhite.setStyle(Style.FILL_AND_STROKE);

		mediaPlayerTouch=MediaPlayer.create(this.context,R.raw.touch);
		myConstantObj=new Constant(context);
		mySound=new Sound(context);
	    }

	@Override
	protected void onDraw(Canvas canvas) {
		if(canvas!=null){
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		canvas.drawRect(0, 0, canvasWidth, canvasHeight, paintWhite);
		drawAnimation(canvas,whichScene);
		}
		
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
		if(Constant.HEADER==1){
		myConstantObj.drawText(canvas,"SCENE NO : "+whichScene +"."+subSwichIndex,100,100,30);
		myConstantObj.drawText(canvas,"threreadTimeController : "+threadTimeController,(int)(100*GlobalVariables.xScale_factor),(int)(200*GlobalVariables.yScale_factor),30);
		myConstantObj.drawText(canvas,"yScale : "+yScale,canvasWidth-200,200,30);
		}
	}

	private void drawAnimation(Canvas canvas,int whichScene) {
	  
		switch(whichScene){
		case -1:
			
			break;
		case 0:
			myConstantObj.drawImageWithRotation(canvas);
	        loadImages();
			break;
		case 1:
			scene_1(canvas);
			break;
		case 2:
			try {
			     versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				versionName="0.0";
				e.printStackTrace();
			}
			myConstantObj.drawBackground(canvas,backGround);
			scene_2(canvas);
			break;
		case 3:
			myConstantObj.drawBackground(canvas,backGround);
			scene_3(canvas);
			break;
		case 4:
			myConstantObj.drawBackground(canvas,backGround);
//			scene_4(canvas);
			break;
		}
	}

	private void scene_3(Canvas canvas) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		
		
		
		if(!link1_4a.isRecycled()&!link1_4b.isRecycled())
		{
			myConstantObj.drawImageAtExactPosition(canvas,link1_4a,(int)(95*GlobalVariables.xScale_factor),(int)(175*GlobalVariables.yScale_factor),null);
		
		Date d;
		try {
			d = sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
			Calendar now = Calendar.getInstance();    
	        now.setTime(d);
	        now.add(Calendar.MONTH, 7);
	        myConstantObj.drawText(canvas,""+now.get(Calendar.DATE),(int)(200*GlobalVariables.xScale_factor),(int)(400*GlobalVariables.yScale_factor),(int)(100*GlobalVariables.xScale_factor));
	        myConstantObj.drawText(canvas,""+(now.get(Calendar.MONTH)+1),(int)(400*GlobalVariables.xScale_factor),(int)(400*GlobalVariables.yScale_factor), (int)(100*GlobalVariables.xScale_factor));
	        myConstantObj.drawText(canvas,""+now.get(Calendar.YEAR),(int)(645*GlobalVariables.xScale_factor),(int)(400*GlobalVariables.yScale_factor), (int)(100*GlobalVariables.xScale_factor));
	        storyOK=true;
		} catch (ParseException e) {
			
		}
		if(Constant.AGEINMONTHS>=6&!link1_4b.isRecycled())spritelink1_4bObj.drawSpriteAtExactPosition(canvas,1,canvasWidth-link1_4b.getWidth()/2, 0,null);
		else if(!link1_4b.isRecycled())spritelink1_4bObj.drawSpriteAtExactPosition(canvas,0,canvasWidth-link1_4b.getWidth()/2, 0,null);

		if(!ageChale.isRecycled())drawButton(canvas,ageChale,(int)(GlobalVariables.xScale_factor*200),canvasHeight-ageChale.getHeight()*2);
		}
	}
		
		
    
	

	private void scene_30(Canvas canvas) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		myConstantObj.drawImageAtExactPosition(canvas,link1_4a,(int)(95*GlobalVariables.xScale_factor),(int)(GlobalVariables.yScale_factor*175),null);
			Date d;
			try {
				d = sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
				Calendar now = Calendar.getInstance();    
		        now.setTime(d);
		        now.add(Calendar.MONTH, 7);
		        myConstantObj.drawText(canvas,""+now.get(Calendar.DATE),(int)(GlobalVariables.xScale_factor*200),(int)(GlobalVariables.yScale_factor*400), 100);
		        myConstantObj.drawText(canvas,""+(now.get(Calendar.MONTH)+1),(int)(GlobalVariables.xScale_factor*400),(int)(GlobalVariables.yScale_factor*400), 100);
		        myConstantObj.drawText(canvas,""+now.get(Calendar.YEAR),(int)(GlobalVariables.xScale_factor*645),(int)(GlobalVariables.yScale_factor*400), 100);
			} catch (ParseException e) {
				
			}
		
		if(Constant.AGEINMONTHS>=6)spritelink1_4bObj.drawSpriteAtExactPosition(canvas,1,canvasWidth-link1_4b.getWidth()/2, 0,null);
		else spritelink1_4bObj.drawSpriteAtExactPosition(canvas,0,canvasWidth-link1_4b.getWidth()/2, 0,null);
		
		mySound.playSound(R.raw.link1_4a); 
		if(mySound.ifPlaying()==0){
	    	mySound.stopSound();
	    	whichScene=5;
	    	
	    	
	    }
	}

	
	private void scene_2(Canvas canvas) {
		int d, m,y,space=30;
		
		datef=new RectF(canvasWidth/2-dateBackground.getWidth()/2,canvasHeight/2-dateBackground.getHeight()/2, canvasWidth/2+dateBackground.getWidth()/2, canvasHeight/2+dateBackground.getHeight()/2);
		//LockF=new RectF(canvasWidth-lockImage.getWidth()-50,lockImage.getHeight()*3/2,canvasWidth-50,lockImage.getHeight()*3/2+lockImage.getHeight());
        LockF=new RectF(canvasWidth-lockImage.getWidth()-(int)(50*GlobalVariables.xScale_factor),lockImage.getHeight()*3/2,canvasWidth-(int)(50*GlobalVariables.xScale_factor),lockImage.getHeight()*3/2+lockImage.getHeight());
		
		myConstantObj.drawImageWithRectF(canvas, LockF, lockImage);
//		drawImage(canvas, lockImage, canvasWidth-lockImage.getWidth(),lockImage.getHeight()*3/2,null);
		
		myConstantObj.drawImage(canvas, dateBackground, canvasWidth/2,canvasHeight/2,null);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		int numberImageWidth=numberSprite.getWidth()/10;
		d=day;
		m=month;
		y=year;
		
//		dayUpF=new RectF(canvasWidth/2-3*numberImageWidth-space-triangleUp.getWidth()/2-120,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40,canvasWidth/2-3*numberImageWidth-space+triangleUp.getWidth()/2-120,canvasHeight/2-numberSprite.getHeight()/2-40);
//		dayDownF=new RectF(canvasWidth/2-3*numberImageWidth-space-triangleUp.getWidth()/2-120,canvasHeight/2+numberSprite.getHeight()/2+30,canvasWidth/2-3*numberImageWidth-space+triangleUp.getWidth()/2-120,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//		monthUpF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-20,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40, canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-20,canvasHeight/2-numberSprite.getHeight()/2-40);
//		monthDownF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-20,canvasHeight/2+numberSprite.getHeight()/2+30, canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-20,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//		yearUpF=new RectF(canvasWidth/2+2*numberImageWidth-triangleUp.getWidth()/2+120,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40, canvasWidth/2+2*numberImageWidth+triangleUp.getWidth()/2+120,canvasHeight/2-numberSprite.getHeight()/2-40);
//		yearDownF=new RectF(canvasWidth/2+2*numberImageWidth-triangleUp.getWidth()/2+120,canvasHeight/2+numberSprite.getHeight()/2+30, canvasWidth/2+2*numberImageWidth+triangleUp.getWidth()/2+120,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//
//		drawImageWithRectF(canvas, dayUpF,triangleUp);
//	    drawImageWithRectF(canvas, dayDownF, triangleDown);
//	    drawImageWithRectF(canvas, monthUpF, triangleUp);
//	    drawImageWithRectF(canvas, monthDownF, triangleDown);
//	    drawImageWithRectF(canvas, yearUpF, triangleUp);
//	    drawImageWithRectF(canvas, yearDownF, triangleDown);
		

		spriteNumberArrayObj[0].drawSprite(canvas,d%10,canvasWidth/2-3*numberImageWidth+numberImageWidth/2-space-(int)(120*GlobalVariables.xScale_factor),canvasHeight/2,null);
		d=d/10;
		spriteNumberArrayObj[1].drawSprite(canvas,d%10,canvasWidth/2-4*numberImageWidth+numberImageWidth/2-space-(int)(120*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		m=m+1;
		spriteNumberArrayObj[2].drawSprite(canvas,m%10,canvasWidth/2-numberImageWidth+numberImageWidth/2-(int)(20*GlobalVariables.xScale_factor),canvasHeight/2,null);
		m=m/10;
		spriteNumberArrayObj[3].drawSprite(canvas,m%10,canvasWidth/2-2*numberImageWidth+numberImageWidth/2-(int)(20*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		
		spriteNumberArrayObj[7].drawSprite(canvas,y%10,canvasWidth/2+3*numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[6].drawSprite(canvas,y%10,canvasWidth/2+2*numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[5].drawSprite(canvas,y%10,canvasWidth/2+numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[4].drawSprite(canvas,y%10,canvasWidth/2+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		myConstantObj.drawImage(canvas, janamtithiImage, canvasWidth/2, (int)(200*GlobalVariables.yScale_factor), null);
//		drawText(canvas,getResources().getString(R.string.jamantithi),canvasWidth/2,250,70);

		Date d1=null,d2=null;
		long diffInDays=0;
		try {
			
			d1=sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
			d2=sdf.parse(calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00");
			diffInDays = (long)(d2.getTime() - d1.getTime())/ (1000 * 60 * 60 * 24);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if(diffInDays>=0){
			
			myConstantObj.drawText(canvas,getResources().getString(R.string.age)+" : "+ diffInDays/365 +" "+ getResources().getString(R.string.year)+" , "+(diffInDays%365)/30 +"  "+getResources().getString(R.string.month)+" , "+(diffInDays%365)%30 +" "+ getResources().getString(R.string.day),canvasWidth/2,canvasHeight/2+(int)(200*GlobalVariables.yScale_factor),40);
			drawButton(canvas,ageChale,canvasWidth/2,canvasHeight-ageChale.getHeight()*2);
		}
		else myConstantObj.drawText(canvas,getResources().getString(R.string.checkDate),canvasWidth/2,canvasHeight/2+(int)(200*GlobalVariables.yScale_factor),40);

		Constant.AGEINMONTHS=(int)diffInDays/30;
		
		/////////// verson control /////////////
		 if(canvas!=null&&(versonShow>2&&versonShow<4))
	     myConstantObj.drawText(canvas,versionName, (int)(100*GlobalVariables.xScale_factor),(int) (70*GlobalVariables.yScale_factor), 20);
		 if(versonShow==5)versonShow=1;
		 ///////////////////////////////////////
		
	}
	
	
	private void scene_2_for_Calander(Canvas canvas){
		int d, m,y,space=30;
		
		LockF=new RectF(canvasWidth-lockImage.getWidth()-(int)(50*GlobalVariables.xScale_factor),lockImage.getHeight()*3/2,canvasWidth-(int)(50*GlobalVariables.xScale_factor),lockImage.getHeight()*3/2+lockImage.getHeight());
		
		myConstantObj.drawImageWithRectF(canvas, LockF, lockImage);
//		drawImage(canvas, lockImage, canvasWidth-lockImage.getWidth(),lockImage.getHeight()*3/2,null);
		
		myConstantObj.drawImage(canvas, dateBackground, canvasWidth/2,canvasHeight/2,null);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		int numberImageWidth=numberSprite.getWidth()/10;
		d=day;
		m=month;
		y=year;
		
//		dayUpF=new RectF(canvasWidth/2-3*numberImageWidth-space-triangleUp.getWidth()/2-120,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40,canvasWidth/2-3*numberImageWidth-space+triangleUp.getWidth()/2-120,canvasHeight/2-numberSprite.getHeight()/2-40);
//		dayDownF=new RectF(canvasWidth/2-3*numberImageWidth-space-triangleUp.getWidth()/2-120,canvasHeight/2+numberSprite.getHeight()/2+30,canvasWidth/2-3*numberImageWidth-space+triangleUp.getWidth()/2-120,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//		monthUpF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-20,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40, canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-20,canvasHeight/2-numberSprite.getHeight()/2-40);
//		monthDownF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-20,canvasHeight/2+numberSprite.getHeight()/2+30, canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-20,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//		yearUpF=new RectF(canvasWidth/2+2*numberImageWidth-triangleUp.getWidth()/2+120,canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-40, canvasWidth/2+2*numberImageWidth+triangleUp.getWidth()/2+120,canvasHeight/2-numberSprite.getHeight()/2-40);
//		yearDownF=new RectF(canvasWidth/2+2*numberImageWidth-triangleUp.getWidth()/2+120,canvasHeight/2+numberSprite.getHeight()/2+30, canvasWidth/2+2*numberImageWidth+triangleUp.getWidth()/2+120,canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+30);
//
//
//
//		drawImageWithRectF(canvas, dayUpF,triangleUp);
//	    drawImageWithRectF(canvas, dayDownF, triangleDown);
//	    drawImageWithRectF(canvas, monthUpF, triangleUp);
//	    drawImageWithRectF(canvas, monthDownF, triangleDown);
//	    drawImageWithRectF(canvas, yearUpF, triangleUp);
//	    drawImageWithRectF(canvas, yearDownF, triangleDown);
		
		
	    
		spriteNumberArrayObj[0].drawSprite(canvas,d%10,canvasWidth/2-3*numberImageWidth+numberImageWidth/2-space-(int)(120*GlobalVariables.xScale_factor),canvasHeight/2,null);
		d=d/10;
		spriteNumberArrayObj[1].drawSprite(canvas,d%10,canvasWidth/2-4*numberImageWidth+numberImageWidth/2-space-(int)(120*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		m=m+1;
		spriteNumberArrayObj[2].drawSprite(canvas,m%10,canvasWidth/2-numberImageWidth+numberImageWidth/2-(int)(20*GlobalVariables.xScale_factor),canvasHeight/2,null);
		m=m/10;
		spriteNumberArrayObj[3].drawSprite(canvas,m%10,canvasWidth/2-2*numberImageWidth+numberImageWidth/2-(int)(120*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		
		spriteNumberArrayObj[7].drawSprite(canvas,y%10,canvasWidth/2+3*numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[6].drawSprite(canvas,y%10,canvasWidth/2+2*numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[5].drawSprite(canvas,y%10,canvasWidth/2+numberImageWidth+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[4].drawSprite(canvas,y%10,canvasWidth/2+space+numberImageWidth/2+(int)(90*GlobalVariables.xScale_factor),canvasHeight/2,null);
		
		myConstantObj.drawImage(canvas, janamtithiImage, canvasWidth/2, 200, null);
//		drawText(canvas,getResources().getString(R.string.jamantithi),canvasWidth/2,250,70);

		Date d1=null,d2=null;
		long diffInDays=0;
		try {
			
			d1=sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
			d2=sdf.parse(calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00");
			diffInDays = (long)(d2.getTime() - d1.getTime())/ (1000 * 60 * 60 * 24);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		if(diffInDays>=0)myConstantObj.drawText(canvas,getResources().getString(R.string.age)+" : "+ diffInDays/365 +" "+ getResources().getString(R.string.year)+" , "+(diffInDays%365)/30 +"  "+getResources().getString(R.string.month)+" , "+(diffInDays%365)%30 +" "+ getResources().getString(R.string.day),canvasWidth/2,canvasHeight/2+(int)(200*GlobalVariables.yScale_factor),40);
		else myConstantObj.drawText(canvas,getResources().getString(R.string.checkDate),canvasWidth/2,canvasHeight/2+(int)(200*GlobalVariables.yScale_factor),40);

		Constant.AGEINMONTHS=(int)diffInDays/30;
		
		drawButton(canvas,ageChale,canvasWidth/2,canvasHeight-ageChale.getHeight()*2);
	}

	ObjectMove moveLeftToRight,moveRightToLeft;
	int moveFrom,moveTo;
	int time;
	   
	private void scene_1(Canvas canvas) {

		canvas.drawRect(0, 0, canvasWidth, canvasHeight, paintWhite);
		
		switch (subSwichIndex) {
		case 0:
			moveLeftToRight=new ObjectMove(context,0,(int)(400* GlobalVariables.xScale_factor));
			moveRightToLeft=new ObjectMove(context,canvasWidth-(int)(100*GlobalVariables.xScale_factor),canvasWidth/2);
			xDpi=(float)link3_8a.getWidth()/canvasWidth;
			yDpi=(float)link3_8a.getHeight()/canvasHeight;
			xMultiplyer=xDpi*yDpi;
			yMultiplyer=xDpi*yDpi;
			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+(int)(20*GlobalVariables.xScale_factor),(int)(60*GlobalVariables.yScale_factor)+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+(int)(20*GlobalVariables.xScale_factor),(int)(60*GlobalVariables.yScale_factor)+canvasHeight/2+link3_8a.getHeight()/2-yScale);
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			if(threadTimeController>20){
				threadTimeController=0;
				subSwichIndex=1;
			}
			break;
		case 1:
			mySound.playSound( R.raw.a);

			if(threadTimeController<38){
			xScale+=((int)(40*GlobalVariables.xScale_factor))*xMultiplyer;
			yScale+=((int)(40*GlobalVariables.yScale_factor))*yMultiplyer;
			}
//			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+20,60+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+20,60+canvasHeight/2+link3_8a.getHeight()/2-yScale);
            imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+(int)(20*GlobalVariables.xScale_factor),(int)(60*GlobalVariables.yScale_factor)+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+(int)(20*GlobalVariables.xScale_factor),(int)(60*GlobalVariables.yScale_factor)+canvasHeight/2+link3_8a.getHeight()/2-yScale);
            myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);

//			if(threadTimeController>50){
//				subSwichIndex=2;
//				threadTimeController=0;
//				xPoint=0;
////				mediaPlayerIntro.stop();
////				mediaPlayerIntro.release();
//				mySound.stopSound();
//			}

            if(mySound.timerControllerMediaPlayer){//by Faiyaz
                subSwichIndex=2;
                threadTimeController=0;
                xPoint=0;
//				mediaPlayerIntro.stop();
//				mediaPlayerIntro.release();
                mySound.stopSound();
            }

			break;
		case 2:
			yPoint=(int)(145*GlobalVariables.yScale_factor);
			mySound.playSound(R.raw.b);
			moveFrom=canvasWidth;
			moveTo=canvasWidth/2;
			if(xPoint<moveTo&&threadTimeController%7==0){
				time++;
				xPoint+=(int)(68*GlobalVariables.xScale_factor);
			}
			if(time%2==0)link3_8bSpriteIndex=1;
			else link3_8bSpriteIndex=0;

			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController%10==0)
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, link3_8bSpriteIndex, canvasWidth-(int)xPoint,(int)yPoint, null);
//			else 
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas,link3_8bSpriteIndex, canvasWidth-(int)xPoint,(int)yPoint, null);
			
			if(xPoint>moveTo){
				threadTimeController=0;
				subSwichIndex=3;
				mySound.stopSound();
			}
			break;
		case 3:
			mySound.playSound(R.raw.c);
 
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			moveLeftToRight.MoveImageHorizontallyNew(canvas, link3_8c,(int)(345*GlobalVariables.yScale_factor),1,20, null);
			int motion=moveRightToLeft.MoveImageHorizontallyNew(canvas, link3_8d,(int)(345*GlobalVariables.yScale_factor),2,30, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			
			if(motion==0){
				subSwichIndex=4;
				threadTimeController=0;
//				mediaPlayerIntro.stop();
//				mediaPlayerIntro.release();
				mySound.stopSound();
			}
			break;
		case 4:
//			mediaPlayerIntro=MediaPlayer.create(context, R.raw.c);
//			mediaPlayerIntro.start();
			
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			if(threadTimeController<10)link3_8eSpriteIndex=0;
			else link3_8eSpriteIndex=1;
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			if(threadTimeController>20){
				threadTimeController=0;
				subSwichIndex=5;
//				mediaPlayerIntro.stop();
//				mediaPlayerIntro.release();
			}
			break;
		case 5:
//			mediaPlayerIntro=MediaPlayer.create(context, R.raw.d);
//			mediaPlayerIntro.start();
			mySound.playSound(R.raw.d);
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			if(threadTimeController>0&threadTimeController<10)link3_8fSpriteIndex=0;
			else if(threadTimeController>10&threadTimeController<20)link3_8fSpriteIndex=1;
			else if(threadTimeController>20&threadTimeController<30)link3_8fSpriteIndex=0;
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(25*GlobalVariables.xScale_factor), 0, null);
			if(threadTimeController>40){
				threadTimeController=0;
				subSwichIndex=6;
				mySound.stopSound();
			}
			break;
		case 6:
			mySound.playSound(R.raw.e);
			if(threadTimeController%2==0){
				if(link3_8gSpriteIndex<link3_8gSpriteObj.getNoOfImagesInSprite()-1)link3_8gSpriteIndex++;
			}
			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null);
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(25*GlobalVariables.xScale_factor), 0, null);
				
			if(threadTimeController>10){
				threadTimeController=0;
				subSwichIndex=7;
				mySound.stopSound();
			}
			break;
		case 7:
			mySound.playSound(R.raw.f);
			if(threadTimeController%2==0){
				if(link3_8hSpriteIndex<link3_8hSpriteObj.getNoOfImagesInSprite()-1)link3_8hSpriteIndex++;
			}
			link3_8hSpriteObj.drawSpriteAtExactPosition(canvas, link3_8hSpriteIndex, canvasWidth/2-link3_8h.getWidth()/12, 0, null); // bottom text
			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null); // background
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(25*GlobalVariables.xScale_factor), 0, null);
			if(threadTimeController>20){
				
				threadTimeController=0;
				subSwichIndex=8;
//			    whichScene=2;
			}
			break;
		case 8:
			myConstantObj.drawBackground(canvas,backGround);
			link3_8hSpriteObj.drawSpriteAtExactPosition(canvas, link3_8hSpriteIndex, canvasWidth/2-link3_8h.getWidth()/12, 0, null); // bottom text
			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null); // background
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(25*GlobalVariables.xScale_factor), 0, null);
        if(threadTimeController==40){
				threadTimeController=0;
//				if(canvas!=null)scene_2_for_Calander(canvas);
			    whichScene=2;
//			    sleepTime=100; 
			}
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;

		default:
			break;
		}
		
	}

//	public void drawEyesSprite(Canvas canvas) {
//		
//		if(threadTimeController%150<95)eyesSpriteIndex=0;
//		if(threadTimeController%150>=95)eyesSpriteIndex=1;
//		if(threadTimeController%150>97)eyesSpriteIndex=2;
//		if(threadTimeController%150>100)eyesSpriteIndex=3;
//		if(threadTimeController%150>103)eyesSpriteIndex=2;
//		if(threadTimeController%150>105)eyesSpriteIndex=1;
//		if(threadTimeController%150>107)eyesSpriteIndex=0;
//		
//		spriteEyesObj.drawSprite(canvas,eyesSpriteIndex, canvasWidth/2,eyes.getHeight()/2);
//		
//	}
	
//   public void drawLipsSprite(Canvas canvas) {
//	    if(mySound.ifPlaying()==1){
//		if(threadTimeController%10==0)lipsSpriteIndex++;
//		if(lipsSpriteIndex==spriteLipsObj.getNoOfImagesInSprite())lipsSpriteIndex=0;
//		
//	    }
//	}
	

	private void drawButton(Canvas canvas, Bitmap btnBitmap,int xMidPosition, int yMidPosition){
		if(!btnBitmap.isRecycled()){
		ageChaleRectF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,null,ageChaleRectF,null);
		}
	}
	
	private void drawImageWithRectF(Canvas canvas,RectF imageRectF,Bitmap image) {
		Rect  btnBitmapS=new Rect(0,0,image.getWidth(),image.getHeight());
		canvas.drawBitmap(image,btnBitmapS,imageRectF,null);
	}

//	public void drawBackground(Canvas canvas, Bitmap backGround) {
//		Rect  backGroundS=new Rect(0,0,backGround.getWidth(),backGround.getHeight());
//		RectF backGroundF=new RectF(0,0,canvasWidth,canvasHeight);
//		canvas.drawBitmap(backGround,backGroundS,backGroundF,null);
//	}

	@Override
	public boolean onTouchEvent(MotionEvent event ) {
		RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
		
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			if(LockF!=null&&LockF.intersect(touchrecF)){
				Intent intent=new Intent();
				intent.setClass(context,Login.class);
				((Activity)context).startActivity(intent);
			}

			switch(whichScene){
			case 2:
//				if(dayUpF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//					if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<31)day++;
//					else if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<30)day++;
//					else if((month==1&&year%4==0)&&day<29)day++;
//					else if((month==1)&&day<28)day++;
//					else day=1;
//				}
//				if(dayDownF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//					if(day>1)day--;
//					else{
//						  if(month==0||month==2||month==4||month==6||month==7||month==9||month==11)day=31;
//						  else if(month==3||month==5||month==8||month==6||month==10)day=30;
//						  else if(month==1&&year%4==0)day=29;
//						  else if(month==1)day=28;
//					    }
//				}
//				if(monthUpF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//						if(month<11)month++;
//						else month=0;
//
//						if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
//						else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
//						else if((month==1&&year%4==0)&&day>29)day=29;
//						else if((month==1)&&day>28)day=28;
//				}
//				if(monthDownF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//					if(month>0)month--;
//					else month=11;
//
//					if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
//					else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
//					else if((month==1&&year%4==0)&&day>29)day=29;
//					else if((month==1)&&day>28)day=28;
//
//				}
//				if(yearUpF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//					if(year<calendar.get(Calendar.YEAR))year++;
//				}
//				if(yearDownF.intersect(touchrecF)){
//					mediaPlayerTouch.start();
//					if(year>0)year--;
//				}
				if(ageChaleRectF!=null&&ageChaleRectF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					Constant.DAYS=day;
					Constant.MONTHS=month+1;
					Constant.YEARS=year;
					whichScene=3;
					threadTimeController=0;
				}
////////////////veson show ///////////////////////////////
				if( new RectF(0,0,100,100).intersect(touchrecF)){
                      versonShow++;
				}
				//////////////////////////////////////////////////
//				if(datef!=null&&datef.intersect(touchrecF)){
//                    showDialogGameCompleted();
//				}
                //by shah
                if(datef!=null&&datef.intersect(touchrecF)){
                   setDate();
				}
				break;
			case 3:

				if(ageChaleRectF!=null&&ageChaleRectF.intersect(touchrecF)){
					if(Constant.AGEINMONTHS>=6&&storyOK){
						mediaPlayerTouch.start();
						whichScene=4;
						TF=false;
						gameThread=null;
						getHandler().removeCallbacks(this);
						((Activity)context).setResult(Activity.RESULT_CANCELED);
						((Activity)context).finish();
						clearAll();
					}else if(Constant.AGEINMONTHS<6&&storyOK){
						mediaPlayerTouch.start();
						whichScene=4;
						TF=false;
						gameThread=null;
						getHandler().removeCallbacks(this);
						((Activity)context).setResult(Activity.RESULT_OK);
						((Activity)context).finish();
						clearAll();
					}
				}
			case 4:
				break;
			case 5:
				break;
			}
			break;
//		case MotionEvent.
		case MotionEvent.ACTION_MOVE:
			switch(whichScene){
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
	         break;
	         
		case MotionEvent.ACTION_POINTER_DOWN:
			
			switch(whichScene){
			case 0:
				
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
	         break;
	         
		case MotionEvent.ACTION_POINTER_UP:
			switch(whichScene){
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
	         break;
		default:
		}

//		if(whichScene==2){
//			if(dayUpF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<31)day++;
//				else if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<30)day++;
//				else if((month==1&&year%4==0)&&day<29)day++;
//				else if((month==1)&&day<28)day++;
//				else day=1;
//			}
//			if(dayDownF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				if(day>1)day--;
//				else{
//					  if(month==0||month==2||month==4||month==6||month==7||month==9||month==11)day=31;
//					  else if(month==3||month==5||month==8||month==6||month==10)day=30;
//					  else if(month==1&&year%4==0)day=29;
//					  else if(month==1)day=28;
//				    }
//			}
//			if(monthUpF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//					if(month<11)month++;
//					else month=0;
//					
//					if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
//					else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
//					else if((month==1&&year%4==0)&&day>29)day=29;
//					else if((month==1)&&day>28)day=28;
//			}
//			if(monthDownF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				if(month>0)month--;
//				else month=11;
//				
//				if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
//				else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
//				else if((month==1&&year%4==0)&&day>29)day=29;
//				else if((month==1)&&day>28)day=28;
//				
//			}
//			if(yearUpF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				if(year<calendar.get(Calendar.YEAR))year++;
//				
//			}
//			if(yearDownF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				if(year>0)year--;
//			}
//			if(ageChaleRectF!=null&&ageChaleRectF.intersect(touchrecF)){
//				mediaPlayerTouch.start();
//				Constant.DAYS=day;
//				Constant.MONTHS=month+1;
//				Constant.YEARS=year;
//				whichScene=3;
//				threadTimeController=0;
//
//			}
//			
//		}
		
        return true;
	}
	
	final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
	    public void onLongPress(MotionEvent e) {
	        Log.e("", "Longpress detected");
	    }
	});

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.e("SurfaceView","surfaceChanged");
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		TF=true;
		gameThread = new GameThread(getHolder(), this);
		gameThread.start();
		Log.e("SurfaceView","surfaceCreated");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
//		whichScene=3;
		TF=false;
		gameThread=null;
//		getHandler().removeCallbacks(this);
//		Log.e("surfaceDestroyed","DOBCanvas");
//		((Activity)context).setResult(Constant.CLOSE_WITH_MESSAGE);
//		((Activity)context).finish();
//		clearAll();
		
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		DOBCanvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,DOBCanvas mycanvas) {
			// TODO Auto-generated constructor stub
			_suHolder = surfaceHolder;
			_myMycanvas = mycanvas;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			super.run();
			Canvas canvas;
			while (TF) {
				canvas =null;
				try {
					
					canvas =_suHolder.lockCanvas(null);
					synchronized (_suHolder) {
						if(TF){
						_myMycanvas.onDraw(canvas);
						}
					}
					try {
						Thread.sleep(sleepTime);
						threadTimeController++;
						if(threadTimeController>999)threadTimeController=1;
					} catch (InterruptedException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally{
					//TODO: handle exception
					if(canvas!=null)
					_suHolder.unlockCanvasAndPost(canvas);
				}
				
			}
			
			
		}
		
	}
	
	boolean initialiseThreadLoad=true;
	Thread localThread=null;
	public void loadImages(){
		if(initialiseThreadLoad){
		   localThread=new Thread(this);
		   localThread.start();
		   initialiseThreadLoad=false;
			}
	}
	
	 Bitmap link1_14a;
	 Bitmap link1_14b;
	    Sprite spritelink1_14bObj;
	    int link1_14bSpriteIndex;
	    
	    Bitmap link1_15a,link1_15b;
	    Sprite spritelink1_15bObj;
	    int link1_15bSpriteIndex;

	     Bitmap dateBackground;
	     Bitmap lockImage;
	     
	        Bitmap link3_8;
			Bitmap link3_8a;
			
			Bitmap link3_8b;
			Sprite link3_8bSpriteObj;
			int link3_8bSpriteIndex;
			
			Bitmap link3_8c;
			Bitmap link3_8d;
			
			Bitmap link3_8e;
			Sprite link3_8eSpriteObj;
			int link3_8eSpriteIndex;
			
			Bitmap link3_8f;
			Sprite link3_8fSpriteObj;
			int link3_8fSpriteIndex;
			
			Bitmap link3_8g;
			Sprite link3_8gSpriteObj;
			int link3_8gSpriteIndex;
			
			Bitmap link3_8h;
			Sprite link3_8hSpriteObj;
			int link3_8hSpriteIndex;
			
	     
	@Override
	public void run() {
		dateBackground= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.date_background);
		ageChale= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
		numberSprite= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.numbers);
//		triangleUp= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.triangle_up);
//		triangleDown= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.triangle_down);
		janamtithiImage=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.tithi);
		link1_4a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4a);
		link1_4b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4b);
		lockImage= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lock);
		spriteNumberArrayObj= new Sprite[8];
		calendar2.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
		spriteNumberArrayObj[0]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[1]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[2]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[3]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[4]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[5]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[6]=new Sprite(numberSprite,10);
		spriteNumberArrayObj[7]=new Sprite(numberSprite,10);
		
		spritelink1_4bObj=new Sprite(link1_4b,2);
		
		link3_8a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8a);
		link3_8b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8b);
		link3_8c=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8c);
		link3_8d=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8d);
		link3_8e=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8e);
		link3_8f=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8f);
		link3_8g=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8g);
		link3_8h=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_8h);
		
		link3_8bSpriteObj=new Sprite(link3_8b, 2);
		link3_8eSpriteObj=new Sprite(link3_8e, 2);
		link3_8fSpriteObj=new Sprite(link3_8f, 2);
		link3_8gSpriteObj=new Sprite(link3_8g, 4);
		link3_8hSpriteObj=new Sprite(link3_8h, 6);

//		spritelink1_7aObj=new ShahSprite(link1_7a,3);
//		spritelink1_7bObj=new ShahSprite(link1_7b,3);
		
//		spritelink1_8aObj=new ShahSprite(link1_8a,2);
//		spritelink1_8bObj=new ShahSprite(link1_8b,2);
//		
//		spritelink1_14bObj=new ShahSprite(link1_14b,6);
//		spritelink1_15bObj=new ShahSprite(link1_15b,6);

		whichScene=1;
		subSwichIndex=0;
		threadTimeController=1;

	}
	
    public void clearAll(){
        if(dateBackground!=null&&!dateBackground.isRecycled())dateBackground.recycle();

        if(ageChale!=null&&!ageChale.isRecycled())ageChale.recycle();
        if(numberSprite!=null&&!numberSprite.isRecycled())numberSprite.recycle();numberSprite.recycle();
        if(janamtithiImage!=null&&!janamtithiImage.isRecycled())janamtithiImage.recycle();janamtithiImage.recycle();
        if(link1_4a!=null&&!link1_4a.isRecycled())link1_4a.recycle();
        if(link1_4b!=null&&!link1_4b.isRecycled())link1_4b.recycle();
        if(link3_8a!=null&&!link3_8a.isRecycled())link3_8a.recycle();
        if(link3_8b!=null&&!link3_8b.isRecycled())link3_8b.recycle();
        if(link3_8c!=null&&!link3_8c.isRecycled())link3_8c.recycle();
        if(link3_8d!=null&&!link3_8d.isRecycled())link3_8d.recycle();
        if(link3_8e!=null&&!link3_8e.isRecycled())link3_8e.recycle();
        if(link3_8f!=null&&!link3_8f.isRecycled())link3_8f.recycle();
        if(link3_8g!=null&&!link3_8g.isRecycled())link3_8g.recycle();
        if(link3_8h!=null&&!link3_8h.isRecycled())link3_8h.recycle();

 		spriteNumberArrayObj=null;
 		spritelink1_4bObj=null;
 		
	}

	@Override
	public boolean onLongClick(View v) {
		
		return false;
	}

//public  void showDialogGameCompleted() {
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
//			day=arg3;
//			month=arg2;
//			year =arg1;
////			Toast.makeText(context, "ca="+arg1+"/"+arg2+"/"+arg3, Toast.LENGTH_SHORT)
////		      .show();
//		}
//	};
@SuppressWarnings("deprecation")
public void setDate(){
    AlertDialog dialog=null;

    datePicker = new DatePicker(context);
//    datePicker.setCalendarViewShown(false);
    ////////////////////shah////////////////
    String monthPickerVarName;
//    String months[] =  context.getResources().getStringArray(R.array.short_months);
    String months[] =  {
//            "जन","फ़र",
//            "मार्च","अप्रै",
//            "मई","जून",
//            "जुला","अग",
//            "सितं","अक्तू",
//            "नवं","दिसं"
            "जनवरी","फरवरी",
            "मार्च","अप्रैल",
            "मई","जून",
            "जुलाई","अगस्त",
            "सितम्बर","अक्तूबर",
            "नवम्बर","दिसम्बर"
    };

    if (Build.VERSION.SDK_INT >= 14) {
        monthPickerVarName = "mMonthSpinner";
    } else {
        monthPickerVarName = "mMonthPicker";
    }

    try {
        Field f[] = datePicker.getClass().getDeclaredFields();

        for (Field field : f) {
            if (field.getName().equals("mShortMonths")) {
                field.setAccessible(true);
                field.set(datePicker, months);
            } else if (field.getName().equals(monthPickerVarName)) {
                field.setAccessible(true);
                Object o = field.get(datePicker);
                if (Build.VERSION.SDK_INT >= 14) {
                    Method m = o.getClass().getDeclaredMethod("setDisplayedValues", String[].class);
                    m.setAccessible(true);
                    m.invoke(o, (Object)months);
                } else {
                    Method m = o.getClass().getDeclaredMethod("setRange", int.class, int.class, String[].class);
                    m.setAccessible(true);
                    m.invoke(o, 1, 12, (Object)months);
                }
            }
        }
//        for (Field field : f) {
//            if (field.getName().equals("mMonthName")) {
//                field.setAccessible(true);
//            }
//        }

    } catch (Exception e) {
        Log.e("wow", e.getMessage(), e);
    }

    try {
        final Method updateSpinner = datePicker.getClass().getDeclaredMethod("updateSpinners");
        updateSpinner.setAccessible(true);
        updateSpinner.setAccessible(false);

    } catch (Exception e) {
        Log.e("wow", e.getMessage(), e);
    }
    // //////////////////shah////////////////
    CalendarView calendarView = datePicker.getCalendarView();
//    DateFormatSymbols

//    java.lang.reflect.Field monthFieldName = null;
//    try {
//        Class<?> monthClass =Class.forName("DateFormatSymbols");
//        monthFieldName=monthClass.getDeclaredField("months");
//        monthFieldName.setAccessible(true);
//        Object o = monthFieldName.get(monthClass);
//        Method m = o.getClass().getDeclaredMethod("setMonths", String[].class);
//        m.setAccessible(true);
//        m.invoke(o, (Object)months);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }

//******************************************
    java.lang.reflect.Field field = null;
    java.lang.reflect.Field mMonthNamefield = null;
    Class<?> cvClass = calendarView.getClass();
    try {
        field = cvClass.getDeclaredField("mDayNamesHeader");
        mMonthNamefield = cvClass.getDeclaredField("mMonthName");
        Field[] f = cvClass.getDeclaredFields();
        field.setAccessible(true);
        mMonthNamefield.setAccessible(true);
    } catch (NoSuchFieldException e) {
    }
//    name = "mMonthName"
    ViewGroup tv = null;
//    TextView mMonthNameTv=null;
    try {
        tv = (ViewGroup) field.get(calendarView);
         mMonthNameTv = (TextView) mMonthNamefield.get(calendarView);
//         mMonthNameTv.setText("मार्च 2015");
    } catch (IllegalAccessException e) {}

//   new Thread(new Runnable() {
//       @Override
//       public void run() {
//          while (true){
//              try {
//                  mMonthNameTv.setText("मार्च 2015");
//                  Thread.sleep(100);
//              } catch (InterruptedException e) {
//                  e.printStackTrace();
//              }
//          }
//       }
//   }).start();
//    calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//        @Override
//        public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
//            mMonthNameTv.setText("मार्च 2015");
//        }
//    });
//    calendarView.setOnClickListener(new OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            mMonthNameTv.setText("मार्च 2015");
//        }
//    });
//   calendarView.setOnDragListener(new OnDragListener() {
//       @Override
//       public boolean onDrag(View view, DragEvent dragEvent) {
//           mMonthNameTv.setText("मार्च 2015");
//           return false;
//       }
//   });
//    calendarView.setOnTouchListener(new OnTouchListener() {
//        @Override
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            mMonthNameTv.setText("मार्च 2015");
//            return false;
//        }
//    });


    TextView k =  (TextView) tv.getChildAt(1);
    k.setText("रवि");
    k.setTextColor(Color.WHITE);

    TextView k1 =  (TextView) tv.getChildAt(2);
    k1.setText("सोम");
    k1.setTextColor(Color.WHITE);

    TextView k2 =  (TextView) tv.getChildAt(3);
    k2.setText("मंगल");
    k2.setTextColor(Color.WHITE);

    TextView k3=  (TextView) tv.getChildAt(4);
    k3.setText("बुध");
    k3.setTextColor(Color.WHITE);

    TextView k4 =  (TextView) tv.getChildAt(5);
    k4.setText("गुरु");
    k4.setTextColor(Color.WHITE);

    TextView k5 =  (TextView) tv.getChildAt(6);
    k5.setText("शुक्र");
    k5.setTextColor(Color.WHITE);

    TextView k6 =  (TextView) tv.getChildAt(7);
    k6.setText("शनि");
    k6.setTextColor(Color.WHITE);


    Bitmap dates_bg_nwTemp=Constant.decodeSampledBitmapFromResource(context.getResources(), R.drawable.dates_bg_nw);
    Drawable dates_bg_nwnew =new BitmapDrawable(context.getResources(), dates_bg_nwTemp);
    datePicker.setBackground(dates_bg_nwnew);
//    datePicker.setBackground(context.getResources().getDrawable(
//            R.drawable.dates_bg_nw));


    //**********************************
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);

    //builder .setMessage("The content");
//		     ImageView imageView = new ImageView(context);
//		     imageView.setBackgroundResource(R.drawable.set_cancel_bg);
//
//		     imageView.setLayoutParams(params);
    dialog= builder .create();
    //************************************************
    dialog.setButton2("रद्द करें", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            year = calendar.get(Calendar.YEAR);
            month =calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }
    });

    dialog.setButton3("सेट करें", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            day = datePicker.getDayOfMonth();
            month = datePicker.getMonth() ;
            year = datePicker.getYear();
        }
    });

    //*****************************
    LinearLayout layout=new LinearLayout(context);
    layout.setLayoutParams(params);

    Bitmap set_cancel_bgTemp=Constant.decodeSampledBitmapFromResource(context.getResources(), R.drawable.set_cancel_bg);
    Drawable set_cancel_bg =new BitmapDrawable(context.getResources(), set_cancel_bgTemp);
    layout.setBackground(set_cancel_bg);
//    layout.setBackgroundResource(R.drawable.set_cancel_bg);
    layout.setGravity(Gravity.CENTER);
    TextView textView=new TextView(context);
    textView.setText("जन्म तिथि चुने");
    textView.setTextSize(20);
    textView.setTextColor(Color.WHITE);
    layout.addView(textView);

    //dialog.setTitle("Set Date");
    dialog.setCustomTitle(layout);
    dialog.setView(datePicker);

    //*******************************************
    LinearLayout llFirst = (LinearLayout) datePicker.getChildAt(0);
    LinearLayout llSecond = (LinearLayout) llFirst.getChildAt(0);
    for (int i = 0; i < llSecond.getChildCount(); i++) {
        NumberPicker npicker = (NumberPicker) llSecond.getChildAt(i); // Numberpickers in llSecond
        // reflection - picker.setDividerDrawable(divider); << didn't seem to work.
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    pf.set(npicker, context.getResources().getDrawable(R.drawable.divider));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();

                }
                break;
            }
        }
    }

    //********************************************
    calendarView.setWeekSeparatorLineColor(Color.TRANSPARENT);
    calendarView.setWeekNumberColor(Color.TRANSPARENT);
    calendarView.setUnfocusedMonthDateColor(Color.parseColor("#a89a8b"));
    calendarView.setFocusedMonthDateColor(Color.WHITE);
    calendarView.setSelectedWeekBackgroundColor(Color
            .parseColor("#10aa7243"));
    calendarView.setSelectedDateVerticalBar(R.drawable.line_nw);

    //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.show();

    Bitmap set_cancel_bg_nwTemp=Constant.decodeSampledBitmapFromResource(context.getResources(), R.drawable.set_cancel_bg_nw);
    Drawable set_cancel_bg_nw =new BitmapDrawable(context.getResources(), set_cancel_bg_nwTemp);

    Button b = dialog.getButton(AlertDialog.BUTTON2);
    b.setBackground(set_cancel_bg_nw);
//    b.setBackground(context.getResources().getDrawable(R.drawable.set_cancel_bg_nw));
    b.setTextSize(20);
    b.setTextColor(Color.WHITE);

    Button b1 = dialog.getButton(AlertDialog.BUTTON3);
    b1.setBackground(set_cancel_bg_nw);
//    b1.setBackground(context.getResources().getDrawable(
//            R.drawable.set_cancel_bg_nw));
    b1.setTextSize(20);
    b1.setTextColor(Color.WHITE);

    //*****************************Header Divider
    int dividerId = context.getResources().getIdentifier("android:id/titleDivider", null, null);
    View divider = dialog.findViewById(dividerId);
    divider.setBackgroundResource(R.drawable.divider);
    //dialog.getListView().addFooterView(divider);


// ************** change size of calendar date......
    int dividerId1 = context.getResources().getIdentifier(
            "android:style/TextAppearance.Medium", null, null);
    calendarView.setDateTextAppearance(dividerId1);

}

public void changeLocale(){
    Locale locale = new Locale("hi");

    Class amnClass = null;
    try {
        amnClass = Class.forName("android.app.ActivityManagerNative");

    Object amn = null;
    Configuration config = null;

    // amn = ActivityManagerNative.getDefault();
    Method methodGetDefault = amnClass.getMethod("getDefault");
    methodGetDefault.setAccessible(true);
    amn = methodGetDefault.invoke(amnClass);

    // config = amn.getConfiguration();
    Method methodGetConfiguration = amnClass.getMethod("getConfiguration");
    methodGetConfiguration.setAccessible(true);
    config = (Configuration) methodGetConfiguration.invoke(amn);

    // config.userSetLocale = true;
    Class configClass = config.getClass();
    Field f = configClass.getField("userSetLocale");
    f.setBoolean(config, true);

    // set the locale to the new value
    config.locale = locale;

    // amn.updateConfiguration(config);
    Method methodUpdateConfiguration = amnClass.getMethod("updateConfiguration", Configuration.class);
    methodUpdateConfiguration.setAccessible(true);
    methodUpdateConfiguration.invoke(amn, config);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

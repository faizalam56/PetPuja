package com.abdullah.canvas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.ObjectFall;
import com.abdullah.petpuja.ObjectMove;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.VedioPlay;
import com.abdullah.petpuja.ZoomInZoomOut;
import com.zmq.utility.GlobalVariables;

import android.animation.AnimatorSet.Builder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart_1_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	int timeInSecond=0;
	int zoomIn,ZoomOut=200;
	float xDpi,yDpi;
	float xScale,yScale;
	float xMultiplyer,yMultiplyer;
	int lineLength=0;
	Bitmap waitingStar,girl1,backGround,ageChale,sprite,numberSprite,triangleUp,triangleDown,image4;
	Bitmap link1_1a,link1_2a,link1_3a;
	private RectF ageChaleRectF,imageRectF;
	private RectF dayUpF,dayDownF,monthUpF,monthDownF,yearUpF,yearDownF;
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
	int whichScene=-1,subSwichIndex=0;
	int threadTimeController=1;
	int sleepTime=5;
	
	Sprite[] spriteNumberArrayObj;
	int day,month,year;
	
	Calendar calendar,calendar2;
	
	ObjectFall fallObj;
	ObjectMove moveObj;
	Constant myConstantObj;
    Sound mySound;
	
    
    Bitmap eyes;
    Sprite spriteEyesObj;
    int eyesSpriteIndex;
    
    Bitmap lips;
    Sprite spriteLipsObj;
    int lipsSpriteIndex;
    
    Bitmap link1_4a,link1_4b;
    Sprite spritelink1_4bObj;
    int link1_4bSpriteIndex;
    
    
    Bitmap link1_5a,link1_5b;
    
    Bitmap link1_6a;
    
    Bitmap link1_7a1,link1_7a2,link1_7a3,link1_7b1,link1_7b2;

    
    Bitmap link1_8a,link1_8b;
    Sprite spritelink1_8aObj,spritelink1_8bObj;
    int link1_8aSpriteIndex,link1_8bSpriteIndex;
    
    Bitmap link1_9a;
    
    Bitmap link1_10a;
   
    
    Bitmap link1_11a,link1_11b;
    
    Bitmap link1_12a;
    
    Bitmap link1_13a,link1_13b;
    
   
    

    Sprite spritelink1_15aObj;
    int link1_15aSpriteIndex;
    
    Bitmap link1_16a;
    Bitmap link1_17a,link1_17b;
   
    
   
    
    Paint paintfadeInOut,paintWhite;
    int fadeInOutIndex=0;
    
	    public StoryPart_1_Canvas(Context context) {
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
//		paintWhite.set
		
		
		mySound=new Sound(context);
		myConstantObj=new Constant(context);
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		myConstantObj.drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
		
		
		if(Constant.HEADER==1){
		myConstantObj.drawText(canvas,"SCENE NO : "+whichScene +"."+subSwichIndex,100,100,30);
		myConstantObj.drawText(canvas,"threreadTimeController : "+threadTimeController,100,200,30);
		myConstantObj.drawText(canvas,"yScale : "+yScale,canvasWidth-200,200,30);
		}
	}

	
	
	
	private void drawAnimation(Canvas canvas,int whichScene) {
	  
		switch(whichScene){
		case -1:
			myConstantObj.drawImageWithRotation(canvas);
	        loadImages();
			break;
		case 0:
			scene_0(canvas);
			break;
		case 1:
			scene_1(canvas);
			break;
		case 2:
			scene_2(canvas);
			break;
		case 3:
			scene_3(canvas);
			break;
		case 4:
			scene_4(canvas);
			break;
		case 5:
			scene_5(canvas);
			break;
		case 6:
			scene_6(canvas);
			break;
		case 7:
			scene_7(canvas);
			break;
		case 8:
			scene_8(canvas);
			break;
		case 9:
			scene_9(canvas);
			break;
		case 10:
			scene_10(canvas);
			break;
		case 11:
			scene_11(canvas);
			break;
		case 12:
			scene_12(canvas);
			break;
		case 13:
			scene_13(canvas);
			break;
		case 14:
			scene_14(canvas);
			break;
		case 15:
			scene_15(canvas);
			break;
		case 16:
			scene_16(canvas);
			break;
		case 17:
			scene_17(canvas);
			break;
//		case 18:
//			scene_18(canvas);
//			break;
		}
   
		
	}

//	private void scene_18(Canvas canvas) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
//		myConstantObj.drawImageAtExactPosition(canvas,link1_4a,0,0,null); 
//		
//		Date d;
//		try {
//			d = sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
//			Calendar now = Calendar.getInstance();    
//	        now.setTime(d);
//	        now.add(Calendar.MONTH, 6);
//	        myConstantObj.drawText(canvas,""+now.get(Calendar.DATE),200,400, 100);
//	        myConstantObj.drawText(canvas,""+(now.get(Calendar.MONTH)+1),400,400, 100);
//	        myConstantObj.drawText(canvas,""+now.get(Calendar.YEAR),645,400, 100);
//		} catch (ParseException e) {
//			
//		}
//		
//		
//    
//	
//	
//	
//	
//	
//	if(Constant.AGEINMONTHS>=6)spritelink1_4bObj.drawSpriteAtExactPosition(canvas,1,canvasWidth-link1_4b.getWidth()/2, 0,null);
//	else spritelink1_4bObj.drawSpriteAtExactPosition(canvas,0,canvasWidth-link1_4b.getWidth()/2, 0,null);
//	
////	mySound.playSound(R.raw.link1_4a); 
//	if(mySound.ifPlaying()==0){
//    	mySound.stopSound();
//    	whichScene=1;
//    }
//	
//	     drawButton(canvas,ageChale,200,canvasHeight-ageChale.getHeight()*2);
//		
//	}


	private void scene_17(Canvas canvas) {
		switch (subSwichIndex) {
		case 0:
			 mySound.playSound(R.raw.link1_17a); 
			 subSwichIndex=1;
			break;
		case 1:
			if(!link1_17a.isRecycled())
			myConstantObj.drawImageAtExactPosition(canvas, link1_17a,(int)(GlobalVariables.xScale_factor*70),0, null);
			if(!lips.isRecycled()&!link1_17a.isRecycled())
			spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(),link1_17a.getWidth()/2+(int)(GlobalVariables.xScale_factor*105),lips.getHeight()/2);
			if(!eyes.isRecycled()&!link1_17a.isRecycled())
			spriteEyesObj.drawEyesSprite(canvas,eyes,link1_17a.getWidth()/2+(int)(GlobalVariables.xScale_factor*105),eyes.getHeight()/2);
			if(!link1_17b.isRecycled()){
			imageRectF=new RectF((int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160),link1_17b.getWidth()+(int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160)+link1_17b.getHeight());
			myConstantObj.drawImageWithRectF(canvas, imageRectF, link1_17b);
			Constant.drawButtonReplay(canvas);
		  }
			break;
		default:
			break;
		}
		
		
		
		
//		if(threadTimeController>100){
////			mySound.stopSound();
////	    	whichScene=17;
//			subSwichIndex=0;
//			threadTimeController=0;
//		}
		

	}
	private void scene_16(Canvas canvas) {
		myConstantObj.drawImageAtExactPosition(canvas, link1_16a,canvasWidth/2-link1_16a.getWidth()/2,canvasHeight/2-link1_16a.getHeight()/2, null);
		 mySound.playSound(R.raw.link1_16a); 
			
			if(mySound.ifPlaying()==0){
		    	mySound.stopSound();
		    	whichScene=17;
				subSwichIndex=0;
				threadTimeController=0;
				link1_14a.recycle();
		 		link1_14b.recycle();
		 		link1_15a.recycle();
		 		link1_15b.recycle();
		 		link1_16a.recycle();
		    }
		
	}
	private void scene_15(Canvas canvas) {
		myConstantObj.drawImageAtExactPosition(canvas, link1_15a,canvasWidth/2-link1_15a.getWidth()/2,0, null);
		switch(subSwichIndex){
		case 0:
			if(threadTimeController%5==0){
				if(link1_15bSpriteIndex<spritelink1_15bObj.getNoOfImagesInSprite()-1)link1_15bSpriteIndex++;
			}
		    spritelink1_15bObj.drawSprite(canvas,link1_15bSpriteIndex, canvasWidth/2,link1_15b.getHeight()/2,null);
	        if(link1_15bSpriteIndex==spritelink1_15bObj.getNoOfImagesInSprite()-1){
	        	subSwichIndex=1;
	        	threadTimeController=0;
	        }
			break;
		case 1:
			spritelink1_15bObj.drawSprite(canvas,link1_15bSpriteIndex, canvasWidth/2,link1_15b.getHeight()/2,null);
			break;
		}
		
		spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2,lips.getHeight()/2);
		spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2,eyes.getHeight()/2);
		
		 mySound.playSound(R.raw.link1_15a); 
			
//		 if(threadTimeController>30){
//				mySound.stopSound();
//		    	whichScene=16;
//				subSwichIndex=0;
//				threadTimeController=0;
//			}

        if(mySound.timerControllerMediaPlayer){
            mySound.stopSound();
            whichScene=16;
            subSwichIndex=0;
            threadTimeController=0;
        }
		
	}
	private void scene_14(Canvas canvas) {
		
	    	myConstantObj.drawImageAtExactPosition(canvas, link1_14a,canvasWidth/2-link1_14a.getWidth()/2,0, null);
			switch(subSwichIndex){
			case 0:
				if(threadTimeController%3==0){
					if(link1_14bSpriteIndex<spritelink1_14bObj.getNoOfImagesInSprite()-1)link1_14bSpriteIndex++;
				}
			    spritelink1_14bObj.drawSprite(canvas,link1_14bSpriteIndex, canvasWidth/2,link1_14b.getHeight()/2,null);
		        if(link1_14bSpriteIndex==spritelink1_14bObj.getNoOfImagesInSprite()-1){
		        	subSwichIndex=1;
		        	threadTimeController=0;
		        }
				break;
			case 1:
				spritelink1_14bObj.drawSprite(canvas,link1_14bSpriteIndex, canvasWidth/2,link1_14b.getHeight()/2,null);
				break;
			}
			
			spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2,lips.getHeight()/2);
			spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2,eyes.getHeight()/2);
			
			 mySound.playSound(R.raw.link1_14a); 
				
				if(mySound.ifPlaying()==0){
					
			    }
//				if(threadTimeController>20){
//					mySound.stopSound();
//			    	whichScene=15;
//					subSwichIndex=0;
//					threadTimeController=0;
//					link1_13a.recycle();
//			 		link1_13b.recycle();
//				}

        if(mySound.timerControllerMediaPlayer){
            mySound.stopSound();
            whichScene=15;
            subSwichIndex=0;
            threadTimeController=0;
            link1_13a.recycle();
            link1_13b.recycle();
        }

	
	}
	private void scene_13(Canvas canvas) {
		
		 mySound.playSound(R.raw.link1_13a); 
		
		switch (subSwichIndex) {
		case 0:
			myConstantObj.drawImageAtExactPosition(canvas, link1_13a, 0, 0, null);
			if(threadTimeController>5){
				fallObj=new ObjectFall(context,-link1_13b.getHeight(),(int)(GlobalVariables.yScale_factor*60));
				threadTimeController=0;
				subSwichIndex=1;
			}
			break;
		case 1:
			myConstantObj.drawImageAtExactPosition(canvas, link1_13a, 0, 0, null);
			timeInSecond++;
			fallObj.fallImageVertically(canvas, link1_13b, (int)(GlobalVariables.xScale_factor*760),0,timeInSecond,null);
			if(mySound.ifPlaying()==0){
				threadTimeController=0;
				subSwichIndex=0;
				mySound.stopSound();
				link1_12a.recycle();
		 		
				whichScene=14;
			}
			break;
		case 2:
			
			break;

		default:
			break;
		}
	}
	private void scene_12(Canvas canvas) {
		
		 myConstantObj.drawImageAtExactPosition(canvas, link1_11a, 0, 0, null);
		 myConstantObj.drawImageAtExactPosition(canvas,link1_11b,(int)(GlobalVariables.xScale_factor*515),(int)(GlobalVariables.yScale_factor*335),null);
//		myConstantObj.drawImageAtExactPosition(canvas,link1_12a,canvasWidth-link1_12a.getWidth(),0,null);
		int val=zio.zoomOut(null);
		mySound.playSound(R.raw.link1_12a); 
		
			if(mySound.ifPlaying()==0){
		    	mySound.stopSound();
		    	subSwichIndex=0;
		    	threadTimeController=0;
		    	link1_11a.recycle();
		 		link1_11b.recycle();
		 		
				whichScene=13;
		    }
	}
	private void scene_11(Canvas canvas) {
//		myConstantObj.drawImageAtExactPosition(canvas, link1_11a, 0, 0, null);
		int val=zio.zoomOut(null);
//		if(threadTimeController>100)
		 

		     mySound.playSound(R.raw.link1_11a); 
			
			if(val==0){
				 myConstantObj.drawImageAtExactPosition(canvas,link1_11b,(int)(GlobalVariables.xScale_factor*515),(int)(GlobalVariables.yScale_factor*335),null);
		    }
			
			if(mySound.ifPlaying()==0){
				 mySound.stopSound();
			     threadTimeController=0;
			     whichScene=12;
			 	link1_8a.recycle();
		 		link1_8b.recycle();
		 		link1_9a.recycle();
		 		link1_10a.recycle();

		 		
			        link1_14a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14a);
					link1_14b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14b);
					link1_15a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15a);
					link1_15b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15b);
					link1_16a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_16a);
					link1_17a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
					link1_17b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17b);
					spritelink1_14bObj=new Sprite(link1_14b,6);
					spritelink1_15bObj=new Sprite(link1_15b,6);
			     zio=new ZoomInZoomOut(canvas, link1_12a,50,canvasWidth-link1_12a.getWidth()/2,link1_12a.getHeight()/2,10);
			     
			}
			
	}
	private void scene_10(Canvas canvas) {
		myConstantObj.drawImage(canvas,link1_10a,canvasWidth/2, canvasHeight/2,null);
		
			 mySound.playSound(R.raw.link1_10a); 
				if(mySound.ifPlaying()==0){
			    	mySound.stopSound();
			    	whichScene=11;
			    	threadTimeController=0;
			    	zio=new ZoomInZoomOut(canvas, link1_11a,50,link1_11a.getWidth()/2,link1_11a.getHeight()/2,10);
			    }
				
				spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2+(int)(GlobalVariables.xScale_factor*2),lips.getHeight()/2);
				spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2+(int)(GlobalVariables.xScale_factor*2),eyes.getHeight()/2);
	}
	
	private void scene_9(Canvas canvas){
		if(threadTimeController%10==0){
			if(link1_8bSpriteIndex==1)link1_8bSpriteIndex=0;
			else link1_8bSpriteIndex=1;
		}
		spritelink1_8bObj.drawSpriteAtExactPosition(canvas, link1_8bSpriteIndex, 0, 0, null);
		myConstantObj.drawImage(canvas,link1_9a,canvasWidth*2/3, canvasHeight/2,null);
		
		
        mySound.playSound(R.raw.link1_9a); 
		
		if(mySound.ifPlaying()==0){
	    	mySound.stopSound();
	    	threadTimeController=0;
	    	whichScene=10;
	 		link1_5a.recycle();
	 		link1_5b.recycle();
	 		link1_6a.recycle();
	 		link1_7a1.recycle();
	 		link1_7a2.recycle();
	 		link1_7a3.recycle();
	 		link1_7b1.recycle();
	 		link1_7b2.recycle();
	 		
			link1_11a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_11a);
			link1_11b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_11b);
			link1_12a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_12a);
			link1_13a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_13a);
			link1_13b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_13b);
	    }
		
	}
	
	private void scene_8(Canvas canvas) {
		
		switch(subSwichIndex){
		case 0:
			xDpi=(float)(link1_8a.getWidth()/2)/canvasWidth;
			yDpi=(float)(link1_8a.getHeight())/canvasHeight;
			xMultiplyer=xDpi*yDpi;
			yMultiplyer=xDpi*yDpi;
			xScale=0;
			yScale=0;
			yPoint=0;
			xPoint=0;
			subSwichIndex=1;
			break;
			case 1:
				mySound.playSound(R.raw.link1_8a);
				imageRectF=new RectF(canvasWidth/2-link1_8a.getWidth()/4-xScale,-yScale, canvasWidth/2+link1_8a.getWidth()/4+xScale,link1_8a.getHeight()+yScale);
				if(threadTimeController%10==0){
					if(link1_8aSpriteIndex==1)link1_8aSpriteIndex=0;
					else link1_8aSpriteIndex=1;
				}
				spritelink1_8aObj.drawSpriteByRectF(canvas, imageRectF, link1_8aSpriteIndex,null);
				if(threadTimeController==50){
					subSwichIndex=2;
					fadeInOutIndex=250;
					
				}
				break;
			case 2:
					
				if(xPoint<280){
					xScale-=30*xMultiplyer;
					yScale-=30*yMultiplyer;
					xPoint+=10;
					yPoint+=5;
				}
				imageRectF=new RectF(canvasWidth/2-link1_8a.getWidth()/4-xPoint-xScale/2,-yPoint-yScale/2, canvasWidth/2+link1_8a.getWidth()/4+xScale/2-xPoint,link1_8a.getHeight()+yScale/2-yPoint);
	            
				if(threadTimeController%10==0){
					if(link1_8aSpriteIndex==1)link1_8aSpriteIndex=0;
					else link1_8aSpriteIndex=1;
				}
	            
	            if(fadeInOutIndex>0)fadeInOutIndex-=10;
				paintfadeInOut.setAlpha(fadeInOutIndex);
				spritelink1_8aObj.drawSpriteByRectF(canvas, imageRectF, link1_8aSpriteIndex,paintfadeInOut);
				
				if(threadTimeController%10==0){
					if(link1_8bSpriteIndex==1)link1_8bSpriteIndex=0;
					else link1_8bSpriteIndex=1;
				}
				paintfadeInOut.setAlpha(255-fadeInOutIndex);
				spritelink1_8bObj.drawSpriteAtExactPosition(canvas,link1_8bSpriteIndex,0, 0, paintfadeInOut);
				
				if(mySound.ifPlaying()==0){
					whichScene=9;
					subSwichIndex=0;
					threadTimeController=0;
					mySound.stopSound();
					link1_7b1.recycle();
					link1_7b2.recycle();
				}
				
				break;

		}
		
	}

	private void scene_7(Canvas canvas) {
		switch(subSwichIndex){
		case 0:
			fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			mySound.playSound(R.raw.link1_7a);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a1, (int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304), paintfadeInOut);
			if(fadeInOutIndex==255){
				subSwichIndex=1;
				fadeInOutIndex=0;
			}
			break;
		case 1:
			if(fadeInOutIndex<255)fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a1,(int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304), null);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a2, (int)(GlobalVariables.xScale_factor*557), (int)(GlobalVariables.yScale_factor*240), paintfadeInOut);
			if(fadeInOutIndex==255){
				subSwichIndex=2;
				fadeInOutIndex=0;
				threadTimeController=0;
			}
			break;
		case 2:
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a1,(int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304) ,  null);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a2,(int)(GlobalVariables.xScale_factor*557),(int)(GlobalVariables.yScale_factor*240) , null);
			if(fadeInOutIndex<255)fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7a3,(int)(GlobalVariables.xScale_factor*900),(int)(GlobalVariables.yScale_factor*110), paintfadeInOut);
			if(fadeInOutIndex==255){
				if(threadTimeController>40){
					fadeInOutIndex=0;
					subSwichIndex=3;
				}
			}
			break;
		case 3:
			fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
			if(fadeInOutIndex==255){
				subSwichIndex=4;
				fadeInOutIndex=0;
			}
			break;
		case 4:
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), null);
			canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
			fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*452),(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
			if(fadeInOutIndex==255){
				subSwichIndex=5;
				fadeInOutIndex=0;
			}
			break;
		case 5:
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95) ,(int)(GlobalVariables.yScale_factor*180), null);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*452),(int)(GlobalVariables.yScale_factor*180), null);
			canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
			canvas.drawLine((int)(GlobalVariables.xScale_factor*720),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*720),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
			if(fadeInOutIndex<255)fadeInOutIndex+=15;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b2, (int)(GlobalVariables.xScale_factor*805),(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*1005) ,(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);

			if(fadeInOutIndex==255)subSwichIndex=6;
			break;
		case 6:
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), null);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*452) ,(int)(GlobalVariables.yScale_factor*180), null);
			canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
			canvas.drawLine((int)(GlobalVariables.xScale_factor*720),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*720),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*805),(int)(GlobalVariables.yScale_factor*180), null);
			myConstantObj.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*1005) ,(int)(GlobalVariables.yScale_factor*180), null);
			if(mySound.ifPlaying()==0){
				try {
					link1_7a1.recycle();
					link1_7a2.recycle();
					link1_7a3.recycle();
					link1_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_8a);
					link1_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_8b);
					spritelink1_8aObj=new Sprite(link1_8a,2);
					spritelink1_8bObj=new Sprite(link1_8b,2);
					Thread.sleep(1000);
					threadTimeController=0;
					whichScene=8;
					subSwichIndex=0;
					mySound.stopSound();
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		
	}

	private void scene_6(Canvas canvas) {
		myConstantObj.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),null);
		myConstantObj.drawImageAtExactPosition(canvas,link1_5b,(int)(GlobalVariables.xScale_factor*490),(int)(GlobalVariables.yScale_factor*335),null);
		if(fadeInOutIndex<255)fadeInOutIndex+=15;
		paintfadeInOut.setAlpha(fadeInOutIndex);
		myConstantObj.drawImageAtExactPosition(canvas,link1_6a,(int)(GlobalVariables.xScale_factor*580),(int)(GlobalVariables.yScale_factor*50),paintfadeInOut);
		mySound.playSound(R.raw.link1_6a); 
		
		if(mySound.ifPlaying()==0){
	    	mySound.stopSound();
	    	whichScene=7;
	    	fadeInOutIndex=0;
	    	link1_1a.recycle();
	 		link1_2a.recycle();
	 		link1_3a.recycle();
	 		link1_4a.recycle();
	 		link1_4b.recycle();
	    	link1_7a1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a1);
			link1_7a2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a2);
			link1_7a3= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a3);
			link1_7b1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7b1);
			link1_7b2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7b2);
			
			
	    }
	}

	
	private void scene_5(Canvas canvas) {
		mySound.playSound(R.raw.link1_5a); 
		switch (subSwichIndex) {
		case 0:
			if(fadeInOutIndex<255)fadeInOutIndex+=5;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),paintfadeInOut);
			if(fadeInOutIndex==250){
				fadeInOutIndex=0;
				subSwichIndex=1;
				
			}
			break;
		case 1:
			if(fadeInOutIndex<250)fadeInOutIndex+=10;
			paintfadeInOut.setAlpha(fadeInOutIndex);
			myConstantObj.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),null);
			myConstantObj.drawImageAtExactPosition(canvas,link1_5b,(int)(GlobalVariables.xScale_factor*490),(int)(GlobalVariables.yScale_factor*335),paintfadeInOut);
			if(mySound.ifPlaying()==0){
		    	mySound.stopSound();
		    	whichScene=6;
		    	subSwichIndex=0;
		    	fadeInOutIndex=0;
		    }
			break;
		case 2:
			
			break;

		default:
			break;
		}
		
		
	}


	private void scene_4(Canvas canvas) {
		
		day=Constant.DAYS;
		month=Constant.MONTHS;
		year=Constant.YEARS;
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		myConstantObj.drawImageAtExactPosition(canvas,link1_4a,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*175),null);
		
			Date d;
//			try {
//				d = sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
//				Calendar now = Calendar.getInstance();    
//		        now.setTime(d);
//		        now.add(month, 6);
//		        myConstantObj.drawText(canvas,""+now.get(Calendar.DATE),200,400, 100);
//		        myConstantObj.drawText(canvas,""+(now.get(Calendar.MONTH)+1),400,400, 100);
//		        myConstantObj.drawText(canvas,""+now.get(Calendar.YEAR),645,400, 100);
//			} catch (ParseException e) {
//				
//			}
			
			try {
				d = sdf.parse(Constant.YEARS+"/"+Constant.MONTHS+"/"+Constant.DAYS+ " 00:00:00");
				Calendar now = Calendar.getInstance(); 
				now = Calendar.getInstance();    
		        now.setTime(d);
		        now.add(Calendar.MONTH, 6);
		        myConstantObj.drawText(canvas,""+now.get(Calendar.DATE),(int)(GlobalVariables.xScale_factor*200),(int)(GlobalVariables.yScale_factor*400), (int)(100*GlobalVariables.xScale_factor));
		        myConstantObj.drawText(canvas,""+(now.get(Calendar.MONTH)+1),(int)(GlobalVariables.xScale_factor*400),(int)(GlobalVariables.yScale_factor*400), (int)(100*GlobalVariables.xScale_factor));
		        myConstantObj.drawText(canvas,""+now.get(Calendar.YEAR),(int)(GlobalVariables.xScale_factor*645),(int)(GlobalVariables.yScale_factor*400), (int)(100*GlobalVariables.xScale_factor));
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


	private void scene_3(Canvas canvas) {
		myConstantObj.drawImage(canvas, link1_3a, canvasWidth/2,canvasHeight/2,null);
		
		mySound.playSound(R.raw.link1_3a); 
		if(mySound.ifPlaying()==0){
			if(threadTimeController>70){
				 mySound.stopSound();
				 threadTimeController=0;
				 whichScene=4;
			 }
	    }
		
		 spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2,lips.getHeight()/2);
		 spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2,eyes.getHeight()/2);
		
	}


	private void scene_2(Canvas canvas) {
		myConstantObj.drawImage(canvas, link1_2a, canvasWidth/2,canvasHeight/2,null);
		mySound.playSound(R.raw.link1_2a); 
		
		if(mySound.ifPlaying()==0){
			if(threadTimeController>100){
				 mySound.stopSound();
				 threadTimeController=0;
				 whichScene=3;
			 }
	    }
		
		spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2,lips.getHeight()/2);
		spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2,eyes.getHeight()/2);
	}
	
	
	private void scene_1(Canvas canvas) {
		
		int val=-1;
		switch(subSwichIndex){
		case 0:
			zio=new ZoomInZoomOut(canvas, link1_1a,20,canvasWidth/2,canvasHeight/2,10);
			subSwichIndex=1;
			break;
		case 1:
			 val=zio.zoomOut(null);
			 if(val==0)subSwichIndex=2;
			break;
		case 2:
			zio.zoomOut(null);
			mySound.playSound(R.raw.link1_1a);
			spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
			break;
		case 3:
			break;
			
		}

//		if(threadTimeController>90){
//			mySound.stopSound();
//			whichScene=2;
//			threadTimeController=0;
//			subSwichIndex=0;
//		}

        if(mySound.timerControllerMediaPlayer){
            mySound.stopSound();
            whichScene=2;
            threadTimeController=0;
            subSwichIndex=0;
        }



//		if(xScale>0&&threadTimeController%2==0){
//		   xScale-=20*xMultiplyer;
//		   yScale-=20*yMultiplyer;
//		}
//	   
//		imageRectF=new RectF(canvasWidth/2-link1_1a.getWidth()/2-xScale,canvasHeight/2-link1_1a.getHeight()/2-yScale, canvasWidth/2+link1_1a.getWidth()/2+xScale,canvasHeight/2+link1_1a.getHeight()/2+yScale);
//		drawImageWithRectF(canvas, imageRectF, link1_1a);
//		
//		if(xScale==0){
//		    mySound.playSound(R.raw.link1_1a); 
//		    spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2,eyes.getHeight()/2);
//		    spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2,lips.getHeight()/2);
//		    }
//		
//		 if(mySound.ifPlaying()==0){
//			 if(threadTimeController>100){
//				 mySound.stopSound();
//				 threadTimeController=0;
//				 whichScene=2;
//			 }
		    	
//		    }
		 
		 
	}


	private void scene_0(Canvas canvas) {
		int d, m,y,space=30;
		
		myConstantObj.drawImage(canvas, dateBackground, canvasWidth/2,canvasHeight/2,null);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		int numberImageWidth=numberSprite.getWidth()/10;
		d=day;
		m=month;
		y=year;
		
		dayUpF=new RectF(canvasWidth/2-(int)(GlobalVariables.xScale_factor*3)*numberImageWidth-space-triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-(int)(GlobalVariables.yScale_factor*40),canvasWidth/2-(int)(GlobalVariables.xScale_factor*3)*numberImageWidth-space+triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2-numberSprite.getHeight()/2-(int)(GlobalVariables.yScale_factor*40));
		dayDownF=new RectF(canvasWidth/2-(int)(GlobalVariables.xScale_factor*3)*numberImageWidth-space-triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2+numberSprite.getHeight()/2+(int)(GlobalVariables.yScale_factor*30),canvasWidth/2-(int)(GlobalVariables.xScale_factor*3)*numberImageWidth-space+triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+(int)(GlobalVariables.yScale_factor*30));
		
		monthUpF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-(int)(GlobalVariables.yScale_factor*40), canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2-numberSprite.getHeight()/2-(int)(GlobalVariables.yScale_factor*40));
		monthDownF=new RectF(canvasWidth/2-numberImageWidth-triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2+numberSprite.getHeight()/2+(int)(GlobalVariables.yScale_factor*30), canvasWidth/2-numberImageWidth+triangleUp.getWidth()/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+(int)(GlobalVariables.yScale_factor*30));
		
		yearUpF=new RectF(canvasWidth/2+(int)(GlobalVariables.xScale_factor*2)*numberImageWidth-triangleUp.getWidth()/2+(int)(GlobalVariables.xScale_factor*120),canvasHeight/2-numberSprite.getHeight()/2-triangleUp.getHeight()-(int)(GlobalVariables.yScale_factor*40), canvasWidth/2+(int)(GlobalVariables.xScale_factor*2)*numberImageWidth+triangleUp.getWidth()/2+(int)(GlobalVariables.xScale_factor*120),canvasHeight/2-numberSprite.getHeight()/2-(int)(GlobalVariables.yScale_factor*40));
		yearDownF=new RectF(canvasWidth/2+(int)(GlobalVariables.xScale_factor*2)*numberImageWidth-triangleUp.getWidth()/2+(int)(GlobalVariables.xScale_factor*120),canvasHeight/2+numberSprite.getHeight()/2+(int)(GlobalVariables.yScale_factor*30), canvasWidth/2+(int)(GlobalVariables.xScale_factor*2)*numberImageWidth+triangleUp.getWidth()/2+(int)(GlobalVariables.xScale_factor*120),canvasHeight/2+numberSprite.getHeight()/2+triangleDown.getHeight()+(int)(GlobalVariables.yScale_factor*30));
		
		
		
		drawImageWithRectF(canvas, dayUpF,triangleUp);
	    drawImageWithRectF(canvas, dayDownF, triangleDown);
	    drawImageWithRectF(canvas, monthUpF, triangleUp);
	    drawImageWithRectF(canvas, monthDownF, triangleDown);
	    drawImageWithRectF(canvas, yearUpF, triangleUp);
	    drawImageWithRectF(canvas, yearDownF, triangleDown);
		
		
	    
		spriteNumberArrayObj[0].drawSprite(canvas,d%10,canvasWidth/2-(int)(GlobalVariables.xScale_factor*3)*numberImageWidth+numberImageWidth/2-space-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2,null);
		d=d/10;
		spriteNumberArrayObj[1].drawSprite(canvas,d%10,canvasWidth/2-(int)(GlobalVariables.xScale_factor*4)*numberImageWidth+numberImageWidth/2-space-(int)(GlobalVariables.xScale_factor*120),canvasHeight/2,null);
		
		m=m+1;
		spriteNumberArrayObj[2].drawSprite(canvas,m%10,canvasWidth/2-numberImageWidth+numberImageWidth/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2,null);
		m=m/10;
		spriteNumberArrayObj[3].drawSprite(canvas,m%10,canvasWidth/2-(int)(GlobalVariables.xScale_factor*2)*numberImageWidth+numberImageWidth/2-(int)(GlobalVariables.xScale_factor*20),canvasHeight/2,null);
		
		
		spriteNumberArrayObj[7].drawSprite(canvas,y%10,canvasWidth/2+(int)(GlobalVariables.xScale_factor*3)*numberImageWidth+space+numberImageWidth/2+(int)(GlobalVariables.xScale_factor*90),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[6].drawSprite(canvas,y%10,canvasWidth/2+(int)(GlobalVariables.xScale_factor*2)*numberImageWidth+space+numberImageWidth/2+(int)(GlobalVariables.xScale_factor*95),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[5].drawSprite(canvas,y%10,canvasWidth/2+numberImageWidth+space+numberImageWidth/2+(int)(GlobalVariables.xScale_factor*90),canvasHeight/2,null);
		y=y/10;
		spriteNumberArrayObj[4].drawSprite(canvas,y%10,canvasWidth/2+space+numberImageWidth/2+(int)(GlobalVariables.xScale_factor*90),canvasHeight/2,null);
		
		myConstantObj.drawText(canvas,getResources().getString(R.string.jamantithi),canvasWidth/2,(int)(GlobalVariables.yScale_factor*250),70);

		Date d1=null,d2=null;
		long diffInDays=0;
		try {
			
			d1=sdf.parse(year+"/"+month+"/"+day+ " 00:00:00");
			d2=sdf.parse(calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+" 00:00:00");
			diffInDays = (long)(d2.getTime() - d1.getTime())/ (1000 * 60 * 60 * 24);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		if(diffInDays>=0)myConstantObj.drawText(canvas,getResources().getString(R.string.age)+" : "+ diffInDays/365 +" "+ getResources().getString(R.string.year)+" , "+(diffInDays%365)/30 +"  "+getResources().getString(R.string.month)+" , "+(diffInDays%365)%30 +" "+ getResources().getString(R.string.day),canvasWidth/2,canvasHeight/2+200,40);
		else myConstantObj.drawText(canvas,getResources().getString(R.string.checkDate),canvasWidth/2,canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),40);

		Constant.AGEINMONTHS=(int)diffInDays/30;
		
		drawButton(canvas,ageChale,canvasWidth/2,canvasHeight-ageChale.getHeight()*2);
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
		ageChaleRectF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,null,ageChaleRectF,null);
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
		
			switch(whichScene){
			case 0:
				if(dayUpF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<31)day++;
					else if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day<30)day++;
					else if((month==1&&year%4==0)&&day<29)day++;
					else if((month==1)&&day<28)day++;
					else day=1;
				}
				if(dayDownF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					if(day>1)day--;
					else{
						  if(month==0||month==2||month==4||month==6||month==7||month==9||month==11)day=31;
						  else if(month==3||month==5||month==8||month==6||month==10)day=30;
						  else if(month==1&&year%4==0)day=29;
						  else if(month==1)day=28;
					    }
				}
				if(monthUpF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
						if(month<11)month++;
						else month=0;
						
						if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
						else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
						else if((month==1&&year%4==0)&&day>29)day=29;
						else if((month==1)&&day>28)day=28;
				}
				if(monthDownF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					if(month>0)month--;
					else month=11;
					
					if((month==0||month==2||month==4||month==6||month==7||month==9||month==11)&&day>31)day=31;
					else if((month==3||month==5||month==8||month==6||month==10)&&day>30)day=30;
					else if((month==1&&year%4==0)&&day>29)day=29;
					else if((month==1)&&day>28)day=28;
					
				}
				if(yearUpF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					if(year<calendar.get(Calendar.YEAR))year++;
					
				}
				if(yearDownF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					if(year>0)year--;
				}
				if(ageChaleRectF!=null&&ageChaleRectF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					Constant.DAYS=day;
					Constant.MONTHS=month;
					Constant.YEARS=year;
					whichScene=2;
					threadTimeController=0;

				}
				break;
			case 17:
				if(imageRectF!=null&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0){
					Constant.mediaPlayerTouch.start();
					subSwichIndex=2;
					TF=false;
					gameThread=null;
					mySound.stopSound();
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Activity.RESULT_OK);
					((Activity)context).finish();
					if(whichScene>1)clearAll();
				}
				if(Constant.replayF!=null&&Constant.replayF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					TF=false;
					gameThread=null;
					mySound.stopSound();
					getHandler().removeCallbacks(this);
				    ((Activity)context).setResult(Constant.REPLAY);
					((Activity)context).finish();
					clearAll();
				}
				break;
			case 18:
//				if(ageChaleRectF!=null&&ageChaleRectF.intersect(touchrecF)){
//					Constant.mediaPlayerTouch.start();
//					Constant.DAYS=day;
//					Constant.MONTHS=month;
//					Constant.YEARS=year;
//					whichScene=1;
//					threadTimeController=0;
//
//				}
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
			break;
			
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
        return true;
	}

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
		subSwichIndex=2;
		TF=false;
		gameThread=null;
		mySound.stopSound();
		getHandler().removeCallbacks(this);
		((Activity)context).setResult(Activity.RESULT_OK);
		((Activity)context).finish();
		clearAll();
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart_1_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_1_Canvas mycanvas) {
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
	@Override
	public void run() {
//		dateBackground= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.date_background);
		
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		eyes= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.eyes);
		lips= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lips);
		ageChale= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
		numberSprite= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.numbers);
		triangleUp= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.triangle_up);
		triangleDown= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.triangle_down);
		link1_1a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_1a);
		link1_2a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_2a);
		link1_3a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_3a);
		link1_4a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4a);
		link1_4b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4b);
		link1_5a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_5a);
		link1_5b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_5b);
		link1_6a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_6a);
		
		
		link1_9a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_9a);
    	link1_10a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_10a);
    	
		
		
		
		
		spriteNumberArrayObj= new Sprite[8];

		spriteEyesObj=new Sprite(eyes,4);
		spriteLipsObj=new Sprite(lips,13);
		spritelink1_4bObj=new Sprite(link1_4b,2);
		
		
		
		
		
		xDpi=(float)link1_1a.getWidth()/canvasWidth;
		yDpi=(float)link1_1a.getHeight()/canvasHeight;
		xMultiplyer=xDpi*yDpi;
		yMultiplyer=xDpi*yDpi;
		xScale=300*xMultiplyer;
		yScale=300*yMultiplyer;
		
		whichScene=1;
		subSwichIndex=0;
		threadTimeController=1;
	}
	
     public void clearAll(){
 		eyes.recycle();
 		lips.recycle();
 		ageChale.recycle();
 		numberSprite.recycle();
 		triangleUp.recycle();
 		triangleDown.recycle();
 		
 	
 		if(whichScene==17){
 		link1_17a.recycle();
 		link1_17b.recycle();
 		}
 		
 		spriteEyesObj=null;
		spriteLipsObj=null;
		spritelink1_4bObj=null;
		

		
		spritelink1_8aObj=null;
		spritelink1_8bObj=null;
		
		spritelink1_14bObj=null;
		spritelink1_15bObj=null;
		System.gc();
	}
	
}

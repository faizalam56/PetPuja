package com.abdullah.canvas;


import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.ZoomInZoomOut;
import com.zmq.utility.GlobalVariables;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart_4_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	Bitmap girl1,backGround,button,sprite,image1,image2,image3,image4;
	private RectF imageRectF,image2RectF,image3RectF,buttonNextF,buttonRectF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paintWhite,paintBtn;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false;
	Context context;
	Sprite drawMidSprite;
	ZoomInZoomOut zio;
	
	int canvasWidth,canvasHeight;
    Constant myConstant;
	int whichScene=0;
	int threadTimeController=0;
	int subSwitchIndex=0;
	Sound mySound;
	int sleepTime=2;
	Bitmap eyes;
	Sprite spriteEyesObj;
	boolean spriteSwitcher;
	Bitmap lips;
	Sprite spriteLipsObj;
	
	Bitmap link4_1a;
	
	
	
	Bitmap link4_2a;
	Sprite link4_2aSpriteObj;
	int link4_2aSpriteIndex;
	
	Bitmap link4_3a;
	Sprite link4_3aSpriteObj;
	int link4_3aSpriteIndex;
	
	Bitmap link4_3b;
	Bitmap link4_4a;
	
	
	Bitmap link4_2b;
	Sprite link4_2bSpriteObj;
	int link4_2bSpriteIndex;
	
	Bitmap link4_5a;
	Bitmap link4_6a;
	Bitmap link4_7a;
	Bitmap link4_7b;
	
	Bitmap link4_8a;
	Bitmap link4_8b;
	Sprite link4_8bSpriteObj;
	int link4_8bSpriteIndex;
	
	Bitmap link4_9a;
	Bitmap link4_9b;
	Sprite link4_9bSpriteObj;
	int link4_9bSpriteIndex;
	
	Bitmap link4_10a;
	Bitmap link4_10b;
	
	    public StoryPart_4_Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant(context);
		mySound=new Sound(context);
		backGround = myConstant.backGround;
		paintWhite=new Paint(Paint.ANTI_ALIAS_FLAG);
		paintWhite.setColor(Color.WHITE);
		paintWhite.setStrokeWidth(3);
//		paintWhite.setStyle(Paint.Style.STROKE); 
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		if(canvas!=null){
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		myConstant.drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
	
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
	
		if(Constant.HEADER==1){
		myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+ "."+subSwitchIndex,canvasWidth/2,100,20);
		myConstant.drawText(canvas,threadTimeController +whichScene+"."+subSwitchIndex,100,100,20);
		}
		}
	}

	
	
	
	private void drawAnimation(Canvas canvas,int whichScene) {
	  
		switch(whichScene){
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
			default:
				
		}
   
		
	}

	private void scene_12(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}


	private void scene_11(Canvas canvas) {
		if(!link4_10a.isRecycled())
		myConstant.drawImageAtExactPosition(canvas,link4_10a,(int)(GlobalVariables.xScale_factor*75),0, null);
		if(!link4_10b.isRecycled()){
		imageRectF=new RectF(canvasWidth-link4_10b.getWidth()-(int)(GlobalVariables.xScale_factor*112),(int)(GlobalVariables.yScale_factor*121),canvasWidth-(int)(GlobalVariables.xScale_factor*112),(int)(GlobalVariables.yScale_factor*121)+link4_10b.getHeight());
		myConstant.drawImageWithRectF(canvas, imageRectF, link4_10b);
		}
		if(!eyes.isRecycled())spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
		Constant.drawButtonReplay(canvas);
	}


	private void scene_10(Canvas canvas) {
		
//		myConstant.drawImageAtExactPosition(canvas,link2_11a,75,0, null);
//		mySound.playSound(R.raw.link2_11a);
//		spriteEyesObj.drawEyesSprite(canvas, eyes,381,eyes.getHeight()/2);
//		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),381,lips.getHeight()/2);
		
		
		
		myConstant.drawImageAtExactPosition(canvas,link4_10a,(int)(GlobalVariables.xScale_factor*75),0, null);
//		myConstant.drawImageAtExactPosition(canvas,link4_10b,canvasWidth-link4_10b.getWidth(),0, null);
		
		imageRectF=new RectF(canvasWidth-link4_10b.getWidth()-(int)(GlobalVariables.xScale_factor*112),(int)(GlobalVariables.yScale_factor*121),canvasWidth-(int)(GlobalVariables.xScale_factor*112),(int)(GlobalVariables.yScale_factor*121)+link4_10b.getHeight());
		myConstant.drawImageWithRectF(canvas, imageRectF, link4_10b);
		
		if(threadTimeController>10){
			mySound.playSound(R.raw.link4_10a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=11;
			threadTimeController=0;
		}
		
		if(eyes!=null)spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
		if(lips!=null)spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*381),lips.getHeight()/2);
	}


	private void scene_9(Canvas canvas) {
     myConstant.drawImageAtExactPosition(canvas,link4_9a,canvasWidth/2-link4_9a.getWidth()/2-(int)(GlobalVariables.xScale_factor*35),0, null);
		
		
        
		if(threadTimeController%5==0){
			if(link4_9bSpriteIndex<link4_9bSpriteObj.getNoOfImagesInSprite()-1)link4_9bSpriteIndex++;
		}
		link4_9bSpriteObj.drawSpriteAtExactPosition(canvas,link4_9bSpriteIndex, canvasWidth/2-link4_9b.getWidth()/(2*link4_9bSpriteObj.getNoOfImagesInSprite())-(int)(GlobalVariables.xScale_factor*35),0, null);
	
		if(threadTimeController>10){
			mySound.playSound(R.raw.link4_9a);
		}
		if(threadTimeController>70){
			mySound.stopSound();
			whichScene=10;
			threadTimeController=0;
		}
	
		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2-(int)(GlobalVariables.xScale_factor*12),eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2-(int)(GlobalVariables.xScale_factor*12),lips.getHeight()/2);
	}


	private void scene_8(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link4_8a,canvasWidth/2-link4_8a.getWidth()/2,0, null);
		
		
        
		if(threadTimeController%10==0){
			if(link4_8bSpriteIndex==link4_8bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link4_8bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link4_8bSpriteIndex--;
			else link4_8bSpriteIndex++;
			
		}
		link4_8bSpriteObj.drawSpriteAtExactPosition(canvas,link4_8bSpriteIndex, canvasWidth/2-link4_8b.getWidth()/(2*link4_8bSpriteObj.getNoOfImagesInSprite()),0, null);
	
		if(threadTimeController>20){
			mySound.playSound(R.raw.link4_8a);
		}
		if(threadTimeController>120){
			mySound.stopSound();
			whichScene=9;
			threadTimeController=0;
		}
	
//		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2-10,eyes.getHeight()/2-5);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2-(int)(GlobalVariables.xScale_factor*10),lips.getHeight()/2);
	}


	private void scene_7(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link4_7a,0,0, null);
		myConstant.drawImageAtExactPosition(canvas,link4_7b,canvasWidth-link4_7b.getWidth(),0, null);
		canvas.drawLine((int)(GlobalVariables.xScale_factor*675),(int)(GlobalVariables.yScale_factor*50),(int)(GlobalVariables.xScale_factor*675),canvasHeight-(int)(GlobalVariables.yScale_factor*70), paintWhite);
		
		if(threadTimeController>10){
			mySound.playSound(R.raw.link4_7a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=8;
			threadTimeController=0;
		}
		
	}


	private void scene_6(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link4_5a,canvasWidth/2-link4_5a.getWidth()/2,(int)(GlobalVariables.yScale_factor*40), null);
		if(threadTimeController>10){
			mySound.playSound(R.raw.link4_6a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=7;
			threadTimeController=0;
		}
		
	}


	private void scene_5(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link4_3b,canvasWidth/2-link4_3b.getWidth()/2,0, null);
		if(threadTimeController>20){
			mySound.playSound(R.raw.link4_5a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=6;
			threadTimeController=0;
		}
	}


	private void scene_4(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link4_4a,canvasWidth-link4_4a.getWidth(),0, null);
		if(threadTimeController>20){
			mySound.playSound(R.raw.link4_4a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=5;
			threadTimeController=0;
			subSwitchIndex=0;
		}
		
	}


	private void scene_3(Canvas canvas) {
		switch(subSwitchIndex){
		case 0:
			if(threadTimeController%10==0){
			 if(link4_3aSpriteIndex==link4_3aSpriteObj.getNoOfImagesInSprite()-1){
				 link4_3aSpriteIndex=link4_3aSpriteObj.getNoOfImagesInSprite()-1;
			 }
			 else  link4_3aSpriteIndex++;
			 if(threadTimeController>120)subSwitchIndex=1;
			}
			link4_3aSpriteObj.drawSpriteAtExactPosition(canvas,link4_3aSpriteIndex, canvasWidth/2-link4_3a.getWidth()/(2*link4_3aSpriteObj.getNoOfImagesInSprite()),0, null);
			break;
		case 1:
			myConstant.drawImageAtExactPosition(canvas,link4_3b,canvasWidth/2-link4_3b.getWidth()/2,0, null);
			break;
		case 2:
			break;
		}
				
		if(threadTimeController>20){
			mySound.playSound(R.raw.link4_3a);
		}
		if(threadTimeController>180){
			mySound.stopSound();
			whichScene=4;
			threadTimeController=0;
		}
		
	}


	private void scene_2(Canvas canvas) {
		
		if(threadTimeController%10==0){
			if(spriteSwitcher)link4_2aSpriteIndex--;
			else link4_2aSpriteIndex++;
			
			if(link4_2aSpriteIndex==link4_2aSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link4_2aSpriteIndex==0)spriteSwitcher=false;
		}
		
		link4_2aSpriteObj.drawSpriteAtExactPosition(canvas,link4_2aSpriteIndex, canvasWidth/2-link4_2a.getWidth()/(2*link4_2aSpriteObj.getNoOfImagesInSprite()),0, null);
		
		if(threadTimeController>20){
			mySound.playSound(R.raw.link4_2a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=3;
			subSwitchIndex=0;
			threadTimeController=0;
		}
		
	}


	private void scene_1(Canvas canvas) {
		int val=-1;
		switch(subSwitchIndex){
		case 0:
			zio=new ZoomInZoomOut(canvas, link4_1a,20,canvasWidth/2,canvasHeight/2,10);
			subSwitchIndex=1;
			break;
		case 1:
			 val=zio.zoomOut(null);
			 if(val==0)subSwitchIndex=2;
			break;
		case 2:
			zio.zoomOut(null);
			mySound.playSound(R.raw.link4_1a);
			spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
			break;
		case 3:
			break;
			
		
		}

		if(threadTimeController>80){
			mySound.stopSound();
			whichScene=2;
			threadTimeController=0;
		}
		
	}


	private void scene_0(Canvas canvas) {
		myConstant.drawImageWithRotation(canvas);
	    loadImages();
	}
	



	private void drawButtonNext(Canvas canvas, Bitmap btnBitmap,int xMidPosition, int yMidPosition) {
		Rect  btnBitmapS=new Rect(0,0,btnBitmap.getWidth(),btnBitmap.getHeight());
		buttonNextF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,btnBitmapS,buttonNextF,null);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event ) {
		RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
//			if(Constant.closeF!=null&&Constant.closeF.intersect(touchrecF)){
//				Constant.messageBoxForClosingApp(context);
//			}
			switch(whichScene){
			case 0:
				
				break;
			case 1:
//				if(buttonNextF.intersect(touchrecF)){
//					TF=false;
//					gameThread=null;
//					((Activity)context).setResult(Activity.RESULT_OK);
//                    ((Activity)context).finish();
//				}
				break;
			case 11:
				if(imageRectF!=null&imageRectF.intersect(touchrecF)){
				Constant.mediaPlayerTouch.start();
				subSwitchIndex=-1;
				TF=false;
				gameThread=null;
				mySound.stopSound();
				getHandler().removeCallbacks(this);
				((Activity)context).setResult(Activity.RESULT_OK);
				((Activity)context).finish();
				clearAll();
				}
				if(Constant.replayF!=null&&Constant.replayF.intersect(touchrecF)){
					Constant.mediaPlayerTouch.start();
					subSwitchIndex=-1;
					TF=false;
					gameThread=null;
					mySound.stopSound();
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Constant.REPLAY);
					((Activity)context).finish();
					clearAll();
					}
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
		mySound.stopSound();
		TF=true;
		gameThread = new GameThread(holder, this);
		gameThread.start();
		Log.e("SurfaceView","surfaceCreated");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		TF=false;
		Log.e("SurfaceView","surfaceDestroyed");
		if(gameThread!=null){
		Log.e("Thread Status",""+gameThread.getState());
		gameThread=null;
		girl1=null;
		button=null;
		sprite=null;
		image1=null;
		image2=null;
		}
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart_4_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_4_Canvas mycanvas) {
			_suHolder = surfaceHolder;
			_myMycanvas = mycanvas;
		}
		
		@Override
		public void run() {
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
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} finally{
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

	@Override
	public void run() {
		eyes= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.eyes);
		lips= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lips);
		spriteEyesObj=new Sprite(eyes,4);
		spriteLipsObj=new Sprite(lips,13);
		link4_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_1a); // repeat Image
		link4_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_8a); // repeat Image
		link4_3a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_3a);
		link4_3b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game1_finalframe);
		link4_4a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_4a);
		link4_5a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_6a);
		link4_7a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_7a);
		link4_7b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_7b);
		link4_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_8a);
		link4_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_8b);
		link4_9a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_9a);
		link4_9b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_9b);
		link4_10a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
		link4_10b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link4_10b);
		
		
		link4_2aSpriteObj=new Sprite(link4_2a, 2);
		link4_3aSpriteObj=new Sprite(link4_3a, 6);
		link4_8bSpriteObj=new Sprite(link4_8b, 4);
		link4_9bSpriteObj=new Sprite(link4_9b, 5);
		
		button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);

		whichScene=1;
		threadTimeController=0;
	
	}
	
	public void clearAll(){
		eyes.recycle();
		lips.recycle();
		link4_1a.recycle();
		link4_2a.recycle();
		link4_3a.recycle();
		link4_4a.recycle();
		link4_5a.recycle();
		link4_7a.recycle();
		link4_7b.recycle();
		link4_8a.recycle();
		link4_8b.recycle();
		link4_9a.recycle();
		link4_9b.recycle();
		link4_10a.recycle();
		link4_10b.recycle();

		link4_2aSpriteObj=null;
		link4_3aSpriteObj=null;
		link4_8bSpriteObj=null;
		link4_9bSpriteObj=null;
		System.gc();
}
	
	
}

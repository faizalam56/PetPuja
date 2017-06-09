package com.abdullah.canvas;


import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.PetPuja;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.ZoomInZoomOut;
import com.abdullah.activities.*;
import com.zmq.utility.GlobalVariables;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class StoryPart_2_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{

	GameThread gameThread;
	Bitmap girl1,backGround,buttonNext,sprite,image1,image2,image3,image4;
	private RectF imageRectF,image2RectF,image3RectF,buttonNextF,buttonRectF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paintImage,paintBtn;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false,spriteSwitcher;
	Context context;
	Sprite drawMidSprite;
	int canvasWidth,canvasHeight;
    Constant myConstant;
	int whichScene=0;
	int threadTimeController=0,subSwitchIndex=0;
	int sleepTime=5;
	int fadeInOut=0;
	Sound mySound;
	
	    Bitmap eyes;
	    Sprite spriteEyesObj;
	    int eyesSpriteIndex;
	    
	    Bitmap lips;
	    Sprite spriteLipsObj;
	    int lipsSpriteIndex;
	    
	    Bitmap lips2;
	    Sprite spriteLips2Obj;
	    int lips2SpriteIndex;
	
	Bitmap link2_1a;
	
	Bitmap link2_2a;
	Bitmap link2_2b;
	Sprite spriteLink2_2bObj;
	int link2_2bSpriteIndex;
	
	Bitmap link2_3a;
	
	Bitmap link2_4a;
	
	Bitmap link2_5a;
	
	Bitmap link2_5b;
	Sprite spriteLink2_5bObj;
	int link2_5bSpriteIndex;
	
	Bitmap link2_6a;
	Bitmap link2_6b;
	Sprite spriteLink2_6bObj;
	int link2_6bSpriteIndex;
	
	Bitmap link2_7a;
	
	Bitmap link2_8a;
	
	Bitmap link2_9a;
	
	Bitmap link2_9b;
	Sprite spriteLink2_9bObj;
	int link2_9bSpriteIndex;
	
    Bitmap link2_10a;
    Sprite spriteLink2_10aObj;
	int link2_10aSpriteIndex;
	
	Bitmap link2_10b;
	Sprite spriteLink2_10bObj;
	int link2_10bSpriteIndex;
	
	Bitmap link2_11a;
	Bitmap link2_11b;

	ZoomInZoomOut zio;
	    public StoryPart_2_Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant();
		backGround = Constant.backGround;
		mySound=new Sound(context);
		paintImage=new Paint(Paint.ANTI_ALIAS_FLAG);
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		if(canvas!=null){
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		myConstant.drawBackground(canvas,backGround);
		drawAnimation(canvas);
		if(Constant.HEADER==1)myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+"."+subSwitchIndex,canvasWidth/2,100,20);
		}
		
//		if(whichScene>0)
//			drawButtonNext(canvas,buttonNext,canvasWidth/2,canvasHeight-buttonNext.getHeight()/2);
	}

	private void drawAnimation(Canvas canvas) {
	  
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
		
		}
   
		
	}

	private void scene_11(Canvas canvas) {
		
//		if(!link6_8a.isRecycled())
//			 myConstant.drawImageAtExactPosition(canvas, link6_8a,75, 0, null);
//			if(!eyes.isRecycled())
//			 spriteEyesObj.drawEyesSprite(canvas, eyes,381,eyes.getHeight()/2);
//			if(!lips.isRecycled())
//			 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),381,lips.getHeight()/2);
//			 if(threadTimeController>5){
//					mySound.playSound(R.raw.link6_8a);
//					subSwitchIndex=0;
//				}
//			 if(!link6_8b.isRecycled()){
//				 imageRectF=new RectF(canvasWidth-link6_8b.getWidth(),0,canvasWidth,link6_8b.getHeight());
//				 myConstant.drawImageWithRectF(canvas, imageRectF, link6_8b);
//			 }
		
		
		
		switch (subSwitchIndex) {
		case 0:
			if(!link2_11a.isRecycled())myConstant.drawImageAtExactPosition(canvas,link2_11a,(int)(GlobalVariables.xScale_factor*75),0, null);
			mySound.playSound(R.raw.link2_11a);
			spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*381),lips.getHeight()/2);
			if(!link2_11b.isRecycled()){
			imageRectF=new RectF(canvasWidth-link2_11b.getWidth()-(int)(GlobalVariables.xScale_factor*100),canvasHeight/2-link2_11b.getHeight()/2,canvasWidth-(int)(GlobalVariables.xScale_factor*100),canvasHeight/2+link2_11b.getHeight()/2);
			myConstant.drawImageWithRectF(canvas, imageRectF, link2_11b);
			if(mySound.ifPlaying()==0)subSwitchIndex=1;
			}
			break;
		case 1:
			if(!link2_11a.isRecycled()){
			myConstant.drawImageAtExactPosition(canvas,link2_11a,(int)(GlobalVariables.xScale_factor*75),0, null);
			}
			if(!link2_11b.isRecycled()){
				imageRectF=new RectF(canvasWidth-link2_11b.getWidth()-(int)(GlobalVariables.xScale_factor*100),canvasHeight/2-link2_11b.getHeight()/2,canvasWidth-(int)(GlobalVariables.xScale_factor*100),canvasHeight/2+link2_11b.getHeight()/2);
				myConstant.drawImageWithRectF(canvas, imageRectF, link2_11b);
			}
			Constant.drawButtonReplay(canvas);
			break;
		case 2:
			
			break;

		default:
			break;
		}

	}


	private void scene_10(Canvas canvas) {
		
		
		if(threadTimeController%8==0){
			
			if(link2_10bSpriteIndex==spriteLink2_10bObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link2_10bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link2_10bSpriteIndex--;
			else link2_10bSpriteIndex++;
		}
		
		if(threadTimeController%4==0){
			if(link2_10aSpriteIndex<spriteLink2_10aObj.getNoOfImagesInSprite()-1)link2_10aSpriteIndex++;
		}
		
		
//		link2_10bSpriteIndex=link2_10aSpriteIndex;
		
		spriteLink2_10bObj.drawSpriteAtExactPosition(canvas, link2_10bSpriteIndex, canvasWidth-link2_10b.getWidth()/4,0, null);
		
		
		spriteLink2_10aObj.drawSpriteAtExactPosition(canvas, link2_10aSpriteIndex,(int)(GlobalVariables.xScale_factor*15),0, null);
		
		
			mySound.playSound(R.raw.link2_10a);

			if(threadTimeController>85){
			mySound.stopSound();
			whichScene=11;
			threadTimeController=0;
			subSwitchIndex=0;
			link2_10a.recycle();
	 		link2_10b.recycle();
			link2_11a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
			link2_11b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_11b);
			
		}
		
		spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*302),eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*302),lips.getHeight()/2);
		
	}


	private void scene_9(Canvas canvas) {
		int val=0;
		switch (subSwitchIndex) {
		case 0:
			zio=new ZoomInZoomOut(canvas, link2_9a,0,canvasWidth/2,canvasHeight/2,10);
			subSwitchIndex=1;
			fadeInOut=0;
			threadTimeController=0;
			mySound.playSound(R.raw.link2_9a);
			break;
		case 1:
		      val=zio.zoomIn(null);
			  if(threadTimeController>20)subSwitchIndex=2;
			break;
		case 2:
			zio.zoomIn(null);
			if(fadeInOut<255)fadeInOut+=15;
			paintImage.setAlpha(fadeInOut);
			 
			if(threadTimeController%10==0){
				
				if(link2_9bSpriteIndex==spriteLink2_9bObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
				if(link2_9bSpriteIndex==0)spriteSwitcher=false;
				
				if(spriteSwitcher)link2_9bSpriteIndex--;
				else link2_9bSpriteIndex++;
			}
			spriteLink2_9bObj.drawSpriteAtExactPosition(canvas, link2_9bSpriteIndex, canvasWidth/2-link2_9b.getWidth()/8,canvasHeight/2-link2_9b.getHeight()/2, paintImage);
			
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				whichScene=10;
				threadTimeController=0;
				subSwitchIndex=0;
				link2_8a.recycle();
				link2_9a.recycle();
		 		link2_9b.recycle();
				link2_10a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_10a);
				link2_10b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_10b);
				spriteLink2_10aObj=new Sprite(link2_10a, 4);
				spriteLink2_10bObj=new Sprite(link2_10b, 4);
			}
			
			break;

		default:
			break;
		}
		
	}


	private void scene_8(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link2_8a,canvasWidth/2-link2_8a.getWidth()/2,0, null);
		
		if(threadTimeController>20)mySound.playSound(R.raw.link2_8a);
		
		if(mySound.ifPlaying()==0){
			if(threadTimeController>70){
			mySound.stopSound();
			whichScene=9;
			threadTimeController=0;
			subSwitchIndex=0;
			link2_6a.recycle();
	 		link2_6b.recycle();
			link2_9a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_9a);
			link2_9b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_9b);
			spriteLink2_9bObj=new Sprite(link2_9b, 4);
			}
		}
		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
	}


	private void scene_7(Canvas canvas) {
//		int val=-1;
//		switch(subSwitchIndex){
//		case 0:
//			
////			zio=new ZoomInZoomOut(canvas, link2_1a, 0,canvasWidth/2,canvasHeight/2,10);
////			subSwitchIndex=1;
////			threadTimeController=0;
//			break;
//		case 1:
////			val=zio.zoomOut(null);
//		    subSwitchIndex=2;
//			break;
//		case 2:
////			zio.zoomOut(null);
////			spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
////			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
////			
//			break;
//		case 3:
//			break;
//		
//		}
		
		
		myConstant.drawImageAtExactPosition(canvas, link2_7a,(int)(GlobalVariables.xScale_factor*240),(int)(GlobalVariables.yScale_factor*71) , null);
		mySound.playSound(R.raw.link2_7a);
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=8;
			threadTimeController=0;
			subSwitchIndex=0;
		}
		
	}


	private void scene_6(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link2_6a,canvasWidth/2-link2_6a.getWidth()/2,0, null);
       if(threadTimeController%10==0){
			if(link2_6bSpriteIndex==spriteLink2_6bObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link2_6bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link2_6bSpriteIndex--;
			else link2_6bSpriteIndex++;
		}
		
		spriteLink2_6bObj.drawSpriteAtExactPosition(canvas, link2_6bSpriteIndex, canvasWidth-(link2_6b.getWidth()/spriteLink2_6bObj.getNoOfImagesInSprite())*4/3,canvasHeight/2-link2_6b.getHeight()/2, null);
	
		if(threadTimeController>10){
			mySound.playSound(R.raw.link2_6a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=7;
			threadTimeController=0;
			link2_5a.recycle();
			link2_5b.recycle();
			
		}
		
		
	}


	private void scene_5(Canvas canvas) {
	
		myConstant.drawImageAtExactPosition(canvas,link2_5a,canvasWidth/2-link2_5a.getWidth()/2,0, null);

		if(threadTimeController%10==0){
			
			if(link2_5bSpriteIndex==spriteLink2_5bObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link2_5bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link2_5bSpriteIndex--;
			else link2_5bSpriteIndex++;
		}
		
		spriteLink2_5bObj.drawSpriteAtExactPosition(canvas, link2_5bSpriteIndex, canvasWidth/2-link2_5b.getWidth()/8,canvasHeight/2-link2_5b.getHeight()/2, null);
	
		mySound.playSound(R.raw.link2_5a);
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=6;
			threadTimeController=0;
			link2_4a.recycle();
			link2_6a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2a);
			link2_6b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2b);
			spriteLink2_6bObj=new Sprite(link2_6b, 3);

		}
	}


	private void scene_4(Canvas canvas) {
		    myConstant.drawImageAtExactPosition(canvas,link2_4a,canvasWidth/2-link2_4a.getWidth()/2,0, null);
			
		   if(threadTimeController>20)
		    mySound.playSound(R.raw.link2_4a);
			
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=5;
			subSwitchIndex=0;
			threadTimeController=0;
			link2_3a.recycle();

			link2_5a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_5a);
			link2_5b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_5b);
			spriteLink2_5bObj=new Sprite(link2_5b, 4);

		}
//		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		spriteLips2Obj.drawLipsSprite(canvas, lips2,mySound.ifPlaying(),canvas.getWidth()/2-(int)(GlobalVariables.xScale_factor*5),lips2.getHeight()/2);
		
	}


	private void scene_3(Canvas canvas) {
		
		int val=-1;
		switch(subSwitchIndex){
		case 0:
			zio=new ZoomInZoomOut(canvas, link2_3a,0,canvasWidth/2,canvasHeight/2,10);
			subSwitchIndex=1;
			break;
		case 1:
			val=zio.zoomOut(null);
			if(val==0)subSwitchIndex=2;
			break;
		case 2:
			mySound.playSound(R.raw.link2_3a);
			val=zio.zoomIn(null);
//			spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
			break;
		case 3:
			break;
		}
		
		
			
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=4;
			threadTimeController=0;
			subSwitchIndex=0;
			link2_1a.recycle();
	 		link2_2a.recycle();
	 		link2_2b.recycle();
		}
			}


	private void scene_2(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas,link2_2a,canvasWidth/2-link2_2a.getWidth()/2,0, null);
			
		if(threadTimeController%10==0){
			if(link2_2bSpriteIndex<spriteLink2_2bObj.getNoOfImagesInSprite()-1) link2_2bSpriteIndex++;
			else link2_2bSpriteIndex--;

		}
		
		spriteLink2_2bObj.drawSpriteAtExactPosition(canvas, link2_2bSpriteIndex, canvasWidth/2-link2_2b.getWidth()/12,0, null);
		
		if(threadTimeController>20){
			mySound.playSound(R.raw.link2_2a);
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=3;
			threadTimeController=0;
		}

		
	}


	private void scene_1(Canvas canvas) {
		
		int val=-1;
		switch(subSwitchIndex){
		case 0:
			zio=new ZoomInZoomOut(canvas, link2_1a,30,canvasWidth/2,canvasHeight/2,10);
			subSwitchIndex=1;
			break;
		case 1:
			 val=zio.zoomOut(null);
			 if(val==0)subSwitchIndex=2;
			break;
		case 2:
			zio.zoomOut(null);
			mySound.playSound(R.raw.link2_1a);
			spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
			break;
		case 3:
			break;
		case 4:
			break;
		}

		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=2;
			threadTimeController=0;
			subSwitchIndex=0;
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
			
			if(buttonNextF!=null&&buttonNextF.intersect(touchrecF)){
				if(whichScene<11){
					mySound.stopSound();
					whichScene++;
					threadTimeController=0;
				}
		  }
			
			
//			if(Constant.closeF!=null&&Constant.closeF.intersect(touchrecF)){
//				Constant.messageBoxForClosingApp(context);
//			}
			switch(whichScene){
			case 0:
				
				break;
			case 11:
				
				if(imageRectF!=null&&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0){
					Constant.mediaPlayerTouch.start();
					subSwitchIndex=2;
					threadTimeController=0;
					TF=false;
					gameThread=null;
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Activity.RESULT_OK);
					((Activity)context).finish();
					mySound.stopSound();
					clearAll();
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
		// TODO Auto-generated method stub
		Log.e("SurfaceView","surfaceChanged");
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		TF=true;
		gameThread = new GameThread(holder, this);
		gameThread.start();
		Log.e("SurfaceView","surfaceCreated");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mySound.stopSound();
		TF=false;
		gameThread=null;
		Log.e("SurfaceView","surfaceDestroyed");
		
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart_2_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_2_Canvas mycanvas) {
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

	@Override
	public void run() {
		
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		eyes= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.eyes);
		lips= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lips);
		lips2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.rotate_lipsing);
		spriteEyesObj=new Sprite(eyes,4);
		spriteLipsObj=new Sprite(lips,13);
		spriteLips2Obj=new Sprite(lips2,13);
//		buttonNext= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.age_chale);
		link2_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_1a);
		link2_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_2a);
		link2_2b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_2b);
		link2_3a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_3a);
		link2_4a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_4a);
		
		
		link2_7a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_7a);
		link2_8a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_8a);
		
		
		
		
		spriteLink2_2bObj=new Sprite(link2_2b, 6);
		
		
		
		whichScene=1;
		threadTimeController=0;
	}
	
	
	
	 public void clearAll(){
 		eyes.recycle();
 		lips.recycle();
 		
 		
 		
// 		link2_5a.recycle();
// 		link2_5b.recycle();
 		
// 		link2_7a.recycle();
 		
 		
 		
 		link2_11a.recycle();
 		link2_11b.recycle();

 		spriteLink2_2bObj=null;
		spriteLink2_5bObj=null;
		spriteLink2_6bObj=null;
		spriteLink2_9bObj=null;
		spriteLink2_10aObj=null;
		spriteLink2_10bObj=null;
		System.gc();
	}
	
}

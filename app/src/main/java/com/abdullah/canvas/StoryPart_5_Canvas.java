package com.abdullah.canvas;


import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
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
import android.transition.Fade;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart_5_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	Bitmap girl1,backGround,button,sprite,image1,image2,image3,image4;
	private RectF imageRectF,image2RectF,image3RectF,buttonNextF,buttonRectF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paintFadeInOut,paintBtn;
	int intFadeInOut;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false;
	Context context;
	Sprite drawMidSprite;

	

	int canvasWidth,canvasHeight;
    Constant myConstant;
	int whichScene=0;
	int threadTimeController=0;
	int subSwitchIndex=0;
	Sound mySound;
	int sleepTime=5;
	Bitmap eyes;
	Sprite spriteEyesObj;
	boolean spriteSwitcher;
	Bitmap lips;
	Sprite spriteLipsObj;
	
	Bitmap link5_1a;
	Sprite link5_1aSpriteObj;
	int link5_1aSpriteIndex;
	
	Bitmap link5_2a;
	
	Bitmap link5_3a;
	
	    public StoryPart_5_Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant(context);
		mySound=new Sound(context);
		backGround = myConstant.backGround;
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		myConstant.drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
		
		paintFadeInOut= new Paint(Paint.ANTI_ALIAS_FLAG); 
			
		if(Constant.HEADER==1){
		myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+"."+subSwitchIndex,canvasWidth/2,100,20);
		myConstant.drawText(canvas,"Time : "+threadTimeController,100,100,20);
		}
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
	
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

			default:
				
		}
   
		
	}

	private void scene_10(Canvas canvas) {
		
	switch (subSwitchIndex) {
	case 0:
		mySound.playSound(R.raw.link5_10a);
		myConstant.drawImageAtExactPosition(canvas, link5_10a,(int)(GlobalVariables.xScale_factor*70), 0, null);
		spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*380),eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*380),lips.getHeight()/2);
		imageRectF=new RectF((int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160),link5_10b.getWidth()+(int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160)+link5_10b.getHeight());
		myConstant.drawImageWithRectF(canvas, imageRectF, link5_10b);
		if(mySound.ifPlaying()==0)subSwitchIndex=1;
		break;
	case 1:
		if(!link5_10a.isRecycled())
		myConstant.drawImageAtExactPosition(canvas, link5_10a,(int)(GlobalVariables.xScale_factor*70), 0, null);
		if(!eyes.isRecycled()&!link5_10a.isRecycled())
		spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*380),eyes.getHeight()/2);
		if(!lips.isRecycled())
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*380),lips.getHeight()/2);
		if(!link5_10b.isRecycled()){
			imageRectF=new RectF((int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160),link5_10b.getWidth()+(int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160)+link5_10b.getHeight());
		myConstant.drawImageWithRectF(canvas, imageRectF, link5_10b);
		}

       Constant.drawButtonReplay(canvas);
		break;

	default:
		break;
	}	
		
	}

	private void scene_9(Canvas canvas) {
    myConstant.drawImage(canvas, link5_9a,canvasWidth/2, canvasHeight/2, null);
		
		if(threadTimeController>5){
			mySound.playSound(R.raw.link5_9a);
			subSwitchIndex=0;
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			threadTimeController=0;
			whichScene=10;
		}
		
	}


	private void scene_8(Canvas canvas) {
//		myConstant.drawImage(canvas, link5_8a,canvasWidth/2, canvasHeight/2, null);
		
        myConstant.drawImageAtExactPosition(canvas, link5_8a, canvasWidth/2-link5_8a.getWidth()/2, 0, null);
		
		if(threadTimeController%10==0){
			
			if(link5_8bSpriteIndex==link5_8bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link5_8bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link5_8bSpriteIndex--;
			else link5_8bSpriteIndex++;
			
			
		}
//		link5_8bSpriteObj.drawSpriteAtExactPosition(canvas, , canvasWidth-link5_8b.getWidth()/3,0, null);
		link5_8bSpriteObj.drawSpriteAtExactPosition(canvas, link5_8bSpriteIndex, canvasWidth-(link5_8b.getWidth()/link5_8bSpriteObj.getNoOfImagesInSprite())*4/3,canvasHeight/2-link5_8b.getHeight()/2, null);
		
		
		
		if(threadTimeController>5){
			mySound.playSound(R.raw.link5_8a);
			subSwitchIndex=0;
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			threadTimeController=0;
			whichScene=9;
		}
		
	}


	private void scene_7(Canvas canvas) {
		myConstant.drawImage(canvas, link5_7a,canvasWidth/2, canvasHeight/2, null);
		if(threadTimeController%10==0){
			
			if(link5_7bSpriteIndex==link5_7bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link5_7bSpriteIndex==0)spriteSwitcher=false;
			
			if(spriteSwitcher)link5_7bSpriteIndex--;
			else link5_7bSpriteIndex++;
			
		}
		
		link5_7bSpriteObj.drawSpriteAtExactPosition(canvas, link5_7bSpriteIndex, canvasWidth/2-link5_7b.getWidth()/(2*link5_7bSpriteObj.getNoOfImagesInSprite()), 0, null);
        
		if(threadTimeController>5){
			mySound.playSound(R.raw.link5_7a);
			subSwitchIndex=0;
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			threadTimeController=0;
			whichScene=8;
		}
	}


	private void scene_6(Canvas canvas) {
		myConstant.drawImage(canvas, link5_6a,canvasWidth/2, canvasHeight/2, null);
		if(threadTimeController>5){
			mySound.playSound(R.raw.link5_6a);
			subSwitchIndex=0;
		}
		if(threadTimeController>100){
			mySound.stopSound();
			threadTimeController=0;
			whichScene=7;
		}
		
		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);

	}


	private void scene_5(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas, link5_5a, canvasWidth/2-link5_5a.getWidth()/2, 0, null);

		
//		if(threadTimeController%10==0){
//			if(link2_6bSpriteIndex==spriteLink2_6bObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
//			if(link2_6bSpriteIndex==0)spriteSwitcher=false;
//			
//			if(spriteSwitcher)link2_6bSpriteIndex--;
//			else link2_6bSpriteIndex++;
//		}
//		
//		spriteLink2_6bObj.drawSpriteAtExactPosition(canvas, link2_6bSpriteIndex, canvasWidth/2-link2_6b.getWidth()/8,canvasHeight/2-link2_6b.getHeight()/2, null);
	
		
		
		if(threadTimeController>5){
			mySound.playSound(R.raw.link5_5a);
			subSwitchIndex=0;
		}
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			threadTimeController=0;
			whichScene=6;
		}
	}


	private void scene_4(Canvas canvas) {
		
		myConstant.drawImageAtExactPosition(canvas, link5_4a,0, 0, null);
		
		spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*368),eyes.getHeight()/2+(int)(GlobalVariables.yScale_factor*5));
 		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*368),lips.getHeight()/2+(int)(GlobalVariables.yScale_factor*5));
 
		
		switch(subSwitchIndex){
		case 0:	
			if(threadTimeController>5){
				mySound.playSound(R.raw.link5_4a);
				subSwitchIndex=1;
			}
			break;
		case 1:
			paintFadeInOut.setAlpha(intFadeInOut);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*840),(int)(GlobalVariables.yScale_factor*320),paintFadeInOut);
			if(intFadeInOut<255)intFadeInOut+=15;
			else {
				subSwitchIndex=2;
				intFadeInOut=0;
			}
			
			break;
		case 2:
			paintFadeInOut.setAlpha(intFadeInOut);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*840),(int)(GlobalVariables.yScale_factor*320),null);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*1050),(int)(GlobalVariables.yScale_factor*320),paintFadeInOut);
			if(intFadeInOut<255)intFadeInOut+=15;
			else {
				subSwitchIndex=3;
				intFadeInOut=0;
			}
			
			break;
		case 3:
			paintFadeInOut.setAlpha(intFadeInOut);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*840),(int)(GlobalVariables.yScale_factor*320),null);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*1050),(int)(GlobalVariables.yScale_factor*320),null);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*950),(int)(GlobalVariables.yScale_factor*450),paintFadeInOut);
			if(intFadeInOut<255)intFadeInOut+=15;
			else {
				subSwitchIndex=4;
				intFadeInOut=0;
				threadTimeController=0;
			}
			break;
		case 4:
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*840),(int)(GlobalVariables.yScale_factor*320),null);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*1050),(int)(GlobalVariables.yScale_factor*320),null);
			myConstant.drawImage(canvas, link5_4b,(int)(GlobalVariables.xScale_factor*950),(int)(GlobalVariables.yScale_factor*450),null);
			if(threadTimeController>50){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=5;
			}
			break;
		}
		
	}


	private void scene_3(Canvas canvas) {
		
		myConstant.drawImageAtExactPosition(canvas, link5_3a, canvasWidth/2-link5_3a.getWidth()/2, 0, null);
		
		
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
 		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
 
 		switch(subSwitchIndex){
		case 0:
				mySound.playSound(R.raw.link5_3a);
				subSwitchIndex=1;
				threadTimeController=0;
			break;
		case 1:
//			myConstant.drawImageAtExactPosition(canvas, link5_3b, canvasWidth-link5_3b.getWidth(), 0, null);
			myConstant.drawImageAtExactPosition(canvas, link5_3c, canvasWidth-link5_3c.getWidth()-(int)(GlobalVariables.xScale_factor*120),(int)(GlobalVariables.yScale_factor*400), null);
			if(threadTimeController>50){
				subSwitchIndex=2;
				threadTimeController=0;
			}
			break;
		case 2:
			myConstant.drawImageAtExactPosition(canvas, link5_3c, canvasWidth-link5_3c.getWidth()-(int)(GlobalVariables.xScale_factor*120), (int)(GlobalVariables.yScale_factor*400), null);
			myConstant.drawImageAtExactPosition(canvas, link5_3b, canvasWidth-link5_3b.getWidth(), 0, null);

			if(mySound.ifPlaying()==0){
				if(threadTimeController>60){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=4;
				subSwitchIndex=0;
				}
			}
			break;
		case 3:
			break;
		}
	}


	private void scene_2(Canvas canvas) {
		
		myConstant.drawImageAtExactPosition(canvas, link5_2a, canvasWidth/2-link5_2a.getWidth()/2, 0, null);
		
		
			mySound.playSound(R.raw.link5_2a);
		
		if(threadTimeController>60){
			mySound.stopSound();
			whichScene=3;
			threadTimeController=0;
		}
		
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
 		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
 		 
	}


	private void scene_1(Canvas canvas) {
		if(threadTimeController%10==0){
			if(spriteSwitcher)link5_1aSpriteIndex--;
			else link5_1aSpriteIndex++;
			if(link5_1aSpriteIndex==link5_1aSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link5_1aSpriteIndex==0)spriteSwitcher=false;
		}
		
         link5_1aSpriteObj.drawSpriteAtExactPosition(canvas, link5_1aSpriteIndex, canvasWidth/2-link5_1a.getWidth()/(2*link5_1aSpriteObj.getNoOfImagesInSprite()), 0, null);
         spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
 		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
 		 

		mySound.playSound(R.raw.link5_1a);

		if(threadTimeController>75){
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
//				if(buttonNextF!=null&buttonNextF.intersect(touchrecF)){
//					TF=false;
//					gameThread=null;
//					((Activity)context).setResult(Activity.RESULT_OK);
//                    ((Activity)context).finish();
//				}
				break;
			case 10:
				if(imageRectF!=null&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0){
					subSwitchIndex=2;
					Constant.mediaPlayerTouch.start();
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
		StoryPart_5_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_5_Canvas mycanvas) {
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
	
	
	Bitmap link5_3b;
	Bitmap link5_3c;
	Bitmap link5_4a;
	Bitmap link5_4b;
	Bitmap link5_5a;
	Bitmap link5_6a;
	Bitmap link5_7a;
	Bitmap link5_7b;
	Sprite link5_7bSpriteObj;
	int    link5_7bSpriteIndex;
	Bitmap link5_8a;
	Bitmap link5_8b;
	Sprite link5_8bSpriteObj;
	int    link5_8bSpriteIndex;
	Bitmap link5_9a;
	Bitmap link5_10a;
	Bitmap link5_10b;
	Sprite link5_10bSpriteObj;
	int    link5_10bSpriteIndex;
	@Override
	public void run() {
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
		eyes= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.eyes);
		lips= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lips);
		spriteEyesObj=new Sprite(eyes,4);
		spriteLipsObj=new Sprite(lips,13);
		
		link5_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_1a);
		link5_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_2a_6a);
		link5_3a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_3a);
		link5_3b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_3b);
		link5_3c = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_3c);
		link5_4a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_4a);
		link5_4b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_4b);
		link5_5a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_5a);
		link5_6a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_2a_6a);
		link5_7a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_5a); // repeatImage
		link5_7b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_5b);
		link5_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2a);
		link5_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2b);
		link5_9a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_7a);
		link5_10a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
		link5_10b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17b);
		
		link5_1aSpriteObj=new Sprite(link5_1a,2);
		link5_7bSpriteObj=new Sprite(link5_7b,4);
		link5_8bSpriteObj=new Sprite(link5_8b,3);
		
		whichScene=1;
		threadTimeController=0;
		subSwitchIndex=0;
	}
	
	private void clearAll() {
		link5_1a.recycle();
		link5_2a.recycle();
		link5_3a.recycle();
		link5_3b.recycle();
		link5_3c.recycle();
		link5_4a.recycle();
		link5_4b.recycle();
		link5_5a.recycle();
		link5_6a.recycle();
		link5_7a.recycle();
		link5_7b.recycle();
		link5_8a.recycle();
		link5_8b.recycle();
		link5_9a.recycle();
		link5_10a.recycle();
		link5_10b.recycle();
		System.gc();
	}

	
}

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
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart_6_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	Bitmap girl1,backGround,button,sprite,image1,image2,image3,image4;
	private RectF imageRectF,image2RectF,image3RectF,buttonNextF,buttonRectF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paint1,paintBtn;
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
	
	
	
	
	    public StoryPart_6_Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant(context);
		backGround = myConstant.backGround;
		mySound=new Sound(context);
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
		
		if(Constant.HEADER==1){
		myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+"."+subSwitchIndex,canvasWidth/2,100,20);
		myConstant.drawText(canvas," Time : "+threadTimeController,100,100,20);
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
		// TODO Auto-generated method stub
		
	}
	private void scene_9(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}

    boolean buttunShow=false;
	private void scene_8(Canvas canvas) {
		if(!link6_8a.isRecycled())
		 myConstant.drawImageAtExactPosition(canvas, link6_8a, (int)(GlobalVariables.xScale_factor*75), 0, null);
		if(!eyes.isRecycled())
		 spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
		if(!lips.isRecycled())
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*381),lips.getHeight()/2);
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_8a);
				subSwitchIndex=0;
			}
		 if(!link6_8b.isRecycled()){
			 imageRectF=new RectF(canvasWidth-link6_8b.getWidth()-(int)(GlobalVariables.xScale_factor*105),(int)(GlobalVariables.yScale_factor*126),canvasWidth-(int)(GlobalVariables.xScale_factor*105),link6_8b.getHeight()+(int)(GlobalVariables.yScale_factor*126));
			 myConstant.drawImageWithRectF(canvas, imageRectF, link6_8b);
		 }
		     
		 if(mySound.ifPlaying()==0){
			 buttunShow=true;
		 }
		 if(buttunShow)Constant.drawButtonReplay(canvas);
	}


	private void scene_7(Canvas canvas) {
		switch (subSwitchIndex) {
		case 0:
			myConstant.drawImageAtExactPosition(canvas, link6_7a,0,0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7c,(int)(GlobalVariables.xScale_factor*500),0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7d,(int)(GlobalVariables.xScale_factor*870),0, null);
			if(threadTimeController>50)subSwitchIndex=1;
			break;
		case 1:
			myConstant.drawImageAtExactPosition(canvas, link6_7a,0,0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7c,(int)(GlobalVariables.xScale_factor*500), 0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7d,(int)(GlobalVariables.xScale_factor*870),0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7b,(int)(GlobalVariables.xScale_factor*615), 0, null);
			if(threadTimeController>100)subSwitchIndex=2;
			break;
		case 2:
			myConstant.drawImageAtExactPosition(canvas, link6_7a,0,0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7c,(int)(GlobalVariables.xScale_factor*500), 0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7d,(int)(GlobalVariables.xScale_factor*870),0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7b,(int)(GlobalVariables.xScale_factor*615), 0, null);
			myConstant.drawImageAtExactPosition(canvas, link6_7b,(int)(GlobalVariables.xScale_factor*990), 0, null);
			break;

		default:
			break;
		}
		
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_7a);
//				
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				subSwitchIndex=0;
				whichScene=8;
			}

	
		
	}


	private void scene_6(Canvas canvas) {
		 myConstant.drawImageAtExactPosition(canvas, link6_6a,(int)(GlobalVariables.xScale_factor*230), (int)(GlobalVariables.yScale_factor*110), null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*450),eyes.getHeight()/2+(int)(GlobalVariables.yScale_factor*55));
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*450),lips.getHeight()/2+(int)(GlobalVariables.yScale_factor*55));
		
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_6a);
//				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
//				mySound.stopSound();
//				threadTimeController=0;
			}
			
		switch(subSwitchIndex){
		case 0:
			if(threadTimeController>60)
			{
			  subSwitchIndex=1;
//			  threadTimeController=1;
			}
			break;
		case 1:
			link6_6bSpriteObj.drawSpriteAtExactPosition(canvas,link6_6bSpriteIndex, canvasWidth-link6_6b.getWidth()/link6_6bSpriteObj.getNoOfImagesInSprite(), 0, null);
			if(threadTimeController%15==0){
			  link6_6bSpriteIndex++;
			  if(link6_6bSpriteIndex==link6_6bSpriteObj.getNoOfImagesInSprite()){
				  link6_6bSpriteIndex=link6_6bSpriteObj.getNoOfImagesInSprite()-1;
				  if(threadTimeController>150){
					  whichScene=7;
					  subSwitchIndex=0;
					  mySound.stopSound();
					  threadTimeController=0;
				  }
			  }
			 
			  
			}

			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}


	private void scene_5(Canvas canvas) {
		 myConstant.drawImageAtExactPosition(canvas, link6_5a,canvasWidth/2-link6_5a.getWidth()/2, 0, null);

			mySound.playSound(R.raw.link6_5a);
				
			
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=6;
				subSwitchIndex=0;
			}
		
	}


	private void scene_4(Canvas canvas) {
		 myConstant.drawImageAtExactPosition(canvas, link6_4a,canvasWidth/2-link6_4a.getWidth()/2, 0, null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		 
		 
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_4a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=5;
			}
	}


	private void scene_3(Canvas canvas) {
		 myConstant.drawImageAtExactPosition(canvas, link6_3a,canvasWidth/2-link6_3a.getWidth()/2, 0, null);
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_3a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=4;
			}
		
	}


	private void scene_2(Canvas canvas) {
		
		 myConstant.drawImageAtExactPosition(canvas, link6_2a,canvasWidth/2-link6_2a.getWidth()/2, 0, null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		 
		 
		 if(threadTimeController>5){
				mySound.playSound(R.raw.link6_2a);
				subSwitchIndex=0;
			}
			if(threadTimeController>80){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=3;
			}
//        if(mySound.timerControllerMediaPlayer){
//            mySound.stopSound();
//            threadTimeController=0;
//            whichScene=3;
//            mySound.timerControllerMediaPlayer=false;
//
//        }

	}


	private void scene_1(Canvas canvas) {
		    myConstant.drawImageAtExactPosition(canvas, link6_1a,0, 0, null);
			spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*272),eyes.getHeight()/2+(int)(GlobalVariables.yScale_factor*10));
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*272),lips.getHeight()/2+(int)(GlobalVariables.yScale_factor*10));
//
//			if(threadTimeController%10==0){
//				if(spriteSwitcher)link6_1bSpriteIndex--;
//				else link6_1bSpriteIndex++;
//				if(link6_1bSpriteIndex==link6_1bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
//				if(link6_1bSpriteIndex==0)spriteSwitcher=false;
//			}
//			link6_1bSpriteObj.drawSpriteByRectF(canvas, rectf, link6_1bSpriteIndex, null);
			
			
			RectF rectf=new RectF(canvasWidth/2,0, canvasWidth/2+link6_1b.getWidth()-(link6_1b.getWidth()*10/100),link6_1b.getHeight()-(link6_1b.getHeight()*10/100));
			myConstant.drawImageWithRectF(canvas, rectf, link6_1b);
			
			
			if(threadTimeController>5){
				mySound.playSound(R.raw.link6_1a);
				subSwitchIndex=0;
			}
//			if(threadTimeController>190){//170
//				mySound.stopSound();
//				threadTimeController=0;
//				whichScene=2;
//			}

        if(mySound.timerControllerMediaPlayer){
            mySound.stopSound();
            threadTimeController=0;
            whichScene=2;
        }
	}


	private void scene_0(Canvas canvas) {
		myConstant.drawImageWithRotation(canvas);
	    loadImages();
	}
	

	
	private void drawButton(Canvas canvas, Bitmap btnBitmap,int xMidPosition, int yMidPosition) {
		Rect  btnBitmapS=new Rect(0,0,btnBitmap.getWidth(),btnBitmap.getHeight());
		buttonRectF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,null,buttonRectF,null);
	}


	private void drawText(Canvas canvas, String Text,int xMidPosition,int yMidPosition, int textSize) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.WHITE);
		paint.setTextSize(textSize);
		Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
		paint.setTypeface(tf);
		paint.setTextAlign(Align.CENTER);
		canvas.drawText(Text,xMidPosition,yMidPosition, paint);
	}

	private void drawImage(Canvas canvas, Bitmap btnBitmap,int xMidPosition, int yMidPosition) {
		Rect  btnBitmapS=new Rect(0,0,btnBitmap.getWidth(),btnBitmap.getHeight());
		imageRectF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,btnBitmapS,imageRectF,null);
	}
	private void drawBackground(Canvas canvas, Bitmap backGround) {
		Rect rectS=new Rect(0,0,backGround.getWidth(),backGround.getHeight());
		RectF rectF=new RectF(0,0,canvasWidth,canvasHeight);
		canvas.drawBitmap(backGround,rectS,rectF,null);
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
			case 8:
				if(imageRectF!=null&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0){
					Constant.mediaPlayerTouch.start();
					TF=false;
					gameThread=null;
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
		StoryPart_6_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_6_Canvas mycanvas) {
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
	
	Bitmap link6_1a;
	Bitmap link6_1b;
	Sprite link6_1bSpriteObj;
	int link6_1bSpriteIndex;
	Bitmap link6_2a;
	Bitmap link6_3a;
	Bitmap link6_4a;
	Bitmap link6_5a;
	Bitmap link6_6a;

	Bitmap link6_6b;
	Sprite link6_6bSpriteObj;
	int link6_6bSpriteIndex;
	
	Bitmap link6_8a;
	Bitmap link6_8b;
	Bitmap link6_7a;
	Bitmap link6_7b;
	Bitmap link6_7c;
	Bitmap link6_7d;
//	ShahSprite link6_1aSpriteObj;
//	int link5_6SpriteIndex;

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
		
		link6_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_1a);
		link6_1b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_12a);
		link6_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_12a);
		link6_3a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_3a);
		link6_4a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_2a_6a);
		link6_5a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_5a);
		link6_6a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_6a);
		link6_6b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_6b);
		link6_7a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_7a);
		link6_7b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_7b);
		link6_7c= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_7c);
		link6_7d= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_7d);
		link6_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
		link6_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link6_8a);
		link6_1bSpriteObj=new Sprite(link6_1b,6);
		link6_6bSpriteObj=new Sprite(link6_6b,3);
		threadTimeController=0;
		whichScene=1;
	}
	
	private void clearAll() {
		link6_1a.recycle();
		link6_1b.recycle();
		link6_2a.recycle();
		link6_3a.recycle();
		link6_4a.recycle();
		link6_5a.recycle();
		link6_6a.recycle();
		link6_6b.recycle();
		link6_7a.recycle();
		link6_7b.recycle();
		link6_7c.recycle();
		link6_7d.recycle();
		link6_8a.recycle();
		link6_8b.recycle();
		button.recycle();
		eyes.recycle();
		lips.recycle();
		System.gc();
	}
}

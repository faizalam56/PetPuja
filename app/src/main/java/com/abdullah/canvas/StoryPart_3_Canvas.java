package com.abdullah.canvas;


import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.ObjectMove;
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

public class StoryPart_3_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	ZoomInZoomOut zio;
	private RectF imageRectF,buttonNextF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paintFadeInOut,paintBtn;
	int indexFadeInOut=0;
	int subSwitchIndex;
	boolean TF=false,spriteSwitcher;
	Context context;
	Sprite drawMidSprite;
	int canvasWidth,canvasHeight;
    Constant myConstant;
	int whichScene=0;
	int threadTimeController=0,sleepTime=2;
	int moveFrom,moveTo;
	int time=0;
	float xDpi,yDpi;
	float xScale,yScale;
	float xMultiplyer,yMultiplyer;
	int xPoint,yPoint;
	ObjectMove objectMove;
	ObjectMove moveLeftToRight,moveRightToLeft;
	
	
	Sound mySound;
	Bitmap backGround,buttonNext;
	
	Bitmap eyes;
	Sprite spriteEyesObj;
	
	Bitmap faces,childLyrix;
	Sprite spriteChildObj,spriteLyrixChildObj;
	int lyrixIndex=0;
	
	Bitmap lips;
	Sprite spriteLipsObj;

	Bitmap link3_1a;
	Bitmap link3_1b;
	Sprite link3_1bSpriteObj;
	int link3_1bSpriteIndex;
	
	Bitmap link3_2a;
	
	Bitmap link3_2b;
	Sprite link3_2bSpriteObj;
	int link3_2bSpriteIndex;
	
	Bitmap link3_3a;
	
	Bitmap link3_3b;
	
	Bitmap link3_4a;
	Bitmap link3_4b;
	Bitmap link3_4c;
	Bitmap link3_4d;
	Bitmap link3_4e;
	Bitmap link3_4f;
	
	Bitmap link3_5a;
	
	Bitmap link3_5b;
	Sprite link3_5bSpriteObj;
	int link3_5bSpriteIndex;
	
	
	Bitmap link3_6a;
	
	Bitmap link3_6b;
	Sprite link3_6bSpriteObj;
	int link3_6bSpriteIndex;
	
	Bitmap link3_6c;
	
	Bitmap link3_7a;
	
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

	
	
	Bitmap link3_11a;
	Bitmap link3_11b;
	Bitmap link3_11c;
	
	Bitmap link3_12a;
	Bitmap link3_13a;
	Bitmap link3_13b;


    private long mLastTime;//by Faiyaz

    public StoryPart_3_Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant(context);
		paintFadeInOut=new Paint(Paint.ANTI_ALIAS_FLAG);
		mySound=new Sound(context);
		backGround = myConstant.backGround;
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
		
//		
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
		if(Constant.HEADER==1){
			myConstant.drawText(canvas,"threadTimeController : "+threadTimeController +"."+subSwitchIndex,100,100,20);
			myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene +"."+subSwitchIndex,canvasWidth/2,100,20);		
		}
		
//		if(whichScene>0)
//			drawButtonNext(canvas, buttonNext, canvasWidth/2,canvasHeight-buttonNext.getHeight());
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
		case 13:
			scene_13(canvas);
			break;
		case 14:
			scene_14(canvas);
			break;
		
		}
   
		
	}

	private void scene_14(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}


	private void scene_13(Canvas canvas) {
		switch (subSwitchIndex) {
		case 0:
			mySound.playSound(R.raw.link3_13a);
			myConstant.drawImageAtExactPosition(canvas, link3_13b,(int)(GlobalVariables.xScale_factor*75),0, null);
			spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*381),lips.getHeight()/2);
			imageRectF=new RectF(canvasWidth-link3_13a.getWidth()-(int)(GlobalVariables.xScale_factor*90),(int)(GlobalVariables.yScale_factor*117),canvasWidth-(int)(GlobalVariables.xScale_factor*90),link3_13a.getHeight()+(int)(GlobalVariables.yScale_factor*117));
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_13a);
			if(mySound.ifPlaying()==0)subSwitchIndex=1;
			break;
		case 1:
			if(!link3_13b.isRecycled())
			myConstant.drawImageAtExactPosition(canvas, link3_13b,(int)(GlobalVariables.xScale_factor*75),0, null);
			if(!eyes.isRecycled())
			spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*381),eyes.getHeight()/2);
			if(!lips.isRecycled())
			spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*381),lips.getHeight()/2);
			if(!link3_13a.isRecycled()){
				imageRectF=new RectF(canvasWidth-link3_13a.getWidth()-(int)(GlobalVariables.xScale_factor*90),(int)(GlobalVariables.yScale_factor*117),canvasWidth-(int)(GlobalVariables.xScale_factor*90),link3_13a.getHeight()+(int)(GlobalVariables.yScale_factor*117));
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_13a);
			}
			Constant.drawButtonReplay(canvas);
			break;
		default:
			break;
		
	 }
		
		
		
		if(mySound.ifPlaying()==0){
			subSwitchIndex=1;
	     }
	}

	private void scene_12(Canvas canvas) {
		myConstant.drawImage(canvas, link3_12a, canvasWidth/2,canvasHeight/2,null);
		
		
		mySound.playSound(R.raw.link3_12a);
	
		
//		if(threadTimeController>100){
//			mySound.stopSound();
////			link3_11a=null;
//////		link3_11b=null;
////			link3_11c=null;
//			link3_13a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_13a);
//			link3_13b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
//			whichScene=13;
//			subSwitchIndex=0;
//			threadTimeController=0;
////			objectMove=new ObjectMove(context,canvasWidth, canvasWidth-link3_11b.getWidth());
//		}


        if(mySound.ifPlaying()==0){//by Faiyaz
            mySound.stopSound();
//			link3_11a=null;
////		link3_11b=null;
//			link3_11c=null;
            link3_13a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_13a);
            link3_13b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
            whichScene=13;
            subSwitchIndex=0;
            threadTimeController=0;
//			objectMove=new ObjectMove(context,canvasWidth, canvasWidth-link3_11b.getWidth());
        }
		
		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2-(int)(GlobalVariables.xScale_factor*3),eyes.getHeight()/2);
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2-(int)(GlobalVariables.xScale_factor*3),lips.getHeight()/2);

	}


	private void scene_11(Canvas canvas) {
		myConstant.drawImage(canvas, link3_11a, canvasWidth/2,canvasHeight/2,null);
		int mv=objectMove.MoveImageHorizontallyNew(canvas, link3_11b, canvasHeight/2-link3_11b.getHeight()/2, 2,40, null);
        if(mv==0){
		myConstant.drawImage(canvas, link3_11c, canvasWidth/2-link3_11c.getWidth()*3/2,canvasHeight/2+(int)(100*GlobalVariables.yScale_factor),null);
        }
        
       
		mySound.playSound(R.raw.link3_11a);
	
		
		if(threadTimeController>70){
			mySound.stopSound();
			faces=null;
			childLyrix=null;
			link3_12a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_12a);
			whichScene=12;
			subSwitchIndex=0;
			threadTimeController=0;
		}
		
		
	}


	private void scene_10(Canvas canvas) {
		spriteChildObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2, null);
		drawChildLyrixMove(canvas);
		
		
			mySound.playSound(R.raw.link3_10a);
	
		
		if(mySound.ifPlaying()==0){
			link3_8a.recycle();
			link3_8b.recycle();
			link3_8c.recycle();
			link3_8d.recycle();
			link3_8e.recycle();
			link3_8f.recycle();
			link3_8g.recycle();
			link3_8h.recycle();
			mySound.stopSound();
			link3_11a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_11a);
			link3_11b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_11b);
			link3_11c=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_11c);
			whichScene=11;
			subSwitchIndex=0;
			threadTimeController=0;
			objectMove=new ObjectMove(context,canvasWidth, canvasWidth-link3_11b.getWidth());
			backGround=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.background);
		}
		
	}


	private void scene_9(Canvas canvas) {
		
		switch(subSwitchIndex){
		case 0:
			myConstant.drawImageAtExactPosition(canvas, link3_9a, canvasWidth/2-link3_9a.getWidth()/2, canvasHeight/2-link3_9a.getHeight()/2, null);
			if(threadTimeController>45)subSwitchIndex=1;
			break;
		case 1:
			myConstant.drawImageAtExactPosition(canvas, link3_9b, canvasWidth/2-link3_9b.getWidth()/2, canvasHeight/2-link3_9b.getHeight()/2, null);
			if(threadTimeController>55)subSwitchIndex=2;
			break;
		case 2:

			if(threadTimeController%7==0){
				if(link3_9cSpriteIndex<link3_9cSpriteObj.getNoOfImagesInSprite()-1)link3_9cSpriteIndex++;
			}
			
			link3_9cSpriteObj.drawSpriteAtExactPosition(canvas,link3_9cSpriteIndex, canvasWidth/2-link3_9c.getWidth()/(2*link3_9cSpriteObj.getNoOfImagesInSprite()),canvasHeight/2-link3_9c.getHeight()/2, null);
			break;
		case 3:
			break;
		}
		 
		mySound.playSound(R.raw.link3_9a);

		
//		if(threadTimeController>130){
//			mySound.stopSound();
//			link3_9cSpriteIndex=0;
//			whichScene=10;
//			subSwitchIndex=0;
//			threadTimeController=0;
//			backGround=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4a);
//		}

        if(mySound.ifPlaying()==0){//by Faiyaz
            mySound.stopSound();
            link3_9cSpriteIndex=0;
            whichScene=10;
            subSwitchIndex=0;
            threadTimeController=0;
            backGround=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4a);
        }
		
		spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2-(int)(GlobalVariables.xScale_factor*12),eyes.getHeight()/2+(int)(GlobalVariables.yScale_factor*2));
		spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvas.getWidth()/2-(int)(GlobalVariables.xScale_factor*12),lips.getHeight()/2+(int)(GlobalVariables.yScale_factor*2));
	}


	private void scene_8(Canvas canvas) {
		switch (subSwitchIndex) {
		case 0:
			xDpi=(float)link3_8a.getWidth()/canvasWidth;
			yDpi=(float)link3_8a.getHeight()/canvasHeight;
			xMultiplyer=xDpi*yDpi;
			yMultiplyer=xDpi*yDpi;
			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+(int)(GlobalVariables.xScale_factor*20),(int)(GlobalVariables.yScale_factor*60)+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+(int)(GlobalVariables.xScale_factor*20),(int)(GlobalVariables.yScale_factor*60)+canvasHeight/2+link3_8a.getHeight()/2-yScale);
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			if(threadTimeController>20){
				threadTimeController=0;
				subSwitchIndex=1;
			}
			break;
		case 1:
			mySound.playSound(R.raw.link3_8a);
			if(threadTimeController<38){
			xScale+=(int)(GlobalVariables.xScale_factor*40)*xMultiplyer;
			yScale+=(int)(GlobalVariables.yScale_factor*40)*yMultiplyer;
			}
			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+(int)(GlobalVariables.xScale_factor*20),(int)(GlobalVariables.yScale_factor*60)+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+(int)(GlobalVariables.xScale_factor*20),(int)(GlobalVariables.yScale_factor*60)+canvasHeight/2+link3_8a.getHeight()/2-yScale);
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			if(threadTimeController>50){
				subSwitchIndex=2;
				threadTimeController=0;
				xPoint=0;
			}
			
			
			break;
		case 2:
			yPoint=(int)(GlobalVariables.yScale_factor*145);
//			xPoint=-200;
			moveFrom=canvasWidth;
			moveTo=canvasWidth/2;
			if(xPoint<moveTo&&threadTimeController%7==0){
				time++;
				xPoint+=(int)(GlobalVariables.xScale_factor*68);
				
			}
			if(time%2==0)link3_8bSpriteIndex=1;
			else link3_8bSpriteIndex=0;
			
			
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController%10==0)
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, link3_8bSpriteIndex, canvasWidth-(int)xPoint,(int)yPoint, null);
//			else 
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas,link3_8bSpriteIndex, canvasWidth-(int)xPoint,(int)yPoint, null);
			
			if(xPoint>moveTo){
				threadTimeController=0;
				subSwitchIndex=3;
			}
			break;
		case 3:
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			moveLeftToRight.MoveImageHorizontallyNew(canvas, link3_8c,(int)(GlobalVariables.yScale_factor*345),1,20, null);
			int motion=moveRightToLeft.MoveImageHorizontallyNew(canvas, link3_8d,(int)(GlobalVariables.yScale_factor*345),2,30, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			
			if(motion==0){
				subSwitchIndex=4;
				threadTimeController=0;
			}
			break;
		case 4:
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			if(threadTimeController<10)link3_8eSpriteIndex=0;
			else link3_8eSpriteIndex=1;
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			if(threadTimeController>20){
				threadTimeController=0;
				subSwitchIndex=5;
			}
			break;
		case 5:
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			if(threadTimeController>0&threadTimeController<10)link3_8fSpriteIndex=0;
			else if(threadTimeController>10&threadTimeController<20)link3_8fSpriteIndex=1;
			else if(threadTimeController>20&threadTimeController<30)link3_8fSpriteIndex=0;
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(GlobalVariables.xScale_factor*25), 0, null);
			if(threadTimeController>40){
				threadTimeController=0;
				subSwitchIndex=6;
			}
			break;
		case 6:
			if(threadTimeController%2==0){
				if(link3_8gSpriteIndex<link3_8gSpriteObj.getNoOfImagesInSprite()-1)link3_8gSpriteIndex++;
			}
			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null);
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(GlobalVariables.xScale_factor*25), 0, null);
				
			if(threadTimeController>10){
				threadTimeController=0;
				subSwitchIndex=7;
			}
			break;
		case 7:
			if(threadTimeController%2==0){
				if(link3_8hSpriteIndex<link3_8hSpriteObj.getNoOfImagesInSprite()-1)link3_8hSpriteIndex++;
			}
			link3_8hSpriteObj.drawSpriteAtExactPosition(canvas, link3_8hSpriteIndex, canvasWidth/2-link3_8h.getWidth()/12, 0, null); // bottom text
			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null); // background
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(GlobalVariables.xScale_factor*25), 0, null);
			if(threadTimeController>20){


				threadTimeController=0;
				subSwitchIndex=0;
			    whichScene=9;
			    mySound.stopSound();
			}
			break;
		case 8:
			
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


	private void scene_7(Canvas canvas) {
		myConstant.drawImageAtExactPosition(canvas, link3_7a, canvasWidth/2-link3_7a.getWidth()/2, canvasHeight/2-link3_7a.getHeight()/2, null);
//		if(threadTimeController>50)
//		myConstant.drawImageAtExactPosition(canvas, link3_5b, canvasWidth/2-link3_5b.getWidth()/2, canvasHeight/2-link3_5b.getHeight()/2, null);
	
		if(threadTimeController>10){
			mySound.playSound(R.raw.link3_7a);
		}
		
		if(threadTimeController<65)spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(),canvas.getWidth()/2+(int)(GlobalVariables.xScale_factor*40),lips.getHeight()/2);
		
		if(mySound.ifPlaying()==0&&threadTimeController>70){
			mySound.stopSound();
			whichScene=8;
			subSwitchIndex=0;
			threadTimeController=0;
			moveLeftToRight=new ObjectMove(context,0,(int)(GlobalVariables.xScale_factor*400));
			moveRightToLeft=new ObjectMove(context,canvasWidth-(int)(GlobalVariables.xScale_factor*100),canvasWidth/2);
			
			link3_6a.recycle();
			link3_6b.recycle();
			link3_6c.recycle();
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
			
			moveLeftToRight=new ObjectMove(context,0,canvasWidth/2-link3_8c.getWidth()-(int)(GlobalVariables.xScale_factor*60));//
			moveRightToLeft=new ObjectMove(context,canvasWidth-link3_8d.getWidth(),canvasWidth/2-(int)(GlobalVariables.xScale_factor*50));
		}
		
	}


	private void scene_6(Canvas canvas) {
		int val=-1;
		switch (subSwitchIndex) {
		case 0:
			zio=new ZoomInZoomOut(canvas,link3_6a,20,canvasWidth/2, canvasHeight/2,10);
			subSwitchIndex=1;
			indexFadeInOut=0;
		case 1:
			val=zio.zoomOut(null);
			if(val==0)subSwitchIndex=2;
			break;
        
		case 2:
			zio.zoomOut(null);
			if(threadTimeController>100)subSwitchIndex=3;
			break;
		case 3:
			if(indexFadeInOut<255)indexFadeInOut+=15;
			paintFadeInOut.setAlpha(255-indexFadeInOut);
			zio.zoomOut(paintFadeInOut);
			paintFadeInOut.setAlpha(indexFadeInOut);
			myConstant.drawImageAtExactPosition(canvas, link3_6c, canvasWidth/2-link3_6c.getWidth()/2, canvasHeight/2-link3_6c.getHeight()/2, paintFadeInOut);
			
			if(threadTimeController%10==0){
				if(link3_6bSpriteIndex==1)link3_6bSpriteIndex=0;
				else link3_6bSpriteIndex=1;
				
//				if(link3_6bSpriteIndex==link3_6bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
//				if(link3_6bSpriteIndex==0)spriteSwitcher=false;
			}
			
			link3_6bSpriteObj.drawSpriteAtExactPosition(canvas, link3_6bSpriteIndex, (int)(GlobalVariables.xScale_factor*100),0, paintFadeInOut);
			
			break;
		default:
			break;
		}
		

		mySound.playSound(R.raw.link3_6a);
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=7;
			subSwitchIndex=0;
			threadTimeController=0;
			
			link3_5a.recycle();
			link3_5b.recycle();

			
		}
		
	}


	private void scene_5(Canvas canvas) {
		switch (subSwitchIndex) {
		case 0:
			 if(threadTimeController>130)subSwitchIndex=1;
			break;
		case 1:
			 link3_5bSpriteObj.drawSpriteAtExactPosition(canvas, 0, canvasWidth-link3_5b.getWidth()/2, 0, null);
			 if(threadTimeController>145)subSwitchIndex=2;
			break;
		case 2:
			 link3_5bSpriteObj.drawSpriteAtExactPosition(canvas, 0, canvasWidth-link3_5b.getWidth()/2, 0, null);
			 link3_5bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-link3_5b.getWidth()/2, 0, null);
			break;

		default:
			break;
		}
		myConstant.drawImageAtExactPosition(canvas, link3_5a, canvasWidth/2-link3_5a.getWidth()/2, 0, null);
		
			mySound.playSound(R.raw.link3_5a);
	
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			link3_4b.recycle();
			link3_4d.recycle();
			link3_4e.recycle();
			link3_4f.recycle();
			backGround=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.background);
			whichScene=6;
			subSwitchIndex=0;
			threadTimeController=0;
		}
	}


	private void scene_4(Canvas canvas) {
//		myConstant.drawImageAtExactPosition(canvas, link3_4a, canvasWidth/2-link3_4a.getWidth()/2, canvasHeight/2-link3_4a.getHeight()/2, null);
		myConstant.drawImageAtExactPosition(canvas, link3_4b, canvasWidth/2-link3_4b.getWidth()/2,0, null);

		if(threadTimeController>120)myConstant.drawImageAtExactPosition(canvas, link3_4c,(int)(GlobalVariables.xScale_factor*361),0, null);
		if(threadTimeController>130)myConstant.drawImageAtExactPosition(canvas, link3_4d, (int)(GlobalVariables.xScale_factor*211),0, null);
		if(threadTimeController>140)myConstant.drawImageAtExactPosition(canvas, link3_4e,(int)(GlobalVariables.xScale_factor*857),0, null);
		if(threadTimeController>150)myConstant.drawImageAtExactPosition(canvas, link3_4f, (int)(GlobalVariables.xScale_factor*869),0, null);




        mySound.playSound(R.raw.link3_4a);
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();

			whichScene=5;
			subSwitchIndex=0;
			threadTimeController=0;
			
		
			link3_3a.recycle();
			link3_3b.recycle();
			
		}

	}


	private void scene_3(Canvas canvas) {
		int val=-1;
		switch(subSwitchIndex){
		case 0:
			zio=new ZoomInZoomOut(canvas, link3_3b,20,canvasWidth-link3_3b.getWidth(), canvasHeight/2,10);
			subSwitchIndex=1;
			break;
		case 1:
			val=zio.zoomOut(null);
			if(val==0)subSwitchIndex=2;
			break;
		case 2:
			zio.zoomOut(null);
			myConstant.drawImageAtExactPosition(canvas, link3_3a, canvasWidth/2-link3_3b.getWidth()/2-link3_3a.getWidth()/2, canvasHeight/2-link3_3a.getHeight()/2, null);
			break;
		case 3:
			break;
			
		}
		
//		myConstant.drawImageAtExactPosition(canvas, link3_3b, canvasWidth/2-link3_3b.getWidth()/2+link3_3a.getWidth(), canvasHeight/2-link3_3b.getHeight()/2, null);
		
	
			mySound.playSound(R.raw.link3_3a);
		
		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=4;
			threadTimeController=0;
			link3_2a.recycle();
			link3_2b.recycle();
			subSwitchIndex=0;
			backGround=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4a);
			link3_5a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_5a);
			link3_5b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_5b);
			link3_5bSpriteObj=new Sprite(link3_5b, 2);
		}
		
	}


	private void scene_2(Canvas canvas) {
		
		myConstant.drawImageAtExactPosition(canvas, link3_2a, canvasWidth/2-link3_2a.getWidth()/2, 0, null);
		
		if(threadTimeController%10==0){
			if(spriteSwitcher)link3_2bSpriteIndex--;
			else link3_2bSpriteIndex++;
			
			if(link3_2bSpriteIndex==link3_2bSpriteObj.getNoOfImagesInSprite()-1)spriteSwitcher=true;
			if(link3_2bSpriteIndex==0)spriteSwitcher=false;
		}
		link3_2bSpriteObj.drawSpriteAtExactPosition(canvas, link3_2bSpriteIndex, canvasWidth-(link3_2b.getWidth()/link3_2bSpriteObj.getNoOfImagesInSprite())*4/3,canvasHeight/2-link3_2b.getHeight()/2, null);
		
	
	    mySound.playSound(R.raw.link3_2a);

		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=3;
			threadTimeController=0;
			
			link3_1a.recycle();
			link3_1b.recycle();
			link3_4b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4b);
			link3_4c=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4c);
			link3_4d=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4d);
			link3_4e=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4e);
			link3_4f=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4f);
		}
		
	}


	private void scene_1(Canvas canvas) {
		
		myConstant.drawImageAtExactPosition(canvas, link3_1a, canvasWidth/2-link3_1a.getWidth()/2, 0, null);
		link3_1bSpriteObj.drawSpriteAtExactPosition(canvas, link3_1bSpriteIndex, canvasWidth/2-link3_1b.getWidth()/(2*link3_1bSpriteObj.getNoOfImagesInSprite()),0, null);
		
		spriteEyesObj.drawEyesSprite(canvas,eyes,canvasWidth/2,eyes.getHeight()/2);
        spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(),canvas.getWidth()/2,lips.getHeight()/2);
		
		if(threadTimeController>10){
			if(threadTimeController%5==0){
				if(link3_1bSpriteIndex<link3_1bSpriteObj.getNoOfImagesInSprite()-1)link3_1bSpriteIndex++;
			}
			mySound.playSound(R.raw.link3_1a);
		}

		if(mySound.ifPlaying()==0){
			mySound.stopSound();
			whichScene=2;
			threadTimeController=0;
			
			link3_3a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_3a);
			link3_3b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_9a);
		}
	}


	private void scene_0(Canvas canvas) {
		myConstant.drawImageWithRotation(canvas);
	    loadImages();
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
			if(buttonNextF!=null&&buttonNextF.intersect(touchrecF)){
				if(whichScene<10){
					mySound.stopSound();
					whichScene++;
					threadTimeController=0;
				}
			}
			switch(whichScene){
			case 0:
				
				break;
			case 13:
				if(imageRectF!=null&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0&subSwitchIndex==1){
					Constant.mediaPlayerTouch.start();
					subSwitchIndex=2;
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

		}
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart_3_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_3_Canvas mycanvas) {
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
	Bitmap link3_9a;
	Bitmap link3_9b;
	Bitmap link3_9c;
	Sprite link3_9cSpriteObj;
	int link3_9cSpriteIndex;
	

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
		spriteEyesObj=new Sprite(eyes,4);
		spriteLipsObj=new Sprite(lips,13);
		buttonNext=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
		link3_1a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15a);
		link3_1b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15b);
		link3_2a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2a);
		link3_2b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_2b);
		
//		link3_4a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4a);
		
		
		link3_6a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_6a);
		link3_6c=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_6c);
		link3_7a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_7a);
		link3_6b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_6b);
		link3_9c=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_9c);
		link3_9cSpriteObj=new Sprite(link3_9c, 4); 
//		link3_8=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.petpuja_logo_fade);
		
		faces= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_mouth_opening_sprite);
		childLyrix= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_laranx_sprite);
		link3_9a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_9a);
		link3_9b=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_9b);
		
		

		
		
		link3_1bSpriteObj=new Sprite(link3_1b, 6);
		link3_2bSpriteObj=new Sprite(link3_2b, 3);
		
		link3_6bSpriteObj=new Sprite(link3_6b, 2);
		
		
		
		
		
		
		
		
		spriteChildObj=new Sprite(faces,2);
		spriteLyrixChildObj=new Sprite(childLyrix,8);
		
		whichScene=1;
		threadTimeController=0;
	}
	
private void drawChildLyrixMove(Canvas canvas) {
		RectF rectLyrixF=new RectF(canvasWidth/2-childLyrix.getWidth()/16,canvasHeight/2-childLyrix.getHeight()/2-2,canvasWidth/2+childLyrix.getWidth()/16,canvasHeight/2+childLyrix.getHeight()/2-2);
		spriteLyrixChildObj.drawSpriteByRectF(canvas, rectLyrixF, lyrixIndex,null);
        
		if(threadTimeController%5==0){     
			 if(lyrixIndex<7)lyrixIndex++;
		        else lyrixIndex=0;
		}
       
}
public void clearAll(){
		eyes.recycle();
		lips.recycle();
		
		
		
		link3_7a.recycle();
		link3_9a.recycle();
		link3_9b.recycle();
		link3_11a.recycle();
		link3_11b.recycle();
		link3_11c.recycle();
		link3_12a.recycle();
		link3_13a.recycle();
		link3_13b.recycle();
		
		link3_1bSpriteObj=null;
		link3_2bSpriteObj=null;
		link3_5bSpriteObj=null;
		link3_6bSpriteObj=null;
		
		link3_8bSpriteObj=null;
		link3_8eSpriteObj=null;
		link3_8fSpriteObj=null;
		link3_8gSpriteObj=null;
		link3_8hSpriteObj=null;
//		System.gc();
}
	
}

package com.abdullah.canvas;


import com.aasif.utility.MyPreference;
import com.aasif.utility.Utitlity;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.ObjectMove;
import com.abdullah.petpuja.PetPuja;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.VideoPlayNew;
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
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart_7_Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	Bitmap girl1,backGround,button,sprite,image1,image2,image3,image4;
	private RectF imageRectF, movieRectF,movie2RectF,movie3RectF,buttonNextF,buttonRectF;
	private Rect buttonRectS,imageRectS;
	Canvas canvas;
	Paint paint1,paintBtn;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false;
	Context context;
	Sprite drawMidSprite;

	int time=0;
	float xDpi,yDpi;
	float xScale,yScale;
	float xMultiplyer,yMultiplyer;
	int xPoint,yPoint;
	int moveFrom,moveTo;
	ObjectMove objectMove;
	ObjectMove moveLeftToRight,moveRightToLeft;
	
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
	
	
	    public StoryPart_7_Canvas(Context context) {
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
		
		myConstant.drawBackground(canvas,backGround);
		drawAnimation(canvas,whichScene);
		
		
		if(Constant.HEADER==1)
			myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+"."+subSwitchIndex +"::"+threadTimeController,canvasWidth/2,100,20);
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
		
		if(whichScene>0){
//			buttonNextF=new RectF(canvas.getWidth()/2-button.getWidth()/2,canvas.getHeight()-button.getHeight(),canvas.getWidth()/2+button.getWidth()/2,canvas.getHeight());
//			myConstant.drawButtonNext(canvas, button,buttonNextF);
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
		case 13:
			scene_13(canvas);
			break;
		case 14:
			scene_14(canvas);
			break;
			default:
				
		}
   
		
	}
	
	
	private void scene_14(Canvas canvas) {
        if(!link7_13a.isRecycled())myConstant.drawImageAtExactPosition(canvas,link7_13a,(int)(GlobalVariables.xScale_factor*100),0,null);
//		 myConstant.drawImageAtExactPosition(canvas,link7_13b,canvasWidth-link7_13b.getWidth(),0,null);
        if(!eyes.isRecycled())spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*378),eyes.getHeight()/2);
        if(!lips.isRecycled())spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*378),lips.getHeight()/2);

        if(movieImage1!=null){
            movieRectF=new RectF(canvasWidth-movieImage1.getWidth()*3/2,canvasHeight/2-movieImage2.getHeight()/2-movieImage1.getHeight(),canvasWidth-movieImage1.getWidth()/2,canvasHeight/2-movieImage2.getHeight()/2);
            myConstant.drawImageWithRectF(canvas, movieRectF, movieImage1);
        }
        if(movieImage2!=null){
            movie2RectF=new RectF(canvasWidth-movieImage2.getWidth()*3/2,canvasHeight/2-movieImage2.getHeight()/2,canvasWidth-movieImage2.getWidth()/2,canvasHeight/2+movieImage2.getHeight()/2);
            myConstant.drawImageWithRectF(canvas, movie2RectF, movieImage2);
        }
        if(movieImage3!=null){
            movie3RectF=new RectF(canvasWidth-movieImage3.getWidth()*3/2,canvasHeight/2+movieImage2.getHeight()/2,canvasWidth-movieImage3.getWidth()/2,canvasHeight/2+movieImage2.getHeight()/2+movieImage3.getHeight());
            myConstant.drawImageWithRectF(canvas, movie3RectF, movieImage3);
        }

         Constant.drawButtonReplay(canvas);
	}


	private void scene_13(Canvas canvas) {
		 if(!link7_13a.isRecycled())myConstant.drawImageAtExactPosition(canvas,link7_13a,(int)(GlobalVariables.xScale_factor*100),0,null);
//		 myConstant.drawImageAtExactPosition(canvas,link7_13b,canvasWidth-link7_13b.getWidth(),0,null);
		 if(!eyes.isRecycled())spriteEyesObj.drawEyesSprite(canvas, eyes,(int)(GlobalVariables.xScale_factor*378),eyes.getHeight()/2);
		 if(!lips.isRecycled())spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*378),lips.getHeight()/2);
		
		 if(movieImage1!=null){
		 movieRectF=new RectF(canvasWidth-movieImage1.getWidth()*3/2,canvasHeight/2-movieImage2.getHeight()/2-movieImage1.getHeight(),canvasWidth-movieImage1.getWidth()/2,canvasHeight/2-movieImage2.getHeight()/2);
		 myConstant.drawImageWithRectF(canvas, movieRectF, movieImage1);
		 }
		 if(movieImage2!=null){
		 movie2RectF=new RectF(canvasWidth-movieImage2.getWidth()*3/2,canvasHeight/2-movieImage2.getHeight()/2,canvasWidth-movieImage2.getWidth()/2,canvasHeight/2+movieImage2.getHeight()/2);
		 myConstant.drawImageWithRectF(canvas, movie2RectF, movieImage2);
		 }
		 if(movieImage3!=null){
	     movie3RectF=new RectF(canvasWidth-movieImage3.getWidth()*3/2,canvasHeight/2+movieImage2.getHeight()/2,canvasWidth-movieImage3.getWidth()/2,canvasHeight/2+movieImage2.getHeight()/2+movieImage3.getHeight());
	     myConstant.drawImageWithRectF(canvas, movie3RectF, movieImage3);
		 }
		 
		 if(threadTimeController>0&threadTimeController<10){
				mySound.playSound(R.raw.link7_13a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()>0){
//				mySound.stopSound();
				threadTimeController=20;
				subSwitchIndex=1;
//				whichScene=14;
			}
			if(mySound.ifPlaying()==0){
//				Constant.drawButtonReplay(canvas);
                whichScene=14;
			}
	}
	
	
	private void scene_12(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_12a,canvasWidth/2,canvasHeight/2,null);
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_12a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=13;
			}
		
	}
	
	private void scene_11(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_11a,canvasWidth/2,canvasHeight/2,null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		 
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_11a);
				subSwitchIndex=0;
			}
			if(threadTimeController>210){
				link3_8.recycle();
				link3_8a.recycle();
				link3_8b.recycle();
				link3_8c.recycle();
				link3_8d.recycle();
				link3_8e.recycle();
				link3_8f.recycle();
				link3_8g.recycle();
				link3_8h.recycle();
				mySound.stopSound();
				threadTimeController=0;
				whichScene=12;
			}
		
	}
	private void scene_10(Canvas canvas) {
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
			moveFrom=canvasWidth;
			moveTo=canvasWidth/2;
			if(xPoint<moveTo&&threadTimeController%7==0){
				time++;
				xPoint+=(int)(GlobalVariables.xScale_factor*68);//Doubt
				
			}
			if(time%2==0)link3_8bSpriteIndex=1;
			else link3_8bSpriteIndex=0;
			
			
			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
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
			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4-(int)(GlobalVariables.yScale_factor*25), 0, null);
				
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
			    whichScene=11;
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

//	private void scene_10(Canvas canvas) {
//		switch (subSwitchIndex) {
//		case 0:
//			xDpi=(float)link3_8a.getWidth()/canvasWidth;
//			yDpi=(float)link3_8a.getHeight()/canvasHeight;
//			xMultiplyer=xDpi*yDpi;
//			yMultiplyer=xDpi*yDpi;
//			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+20,60+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+20,60+canvasHeight/2+link3_8a.getHeight()/2-yScale);
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController>20){
//				threadTimeController=0;
//				subSwitchIndex=1;
//			}
//			break;
//		case 1:
//			if(threadTimeController<75){
//			xScale+=20*xMultiplyer;
//			yScale+=20*yMultiplyer;
//			}
//			imageRectF=new RectF(canvasWidth/2-link3_8a.getWidth()/2+20,60+canvasHeight/2-link3_8a.getHeight()/2,canvasWidth/2+link3_8a.getWidth()/2-xScale+20,60+canvasHeight/2+link3_8a.getHeight()/2-yScale);
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController>120){
//				subSwitchIndex=2;
//				threadTimeController=0;
//				xPoint=0;
//			}
//			
//			
//			break;
//		case 2:
//			mySound.playSound(R.raw.link7_10a);
//			yPoint=145;
////			xPoint=-200;
//			moveFrom=canvasWidth;
//			moveTo=canvasWidth/2;
//			if(xPoint<moveTo&&threadTimeController%10==0){
//				time++;
//				xPoint+=68;
//			}
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController%20<9)
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 0, canvasWidth-(int)xPoint,(int)yPoint, null);
//			else link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			
//			if(xPoint>moveTo){
//				threadTimeController=0;
//				subSwitchIndex=3;
//			}
//			break;
//		case 3:
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			moveLeftToRight.MoveImageHorizontallyNew(canvas, link3_8c,345,1,20, null);
//			int motion=moveRightToLeft.MoveImageHorizontallyNew(canvas, link3_8d,345,2,20, null);
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			
//			if(motion==0){
//				subSwitchIndex=4;
//				threadTimeController=0;
//			}
//			break;
//		case 4:
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			if(threadTimeController<10)link3_8eSpriteIndex=0;
//			else link3_8eSpriteIndex=1;
//			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			if(threadTimeController>20){
//				threadTimeController=0;
//				subSwitchIndex=5;
//			}
//			break;
//		case 5:
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			if(threadTimeController<20)link3_8fSpriteIndex=1;
//			else link3_8fSpriteIndex=0;
//			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
//			if(threadTimeController>50){
//				threadTimeController=0;
//				subSwitchIndex=6;
//			}
//			break;
//		case 6:
//			if(threadTimeController%10==0){
//				if(link3_8gSpriteIndex<link3_8gSpriteObj.getNoOfImagesInSprite()-1)link3_8gSpriteIndex++;
//			}
//			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null);
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
//			
//			if(threadTimeController>50){
//				threadTimeController=0;
//				subSwitchIndex=7;
//			}
//			break;
//		case 7:
//			if(threadTimeController%10==0){
//				if(link3_8hSpriteIndex<link3_8hSpriteObj.getNoOfImagesInSprite()-1)link3_8hSpriteIndex++;
//			}
//			link3_8hSpriteObj.drawSpriteAtExactPosition(canvas, link3_8hSpriteIndex, canvasWidth/2-link3_8h.getWidth()/12, 0, null); // bottom text
//			link3_8gSpriteObj.drawSpriteAtExactPosition(canvas, link3_8gSpriteIndex, canvasWidth/2-link3_8g.getWidth()/8, 0, null); // background
//			myConstant.drawImageWithRectF(canvas, imageRectF, link3_8a);
//			link3_8eSpriteObj.drawSpriteAtExactPosition(canvas, link3_8eSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null); // child
//			link3_8bSpriteObj.drawSpriteAtExactPosition(canvas, 1, canvasWidth-(int)xPoint,(int)yPoint, null);
//			link3_8fSpriteObj.drawSpriteAtExactPosition(canvas, link3_8fSpriteIndex, canvasWidth/2-link3_8e.getWidth()/4, 0, null);
//			if(threadTimeController>100){
//				threadTimeController=0;
//				subSwitchIndex=0;
//			    whichScene=11;
//			}
//			break;
//		default:
//			break;
//		}
//		
////		 if(threadTimeController>50){
////				
////			}
//			if(mySound.ifPlaying()==0){
//				mySound.stopSound();
//			}	
//	}


	private void scene_9(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_9a,canvasWidth/2,canvasHeight/2,null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		 
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_9a);
				subSwitchIndex=0;
			}
			if(threadTimeController>80){
				mySound.stopSound();
				threadTimeController=0;
				moveLeftToRight=new ObjectMove(context,0,canvasWidth/2);
				moveRightToLeft=new ObjectMove(context,canvasWidth,canvasWidth/2);
				whichScene=10;
			}
		
	}


	private void scene_8(Canvas canvas) {
        myConstant.drawImageAtExactPosition(canvas, link7_8a,0,0,null);
        myConstant.drawImageAtExactPosition(canvas, link7_8b,canvasWidth-link7_8b.getWidth(),0,null);
		 
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_8a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=9;
			}
		
	}


	private void scene_7(Canvas canvas) {
		switch(subSwitchIndex){
		case 0:
			 myConstant.drawImageAtExactPosition(canvas, link7_7a,0,0,null);
			 if(threadTimeController>50)
				 {
				  subSwitchIndex=1;
				  threadTimeController=0;
				 }
			break;
		case 1:
			 myConstant.drawImageAtExactPosition(canvas, link7_7a,0,0,null);
			 myConstant.drawImage(canvas, link7_7b,canvasWidth/2-(int)(GlobalVariables.xScale_factor*40),link7_7b.getHeight()/2,null);
			 if(threadTimeController>50)
			 {
			  subSwitchIndex=2;
			  threadTimeController=0;
			 }
			break;
		case 2:
			 myConstant.drawImageAtExactPosition(canvas, link7_7a,0,0,null);
			 myConstant.drawImage(canvas, link7_7b,canvasWidth/2-(int)(GlobalVariables.xScale_factor*40),link7_7b.getHeight()/2,null);
			 myConstant.drawImageAtExactPosition(canvas, link7_7c,canvasWidth-link7_7c.getWidth(),0,null);
			 if(threadTimeController>50)
			 {
				
			 }
			
			break;
		
		}
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_7a);
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=8;
			    threadTimeController=0;
			    subSwitchIndex=0;
			}
		
	}


	private void scene_6(Canvas canvas) {
		switch(subSwitchIndex){
		case 0:
			 myConstant.drawImageAtExactPosition(canvas, link7_6a,0,0,null);
			 if(threadTimeController>50)
				 {
				  subSwitchIndex=1;
				  threadTimeController=0;
				 }
			break;
		case 1:
			 myConstant.drawImageAtExactPosition(canvas, link7_6a,0,0,null);
			 myConstant.drawImage(canvas, link7_6b,(int)(GlobalVariables.xScale_factor*640),(int)(GlobalVariables.yScale_factor*335),null);
			 if(threadTimeController>20)
			 {
			  subSwitchIndex=2;
			  threadTimeController=0;
			 }
			break;
		case 2:
			 myConstant.drawImageAtExactPosition(canvas, link7_6a,0,0,null);
			 myConstant.drawImage(canvas, link7_6b,(int)(GlobalVariables.xScale_factor*640),(int)(GlobalVariables.yScale_factor*335),null);
			 myConstant.drawImageAtExactPosition(canvas, link7_6c,canvasWidth-link7_3c.getWidth(),0,null);
			 if(threadTimeController>20)
			 {
				
			 }
			
			break;
		
		}
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_6a);
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=7;
			    threadTimeController=0;
			    subSwitchIndex=0;
				 
			}
	}


	private void scene_5(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_5a,canvasWidth/2,canvasHeight/2,null);
		 
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_5a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=6;
			}
		
	}


	private void scene_4(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_4a,canvasWidth/2,canvasHeight/2,null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_4a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=5;
			}
	}


	private void scene_3(Canvas canvas) {
		switch(subSwitchIndex){
		case 0:
			 myConstant.drawImageAtExactPosition(canvas, link7_3a,0,0,null);
			 if(threadTimeController>50)
				 {
				  subSwitchIndex=1;
				  threadTimeController=0;
				 }
			break;
		case 1:
			 myConstant.drawImageAtExactPosition(canvas, link7_3a,0,0,null);
			 myConstant.drawImage(canvas, link7_3b,canvasWidth/2,link7_3b.getHeight()/2,null);
			 if(threadTimeController>20)
			 {
			  subSwitchIndex=2;
			  threadTimeController=0;
			 }
			break;
		case 2:
			 myConstant.drawImageAtExactPosition(canvas, link7_3a,0,0,null);
			 myConstant.drawImage(canvas, link7_3b,canvasWidth/2,link7_3b.getHeight()/2,null);
			 myConstant.drawImageAtExactPosition(canvas, link7_3c,canvasWidth-link7_3c.getWidth(),0,null);
			 if(threadTimeController>50)
			 {
				
			 }
			
			break;
		
		}
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_3a);
			}
			if(threadTimeController>90){
				mySound.stopSound();
				
				whichScene=4;
			    threadTimeController=0;
			    subSwitchIndex=0;
			}
	}


	private void scene_2(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_2a,canvasWidth/2,canvasHeight/2,null);

		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_2a);
				subSwitchIndex=0;
			}
			if(mySound.ifPlaying()==0){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=3;
			}
		
	}


	private void scene_1(Canvas canvas) {
		 myConstant.drawImage(canvas, link7_1a,canvasWidth/2,canvasHeight/2,null);
		 spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
		 spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);
		 
		
		 if(threadTimeController>0){
				mySound.playSound(R.raw.link7_1a);
				subSwitchIndex=0;
			}
			if(threadTimeController>50){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=2;
			}
	}


	private void scene_0(Canvas canvas) {
		myConstant.drawImageWithRotation(canvas);
	    loadImages();
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
				if(whichScene<13)whichScene++;
				mySound.stopSound();
			}
			switch(whichScene){
			case 0:
				
				break;
			case 1:
//				if(buttonNextF.intersect(touchrecF)){
////					TF=false;
////					gameThread=null;
////					((Activity)context).setResult(Activity.RESULT_OK);
////                    ((Activity)context).finish();
//				}
				break;
			case 2:
				break;
			case 14:
				if(movieRectF!=null&&movieRectF.intersect(touchrecF)&subSwitchIndex==1){
					Constant.mediaPlayerTouch.start();
//					mySound.stopSound();
					Intent intent=new Intent();
					intent.setClass(context,VideoPlayNew.class);
					intent.putExtra("VIDEOPATH","android.resource://"+context.getPackageName()+"/"+R.raw.vd_01);
					intent.putExtra("SWITCHINDEX",1);
					context.startActivity(intent);
					replayModule("VIDEO DIARY 1");
					
				}
                if(movie2RectF!=null&&movie2RectF.intersect(touchrecF)&subSwitchIndex==1){
                	Constant.mediaPlayerTouch.start();
//                	mySound.stopSound();
                	Intent intent=new Intent();
					intent.setClass(context,VideoPlayNew.class);
					intent.putExtra("VIDEOPATH","android.resource://"+context.getPackageName()+"/"+R.raw.vd_02);
					intent.putExtra("SWITCHINDEX",2);
					context.startActivity(intent);
					replayModule("VIDEO DIARY 2");
				}
                if(movie3RectF!=null&&movie3RectF.intersect(touchrecF)&subSwitchIndex==1){
                	Constant.mediaPlayerTouch.start();
                	Intent intent=new Intent();
					intent.setClass(context,VideoPlayNew.class);
					intent.putExtra("VIDEOPATH","android.resource://"+context.getPackageName()+"/"+R.raw.vd_03);
					intent.putExtra("SWITCHINDEX",3);
					context.startActivity(intent);
					replayModule("VIDEO DIARY 3");
				}
                if(Constant.replayF!=null&&Constant.replayF.intersect(touchrecF)){
                	Constant.mediaPlayerTouch.start();
					subSwitchIndex=-1;
					TF=false;
					gameThread=null;
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Constant.REPLAY);
					((Activity)context).finish();
					clearAll();
                }
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
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
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
        mySound.stopSound();
		if(gameThread!=null){
		Log.e("Thread Status",""+gameThread.getState());
		gameThread=null;
		}
//           ((Activity)context).finish();
//           if(whichScene>1)clearAll();
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart_7_Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart_7_Canvas mycanvas) {
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
	
	Bitmap link7_1a;
	Bitmap link7_2a;
	Bitmap link7_3a;
	Bitmap link7_3b;
	Bitmap link7_3c;
	Bitmap link7_4a;
	Bitmap link7_5a;
	Bitmap link7_6a;
	Bitmap link7_6b;
	Bitmap link7_6c;
	Bitmap link7_7a;
	Bitmap link7_7b;
	Bitmap link7_7c;
	Sprite link7_6bSpriteObj;
	int link7_6bSpriteIndex;
	Bitmap link7_8a;
	Bitmap link7_8b;
	Bitmap link7_9a;
	
	Bitmap link3_8;
	Bitmap link3_8a;
	Bitmap link7_11a;
	Bitmap link7_12a;
	Bitmap link7_12b;
	Bitmap link7_13a;
	Bitmap link7_13b;
	
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
	
	Bitmap movieImage1,movieImage2,movieImage3;

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
		
		link7_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_1a);
		link7_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game1_finalframe);
		link7_3a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_3a);
		link7_3b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_3b);
		link7_3c = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_3c);
		link7_4a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_4a);
		link7_5a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_5a);
		link7_6a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_6a);
		link7_6b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_11b);
		link7_6c= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_6c);
		link7_7a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_7a);
		link7_7b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_7b);
		link7_7c= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_7c);
		link7_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_8a);
		link7_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_8b);
		link7_9a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link5_2a_6a);
		link7_11a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_3a);
		link7_12a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_16a);
		link7_12b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_12b);
		link7_13a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_1a);
//		link7_13b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link7_13b);
		
		link3_8=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.logo);
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
		
		movieImage1=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.movie1);
		movieImage2=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.movie2);
		movieImage3=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.movie3);
		
		
//		link7_1bSpriteObj=new ShahSprite(link6_1b,6);
//		link7_6bSpriteObj=new ShahSprite(link6_6b,3);
		threadTimeController=0;
		whichScene=1;
	}
	
	private void clearAll() {
		button.recycle();
		link7_1a.recycle();
		link7_2a.recycle();
		link7_3a.recycle();
		link7_3b.recycle();
		link7_3c.recycle();
		link7_4a.recycle();
		link7_5a.recycle();
		link7_6a.recycle();
		link7_6b.recycle();
		link7_6c.recycle();
		link7_7a.recycle();
		link7_7b.recycle();
		link7_7c.recycle();
		link7_8a.recycle();
		link7_8b.recycle();
		link7_9a.recycle();
		link7_11a.recycle();
		link7_12a.recycle();
		link7_12b.recycle();
		link7_13a.recycle();
//		link7_13b.recycle();
		
		eyes.recycle();
		lips.recycle();
		movieImage1=null;
		movieImage2=null;
		movieImage3=null;
		System.gc();
	}
	
	private void replayModule(String key) {
		
		int value = MyPreference.getIntValue(context, "ActivityStatus", key);
		value++;
		System.out.println("REPLAY VALUE Counter"+value);
		 MyPreference.saveIntInPreference(context, "ActivityStatus", key, value);
	}
	
}

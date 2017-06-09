package com.abdullah.canvas;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.ObjectMove;
import com.abdullah.petpuja.PetPuja;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
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
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class Module2Link1Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
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

    Paint paintfadeInOut,paintWhite;
    int fadeInOutIndex=0;
    int lineLength=0;
    int zoomIn,ZoomOut=200;
    float xDpi,yDpi;
    float xScale,yScale;
    float xMultiplyer,yMultiplyer;
    private int xPoint;
    private int yPoint;
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

    boolean isDelay=true;

    public Module2Link1Canvas(Context context) {
        super(context);
        this.context=context;
        getHolder().addCallback(this);
        myConstant=new Constant(context);
        mySound=new Sound(context);
        backGround = Constant.backGround;
//		buttonNextF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
        paintfadeInOut=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(canvas!=null){
            canvasWidth=canvas.getWidth();
            canvasHeight=canvas.getHeight();

            myConstant.drawBackground(canvas,backGround);
            drawAnimation(canvas);

            paintfadeInOut=new Paint(Paint.ANTI_ALIAS_FLAG);
            paintWhite=new Paint(Paint.ANTI_ALIAS_FLAG);
            paintWhite.setARGB(255,255,255, 255);
            paintWhite.setStyle(Style.FILL_AND_STROKE);
        }
        if(Constant.HEADER==1){
            myConstant.drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene+"."+subSwitchIndex,canvasWidth/2,100,20);
            myConstant.drawText(canvas," Time : "+threadTimeController,100,100,20);
        }
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

            default:

        }


    }

    private void scene_16(Canvas canvas) {
        switch (subSwitchIndex) {
            case 0:
                mySound.playSound(R.raw.link1_17a);
                subSwitchIndex=1;
                break;
            case 1:
                if(!link1_17a.isRecycled())
                    myConstant.drawImageAtExactPosition(canvas, link1_17a,(int)(GlobalVariables.xScale_factor*70),0, null);
                if(!lips.isRecycled())
                    spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(),link1_17a.getWidth()/2+(int)(GlobalVariables.xScale_factor*105),lips.getHeight()/2);
                if(!eyes.isRecycled())
                    spriteEyesObj.drawEyesSprite(canvas,eyes,link1_17a.getWidth()/2+(int)(GlobalVariables.xScale_factor*105),eyes.getHeight()/2);
                if(!link1_17b.isRecycled()){
                    imageRectF=new RectF((int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160),link1_17b.getWidth()+(int)(GlobalVariables.xScale_factor*603),(int)(GlobalVariables.yScale_factor*160)+link1_17b.getHeight());
                    myConstant.drawImageWithRectF(canvas, imageRectF, link1_17b);
                }
                if(mySound.ifPlaying()==0)Constant.drawButtonReplay(canvas);
                break;
            default:
                break;
        }

    }

    private void scene_15(Canvas canvas) {
        myConstant.drawImageAtExactPosition(canvas, link1_16a,canvasWidth/2-link1_16a.getWidth()/2,canvasHeight/2-link1_16a.getHeight()/2, null);
        mySound.playSound(R.raw.link1_16a);

//		 spriteLipsObj.drawLipsSprite(canvas,lips,mySound.ifPlaying(), canvasWidth/2+35,lips.getHeight()/2);
//		  spriteEyesObj.drawEyesSprite(canvas,eyes, canvasWidth/2+35,eyes.getHeight()/2);

        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            link1_14a.recycle();
            link1_14b.recycle();
            whichScene=16;
            subSwitchIndex=0;
            threadTimeController=0;
            link1_15a.recycle();
            link1_15b.recycle();
            link1_17a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
            link1_17b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17b);
        }

    }

    private void scene_14(Canvas canvas) {
        myConstant.drawImageAtExactPosition(canvas, link1_15a,canvasWidth/2-link1_15a.getWidth()/2,0, null);
        switch(subSwitchIndex){
            case 0:
                if(threadTimeController%5==0){
                    if(link1_15bSpriteIndex<spritelink1_15bObj.getNoOfImagesInSprite()-1)link1_15bSpriteIndex++;
                }
                spritelink1_15bObj.drawSprite(canvas,link1_15bSpriteIndex, canvasWidth/2,link1_15b.getHeight()/2,null);
                if(link1_15bSpriteIndex==spritelink1_15bObj.getNoOfImagesInSprite()-1){
                    subSwitchIndex=1;
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
//		    	whichScene=15;
//		    	subSwitchIndex=0;
//				threadTimeController=0;
//
//				link1_16a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_16a);
//				m2Link1_16aObj=new Sprite(link1_16a,3);
//
//
//			}

        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            whichScene=15;
            subSwitchIndex=0;
            threadTimeController=0;

            link1_16a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_16a);
            m2Link1_16aObj=new Sprite(link1_16a,3);


        }

    }

    private void scene_13(Canvas canvas) {

        myConstant.drawImageAtExactPosition(canvas, link1_14a,canvasWidth/2-link1_14a.getWidth()/2,0, null);
        switch(subSwitchIndex){
            case 0:
                if(threadTimeController%4==0){
                    if(link1_14bSpriteIndex<spritelink1_14bObj.getNoOfImagesInSprite()-1)link1_14bSpriteIndex++;
                }
                spritelink1_14bObj.drawSprite(canvas,link1_14bSpriteIndex, canvasWidth/2,link1_14b.getHeight()/2,null);
                if(m2Link1_14aSpriteIndex==spritelink1_14bObj.getNoOfImagesInSprite()-1){
                    subSwitchIndex=1;
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
        if(threadTimeController>50){
            mySound.stopSound();
            whichScene=14;
            link1_14bSpriteIndex=0;
            subSwitchIndex=0;
            threadTimeController=0;
            m2Link1_12a.recycle();
            link1_14a.recycle();
            link1_14b.recycle();
            link1_15a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15a);
            link1_15b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15b);
            spritelink1_15bObj=new Sprite(link1_15b,6);
        }

    }
//	private void scene_131(Canvas canvas) {
//			switch(subSwitchIndex){
//			case 0:
//				if(threadTimeController%10==0){
//					if(m2Link1_14aSpriteIndex<m2Link1_14aObj.getNoOfImagesInSprite()-1)m2Link1_14aSpriteIndex++;
//				}
//				m2Link1_14aObj.drawSprite(canvas,m2Link1_14aSpriteIndex, canvasWidth/2,canvasHeight/2,null);
//		        if(m2Link1_14aSpriteIndex==m2Link1_14aObj.getNoOfImagesInSprite()-1){
//		        	subSwitchIndex=1;
//		        	threadTimeController=0;
//		        }
//				break;
//			case 1:
//				m2Link1_14aObj.drawSprite(canvas,m2Link1_14aSpriteIndex, canvasWidth/2,canvasHeight/2,null);
//				if(threadTimeController>100){
//					whichScene=14;
//					subSwitchIndex=0;
//					threadTimeController=0;
//
//				}
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//			}
//
//
//
//	}

    private void scene_12(Canvas canvas) {
        myConstant.drawImage(canvas, m2Link1_12a,canvasWidth/2,canvasHeight/2,null);
        spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
        spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);


        if(threadTimeController>0){
            mySound.playSound(R.raw.link1b_12a);
            subSwitchIndex=0;
        }
        if(threadTimeController>100){
            mySound.stopSound();
            threadTimeController=0;
            whichScene=13;
            subSwitchIndex=0;
            m2Link1_11a.recycle();

            link1_14a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14a);
            link1_14b =Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14b);
            spritelink1_14bObj=new Sprite(link1_14b,6);

        }
    }

//	private void scene_111(Canvas canvas) {
//		if(threadTimeController%10==0){
//			if(m2Link1_10bSpriteIndex==1)m2Link1_10bSpriteIndex=0;
//			else m2Link1_10bSpriteIndex=1;
//		}
//		m2Link1_10bObj.drawSpriteAtExactPosition(canvas,m2Link1_10bSpriteIndex,0, 0, paintfadeInOut);
//		myConstant.drawImageAtExactPosition(canvas,m2Link1_11a,canvasWidth/2,canvasHeight/2-m2Link1_11a.getHeight()/2,null);
//
//
//		if(threadTimeController>0){
//			mySound.playSound(R.raw.link7_2a);
//			subSwitchIndex=0;
//		}
//		if(mySound.ifPlaying()==0){
//			mySound.stopSound();
//			threadTimeController=0;
//			whichScene=12;
//
//		}
//
//
//	}

    private void scene_11(Canvas canvas){
        if(threadTimeController%10==0){
            if(m2Link1_10bSpriteIndex==1)m2Link1_10bSpriteIndex=0;
            else m2Link1_10bSpriteIndex=1;
        }
        m2Link1_10bObj.drawSpriteAtExactPosition(canvas, m2Link1_10bSpriteIndex, 0, 0, null);
        myConstant.drawImage(canvas,m2Link1_11a,canvasWidth*2/3, canvasHeight/2,null);
//

        mySound.playSound(R.raw.link1_9a);

        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            threadTimeController=0;
            whichScene=12;
            m2Link1_10a.recycle();
            m2Link1_10b.recycle();




        }

    }

    private void scene_10(Canvas canvas) {

        switch(subSwitchIndex){
            case 0:
                xDpi=(float)(m2Link1_10a.getWidth()/2)/canvasWidth;
                yDpi=(float)(m2Link1_10a.getHeight())/canvasHeight;
                xMultiplyer=xDpi*yDpi;
                yMultiplyer=xDpi*yDpi;
                xScale=0;
                yScale=0;
                yPoint=0;
                xPoint=0;
                subSwitchIndex=1;
                break;
            case 1:
                mySound.playSound(R.raw.link1_8a);
                imageRectF=new RectF(canvasWidth/2-m2Link1_10a.getWidth()/4-xScale,-yScale, canvasWidth/2+m2Link1_10a.getWidth()/4+xScale,m2Link1_10a.getHeight()+yScale);
                if(threadTimeController%10==0){
                    if(m2Link1_10aSpriteIndex==1)m2Link1_10aSpriteIndex=0;
                    else m2Link1_10aSpriteIndex=1;
                }
                m2Link1_10aObj.drawSpriteByRectF(canvas, imageRectF, m2Link1_10aSpriteIndex,null);
                if(threadTimeController==50){
                    subSwitchIndex=2;
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
                imageRectF=new RectF(canvasWidth/2-m2Link1_10a.getWidth()/4-xPoint-xScale/2,-yPoint-yScale/2, canvasWidth/2+m2Link1_10a.getWidth()/4+xScale/2-xPoint,m2Link1_10a.getHeight()+yScale/2-yPoint);

                if(threadTimeController%10==0){
                    if(m2Link1_10aSpriteIndex==1)m2Link1_10aSpriteIndex=0;
                    else m2Link1_10aSpriteIndex=1;
                }

                if(fadeInOutIndex>0)fadeInOutIndex-=10;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                m2Link1_10aObj.drawSpriteByRectF(canvas, imageRectF, m2Link1_10aSpriteIndex,paintfadeInOut);

                if(threadTimeController%10==0){
                    if(m2Link1_10bSpriteIndex==1)m2Link1_10bSpriteIndex=0;
                    else m2Link1_10bSpriteIndex=1;
                }
                paintfadeInOut.setAlpha(255-fadeInOutIndex);
                m2Link1_10bObj.drawSpriteAtExactPosition(canvas,m2Link1_10bSpriteIndex,0, 0, paintfadeInOut);

                if(mySound.ifPlaying()==0){
                    whichScene=11;
                    subSwitchIndex=0;
                    threadTimeController=0;
                    mySound.stopSound();
                    link1_7b1.recycle();
                    link1_7b2.recycle();
                    m2Link1_11a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_9a);
                    m2Link1_12a =Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.m2_link1_12a);


                }

                break;
        }
    }

    private void scene_9(Canvas canvas) {
        switch(subSwitchIndex){
            case 0:
                fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                mySound.playSound(R.raw.link1_7a);
                myConstant.drawImageAtExactPosition(canvas, link1_7a1, (int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304), paintfadeInOut);
                if(fadeInOutIndex==255){
                    subSwitchIndex=1;
                    fadeInOutIndex=0;
                }
                break;
            case 1:
                if(fadeInOutIndex<255)fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas, link1_7a1, (int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304), null);
                myConstant.drawImageAtExactPosition(canvas, link1_7a2,(int)(GlobalVariables.xScale_factor*557) ,(int)(GlobalVariables.yScale_factor*240) , paintfadeInOut);
                if(fadeInOutIndex==255){
                    subSwitchIndex=2;
                    fadeInOutIndex=0;
                    threadTimeController=0;
                }
                break;
            case 2:
                myConstant.drawImageAtExactPosition(canvas, link1_7a1,(int)(GlobalVariables.xScale_factor*63),(int)(GlobalVariables.yScale_factor*304),  null);
                myConstant.drawImageAtExactPosition(canvas, link1_7a2,(int)(GlobalVariables.xScale_factor*557),(int)(GlobalVariables.yScale_factor*240), null);
                if(fadeInOutIndex<255)fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas, link1_7a3,(int)(GlobalVariables.xScale_factor*900),(int)(GlobalVariables.yScale_factor*110), paintfadeInOut);
                if(fadeInOutIndex==255){
                    if(threadTimeController>40){
                        fadeInOutIndex=0;
                        subSwitchIndex=3;
                    }
                }
                break;
            case 3:
                fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
                if(fadeInOutIndex==255){
                    subSwitchIndex=4;
                    fadeInOutIndex=0;
                }
                break;
            case 4:
                myConstant.drawImageAtExactPosition(canvas, link1_7b1, (int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), null);
                canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
                fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas, link1_7b2, (int)(GlobalVariables.xScale_factor*452),(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
                if(fadeInOutIndex==255){
                    subSwitchIndex=5;
                    fadeInOutIndex=0;
                }
                break;
            case 5:
                myConstant.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*180), null);
                myConstant.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*452),(int)(GlobalVariables.yScale_factor*180), null);
                canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
                canvas.drawLine((int)(GlobalVariables.xScale_factor*720),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*720),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
                if(fadeInOutIndex<255)fadeInOutIndex+=15;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*805) ,(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);
                myConstant.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*1005) ,(int)(GlobalVariables.yScale_factor*180), paintfadeInOut);

                if(fadeInOutIndex==255)subSwitchIndex=6;
                break;
            case 6:
                myConstant.drawImageAtExactPosition(canvas, link1_7b1,(int)(GlobalVariables.xScale_factor*95) ,(int)(GlobalVariables.yScale_factor*180), null);
                myConstant.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*452),(int)(GlobalVariables.yScale_factor*180), null);
                canvas.drawLine((int)(GlobalVariables.xScale_factor*380),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*380),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
                canvas.drawLine((int)(GlobalVariables.xScale_factor*720),canvasHeight/2+(int)(GlobalVariables.yScale_factor*200),(int)(GlobalVariables.xScale_factor*720),canvasHeight/2-(int)(GlobalVariables.yScale_factor*200),paintWhite);
                myConstant.drawImageAtExactPosition(canvas, link1_7b2,(int)(GlobalVariables.xScale_factor*805),(int)(GlobalVariables.yScale_factor*180), null);
                myConstant.drawImageAtExactPosition(canvas, link1_7b1, (int)(GlobalVariables.xScale_factor*1005),(int)(GlobalVariables.yScale_factor*180), null);
                if(mySound.ifPlaying()==0){
                    try {
                        Thread.sleep(1000);
                        threadTimeController=0;
                        mySound.stopSound();
                        whichScene=10;
                        subSwitchIndex=0;
                        m2Link1_8a.recycle();
                        m2Link1_8b.recycle();
                        m2Link1_10a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_8a);
                        m2Link1_10b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_8b);
                        m2Link1_10aObj=new Sprite(m2Link1_10a,2);
                        m2Link1_10bObj=new Sprite(m2Link1_10b,2);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    private void scene_8(Canvas canvas) {
        myConstant.drawImageAtExactPosition(canvas,m2Link1_8a,canvasWidth/2-m2Link1_8a.getWidth()/2,0, null);

        if(threadTimeController%10==0){
            if(m2Link1_8bSpriteIndex<m2Link1_8bSpriteObj.getNoOfImagesInSprite()-1) m2Link1_8bSpriteIndex++;
            else m2Link1_8bSpriteIndex--;

        }

        m2Link1_8bSpriteObj.drawSpriteAtExactPosition(canvas, m2Link1_8bSpriteIndex, canvasWidth/2-m2Link1_8b.getWidth()/12,0, null);

        if(threadTimeController>20){
            mySound.playSound(R.raw.link1b_8a);
        }
        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            whichScene=9;
            subSwitchIndex=0;
            threadTimeController=0;
//					m2Link1_7a.recycle();
            m2Link1_7b.recycle();
            m2Link1_7c.recycle();
            link1_7a1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a1);
            link1_7a2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a2);
            link1_7a3= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7a3);
            link1_7b1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7b1);
            link1_7b2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7b2);

            fadeInOutIndex=0;


//					link1_7b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_7b);
//					m2Link1_9aObj=new Sprite(m2Link1_9a,3);
//					m2Link1_9bObj=new Sprite(m2Link1_9b,3);

//					xDpi=(float)(link1_7a1.getWidth()/3)/canvasWidth;
//					yDpi=(float)(link1_7a1.getHeight())/canvasHeight;
//					xMultiplyer=xDpi*yDpi;
//					yMultiplyer=xDpi*yDpi;
//			    	xScale=300*xMultiplyer;
//					yScale=300*yMultiplyer;
        }








    }

    private void scene_7(Canvas canvas){


        if(threadTimeController%10==0){
            if(m2Link1_7cSpriteIndex==0)m2Link1_7cSpriteIndex=1;
            else m2Link1_7cSpriteIndex=0;
        }

        switch(subSwitchIndex){
            case 0:
                myConstant.drawImageAtExactPosition(canvas,m2Link1_7b,canvasWidth-m2Link1_7b.getWidth(),0,null);
                m2Link1_7aSpriteObj.drawSpriteAtExactPosition(canvas,0,0, 0, null);
                if(threadTimeController>100)
                    if(threadTimeController>5){
                        mySound.playSound(R.raw.link1b_7a);
                    }
                if(mySound.ifPlaying()==0){
                    mySound.stopSound();
                    threadTimeController=0;
                    subSwitchIndex=1;
                }
                break;
            case 1:
                m2Link1_7aSpriteObj.drawSpriteAtExactPosition(canvas,1,0, 0, null);
                m2Link1_7cSpriteObj.drawSpriteAtExactPosition(canvas,m2Link1_7cSpriteIndex,canvasWidth-m2Link1_7c.getWidth()/2, 0, null);
                if(threadTimeController>5){
                    mySound.playSound(R.raw.link1b_7b);
                }
                if(mySound.ifPlaying()==0){
                    mySound.stopSound();
                    threadTimeController=0;
                    whichScene=8;
                    link1_6a.recycle();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;


        }


        spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),(int)(GlobalVariables.xScale_factor*310),lips.getHeight()/2+(int)(GlobalVariables.yScale_factor*10));
    }

    private void scene_6(Canvas canvas) {
        myConstant.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),null);
        myConstant.drawImageAtExactPosition(canvas,link1_5b,(int)(GlobalVariables.xScale_factor*490),(int)(GlobalVariables.yScale_factor*335),null);
        if(fadeInOutIndex<255)fadeInOutIndex+=15;
        paintfadeInOut.setAlpha(fadeInOutIndex);
        myConstant.drawImageAtExactPosition(canvas,link1_6a,(int)(GlobalVariables.xScale_factor*580),(int)(GlobalVariables.yScale_factor*50),paintfadeInOut);
        mySound.playSound(R.raw.link1_6a);

        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            whichScene=7;
            fadeInOutIndex=0;
            link1_5a.recycle();
            link1_5b.recycle();
        }
    }

    private void scene_4(Canvas canvas) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");


        Date d=null,d2=null;
        Calendar now=null;
        long diffInDays=0;

        try {
            d=sdf.parse(Constant.YEARS+"/"+Constant.MONTHS+"/"+Constant.DAYS+" 00:00:00");
            now = Calendar.getInstance();
            now.setTime(d);
            now.add(Constant.MONTHS,6);
            d2=sdf.parse(now.get(Calendar.YEAR)+"/"+now.get(Calendar.MONTH)+"/"+now.get(Calendar.DAY_OF_MONTH)+" 00:00:00");
            diffInDays = (long)(d2.getTime() - d.getTime())/ (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Constant.AGEINMONTHS=(int)diffInDays/30;

        myConstant.drawImageAtExactPosition(canvas,m2Link1_4a,(int)(GlobalVariables.xScale_factor*95),(int)(GlobalVariables.yScale_factor*175),null);
        m2Link1_4bSpriteObj.drawSpriteAtExactPosition(canvas,1,canvasWidth-m2Link1_4b.getWidth()/2, 0,null);

        try {
            d = sdf.parse(Constant.YEARS+"/"+Constant.MONTHS+"/"+Constant.DAYS+ " 00:00:00");
            now = Calendar.getInstance();
            now.setTime(d);
            now.add(Calendar.MONTH, 6);
            myConstant.drawText(canvas,""+now.get(Calendar.DATE),(int)(GlobalVariables.xScale_factor*200),(int)(GlobalVariables.yScale_factor*400), (int)(GlobalVariables.xScale_factor*100));
            myConstant.drawText(canvas,""+(now.get(Calendar.MONTH)+1),(int)(GlobalVariables.xScale_factor*400),(int)(GlobalVariables.yScale_factor*400), (int)(GlobalVariables.xScale_factor*100));
            myConstant.drawText(canvas,""+now.get(Calendar.YEAR),(int)(GlobalVariables.xScale_factor*645),(int)(GlobalVariables.yScale_factor*400), (int)(GlobalVariables.xScale_factor*100));
        } catch (ParseException e) {

        }


//        delayCount();
//        if(delayCounter>=sleepTime){
//            threadTimeController++;
//            delayCounter=0;
//        }

        if(threadTimeController>5){
            mySound.playSound(R.raw.link1_4a);
            subSwitchIndex=0;
        }
        if(mySound.ifPlaying()==0){
            mySound.stopSound();
            threadTimeController=0;
            m2Link1_3a.recycle();
            whichScene=5;
        }

    }

    private void scene_3(Canvas canvas) {
        myConstant.drawImage(canvas, m2Link1_3a,canvasWidth/2,canvasHeight/2,null);
        spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
        spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);


        if(threadTimeController>0){
            mySound.playSound(R.raw.link1_3a);
            subSwitchIndex=0;
        }
//			if(threadTimeController>60){
//				mySound.stopSound();
//				threadTimeController=0;
//				whichScene=4;
//				m2Link1_2a.recycle();
//			}

//        delayCount();
//        if(delayCounter>=sleepTime){
//            threadTimeController++;
//            delayCounter=0;
//        }

        if(threadTimeController>70){
            mySound.stopSound();
            threadTimeController=0;
            whichScene=4;
            m2Link1_2a.recycle();
        }


    }

    private void scene_5(Canvas canvas) {
        mySound.playSound(R.raw.link1_5a);
        switch (subSwitchIndex) {
            case 0:
                if(fadeInOutIndex<255)fadeInOutIndex+=5;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                myConstant.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),paintfadeInOut);
                if(fadeInOutIndex==250){
                    fadeInOutIndex=0;
                    subSwitchIndex=1;

                }
                break;
            case 1:
                if(fadeInOutIndex<250)fadeInOutIndex+=10;
                paintfadeInOut.setAlpha(fadeInOutIndex);
                //myConstant.drawImageAtExactPosition(canvas,link1_5a,85,165,null);
                myConstant.drawImageAtExactPosition(canvas,link1_5a,(int)(GlobalVariables.xScale_factor*85),(int)(GlobalVariables.yScale_factor*165),paintfadeInOut);
                myConstant.drawImageAtExactPosition(canvas,link1_5b,(int)(GlobalVariables.xScale_factor*490),(int)(GlobalVariables.yScale_factor*335),paintfadeInOut);
                if(mySound.ifPlaying()==0){
                    mySound.stopSound();
                    whichScene=6;
                    subSwitchIndex=0;
                    fadeInOutIndex=0;
                    m2Link1_4b.recycle();
                    m2Link1_4a.recycle();
                }
                break;
            case 2:

                break;

            default:
                break;
        }


    }

    private void scene_2(Canvas canvas) {
        myConstant.drawImage(canvas, m2Link1_2a,canvasWidth/2,canvasHeight/2,null);
        spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
        spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);



        mySound.playSound(R.raw.link1_2a);


			if(threadTimeController>90){
				mySound.stopSound();
				threadTimeController=0;
				whichScene=3;
				subSwitchIndex=0;
				m2Link1_1a.recycle();
			}
//        if(isDelay)delayCount();
//        if(delayCounter>=sleepTime){
//            threadTimeController++;
//            delayCounter=0;
//        }

        if(threadTimeController>100){ // by Faiyaz
            mySound.stopSound();
            threadTimeController=0;
            whichScene=3;
            subSwitchIndex=0;
            m2Link1_1a.recycle();
            //isDelay=false;
        }

    }

    private void scene_1(Canvas canvas) {
        myConstant.drawImage(canvas, m2Link1_1a,canvasWidth/2,canvasHeight/2,null);
        spriteEyesObj.drawEyesSprite(canvas, eyes,canvasWidth/2,eyes.getHeight()/2);
        spriteLipsObj.drawLipsSprite(canvas, lips,mySound.ifPlaying(),canvasWidth/2,lips.getHeight()/2);



        mySound.playSound(R.raw.link1_1a);

//        if(isDelay)delayCount();
//        if(delayCounter>=sleepTime){
//            threadTimeController++;
//            delayCounter=0;
//        }
        if(threadTimeController>70){
            mySound.stopSound();
            threadTimeController=0;
            subSwitchIndex=0;
            whichScene=2;
            //isDelay=false;
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
                switch(whichScene){
                    case 0:

                        break;
                    case 1:
                        if(buttonNextF!=null&&buttonNextF.intersect(touchrecF)){
                            ((Activity)context).setResult(Activity.RESULT_OK);
                            ((Activity)context).finish();
                        }
                        break;
                    case 16:
                        if(imageRectF!=null&imageRectF.intersect(touchrecF)&mySound.ifPlaying()==0){
                            Constant.mediaPlayerTouch.start();
                            subSwitchIndex=2;
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
                            subSwitchIndex=2;
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

        //delayCount();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //TODO Auto-generated method stub
        gameThread=null;
        gameThread=null;
        getHandler().removeCallbacks(this);
        mySound.stopSound();
        clearAll();
        Log.e("surfaceDestroyed","Module2Link1Canvas");
//		((Activity)context).setResult(Activity.RESULT_OK);
        ((Activity)context).finish();


    }

    @SuppressLint("WrongCall")
    class GameThread extends Thread{
        SurfaceHolder _suHolder;
        Module2Link1Canvas _myMycanvas;

        public GameThread(SurfaceHolder surfaceHolder,Module2Link1Canvas mycanvas) {
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

//                        if(isDelay)delayCount();
//                        if(delayCounter==1){
//                            threadTimeController++;
//                            delayCounter=0;
//                        }

                    } catch (Exception e) {
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

    Bitmap m2Link1_1a;
    Bitmap m2Link1_2a;
    Bitmap m2Link1_3a;
    Bitmap m2Link1_4a;

    Bitmap m2Link1_4b;
    Sprite m2Link1_4bSpriteObj;
    int m2Link1_4bSpriteIndex;

    Bitmap link1_5a;
    Bitmap link1_5b;
    Bitmap link1_6a;
//	Bitmap m2Link1_6b;

    Bitmap m2Link1_7a;
    Sprite m2Link1_7aSpriteObj;
    int m2Link1_7aSpriteIndex;
    Bitmap m2Link1_7b;
    Bitmap m2Link1_7c;
    Sprite m2Link1_7cSpriteObj;
    int m2Link1_7cSpriteIndex;
    Bitmap m2Link1_8a;
    Sprite m2Link1_8bSpriteObj;
    int m2Link1_8bSpriteIndex;
    Bitmap m2Link1_8b;

//	     Bitmap link1_8a,link1_8b;
//	    ShahSprite spritelink1_8aObj,spritelink1_8bObj;
//	    int link1_8aSpriteIndex,link1_8bSpriteIndex;



    Bitmap m2Link1_11a;
    Bitmap m2Link1_12a;
    Bitmap m2Link1_13a;

    Bitmap   m2Link1_14a;
    Sprite m2Link1_14aObj;
    int m2Link1_14aSpriteIndex;

    Bitmap link1_15a;
    Bitmap link1_15b;
    Sprite spritelink1_15bObj;
    int link1_15bSpriteIndex;

    Bitmap link1_16a,link1_16b;
    Sprite m2Link1_16aObj,m2Link1_16bObj;
    int m2Link1_16aSpriteIndex,m2Link1_16bSpriteIndex;

    Bitmap link1_17a,link1_17b;

    Bitmap link1_7a1;
    Bitmap link1_7a2;
    Bitmap link1_7a3;



    Bitmap link1_7b1;
    Bitmap link1_7b2;

    Sprite m2Link1_9aObj,m2Link1_9bObj;
    int m2Link1_9aSpriteIndex,m2Link1_9bSpriteIndex;

    Bitmap m2Link1_10a,m2Link1_10b;
    Sprite m2Link1_10aObj,m2Link1_10bObj;
    int m2Link1_10aSpriteIndex,m2Link1_10bSpriteIndex;

    ObjectMove moveObj;


    Bitmap link1_14a;
    Bitmap link1_14b;
    Sprite spritelink1_14bObj;
    int link1_14bSpriteIndex;

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(button==null)button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
        if(eyes==null)eyes= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.eyes);
        if(lips==null)lips= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.lips);

        if(spriteEyesObj==null)spriteEyesObj=new Sprite(eyes,4);
        if(spriteLipsObj==null)spriteLipsObj=new Sprite(lips,13);

        if(m2Link1_1a==null)m2Link1_1a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_1a);
        if(m2Link1_2a==null)m2Link1_2a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_2a);
        if(m2Link1_3a==null)m2Link1_3a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_3a);
        if(m2Link1_4a==null)m2Link1_4a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4a);
        if(m2Link1_4b==null)m2Link1_4b = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_4b);
        if(link1_5a==null)link1_5a = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_5a);
        if(link1_5b==null)link1_5b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_5b);
        if(link1_6a==null)link1_6a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_6a);
        if(m2Link1_7a==null)m2Link1_7a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.m2_link1_7a);
        if(m2Link1_7b==null)m2Link1_7b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.m2_link1_7b);
        if(m2Link1_7c==null)m2Link1_7c= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.m2_link1_7c);
        if(m2Link1_8a==null)m2Link1_8a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_2a);
        if(m2Link1_8b==null)m2Link1_8b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link2_2b);


//		m2Link1_11a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_9a);
//		m2Link1_12a =Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.m2_link1_12a);
//		link1_14a=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14a);
//		link1_14b =Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_14b);
//		link1_15a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15a);
//		link1_15b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_15b);
//		link1_16a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_16a);
//		link1_17a= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17a);
//		link1_17b= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link1_17b);

        m2Link1_4bSpriteObj=new Sprite(m2Link1_4b, 2);
        m2Link1_7aSpriteObj=new Sprite(m2Link1_7a, 2);
        m2Link1_7cSpriteObj=new Sprite(m2Link1_7c, 2);
        m2Link1_8bSpriteObj=new Sprite(m2Link1_8b, 6);



//		m2Link1_16bObj=new ShahSprite(link1_16b,3);

        threadTimeController=0;
        whichScene=1;
    }



    public void clearAll(){
        if(button!=null&&!button.isRecycled())button.recycle();
        if(m2Link1_1a!=null&&!m2Link1_1a.isRecycled())m2Link1_1a.recycle();
        if(m2Link1_2a!=null&&!m2Link1_2a.isRecycled())m2Link1_2a.recycle();
        if(m2Link1_3a!=null&&!m2Link1_3a.isRecycled())m2Link1_3a.recycle();
        if(m2Link1_4a!=null&&!m2Link1_4a.isRecycled())m2Link1_4a.recycle();
        if(m2Link1_4b!=null&&!m2Link1_4b.isRecycled())m2Link1_4b.recycle();
        if(link1_5a!=null&&!link1_5a.isRecycled())link1_5a.recycle();
        if(link1_5b!=null&&!link1_5b.isRecycled())link1_5b.recycle();
        if(m2Link1_7a!=null&&!m2Link1_7a.isRecycled())m2Link1_7a.recycle();
        if(m2Link1_7b!=null&&!m2Link1_7b.isRecycled())m2Link1_7b.recycle();
        if(m2Link1_7c!=null&&!m2Link1_7c.isRecycled())m2Link1_7c.recycle();
        if(m2Link1_8a!=null&&!m2Link1_8a.isRecycled())m2Link1_8a.recycle();
        if(m2Link1_8b!=null&&!m2Link1_8b.isRecycled())m2Link1_8b.recycle();
        if(m2Link1_10a!=null&&!m2Link1_10a.isRecycled())m2Link1_10a.recycle();
        if(m2Link1_10b!=null&&!m2Link1_10b.isRecycled())m2Link1_10b.recycle();

        if(m2Link1_11a!=null&&!m2Link1_11a.isRecycled())m2Link1_11a.recycle();
        if(m2Link1_12a!=null&&!m2Link1_12a.isRecycled())m2Link1_12a.recycle();

        if(link1_14a!=null&&!link1_14a.isRecycled())link1_14a.recycle();
        if(link1_14b!=null&&!link1_14b.isRecycled())link1_14b.recycle();

        if(link1_15a!=null&&!link1_15a.isRecycled())link1_15a.recycle();
        if(link1_15b!=null&&!link1_15b.isRecycled())link1_15b.recycle();
        if(link1_16a!=null&&!link1_16a.isRecycled())link1_16a.recycle();
        if(link1_17a!=null&&!link1_17a.isRecycled())link1_17a.recycle();
        if(link1_17b!=null&&!link1_17b.isRecycled())link1_17b.recycle();

        if(eyes!=null&&!eyes.isRecycled())eyes.recycle();
        if(lips!=null&&!lips.isRecycled())lips.recycle();
        spriteEyesObj=null;
        spriteLipsObj=null;
        System.gc();
    }

    private Long lastMiliSeconds=System.currentTimeMillis();
    public int delayCounter;
    protected void delayCount(){
        long currentMilisecond=System.currentTimeMillis();

        long temp=(currentMilisecond-lastMiliSeconds);
        if(temp%10==0){
            lastMiliSeconds=currentMilisecond;
            delayCounter=delayCounter+1;
        }
    }
}

//    private Long lastMiliSeconds=System.currentTimeMillis();
//    public int delayCounter;
//    Calendar cal = Calendar.getInstance();
//    private int lastSec=cal.get(Calendar.MILLISECOND);
//
//    protected void  delayCount(){
//        long currentMilisecond=System.currentTimeMillis();
//
//        long temp=(currentMilisecond-lastMiliSeconds);
//
////        cal = Calendar.getInstance();
////        int millisecond = cal.get(Calendar.MILLISECOND);
//      // long temp1=(temp*1000);
//
//        if(temp>=1){
//            lastMiliSeconds=currentMilisecond;
//            //lastSec=millisecond;
//            delayCounter=delayCounter+1;
//
//        }
//    }


package com.abdullah.petpuja;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;

import android.graphics.Canvas;

import android.graphics.Rect;

import com.zmq.utility.Utility;


public class Sprite {

    private static  int BMP_ROWS = 1;
    int BMP_COLUMNS = 1;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int imageWidth;
    private int imageHeight;
    int canvasWidth,canvasHeight;
    int eyesSpriteIndex;
    int lipsSpriteIndex;
    int eyeBlinkTime;
    int lipsMoveTime;

    public Sprite(Bitmap bmp,int noOfImageInSprite) {

 	     this.BMP_COLUMNS =noOfImageInSprite;  
          this.imageWidth = bmp.getWidth() / BMP_COLUMNS;
          this.imageHeight = bmp.getHeight() / BMP_ROWS;
        if (bmp.getWidth()%imageWidth!=0) {
            bmp= Utility.getResizedBitmap(bmp, bmp.getWidth() - bmp.getWidth() % imageWidth, imageHeight);
        }
          this.bmp = bmp;

    }
    
    
    public int getNoOfImagesInSprite(){
    	return BMP_COLUMNS;
    }


	private void update() {
//          currentFrame = ++currentFrame % BMP_COLUMNS;
    }

	public void drawSpriteByRectF(Canvas canvas,RectF rectf,int spriteIndex,Paint paint) {
        int srcX = spriteIndex * imageWidth;
        int srcY = imageHeight;
        Rect src = new Rect(srcX,0, srcX + imageWidth, srcY);
        canvas.drawBitmap(bmp, src, rectf, paint);
  }

    public void drawSprite(Canvas canvas,int CurrentFrame,int xMidPosition,int yMidPosition,Paint paint) {
          int srcX = CurrentFrame * imageWidth;
          int srcY = imageHeight;
          Rect src = new Rect(srcX,0, srcX + imageWidth, srcY);
          Rect dst1 = new Rect(xMidPosition-imageWidth/2,yMidPosition-imageHeight/2,xMidPosition+imageWidth/2 , yMidPosition +imageHeight/2);
          canvas.drawBitmap(bmp, src, dst1, paint);
    }
    
    public void drawSpriteAtExactPosition(Canvas canvas,int CurrentFrame,int xPosition,int yPosition,Paint paint) {
        int srcX = CurrentFrame * imageWidth;
        int srcY = imageHeight;
        Rect src = new Rect(srcX,0, srcX + imageWidth, srcY);
        Rect dst1 = new Rect(xPosition,yPosition,xPosition+imageWidth , yPosition +imageHeight);
        canvas.drawBitmap(bmp, src, dst1, paint);
  }
    
public void drawEyesSprite(Canvas canvas,Bitmap eyes,int xPosition,int yPosition) {
	   
	    eyeBlinkTime++;
	
		if(eyeBlinkTime<45)eyesSpriteIndex=0;
		if(eyeBlinkTime>=45)eyesSpriteIndex=1;
		if(eyeBlinkTime>47)eyesSpriteIndex=2;
		if(eyeBlinkTime>50)eyesSpriteIndex=3;
		if(eyeBlinkTime>53)eyesSpriteIndex=2;
		if(eyeBlinkTime>55)eyesSpriteIndex=1;
		if(eyeBlinkTime>57)eyesSpriteIndex=0;
		
		if(eyeBlinkTime==100)eyeBlinkTime=0;
		
		drawSprite(canvas,eyesSpriteIndex, xPosition,yPosition,null);
	}
	
   public void drawLipsSprite(Canvas canvas,Bitmap lips,int playing,int xPoint,int yPoint) {
	    if(playing==1){
	    lipsMoveTime++;
		if(lipsMoveTime%6==0)lipsSpriteIndex++;
		if(lipsSpriteIndex==getNoOfImagesInSprite())lipsSpriteIndex=0;
		drawSprite(canvas,lipsSpriteIndex, xPoint,yPoint,null);
		if(lipsMoveTime==100)lipsMoveTime=0;
	    }
	}
}
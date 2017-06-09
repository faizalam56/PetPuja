package com.abdullah.petpuja;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ZoomInZoomOut {
	
	float imageWidth;
	float imageHeight;
	float xPoint,yPoint;
	
	float xDpi;
	float yDpi;
	
	float xMultiplyer;
	float yMultiplyer;
	
	Canvas canvas;
	Bitmap image;
	
	int percentageIncreaseorDecrease,speed;
	Rect sourceRect;
	RectF finalRect;
	
	int canvasWidth;
	int canvasHeight;
	
	float startWidth,startHeight;
	int incrementor=0;
	int xMid;
	int yMid;
	
	int value;
	
	public ZoomInZoomOut(Canvas _canvas,Bitmap _image, int _percentageIncreaseorDecrease,int _xMid,int _yMid, int _speed) {
		canvas=_canvas;
		image=_image;
		
		xMid=_xMid;
		yMid=_yMid;
		
		value=-1;
		
		percentageIncreaseorDecrease=_percentageIncreaseorDecrease;
		
		if(_speed>=10)speed=9;
		else if(_speed<0) speed=0;
		else speed=_speed;
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		imageWidth=image.getWidth();
		imageHeight=image.getHeight();
		
		xDpi=(float)image.getWidth()/canvas.getWidth();
		yDpi=(float)image.getHeight()/canvas.getHeight();
		
		xMultiplyer=xDpi*yDpi;
		yMultiplyer=xDpi*yDpi;
		

			startWidth= (int) (imageWidth+imageWidth*percentageIncreaseorDecrease/100);
			startHeight=(int) (imageHeight+imageHeight*percentageIncreaseorDecrease/100);

		
		
		
		sourceRect=new Rect(0,0,(int)imageWidth,(int)imageHeight);
	}
	
	public int zoomIn(Paint paint){
		incrementor++;
		if(startWidth<imageWidth){
			 if(incrementor%(10-speed)==0){
			 startWidth =startWidth+imageWidth/100;
			 startHeight=startHeight+imageHeight/100;
			 value=1;
			 }
		   }
		else{
			   startWidth=imageWidth;
			   startHeight=imageHeight;
			   value=0;
		}
		finalRect=new RectF(xMid-startWidth/2,yMid-startHeight/2,xMid+startWidth/2,yMid+startHeight/2);	
		canvas.drawBitmap(image, sourceRect, finalRect, paint);
		
		return value;
	}
	
	
	public int zoomOut(Paint paint){
		if(startWidth>imageWidth){
			incrementor++;
            if(incrementor%(10-speed)==0){
			startWidth =startWidth-imageWidth/100;
			startHeight=startHeight-imageHeight/100;
			value=1;
            }
		   }
		else{
			   startWidth=imageWidth;
			   startHeight=imageHeight;
			   value=0;
		}
		finalRect=new RectF(xMid-startWidth/2,yMid-startHeight/2,xMid+startWidth/2,yMid+startHeight/2);	
		canvas.drawBitmap(image, sourceRect, finalRect, paint);
		
		return value;
		
	}
	
	
	
	

}

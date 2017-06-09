package com.abdullah.petpuja;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ObjectMove {
	
	int xMoveFrom,xMoveTo;
	int timeInSecond;
	int xMove=0;
	
	
	
	public ObjectMove(Context context,int xMoveFrom,int xMoveTo) {
		this.xMoveFrom=xMoveFrom;
		this.xMoveTo=xMoveTo;
		this.xMove=this.xMoveFrom;
	}
	
	public int MoveImageHorizontally(Canvas canvas,Bitmap image,int imageX,int imageY,int timeInSecond,int speed,Paint paint){
		if(this.xMoveTo<this.xMoveFrom){
		xMove=xMoveFrom-5*timeInSecond*timeInSecond/1000;
		this.xMoveFrom=xMove;
		
		if(this.xMoveFrom<1)this.xMoveFrom=0;
		
		Rect  imageRectS=new Rect(0,0,image.getWidth(),image.getHeight());
		RectF imageRectF=new RectF(this.xMoveFrom,imageY,image.getWidth()+this.xMoveFrom,imageY+image.getHeight());
		canvas.drawBitmap(image,imageRectS,imageRectF,paint);
		return 1;
		}if(this.xMoveTo==this.xMoveFrom){
			return 0;
		}else return -1;
		
	}
	
	public int MoveImageHorizontallyNew(Canvas canvas,Bitmap image,int imageY,int whichDirection,int speed,Paint paint){
//		whichDirection =1 left to right
//		whichDirection =2 right to left
		
		timeInSecond++;
			switch (whichDirection) {
			case 1:
				if(this.xMoveTo>xMove)
				xMove=xMoveFrom+speed*timeInSecond*timeInSecond/100;
		        if(Math.abs(this.xMoveTo-this.xMove)<20)
		        	xMove=xMoveTo;
				break;
			case 2:
				if(this.xMoveTo<xMove)
				xMove=xMoveFrom-speed*timeInSecond*timeInSecond/100;
				if(Math.abs(this.xMoveTo-this.xMove)<20)
		        xMove=xMoveTo;
				break;
			default:
				break;
			}
		
		Rect  imageRectS=new Rect(0,0,image.getWidth(),image.getHeight());
		RectF imageRectF=new RectF(xMove,imageY,image.getWidth()+xMove,imageY+image.getHeight());
		canvas.drawBitmap(image,imageRectS,imageRectF,paint);
		
		System.out.println("move :: "+(this.xMoveTo-this.xMove));
		
		if(Math.abs(this.xMoveTo-this.xMove)<=10){
			return 0;
		}else return -1;
		
	}
	
	public int getX(){
		if(this.xMoveTo<this.xMoveFrom){
			xMove=xMoveFrom-5*timeInSecond*timeInSecond/1000;
			this.xMoveFrom=xMove;
			
			if(this.xMoveFrom<1)this.xMoveFrom=0;
	}
		return xMove;
	}
}

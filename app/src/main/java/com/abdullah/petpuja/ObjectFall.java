package com.abdullah.petpuja;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ObjectFall {
	
	int yFallFrom,yFallTo;
	int xMoveFrom,xMoveTo;
	int timeInSecond;
	int yMove=1;
	
	
	
	public ObjectFall(Context context,int yFallFrom,int yFallTo) {
		this.yFallFrom=yFallFrom;
		this.yFallTo=yFallTo;
	}
	
	public void fallImageVertically(Canvas canvas,Bitmap image,int imageX,int imageY,int timeInSecond,Paint paint){
		if(this.yFallFrom<this.yFallTo)yMove=yFallFrom+5*timeInSecond*timeInSecond/1000;
		this.yFallFrom=yMove;
		
		Rect  imageRectS=new Rect(0,0,image.getWidth(),image.getHeight());
		RectF imageRectF=new RectF(imageX,yFallFrom+yMove,imageX+image.getWidth(),yFallFrom+image.getHeight()+yMove);
		canvas.drawBitmap(image,imageRectS,imageRectF,paint);
		
	}

}

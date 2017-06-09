package com.abdullah.petpuja;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.media.MediaPlayer;

import com.zmq.utility.GlobalVariables;
import com.zmq.utility.Utility;

public class Constant {
	public static final int CLOSE_WITH_MESSAGE=999;
	public static final int REPLAY=10;
	
	public static int DAYS=1;
	public static int MONTHS=1;
	public static int YEARS=2015;
	public static int AGEINMONTHS=0;
	public static int THREADTIME=10;
	
	public static Bitmap backGround;
	public static Bitmap waitingStar;
	public static Bitmap replay,next;
	int rotationAngle=0;
	int threadSpeedController=0;
	public static int HEADER=0;
    public static int APPLICATION=0;
	
	Matrix matrix;
	public static MediaPlayer mediaPlayerTouch;
	public static RectF replayF,nextF;

	public Constant(Context context) {
		matrix=new Matrix();
		backGround  = Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.background);
		waitingStar = Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.wait);
		mediaPlayerTouch=MediaPlayer.create(context, R.raw.touch);
		replay= Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.replay_button);
		next= Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.next_button);
	}
	
	public Constant(){
		matrix=new Matrix();
	}
	
	public void drawImage(Canvas canvas, Bitmap image,int xMidPosition, int yMidPosition,Paint paint) {
		Rect  imageRectS=new Rect(0,0,image.getWidth(),image.getHeight());
		RectF imageRectF=new RectF(xMidPosition-image.getWidth()/2,yMidPosition-image.getHeight()/2,xMidPosition+image.getWidth()/2,yMidPosition+image.getHeight()/2);
		canvas.drawBitmap(image,imageRectS,imageRectF,paint);
	}
	
	public void drawImageAtExactPosition(Canvas canvas, Bitmap image,int xPosition, int yPosition,Paint paint) {
		Rect  imageRectS=new Rect(0,0,image.getWidth(),image.getHeight());
		RectF imageRectF=new RectF(xPosition,yPosition,xPosition+image.getWidth(),yPosition+image.getHeight());
		canvas.drawBitmap(image,imageRectS,imageRectF,paint);
	}
	
	public void drawText(Canvas canvas, String Text,int xMidPosition,int yMidPosition, int textSize) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.WHITE);
		paint.setTextSize(textSize);

        //paint.setTextScaleX(GlobalVariables.xScale_factor);

		Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
		paint.setTypeface(tf);
		paint.setTextAlign(Align.CENTER);
		canvas.drawText(Text,xMidPosition,yMidPosition, paint);



	}
	
	public void drawBackground(Canvas canvas, Bitmap backGround) {
		Rect  backGroundS=new Rect(0,0,backGround.getWidth(),backGround.getHeight());
		RectF backGroundF=new RectF(0,0,canvas.getWidth(),canvas.getHeight());
		canvas.drawBitmap(backGround,backGroundS,backGroundF,null);
	}
	
	public static void drawButtonNext(Canvas canvas) {
		Rect  btnBitmapS=new Rect(0,0,next.getWidth(),next.getHeight());
		nextF=new RectF(canvas.getWidth()-next.getWidth(),canvas.getHeight()-next.getHeight(),canvas.getWidth(),canvas.getHeight());
		canvas.drawBitmap(next,btnBitmapS,nextF,null);
	}
	
	public static void drawButtonReplay(Canvas canvas) {
		Rect  btnBitmapS=new Rect(0,0,replay.getWidth(),replay.getHeight());
		replayF=new RectF(0,canvas.getHeight()-replay.getHeight(),replay.getWidth(),canvas.getHeight());
		canvas.drawBitmap(replay,btnBitmapS,replayF,null);
	}
	
	public void drawImageWithRotation(Canvas canvas){
		
		threadSpeedController++;
		if(threadSpeedController>999)threadSpeedController=0;
		
    	if(threadSpeedController%2==0){         // controlling main thread speed
        if(rotationAngle>=360)rotationAngle=0;
        else rotationAngle+=22.5;
    	}
    	
        matrix.preTranslate(canvas.getWidth()/2-waitingStar.getWidth()/2,canvas.getHeight()/2-waitingStar.getHeight()/2);
    	matrix.setRotate(rotationAngle,waitingStar.getWidth()/2,waitingStar.getHeight()/2);
    	matrix.postTranslate(canvas.getWidth()/2-waitingStar.getWidth()/2,canvas.getHeight()/2-waitingStar.getHeight()/2);
    	canvas.drawBitmap(waitingStar, matrix, null);
    }
	
	public void drawImageWithRectF(Canvas canvas,RectF imageRectF,Bitmap image) {
		Rect  btnBitmapS=new Rect(0,0,image.getWidth(),image.getHeight());
		canvas.drawBitmap(image,btnBitmapS,imageRectF,null);
	}
	
	public void drawButtonNext(Canvas canvas, Bitmap btnBitmap,RectF buttonNextF) {
		Rect  btnBitmapS=new Rect(0,0,btnBitmap.getWidth(),btnBitmap.getHeight());
		canvas.drawBitmap(btnBitmap,btnBitmapS,buttonNextF,null);
	}
	
	public static void messageBoxForClosingApp(final Context context){
		new AlertDialog.Builder(context)
		.setIcon(R.drawable.girl1)
		.setTitle(R.string.closeAppHeading)
		.setMessage(R.string.closeAppString)
		.setCancelable(false)
		.setPositiveButton(R.string.haanString, new DialogInterface.OnClickListener() {
		 public void onClick(DialogInterface dialog, int id){
			 ((Activity) context).setResult(Constant.REPLAY);
			 ((Activity) context).finish();
		}})
		.setNegativeButton(R.string.nahiString,  new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){
		}}).show();
	}

    /*
        by shah
        */
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId ) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        int imageHeight = (int)(options.outHeight* GlobalVariables.yScale_factor);//scaled height   by shah
        int imageWidth = (int)(options.outWidth * GlobalVariables.xScale_factor);// scaled width    by shah
        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, imageWidth, imageHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return Utility.getResizedBitmap(BitmapFactory.decodeResource(res, resId, options), imageWidth, imageHeight);
    }
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}


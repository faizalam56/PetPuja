package com.abdullah.canvas;


import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.PetPuja;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sprite;
import com.abdullah.activities.*;

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
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StoryPart9Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{

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
	int threadTimeController=50;
	
	    public StoryPart9Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		myConstant=new Constant(context);
		backGround = Constant.backGround;
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		drawBackground(canvas,backGround);
		drawAnimation(canvas);
		
		drawText(canvas,getClass().getSimpleName()+" SCENE NO : "+whichScene,canvasWidth/2,100,20);
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
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
			default:
				
		}
   
		
	}

	private void scene_1(Canvas canvas) {
		drawButtonNext(canvas,button,canvasWidth/2,canvasHeight-button.getHeight());
//		Constant.drawButtonClose(canvas,canvasWidth-Constant.close.getWidth(), Constant.close.getHeight()*3/2);
	}


	private void scene_0(Canvas canvas) {
		myConstant.drawImageWithRotation(canvas);
	    loadImages();
	}
	

	
	public void drawButton(Canvas canvas, Bitmap btnBitmap,int xMidPosition, int yMidPosition) {
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
			case 1:
				if(buttonNextF!=null&&buttonNextF.intersect(touchrecF)){
						 ((Activity)context).setResult(Activity.RESULT_OK);
		                 ((Activity)context).finish();
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
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		TF=false;
		if(gameThread==null){
		Log.e("Thread Status",""+gameThread.getState());
		gameThread=null;
		}
		Log.e("SurfaceView","surfaceDestroyed");
		
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		StoryPart9Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,StoryPart9Canvas mycanvas) {
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
						Thread.sleep(threadTimeController);
					} catch (InterruptedException e) {
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

	@Override
	public void run() {
		girl1 = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.girl1);
		button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
		image1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.background);
		drawMidSprite=new Sprite(girl1,1);
		whichScene=1;
	}
	
}

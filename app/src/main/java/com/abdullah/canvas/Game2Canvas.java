package com.abdullah.canvas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.PetPuja;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.abdullah.petpuja.ZoomInZoomOut;
import com.abdullah.activities.*;
import com.zmq.utility.GlobalVariables;

public class Game2Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	int sceneNumber=0;
	Bitmap faces,backGround,button,age_chale,childLyrix,last_screen,wait;
	private RectF rectF,buttonRectF,imageRectF;
	private Rect imageRectS;
//	private float x;
//	private float y;
	Canvas canvas;
	Paint paint1,paintBtn;
//	int imageWidth,imageHeight;
	boolean TF=false;
	Context context;
	float xDpi,yDpi;
	float xScale,yScale;
	float xMultiplyer,yMultiplyer;
	int canvasWidth,canvasHeight;
	int sleepTime=50;
	int threadTimeController=1;
	int xMove,yMove;
	float lastSpritePositionX,lastSpritePositionY;
	RectF buttonFY,buttonFN,girlRectF,buttonFTA,bowlRectF,buttonNextF,handRectF;
	Rect girlRectS;
	boolean actionButtonYesTouched,actionButtonNoTouched;
	Sprite drawSprite,spriteChildObj,spriteLyrixChildObj,spriteYesObj,spriteNoObj;
	int spriteIndex=0,lyrixIndex=0;
	
	Bitmap noDefault,yesDefault,noSelect,yesSelect,yes,no;
	boolean showButtons;
	
	boolean timerControllerMediaPlayer;
	int whatToPlay=0;
	int timerForMediaPlayer=0;
	MediaPlayer mediaPlayer = null,mediaPlayerTouch;
	boolean music=true;
	
	int distanceSecond,distanceFirst;
	
	int textZoomIndex=0;
	int yesIndex=0,noIndex=0;
	int sceneOk=0;
	
	Constant myConstant;
	Sound mySound;
	
	    public Game2Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		matrix=new Matrix();
		backGround = Constant.backGround;
		wait = Constant.waitingStar;
		myConstant=new Constant();
		mySound=new Sound(context);
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
//		xDpi=(float)(faces.getWidth()/2)/500;
//		yDpi=(float)faces.getHeight()/500;
//		
//		xMultiplyer=xDpi;
//		yMultiplyer=yDpi;
		
		drawBackground(canvas,backGround);
		drawAnimation(canvas, sceneNumber);
		if(Constant.HEADER==1) drawText(canvas,"SCENE NO : "+sceneNumber,200,100,40);
        
//        sceneNumber=5;
	}

	
	
	
	private void drawAnimation(Canvas canvas,int scene){
		
		switch(scene){
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
		}
		
		
		
		
	}


	

	private void scene_8(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}


	private void scene_9(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}


	private void scene_10(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
	private void scene_7(Canvas canvas) {
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(!last_screen.isRecycled()){
		Rect r=new Rect(0,0,last_screen.getWidth(),last_screen.getHeight());
		RectF rf=new RectF(0,0,canvasWidth,canvasHeight);
		canvas.drawBitmap(last_screen, r, rf, null);
		}
		
		
		myConstant.drawButtonNext(canvas);
		myConstant.drawButtonReplay(canvas);

//		threadTimeController=0;
//		TF=false;
//		gameThread=null;
//		getHandler().removeCallbacks(this);
//		((Activity)context).setResult(Activity.RESULT_OK);
//		((Activity)context).finish();
//		clearAll();
	}



	private void scene_6(Canvas canvas) {
		Rect r=new Rect(0,0,last_screen.getWidth(),last_screen.getHeight());
		RectF rf=new RectF(0,0,canvasWidth,canvasHeight);
		canvas.drawBitmap(last_screen, r, rf, null);
//		playMusic();
		mySound.playSound(R.raw.game2_4);
		if(mySound.ifPlaying()==0){
			sceneNumber=7;
			mySound.stopSound();
		}
	}
	
	private void scene_5(Canvas canvas){
		girlRectS=new Rect(0,0,faces.getWidth()/2,faces.getHeight());
		girlRectF=new RectF(canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2,canvasWidth/2+faces.getWidth()/4,canvasHeight/2+faces.getHeight()/2);
		spriteChildObj.drawSpriteByRectF(canvas, girlRectF, spriteIndex,null);
		childLyrixMove(canvas);
		if(showButtons)drawButtons(canvas,yes,no); 
//		if(threadTimeController%10==0)
			sceneNumber=6;
	}

	private void scene_4(Canvas canvas) {
		girlRectS=new Rect(0,0,faces.getWidth()/2,faces.getHeight());
		girlRectF=new RectF(canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2,canvasWidth/2+faces.getWidth()/4,canvasHeight/2+faces.getHeight()/2);
		spriteChildObj.drawSpriteByRectF(canvas, girlRectF, spriteIndex,null);
		childLyrixMove(canvas);
		
		if(showButtons)drawButtons(canvas,yes,no); 
		playMusic();
		
	}


	private void scene_3(Canvas canvas) {
		girlRectS=new Rect(0,0,faces.getWidth()/2,faces.getHeight());
		girlRectF=new RectF(canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2,canvasWidth/2+faces.getWidth()/4,canvasHeight/2+faces.getHeight()/2);
		spriteChildObj.drawSpriteByRectF(canvas, girlRectF, spriteIndex,null);
		childLyrixMove(canvas);
		
		if(showButtons)drawButtons(canvas,yes,no); 
		playMusic();
		
	}

	private void scene_2(Canvas canvas) {

		girlRectS=new Rect(0,0,faces.getWidth()/2,faces.getHeight());
		girlRectF=new RectF(canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2,canvasWidth/2+faces.getWidth()/4,canvasHeight/2+faces.getHeight()/2);
		spriteChildObj.drawSpriteByRectF(canvas, girlRectF, spriteIndex,null);
		childLyrixMove(canvas);
		
		if(showButtons)drawButtons(canvas,yes,no); 
		if(threadTimeController%10==0)playMusic();
		
	}


	


	private void scene_1(Canvas canvas) {
//		    if(yScale>canvasHeight){
//			xScale-=10*xMultiplyer;
//			yScale-=10*yMultiplyer;
//			lastSpritePositionX=canvasWidth/2-xScale/2;
//			lastSpritePositionY=canvasHeight/2-yScale/2;
//			girlRectS=new Rect(0,0,faces.getWidth()/2,faces.getHeight());
//		    }else{
//			if(threadTimeController%10==0)playMusic();	
//		    }
//		    girlRectF=new RectF(lastSpritePositionX,lastSpritePositionY,lastSpritePositionX+xScale,lastSpritePositionY+yScale);
		    
		    if(threadTimeController%10==0)playMusic();
		    girlRectF=new RectF(canvasWidth/2-faces.getWidth()/4,canvasHeight/2-faces.getHeight()/2,canvasWidth/2+faces.getWidth()/4,canvasHeight/2+faces.getHeight()/2);
			spriteChildObj.drawSpriteByRectF(canvas, girlRectF, spriteIndex,null);
			
	}


	private void scene_0(Canvas canvas) {
		drawImageWithRotation(canvas,matrix,wait);
		loadImages();
	}
	
	private void childLyrixMove(Canvas canvas) {
		
		RectF rectLyrixF=new RectF(canvasWidth/2-childLyrix.getWidth()/16,canvasHeight/2-childLyrix.getHeight()/2-(int)(GlobalVariables.yScale_factor*2),canvasWidth/2+childLyrix.getWidth()/16,canvasHeight/2+childLyrix.getHeight()/2-(int)(GlobalVariables.yScale_factor*2));
		spriteLyrixChildObj.drawSpriteByRectF(canvas, rectLyrixF, lyrixIndex,null);
        
		if(threadTimeController%2==0){     
			 if(lyrixIndex<7)lyrixIndex++;
		        else lyrixIndex=0;
		}
       
	}
	
	private void playMusic() { 
		 if(mediaPlayer==null){
			 switch(sceneNumber){
				case 0:
					break;
				case 1:
					 whatToPlay=R.raw.game2_1;
					break;
				case 2:
					whatToPlay=R.raw.game2_2;
					break;
				case 3:
					whatToPlay=R.raw.right;
					break;
				case 4:
					whatToPlay=R.raw.wrong;
					break;
				case 5:
					break;
				case 6:
					whatToPlay=R.raw.game2_3;
					break;
				}
			 mediaPlayer = MediaPlayer.create(getContext(),whatToPlay);
			 mediaPlayer.start();
		     }
		 
			   if(mediaPlayer!=null)
			   mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						timerControllerMediaPlayer=true;
						switch (sceneNumber){
						case 0:
							break;
						case 1:
							sceneOk=2;
							break;
						case 2:
							showButtons=true;
							break;
						case 3:
							sceneNumber=5;
							showButtons=true;
							break;
						case 4:
							sceneNumber=5;
							showButtons=true;
							break;
						case 5:
							showButtons=true;
							sceneNumber=6;
							break;
						case 6:
							showButtons=false;
//							stopPlayingMusic();
//							sceneNumber=7;
							break;
						default:
							break;
						}
						
					}
				});
			 
			   
			   if(timerControllerMediaPlayer)
			   {
//				   stopPlayingMusic();
				   timerForMediaPlayer++;
			   }
			   if(timerForMediaPlayer==8){  // wait time for second time playing
				   stopPlayingMusic();
				   timerForMediaPlayer=0;
			   }
			   
//			   if(timerControllerMediaPlayer&&threadTimeController%5==0){     // wait time for second time playing
//				   stopPlayingMusic();
//			   }
			   
	}

	private void drawButtons(Canvas canvas, Bitmap yes,Bitmap no) {
		buttonFN=new RectF(canvas.getWidth()/8-no.getWidth()/4,canvas.getHeight()-no.getHeight()-(int)(GlobalVariables.yScale_factor*60),canvas.getWidth()/8+no.getWidth()/4,canvas.getHeight()-(int)(GlobalVariables.yScale_factor*60));
		buttonFY=new RectF(canvas.getWidth()*7/8-yes.getWidth()/4,canvas.getHeight()-yes.getHeight()-(int)(GlobalVariables.yScale_factor*60),canvas.getWidth()*7/8+yes.getWidth()/4,canvas.getHeight()-(int)(GlobalVariables.yScale_factor*60));
		spriteYesObj.drawSpriteByRectF(canvas,buttonFY,yesIndex,null);
		spriteNoObj.drawSpriteByRectF(canvas,buttonFN,noIndex,null);
		
//		canvas.drawBitmap(yes,backGroundS,buttonFY,null);
//		canvas.drawBitmap(no,backGroundS,buttonFN,null);
	}




	private void drawText(Canvas canvas, String Text) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.WHITE);
		paint.setTextSize(45);
		Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
		paint.setTypeface(tf);
		paint.setTextAlign(Align.CENTER);
		canvas.drawText(Text,canvas.getWidth()/2, (int)(GlobalVariables.yScale_factor*80), paint);
	}


	private void drawBackground(Canvas canvas, Bitmap backGround) {
		Rect  backGroundS=new Rect(0,0,backGround.getWidth(),backGround.getHeight());
		RectF backGroundF=new RectF(0,0,canvasWidth ,canvasHeight);
		canvas.drawBitmap(backGround,backGroundS,backGroundF,null);
	}

	private void drawButtonNext(Canvas canvas, Bitmap buttonNext) {
		Rect  backGroundS=new Rect(0,0,buttonNext.getWidth(),buttonNext.getHeight());
		buttonNextF=new RectF(canvasWidth/2-buttonNext.getWidth()/2,canvasHeight/2-buttonNext.getHeight()/2,canvasWidth/2+buttonNext.getWidth()/2,canvasHeight/2+buttonNext.getHeight()/2);
		canvas.drawBitmap(buttonNext,backGroundS,buttonNextF,null);
	}

	
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event ) {
		RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
		float FirstnewDist=0;
		float secondNewDistance=0;
		switch (event.getAction() & MotionEvent.ACTION_MASK) {

		case MotionEvent.ACTION_DOWN:
			switch(sceneNumber){
			case 0:
				
				break;
			case 1:
				 if(girlRectF!=null&girlRectF.intersect(touchrecF)&sceneOk==2){
				  mediaPlayerTouch.start();
				  stopPlayingMusic();
	  			  spriteIndex=1;
	  			  sceneNumber=2;
				 }
				break;
			case 2:
				    if(girlRectF.intersect(touchrecF)&&event.getPointerCount()==2){
//				    	mediaPlayerTouch.start();
				    	distanceFirst=(int)event.getY();
				    }
			        
				    
				    if(showButtons&&buttonFY!=null&&buttonFN!=null){
				    	mediaPlayerTouch.start();
						if(buttonFY.intersect(touchrecF)){
							stopPlayingMusic();
							yesIndex=1;
							sceneNumber=3;
						}
						if(buttonFN.intersect(touchrecF)){
							stopPlayingMusic();
							noIndex=1;
							yesIndex=1;
							sceneNumber=4;
						}
						
					}
				    
				break;
			case 3:
				
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
//				if(buttonNextF!=null)
//					if(buttonNextF.intersect(touchrecF)){
//						mediaPlayerTouch.start();
//						TF=false;
//	                    gameThread=null; 
//	                    stopPlayingMusic();
//                        ((Activity)context).finish();
//				}
				 if(Constant.nextF!=null&&Constant.nextF.intersect(touchrecF)){
				    	mediaPlayerTouch.start();
				    	threadTimeController=0;
						TF=false;
						gameThread=null;
						getHandler().removeCallbacks(this);
						((Activity)context).setResult(Activity.RESULT_OK);
						((Activity)context).finish();
						clearAll();
				 }
				if(Constant.replayF!=null&&Constant.replayF.intersect(touchrecF)){
						mediaPlayerTouch.start();
				    	threadTimeController=0;
						TF=false;
						gameThread=null;
						getHandler().removeCallbacks(this);
						((Activity)context).setResult(Constant.REPLAY);
						((Activity)context).finish();
						clearAll();
					
						 }
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;	
			}
			

			break;
			
		case MotionEvent.ACTION_MOVE:
			switch(sceneNumber){
			case 0:
				
				break;
			case 1:
				 if(girlRectF.intersect(touchrecF)&&event.getPointerCount()==2){
					   mediaPlayerTouch.start();
		    		   distanceSecond=(int) getFingerSpacing(event);
	                   if(distanceSecond>distanceFirst+50&&sceneOk==2)
	                   {
	                	  stopPlayingMusic();
		    			  spriteIndex=1;
		    			  sceneNumber=2;
                          
	                   }
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
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;	
			}
			
			
		

	         
	         break;
	         
		case MotionEvent.ACTION_POINTER_DOWN:
			
			switch(sceneNumber){
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
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;	
			}
			
			 FirstnewDist=event.getY();
			 secondNewDistance=event.getY();
			 distanceSecond=(int)event.getY();
			 
			 //////////////////////////////////////
			 if(event.getPointerCount()==2){
				 distanceFirst=(int) getFingerSpacing(event);
//	    		   Log.e("getFingerSpacing between fingers",""+getFingerSpacing(event));
	    	      }
	         break;
	         
		case MotionEvent.ACTION_POINTER_UP:
			 distanceSecond=(int)event.getY();
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
		holder.addCallback(this);
		gameThread = new GameThread(holder, this);
		gameThread.start();
		Log.e("SurfaceView","surfaceCreated");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		TF=false;
		gameThread=null;
		stopPlayingMusic();
		holder.removeCallback(this);
		Log.e("SurfaceView","surfaceDestroyed GAME 2");
		
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		Game2Canvas _mycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,Game2Canvas mycanvas) {
			// TODO Auto-generated constructor stub
			_suHolder = surfaceHolder;
			 _mycanvas = mycanvas;
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
							_mycanvas.onDraw(canvas);
							threadTimeController++;
							if(threadTimeController==100)threadTimeController=1;
						}
					}
					try {
						Thread.sleep(sleepTime);
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
	
	private void drawText(Canvas canvas, String Text1,int positionX,int positionY,int size) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.WHITE);
		paint.setTextSize(size);
		Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
		paint.setTypeface(tf);
		paint.setTextAlign(Align.CENTER);
		canvas.drawText(Text1,positionX,positionY, paint);
	}

	private void drawButtonsRightWrong(Canvas canvas2, Bitmap right,Bitmap wrong) {
    	Rect  backGroundS=new Rect(0,0,yes.getWidth(),yes.getHeight());
    	if(actionButtonYesTouched){
    	RectF buttonRightF=new RectF(canvas.getWidth()*3/4+yes.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()*3/4+yes.getWidth()/2+right.getWidth(),canvas.getHeight()/2+right.getHeight());
    	canvas.drawBitmap(right,backGroundS,buttonRightF,null);
    	}
    	if(actionButtonNoTouched){
    	RectF buttonWrongF=new RectF(canvas.getWidth()*3/4+no.getWidth()/2,canvas.getHeight()/2+yes.getHeight(),canvas.getWidth()*3/4+no.getWidth()/2+wrong.getWidth(),canvas.getHeight()/2+yes.getHeight()+wrong.getHeight());
			canvas.drawBitmap(wrong,backGroundS,buttonWrongF,null);
    	}
		
	   }
	
	private void drawButton(Canvas canvas, Bitmap button) {
		Rect  backGroundS=new Rect(0,0,button.getWidth(),button.getHeight());
		buttonNextF=new RectF(canvas.getWidth()/2-button.getWidth()/2,canvas.getHeight()-button.getHeight(),canvas.getWidth()/2+button.getWidth()/2,canvas.getHeight());
		canvas.drawBitmap(button,backGroundS,buttonNextF,null);
	}
	
	private float getFingerSpacing(MotionEvent event) {
	    float x = event.getX(0) - event.getX(1);
	    float y = event.getY(0) - event.getY(1);
	    return FloatMath.sqrt(x * x + y * y);
	}

	  public void stopPlayingMusic(){
		   if(mediaPlayer!=null){
			   if(mediaPlayer.isPlaying())
			   {
				   mediaPlayer.stop();
				   mediaPlayer.release();
			   }
			   mediaPlayer=null;
		   }
		   timerControllerMediaPlayer=false;
		   timerForMediaPlayer=0;
	   }
	  
	  
	  Bitmap faltu1,faltu12,faltu13;
	  Matrix matrix;
	  Thread localThread;
	  boolean initialiseThreadLoad=true;
	  float rotationAngle=0;
	  private void  drawImageWithRotation(Canvas canvas,Matrix matrix,Bitmap image){
	    
	        if(rotationAngle>=360)rotationAngle=0;
	        else rotationAngle+=22.5;
	 
	        matrix.preTranslate(canvasWidth/2-image.getWidth()/2,canvasHeight/2-image.getHeight()/2);
	    	matrix.setRotate(rotationAngle,image.getWidth()/2,image.getHeight()/2);
	    	matrix.postTranslate(canvasWidth/2-image.getWidth()/2,canvasHeight/2-image.getHeight()/2);
	    	canvas.drawBitmap(wait, matrix, null);
	    }
	  
	  
	  public void loadImages(){
			if(initialiseThreadLoad){
			   localThread=new Thread(this);
			   localThread.start();
			   initialiseThreadLoad=false;
				}
		}
	  
	  @Override
		public void run() {
			initialiseImages();
		}
	  private void initialiseImages() {
		  
		  
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    backGround= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.link3_4a);
			button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
			faces = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_mouth_opening_sprite);
			childLyrix= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_laranx_sprite);
			last_screen= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_last_screen);
			yes= Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.game2_yes);
			no= Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.game2_no);
			age_chale= Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.gonext);
			mediaPlayerTouch=MediaPlayer.create(context, R.raw.touch);
			spriteYesObj=new Sprite(yes,2);
			spriteNoObj=new Sprite(no,2);
			spriteChildObj=new Sprite(faces,2);
			spriteLyrixChildObj=new Sprite(childLyrix,8);
			
			faltu1=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_mouth_opening_sprite);
			faltu12=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_mouth_opening_sprite);
			faltu13=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game2_mouth_opening_sprite);

			
			sceneNumber=1;
			threadTimeController=1;
		}
	  

		private void clearAll() {
			button.recycle();
			faces.recycle();
			childLyrix.recycle();
			last_screen.recycle();
			yes.recycle();
			no.recycle();
			age_chale.recycle();
			myConstant=null;
			mySound=null;
			spriteYesObj=null;
			spriteNoObj=null;
			spriteChildObj=null;
			spriteLyrixChildObj=null;
		}

	
}

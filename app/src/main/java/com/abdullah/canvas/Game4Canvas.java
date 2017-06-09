package com.abdullah.canvas;

import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.abdullah.petpuja.Sound;
import com.abdullah.petpuja.Sprite;
import com.zmq.utility.GlobalVariables;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.webkit.WebView;
import android.widget.ImageView;

public class Game4Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
	
	GameThread gameThread;
	boolean up, initialiseThreadLoad=true;
	int INDEX=0;
	static int TIMER=0;
	String str = "My Name is Abdullah";
	Bitmap wait,numbers,girl1,backGround,button,sprite,right,wrong,age_Chale,image3;
	private RectF rightRectF,wrongRectF,rectF;
	private Rect buttonRectS,imageRectS;
	private int alphaMax=255,alphaMin=0;
	private int changeAlpha;
	Canvas canvas;
	Paint paint1,paint2,paintBtn;
	int buttonWidth,buttonHeight,imageWidth,imageHeight;
	boolean TF=false;
	Context context;
	Sprite drawMidSprite,spriteNumnersObj,spriteMouthOpenningObj;
	Bitmap crying1,crying2,crying3,crying4,crying5,crying6,crying7 ;
	Sprite spriteChildCrying1,spriteChildCrying2,spriteChildCrying3,spriteChildCrying4,spriteChildCrying5,spriteChildCrying6,spriteChildCrying7;
	int childCryingSpriteIndex=0,spriteChanger=0;
	String show_me="try me";
	int canvasWidth,canvasHeight;

	int whichScene=0;
	int sleepTime=0;
	long threadTimeController=1;
	int spriteIndexNumner=0;
	int case7switchIndex=0,case9switchIndex=0;
	Matrix matrix;
	float rotationAngle=0;  
	
	MediaPlayer mediaPlayer=null,mediaPlayerTouch,mediaPlayerCry;
	int timerForMediaPlayer=0;
	boolean timerControllerMediaPlayer=false;
	int whatToPlaySound;
	int cryingSound=R.raw.cry01;
	
	boolean spriteIndexController=true;
	
	int zoomStart=-156;
	int zoomINOutWrong=zoomStart,zoomINOutRight=zoomStart;
	boolean INOutWrong,INOutRight,zoomWrong,zoomRight;
	Thread localThread;
	
	Constant myConstant;
	
	boolean playingSound=false;
	int  noOfTimePlaying=1;
	int startSoundDelay=0;
	int crySound;
	    public Game4Canvas(Context context) {
		super(context);	
		this.context=context;
		getHolder().addCallback(this);
		backGround = Constant.backGround;
//		numbers = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.numbers);
		wait = Constant.waitingStar;
//		spriteNumnersObj=new ShahSprite(numbers,10);
		matrix=new Matrix();
		paint1=new Paint(Paint.ANTI_ALIAS_FLAG);
		paint2=new Paint(Paint.ANTI_ALIAS_FLAG);
		myConstant=new Constant();
	    }

	
	@Override
	protected void onDraw(Canvas canvas) {
		this.canvas=canvas;
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		drawBackground(canvas,backGround);
		drawAnimation(canvas);
		if(Constant.HEADER==1){
		drawText(canvas,"SCENE NO : "+whichScene,100,100,25);
		drawText(canvas,"timer : "+timerForMediaPlayer,getWidth()-100,100,25);
		drawText(canvas,"nooftimePlaying " +noOfTimePlaying,getWidth()/2, 100, 30);
		}
	}

	
	
	private void drawAnimation(Canvas canvas){
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
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		}
   
		
	}
	
	
	private void scene_11(Canvas canvas) {
//		Rect sourscRect= new Rect(0,0,age_Chale.getWidth(),age_Chale.getHeight());
//		rectF= new RectF(canvasWidth/2-age_Chale.getWidth()/2,canvasHeight/2-age_Chale.getHeight()/2,canvasWidth/2+age_Chale.getWidth()/2,canvasHeight/2+age_Chale.getHeight()/2);
//		canvas.drawBitmap(age_Chale,sourscRect,rectF, null);
		
		
		if(!crying6.isRecycled())spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,null);
		if(!wrong.isRecycled())drawButtonWrong(canvas,wrong);
		if(!right.isRecycled())drawButtonRight(canvas, right);
		
		 myConstant.drawButtonNext(canvas);
		 myConstant.drawButtonReplay(canvas);
		
//		TF=false;
//		gameThread=null;
//		getHandler().removeCallbacks(this);
//		((Activity)context).setResult(Activity.RESULT_OK);
//		((Activity)context).finish();
//		clearAll();

	}
	
	private void scene_10(Canvas canvas) {
		   childCryingSpriteIndex=0;
		   buttonZoonOut();
		   if(spriteChanger==4*(spriteChildCrying6.getNoOfImagesInSprite()-1))playMusic();
		   spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,null);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		   
		   if(zoomINOutWrong==zoomStart){
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//                stopPlayingMusic();
                whichScene=11;
		   }
		
	}

	private void scene_9(Canvas canvas) {
		
		switch(case9switchIndex){
		   case 7:
			   break;
		   case 6:
			   break;
		   case 5:
			   break;
		   case 4:
			   break;
		   case 3:
			   playMusic(); 
			   if(childCryingSpriteIndex==spriteChildCrying5.getNoOfImagesInSprite()-1)spriteIndexController=false;
			   if(childCryingSpriteIndex==0)spriteIndexController=true;
			   
			   if(threadTimeController%5==0){
			   if(spriteIndexController){
				   childCryingSpriteIndex++;
			   }
			   else childCryingSpriteIndex--;
			   }
			   changeAlpha=0;
			   break;
		   case 2:
			   playMusic(); 
			   if(changeAlpha<alphaMax)changeAlpha+=5;
			   paint1.setAlpha(255-changeAlpha);
			   paint2.setAlpha(changeAlpha);
			   if(changeAlpha==255){
				   case9switchIndex=3;
				   changeAlpha=0;
			   }
			   break;
		   case 1:
			   buttonZoonIn();
			   if(zoomINOutWrong==0)case9switchIndex=2;  // icon has been zoomed
			   break;
		   case 0:    // yes shake head 
			   paint1.setAlpha(255);
			   if(childCryingSpriteIndex==spriteChildCrying7.getNoOfImagesInSprite()-1)spriteIndexController=false;
			   if(childCryingSpriteIndex==0)spriteIndexController=true;
				
			   if(threadTimeController%5==0){
			   if(spriteIndexController)childCryingSpriteIndex++;
			   else childCryingSpriteIndex--;

			   if(spriteChanger<6*(spriteChildCrying7.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
				   spriteChanger++;
			   }else childCryingSpriteIndex=0;
			   }
			   if(spriteChanger==6*(spriteChildCrying7.getNoOfImagesInSprite()-1))case9switchIndex=1;
			   break;
		   }

		   spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
		   spriteChildCrying7.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		   ////////////////////////////////////////////////////////////////////////////////////////////////////
		
		   
           
//		   if(zoomINOutWrong==0){
//				   playMusic(); 
//				   if(childCryingSpriteIndex==spriteChildCrying7.getNoOFImagesInSprite()-1)spriteIndexController=false;
//				   if(childCryingSpriteIndex==0)spriteIndexController=true;
//				   
//				   if(threadTimeController%5==0){
//				   if(spriteIndexController)childCryingSpriteIndex++;
//				   else childCryingSpriteIndex--;
//
//				   }
//
//		   }
//		
//		   spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
//		   spriteChildCrying7.drawSprite(canvas,childCryingSpriteIndex,canvasWidth/2,canvasHeight/2,null);
//		   drawButtonWrong(canvas,wrong);
//		   drawButtonRight(canvas, right);
		
	}
	

	
    private void scene_8(Canvas canvas) {

		   if(childCryingSpriteIndex==spriteChildCrying6.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
		   
		   if(threadTimeController%5==0){
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<4*(spriteChildCrying6.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   }
		   
		   playMusic();
		   buttonZoonOut();
		   
		   if(changeAlpha<alphaMax)changeAlpha+=5;
		   paint1.setAlpha(255-changeAlpha);
		   paint2.setAlpha(changeAlpha);
		   if(changeAlpha==255)case7switchIndex=3;
		   
		   spriteChildCrying7.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
		   spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		   
//		   changeAlpha=0;
//		   paint1.setAlpha(255);
		
	}


	private void scene_7(Canvas canvas) {
		   switch(case7switchIndex){
		   case 7:
			   break;
		   case 6:
			   break;
		   case 5:
			   break;
		   case 4:
			   break;
		   case 3:
//			   playMusic(); 
			   if(childCryingSpriteIndex==spriteChildCrying5.getNoOfImagesInSprite()-1)spriteIndexController=false;
			   if(childCryingSpriteIndex==0)spriteIndexController=true;
			   if(threadTimeController%5==0){
			   if(spriteIndexController){
				   childCryingSpriteIndex++;
			   }
			   else childCryingSpriteIndex--;
			   }
			   changeAlpha=0;
			   break;
		   case 2:
			  
			   if(changeAlpha<alphaMax)changeAlpha+=5;
			   paint1.setAlpha(255-changeAlpha);
			   paint2.setAlpha(changeAlpha);
			   if(changeAlpha==255){
				   case7switchIndex=3;
				   changeAlpha=0;
			   }
			   break;
		   case 1:
			   buttonZoonIn();
			   if(zoomINOutWrong==0){
				   playMusic(); 
				   case7switchIndex=2;  // icon has been zoomed
			   }
			   break;
		   case 0:    // yes shake head 
			   if(childCryingSpriteIndex==spriteChildCrying4.getNoOfImagesInSprite()-1)spriteIndexController=false;
			   if(childCryingSpriteIndex==0)spriteIndexController=true;
				
			   if(threadTimeController%5==0){
			   if(spriteIndexController)childCryingSpriteIndex++;
			   else childCryingSpriteIndex--;

			   if(spriteChanger<6*(spriteChildCrying4.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
				   spriteChanger++;
			   }else childCryingSpriteIndex=0;
			   }
			   if(spriteChanger==6*(spriteChildCrying4.getNoOfImagesInSprite()-1))case7switchIndex=1;
			   break;
		   }

		   spriteChildCrying6.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
		   spriteChildCrying4.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);

	}
	private void scene_6(Canvas canvas){
//		   playMusic();

		   if(childCryingSpriteIndex==spriteChildCrying4.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
		   
		   if(threadTimeController%5==0){
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<4*(spriteChildCrying4.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   }
		   
		   buttonZoonOut();
		   if(spriteChanger==4*(spriteChildCrying4.getNoOfImagesInSprite()-1))playMusic();
		   spriteChildCrying4.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,null);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		   
		   changeAlpha=0;
		   paint1.setAlpha(255);
		   paint2.setAlpha(0);
		   
		
	}
	private void scene_5(Canvas canvas){
//		   playMusic();
		   if(childCryingSpriteIndex==spriteChildCrying3.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
		   
		   if(threadTimeController%5==0){
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<4*(spriteChildCrying3.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   }
		   
		   if(spriteChanger==4*(spriteChildCrying3.getNoOfImagesInSprite()-1)){ // after sprite zoom 
			   buttonZoonIn();
			   if(zoomINOutRight==0){
				   playMusic(); 
				   mediaPlayerCry.stop();
				   if(changeAlpha<alphaMax)changeAlpha+=5;
				   paint1.setAlpha(255-changeAlpha);
				   paint2.setAlpha(changeAlpha);
				   spriteChildCrying4.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
			   }
			   
		   }
		   
//		   if(spriteChanger==4*(spriteChildCrying3.getNoOFImagesInSprite()-1))playMusic();
		   spriteChildCrying3.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		
	}
	
	private void scene_4(Canvas canvas) {   // moving head in yes //(3+4)
		
		   if(childCryingSpriteIndex==spriteChildCrying3.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
			
		   if(threadTimeController%5==0){
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<4*(spriteChildCrying3.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   }
		   
		   spriteChildCrying3.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,null);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		   
		   if(spriteChanger==4*(spriteChildCrying3.getNoOfImagesInSprite()-1))playMusic();
		   buttonZoonOut();
		   
		   changeAlpha=0;
		   paint1.setAlpha(255);
	}


	private void scene_3(Canvas canvas) {  //(3+4)
		  
		   mediaPlayerCry.stop();
		   
		   if(childCryingSpriteIndex==spriteChildCrying2.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
			
		   if(threadTimeController%5==0){
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<4*(spriteChildCrying2.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   
		   }
		   
		   if(spriteChanger==4*(spriteChildCrying2.getNoOfImagesInSprite()-1)){ // after sprite zoom 
			   buttonZoonIn();
			   if(zoomINOutRight==0){
				   playMusic(); 
				   if(changeAlpha<alphaMax)changeAlpha+=5;
				   paint1.setAlpha(255-changeAlpha);
				   paint2.setAlpha(changeAlpha);
				   spriteChildCrying3.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
			   }
//			   spriteChildCrying3.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2);
		   }
		       
		   spriteChildCrying2.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint1);
//		   spriteChildCrying3.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,paint2);
		   
		   
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		
	}


	private void scene_2(Canvas canvas){
		  
		   if(childCryingSpriteIndex==spriteChildCrying1.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
			
		   if(threadTimeController%5==0){
			   if(spriteIndexController)childCryingSpriteIndex++;
			   else childCryingSpriteIndex--;
			   
			   if(spriteChanger<2*(spriteChildCrying1.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
				   spriteChanger++;
			   }else childCryingSpriteIndex=0;
		   }
		   
		   if(spriteChanger==2*(spriteChildCrying1.getNoOfImagesInSprite()-1))
			   {
			   
			   if(mediaPlayerCry.isPlaying())mediaPlayerCry.setVolume((float)0.5,(float)1);
			   playMusic();
			   }
		  
		   
		   spriteChildCrying1.drawSprite(canvas,childCryingSpriteIndex, canvasWidth/2,canvasHeight/2,null);
		   drawButtonWrong(canvas,wrong);
		   drawButtonRight(canvas, right);
		
		  
	}


	private void scene_1(Canvas canvas){
	   mediaPlayerCry.start();
	 
	   spriteChildCrying1.drawSprite(canvas, 0, canvasWidth/2,canvasHeight/2,null);
	   drawButtonWrong(canvas,wrong);
	   drawButtonRight(canvas, right);
	   
	   if(startSoundDelay>80)playMusic();
	   
	  
	}



    private void scene_0(Canvas canvas) {
	   drawImageWithRotation(canvas,matrix,wait);
	   loadImages();
	}


//	private void drawImageWait(Canvas canvas) {	
//    WebView wv=new WebView(context);
//    ImageView iv =new ImageView(context);
//    iv.setImageBitmap(wait);
//    wv.addView(iv);
//	}


	private void drawNumbers(Canvas canvas) {
	 if(spriteIndexNumner<spriteNumnersObj.getNoOfImagesInSprite())spriteIndexNumner++;
	 else spriteIndexNumner=10;
	 spriteNumnersObj.drawSprite(canvas,spriteIndexNumner,canvasWidth/2,canvasHeight/2,null);
	}

    private void drawImageWithRotation(Canvas canvas,Matrix matrix,Bitmap image){
    	if(threadTimeController%5==0){
        if(rotationAngle>=360)rotationAngle=0;
        else rotationAngle+=22.5;
    	}
        matrix.preTranslate(canvasWidth/2-image.getWidth()/2,canvasHeight/2-image.getHeight()/2);
    	matrix.setRotate(rotationAngle,image.getWidth()/2,image.getHeight()/2);
    	matrix.postTranslate(canvasWidth/2-image.getWidth()/2,canvasHeight/2-image.getHeight()/2);
    	canvas.drawBitmap(wait, matrix, null);
    }
	

	private void drawButtonRight(Canvas canvas,Bitmap right) {
		Rect  btnBitmapS=new Rect(0,0,right.getWidth(),right.getHeight());
		rightRectF=new RectF(canvasWidth*5/6-right.getWidth()/2-zoomINOutRight/2,canvasHeight-right.getHeight()-(int)(GlobalVariables.yScale_factor*80)-zoomINOutRight/2,canvasWidth*5/6+right.getWidth()/2+zoomINOutRight/2,canvasHeight-(int)(GlobalVariables.yScale_factor*80)+zoomINOutRight/2);
		canvas.drawBitmap(right,btnBitmapS,rightRectF,null);
	}
	private void drawButtonWrong(Canvas canvas,Bitmap wrong) {
		Rect  btnBitmapS=new Rect(0,0,wrong.getWidth(),wrong.getHeight());
		wrongRectF=new RectF(canvasWidth/6-wrong.getWidth()/2-zoomINOutWrong/2,canvasHeight-wrong.getHeight()-(int)(GlobalVariables.yScale_factor*80)-zoomINOutWrong/2,canvasWidth/6+wrong.getWidth()/2+zoomINOutWrong/2,canvasHeight-(int)(GlobalVariables.yScale_factor*80)+zoomINOutWrong/2);
		canvas.drawBitmap(wrong,btnBitmapS,wrongRectF,null);
	}
	
	
	public void buttonZoonIn(){
		if(zoomRight){
			if(zoomINOutRight<0)zoomINOutRight+=6;
			}
		
		if(zoomWrong){
			if(zoomINOutWrong<0)zoomINOutWrong+=6;
			}
		
		
	}
    public void buttonZoonOut(){
    	if(zoomRight){
			if(zoomINOutRight>zoomStart)zoomINOutRight-=6;
			}
		
		if(zoomWrong){
			if(zoomINOutWrong>zoomStart)zoomINOutWrong-=6;
			}
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
		Rect  bitmapRectS=new Rect(0,0,btnBitmap.getWidth(),btnBitmap.getHeight());
		RectF bitmapRectF=new RectF(xMidPosition-btnBitmap.getWidth()/2,yMidPosition-btnBitmap.getHeight()/2,xMidPosition+btnBitmap.getWidth()/2,yMidPosition+btnBitmap.getHeight()/2);
		canvas.drawBitmap(btnBitmap,bitmapRectS,bitmapRectF,null);
	}
	private void drawBackground(Canvas canvas, Bitmap backGround) {
		Rect  rectS = new Rect(0,0,backGround.getWidth(),backGround.getHeight());
		RectF rectF = new RectF(0,0,canvasWidth,canvasHeight);
		canvas.drawBitmap(backGround,rectS,rectF,null);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event ) {
		RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			 if(rectF!=null&&rectF.intersect(touchrecF)){
	                ((Activity) context).finish(); 
				}
			if(zoomINOutWrong==zoomStart&&zoomINOutRight==zoomStart&&noOfTimePlaying>1){
				
//				 noOfTimePlaying=1;
			threadTimeController=1;
			
			switch(whichScene){
			case 0:
				break;
			case 1:
				if(rightRectF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					spriteChanger=0;
				}
				if(wrongRectF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					stopPlayingMusic();
					whichScene=2;
					spriteChanger=0;
					noOfTimePlaying=1;
				}
				
				break;
			case 2:
                if(rightRectF.intersect(touchrecF)){
                	mediaPlayerTouch.start();
                	stopPlayingMusic();
                	whichScene=3;
                	spriteChanger=0;
                	zoomRight=true;
                	noOfTimePlaying=1;
				}
				if(wrongRectF.intersect(touchrecF)){
//					spriteChanger=0;
					
				}
				break;
			case 3:
				mediaPlayerCry.stop();
				mediaPlayerCry.release();
				mediaPlayerCry=MediaPlayer.create(context,cryingSound);
				mediaPlayerCry.start();
                if(rightRectF.intersect(touchrecF)){
                	mediaPlayerTouch.start();
                	stopPlayingMusic();
                	whichScene=4;
                	spriteChanger=0;
                	zoomRight=true;
                	noOfTimePlaying=1;
				}
				if(wrongRectF.intersect(touchrecF)){
//					spriteChanger=0;
				}
				break;
			case 4:
                if(rightRectF.intersect(touchrecF)){
                	mediaPlayerTouch.start();
                	stopPlayingMusic();
                	whichScene=5;
                	spriteChanger=0;
                	zoomRight=true;
                	noOfTimePlaying=1;
				}
				if(wrongRectF.intersect(touchrecF)){
//					spriteChanger=0;
				}
				break;
			case 5:
                if(rightRectF.intersect(touchrecF)){
//                	stopPlayingMusic();
//                	whichScene=5;
//                	spriteChanger=0;
//                	zoomRight=true;
				}
				if(wrongRectF.intersect(touchrecF)){
//					spriteChanger=0;
				}
				break;
			case 6:
                if(rightRectF.intersect(touchrecF)){
                	
				}
				if(wrongRectF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					stopPlayingMusic();
					whichScene=7;
                	spriteChanger=0;
                	zoomWrong=true;
                	zoomRight=false;
                	noOfTimePlaying=1;
				}
				break;
			case 7:
                if(rightRectF.intersect(touchrecF)){
//                	spriteChanger=0;
				}
				if(wrongRectF.intersect(touchrecF)){
//					stopPlayingMusic();
//					whichScene=7;
//					spriteChanger=0;
//					zoomWrong=true;
					
				}
				break;
			case 8:
                if(rightRectF.intersect(touchrecF)){
//                	spriteChanger=0;
				}
				if(wrongRectF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					stopPlayingMusic();
					whichScene=9;
					spriteChanger=0;
					zoomWrong=true;
					changeAlpha=0;
					paint2.setAlpha(0);
					noOfTimePlaying=1;
				}
				break;
			case 10:
				
				break;
			
			case 11:
				if(Constant.nextF!=null&&Constant.nextF.intersect(touchrecF)){
			    	mediaPlayerTouch.start();
					TF=false;
					gameThread=null;
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Activity.RESULT_OK);
					((Activity)context).finish();
					clearAll();
			 }
			if(Constant.replayF!=null&&Constant.replayF.intersect(touchrecF)){
					mediaPlayerTouch.start();
					TF=false;
					gameThread=null;
					getHandler().removeCallbacks(this);
					((Activity)context).setResult(Constant.REPLAY);
					((Activity)context).finish();
					clearAll();
				
					 }
            break;
			}
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
		TF=true;
		gameThread = new GameThread(holder, this);
		gameThread.start();
		Log.e("SurfaceView","surfaceCreated");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		TF=false;
		mediaPlayerCry.stop();
		stopPlayingMusic();
		Log.e("SurfaceView","surfaceDestroyed");
//		Log.e("Thread Status",""+gameThread.getState());
		
	}
	
	
	@SuppressLint("WrongCall")
	class GameThread extends Thread{
		SurfaceHolder _suHolder;
		Game4Canvas _myMycanvas;
		
		public GameThread(SurfaceHolder surfaceHolder,Game4Canvas mycanvas) {
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
						threadTimeController+=1;
						startSoundDelay+=1;
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

	public void loadImages(){
		if(initialiseThreadLoad){
		   localThread=new Thread(this);
		   localThread.start();
		   initialiseThreadLoad=false;
			}
	}

	@Override
	public void run() {
		switch(whichScene){
		case 0:
			initialiseImages();
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
			
		}
		
	}
	
	
	
	private void playMusic() { 
		if(mediaPlayer!=null)
		Log.e("PLAYING SOUND ",""+noOfTimePlaying);
		
		 if(mediaPlayer==null){
			 timerControllerMediaPlayer=false;
			 timerForMediaPlayer=1;
			 switch(whichScene){
				case 0:
					break;
				case 1:
					 whatToPlaySound=R.raw.game4_1;
					 cryingSound=R.raw.cry01;
					break;
				case 2:
					 whatToPlaySound=R.raw.game4_2;
					 cryingSound=R.raw.cry01;
					break;
				case 3:
				case 4:
					 cryingSound=R.raw.cry02;
					 whatToPlaySound=R.raw.game4_3;
					break;
				case 5:
				case 6:
					 whatToPlaySound=R.raw.game4_4;
					break;
				case 7:
				case 8:
					 whatToPlaySound=R.raw.game4_5;
					break;
				case 9:
				case 10:
					 whatToPlaySound=R.raw.game4_6;
					break;
				}
			         
			         playingSound=true;
					 mediaPlayer = MediaPlayer.create(getContext(),whatToPlaySound);
					 mediaPlayer.start();
		     }
		 
		 if(mediaPlayer!=null)
		 mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					timerControllerMediaPlayer=true;
					playingSound=false;
					noOfTimePlaying++;
					switch(whichScene){
					case 0:
						initialiseImages();
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						whichScene=4;
						break;
					case 4:
						break;
					case 5:
						whichScene=6;
						break;
					case 6:
						
						break;
					case 7:
						whichScene=8;
						break;
					case 8:
						break;
					case 9:
						whichScene=10;
						break;
					case 10:
						break;
					case 11:
						break;
						
					}
				}
		 });
			  
			 
			   
			   if(timerControllerMediaPlayer){
				   timerForMediaPlayer++;
			   }

			   
			   if(timerForMediaPlayer==200){     // wait time for second time playing
				   timerControllerMediaPlayer=false;
				   timerForMediaPlayer=0;
                   stopPlayingMusic();
			   }
			
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
	   
	   public int getSpriteIndex(Sprite spriteChildCrying){
		   if(childCryingSpriteIndex==spriteChildCrying.getNoOfImagesInSprite()-1)spriteIndexController=false;
		   if(childCryingSpriteIndex==0)spriteIndexController=true;
			
		   if(spriteIndexController)childCryingSpriteIndex++;
		   else childCryingSpriteIndex--;

		   if(spriteChanger<2*(spriteChildCrying.getNoOfImagesInSprite()-1)){   // spriteChanger is used in stop sprite after playing no of times
			   spriteChanger++;
		   }else childCryingSpriteIndex=0;
		   
		   return childCryingSpriteIndex;
	   }

	   private void initialiseImages() {
		   
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
			button= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
			right= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.breastfeedingbig);
			wrong= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.bowlbig);
//			image3= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.startbutton);
			crying1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.crying1);
			crying2= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.crying2);
			crying3= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.crying3);
			crying4= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.normal4);
			crying5= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.normal5);
			crying6= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.normal6);
			crying7= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.normal7);
			age_Chale= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
			spriteChildCrying1=new Sprite(crying1, 4);
			spriteChildCrying2=new Sprite(crying2, 2);
			spriteChildCrying3=new Sprite(crying3, 2);
			spriteChildCrying4=new Sprite(crying4, 2);
			spriteChildCrying5=new Sprite(crying5, 2);
			spriteChildCrying6=new Sprite(crying6, 2);
			spriteChildCrying7=new Sprite(crying7, 2);
			mediaPlayerTouch=MediaPlayer.create(context, R.raw.touch);
			mediaPlayerCry=MediaPlayer.create(context,cryingSound);
			whichScene=1;
			threadTimeController=1;
			startSoundDelay=1;
		}
	   
	   private void clearAll() {
		   button.recycle();
			right.recycle();
			wrong.recycle();
			crying1.recycle();
			crying2.recycle();
			crying3.recycle();
			crying4.recycle();
			crying5.recycle();
			crying6.recycle();
			crying7.recycle();
			age_Chale.recycle();
		}
}

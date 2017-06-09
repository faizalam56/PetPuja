



package com.abdullah.canvas;

import com.abdullah.petpuja.*;
import com.zmq.utility.GlobalVariables;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game3Canvas extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    int sceneNumber=0,sleepTime=50;
    GameThread gameThread;
    Bitmap wrong,right,imageMid,sprite1,sprite2,sprite3,sprite4,sprite5,sprite6,spriteCover;
    int sprite1Index,sprite2Index,sprite3Index,sprite4Index,sprite5Index,sprite6Index;
    Bitmap wait,tryAgain,handRight,handWrong,backGround,ageBadhe;
    private RectF ageBadheF,tryAgainF,rectF,wrongF,rightF;
    Canvas canvas;
    Paint fadeOutpaint,paint1,paintBtn;
    int canvasWidth,canvasHeight;
    boolean TF=false;
    Context context;
    int fromAlpha=0,toAlpha=255,changeAlpha=0;
    Sprite sprite1Obj,sprite2Obj,sprite3Obj,sprite4Obj,sprite5Obj,sprite6Obj;
    int sceneOK=0;
    boolean music=true;
    MediaPlayer mediaPlayer=null,mediaPlayerTouch,mediaPlayerRighrWrongSound;
    int whatToPlay=0;
    boolean timerControllerMediaPlayer;
    int timerForMediaPlayer,sceneTimeController=1;
    Constant myConstant;

    public Game3Canvas(Context context) {
        super(context);
        this.context=context;
        canvasWidth=getResources().getDisplayMetrics().widthPixels;
        canvasHeight=getResources().getDisplayMetrics().heightPixels;
        matrix=new Matrix();
        backGround = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.background);
        wait = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.wait);
        mediaPlayerTouch=MediaPlayer.create(context, R.raw.touch);
        fadeOutpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        getHolder().addCallback(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //TODO Auto-generated method stub
        this.canvas=canvas;

        drawBackGround(canvas);
        drawAnimation(canvas);
        if(Constant.HEADER==1)drawText(canvas,"SCENE NO : "+sceneNumber, canvasWidth/2,100,20);



        paintBtn = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBtn.setColor(Color.RED);

    }

    private void drawBackGround(Canvas canvas) {
        Rect rectBackGround=new Rect(0,0,backGround.getWidth(), backGround.getHeight());
        RectF rectBackGroundF=new RectF(0,0,canvasWidth, canvasHeight);
        canvas.drawBitmap(backGround,rectBackGround,rectBackGroundF,null);

    }


    private void drawAnimation(Canvas canvas) {
        switch(sceneNumber){
            case 0:
                drawImageWithRotation(canvas,matrix,wait);
                loadImages();
                break;
            case 1:
                Paint paintRect = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintRect.setColor(Color.WHITE);
                wrongF=new RectF(canvasWidth/2-handRight.getHeight(),canvasHeight/2-handWrong.getHeight()/3,canvasWidth/2,canvasHeight/2+handWrong.getHeight()/3);
                rightF=new RectF(canvasWidth/2+(int)(20* GlobalVariables.xScale_factor),canvasHeight/2-handRight.getHeight()/2-(int)(40*GlobalVariables.yScale_factor),canvasWidth/2+handRight.getHeight()+(int)(20*GlobalVariables.xScale_factor),canvasHeight/2+handRight.getHeight()/2-(int)(40*GlobalVariables.yScale_factor));

                drawWrongHand(canvas,null);
                drawRightHand(canvas,null);
                drawAllSpriteRandomly(canvas);
                drawWrongHandCover(canvas,null);
//			     canvas.drawRect(wrongF,paintRect);
//			     canvas.drawRect(rightF,paintRect);
                if(music&&sceneTimeController%10==0)playMusic();

                break;
            case 2:   // right answer

                drawWrongHand(canvas,null);
                drawRightHand(canvas,null);
                drawAllSpriteRandomly(canvas);
                drawWrongHandCover(canvas,null);
                drawImage(canvas,wrong,canvasWidth/2-wrong.getWidth(),canvasHeight-wrong.getHeight()*4/3);
                drawImage(canvas,right,canvasWidth/2+right.getWidth(),canvasHeight-right.getHeight()*4/3);
                if(sceneTimeController%40==0)sceneNumber=5;

                break;
            case 3:    // wrong answer

                drawWrongHand(canvas,null);
                drawRightHand(canvas,null);
                drawAllSpriteRandomly(canvas);
                drawWrongHandCover(canvas,null);
//			     drawImage(canvas,wrong,canvasWidth/2-wrong.getWidth(),canvasHeight-wrong.getHeight()*4/3);
                drawImage(canvas,right,canvasWidth/2+right.getWidth(),canvasHeight-right.getHeight()*4/3);
                if(sceneTimeController%40==0)sceneNumber=4;
                break;
            case 4:
//
//			 drawWrongHand(canvas,null);
//		     drawRightHand(canvas,null);
//		     drawAllSpriteRandomly(canvas);
//		     drawWrongHandCover(canvas,null);
                drawImage(canvas,imageMid,canvasWidth/2,(int)(GlobalVariables.yScale_factor*350));
                playMusic();
                break;
            case 5:
//			 drawWrongHand(canvas,null);
//		     drawRightHand(canvas,null);
//		     drawAllSpriteRandomly(canvas);
//		     drawWrongHandCover(canvas,null);
                drawImage(canvas,imageMid,canvasWidth/2,(int)(GlobalVariables.yScale_factor*350));
                playMusic();
                break;
            case 6:
                drawImage(canvas,imageMid,canvasWidth/2,(int)(GlobalVariables.yScale_factor*350));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myConstant.drawButtonNext(canvas);
                myConstant.drawButtonReplay(canvas);
//				TF=false;
//				gameThread=null;
//				getHandler().removeCallbacks(this);
//				((Activity)context).setResult(Activity.RESULT_OK);
//				((Activity)context).finish();
//				clearAll();
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;

            default:
        }
    }


    private void playMusic() {
        if(mediaPlayer==null){
            timerControllerMediaPlayer=false;
            timerForMediaPlayer=0;
            switch(sceneNumber){
                case 1:
                    whatToPlay=R.raw.game3_1;
                    break;
                case 2:
                    stopPlayingMusic();
                    break;
                case 3:
                    stopPlayingMusic();
                    break;
                case 4:
                    whatToPlay=R.raw.game3_2_1;
                    break;
                case 5:
                    whatToPlay=R.raw.game3_2_1;
                    break;
                case 6:
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
                    timerForMediaPlayer=0;
                    switch (sceneNumber) {
                        case 0:
                            break;
                        case 1:
                            sceneOK=1;
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                        case 5:
                            sceneNumber=6;
                            break;
                        default:
                            break;
                    }
                }
            });


        if(timerControllerMediaPlayer)
//				   stopPlayingMusic();
            timerForMediaPlayer++;

        if(timerForMediaPlayer==8){     // wait time for second time playing
            timerControllerMediaPlayer=false;
            timerForMediaPlayer=0;
            stopPlayingMusic();
        }

    }

    private void drawAllSpriteRandomly(Canvas canvas){
        if(sprite1Index==sprite1Obj.getNoOfImagesInSprite())sprite1Index=0;
        else sprite1Index++;
        if(sprite2Index==sprite2Obj.getNoOfImagesInSprite())sprite2Index=0;
        else sprite2Index++;
        if(sprite3Index==sprite3Obj.getNoOfImagesInSprite())sprite3Index=0;
        else sprite3Index++;
        if(sprite4Index==sprite4Obj.getNoOfImagesInSprite())sprite4Index=0;
        else sprite4Index++;
        if(sprite5Index==sprite5Obj.getNoOfImagesInSprite())sprite5Index=0;
        else sprite5Index++;
        if(sprite6Index==sprite6Obj.getNoOfImagesInSprite())sprite6Index=0;
        else sprite6Index++;



        int x[]={423,475,495,515,538,552};
        int y[]={370,395,400,375,380,380};



        Rect sprite1Rect=new Rect(sprite1Index*sprite1.getWidth()/sprite1Obj.getNoOfImagesInSprite(),sprite1.getHeight(),sprite1.getWidth()/sprite1Obj.getNoOfImagesInSprite(),sprite1.getHeight());
        Rect sprite2Rect=new Rect(sprite2Index*sprite2.getWidth()/sprite2Obj.getNoOfImagesInSprite(),sprite2.getHeight(),sprite2.getWidth()/sprite2Obj.getNoOfImagesInSprite(),sprite2.getHeight());
        Rect sprite3Rect=new Rect(sprite3Index*sprite3.getWidth()/sprite3Obj.getNoOfImagesInSprite(),sprite3.getHeight(),sprite3.getWidth()/sprite3Obj.getNoOfImagesInSprite(),sprite3.getHeight());
        Rect sprite4Rect=new Rect(sprite4Index*sprite4.getWidth()/sprite4Obj.getNoOfImagesInSprite(),sprite4.getHeight(),sprite4.getWidth()/sprite4Obj.getNoOfImagesInSprite(),sprite4.getHeight());
        Rect sprite5Rect=new Rect(sprite5Index*sprite5.getWidth()/sprite5Obj.getNoOfImagesInSprite(),sprite5.getHeight(),sprite5.getWidth()/sprite5Obj.getNoOfImagesInSprite(),sprite5.getHeight());
        Rect sprite6Rect=new Rect(sprite6Index*sprite6.getWidth()/sprite6Obj.getNoOfImagesInSprite(),sprite6.getHeight(),sprite6.getWidth()/sprite6Obj.getNoOfImagesInSprite(),sprite6.getHeight());

        RectF sprite1RectF=new RectF((int)(GlobalVariables.xScale_factor*x[0]),(int)(GlobalVariables.yScale_factor*y[0]),sprite1.getWidth()/sprite1Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[0])),sprite1.getHeight()+((int)(GlobalVariables.yScale_factor*y[0])));
        RectF sprite2RectF=new RectF((int)(GlobalVariables.xScale_factor*x[1]),(int)(GlobalVariables.yScale_factor*y[1]),sprite2.getWidth()/sprite2Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[1])),sprite2.getHeight()+((int)(GlobalVariables.yScale_factor*y[1])));
        RectF sprite3RectF=new RectF((int)(GlobalVariables.xScale_factor*x[2]),(int)(GlobalVariables.yScale_factor*y[2]),sprite3.getWidth()/sprite3Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[2])),sprite3.getHeight()+((int)(GlobalVariables.yScale_factor*y[2])));
        RectF sprite4RectF=new RectF((int)(GlobalVariables.xScale_factor*x[3]),(int)(GlobalVariables.yScale_factor*y[3]),sprite4.getWidth()/sprite4Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[3])),sprite4.getHeight()+((int)(GlobalVariables.yScale_factor*y[3])));
        RectF sprite5RectF=new RectF((int)(GlobalVariables.xScale_factor*x[4]),(int)(GlobalVariables.yScale_factor*y[4]),sprite5.getWidth()/sprite5Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[4])),sprite5.getHeight()+((int)(GlobalVariables.yScale_factor*y[4])));
        RectF sprite6RectF=new RectF((int)(GlobalVariables.xScale_factor*x[5]),(int)(GlobalVariables.yScale_factor*y[5]),sprite6.getWidth()/sprite6Obj.getNoOfImagesInSprite()+((int)(GlobalVariables.xScale_factor*x[5])),sprite6.getHeight()+((int)(GlobalVariables.yScale_factor*y[5])));

//        int xScale=(int)(GlobalVariables.xScale_factor);
//        int yScale=(int)(GlobalVariables.yScale_factor);

//        RectF sprite1RectF=new RectF(x[0],y[0],sprite1.getWidth()/sprite1Obj.getNoOfImagesInSprite()+x[0],sprite1.getHeight()+y[0]);
//        RectF sprite2RectF=new RectF(x[1],y[1],sprite2.getWidth()/sprite2Obj.getNoOfImagesInSprite()+x[1],sprite2.getHeight()+y[1]);
//        RectF sprite3RectF=new RectF(x[2],y[2],sprite3.getWidth()/sprite3Obj.getNoOfImagesInSprite()+x[2],sprite3.getHeight()+y[2]);
//        RectF sprite4RectF=new RectF(x[3],y[3],sprite4.getWidth()/sprite4Obj.getNoOfImagesInSprite()+x[3],sprite4.getHeight()+y[3]);
//        RectF sprite5RectF=new RectF(x[4],y[4],sprite5.getWidth()/sprite5Obj.getNoOfImagesInSprite()+x[4],sprite5.getHeight()+y[4]);
//        RectF sprite6RectF=new RectF(x[5],y[5],sprite6.getWidth()/sprite6Obj.getNoOfImagesInSprite()+x[5],sprite6.getHeight()+y[5]);

        sprite1Obj.drawSpriteByRectF(canvas, sprite1RectF, sprite1Index,null);
        sprite2Obj.drawSpriteByRectF(canvas, sprite2RectF, sprite2Index,null);
        sprite3Obj.drawSpriteByRectF(canvas, sprite3RectF, sprite3Index,null);
        sprite4Obj.drawSpriteByRectF(canvas, sprite4RectF, sprite4Index,null);
        sprite5Obj.drawSpriteByRectF(canvas, sprite5RectF, sprite5Index,null);
        sprite6Obj.drawSpriteByRectF(canvas, sprite6RectF, sprite6Index,null);


    }

//    private void drawImage(Canvas canvas,Bitmap image,int xMidPosition,int yMidPosition) {
//    	 Rect midImageS=new Rect(0,0,image.getWidth(),image.getHeight());
//		 RectF midImageF=new RectF(xMidPosition-image.getWidth()/2,yMidPosition-image.getHeight()/2,xMidPosition+image.getWidth()/2,yMidPosition+image.getHeight()/2);
//		 canvas.drawBitmap(image,midImageS,midImageF,paint);
//
//	}
//


    private void drawButtonTryAgain(Canvas canvas,Paint paint) {
        Rect tryAgainS=new Rect(0,0,tryAgain.getWidth(),tryAgain.getHeight());
        tryAgainF=new RectF(canvasWidth/2-tryAgain.getWidth()/2,canvasHeight/2-tryAgain.getHeight()/2,canvasWidth/2+tryAgain.getWidth()/2,canvasHeight/2+tryAgain.getHeight()/2);
        canvas.drawBitmap(tryAgain,tryAgainS,tryAgainF,paint);
    }

    private void drawButtonNext(Canvas canvas,Paint paint) {
        Rect tryAgainS=new Rect(0,0,ageBadhe.getWidth(),ageBadhe.getHeight());
        ageBadheF=new RectF(canvasWidth/2-ageBadhe.getWidth()/2,canvasHeight/2-ageBadhe.getHeight()/2,canvasWidth/2+ageBadhe.getWidth()/2,canvasHeight/2+ageBadhe.getHeight()/2);
        canvas.drawBitmap(ageBadhe,tryAgainS,ageBadheF,paint);
    }

    private void drawImage(Canvas canvas2,Bitmap image,int xMidPosition,int yMidPosition){
        Rect buttonImageS=new Rect(0,0,image.getWidth(),image.getHeight());
        RectF buttonImageF=new RectF(xMidPosition-image.getWidth()/2,yMidPosition-image.getHeight()/2,xMidPosition+image.getWidth()/2,yMidPosition+image.getHeight()/2);
        canvas.drawBitmap(image,buttonImageS,buttonImageF,null);

    }

    private void drawRightHand(Canvas canvas,Paint paint) {
        Rect rightHandS=new Rect(0,0,handRight.getWidth(),handRight.getHeight());
        RectF rightHandF=new RectF(canvasWidth-handRight.getWidth(),canvasHeight/2-handRight.getHeight()/2-(int)(40*GlobalVariables.yScale_factor),canvasWidth,canvasHeight/2+handRight.getHeight()/2-(int)(40*GlobalVariables.yScale_factor));
//		if(sceneNumber==3||sceneNumber==7) canvas.drawBitmap(handRightGlow,rightHandS,rightHandF,paint);
//		else
        canvas.drawBitmap(handRight,rightHandS,rightHandF,paint);
    }
    private void drawWrongHand(Canvas canvas,Paint paint) {
        Rect wrongHandS=new Rect(0,0,handWrong.getWidth(),handWrong.getHeight());
        RectF wrongHandF=new RectF(0,canvasHeight/2-handWrong.getHeight()/2,handWrong.getWidth(),canvasHeight/2+handWrong.getHeight()/2);
        canvas.drawBitmap(handWrong,wrongHandS,wrongHandF,paint);
//	    canvas.drawBitmap(spriteCover,wrongHandS,wrongHandF,paint);
    }

    private void drawWrongHandCover(Canvas canvas,Paint paint) {
        Rect wrongHandS=new Rect(0,0,spriteCover.getWidth(),spriteCover.getHeight());
        RectF wrongHandF=new RectF((int)(347*GlobalVariables.xScale_factor),(int)(485*GlobalVariables.yScale_factor),(int)(347*GlobalVariables.xScale_factor)+spriteCover.getWidth(),(int)(485*GlobalVariables.yScale_factor)+spriteCover.getHeight());
        canvas.drawBitmap(spriteCover,wrongHandS,wrongHandF,paint);
    }

    private void drawText(Canvas canvas,String text,int xPosition,int yPosition,int size){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(size);
        Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
        paint.setTypeface(tf);
        paint.setTextAlign(Align.CENTER);
        canvas.drawText(text,xPosition,yPosition, paint);
    }



    private Paint fadeOut(){
        if(changeAlpha<toAlpha){
            changeAlpha+=5;
            fadeOutpaint.setAlpha(changeAlpha);
        }
        else fadeOutpaint.setAlpha(toAlpha);

        return fadeOutpaint;
    }
    private Paint fadeIn(){
        if(changeAlpha>fromAlpha){
            changeAlpha-=5;
            fadeOutpaint.setAlpha(changeAlpha);
        }
        else fadeOutpaint.setAlpha(fromAlpha);

        return fadeOutpaint;
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);

        Log.w("XX",""+event.getX());
        Log.w("YY",""+event.getY());

        switch(event.getAction()& MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                switch(sceneNumber){
                    case 0:


                        break;
                    case 1:

                        if (rightF!=null&rightF.intersect(touchrecF)&&sceneOK==1){
                            mediaPlayerTouch.start();

                            if(sceneOK==1){
                                stopPlayingMusic();
                                music=false;
                                mediaPlayerRighrWrongSound=MediaPlayer.create(context, R.raw.right);
                                mediaPlayerRighrWrongSound.start();
                                stopPlayingMusic();
                                sceneNumber=3;
                                sceneTimeController=1;
                            }
                        }
                        if (wrongF.intersect(touchrecF)&&sceneOK==1){
                            stopPlayingMusic();
                            music=false;
                            mediaPlayerTouch.start();
                            if(sceneOK==1){
                                mediaPlayerRighrWrongSound=MediaPlayer.create(context, R.raw.wrong);
                                mediaPlayerRighrWrongSound.start();
                                sceneNumber=2;
                                sceneTimeController=1;
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
                    case 7:
                        break;
                    case 8:

                        break;
                    case 9:
                        break;
                    case 10:
                        break;

                    default:
                }
                break;

            default:
        }
        return true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //TODO Auto-generated method stub
        TF=true;
        gameThread = new GameThread(getHolder(), this);
        gameThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        TF=false;
        gameThread=null;
        stopPlayingMusic();
    }


    @SuppressLint("WrongCall")
    class GameThread extends Thread{
        SurfaceHolder _suHolder;
        Game3Canvas _myMycanvas;

        public GameThread(SurfaceHolder surfaceHolder,Game3Canvas mycanvas) {
            // TODO Auto-generated constructor stub
            _suHolder = surfaceHolder;
            _myMycanvas = mycanvas;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
//			super.run();
            Canvas canvas;
//			ShahSprite _sprite=new ShahSprite(_myMycanvas,sprite);
            while (TF) {
                canvas =null;
                try {

                    canvas =_suHolder.lockCanvas(null);
                    synchronized (_suHolder) {
                        if(TF){
                            _myMycanvas.onDraw(canvas);
//						_sprite.onDraw(canvas);
                        }
                        //invalidate();
                    }
                    try {
                        Thread.sleep(sleepTime);
                        sceneTimeController++;
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } finally{
                    // TODO: handle exception
                    if(canvas!=null)
                        _suHolder.unlockCanvasAndPost(canvas);
                }

            }


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
        sceneTimeController=0;
    }

    Matrix matrix;
    Thread localThread;
    boolean initialiseThreadLoad=true;
    float rotationAngle=0;
    Bitmap faltu1,faltu12,faltu13;
    private void drawImageWithRotation(Canvas canvas,Matrix matrix,Bitmap image){

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
    private void initialiseImages(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        handRight = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_hand02);
        handWrong = Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_hand01);
        right=Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.game3_right_tick);
        wrong=Constant.decodeSampledBitmapFromResource(context.getResources(),R.drawable.game3_wrong_tick);
        sprite1= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite1);
        sprite2=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite2);
        sprite3=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite3);
        sprite4=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite4);
        sprite5=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite5);
        sprite6=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_sprite6);
        imageMid=Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_big_hand);
        ageBadhe= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.gonext);
        spriteCover= Constant.decodeSampledBitmapFromResource(getResources(),R.drawable.game3_spritecover);

        sprite1Obj=new Sprite(sprite1,19);//18 by faiyaz
        sprite2Obj=new Sprite(sprite2,19);//18 by faiyaz
        sprite3Obj=new Sprite(sprite3,14);
        sprite4Obj=new Sprite(sprite4,19);
        sprite5Obj=new Sprite(sprite5,14);
        sprite6Obj=new Sprite(sprite6,16);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        sceneNumber=1;
        sceneTimeController=1;
    }


    private void clearAll() {
        handRight.recycle();
        handWrong.recycle();
        right.recycle();
        wrong.recycle();
        sprite1.recycle();
        sprite2.recycle();
        sprite3.recycle();
        sprite4.recycle();
        sprite5.recycle();
        sprite6.recycle();
        imageMid.recycle();
        ageBadhe.recycle();
        spriteCover.recycle();
        myConstant=null;

    }

}
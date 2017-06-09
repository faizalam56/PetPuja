package com.zmq.game1;

import java.util.Hashtable;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.abdullah.activities.Game1;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.zmq.sprite.FadeAnimation;
import com.zmq.sprite.ShahSprite;
import com.zmq.utility.GlobalVariables;

   
public class Scene1 extends SurfaceView implements SurfaceHolder.Callback ,OnCompletionListener{

	Context context;
	public SurfaceHolder surfaceHolder;
	int scene=1;
	public Screen1GameThread thread;
		
	private ShahSprite bg;
	private ShahSprite bowlblank_big,bowlblankbigroll,bowlghee,hand,thumb;
	private FadeAnimation meshing_sprite,finalframe,dummy_bg;
	int animCounter;
	boolean start_smash_anim;
	boolean startDummyFading=true;
	boolean connectSmashingFlag=true; 

	public Hashtable<Integer, ShahSprite> images;
	
	Hashtable<Integer, Integer> zIndex=new Hashtable(7){{
		put(7,R.id.ToggleButton005);//egg
		put(6,R.id.ToggleButton004);//potato
		put(5,R.id.ToggleButton003);//mix-veg
		put(4,R.id.ToggleButton007);//rice
		put(3,R.id.ToggleButton006);//roti
		put(2,R.id.ToggleButton002);//dal
		put(1,R.id.toggleButton001);//sag	
		}}; 
	
//	private boolean blank_thali_touchFlag,ghee_bottle_touchFlag;
	private ShahSprite yes,no;
	protected boolean yes_noFlag;
	private long bottle_sound_delay=2000;
	private long kya_bache_ko_aise_hi_khiladen_delay=1000;
	private long answer_delay=3000;
//	private MediaPlayer mp;
	private MediaPlayer game01_vo03,game01_vo04_wa,game01_vo04_ca,last_mp;
//	private MediaPlayer game01_vo04_ca_a,//
//						game01_vo04_wa_a;
	boolean last_vo_flag;
	boolean is_last_vo_played;
	boolean surface_flag=true;
	boolean is_ans_played;
	boolean answere;//true-right  false-wrong ans
	private long next_module_delay=500;
	public boolean gheeFlag;
	private Constant myConstant;
	boolean display_replay_Next;
	public Scene1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub		
		init(context);
	}

	public Scene1(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
//		this.context=context;
		init(context);
	}

	public Scene1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
//		this.context=context;
		init(context);
	}
	

	private void init(Context context){
		this.context=context;
		myConstant=new Constant();
		if(SharedInfo.images.images!=null){
			bg=SharedInfo.images.bg;
			dummy_bg=SharedInfo.images.dummy_bg;
			bowlblank_big=SharedInfo.images.bowlblank_big;
			bowlblankbigroll=SharedInfo.images.bowlblankbigroll;
			bowlghee=SharedInfo.images.bowlghee;

					meshing_sprite=SharedInfo.images.meshing_sprite;
					hand=SharedInfo.images.hand;
					thumb=SharedInfo.images.thumb;
					finalframe=SharedInfo.images.finalframe;

			images=SharedInfo.images.images;

			no=SharedInfo.images.no;

			yes=SharedInfo.images.yes;
			//****************************************************
		}
//       else
//          {
//			bg=new ShahSprite(Utility.createImage(R.drawable.game1_background));
//
////			ShahSprite temp_dummy_bg_sprite=new ShahSprite(Utility.createImage(R.drawable.bg));
//			dummy_bg=new FadeAnimation(bg, 1000l, true);
//
//			bowlblank_big=new ShahSprite(Utility.createImage(R.drawable.game1_bowlblank_big));
//			bowlblank_big.setPosition(GlobalVariables.width/2-bowlblank_big.getDstRectWidth()/2, GlobalVariables.height/2-bowlblank_big.getDstRectHeight()/2);
//
//			bowlblankbigroll=new ShahSprite(Utility.createImage(R.drawable.game1_bowlblankbigroll));
//			bowlblankbigroll.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
//
//			bowlghee=new ShahSprite(Utility.createImage(R.drawable.game1_bowlgheebig));
//			bowlghee.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
//
//					Bitmap meshing_spriteImage=Utility.createImage(R.drawable.meshing_sprite);
//					ShahSprite temp_meshing_sprite=new ShahSprite(meshing_spriteImage, meshing_spriteImage.getWidth()/6, meshing_spriteImage.getHeight()/2);
//					meshing_sprite=new FadeAnimation(temp_meshing_sprite, 1000l, false);
//					meshing_sprite.sprite.setPosition(GlobalVariables.width/2-meshing_sprite.sprite.getWidth()/2, 0);
//
//					hand=new ShahSprite(Utility.createImage(R.drawable.game1_hand));
//					hand.setPosition(meshing_sprite.sprite.getX(), meshing_sprite.sprite.getY());//position of smash ShahSprite
//
//					thumb=new ShahSprite(Utility.createImage(R.drawable.game1_thumb));
//					thumb.setPosition(meshing_sprite.sprite.getX(), meshing_sprite.sprite.getY());//position of smash ShahSprite
//
//					ShahSprite temp_finalframe=new ShahSprite(Utility.createImage(R.drawable.game1_finalframe));
//					finalframe=new FadeAnimation(temp_finalframe, 1000l, true);
//					finalframe.sprite.setPosition(GlobalVariables.width/2-finalframe.sprite.getWidth()/2, 0);
//			images=new Hashtable();
//			for (int i = 0; i < Game1.zOrder.length; i++) {
//				ShahSprite  bmpIcon=null;
//				int temp=zIndex.get(Game1.zOrder[i]);
//				switch (temp) {
//				case R.id.toggleButton001://sag
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowsagbig07));
//					break;
//				case  R.id.ToggleButton002://dal
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowdalbig06));
//					break;
//				case  R.id.ToggleButton003://mix veg
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowmixvegbig03));;
//					break;
//				case  R.id.ToggleButton004://potato
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowpotatobig02));;
//					break;
//				case  R.id.ToggleButton005://egg
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowleggbig01));;
//					break;
//				case  R.id.ToggleButton006://roti
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowrotibig05));;
//					break;
//				case  R.id.ToggleButton007://rice
//					bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowricebig04));;
//					break;
//				default:
//					break;
//				}
//				bmpIcon.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
//				images.put(temp, bmpIcon);
//			}
//
//			Bitmap no_sprite_image=Utility.createImage(R.drawable.no);
//			no=new ShahSprite(no_sprite_image,no_sprite_image.getWidth()/2,no_sprite_image.getHeight());
//			no.setPosition(GlobalVariables.width/16,  5*GlobalVariables.height/8);
//
//			Bitmap yes_sprite_image=Utility.createImage(R.drawable.yes);
//			yes=new ShahSprite(yes_sprite_image,yes_sprite_image.getWidth()/2,yes_sprite_image.getHeight());
//			yes.setPosition(15*GlobalVariables.width/16-yes.getDstRectWidth(), 5*GlobalVariables.height/8);
//
//			//****************************************************
//		}
		
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		
//        thread .start();
		//****************************************************
	}
	
	public void update(Canvas g){
		
	}
	
	public void drawSomething(Canvas g) {
        if(!bg.sourceImage.isRecycled()){
		    bg.paint(g, null);
        }
		switch (scene) {
		case 1:
			if(!SharedInfo.scene2Recycle)
			scene1(g);
			break;
		case 2:
			if(!SharedInfo.scene2Recycle)
			scene2(g);
			break;
		default:
			break;
		}
	}
	
	private void scene1(Canvas g){
        if(!bowlblank_big.sourceImage.isRecycled())
		bowlblank_big.paint(g, null);

		for (int i = 0; i < Game1.zOrder.length; i++) {
			ShahSprite temp = images.get(zIndex.get(Game1.zOrder[i]));
            if(!temp.sourceImage.isRecycled())
			temp.paint(g, null);
		}
		if(gheeFlag) {
            if(!bowlghee.sourceImage.isRecycled())
            bowlghee.paint(g, null);
        }
        if(!bowlblankbigroll.sourceImage.isRecycled())
		bowlblankbigroll.paint(g, null);
		// yes no sprite paint
        if(!yes.sourceImage.isRecycled())
		yes.paint(g, null);
        if(!no.sourceImage.isRecycled())
		no.paint(g, null);

	}
	
	private void scene2(Canvas g){
		if(connectSmashingFlag){
            if(!bowlblank_big.sourceImage.isRecycled())
			bowlblank_big.paint(g, null);
            if(!hand.sourceImage.isRecycled())
			hand.paint(g, null);
			for (int i = 0; i < Game1.zOrder.length; i++) {
				ShahSprite temp = images.get(zIndex.get(Game1.zOrder[i]));
                if(!temp.sourceImage.isRecycled())
				temp.paint(g, null);
			}			
			if(gheeFlag){
                if(!bowlghee.sourceImage.isRecycled())
			bowlghee.paint(g, null);
            }
            if(!thumb.sourceImage.isRecycled())
			thumb.paint(g, null);
            if(!bowlblankbigroll.sourceImage.isRecycled())
			bowlblankbigroll.paint(g, null);
			
			if(startDummyFading&&++animCounter%10==0){
				meshing_sprite.setFadein(true);// set true for fadein
				meshing_sprite.start();
				dummy_bg.start();
				startDummyFading=false;				
			}
			if(dummy_bg.mCharacterPaint.getAlpha()==255){
				connectSmashingFlag=false;
				start_smash_anim=true;
				meshing_sprite.setFadein(false);
			}
		}
        if(!dummy_bg.sprite.sourceImage.isRecycled()){
		dummy_bg.update();
		dummy_bg.sprite.paint(g, dummy_bg.mCharacterPaint);
        }
		//old code
		if(start_smash_anim){
			if(animCounter++%4==0){
				meshing_sprite.sprite.nextFrame();
			}
			if(meshing_sprite.sprite.getFrame()==11){
				meshing_sprite.start();
				finalframe.start();
				start_smash_anim=false;
			}
		}
		if(!meshing_sprite.sprite.sourceImage.isRecycled()){
		meshing_sprite.update();
		meshing_sprite.sprite.paint(g, meshing_sprite.mCharacterPaint);
		}
		
		if(!finalframe.sprite.sourceImage.isRecycled()){
		finalframe.update();
		finalframe.sprite.paint(g, finalframe.mCharacterPaint);
		}
		if(display_replay_Next){
			myConstant.drawButtonNext(g);
			myConstant.drawButtonReplay(g);
		}
	}
		
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		System.out.println("surfaceCreated");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		System.out.println("surfaceChanged");
		surface_flag=true;
		Canvas canvas = holder.lockCanvas(null);
        drawSomething(canvas);
        holder.unlockCanvasAndPost(canvas);
        thread=new Screen1GameThread(surfaceHolder, this);
		thread.setRunning(true);
        thread.start();
        switch (scene) {
		case 1:	
				game01_vo03 = MediaPlayer.create(getContext(),R.raw.game01_vo03);//kya bache ko aise hi khilade
				Handler tempMyHandler = new Handler();
				tempMyHandler.postDelayed(new Runnable() {					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(game01_vo03!=null)
						game01_vo03.start();				
					}
				}, kya_bache_ko_aise_hi_khiladen_delay);
				game01_vo03.setOnCompletionListener(this);
			
			break;
		case 2:
			if(!is_ans_played){
				if(answere){//sahi jawab audio
					game01_vo04_ca=MediaPlayer.create(getContext(), R.raw.game01_vo04_ca);
					if(game01_vo04_ca!=null){
						game01_vo04_ca.setOnCompletionListener(this);										
					}
					Handler tempHandler=new Handler();
					tempHandler.postDelayed(new Runnable() {				
						@Override
						public void run() {
							// TODO Auto-generated method stub							
							scene=2;
							meshing_sprite.sprite.setFrame(0);// set smash sprite frame=first
							if(game01_vo04_ca!=null)
							game01_vo04_ca.start();	
//							start_smash_anim=true;
						}
					}, answer_delay);
				}else{//galat jawab
					game01_vo04_wa=MediaPlayer.create(getContext(), R.raw.game01_vo04_wa);
					if(game01_vo04_wa!=null){
						game01_vo04_wa.setOnCompletionListener(this);//listner										
					}
					Handler tempHandler=new Handler();
					tempHandler.postDelayed(new Runnable() {			
						@Override
						public void run() {
							// TODO Auto-generated method stub
							scene=2;
							meshing_sprite.sprite.setFrame(0);// set smash sprite frame=first
//							start_smash_anim=true;
							if(game01_vo04_wa!=null)
							game01_vo04_wa.start();												
						}
					}, answer_delay);
				}
			}
			if(is_ans_played && last_vo_flag && !is_last_vo_played){
				last_mp=MediaPlayer.create(getContext(), R.raw.game01_vo05);
				if(last_mp!=null){
					last_mp.setOnCompletionListener(this);
					last_mp.start();
				}
			}
			break;
		default:
			break;
		}
        
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		System.out.println("surfaceDestroyed");
		surface_flag=false;
		thread.running=false;
		thread=null;

		//stop sound					
		switch (scene) {
		case 1:
			if (game01_vo03 != null) {
				if (game01_vo03.isPlaying())
					game01_vo03.stop();
				game01_vo03.release();
				game01_vo03 = null;			
			}
			break;
		case 2:
			if (game01_vo04_ca != null) {
				if (game01_vo04_ca.isPlaying())
					game01_vo04_ca.stop();
				game01_vo04_ca.release();
				game01_vo04_ca=null;
				start_smash_anim=false;
			}
			if (game01_vo04_wa != null) {
				if (game01_vo04_wa.isPlaying())
					game01_vo04_wa.stop();
				game01_vo04_wa.release();
				game01_vo04_wa=null;
				start_smash_anim=false;
			}
			if (last_mp != null) {
				if (last_mp.isPlaying())
					last_mp.stop();
				last_mp.release();
				last_mp=null;
			}
			break;
		}
//		surface_flag=false;
	}

//	public Scene1(Context context, AttributeSet attrs, int defStyleAttr,
//			int defStyleRes) {
//		super(context, attrs, defStyleAttr, defStyleRes);
//		// TODO Auto-generated constructor stub
//	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x=(int)event.getX();
		int y=(int)event.getY();
		RectF touchrecF = new RectF(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
		switch (scene) {
		case 1:
//			if(blank_thali_touchFlag&&(x > blank_thali.getX() && x < (blank_thali.getX() + blank_thali.getDstRectWidth())) && (y > blank_thali.getY() && y < (blank_thali.getY() + blank_thali.getDstRectHeight()))) {
//				blank_thali.setVisible(false);
//				blank_thali_touchFlag=false;
//				bowl.nextFrame();
//				final MediaPlayer temp_mp = MediaPlayer.create(getContext(),R.raw.game2_10);
//				Handler tempMyHandler = new Handler();
//				tempMyHandler.postDelayed(new Runnable() {					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						temp_mp.start();
//					}
//				}, bottle_sound_delay);
//				temp_mp.setOnCompletionListener(new OnCompletionListener() {					
//					@Override
//					public void onCompletion(MediaPlayer mp) {
//						// TODO Auto-generated method stub
//						ghee_bottle_touchFlag=true;
//						mp.stop();
//						mp.release();
//					}
//				});
//			}
//			if(ghee_bottle_touchFlag&&(x > ghee_bottle.getX() && x < (ghee_bottle.getX() + ghee_bottle.getDstRectWidth())) && (y > ghee_bottle.getY() && y < (ghee_bottle.getY() + ghee_bottle.getDstRectHeight()))) {
//				ghee_bottle_touchFlag=false;
//				bowl.nextFrame();
//				kya_bache_ko_aise_hi_khiladen = MediaPlayer.create(getContext(),R.raw.game2_2);//kya bache ko aise hi khilade
//				Handler tempMyHandler = new Handler();
//				tempMyHandler.postDelayed(new Runnable() {					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						kya_bache_ko_aise_hi_khiladen.start();
//						yes_noFlag=true;
//					}
//				}, kya_bache_ko_aise_hi_khiladen_delay);
//				kya_bache_ko_aise_hi_khiladen.setOnCompletionListener(this);
//			}
			if(yes_noFlag&&(x > yes.getX() && x < (yes.getX() + yes.getDstRectWidth())) && (y > yes.getY() && y < (yes.getY() + yes.getDstRectHeight()))) {
				if(game01_vo03.isPlaying())
				game01_vo03.stop();
				game01_vo03.release();
				game01_vo03=null;
				
				//************************* prompt wrong sound *********************************//
//				MediaPlayer temp_wrong=MediaPlayer.create(getContext(), R.raw.wrong);//wrong answere
//				temp_wrong.start();
				//************************* prompt wrong sound *********************************//
				
//				MediaPlayer temp_game01_vo04_ca_a=MediaPlayer.create(getContext(), R.raw.game01_vo04_wa_a);//wrong answere
				MediaPlayer temp_game01_vo04_ca_a=MediaPlayer.create(getContext(), R.raw.wrong_merge02);//wrong answere
				temp_game01_vo04_ca_a.start();
//				yes.setVisible(false);
				//set next frame with glow				
				yes.nextFrame();
				no.nextFrame();
				answere=false;
				yes_noFlag=false;					
				game01_vo04_wa=MediaPlayer.create(getContext(), R.raw.game01_vo04_wa_b);// wrong answere
				System.out.println("time="+game01_vo04_wa.getDuration());
				if(game01_vo04_wa!=null){
					game01_vo04_wa.setOnCompletionListener(this);										
				}
				Handler tempHandler=new Handler();
				tempHandler.postDelayed(new Runnable() {				
					@Override
					public void run() {
						// TODO Auto-generated method stub
						resetPosition();// set potion for 3rd Scene
						scene=2;
//						start_smash_anim=true;
						game01_vo04_wa.start();						
					}
				}, answer_delay);			
				//************ play click ************************//
				SharedInfo.playClickSound(getContext(), R.raw.touch);
				//************************************//
			}
			if(yes_noFlag&&(x > no.getX() && x < (no.getX() + no.getDstRectWidth())) && (y > no.getY() && y < (no.getY() + no.getDstRectHeight()))) {
				if(game01_vo03.isPlaying())
				game01_vo03.stop();
				game01_vo03.release();
				game01_vo03=null;
				
				//************************* prompt right sound *********************************//
//				MediaPlayer temp_right=MediaPlayer.create(getContext(), R.raw.right);//right answere
//				temp_right.start();
				//************************* prompt right sound *********************************//
				
				
//				MediaPlayer game01_vo04_ca_a=MediaPlayer.create(getContext(), R.raw.game01_vo04_ca_a);// correct answere
				MediaPlayer game01_vo04_ca_a=MediaPlayer.create(getContext(), R.raw.right_merge02);// correct answere
				game01_vo04_ca_a.start();				
//				no.setVisible(false);
				//set next frame with glow
				no.nextFrame();
				answere=true;
				yes_noFlag=false;				
				game01_vo04_ca=MediaPlayer.create(getContext(), R.raw.game01_vo04_ca_b);
				if(game01_vo04_ca!=null){
					game01_vo04_ca.setOnCompletionListener(this);										
				}
				Handler tempHandler=new Handler();
				tempHandler.postDelayed(new Runnable() {			
					@Override
					public void run() {
						// TODO Auto-generated method stub	
						resetPosition();// set potion for 3rd Scene
						scene=2;
//						start_smash_anim=true;
						game01_vo04_ca.start();												
					}
				}, answer_delay);	
				//************ play click ************************//
				SharedInfo.playClickSound(getContext(), R.raw.touch);
				//************************************//
			}
			
			break;
		case 2://scene 2
			if (Constant.nextF != null && Constant.nextF.intersect(touchrecF)) {
				
				thread.running=false;
				yes.sourceImage.recycle();no.sourceImage.recycle();
				yes=null;no=null;
				((Activity)context).setResult(Activity.RESULT_OK);
				((Activity)context).finish();
                SharedInfo.images.clear();
                SharedInfo.images=null;
                this.clear();
                Game1.zOrder=null;
                Game1.pressedBtnCollection=null;
				images.clear();
				SharedInfo.playClickSound(getContext(), R.raw.touch);
			}
			if (Constant.replayF != null
					&& Constant.replayF.intersect(touchrecF)) {

				thread.running=false;

				yes.sourceImage.recycle();no.sourceImage.recycle();
				yes=null;no=null;
				((Activity) context).setResult(Constant.REPLAY);
				((Activity) context).finish();
                SharedInfo.images.clear();
                SharedInfo.images=null;
                this.clear();
                Game1.zOrder=null;
                Game1.pressedBtnCollection=null;
				images.clear();
				SharedInfo.playClickSound(getContext(), R.raw.touch);
			}
			break;
		default:
			break;
		}
		
		return super.onTouchEvent(event);
	}
private void resetPosition(){
	bowlblank_big.setPosition(GlobalVariables.width/2-bowlblank_big.getWidth()/2, (int)(270*GlobalVariables.yScale_factor));
	bowlblankbigroll.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
	bowlghee.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
	for (int i = 0; i < Game1.zOrder.length; i++) {
		ShahSprite temp = images.get(zIndex.get(Game1.zOrder[i]));
		temp.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
	}
}
@Override
	public void onCompletion(MediaPlayer mp) {
	// TODO Auto-generated method stub
	switch (scene) {
	case 1:	
		if(game01_vo03!=null){
		yes_noFlag=true;
		Handler tempHandler=new Handler();
		tempHandler.postDelayed(new Runnable() {
			
			@Override
					public void run() {
						// TODO Auto-generated method stub
						if (game01_vo03 != null && yes_noFlag)
							game01_vo03.start();
					}
				}, SharedInfo.repeated_sound_delay);
			}
		break; 
	case 2:
		if(last_vo_flag){
			is_last_vo_played=true;			
			last_mp.stop();
			last_mp.release();
			last_mp=null;
			display_replay_Next=true;
			// to end screen
//			Handler tempHandler=new Handler();
//			tempHandler.postDelayed(new Runnable() {
//				@Override
//				public void run() {// call for end screen
//					// TODO Auto-generated method stub					
//					thread.running=false;
//					yes.sourceImage.recycle();no.sourceImage.recycle();
//					yes=null;no=null;
//					((Activity)context).setResult(Activity.RESULT_OK);
//					((Activity)context).finish();
//	                SharedInfo.images.clear();
//	                SharedInfo.images=null;
//	                clear();
//	                Game1.zOrder=null;
//	                Game1.pressedBtnCollection=null;
//					images.clear();
//				}				
//			},next_module_delay);
			
		}else{
			mp.stop();
			mp.release();
			is_ans_played=true;
			last_vo_flag=true;
			if(game01_vo04_wa!=null){
				game01_vo04_wa.release();
				game01_vo04_wa=null;
			}
			if(game01_vo04_ca!=null){
				game01_vo04_ca.release();
				game01_vo04_ca=null;
			}
			last_mp=MediaPlayer.create(getContext(), R.raw.game01_vo05);
			if(last_mp!=null){
				last_mp.setOnCompletionListener(this);
				last_mp.start();
			}
		}
		break;
	default:
		break;
	}
}


public void clear(){
    for (int i = 0; i < Game1.zOrder.length; i++) {
        ShahSprite temp = images.get(zIndex.get(Game1.zOrder[i]));
        temp.sourceImage.recycle();
    }
}
}

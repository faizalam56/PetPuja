package com.zmq.game1;

import java.util.ArrayList;
import java.util.Hashtable;

import com.abdullah.activities.Game1;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("NewApi")
public class PlateSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	public SurfaceHolder surfaceHolder;
	public  int gradientBtnIds[] = {
			R.id.toggleButton001, R.id.ToggleButton002, 
			R.id.ToggleButton003,R.id.ToggleButton004, R.id.ToggleButton005,
			R.id.ToggleButton006,R.id.ToggleButton007			
			};
	public Hashtable<Integer, Bitmap> images;
	public static Bitmap bowlblank,bowlblankroll,bowlghee;
	 Hashtable<Integer, Integer> zIndex=new Hashtable(7){{
			put(7,R.id.ToggleButton005);//egg
			put(6,R.id.ToggleButton004);//potato
			put(5,R.id.ToggleButton003);//mix-veg
			put(4,R.id.ToggleButton007);//rice
			put(3,R.id.ToggleButton006);//roti
			put(2,R.id.ToggleButton002);//dal
			put(1,R.id.toggleButton001);//sag	
			}};
	public boolean gheeFlag;
	public static ArrayList<Integer> pressedBtnCollection = new ArrayList<Integer>();

	public void setPressedBtnCollection(ArrayList<Integer> pressedBtnCollection) {
		this.pressedBtnCollection = pressedBtnCollection;
	}

	public PlateSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec ) {
	    int parentViewWidth = MeasureSpec.getSize( widthMeasureSpec );
	    int parentViewHeight = MeasureSpec.getSize( heightMeasureSpec );
	    // ... take into account the parent's size as needed ...
	    super.onMeasure(
	        MeasureSpec.makeMeasureSpec( bowlblank.getWidth(), MeasureSpec.EXACTLY ), 
	        MeasureSpec.makeMeasureSpec( bowlblank.getHeight(), MeasureSpec.EXACTLY ) );
	}
	
	public PlateSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public PlateSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

//	public PlateSurfaceView(Context context, AttributeSet attrs,
//			int defStyleAttr, int defStyleRes) {
//		super(context, attrs, defStyleAttr, defStyleRes);
//		// TODO Auto-generated constructor stub
//		init();
//	}
	
	private void init(){
                 
	    this.setZOrderOnTop(true); //necessary  
		  surfaceHolder = getHolder() ;
		  surfaceHolder.setFormat(PixelFormat.TRANSPARENT);
		  images=new Hashtable();
		  bowlblank = Constant.decodeSampledBitmapFromResource(getResources(),
                  R.drawable.game1_bowlblank);
		  bowlblankroll = Constant.decodeSampledBitmapFromResource(getResources(), 
						    R.drawable.game1_bowlblankroll);
		  bowlghee=Constant.decodeSampledBitmapFromResource(getResources(), 
				    R.drawable.game1_bowlghee);
		  
		for (int i = 0; i < gradientBtnIds.length; i++) {
			Bitmap  bmpIcon=null;
			switch (gradientBtnIds[i]) {
			case R.id.toggleButton001://sag
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowsag06);
				break;
			case  R.id.ToggleButton002://dal
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowdal06);
				break;
			case  R.id.ToggleButton003://mix veg
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowmixveg03);
				break;
			case  R.id.ToggleButton004://potato
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowpotato02);
				break;
			case  R.id.ToggleButton005://egg
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowlegg01);
				break;
			case  R.id.ToggleButton006://roti
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowroti05);
				break;
			case  R.id.ToggleButton007://rice
				bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
					    R.drawable.game1_bowrice04);
				break;							
			default:
				break;
			}
//			bmpIcon = Constant.decodeSampledBitmapFromResource(getResources(), 
//				    R.drawable.ic_launcher);
			images.put(Integer.valueOf(gradientBtnIds[i]), bmpIcon);
		}		  		
		  surfaceHolder.addCallback(this);
}
	
	public void drawSomething(Canvas canvas) {
//		  canvas.drawColor(Color.)	
		Paint clearPaint = new Paint();
		clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		canvas.drawRect(0, 0, getWidth(), getHeight(), clearPaint);
		canvas.drawColor(Color.TRANSPARENT);
		RectF a = new RectF(0, 0, getWidth(), getHeight());
		canvas.drawBitmap(bowlblank, null, a, null);
		for (int i = 0; i < pressedBtnCollection.size(); i++) {
			Bitmap temp = images.get(zIndex.get(Game1.zOrder[i]));
			canvas.drawBitmap(temp, null, a, null);
		}
		if (gheeFlag) {
			canvas.drawBitmap(bowlghee, null, a, null);
		}
		canvas.drawBitmap(bowlblankroll, null, a, null);
	}
  
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Canvas canvas = holder.lockCanvas(null);
        drawSomething(canvas);
        holder.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	public void clear(){
		bowlblank.recycle();
		bowlblankroll.recycle();
		bowlghee.recycle();
		zIndex=null;
	}
}

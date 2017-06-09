package com.abdullah.petpuja;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;

import com.abdullah.petpuja.R;

public class VideoPlayNew extends Activity implements SurfaceHolder.Callback, OnPreparedListener, MediaPlayerControl{
	private  MediaPlayer mediaPlayer;
	private  SurfaceHolder vidHolder;
	private  SurfaceView vidSurface;
	MediaController mediaController;
	String vidAddress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		vidAddress ="android.resource://"+getPackageName()+"/"+R.raw.video1;
//				getIntent().getStringExtra("VIDEOPATH");
//			
		
		if(getIntent().getStringExtra("VIDEOPATH")!=null){
			vidAddress=getIntent().getStringExtra("VIDEOPATH");
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_play_new);
		vidSurface = (SurfaceView) findViewById(R.id.surfView);
		vidHolder = vidSurface.getHolder();
		vidHolder.addCallback(this);
		mediaPlayer = new MediaPlayer();

//		vidHolder.setFixedSize(1200,640);
//		if(getIntent().getIntExtra("SWITCHINDEX",0)!=0)
//		vidHolder.setFixedSize(1280,700);
//		mediaPlayer.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
//		vidSurface.set
		
//		mediaController.setMediaPlayer(this);              

//        handler.post(new Runnable() {
//
//            public void run() {
//            	mediaController.setEnabled(true);
//            	mediaController.show();
//            }
//        });    
		 
	}
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}
	 
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		try {
		   
		    mediaPlayer.setDisplay(vidHolder);
		    Uri uri = Uri.parse(vidAddress);
		    mediaPlayer.setDataSource(this,uri);
		    mediaPlayer.prepare();
		    mediaPlayer.setOnPreparedListener(this);
		    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//		    mediaPlayer.setVideoScalingMode(MediaPlayer.);
		    mediaController = new MediaController(this);
//		    mediaController.setAnchorView(vidSurface);
		   
		    //////////////////////// RATIO ////////////////////////////
		    
//		    int screenHeight=1280;
//		    int screenWidth=800;
		    
//		    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//		        Point size = new Point();
//		        Display d=Diaplay.getDefaultDisplay().getSize(size);
//		        screenWidth = size.x;
//		        screenHeight = size.y;
//		    } else {
////		        Display d = w.getDefaultDisplay();
////		        screenWidth = d.getWidth();
////		        screenHeight = d.getHeight();
//		    }
		    
		    
		    int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            float videoProportion = (float) videoWidth / (float) videoHeight;

            // Get the width of the screen
            int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
            int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
            float screenProportion = (float) screenWidth / (float) screenHeight;

            // Get the SurfaceView layout parameters
            android.view.ViewGroup.LayoutParams lp = vidSurface.getLayoutParams();
            if (videoProportion > screenProportion) {
                lp.width = screenWidth;
                lp.height = (int) ((float) screenWidth / videoProportion);
            } else {
                lp.width = (int) (videoProportion * (float) screenHeight);
                lp.height = screenHeight;
            }
            // Commit the layout parameters
            vidSurface.setLayoutParams(lp);
		    
		    
		    
//		    vidHolder
		    
		    
//		    mediaController.setMediaPlayer(this);
//		    mediaController.setAnchorView(vidSurface);
//		    mediaController.setEnabled(true);
//		    mediaController.show();
		    
		    
//		    mediaPlayer.setMediaController(this);
		    
		    
		    
//		    mediaPlayer.setMediaPlayer();
		    
		    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer mp) {
					mediaPlayer.stop();
					mediaPlayer.release();
					mediaPlayer=null;
					setResult(Activity.RESULT_OK);
					finish();
					
				}
			});
		    
		}
		catch(Exception e){
		    e.printStackTrace();
		}
	}
	 
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		
	}
	 
	@Override
	public void onPrepared(MediaPlayer mp) {
		  mediaPlayer.start();
//		  mediaController.setMediaPlayer(this);              

//	        handler.post(new Runnable() {
//
//	            public void run() {
//	                mMediaController.setEnabled(true);
//	                mMediaController.show();
//	            }
//	        });  
	}
	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getAudioSessionId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}

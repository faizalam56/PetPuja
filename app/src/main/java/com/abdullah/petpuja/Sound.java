package com.abdullah.petpuja;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class Sound {
	public boolean timerControllerMediaPlayer;
	int playing=-1;     // 1 playing 0 not playing
	private int soundDelayInSecond;
	private int endDelayTimer;
	private int startDelayTimer;
	private int whatToPlay=0;
	MediaPlayer mediaPlayer=null;
	Context context;
	
	public  Sound(Context context) {
		this.context=context;
	}
	
	public void playSound(int whatToPlay,int threadSpeed,int startDelayInSecond,int endDelayInSecond){
		
		startDelayTimer+=threadSpeed;
		
		if(mediaPlayer==null&&startDelayTimer>=startDelayInSecond*1000){
			mediaPlayer = MediaPlayer.create(context,whatToPlay);
			mediaPlayer.start();
			playing=1;
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					timerControllerMediaPlayer=true;
				}});
		 }  
			
		
		 if(timerControllerMediaPlayer)
			 endDelayTimer+=threadSpeed;
		   
		   if(endDelayTimer==soundDelayInSecond*1000){     // wait time for second time playing
			   timerControllerMediaPlayer=false;
			   endDelayTimer=0;
			   mediaPlayer=null;
		   }
		
	}
	
   public void playSound(int whatToPlay){
		if(mediaPlayer==null){
			mediaPlayer=new MediaPlayer();
			mediaPlayer = MediaPlayer.create(context,whatToPlay);
			mediaPlayer.start();
			
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					timerControllerMediaPlayer=true;
					playing=-1;
				}});
		 }  
			
		
		 if(timerControllerMediaPlayer)
			 endDelayTimer++;
		   
		   if(endDelayTimer==1000){     // wait time for second time playing
			   timerControllerMediaPlayer=false;
			   endDelayTimer=0;
			   mediaPlayer=null;
		   }
		
	}
	

	
	public void stopSound(){
		if(mediaPlayer!=null){
			   if(mediaPlayer.isPlaying())
			   {
				   mediaPlayer.stop();
				   mediaPlayer.release();
			   }
			   mediaPlayer=null;
		   }
		timerControllerMediaPlayer=false;
		endDelayTimer=0;
		startDelayTimer=0;
		playing=-1; 
	}
	
	
	
	public int ifPlaying(){
		if(mediaPlayer==null)return -1;
		else if(mediaPlayer!=null&mediaPlayer.isPlaying())return 1;
		else return 0;
	}
	
}

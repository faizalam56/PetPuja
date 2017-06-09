package com.zmq.game1;

import android.content.Context;
import android.media.MediaPlayer;

public  class SharedInfo {
		
	public static long repeated_sound_delay=8000;
	
	public static MediaPlayer clickSound;
	public static Context context;
	public static Images images;
	public static boolean scene2Recycle;
	public static void playClickSound(Context context, int uri){

		if(clickSound==null){
			clickSound = MediaPlayer.create(context, uri);
		}

		clickSound.start();
		
//		if (clickSound != null && clickSound.isPlaying()) {
//			clickSound.stop();
//			clickSound.release();
//			clickSound=null;
//		} else {
//			clickSound = MediaPlayer.create(context, uri);
//			clickSound.start();
//		}

	}
	
}

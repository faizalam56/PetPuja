package com.abdullah.petpuja;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VedioPlay extends Activity{
	TextView heading;
	VideoView videoView;
	String path1;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.videoplay);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		
		


	
		videoView=(VideoView)findViewById(R.id.videoView1);
//		video.setVisibility(VideoView.GONE);

//		path1 =getIntent().getStringExtra("VIDEOPATH");
		
		path1="android.resource://"+getPackageName()+"/"+R.raw.video1;
		
		Toast.makeText(getApplicationContext(), "Path : "+path1, Toast.LENGTH_LONG).show();
		playVideo(path1);
       
        
		videoView.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
        		switch(getIntent().getIntExtra("SWITCHINDEX",0)){
        		case 1:
        			 mp.pause();
        			 mp.stop();
        			 mp.reset();
        			 mp=null;
        			 setResult(Activity.RESULT_OK);
       			     finish();
        			break;
        		case 2:
        			break;
        		case 3:
        			break;
        		case 4:
        			break;
        		}
//                  ShowDialog(1);
            }
        });
        
	}
	
	private void playVideo(String path1){
//		MediaController mc = new MediaController(this);
//		MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.video1);
//		videoView.setMediaController(mc);
//		mediaPlayer.setDisplay(videoView);
//		mc.setAnchorView(videoView);
//        mc.setMediaPlayer(videoView);
//		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//        		switch(getIntent().getIntExtra("SWITCHINDEX",0)){
//        		case 1:
//        			 mp.stop();
//        			 mp.release();
//        			 mp.reset();
//        			 mp=null;
//        			 setResult(Activity.RESULT_OK);
//       			     finish();
//        			break;
//        		case 2:
//        			break;
//        		case 3:
//        			break;
//        		case 4:
//        			break;
//        		}
////                  ShowDialog(1);
//            }
//        });
////        
////		mc.setmsetMediaPlayer(mc);
////		mediaPlayer.set
////		mediaPlayer.setMediaPlayer(video);
////		MediaPlayer pl = new MediaPlayer();
////        pl.setOnCompletionListener((OnCompletionListener) this);
////        pl.setDisplay(holder);
////        pl.setDataSource(fileInputStream.getFD());
////        pl.prepare();
////        pl.start();
////		
//		
	    	MediaController mc = new MediaController(this);
		    mc.setAnchorView(videoView);
	        mc.setMediaPlayer(videoView);
	        Uri uri = Uri.parse(path1);
	        videoView.setMediaController(mc);
	        videoView.setVideoURI(uri);
//	        video.setVideoPath(path1);
	        videoView.start();
	}
	
	protected Dialog ShowDialog(int id){
	    AlertDialog.Builder builder;
		switch(id){
		case 1:
			builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.closeAppHeading)
			.setMessage(R.string.videoString)
			.setCancelable(false)
			.setPositiveButton(R.string.haanString, new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int id){
				 playVideo(path1);	 
			}})
			.setNegativeButton(R.string.nahiString, new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int id){
			  setResult(Activity.RESULT_OK);
			  finish();
			}}).show();
		    break;
		case 2:
			builder = new AlertDialog.Builder(this);
			builder.setTitle("Check it out")
			.setMessage("Sorry there is no record to show")
			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int id){
			}}).show();
		    break;
      default: 
	        builder = new AlertDialog.Builder(this);
			builder.setTitle("Network Problem !")
			.setMessage("Could not Connect to the server Please Try Again !")
			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){}}).show();
		}
		return null;
}

	
	

}

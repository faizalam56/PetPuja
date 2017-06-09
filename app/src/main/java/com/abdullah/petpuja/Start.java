package com.abdullah.petpuja;

import com.abdullah.petpuja.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class Start extends Activity implements OnClickListener{
	ImageView imageView;
	MediaPlayer mediaPlayerTouch;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	        
//	        setContentView(R.layout.start);
//			
//			imageView=(ImageView)findViewById(R.id.startImageView);
//			imageView.setOnClickListener(this);
			
//			mediaPlayerTouch=MediaPlayer.create(Start.this, R.raw.touch);
//			mediaPlayerTouch.start();
	        
			Intent intent =new Intent();
			intent.setClass(getApplicationContext(),PetPuja.class);
			startActivity(intent);
		  }
		
		
		    @Override
			protected void onResume() {
			super.onResume();
			}

		    private void stop() {
              finish();
			}


			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}

//		@Override
//		public void onClick(View v) {
//			
//			finish();
//		}

}
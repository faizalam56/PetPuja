package com.zmq.game1;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class Screen1GameThread extends Thread {

	 private SurfaceHolder surfaceHolder;
	 Scene1 mySurfaceView;
	public boolean running;
	
	public Screen1GameThread(SurfaceHolder _surfaceHolder,Scene1 _mySurfaceView) {
		// TODO Auto-generated constructor stub
		 super();
	        this.surfaceHolder=_surfaceHolder;
	        this.mySurfaceView=_mySurfaceView;
	}
	
	  public void setRunning(boolean running) {
	        this.running = running;
	    }
	
	  public void run() {
		 
		 Canvas g;
	        //run the loop
	        while (running) {
	            //executionTime = System.nanoTime();//record the time right before we execute the update loop
	        	g=null;
	            try {
	            	g = this.surfaceHolder.lockCanvas(null);
	            	if(mySurfaceView.surface_flag){
					synchronized (surfaceHolder) {
//						mySurfaceView.update(g);						
						mySurfaceView.drawSomething(g);
					}
					surfaceHolder.unlockCanvasAndPost(g);
					}
	                //  tickCount++; 
	                //  System.gc();
//	                canvas.paint(g);
	                //  update the level if the game is running					
	                Thread.sleep(50);
	            } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
//	            finally {
//					// in case of an exception the surface is not left in 
//					// an inconsistent state
//					if (canvas != null) {
//						surfaceHolder.unlockCanvasAndPost(g);
//					}
//				}	// end finally
	        } 
		 
	 }
}

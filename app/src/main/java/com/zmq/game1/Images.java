package com.zmq.game1;

import java.util.Enumeration;
import java.util.Hashtable;

import android.graphics.Bitmap;
import android.os.Handler;

import com.abdullah.activities.Game1;
import com.abdullah.petpuja.Constant;
import com.abdullah.petpuja.R;
import com.zmq.sprite.FadeAnimation;
import com.zmq.sprite.ShahSprite;
import com.zmq.utility.GlobalVariables;
import com.zmq.utility.Utility;

public class Images {

	public ShahSprite bg;
	public ShahSprite bowlblank_big, bowlblankbigroll, bowlghee,hand,thumb;
	public FadeAnimation meshing_sprite, finalframe,dummy_bg;
	public Hashtable<Integer, ShahSprite> images;
//	boolean recycleFlag;

	Hashtable<Integer, Integer> zIndex=new Hashtable(7){{
		put(7,R.id.ToggleButton005);//egg
		put(6,R.id.ToggleButton004);//potato
		put(5,R.id.ToggleButton003);//mix-veg
		put(4,R.id.ToggleButton007);//rice
		put(3,R.id.ToggleButton006);//roti
		put(2,R.id.ToggleButton002);//dal
		put(1,R.id.toggleButton001);//sag	
		}}; 
		public ShahSprite yes,no;
	public Images() {
		// TODO Auto-generated constructor stub
		SharedInfo.scene2Recycle=false;
//		bg=new ShahSprite(Utility.createImage(R.drawable.background));
        bg=new ShahSprite(Constant.backGround);
//		ShahSprite temp_dummy_bg_sprite=new ShahSprite(Utility.createImage(R.drawable.bg));
		dummy_bg=new FadeAnimation(bg, 1000l, true);
		
		bowlblank_big=new ShahSprite(Utility.createImage(R.drawable.game1_bowlblank_big));
		bowlblank_big.setPosition(GlobalVariables.width/2-bowlblank_big.getWidth()/2, GlobalVariables.height/2-bowlblank_big.getHeight()/2);
		
		bowlblankbigroll=new ShahSprite(Utility.createImage(R.drawable.game1_bowlblankbigroll));
		bowlblankbigroll.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
		
		bowlghee=new ShahSprite(Utility.createImage(R.drawable.game1_bowlgheebig));
		bowlghee.setPosition(bowlblank_big.getX(), bowlblank_big.getY());		
		
				
				Bitmap meshing_spriteImage=Utility.createImage(R.drawable.meshing_sprite);
				ShahSprite temp_meshing_sprite=new ShahSprite(meshing_spriteImage, meshing_spriteImage.getWidth()/12, meshing_spriteImage.getHeight());
				meshing_sprite=new FadeAnimation(temp_meshing_sprite, 1000l, true);
				meshing_sprite.sprite.setPosition(GlobalVariables.width/2-meshing_sprite.sprite.getWidth()/2, 0);
				
				hand=new ShahSprite(Utility.createImage(R.drawable.game1_hand));
				hand.setPosition(meshing_sprite.sprite.getX(), meshing_sprite.sprite.getY());//position of smash ShahSprite
				
				thumb=new ShahSprite(Utility.createImage(R.drawable.game1_thumb));
				thumb.setPosition(meshing_sprite.sprite.getX(), meshing_sprite.sprite.getY());//position of smash ShahSprite
				
				ShahSprite temp_finalframe=new ShahSprite(Utility.createImage(R.drawable.game1_finalframe));
				finalframe=new FadeAnimation(temp_finalframe, 1000l, true);
				finalframe.sprite.setPosition(GlobalVariables.width/2-finalframe.sprite.getWidth()/2, 0);

		images=new Hashtable();
		for (int i = 0; i < Game1.zOrder.length; i++) {
			ShahSprite  bmpIcon=null;
			int temp=zIndex.get(Game1.zOrder[i]);
			switch (temp) {
			case R.id.toggleButton001://sag
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowsagbig07));
				break;
			case  R.id.ToggleButton002://dal
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowdalbig06));
				break;
			case  R.id.ToggleButton003://mix veg
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowmixvegbig03));;
				break;
			case  R.id.ToggleButton004://potato
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowpotatobig02));;
				break;
			case  R.id.ToggleButton005://egg
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowleggbig01));;
				break;
			case  R.id.ToggleButton006://roti
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowrotibig05));;
				break;
			case  R.id.ToggleButton007://rice
				bmpIcon = new ShahSprite(Utility.createImage(R.drawable.game1_bowricebig04));;
				break;							
			default:
				break;
			}
			bmpIcon.setPosition(bowlblank_big.getX(), bowlblank_big.getY());
			images.put(temp, bmpIcon);
		}
						
		Bitmap no_sprite_image=Utility.createImage(R.drawable.no);
		no=new ShahSprite(no_sprite_image,no_sprite_image.getWidth()/2,no_sprite_image.getHeight());
		no.setPosition(GlobalVariables.width/16,  5*GlobalVariables.height/8);
		
		Bitmap yes_sprite_image=Utility.createImage(R.drawable.yes);
		yes=new ShahSprite(yes_sprite_image,yes_sprite_image.getWidth()/2,yes_sprite_image.getHeight());
		yes.setPosition(15*GlobalVariables.width/16-yes.getDstRectWidth(), 5*GlobalVariables.height/8);
	}
	public void clear(){
//		 bg.sourceImage.recycle();
		 bg=null;
		 bowlblank_big.sourceImage.recycle();
		 bowlblank_big=null;
		 bowlblankbigroll.sourceImage.recycle();
		 bowlblankbigroll=null;
		 bowlghee.sourceImage.recycle();
		 bowlghee=null;
		 hand.sourceImage.recycle();
		 hand=null;
		 thumb.sourceImage.recycle();
		 thumb=null;
		 meshing_sprite.sprite.sourceImage.recycle(); 
		 meshing_sprite=null;
		 finalframe.sprite.sourceImage.recycle();
		 finalframe=null;
//		 dummy_bg.sprite.sourceImage.recycle();
		 dummy_bg=null;
		 Enumeration<ShahSprite> enm=images.elements();
		 for (int i = 0; i < images.size(); i++) {	
			 ShahSprite temp=enm.nextElement();
			 temp.sourceImage.recycle();
			 temp=null;
		 }
		 zIndex=null;
		 SharedInfo.scene2Recycle=true;
	}
}

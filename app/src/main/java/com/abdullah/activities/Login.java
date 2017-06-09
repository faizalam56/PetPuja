package com.abdullah.activities;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aasif.example.modulesession.VeiwReport;
import com.aasif.utility.MyPreference;
import com.abdullah.petpuja.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.SyncStateContract.Constants;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;





public class Login extends Activity{
	
	AlertDialog  d;
    Handler handler;
    static JSONObject jObj = null;
    JSONArray jArray = null;
    
    String success;
	Button loginMain,about,login,demo;
	LinearLayout linearLayoutLogin;
    EditText textUsername,txtPassword;
   
    String result = null;
    StringBuilder sb = null;
    InputStream is = null;
    
    String message;
    Context context;
//    DatabaseHelper databaseHelper;
    int isDataOnServer=0;
    int SWITCHINDEX=-1;
    int responce;
//    String[] tableValueHeader={"};
	
//    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	        
	        setContentView(R.layout.login);
//	        loginMain=(Button)findViewById(R.id.btnLoginlogin);
//	        about=(Button)findViewById(R.id.btnLoginAbout);
	        login=(Button)findViewById(R.id.loginBtn);
//	        demo=(Button)findViewById(R.id.demoBtn);
//	        demo.setVisibility(Button.GONE);
	        
	        linearLayoutLogin=(LinearLayout)findViewById(R.id.lL_login);
//	        linearLayoutLogin.setVisibility(LinearLayout.GONE);
//	        textUsername=(EditText)findViewById(R.id.PRF_edit_nameofmother);
	        txtPassword=(EditText)findViewById(R.id.editText2);
	        
//	        textUsername.setWidth(400);
//	        txtPassword.setWidth(400);
	        
//	        textUsername.setText("a");
	        txtPassword.setText("");
	        
	        context=this;
	        d= new ProgressDialog(Login.this);
	       

	        
	
	        
	        login.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					String password1=MyPreference.getStringValue(Login.this, "ActivityStatus", "password");
					String password2=txtPassword.getText().toString();
					
					if(password2!=null){
						if(password1.compareTo(password2)==0){
							
							Intent intent=new Intent();
							intent.setClass(Login.this,VeiwReport.class);
							startActivity(intent);
							finish();
						}
						else{
							ShowDialog(1);
						}
						
					}
					else{
						ShowDialog(0);
					}
					
					
					
				}
			});
	
}
	        
	  
	    protected Dialog ShowDialog(int id){
		super.onCreateDialog(id);
		Dialog dialog=null;
	    AlertDialog.Builder builder;
	    
	    
		switch(id){
		case 0:
			builder = new AlertDialog.Builder(this);
			builder.setTitle("Login Failed !")
			.setMessage("Passwod should not be blank!")
			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){
				
				txtPassword.setText(null);
				
			}});
	        dialog = builder.create();
	        dialog.show();
		    break;
		case 1:
			builder=new AlertDialog.Builder(this);
			builder.setTitle("Login Failed !")
			.setMessage("Password does not match please try again!")
			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				txtPassword.setText(null);
			}});
			dialog = builder.create();
			dialog.show();
			break;
		}
		return dialog;
}


				
		
	  }
		
		
	  
	  
	  

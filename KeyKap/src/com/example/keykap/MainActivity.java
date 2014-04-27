package com.example.keykap;

import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	private EditText username=null;
	private EditText password=null;
	private Button login;
	private Button register;
	static HashMap<String, String> accounts = new HashMap<String, String>();
	int counter = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		username = (EditText)findViewById(R.id.editText1);
	    password = (EditText)findViewById(R.id.editText2);
	    System.out.println( password );
	    login = (Button)findViewById(R.id.button1);
	    register = (Button)findViewById(R.id.button2);
	    login.setOnClickListener(loginListener);  
	    register.setOnClickListener(registerListener);
	    accounts.put("admin", "admin");
	    
	    /*
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}
	
	 private OnClickListener loginListener = new OnClickListener() {
			public void onClick(View view){
				String email = username.getText().toString();
				String pw = password.getText().toString();
				if (!accounts.containsKey(email)) {
					   Toast.makeText(getApplicationContext(), "Account Not Found",
					   Toast.LENGTH_SHORT).show();	
					   return;
				}
				for (String em:accounts.keySet()){
					if (em.equals(email) && pw.equals(accounts.get(em))) {
						   Toast.makeText(getApplicationContext(), "Redirecting...", 
						   Toast.LENGTH_SHORT).show();
								   
						   Intent i = new Intent(getApplicationContext(), KeyActivity.class);
					       startActivity(i);
					}
					else if (em.equals(email) && !pw.equals(accounts.get(em))) {
						   Toast.makeText(getApplicationContext(), "Wrong Credentials",
						   Toast.LENGTH_SHORT).show();						
					}
				}
			}
	    };
	    
		 private OnClickListener registerListener = new OnClickListener() {
				public void onClick(View view){
					Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
		            startActivity(i);
				}
		    };	 
	    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			this.onSettings();
			return true;
		}
		
		
		return super.onOptionsItemSelected(item);
	}
	
	public void onSettings() {
		Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(i);
	}
	
	public static void addAccount( String email, String password ) {
		accounts.put(email, password);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}

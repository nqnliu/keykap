package com.example.keykap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class RegisterActivity extends Activity {
	private Button register;
	private EditText email;
	private EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set View to register.xml
        setContentView(R.layout.register);
        register = (Button)findViewById(R.id.btnRegister);
        password = (EditText)findViewById(R.id.reg_password);
        email = (EditText)findViewById(R.id.reg_email);
        register.setOnClickListener(registerListener);
        
 
        //TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
 
        // Listening to Login Screen link
        /*loginScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });*/
    }
    
	 private OnClickListener registerListener = new OnClickListener() {
			public void onClick(View view){
				String em = email.getText().toString();
				String pw = password.getText().toString();
				if(!em.equals("") && 
				   !password.equals("")){
				   MainActivity.addAccount(em, pw);
				   Toast.makeText(getApplicationContext(), "Registering...", 
				   Toast.LENGTH_SHORT).show();
				   
				   Intent i = new Intent(getApplicationContext(), MainActivity.class);
	               startActivity(i);
				}	
				else{
				   Toast.makeText(getApplicationContext(), "Wrong Credentials",
				   Toast.LENGTH_SHORT).show();
				      }
				   }
	    };       
}

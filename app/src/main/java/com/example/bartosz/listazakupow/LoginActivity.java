package com.example.bartosz.listazakupow;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    EditText USERNAME,USERPASS;
    String username,userpass;
    Context CTX=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        USERNAME=(EditText) findViewById(R.id.LoginEditText);
        USERPASS=(EditText) findViewById(R.id.PasswordEditText);

        Login= (Button)findViewById(R.id.LogButton);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Bundle b= getIntent().getExtras();
                int status=b.getInt("status");
                username=USERNAME.getText().toString();
                userpass=USERPASS.getText().toString();
                DatabaseOperations DOP= new DatabaseOperations(CTX);
                Cursor CR=DOP.getInformationUser(DOP);
                CR.moveToFirst();
                boolean login_status=false;
                String NAME="";
                do {
          //          Log.e(String.valueOf(CR.getInt(0)),CR.getString(1));
                        if (username.equals(CR.getString(1)) && (userpass.equals(CR.getString(2)))) {

                           // login_status = true;
                            NAME = CR.getString(1);
                            Toast.makeText(getBaseContext(), "Login Success \n Welcome " + NAME, Toast.LENGTH_LONG);
                            Intent i = new Intent(LoginActivity.this,ShopActivity.class);
                            i.putExtra("numer",CR.getInt(0));
                            Log.d("cos", String.valueOf(CR.getInt(0)));
                            startActivity(i);
                            finish();
                        }
                }while (CR.moveToNext());

            }
        });

 
    }

}

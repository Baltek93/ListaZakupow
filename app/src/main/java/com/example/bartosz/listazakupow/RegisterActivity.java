package com.example.bartosz.listazakupow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText USER_NAME,USER_PASS,CON_PASS;
    String user_name,user_pass,con_pass;
    Button REG;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        USER_NAME=(EditText) findViewById(R.id.RegisterEditText);
        USER_PASS=(EditText) findViewById(R.id.RegisterPasswordEditText);
        CON_PASS=(EditText) findViewById(R.id.ConfirmPasswordEditText);
        ctx=this;
        REG=(Button)findViewById(R.id.RegButton);
        REG.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=USER_NAME.getText().toString();
                user_pass=USER_PASS.getText().toString();
                con_pass=CON_PASS.getText().toString();

                if(!(user_pass.equals(con_pass)))
                {
                    Toast.makeText(getBaseContext(),"Hasła nie są takie same ",Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                }
                else
                {
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInformationUser(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(),"Rejestracja Udana", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });

    }

}

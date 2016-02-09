package com.example.bartosz.listazakupow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button LoginButton, RegisterButton;
    Intent i;
    int status=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginButton=(Button)findViewById(R.id.LoginButton);
        RegisterButton=(Button)findViewById(R.id.RegisterButton);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.LoginButton:
                status =1;
              //  Bundle b = new Bundle();
               // b.putInt("status",status);
                i=new Intent(this,LoginActivity.class);
                i.putExtra("status",status);
                startActivity(i);
                break;
            case R.id.RegisterButton:
                i=new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
                default:break;

        }

    }
}

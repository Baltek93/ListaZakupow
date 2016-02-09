package com.example.bartosz.listazakupow;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopActivity extends Activity {
    Button ADDPRODUCT;
    ListView tx;
    Context ctx=this;
    int numer;
    ArrayList<String> produkty;
    ArrayList<Integer> iloscproduktow;
    DatabaseOperations DOP;
    AlertDialog.Builder builder;
    Cursor CR;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        produkty= new ArrayList<String>() ;
        iloscproduktow= new ArrayList<Integer>() ;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            numer = bundle.getInt("numer");
            Log.d(String.valueOf(numer),String.valueOf(numer));
        }
        ADDPRODUCT= (Button) findViewById(R.id.AddProductButton);
        tx= (ListView) findViewById(R.id.ListaZakupow);
        try {


            DOP = new DatabaseOperations(ctx);
            CR = DOP.getInformationShop(DOP);

            CR.moveToFirst();

            do {
                if (numer == CR.getInt(3)) {
                    produkty.add(CR.getString(1));
                    iloscproduktow.add(1);
                    Log.d(CR.getString(1), CR.getString(1));

                }
            } while (CR.moveToNext());
        }
        catch (CursorIndexOutOfBoundsException e)
        {
            Log.d("Blad",e.toString());
        }

        if (!produkty.isEmpty())
        {
            AdvancedCustomArrayAdapter adapter =
                    new AdvancedCustomArrayAdapter(this, produkty, iloscproduktow);
            tx.setAdapter(adapter);
        }

        ADDPRODUCT.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {





                Log.d("DFsgf", "SDFfd");
                // nauczenie sie jak obslugiwac lsitview


// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                LayoutInflater li = LayoutInflater.from(ctx);
                final View promptsView = li.inflate(R.layout.okienko, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        ctx);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.ProductEditText);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        DOP=new DatabaseOperations(ctx);
                                        DOP.putInformationShop(DOP, userInput.getText().toString(), 1, numer);
                                        iloscproduktow.add(1);
                                        produkty.add(userInput.getText().toString());
                                        final  AdvancedCustomArrayAdapter ad = new AdvancedCustomArrayAdapter((Activity)ctx,produkty,iloscproduktow);
                                        tx.setAdapter(ad);

                                    //    result.setText(userInput.getText());
                                  //      Log.d("Cycki",userInput.getText().toString());
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }

        });

    }










}


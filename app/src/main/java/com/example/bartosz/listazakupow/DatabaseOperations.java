package com.example.bartosz.listazakupow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Bartosz on 04.02.2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version=1;

    public String CREATE_TABLE_USER="CREATE TABLE "+ TableData.TableInfo.USER_TABLE_NAME+" ( "
            + TableData.TableInfo.USER_ID + " integer primary key autoincrement, "
            + TableData.TableInfo.USER_NAME+" TEXT not null , "
            + TableData.TableInfo.USER_PASS+ " TEXT not null );";
    public  String CREATE_TABLE_SHOP="CREATE TABLE "+ TableData.TableInfo.SHOP_TABLE_NAME + " ( "+
            TableData.TableInfo.SHOP_ID + " integer primary key autoincrement, "+
            TableData.TableInfo.SHOP_PRODUCT_NAME + " TEXT not null , "+
            TableData.TableInfo.SHOP_PRODUCT_AMOUNT + " integer not null , "+
            TableData.TableInfo.SHOP_USER_ID+ " integer,"+
            " FOREIGN KEY ("+ TableData.TableInfo.SHOP_USER_ID+") REFERENCES "+TableData.TableInfo.USER_TABLE_NAME+"("+ TableData.TableInfo.USER_ID+"));";


    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("DATABASE Operations", "DATABASE created");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER);
        Log.d("DATABASE Operations", "Table user Created");
        db.execSQL(CREATE_TABLE_SHOP);
        Log.d("DATABASE Operations", "Table shop Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformationUser(DatabaseOperations dop, String name, String pass)
    {
        SQLiteDatabase SQ= dop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, name);   // stworzenie zawartosci ktora pozniej wpiszemy do tablicy pierwsz zmienna okresla nazwe tabeli a druga wartosc
        cv.put(TableData.TableInfo.USER_PASS, pass);// stworzenie zawartosci ktora pozniej wpiszemy do tablicy
        SQ.insert(TableData.TableInfo.USER_TABLE_NAME,null,cv); // wpisanie do tablicy
        Log.d("DATABASE Operations", "One raw inserted ");
    }
    public Cursor getInformationUser(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.USER_ID,TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor CR= SQ.query(TableData.TableInfo.USER_TABLE_NAME,columns,null,null,null,null,null);
        return CR;
    }

    public Cursor getInformationShop(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.SHOP_ID,TableData.TableInfo.SHOP_PRODUCT_NAME, TableData.TableInfo.SHOP_PRODUCT_AMOUNT, TableData.TableInfo.SHOP_USER_ID};
        Cursor CR= SQ.query(TableData.TableInfo.SHOP_TABLE_NAME,columns,null,null,null,null,null);
        return CR;
    }


    public void putInformationShop(DatabaseOperations dop, String name, int amount, int id_user)
    {
        SQLiteDatabase SQ= dop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.SHOP_PRODUCT_NAME, name);   // stworzenie zawartosci ktora pozniej wpiszemy do tablicy pierwsz zmienna okresla nazwe tabeli a druga wartosc
        cv.put(TableData.TableInfo.SHOP_PRODUCT_AMOUNT, amount);// stworzenie zawartosci ktora pozniej wpiszemy do tablicy
        cv.put(TableData.TableInfo.SHOP_USER_ID,id_user);
        SQ.insert(TableData.TableInfo.SHOP_TABLE_NAME,null,cv); // wpisanie do tablicy

        Log.d("DATABASE Operations", "One raw inserted ");
    }

}

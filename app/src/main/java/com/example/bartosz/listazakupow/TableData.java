package com.example.bartosz.listazakupow;

import android.provider.BaseColumns;

/**
 * Created by Bartosz on 04.02.2016.
 */
public class TableData  {

    public TableData() {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String DATABASE_NAME = "shop_user";

        public  static final String USER_NAME = "usr_name";
        public static final String USER_PASS = "usr_pass";
        public static  final String USER_TABLE_NAME = "user";
        public static final String USER_ID="usrk1_id";

        public static final String SHOP_PRODUCT_NAME="shop_product_name";
        public static final String SHOP_TABLE_NAME="shop";

        public static final String SHOP_PRODUCT_AMOUNT="shop_product_amount";
        public static final String SHOP_PRODUCT_VALUE="shop_product_VALUE";
        public static final String SHOP_USER_ID="usr_id";
        public static final String SHOP_ID="shopk1_id";




    }
}

package com.example.bartosz.listazakupow;

import android.widget.TextView;

/**
 * Created by Bartosz on 07.02.2016.
 */
public class Products {
    String nameProduct;
    String amountProduct;
    String valueProduct;

    public Products(String nameProduct, String amountProduct, String valueProduct) {
        this.nameProduct = nameProduct;
        this.amountProduct = amountProduct;
        this.valueProduct = valueProduct;
    }

    public Products() {
    }



}

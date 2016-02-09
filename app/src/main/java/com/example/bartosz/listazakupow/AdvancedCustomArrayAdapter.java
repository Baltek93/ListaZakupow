package com.example.bartosz.listazakupow;

/**
 * Created by Bartosz on 07.02.2016.
 */

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCustomArrayAdapter extends ArrayAdapter<String>{
    private final Activity context;
    private final ArrayList<String> Title_Product;
    private final ArrayList<Integer>  Amount_Product;

    public AdvancedCustomArrayAdapter(
            Activity context, ArrayList<String> Title_Product, ArrayList<Integer> Amount_Product) {
        super(context, R.layout.element,Title_Product);
        this.context = context;
        this.Title_Product = Title_Product;
        this.Amount_Product = Amount_Product;
    }

    static class ViewContainer {
        public TextView txtTitle;
        public TextView txtAmount;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewContainer viewContainer;
        View rowView = view;

        //---print the index of the row to examine---
        Log.e("CustomArrayAdapter",String.valueOf(position));

        //---if the row is displayed for the first time---
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.element, null, true);

            //---create a view container object---
            viewContainer = new ViewContainer();

            //---get the references to all the views in the row---
            viewContainer.txtTitle = (TextView)
                    rowView.findViewById(R.id.txtPresidentName);
            viewContainer.txtAmount = (TextView)
                    rowView.findViewById(R.id.txtDescription);


            //---assign the view container to the rowView---
            rowView.setTag(viewContainer);
        } else {

            //---view was previously created; can recycle---
            Log.d("CustomArrayAdapter", "Recycling");
            //---retrieve the previously assigned tag to get
            // a reference to all the views; bypass the findViewByID() process,
            // which is computationally expensive---
            viewContainer = (ViewContainer) rowView.getTag();
        }

        //---customize the content of each row based on position---
        viewContainer.txtTitle.setText(Title_Product.get(position));
        viewContainer.txtAmount.setText(String.valueOf(Amount_Product.get(position)));
        return rowView;
    }
}



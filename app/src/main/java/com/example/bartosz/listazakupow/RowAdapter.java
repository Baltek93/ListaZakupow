package com.example.bartosz.listazakupow;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bartosz on 07.02.2016.
 */
public class RowAdapter  {
//    Context context;
//    int layoutResourceId;
//    List<Products> data=null;
//
//
//    public RowAdapter(Context context, int resourceLayoutID, List<Products> data) {
//        super(context, resourceLayoutID,data);
//        this.context=context;
//        this.layoutResourceId=resourceLayoutID;
//        this.data=data;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View row=convertView;
//        RowBeanHolder holder =null;
//
//        if(row==null)
//        {
//            LayoutInflater inflater=((Activity)context).getLayoutInflater();
//            row = inflater.inflate(layoutResourceId, parent, false);
//
//            holder= new RowBeanHolder();
//            holder.txtTitle=(TextView)row.findViewById(R.id.NameProduct);
//            holder.txtValue=(TextView)row.findViewById(R.id.ValueProduct);
//            holder.txtAmount=(TextView)row.findViewById(R.id.AmountProduct);
//            row.setTag(holder);
//        }
//        else
//        {
//            holder=(RowBeanHolder)row.getTag();
//        }
//        return row;
//    }
//    static class RowBeanHolder
//    {
//        TextView txtTitle;
//        TextView txtAmount;
//        TextView txtValue;
//    }
//}
//

}
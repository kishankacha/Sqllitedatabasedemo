package com.example.sqllitedatabasedemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.sqllitedatabasedemo.Activity.Product;
import com.example.sqllitedatabasedemo.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter {
   List list=new ArrayList();
    public ProductAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(Product object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        ProductHolder productHolder;
        if (row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.display_product_row,parent,false);
            productHolder=new ProductHolder();
            productHolder.tx_id=row.findViewById(R.id.p_id);
            productHolder.tx_price=row.findViewById(R.id.p_price);
            productHolder.tx_name=row.findViewById(R.id.p_name);
            productHolder.tx_qty=row.findViewById(R.id.p_qty);

            row.setTag(productHolder);
        }
        else
        {
            productHolder= (ProductHolder) row.getTag();
        }
        Product product=(Product) getItem(position);
        productHolder.tx_id.setText(product.getId());
        productHolder.tx_name.setText(product.getName());
        productHolder.tx_price.setText(Integer.toString(product.getPrice()));
        productHolder.tx_qty.setText(Integer.toString(product.getQty()));


        return row;
    }
    static  class ProductHolder
    {
        TextView tx_id,tx_name,tx_price,tx_qty;
    }
}

package com.example.fnspl.retail_app.Actvities.adapter;

/**
 * Created by User on 8/3/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fnspl.retail_app.R;

import java.util.List;


public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.ViewHolder> {
    private List<String> values;
    private Context context ;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_name_itemGrocery;
        public TextView tv_quantity_spinner;
        public ImageView iv_itemGrocery ;
        public LinearLayout ll_spinner_dialog ;
        public View layout;
        private  ImageView iv_min_cart , iv_add_cart;
        private  TextView tv_quantity_cart;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tv_name_itemGrocery = (TextView) v.findViewById(R.id.tv_product_name);
            tv_quantity_cart = (TextView) v.findViewById(R.id.tv_quantity_cart);
            iv_add_cart = (ImageView) v.findViewById(R.id.iv_add_cart);
            iv_min_cart = (ImageView) v.findViewById(R.id.iv_min_cart);

        }
    }

    public void notifyDataChange(List<String> data) {
        this.values = data ;
        notifyDataSetChanged();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyCartAdapter(Context context, List<String> myDataset) {
        this.context = context ;
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.item_mycart, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.iv_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(holder.tv_quantity_cart.getText().toString().trim());
                count++ ;
                holder.tv_quantity_cart.setText(""+count);
            }
        });

        holder.iv_min_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(holder.tv_quantity_cart.getText().toString().trim());
                if(count>0){
                    count-- ;
                }else {
                    count = 0 ;
                }
                holder.tv_quantity_cart.setText(""+count);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
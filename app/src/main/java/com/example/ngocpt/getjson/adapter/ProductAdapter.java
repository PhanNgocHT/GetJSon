package com.example.ngocpt.getjson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ngocpt.getjson.R;
import com.example.ngocpt.getjson.model.Products;

import java.util.List;

/**
 * Created by ngoc.pt on 28/06/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProducsViewHolder>{
    private List<Products> producs;
    private Context context;

    public ProductAdapter(List<Products> producs, Context context) {
        this.producs = producs;
        this.context = context;
    }

    @Override
    public ProducsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(viewType, parent, false);
        return new ProducsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProducsViewHolder holder, int position) {
        final Products product=producs.get(position);
        holder.tvName.setText(product.getProductName());
        Glide.with(context).load(product.getThumnail())
                .override(150,150).centerCrop().into(holder.imgThumnail);
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.grid_item;
    }

    @Override
    public int getItemCount() {
        return null!=producs ? producs.size() : 0;
    }

    class ProducsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumnail;
        TextView tvName;

        public ProducsViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            imgThumnail=itemView.findViewById(R.id.img_thumnail);
        }
    }

}

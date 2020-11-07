package com.example.uc297;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.MyViewHolder> {

    List<CategoryModel> categoryModelList;


    public GridRecyclerAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sevices_grid_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = categoryModelList.get(position).getCategoryTitle();
        String des = categoryModelList.get(position).getCategoryDescription();
        String offer=categoryModelList.get(position).getFeatureOffers();
        int img = categoryModelList.get(position).getCategoryImg();
        int ServiNo=categoryModelList.get(position).getSERVICE_NO();
        holder.setData(img, title,offer, des, ServiNo);
    }

    @Override
    public int getItemCount() {
        if (categoryModelList.size() > 4) {
            return 4;
        } else {
            return categoryModelList.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView freeOfferTitle;

        @SuppressLint("ClickableViewAccessibility")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage);
            title = itemView.findViewById(R.id.itemtitle);
            freeOfferTitle = itemView.findViewById(R.id.freeOfferTitleId);


        }

        private void setData(int img, final String titletxt,String offer, final String desc, final int SERVICE_NO) {
            title.setText(titletxt);
            imageView.setImageResource(img);
            if (offer.equals("null")){
                freeOfferTitle.setVisibility(View.INVISIBLE);
            }else {
                freeOfferTitle.setText(offer);
            }


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation scaleAnim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_anim);
                    imageView.startAnimation(scaleAnim);
                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                    categoryIntent.putExtra("categoryName", titletxt);
                    categoryIntent.putExtra("categoryDesc", desc);
                    categoryIntent.putExtra("serviceNo", SERVICE_NO);
                    itemView.getContext().startActivity(categoryIntent);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                    categoryIntent.putExtra("categoryName", titletxt);
                    categoryIntent.putExtra("categoryDesc", desc);
                    categoryIntent.putExtra("serviceNo", SERVICE_NO);
                    itemView.getContext().startActivity(categoryIntent);
                }
            });
        }



    }
}

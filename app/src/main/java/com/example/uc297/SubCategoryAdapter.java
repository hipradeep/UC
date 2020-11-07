package com.example.uc297;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {
    List<SubCategoryModel> subCategoryModelList;
    PositionInterface positionInterface;


    public SubCategoryAdapter(List<SubCategoryModel> subCategoryModelList, PositionInterface positionInterface) {
        this.subCategoryModelList = subCategoryModelList;
        this.positionInterface = positionInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subservice_items_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int subServiceImg=subCategoryModelList.get(position).getSubCategoryImg();
        String title=subCategoryModelList.get(position).getSubCategoryTitle();

        holder.setData(subServiceImg, title, position);

    }

    @Override
    public int getItemCount() {
        return subCategoryModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
       private TextView subServiceTitle;
        private ImageView subServiceImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subServiceImage=itemView.findViewById(R.id.subServiceImage);
            subServiceTitle=itemView.findViewById(R.id.subServiceTitle);

        }

        private void setData(final int img, String title, final int position){
            subServiceImage.setImageResource(img);
            subServiceTitle.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    positionInterface.getPosition(position);

                }
            });
        }


    }
}
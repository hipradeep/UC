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

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {

    private List<CategoryModel> categoryListModelList;

    public CategoryListAdapter(List<CategoryModel> categoryListModelList) {
        this.categoryListModelList = categoryListModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int img=categoryListModelList.get(position).getCategoryImg();
        String name=categoryListModelList.get(position).getCategoryTitle();
        String catDes=categoryListModelList.get(position).getCategoryDescription();
        int SERVICE_NO=categoryListModelList.get(position).getSERVICE_NO();

        holder.setData(img, name, catDes, SERVICE_NO);

    }

    @Override
    public int getItemCount() {
        return categoryListModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView listImg;
        private TextView listName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            listImg = itemView.findViewById(R.id.list_image);
            listName = itemView.findViewById(R.id.list_title);
        }

        private void setData(int img_list, final String list_name, final String catDes, final int SERVICE_NO){
            listImg.setImageResource(img_list);
            listName.setText(list_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                    categoryIntent.putExtra("categoryName", list_name);
                    categoryIntent.putExtra("categoryDesc", catDes);
                    categoryIntent.putExtra("serviceNo", SERVICE_NO);
                    itemView.getContext().startActivity(categoryIntent);
                }
            });
        }
    }
}

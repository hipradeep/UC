package com.example.uc297;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubCategoryListAdapter extends RecyclerView.Adapter<SubCategoryListAdapter.MyViewHolder> {
    private List<SubCategoryListModel> subCategoryListModelList;

    public SubCategoryListAdapter(List<SubCategoryListModel> subCategoryListModelList) {
        this.subCategoryListModelList = subCategoryListModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subservice_list_item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title=subCategoryListModelList.get(position).getServiceName();
        holder.setSubServiceData(title);

    }

    @Override
    public int getItemCount() {
        return subCategoryListModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.subservicename);
        }
        private void setSubServiceData(String titletxt){
            title.setText(titletxt);
        }
    }
}

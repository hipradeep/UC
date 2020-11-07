package com.example.uc297;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter {

    private List<SubCategoryModel> serviceModelList;
    private RecyclerView.RecycledViewPool  viewPool ;

    private Context context;

    public ServiceAdapter(List<SubCategoryModel> serviceModelList, Context context) {
        this.serviceModelList = serviceModelList;
        this.context=context;
        viewPool = new RecyclerView.RecycledViewPool();
        }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subservice_item_layout, parent, false);

        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String title = serviceModelList.get(position).getSubCategoryTitle();
        String banner = serviceModelList.get(position).getBannerTitle();
        String bannerDetail = serviceModelList.get(position).getBannerDetails();
        List<SubServicesModel> servicesModels = serviceModelList.get(position).getSubServicesModelList();
        ((ServiceViewHolder) holder).setData(title, banner, bannerDetail, servicesModels);


    }

    @Override
    public int getItemCount() {
        return serviceModelList.size();
    }

    public  class ServiceViewHolder extends RecyclerView.ViewHolder {

        private TextView service_category_name;
        private TextView service_category_banner_name;
        private TextView banner_descriptions;
        private RecyclerView service_recycler_view;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            service_category_name = itemView.findViewById(R.id.service_category_name);
            service_category_banner_name = itemView.findViewById(R.id.service_category_banner_name);
            banner_descriptions = itemView.findViewById(R.id.banner_descriptions);
            service_recycler_view = itemView.findViewById(R.id.service_recycler_view);
           service_recycler_view.setRecycledViewPool(viewPool);
        }

        public void setData(String title, String banner, String bannerDetail, List<SubServicesModel> subServicesModels) {
            service_category_name.setText(title);
            service_category_banner_name.setText(banner);
            banner_descriptions.setText(bannerDetail);

           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());

            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            service_recycler_view.setLayoutManager(linearLayoutManager);
            SubServicesAdapter subServicesAdapter = new SubServicesAdapter(subServicesModels, (CartInterface) itemView.getContext());
            service_recycler_view.setAdapter(subServicesAdapter);
            subServicesAdapter.notifyDataSetChanged();

        }
    }
}

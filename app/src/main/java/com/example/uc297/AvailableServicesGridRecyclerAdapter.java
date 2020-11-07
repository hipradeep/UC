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

import static com.example.uc297.Fragments.HomeFragment.APPLIANCE_REPAIR;
import static com.example.uc297.Fragments.HomeFragment.CLEANING_AND_DUST;

public class AvailableServicesGridRecyclerAdapter extends RecyclerView.Adapter<AvailableServicesGridRecyclerAdapter.MyViewHolder> {

    private List<CategoryModel> categoryModelList;

    public AvailableServicesGridRecyclerAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_servicesgrid_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int image = categoryModelList.get(position).getCategoryImg();
        String title = categoryModelList.get(position).getCategoryTitle();
        String categoryDes = categoryModelList.get(position).getCategoryDescription();
        int SERVICE_NO=categoryModelList.get(position).getSERVICE_NO();

        holder.setCategory(image, title, categoryDes,SERVICE_NO);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();   }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView category_name;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.itemImage);
            category_name = itemView.findViewById(R.id.itemtitle);
          /*  itemView.setClickable(true);
            itemView.setOnClickListener(this);*/
        }

        private void setCategory(int img, final String name, final String catDes, final int SERVICE_NO) {
            categoryImage.setImageResource(img);
            category_name.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (SERVICE_NO==CLEANING_AND_DUST || SERVICE_NO==APPLIANCE_REPAIR) {
                        Intent categoryIntent = new Intent(itemView.getContext(), CategoryListActivity.class);
                        categoryIntent.putExtra("categoryName", name);
                        categoryIntent.putExtra("categoryDesc", catDes);
                        categoryIntent.putExtra("serviceNo", SERVICE_NO);
                        itemView.getContext().startActivity(categoryIntent);

                    }else {

                        Intent categoryIntent = new Intent(itemView.getContext(), CategoryActivity.class);
                        categoryIntent.putExtra("categoryName", name);
                        categoryIntent.putExtra("categoryDesc", catDes);
                        categoryIntent.putExtra("serviceNo", SERVICE_NO);
                        itemView.getContext().startActivity(categoryIntent);

                    }
                }
            });
        }

      /*  @Override
        public void onClick(View view) {

            final Intent intent;
            switch (getAdapterPosition()) {
                case 0:
                    intent = new Intent(context, CategoryActivity.class);
                    context.startActivity(intent);
                    break;

                case 1:
                    intent = new Intent(context, HairCutAtHome.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, CleaningAndDisinfection.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, ApplianceServicesRepairList.class);
                    context.startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(context, ACServiceRepair.class);
                    context.startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, Painters.class);
                    context.startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(context, Electricians.class);
                    context.startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(context, Plumbers.class);
                    context.startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(context, Carprnters.class);
                    context.startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(context, PestControl.class);
                    context.startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(context, MassageTherapy.class);
                    context.startActivity(intent);
                    break;
                case 11:
                    intent = new Intent(context, YogFitness.class);
                    context.startActivity(intent);
                    break;

                default:
                    Toast.makeText(context, "Default: No Activity At", Toast.LENGTH_SHORT).show();
                    break;

            }
        }*/
    }
}

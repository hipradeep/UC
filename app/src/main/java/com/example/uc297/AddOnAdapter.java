package com.example.uc297;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddOnAdapter extends RecyclerView.Adapter<AddOnAdapter.MyViewHolder> {
    private List<AddOnModel> addOnModelList;

    public AddOnAdapter(List<AddOnModel> addOnModelList) {
        this.addOnModelList = addOnModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_on_items_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title=addOnModelList.get(position).getAddOnTitle();
        String price=addOnModelList.get(position).getAddOnPrice();
        int imge=addOnModelList.get(position).getImg();
        holder.setAddOnData(imge,title, price);

    }

    @Override
    public int getItemCount() {
        return addOnModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView titleAndPrice;
        private ImageView checkImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            checkImg=itemView.findViewById(R.id.checkImg);
            titleAndPrice=itemView.findViewById(R.id.titleAndPrice);

        }
        private void setAddOnData(final int img, String title, String price){
            image.setImageResource(img);
            titleAndPrice.setText(title +" : ₹"+price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    if (checkImg.getVisibility()==View.GONE){
                        checkImg.setVisibility(View.VISIBLE);
                        final Drawable color=new ColorDrawable(0x40000000);
                        image.setForeground(color);
                    }else {
                        checkImg.setVisibility(View.GONE);
                        final Drawable color=new ColorDrawable(0x00000000);
                        image.setForeground(color);
                    }

                }
            });
        }
    }
}

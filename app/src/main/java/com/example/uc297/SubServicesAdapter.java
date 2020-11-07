package com.example.uc297;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubServicesAdapter extends RecyclerView.Adapter{


    private List<SubServicesModel> servicesModelList;
 private  CartInterface cartInterface;


    public SubServicesAdapter(List<SubServicesModel> servicesModelList, CartInterface cartInterface) {
        this.servicesModelList = servicesModelList;
        this.cartInterface=cartInterface;

    }

    @Override
    public int getItemViewType(int position) {
        switch (servicesModelList.get(position).getType()) {
            case 0:
                return SubServicesModel.SERVICE_ITEM_TYPE_ONE;
            case 1:
                return SubServicesModel.SERVICE_ITEM_TYPE_TWO;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case SubServicesModel.SERVICE_ITEM_TYPE_ONE:
                View serviceType1View = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_layout, parent, false);
                return new ServiceType1ViewHolder(serviceType1View);
            case SubServicesModel.SERVICE_ITEM_TYPE_TWO:
                View serviceType2View = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_layout_type2, parent, false);
                return new ServiceType2ViewHolder(serviceType2View);

            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        switch (servicesModelList.get(position).getType()) {
            case SubServicesModel.SERVICE_ITEM_TYPE_ONE:
                String name = servicesModelList.get(position).getServiceName();
                int price = servicesModelList.get(position).getServicePrice();
                String free = servicesModelList.get(position).getFreeService();
                String detail1 = servicesModelList.get(position).getServiceDetail1();
                String detail2 = servicesModelList.get(position).getServiceDetail2();
                String detail3 = servicesModelList.get(position).getServiceDetail3();
                String detail4 = servicesModelList.get(position).getServiceDetail4();
                Boolean imgSlider = servicesModelList.get(position).getImageSlider();
                Boolean video = servicesModelList.get(position).getVideoIntro();
                ((ServiceType1ViewHolder) holder).setDataOnServiceTypeOne(name, price, free, detail1, detail2, detail3, detail4, video, imgSlider);
                break;
            case SubServicesModel.SERVICE_ITEM_TYPE_TWO:
                int imgResource=servicesModelList.get(position).getServiceImage();
                String name2 = servicesModelList.get(position).getServiceName();
                int price2 = servicesModelList.get(position).getServicePrice();
                String detai1 = servicesModelList.get(position).getServiceDetail1();
                String detai2 = servicesModelList.get(position).getServiceDetail2();
                ((ServiceType2ViewHolder) holder).setDataOnServiceTypeTwo(imgResource,name2,price2, detai1, detai2);
                break;

            default:
                return;
        }

    }


    @Override
    public int getItemCount() {
        return servicesModelList.size();
    }


    private static int  CART_VALUE=0;
    private static int NUMBER_OF_ITEMS=0;
    public  class ServiceType1ViewHolder extends RecyclerView.ViewHolder {
        private TextView free_offer_text;
        private TextView service_name;
        private TextView service_price;
        private TextView service_detail1;
        private TextView service_detail2;
        private TextView service_detail3;
        private TextView service_detail4;
        private TextView small_slider_image;
        private TextView video_into;
        private LinearLayout ll_addBtnUp, ll_addBtnDown;
        private Button decBtn, incBtn;
        private TextView numCount;

        public ServiceType1ViewHolder(@NonNull View itemView) {
            super(itemView);
            free_offer_text = itemView.findViewById(R.id.free_offer_text);
            service_name = itemView.findViewById(R.id.service_name);
            service_price = itemView.findViewById(R.id.service_price);
            service_detail1 = itemView.findViewById(R.id.service_detail1);
            service_detail2 = itemView.findViewById(R.id.service_detail2);
            service_detail3 = itemView.findViewById(R.id.service_detail3);
            service_detail4 = itemView.findViewById(R.id.service_detail4);
            small_slider_image = itemView.findViewById(R.id.small_slider_image);
            video_into = itemView.findViewById(R.id.video_into);
            ll_addBtnUp = itemView.findViewById(R.id.ll_addBtnUp);
            ll_addBtnDown = itemView.findViewById(R.id.ll_addBtnDown);
            decBtn = itemView.findViewById(R.id.decBtn);
            incBtn = itemView.findViewById(R.id.incBtn);
            numCount = itemView.findViewById(R.id.numCount);



        }

        private void setDataOnServiceTypeOne(String name, int price, String free, String detail1, String detail2, String detail3, String detail4, Boolean vdo,
                             Boolean imgSlider) {
            service_name.setText(name);
            service_price.setText("₹" + price);

            if (free.equals("null")) {
                free_offer_text.setVisibility(View.GONE);
            } else {

                free_offer_text.setText(free);
            }

            if (detail1.equals("null")) {
                service_detail1.setVisibility(View.GONE);
            } else {

                service_detail1.setText(detail1);
            }
            if (detail2.equals("null")) {
                service_detail2.setVisibility(View.GONE);
            } else {

                service_detail2.setText(detail2);
            }
            if (detail3.equals("null")) {
                service_detail3.setVisibility(View.GONE);
            } else {

                service_detail3.setText(detail3);
            }
            if (detail4.equals("null")) {
                service_detail4.setVisibility(View.GONE);
            } else {

                service_detail4.setText(detail4);
            }

            if (vdo) {
                video_into.setVisibility(View.VISIBLE);
            } else {
                video_into.setVisibility(View.GONE);
            }

            if (imgSlider) {
                small_slider_image.setVisibility(View.VISIBLE);
            } else {
                small_slider_image.setVisibility(View.GONE);
            }
           cartButton_quick_fix(price);
        }


        private void cartButton_quick_fix(final int price) {
            final int[] count = {0};

            ll_addBtnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ll_addBtnUp.setVisibility(View.GONE);
                    ll_addBtnDown.setVisibility(View.VISIBLE);
                    count[0] = 1;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS+1;
                    CART_VALUE=CART_VALUE+price;
                    //CART=CART+count[0];
                    numCount.setText(String.valueOf(count[0]));
                    //Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                    cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS, (int)CART_VALUE);

                }
            });

            decBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]--;
                    CART_VALUE=CART_VALUE-price;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS-1;
                    if (count[0] == 0) {
                        ll_addBtnUp.setVisibility(View.VISIBLE);
                        ll_addBtnDown.setVisibility(View.GONE);
                      //  Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS, (int)CART_VALUE);

                    }
                    if (count[0] > 0) {
                        numCount.setText(String.valueOf(count[0]));
                        //Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);
                    }
                }
            });

            incBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    CART_VALUE=CART_VALUE+price;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS+1;
                    if (count[0] > 0) {
                        numCount.setText(String.valueOf(count[0]));
                      //  Toast.makeText(itemView.getContext(),"value" +(int)count[0], Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);
                    }
                }
            });
        }

    }


    public  class ServiceType2ViewHolder extends RecyclerView.ViewHolder{

        private ImageView serviceImage;
        private ImageView doted_line;
        private TextView service_name;
        private TextView service_price;
        private TextView service_detail1;
        private TextView service_detail2;
        private LinearLayout ll_addBtnUp, ll_addBtnDown;
        private Button decBtn, incBtn;
        private TextView numCount;


        public ServiceType2ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceImage = itemView.findViewById(R.id.service_image);
            doted_line = itemView.findViewById(R.id.doted_line);
            service_name = itemView.findViewById(R.id.service_name);
            service_price = itemView.findViewById(R.id.service_price);
            service_detail1 = itemView.findViewById(R.id.service_detail1);
            service_detail2 = itemView.findViewById(R.id.service_detail2);
            ll_addBtnUp = itemView.findViewById(R.id.ll_addBtnUp);
            ll_addBtnDown = itemView.findViewById(R.id.ll_addBtnDown);
            decBtn = itemView.findViewById(R.id.decBtn);
            incBtn = itemView.findViewById(R.id.incBtn);
            numCount = itemView.findViewById(R.id.numCount);


        }

        private void setDataOnServiceTypeTwo(int servImg, String name, int price, String detail1, String detail2) {
            serviceImage.setImageResource(servImg);
            service_name.setText(name);
            service_price.setText("₹" + price);


            if (detail1.equals("null") && detail2.equals("null")){
                doted_line.setVisibility(View.GONE);
            }else {
                doted_line.setVisibility(View.VISIBLE);
            }
            if (detail1.equals("null")) {
                service_detail1.setVisibility(View.GONE);
            } else {
                service_detail1.setText(detail1);
            }
            if (detail2.equals("null")) {
                service_detail2.setVisibility(View.GONE);
            } else {
                service_detail2.setText(detail2);
            }
            cartButton_quick_fix(price);

        }

        private void cartButton_quick_fix(final int price) {

            final int[] count = {0};


            ll_addBtnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ll_addBtnUp.setVisibility(View.GONE);
                    ll_addBtnDown.setVisibility(View.VISIBLE);
                    count[0] = 1;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS+1;
                    CART_VALUE=CART_VALUE+price;
                    //CART=CART+count[0];
                    numCount.setText(String.valueOf(count[0]));
                    //Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                    cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);


                }
            });

            decBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]--;
                    CART_VALUE=CART_VALUE-price;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS-1;
                    //  CART=CART-count[0];
                    if (count[0] == 0) {
                        ll_addBtnUp.setVisibility(View.VISIBLE);
                        ll_addBtnDown.setVisibility(View.GONE);
                        //  Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);


                    }
                    if (count[0] > 0) {
                        numCount.setText(String.valueOf(count[0]));
                        //Toast.makeText(itemView.getContext(),"value" +(int)CART, Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);

                    }
                }
            });

            incBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[0]++;
                    CART_VALUE=CART_VALUE+price;
                    NUMBER_OF_ITEMS=NUMBER_OF_ITEMS+1;
                    //CART=CART+count[0];
                    if (count[0] > 0) {
                        numCount.setText(String.valueOf(count[0]));
                        //  Toast.makeText(itemView.getContext(),"value" +(int)count[0], Toast.LENGTH_SHORT).show();
                        cartInterface.onAddCartButtonClick((int)NUMBER_OF_ITEMS,(int)CART_VALUE);

                    }
                }
            });
        }
    }
}

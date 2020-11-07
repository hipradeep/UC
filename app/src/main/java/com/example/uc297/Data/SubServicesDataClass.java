package com.example.uc297.Data;


import com.example.uc297.R;
import com.example.uc297.ServiceModel;
import com.example.uc297.SubServicesModel;

import java.util.ArrayList;
import java.util.List;

public class SubServicesDataClass {
    List<SubServicesModel> subServicesModelList;
    List<SubServicesModel> subServicesModelList1;
    List<SubServicesModel> subServicesModelList2;
    List<ServiceModel> serviceModelList;


    public SubServicesDataClass() {
        ////////////////////////////////




        ////////////////////////////////
        subServicesModelList = new ArrayList<>();

        subServicesModelList.add(new SubServicesModel(0, "Service1", 499, "null", "FACIAL - Fruit Cleanup by Sara",
                "null", "FACIAL - Fruit Cleanup by Sara3", "FACIAL - Fruit Cleanup by Sara4", true, false));

        subServicesModelList.add(new SubServicesModel(0, "Service1", 499, "free", "FACIAL - Fruit Cleanup by Sara",
                "null", "FACIAL - Fruit Cleanup by Sara3", "FACIAL - Fruit Cleanup by Sara4", false, false));

        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 121, "null", "null"));
        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 399, "FACIAL - Fruit Cleanup by Sara4", "null"));
        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_card_giftcard_24, "Typ2Service", 256, "null", "null"));
        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 564, "FACIAL - Fruit Cleanup by Sara4", "null"));
        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_card_giftcard_24, "Typ2Service", 785, "null", "null"));
        subServicesModelList.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 632, "del1", "null"));
         ///////////////////////////////


        ///////////////////////////////////
        subServicesModelList1 = new ArrayList<>();
        subServicesModelList1.add(new SubServicesModel(0, "Service1", 100, "null", "FACIAL - Fruit Cleanup by Sara",
                "null", "FACIAL - Fruit Cleanup by Sara3", "FACIAL - Fruit Cleanup by Sara4", false, true));
        subServicesModelList1.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 236, "null", "null"));
        subServicesModelList1.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 399, "del1", "null"));
        subServicesModelList1.add(new SubServicesModel(1, R.drawable.ic_baseline_card_giftcard_24, "Typ2Service", 299, "null", "null"));
        subServicesModelList1.add(new SubServicesModel(1, R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 699, "FACIAL - Fruit Cleanup by Sara4", "null"));

        /////////////////////////


        //////////////////////////
        subServicesModelList2=new ArrayList<>();
        subServicesModelList2.add(new SubServicesModel(0,"Service1",526, "null", "FACIAL - Fruit Cleanup by Sara" ,
                "null", "FACIAL - Fruit Cleanup by Sara3","FACIAL - Fruit Cleanup by Sara4", true, false));
        subServicesModelList2.add(new SubServicesModel(0,"Service1",230, "null", "FACIAL - Fruit Cleanup by Sara" ,
                "null", "FACIAL - Fruit Cleanup by Sara3","FACIAL - Fruit Cleanup by Sara4", true, true));

        subServicesModelList2.add(new SubServicesModel(1,R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 499, "null", "null"));
        subServicesModelList2.add(new SubServicesModel(1,R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 799, "FACIAL - Fruit Cleanup by Sara4", "null"));
        subServicesModelList2.add(new SubServicesModel(1,R.drawable.ic_baseline_card_giftcard_24, "Typ2Service", 366, "null", "null"));
        subServicesModelList2.add(new SubServicesModel(1,R.drawable.ic_baseline_shopping_basket_24, "Typ2Service", 661, "del1", "null"));

        ///////////////////////////


        ///////////////////////////

         serviceModelList = new ArrayList<>();

        serviceModelList.add(new ServiceModel("Service 0", "Freedom deals | Free waxing", "*limited period offer ", subServicesModelList));
        serviceModelList.add(new ServiceModel("Service 1", "Freedom deals | Free waxing", "*limited period offer ", subServicesModelList));
        serviceModelList.add(new ServiceModel("Service 2", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList1));
        serviceModelList.add(new ServiceModel("Service 3", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList2));
        serviceModelList.add(new ServiceModel("Service 4", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList));
        serviceModelList.add(new ServiceModel("Service 5", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList1));
        serviceModelList.add(new ServiceModel("Service 6", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList2));
        serviceModelList.add(new ServiceModel("Service 7", "Freedom deals | Free waxing", "*limited period offer", subServicesModelList1));


    }

    public List<SubServicesModel> getSubServicesModelList() {
        return subServicesModelList;
    }
    public List<SubServicesModel> getSubServicesModelList1() {
        return subServicesModelList1;
    }
    public List<SubServicesModel> getSubServicesModelList2() {
        return subServicesModelList2;
    }
    public List<ServiceModel> getServiceModelList() {
        return serviceModelList;
    }



}

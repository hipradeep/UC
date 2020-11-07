package com.example.uc297.Data;

import com.example.uc297.CategoryModel;
import com.example.uc297.R;
import com.example.uc297.SubCategoryModel;
import com.example.uc297.SubServicesModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.uc297.Fragments.HomeFragment.AC_SERVICE;
import static com.example.uc297.Fragments.HomeFragment.BATHROOM_CLEANING;
import static com.example.uc297.Fragments.HomeFragment.CARPET_CLEANING;
import static com.example.uc297.Fragments.HomeFragment.GEYSER_SERVICE;
import static com.example.uc297.Fragments.HomeFragment.KITCHEN_CLEANING;
import static com.example.uc297.Fragments.HomeFragment.MEN_HAIR_CUT;
import static com.example.uc297.Fragments.HomeFragment.RO_WATER_PURIFIER;
import static com.example.uc297.Fragments.HomeFragment.SALON_AT_HOME;
import static com.example.uc297.Fragments.HomeFragment.SOFA_CLEANING;
import static com.example.uc297.Fragments.HomeFragment.WASHING_MACHINE;

public class CategoriesDataClass {
    List<CategoryModel> bannerSliderList;
    List<CategoryModel> customersViewsSliderList;
    List<CategoryModel> cleaningAndPestControlList;
    List<CategoryModel> appliancesServiceAndRepair;
    List<CategoryModel> spotlightExperienceList;
    List<SubCategoryModel> salonAtHomeSubServicesList;
    List<SubCategoryModel> menHairCutSubServicesList;
    List<SubCategoryModel> extSubServicesList;

    List<SubServicesModel> subServicesModelList;
    List<SubServicesModel> subServicesModelList1;

    public CategoriesDataClass() {
        SubServicesDataClass subServicesDataClass=new SubServicesDataClass();

        subServicesModelList=subServicesDataClass.getSubServicesModelList();
        subServicesModelList1=subServicesDataClass.getSubServicesModelList1();


        bannerSliderList=new ArrayList<>();
        bannerSliderList.add(new CategoryModel(SALON_AT_HOME, R.drawable.salon_at_home, "Salon at Home","Services allowed as per governments order" ));
        bannerSliderList.add(new CategoryModel(MEN_HAIR_CUT,R.drawable.hair_cut_1, "Hair Cut at Home","Services allowed as per governments order" ));
        bannerSliderList.add(new CategoryModel(BATHROOM_CLEANING,R.drawable.bathroom_cleaning, "Bathroom Cleaning","Services allowed as per governments order" ));
///////////////////
        customersViewsSliderList=new ArrayList<>();
        customersViewsSliderList.add(new CategoryModel(SALON_AT_HOME,R.drawable.placeholder_img, "Salon at Home","Services allowed as per governments order" ));
        customersViewsSliderList.add(new CategoryModel(MEN_HAIR_CUT,R.drawable.placeholder_img, "Hair Cut at Home","Services allowed as per governments order" ));
        customersViewsSliderList.add(new CategoryModel(BATHROOM_CLEANING,R.drawable.placeholder_img, "Bathroom Cleaning","Services allowed as per governments order" ));
///////////////////
        cleaningAndPestControlList=new ArrayList<>();
        cleaningAndPestControlList.add(new CategoryModel(BATHROOM_CLEANING,R.drawable.bathroom_cleaning, "Bathroom Cleaning","null","Services allowed as per governments order"));
        cleaningAndPestControlList.add(new CategoryModel(SOFA_CLEANING,R.drawable.sofa_cleaning,"Sofa Cleaning","null","Services allowed as per governments order"));
        cleaningAndPestControlList.add(new CategoryModel(KITCHEN_CLEANING,R.drawable.placeholder_img,"Kitchen Deep Cleaning","null","Services allowed as per governments order"));
        cleaningAndPestControlList.add(new CategoryModel(CARPET_CLEANING,R.drawable.carpet_cleaning,"Carpet Cleaning","null","Services allowed as per governments order"));
////////////////////
        appliancesServiceAndRepair=new ArrayList<>();
        appliancesServiceAndRepair.add(new CategoryModel(AC_SERVICE,R.drawable.air_conditioner_png, "AC Services and Repair", "30% off","Services allowed as per governments order"));
        appliancesServiceAndRepair.add(new CategoryModel(GEYSER_SERVICE,R.drawable.geyser, "Geyser Service", "null","Services allowed as per governments order"));
        appliancesServiceAndRepair.add(new CategoryModel(RO_WATER_PURIFIER,R.drawable.ro_png, "Water Purifier", "null","Services allowed as per governments order"));
        appliancesServiceAndRepair.add(new CategoryModel(WASHING_MACHINE,R.drawable.wahing_achine, "Washing Machine", "30% off","Services allowed as per governments order"));
///////////////////
        spotlightExperienceList=new ArrayList<>();
        spotlightExperienceList.add(new CategoryModel(SALON_AT_HOME,R.drawable.salon_at_home, "Salon at Home","Single-use tools","Services allowed as per governments order" ));
        spotlightExperienceList.add(new CategoryModel(MEN_HAIR_CUT,R.drawable.hair_cut_1, "Hair Cut at Home","Single-use tools","Services allowed as per governments order" ));
        spotlightExperienceList.add(new CategoryModel(BATHROOM_CLEANING,R.drawable.bathroom_cleaning, "Bathroom Cleaning","Single-use tools","Services allowed as per governments order" ));


////////////////////////// subServices list ////////////////// SALON AT HOME
        salonAtHomeSubServicesList=new ArrayList<>();
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Bestselling Packages","Alpha","Beta",subServicesModelList));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Make Your Packages","Alpha","Beta",subServicesModelList1));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Low_contact roll_on waxing","Alpha","Beta",subServicesModelList));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "RICE Waxing","Alpha","Beta",subServicesModelList1));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Honey Waxing","Alpha","Beta",subServicesModelList));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Facial, Cleanup, Bleach & Detan","Alpha","Beta",subServicesModelList1));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Pedicure & Manicure","Alpha","Beta",subServicesModelList));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Hair Color & Care","Alpha","Beta",subServicesModelList1));
        salonAtHomeSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Low-Contact Threading","Alpha","Beta",subServicesModelList));

////////////////////////// subServices list ////////////////// SALON AT HOME

////////////////////////// subServices list ////////////////// MEN HAIR CUT
        menHairCutSubServicesList=new ArrayList<>();
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Package Deals","Alpha","Beta",subServicesModelList));
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Make Your Packages","Alpha","Beta",subServicesModelList1));
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Hair Cut for men's and kids","Alpha","Beta",subServicesModelList));
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Shave Beard and Moustache","Alpha","Beta",subServicesModelList1));
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Head & Shoulder Massage","Alpha","Beta",subServicesModelList));
        menHairCutSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm, "Hair Color","Alpha","Beta",subServicesModelList1));
////////////////////////// subServices list ////////////////// MEN HAIR CUT


////////////////////////// subServices list ////////////////// Ext Sub Services
        extSubServicesList=new ArrayList<>();
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));
        extSubServicesList.add(new SubCategoryModel(R.drawable.subservice_thubm,"Service","alpha", "beta",null));

////////////////////////// subServices list ////////////////// Ext Sub Services





    }



   public List<CategoryModel> getBannerSliderList() {return bannerSliderList;}
   public List<CategoryModel> getCustomersViewsSliderList() {return customersViewsSliderList;}
   public List<CategoryModel> getCleaningAndPestControlList() {return cleaningAndPestControlList;}
   public List<CategoryModel> getAppliancesServiceAndRepair() {return appliancesServiceAndRepair;}
   public List<CategoryModel> getSpotlightExperienceList() {return spotlightExperienceList;}
   public List<SubCategoryModel> getSalonAtHomeSubServicesList() {return salonAtHomeSubServicesList;}
   public List<SubCategoryModel> getMenHairCutSubServicesList() {return menHairCutSubServicesList;}
   public List<SubCategoryModel> getExtSubServicesList() {return extSubServicesList;}
}

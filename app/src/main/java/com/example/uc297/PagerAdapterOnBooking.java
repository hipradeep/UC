package com.example.uc297;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.uc297.Fragments.HistoryFragment;
import com.example.uc297.Fragments.OngoingFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapterOnBooking extends FragmentPagerAdapter {
    private int tabsNumber;

    private List<Fragment> fragmentList =new ArrayList<>();
    //private List<String> titleList =new ArrayList<>();

    public PagerAdapterOnBooking(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return  fragmentList.get(position);
       /* switch (position){
            case 0:
                return new OngoingFragment();
            case 1:
                return new HistoryFragment();

            default: return null;
        }*/
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
   /* public  CharSequence getPageTitle(int position){
        return  titleList.get(position);
    }*/
    public  void addFragment(Fragment fragment){
        fragmentList.add(fragment);

    }
    /*public  void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }*/
}

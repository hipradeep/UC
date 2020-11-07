package com.example.uc297.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uc297.PagerAdapterOnBooking;
import com.example.uc297.R;
import com.google.android.material.tabs.TabLayout;

public class BoolkingLoggedInFragment extends Fragment {

    ViewPager pager;
    TabLayout mTabLayout;
    Toolbar toolbar;
    PagerAdapterOnBooking adapter;

    public BoolkingLoggedInFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_boolking_logged_in, container, false);

        pager = view.findViewById(R.id.viewpager);
        mTabLayout = view.findViewById(R.id.tablayout);

        toolbar = view.findViewById(R.id.toolbar);

       /* mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        adapter = new PagerAdapterOnBooking(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount());
        pager.setAdapter(adapter);*/

    return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(pager);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager pager) {
        PagerAdapterOnBooking adapter=new PagerAdapterOnBooking(getChildFragmentManager());

        /*adapter.addFragment(new OngoingFragment(),"Ongoing");
        adapter.addFragment(new HistoryFragment(),"History");*/

        adapter.addFragment(new OngoingFragment());
        adapter.addFragment(new HistoryFragment());
        pager.setAdapter(adapter);
    }
}
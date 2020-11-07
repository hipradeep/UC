package com.example.uc297.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uc297.LoginActivity;
import com.example.uc297.R;

import static com.example.uc297.VerifyOTPActivity.isLogin;


public class ProfileLoggedInFragment extends Fragment {
    TextView txtLogOut;

    public ProfileLoggedInFragment() {
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
       View view= inflater.inflate(R.layout.fragment_profile_logged_in, container, false);
        txtLogOut=view.findViewById(R.id.txtLogOut);
       return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLogin=false;
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.uc297;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uc297.Fragments.BookingFragment;
import com.example.uc297.Fragments.BoolkingLoggedInFragment;
import com.example.uc297.Fragments.HomeFragment;
import com.example.uc297.Fragments.ProfileFragment;
import com.example.uc297.Fragments.ProfileLoggedInFragment;
import com.example.uc297.Fragments.RewardFragment;
import com.example.uc297.Fragments.RewardLoggedInFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.uc297.VerifyOTPActivity.isLogin;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    HomeFragment account = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ProfileLoggedInFragment profileLoggedInFragment = new ProfileLoggedInFragment();
    RewardFragment rewardFragment = new RewardFragment();
    RewardLoggedInFragment rewardLoggedInFragment=new RewardLoggedInFragment();
    BookingFragment bookingFragment = new BookingFragment();
    BoolkingLoggedInFragment boolkingLoggedInFragment=new BoolkingLoggedInFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnavigationID);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        setOpenSafetyActivity();


    }

    private void setOpenSafetyActivity() {
        findViewById(R.id.safetyGuard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this, SafetyActivity.class));
                //startActivity(new Intent(MainActivity.this, SafetyActivity.class));
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, account).commit();
                return true;
            case R.id.navigation_booking:
                if (isLogin) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, boolkingLoggedInFragment).commit();

                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, bookingFragment).commit();
                }

                return true;

            case R.id.navigation_reward:
                if (isLogin){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, rewardLoggedInFragment).commit();

                }else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, rewardFragment).commit();

                }
                return true;
            case R.id.navigation_profile:
                if (isLogin) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profileLoggedInFragment).commit();

                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();

                }
                return true;
            default:
                return false;
        }


    }


}
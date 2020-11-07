package com.example.uc297;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import static com.example.uc297.VerifyOTPActivity.isLogin;

public class LoginActivity extends AppCompatActivity {
    private  String countryCode ;
    BottomSheetBehavior logInSheetBehavior;
    private ImageView pickFlag;
    private TextView pickCountryCode,testLogin;
    private TextView enterMobileNumber;
    private View logInBottomSheet;
    private View bottomSheetContainer;
    private EditText mobileNumber;
    private Button btnLoginSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pickFlag = findViewById(R.id.pickFlag);
        pickCountryCode = findViewById(R.id.pickCountryCode);
        mobileNumber = findViewById(R.id.etMobileNumber);

        logInBottomSheet = (View) findViewById(R.id.logInDetailsBottomSheet);
        btnLoginSignUp = findViewById(R.id.btnLoginSignUp);
        testLogin=findViewById(R.id.testLogin);


        pickCountryCode.setText("+91");
        countryCode = pickCountryCode.getText().toString();

        logInSheetBehavior = BottomSheetBehavior.from(logInBottomSheet);
        logInSheetBehavior.setPeekHeight(0);
        logInSheetBehavior.setHideable(true);

        checkInputForMobileNumber();

        testLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               isLogin=true;
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });
        btnLoginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mobile = mobileNumber.getText().toString();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + mobile,
                        60,
                        TimeUnit.SECONDS,
                        LoginActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationCode, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                Intent intent = new Intent(LoginActivity.this, VerifyOTPActivity.class);
                                intent.putExtra("country_code", countryCode);
                                intent.putExtra("mobile_number", mobile);
                                intent.putExtra("verificationCode", verificationCode);
                                startActivity(intent);
                            }
                        }
                );

            }
        });


    }

    private void checkInputForMobileNumber() {
        mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!TextUtils.isEmpty(mobileNumber.getText()) && mobileNumber.length() == 10) {

                    btnLoginSignUp.setVisibility(View.VISIBLE);
                    btnLoginSignUp.setTextColor(Color.rgb(255, 255, 255));

                } else {
                    btnLoginSignUp.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    public void skipButton(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void setUAEFlagCode(View view) {
        pickFlag.setImageResource(R.drawable.uae_flag);
        pickCountryCode.setText("+971");
        countryCode = pickCountryCode.getText().toString();
        logInSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void setSingapurFlagCode(View view) {
        pickFlag.setImageResource(R.drawable.singapur_flag);
        pickCountryCode.setText("+65");
        countryCode = pickCountryCode.getText().toString();

        logInSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void setAustraliaFlagCode(View view) {
        pickFlag.setImageResource(R.drawable.australia_flag);
        pickCountryCode.setText("+61");
        countryCode = pickCountryCode.getText().toString();
        logInSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void setIndiaFlagCode(View view) {
        pickFlag.setImageResource(R.drawable.ind_flag);
        pickCountryCode.setText("+91");
        countryCode = pickCountryCode.getText().toString();
        logInSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }

    public void selectCountry(View view) {
        logInSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetContainer = findViewById(R.id.bottomSheetContainer);

        // bottomSheetContainer.setBackgroundColor(Color.r);
    }

    public void bottomSheetContainer(View view) {
        logInSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}
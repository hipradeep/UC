package com.example.uc297;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class VerifyOTPActivity extends AppCompatActivity {
    static String country_code, mobile_number;
    static String verificationCode;
    private EditText etOTP1, etOTP2, etOTP3, etOTP4, etOTP5, etOTP6;
    private TextView txtInvalid;
    private Button btnRetry;
    public static boolean isLogin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);
        Toolbar toolbar = findViewById(R.id.toolbar_otp);

        TextView txtCountryCode = findViewById(R.id.txtCuntryCode);
        TextView txtMobileNumber = findViewById(R.id.txtMobileNumber);
        txtInvalid = findViewById(R.id.txtInvalid);
        btnRetry = findViewById(R.id.btnRetry);


        etOTP1 = findViewById(R.id.etOTP1);
        etOTP2 = findViewById(R.id.etOTP2);
        etOTP3 = findViewById(R.id.etOTP3);
        etOTP4 = findViewById(R.id.etOTP4);
        etOTP5 = findViewById(R.id.etOTP5);
        etOTP6 = findViewById(R.id.etOTP6);


        toolbar.setTitle("Login / SignUp");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTextWatcher();

        country_code = getIntent().getStringExtra("country_code");
        mobile_number = getIntent().getStringExtra("mobile_number");
        verificationCode = getIntent().getStringExtra("verificationCode");

        txtCountryCode.setText(country_code);
        txtMobileNumber.setText(mobile_number);

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }


    private void setTextWatcher() {

        etOTP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    etOTP2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    etOTP3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    etOTP4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    etOTP5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    etOTP6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                verifyOtp();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void verifyOtp() {

        String code = etOTP1.getText().toString()
                + etOTP2.getText().toString()
                + etOTP3.getText().toString()
                + etOTP4.getText().toString()
                + etOTP5.getText().toString()
                + etOTP6.getText().toString();

        if (verificationCode != null) {
            PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationCode, code);
            FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                isLogin=true;
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            } else {
                                txtInvalid.setVisibility(View.VISIBLE);
                                btnRetry.setVisibility(View.VISIBLE);
                            }
                        }
                    });
        }

    }
}
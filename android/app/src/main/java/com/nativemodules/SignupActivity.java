package com.nativemodules;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    public static final String TAG = SignupActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        EditText etSignupEmail = findViewById(R.id.etSignupEmail);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        EditText etUsername = findViewById(R.id.etSignupUsername);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        EditText etPassword = findViewById(R.id.etSignupPassword);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etSignupEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                Log.i(TAG, "btnSignup onClick, username: " + username + "\npassword: " + password + "\nemail: " + email);

            }
        });

    }
}
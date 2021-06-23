package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buspass.modelresponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText email, pass;
    Button btn_login;
    TextView tv1;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        tv1 =findViewById(R.id.logitext);
        btn_login =findViewById(R.id.btn_login);


        btn_login.setOnClickListener(this);
        tv1.setOnClickListener(this);

        sharedPrefManager = new SharedPrefManager(getApplicationContext());
    }

    private void userlogin() {

        String useremail = email.getText().toString();
        String userpass = pass.getText().toString();


        if(useremail.isEmpty())
        {
            email.requestFocus();
            email.setError("Please Enter Your Email");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches())

        {
            email.requestFocus();
            email.setError("Please Enter correct Email");
            return;
        }

        if(userpass.isEmpty())
        {
            pass.requestFocus();
            pass.setError("Please Enter Your Password");
            return;
        }

        if(userpass.length() <8)
        {
            pass.requestFocus();
            pass.setError("Please Enter Your Password Greater Than 8");
            return;
        }

        Call<LoginResponse> call= retrofitclient
                                .getInstance()
                                .getApi().
                                login(useremail,userpass);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()){

                    if (loginResponse.getError().equals("200"))
                    {
                        sharedPrefManager.saveUser(loginResponse.getUser());

                    if (loginResponse.getMessage().equals("login success")){
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        Toast.makeText(Login.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    }
                    else {
                        Toast.makeText(Login.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_login:

                userlogin();

                break;

            case  R.id.logitext:

                switchonRegister();

                break;

        }

    }

    private void switchonRegister() {

        Intent i =new Intent(Login.this,Register.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sharedPrefManager.isLoggedIn()) {

            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }
    }
}
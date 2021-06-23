package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buspass.modelresponse.RegisterResponse;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements View.OnClickListener  {
    EditText name,email,pass,confirm_pass,contact,city,state,address;
    TextView tv2;
    Button reg;
    RadioGroup rg;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = findViewById(R.id.names);
        email =findViewById(R.id.emails);
        pass = findViewById(R.id.passs);
        confirm_pass = findViewById(R.id.confirm_passs);
        rg=findViewById(R.id.radioGroup);
        tv2 =findViewById(R.id.regitext);
        contact = findViewById(R.id.contact);
        address =findViewById(R.id.address);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        reg = findViewById(R.id.btn_reg);

        tv2.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    private void registeruser() {

        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String userpass = pass.getText().toString();
        String userconpass = confirm_pass.getText().toString();
        int radioid= rg.getCheckedRadioButtonId();
        radioButton=findViewById(radioid);
        String usergender = radioButton.getText().toString();
        String usercontact= contact.getText().toString();
        String useradd = address.getText().toString();
        String usercity = city.getText().toString();
        String userstate = state.getText().toString();

        if(username.isEmpty())
        {
            name.requestFocus();
            name.setError("Please Enter Your Name");
            return;
        }

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

        if(userconpass.isEmpty())
        {
            confirm_pass.requestFocus();
            confirm_pass.setError("Please Enter Your Conform Password");
            return;
        }

        if(!userconpass.equals(userpass))
        {
            confirm_pass.requestFocus();
            confirm_pass.setError("Please Enter Same Password");
            return;
        }

        if(usercontact.isEmpty())
        {
            contact.requestFocus();
            contact.setError("Please Enter Your Contact No");
            return;
        }

        if(useradd.isEmpty())
        {
            address.requestFocus();
            address.setError("Please Enter Your Address");
            return;
        }

        if(usercity.isEmpty())
        {
            city.requestFocus();
            city.setError("Please Enter Your City");
            return;
        }

        if(userstate.isEmpty())
        {
            state.requestFocus();
            state.setError("Please Enter Your State");
            return;
        }

        Call<RegisterResponse> call=retrofitclient
            .getInstance()
            .getApi()
            .register(username,useremail,userpass,userconpass,usergender,usercontact,useradd,usercity,userstate);

        call.enqueue(new Callback<RegisterResponse>() {
        @Override
        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

            RegisterResponse registerResponse=response.body();

            if (response.isSuccessful()){
                Toast.makeText(Register.this,registerResponse.getMessage(),Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Register.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<RegisterResponse> call, Throwable t) {

            Toast.makeText(Register.this,t.getMessage(),Toast.LENGTH_SHORT).show();
        }
    });
}

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_reg:

                registeruser();

                break;

            case R.id.regitext:

                switchonlogin();

                break;

        }

    }

    private void switchonlogin() {

        Intent i =new Intent(Register.this,Login.class);
        startActivity(i);
    }
}

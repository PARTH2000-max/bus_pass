package com.example.buspass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class header_act extends AppCompatActivity {
   
    TextView tv1,tv2;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

            tv1=findViewById(R.id.et1);
            tv2=findViewById(R.id.et2);

            sharedPrefManager = new SharedPrefManager(getApplication());

            String username="Hey " + sharedPrefManager.getUser().getUsername();
            tv1.setText(username);
            tv2.setText(sharedPrefManager.getUser().getEmail());

    }

}
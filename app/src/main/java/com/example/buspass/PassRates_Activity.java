package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PassRates_Activity extends AppCompatActivity {

    private RecyclerView rcPassList;
    private ArrayList<PassRate_Model> Passrate_model_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_rates);

        rcPassList = findViewById(R.id.RCPassRates);

        Passrate_model_list = new ArrayList<PassRate_Model>();


        Passrate_model_list.add(new PassRate_Model("AMTS",R.drawable.bg_image));


    }
}
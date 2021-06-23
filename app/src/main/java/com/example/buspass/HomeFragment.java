package com.example.buspass;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

   /* TextView tv;
    EditText ed;
    String url = "https://deponent-necks.000webhostapp.com/";

    */

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

       /* tv=view.findViewById(R.id.tv);

        tv.setText("");
        process();
*/
    }


   /* public void process()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi_2 api=retrofit.create(myapi_2.class);

        Call<List<model_2>> call=api.getmodels();

        call.enqueue(new Callback<List<model_2>>() {
            @Override
            public void onResponse(Call<List<model_2>> call, Response<List<model_2>> response) {
                List<model_2> data=response.body();
                for(int i=0; i<data.size();i++)
                    tv.append(" Company:"+data.get(i).getCompany()+" \n Model :"+data.get(i).getModel()+
                                    " \n Variant :"+data.get(i).getVariant()+" \n Year :"+data.get(i).getYear()+
                                    " \n Color :"+data.get(i).getColor()+ " \n kmDriven :"+data.get(i).getKmdriven()+
                                    " \n Owner :"+data.get(i).getOwner()+" \n State :"+data.get(i).getState() +
                                    " \n City :"+data.get(i).getCity()+" \n Price :"+data.get(i).getPrice()+
                                    " \n Description :"+data.get(i).getDescription() + "\n\n\n");
            }

            @Override
            public void onFailure(Call<List<model_2>> call, Throwable t) {

        }

    });
}
*/
}


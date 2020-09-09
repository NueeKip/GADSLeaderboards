package com.example.leaderboard.submit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leaderboard.R;
import com.example.leaderboard.iq.IqResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Submit extends AppCompatActivity {

    String name,lastName,email,gitUrl;
    EditText e1,e2,e3,e4;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        e1 = findViewById(R.id.firstName);
        e2 = findViewById(R.id.secondName);
        e3 = findViewById(R.id.emailAddress);
        e4 = findViewById(R.id.githubUrl);

        findViewById(R.id.response).setOnClickListener(view -> {PostData(
        e1.getText().toString(),
            e2.getText().toString(),
            e3.getText().toString(),
            e4.getText().toString()
        );
        });



    }

    public void PostData(String name,String lastName, String email,String gitUrl) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://docs.google.com/forms/d/e")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        SubmitService submitService = retrofit.create(SubmitService.class);


        //DataSet dataSet = new DataSet(name,lastName,email,gitUrl);
        //Call<DataSet> call = submitService.PostData(dataSet);

        Call<DataSet> call = submitService.PostData(
                name,
                lastName,
                email,
                gitUrl
        );



        call.enqueue(new Callback<DataSet>() {
            @Override
            public void onResponse(Call<DataSet> call, Response<DataSet> response) {

                if(response.isSuccessful()){
                    Toast.makeText(Submit.this,"Sucess", Toast.LENGTH_SHORT).show();

                    Log.e("Sucess",response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<DataSet> call, Throwable t) {
                Toast.makeText(Submit.this,"Sucess", Toast.LENGTH_SHORT).show();
                Log.e("Failed",t.getLocalizedMessage());

            }
        });








    }

//    public Drawable getBackground() {
//        return findViewById(R.layout.sucess);
//    }
}
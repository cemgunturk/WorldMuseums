package com.example.worldmuseums;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView museumName, countryName;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initialize();
        catchInfo();
    }

    public void initialize(){
        museumName = findViewById(R.id.museumNameText);
        countryName = findViewById(R.id.countryNameText);
        image = findViewById(R.id.imageView);
    }

    public void catchInfo(){
        Bundle intent = getIntent().getExtras();
        String comeName = intent.getString("museumName");
        String comaCountryName = intent.getString("countryName");
        museumName.setText(comeName);
        countryName.setText(comaCountryName);
        Singleton singleton = Singleton.getInstance();
        image.setImageBitmap(singleton.getChosenImage());
    }
}

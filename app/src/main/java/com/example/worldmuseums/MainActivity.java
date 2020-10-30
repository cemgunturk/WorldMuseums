package com.example.worldmuseums;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.nio.FloatBuffer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> museumsNames;
    ArrayList<String> countryNames;
    ArrayList<Bitmap> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        museumsName();
        countryName();
        adapterMethod();
        museumsImages();
        listen();
    }

    public void initialize(){
        listView = findViewById(R.id.listView);
    }
    public void museumsName(){
        museumsNames = new ArrayList<>();
        museumsNames.add("Louvre Museum");
        museumsNames.add("British Museum");
        museumsNames.add("China Nationality Museum");
        museumsNames.add("Vatican Museum");
        museumsNames.add("Prado Museum");
        museumsNames.add("Topkapı Palace Museum");
    }
    public void countryName(){
        countryNames = new ArrayList<>();
        countryNames.add("France");
        countryNames.add("United States");
        countryNames.add("China");
        countryNames.add("Vatican");
        countryNames.add("Spain");
        countryNames.add("Türkiye");
    }
    public void adapterMethod(){
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,museumsNames);
        listView.setAdapter(arrayAdapter);
    }

    public void museumsImages(){
        images = new ArrayList<>();
        Bitmap louvre = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.louvre);
        Bitmap british = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.british);
        Bitmap china = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.china);
        Bitmap vatican = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.vatikan);
        Bitmap prado = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.prado);
        Bitmap topkapi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.topkapi);
        images.add(louvre);
        images.add(british);
        images.add(china);
        images.add(vatican);
        images.add(prado);
        images.add(topkapi);
    }
    public void listen(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.i("degerler",museumsNames.get(position)); değerlerim düzgün bir şekilde geliyor.
                //Log.i("ulkeler",countryNames.get(position));

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("museumName",museumsNames.get(position));
                intent.putExtra("countryName",countryNames.get(position));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(images.get(position));
                startActivity(intent);
            }
        });
    }

}

package com.example.prak4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewHero;
    private ArrayList<Hero> heroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroes.addAll(DataHero.getListDetail());
        AdapterHero adapterHero = new AdapterHero(heroes);

        mRecyclerViewHero = findViewById(R.id.recycle_hero);
        mRecyclerViewHero.setHasFixedSize(true);
        mRecyclerViewHero.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewHero.setAdapter(adapterHero);

        adapterHero.setOnItemClickCallback(new AdapterHero.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero hero) {
                Toast.makeText(MainActivity.this, "Memilih "+ hero.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_DATA, hero);
                startActivity(intent);
            }
        });
    }
}

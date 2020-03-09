package com.example.prak4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.ListViewHolder> {

    private ArrayList<Hero> heroes;
    private OnItemClickCallback onItemClickCallback;




    public AdapterHero(ArrayList<Hero> list) {
        this.heroes = list;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heroes_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getImage())
                .apply(new RequestOptions().override(300, 300))
                .into(holder.heroImage);

        holder.heroName.setText(hero.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(heroes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView heroImage;
        TextView heroName, heroDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            heroImage   = itemView.findViewById(R.id.hero_image);
            heroName    = itemView.findViewById(R.id.hero_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Hero hero);
    }
}

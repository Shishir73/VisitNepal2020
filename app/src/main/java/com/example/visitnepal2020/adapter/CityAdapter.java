package com.example.visitnepal2020.adapter;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.ExploreFragment;
import com.example.visitnepal2020.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityHolder> {

    private List<City> _cities = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout_citylist, viewGroup, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder viewHolder, int i) {
        Log.d("ONBINDVIEWHOLDER", "SETTING CITY NAME AND GIVING THEM THEIR PICTURE!!");

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        viewHolder.name.setText(_cities.get(i).getName());
//        Glide.with().load(_cities.get(i).getImage())
//                .apply(requestOptions)
//                .into(viewHolder.image);
        Picasso.get().load(_cities.get(i).getImage())
                .resize(500, 500)
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return _cities.size();
    }

    public void insertCities(List<City> cities) {
        this._cities = cities;
        notifyDataSetChanged();
    }

    class CityHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;

        CityHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv2);
            image = itemView.findViewById(R.id.bktp);
        }
    }
}

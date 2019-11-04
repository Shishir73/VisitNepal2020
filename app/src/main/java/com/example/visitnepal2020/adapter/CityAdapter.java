package com.example.visitnepal2020.adapter;

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
import com.example.visitnepal2020.R;
import com.example.visitnepal2020.Database.City;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private ArrayList<City> _cities;
    final private OnListItemClickListener _OnListItemClickListener;
    private Context context;


    public CityAdapter(ArrayList<City> cities, OnListItemClickListener listener, Context context) {
        _cities = cities;
        _OnListItemClickListener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout_citylist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Log.d("ONBINDVIEWHOLDER", "CALLED");

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        viewHolder.name.setText(_cities.get(i).getName());
        Picasso.get().load(_cities.get(i).getImage()).into(viewHolder.image);
//        Glide.with(context).load(_cities.get(i).getImage())
//                .apply(requestOptions)
//                .into(viewHolder.image);

//        viewHolder.image.setImageURI(_cities.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return _cities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv2);
            image = itemView.findViewById(R.id.bktp);
            itemView.setOnClickListener(this);

        }

        public void onClick(View v) {
            _OnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}

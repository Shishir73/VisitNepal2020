package com.example.visitnepal2020;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.ViewModel.Viewmodel;
import com.example.visitnepal2020.adapter.CityAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ExploreFragment extends Fragment {

    private static final int NUM_COLUMNS = 2;
    private RecyclerView _cityView;
    private Viewmodel viewmodel;
    private CityAdapter cityAdapter;
    private FloatingActionButton buttonAddCity;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_explore, container, false);
        cityAdapter = new CityAdapter();

        _cityView = v.findViewById(R.id.rv);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayout.VERTICAL);
        _cityView.setLayoutManager(sglm);
        _cityView.hasFixedSize();

        _cityView.setAdapter(cityAdapter);

        viewmodel = ViewModelProviders.of(this).get(Viewmodel.class);
        viewmodel.getAllCities().observe(this, new Observer<List<City>>() {
            @Override
            public void onChanged(List<City> cities) {
                cityAdapter.insertCities(cities);
            }
        });

        //region FLOATING BUTTON
        buttonAddCity = v.findViewById(R.id.button_add_city);
        buttonAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewmodel.insert(new City(
                         "Namche Bazar",
                         "https://www.we12travel.com/blog/wp-content/uploads/2016/04/namche-view.jpg"
                ));
                viewmodel.insert(new City(
                        "Illam",
                        "https://traveldiarynepal.com/wp-content/uploads/2019/03/illam-700x410.jpg"
                ));

                Snackbar.make(v.findViewById(R.id.explore_frag), "Added new city.", Snackbar.LENGTH_SHORT).show();
                cityAdapter.notifyDataSetChanged();
            }
        });
        //endregion

        return v;
    }

}

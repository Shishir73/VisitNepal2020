package com.example.visitnepal2020.NavBar;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.visitnepal2020.R;
import com.example.visitnepal2020.adapter.CityAdapter;
import com.example.visitnepal2020.Database.City;

import java.util.ArrayList;

public class ExploreFragment extends Fragment implements CityAdapter.OnListItemClickListener {

    private static final int NUM_COLUMNS = 2;
    private RecyclerView _cityList;
    private RecyclerView.Adapter _cityAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_explore, container, false);

        ArrayList<City> _cities = new ArrayList<>();
        _cities.add(new City("Kathmandu", "https://visitnepal2020.com/images/exp-dance.jpg"));
        _cities.add(new City("Bhaktapur", "https://visitnepal2020.com/images/exp-craft.jpg"));
        _cities.add(new City("Pokhara", "https://visitnepal2020.com/images/exp-adventure.jpg"));
        _cities.add(new City("Chitwan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTd7j7-2CiMIiixKlDlu3SLB3NrjKzV8A1T08Zd91j8Pjlsxg8cIw&s"));
        _cities.add(new City("swayambhunath", "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fspecials-images.forbesimg.com%2Fdam%2Fimageserve%2F1161006287%2F960x0.jpg%3Ffit%3Dscale"));
        _cities.add(new City("Ghandruk", "https://tmmnepal.com/images/package-thumbnails/2019042507-mWxdOA.jpg"));
        _cities.add(new City("Syangja", "https://sworektapu.weebly.com/uploads/2/8/1/4/28142499/4667002_orig.jpg"));
        _cities.add(new City("Mt. Everest", "https://s26626.pcdn.co/wp-content/uploads/2019/03/safety-nepal.jpg.optimal.jpg"));


        _cityList = v.findViewById(R.id.rv);
        _cityList.setHasFixedSize(true);

        _cityAdapter = new CityAdapter(_cities, this, getContext());
        _cityList.setAdapter(_cityAdapter);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayout.VERTICAL);
        _cityList.setLayoutManager(sglm);

        return v;
    }

    public void onListItemClick(int clickedItemIndex) {
//        int cityNum = clickedItemIndex + 1;

    }
}

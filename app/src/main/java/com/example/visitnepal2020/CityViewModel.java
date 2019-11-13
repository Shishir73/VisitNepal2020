package com.example.visitnepal2020;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CityViewModel extends AndroidViewModel {

    private CityRepository repository;

    public CityViewModel(Application app) {
        super(app);
        repository = CityRepository.getInstance(app);
    }

    public LiveData<List<City>> getAllCities() {
        return repository.getAllCities();
    }

    public void insert(City city) {
        repository.insert(city);
    }

    public void deleteAllCities()  {
        repository.deleteAllCities();
    }
}

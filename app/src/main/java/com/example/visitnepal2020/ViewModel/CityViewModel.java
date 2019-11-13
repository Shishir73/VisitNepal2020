package com.example.visitnepal2020.ViewModel;

import android.app.Application;

import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.Repository.CityRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CityViewModel extends AndroidViewModel {
    public CityRepository repository;

    private CityViewModel(Application app) {
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

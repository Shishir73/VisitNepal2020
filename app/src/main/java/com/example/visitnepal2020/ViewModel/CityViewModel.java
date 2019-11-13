package com.example.visitnepal2020.ViewModel;

import android.app.Application;

import com.example.visitnepal2020.Repository.CityRepository;
import com.example.visitnepal2020.Database.City;

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

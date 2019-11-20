package com.example.visitnepal2020.ViewModel;

import android.app.Application;

import com.example.visitnepal2020.Repository.Repository;
import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.Retrofit.Bored;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class Viewmodel extends AndroidViewModel {

    private Repository repository;

    public Viewmodel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    //region GETTING CITIES

    public LiveData<List<City>> getAllCities() {
        return repository.getAllCities();
    }

    public void insert(City city) {
        repository.insert(city);
    }

    public void deleteAllCities()  {
        repository.deleteAllCities();
    }

    //endregion

    //region DATA FROM BORED API

    public LiveData<Bored> getActivity() {
        return repository.getActivity();
    }

    public void updateActivity() {
        repository.updateActivity();
    }

    //endregion
}

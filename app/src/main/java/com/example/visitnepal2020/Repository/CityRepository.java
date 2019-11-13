package com.example.visitnepal2020.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.Database.CityDao;
import com.example.visitnepal2020.Database.CityDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;

public class CityRepository {
    private CityDao cityDao;
    private static CityRepository instance;
    private LiveData<List<City>> allCities;

    public CityRepository(Application application) {
        CityDatabase database = CityDatabase.getInstance(application);
        cityDao = database.cityDao();
        allCities = cityDao.getAllCities();
    }

    public static synchronized CityRepository getInstance(Application app) {
        if (instance == null){
            instance = new CityRepository(app);
        }
        return instance;
    }

    public void insert(City city) {
        new InsertCityAsync(cityDao).execute(city);
    }

    public void deleteAllCities() {
        new DeleteAllCityAsync(cityDao).execute();
    }

    public LiveData<List<City>> getAllCities() {
        return allCities;
    }

    private static class InsertCityAsync extends AsyncTask<City, Void, Void> {
        private CityDao cityDao;

        private InsertCityAsync(CityDao cityDao) {
            this.cityDao = cityDao;
        }

        @Override
        protected Void doInBackground(City... cities) {
            cityDao.insert(cities[0]);
            return null;
        }
    }

    private static class DeleteAllCityAsync extends AsyncTask<Void, Void, Void>  {
        private CityDao cityDao;

        private DeleteAllCityAsync(CityDao cityDao) {
            this.cityDao = cityDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            cityDao.deleteAllNotes();
            return null;
        }
    }
}
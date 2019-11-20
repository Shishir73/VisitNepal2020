package com.example.visitnepal2020.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.visitnepal2020.Database.City;
import com.example.visitnepal2020.Database.CityDao;
import com.example.visitnepal2020.Database.CityDatabase;
import com.example.visitnepal2020.Retrofit.Bored;
import com.example.visitnepal2020.Retrofit.BoredApi;
import com.example.visitnepal2020.Retrofit.BoringResponse;
import com.example.visitnepal2020.Retrofit.ServiceGenerator;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private CityDao cityDao;
    private static Repository instance;
    private LiveData<List<City>> allCities;
    private MutableLiveData<Bored> bored;

    private Repository(Application application) {
        CityDatabase database = CityDatabase.getInstance(application);
        cityDao = database.cityDao();
        allCities = cityDao.getAllCities();
        bored = new MutableLiveData<>();
    }

    public static synchronized Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }

    //region CITY VIEW DATABASE
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

    private static class DeleteAllCityAsync extends AsyncTask<Void, Void, Void> {
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

    //endregion

    //region GETTING DATA FROM BORED API

    public LiveData<Bored> getActivity() {
        return bored;
    }

    public void updateActivity() {
        BoredApi boredApi = ServiceGenerator.getBoredApi();
        Call<BoringResponse> call = boredApi.getActivity();
        call.enqueue(new Callback<BoringResponse>() {
            @Override
            public void onResponse(Call<BoringResponse> call, Response<BoringResponse> response) {
                if (response.code() == 200) {
                    bored.setValue(response.body().getBoring()); //Updating LiveData
                }
            }
            @Override
            public void onFailure(Call<BoringResponse> call, Throwable t) {
                Log.i("Retrofit - REPOSITORY", " Something went wrong :( ");
            }
        });
    }

    //endregion
}
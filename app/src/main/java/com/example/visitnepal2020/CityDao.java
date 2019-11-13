package com.example.visitnepal2020;

import com.example.visitnepal2020.City;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

public interface CityDao {

    @Insert
    void insert(City cities);

    @Query("DELETE FROM city_table")
    void deleteAllNotes();

    @Query("SELECT * FROM city_table")
    LiveData<List<City>> getAllCities();
}

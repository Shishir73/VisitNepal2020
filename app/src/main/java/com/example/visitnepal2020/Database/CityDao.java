package com.example.visitnepal2020.Database;

import java.util.ArrayList;
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

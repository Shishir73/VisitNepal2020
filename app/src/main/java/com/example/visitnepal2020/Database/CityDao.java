package com.example.visitnepal2020.Database;

import androidx.room.Insert;

public interface CityDao {

    @Insert
    void insert(City note);

}

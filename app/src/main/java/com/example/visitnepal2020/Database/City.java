package com.example.visitnepal2020.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "city_table")
public class City {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String image;

    public City(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

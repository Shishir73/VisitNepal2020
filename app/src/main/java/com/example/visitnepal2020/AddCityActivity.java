package com.example.visitnepal2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddCityActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        editTextName = findViewById(R.id.city_txt);
        editTextUrl = findViewById(R.id.city_url);
    }
}

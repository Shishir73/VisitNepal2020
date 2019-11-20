package com.example.visitnepal2020.Retrofit;

public class BoringResponse {
    private int key;
    private String activity;

    public Bored getBoring() {
        return new Bored(key, activity);
    }
}

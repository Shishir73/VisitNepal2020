package com.example.visitnepal2020.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BoredApi {

    @GET("api/activity/")
    Call<BoringResponse> getActivity();
}

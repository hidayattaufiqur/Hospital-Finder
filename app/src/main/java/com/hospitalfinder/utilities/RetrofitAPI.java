package com.hospitalfinder.utilities;

import com.hospitalfinder.model.DirectionModel.DirectionResponseModel;
import com.hospitalfinder.model.PlaceModel.GoogleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {

    @GET
    Call<GoogleResponse> getNearByPlaces(@Url String url);

    @GET
    Call<DirectionResponseModel> getDirection(@Url String url);
}

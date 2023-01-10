package com.hospitalfinder.model.PlaceModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hospitalfinder.model.PlaceModel.LocationModel;

public class GeometryModel {

    @SerializedName("location")
    @Expose
    private LocationModel location;


    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

}
package com.example.doctorsapp.response;

import com.example.doctorsapp.model.CityDetails;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityListResponse {
    @SerializedName("city")
    private List<CityDetails> cityDetails;

    public List<CityDetails> getCityDetails() {
        return cityDetails;
    }
}

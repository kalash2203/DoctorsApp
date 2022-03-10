package com.example.doctorsapp.response;

import com.example.doctorsapp.model.DoctorDetails;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorInfoResponse {
    @SerializedName("data")
    private List<DoctorDetails> doctorDetails;
    @SerializedName("total")
    private int total;

    public List<DoctorDetails> getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(List<DoctorDetails> doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

package com.example.doctorsapp.api;

import com.example.doctorsapp.model.loginBody;
import com.example.doctorsapp.response.BookingRequestResponse;
import com.example.doctorsapp.response.CityListResponse;
import com.example.doctorsapp.response.DoctorInfoResponse;
import com.example.doctorsapp.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("login")
    //commit 2
    Call<LoginResponse> login(@Body String body);

    @Headers("Content-Type: application/json")
    @GET("cityList")
    Call<CityListResponse> cityList();

    @Headers("Content-Type: application/json")
    @POST("doctorList")
    Call<DoctorInfoResponse> doctorInfo(@Query ("pageNum") int pageSize, @Body String body);

    @Headers("Content-Type: application/json")
    @POST("sendBookingRequest")
    Call<BookingRequestResponse> bookingRequest(@Body String body);
}

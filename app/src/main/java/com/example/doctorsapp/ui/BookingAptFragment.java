package com.example.doctorsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doctorsapp.R;
import com.example.doctorsapp.api.ApiClient;
import com.example.doctorsapp.databinding.FragmentBookingAptBinding;
import com.example.doctorsapp.databinding.FragmentDoctorListBinding;
import com.example.doctorsapp.response.BookingRequestResponse;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BookingAptFragment extends BaseFragment implements View.OnClickListener{
    private FragmentBookingAptBinding binding;
    String patientGender;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBookingAptBinding.inflate(getLayoutInflater(),container,false);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        binding.bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    JSONObject paramObject = new JSONObject();
                    paramObject.put("patientName","S");
                    paramObject.put("patientPhone","8448569131");
                    paramObject.put("patientAge","24");
                    paramObject.put("patientAddress","Mars");
                    paramObject.put("patientGender","M");
                    paramObject.put("docName","docnameforwhichbookbuttonisclicked");
                    paramObject.put("docId","docidforwhichbookbuttonisclicked");

                    Call<BookingRequestResponse> call = ApiClient.getApiClient().getApiInterface().bookingRequest(paramObject.toString());
                    call.enqueue(new Callback<BookingRequestResponse>() {
                        @Override
                        public void onResponse(@NonNull Call<BookingRequestResponse> call, @NonNull Response<BookingRequestResponse> response) {
                            if (response.isSuccessful()){
                                assert response.body() != null;
                                if (response.body().getAppointmentId().equals("originallyitwouldbesomerandomid")){
                                    Toast.makeText(getContext(),"Slot Booked Successfully",Toast.LENGTH_SHORT).show();
                                    Toast.makeText(getContext(),"Details will be shared to your phone number",Toast.LENGTH_SHORT).show();
                                }
                            }

                        }

                        @Override
                        public void onFailure(@NonNull Call<BookingRequestResponse> call, @NonNull Throwable t) {
                            Log.e("BookingDetails",""+t.getMessage());
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

        binding.genderFemale.setOnClickListener(this::onClick);
       binding.genderOther.setOnClickListener(this::onClick);
        binding.genderFemale.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.gender_male)
            patientGender="M";
        else if(v.getId()==R.id.gender_female)
            patientGender="F";
        else if(v.getId()==R.id.gender_other)
            patientGender="O";
    }
}
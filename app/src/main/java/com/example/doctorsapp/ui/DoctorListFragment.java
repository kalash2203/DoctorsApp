package com.example.doctorsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doctorsapp.Adapters.DoctorListAdapter;
import com.example.doctorsapp.R;
import com.example.doctorsapp.api.ApiClient;
import com.example.doctorsapp.databinding.FragmentDoctorListBinding;
import com.example.doctorsapp.model.DoctorDetails;
import com.example.doctorsapp.response.DoctorInfoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DoctorListFragment extends BaseFragment {
    private FragmentDoctorListBinding binding;
    private ArrayList<DoctorDetails> doctorList=new ArrayList<>();
    private DoctorListAdapter doctorListAdapter;
    private RecyclerView doctorRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDoctorListBinding.inflate(getLayoutInflater(),container,false);
        doctorListAdapter=new DoctorListAdapter(getActivity(),getContext(),doctorList);
        binding.doctorListRecycler.setAdapter(doctorListAdapter);
        binding.doctorListRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        Call<DoctorInfoResponse> call = ApiClient.getApiClient().getApiInterface().doctorInfo(1,"");
        call.enqueue(new Callback<DoctorInfoResponse>() {
            @Override
            public void onResponse(@NonNull Call<DoctorInfoResponse> call, @NonNull Response<DoctorInfoResponse> response) {
                if(response.body()!=null)
                {

                }

            }

            @Override
            public void onFailure(@NonNull Call<DoctorInfoResponse> call, @NonNull Throwable t) {
                Log.e("LoginDetails", "" + t.getMessage());
            }
        });

    }
}
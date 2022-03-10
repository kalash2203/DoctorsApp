package com.example.doctorsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.doctorsapp.Adapters.CityListAdapter;
import com.example.doctorsapp.R;
import com.example.doctorsapp.api.ApiClient;
import com.example.doctorsapp.databinding.FragmentDoctorListBinding;
import com.example.doctorsapp.databinding.FragmentGetCityBinding;
import com.example.doctorsapp.model.CityDetails;
import com.example.doctorsapp.response.CityListResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCityFragment extends BaseFragment {
    private FragmentGetCityBinding binding;
    private ArrayList<CityDetails> cityList=new ArrayList<>();
    private CityListAdapter cityListAdapter;
    private RecyclerView cityRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGetCityBinding.inflate(getLayoutInflater(),container,false);
        cityListAdapter=new CityListAdapter(getContext(),cityList,getActivity());
        binding.cityListRecycler.setAdapter(cityListAdapter);
        binding.cityListRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();




                    Call<CityListResponse> call = ApiClient.getApiClient().getApiInterface().cityList();
                    call.enqueue(new Callback<CityListResponse>() {
                        @Override
                        public void onResponse(@NonNull Call<CityListResponse> call, @NonNull Response<CityListResponse> response) {
                            if (response.isSuccessful()){
                                assert response.body() != null;
                                if (response.body()!=null){
                                    cityList= (ArrayList<CityDetails>) response.body().getCityDetails();
                                    cityListAdapter.notifyDataSetChanged();
                                }
                            }

                        }

                        @Override
                        public void onFailure(@NonNull Call<CityListResponse> call, @NonNull Throwable t) {
                            Log.e("LoginDetails",""+t.getMessage());
                        }
                    });



            }
       
    
}
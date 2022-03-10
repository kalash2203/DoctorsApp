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
import com.example.doctorsapp.databinding.FragmentDoctorListBinding;
import com.example.doctorsapp.databinding.FragmentLoginBinding;
import com.example.doctorsapp.model.loginBody;
import com.example.doctorsapp.response.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginFragment extends BaseFragment {
    //commit 1
    //commit 2
    //CBHbchbbhcbhvcxhvvhcxcxccbxz  c  b  bzb
    private FragmentLoginBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(getLayoutInflater(),container,false);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return binding.getRoot();
    }
    @Override
    public void onResume() {
        super.onResume();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject paramObject = new JSONObject();
                    paramObject.put("phone", "8448569131");

                    Call<LoginResponse> call = ApiClient.getApiClient().getApiInterface().login(paramObject.toString());
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                            if (response.isSuccessful()){
                                assert response.body() != null;
                                if (response.body().getAuth()){
                                    Toast.makeText(getContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                                    Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.action_loginFragment_to_doctorListFragment);
                                }else
                                if (response.body().getMessage().equals("Sike That's the Wrong Number")){
                                    Toast.makeText(getContext(),""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }

                        }

                        @Override
                        public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                            Log.e("LoginDetails",""+t.getMessage());
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
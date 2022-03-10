package com.example.doctorsapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorsapp.R;
import com.example.doctorsapp.model.CityDetails;

import java.util.ArrayList;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.viewHolder>{
    private ArrayList<CityDetails> cityList;
    private Context context;
    private Activity activity;

    public CityListAdapter(Context context, ArrayList<CityDetails> cityList,Activity activity)
    {
        this.context=context;
        this.cityList=cityList;
        this.activity=activity;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.city_list_item_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CityDetails city= cityList.get(position);
        holder.tvCityName.setText(city.toString());
        holder.btnGetDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((MainActivity)activity).setCityName(city);
//                NavDirections action= CityListFragmentDirections.actionCityListFragmentToDoctorListFragment();
//                Navigation.findNavController(activity,R.id.fragmentContainerView).navigate(action);
                Navigation.findNavController(activity, R.id.fragmentContainerView).navigate(R.id.action_getCityFragment_to_doctorListFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvCityName;
        Button btnGetDoctors;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvCityName=itemView.findViewById(R.id.city_name);
            btnGetDoctors=itemView.findViewById(R.id.get_doctors);

        }

    }

}

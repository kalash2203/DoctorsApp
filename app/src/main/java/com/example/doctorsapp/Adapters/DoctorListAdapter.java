package com.example.doctorsapp.Adapters;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doctorsapp.R;
import com.example.doctorsapp.model.DoctorDetails;

import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.viewHolder>{
    private List<DoctorDetails> doctorList;
    private Context context;
    private Activity activity;
    public DoctorListAdapter(Activity activity,Context context, List<DoctorDetails> doctorList)
    {
        this.activity=activity;
        this.context=context;
        this.doctorList=doctorList;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.doctor_list_item_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DoctorDetails doctor= doctorList.get(position);
        holder.tvDoctorName.setText(doctor.getDocName());
        holder.tvDoctorFee.setText("₹ "+doctor.getDocConsultationFee());
        holder.tvDoctorSpeciality.setText(doctor.getDocSpecialisation());
        holder.tvDoctorExp.setText(doctor.getDocYoE()+" yrs");
        holder.tvDoctorCity.setText(doctor.getCity());
        Glide.with(context).load(Uri.parse(doctor.getDocProfileImgUrl())).into(holder.imgPhoto);
        holder.imgBookApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                NavDirections action= NavGraphDirections.actionGlobalBookAppoitmentFragment(doctor.getName(), doctor.getId());
//                Navigation.findNavController(activity,R.id.fragmentContainerView).navigate(action);
                Navigation.findNavController(activity, R.id.fragmentContainerView).navigate(R.id.action_doctorListFragment_to_bookingAptFragment);

            }
        });

    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvDoctorName;
        TextView tvDoctorExp;
        TextView tvDoctorFee;
        TextView tvDoctorSpeciality;
        TextView tvDoctorCity;
        //CircleImageView imgPhoto;
        ImageView imgPhoto;
        ImageView imgBookApp;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvDoctorName=itemView.findViewById(R.id.doctor_name);
            tvDoctorExp=itemView.findViewById(R.id.doctor_experience);
            tvDoctorFee=itemView.findViewById(R.id.doctor_fee);
            tvDoctorSpeciality=itemView.findViewById(R.id.doctor_speciality);
            imgPhoto=itemView.findViewById(R.id.doctor_image);
            tvDoctorCity=itemView.findViewById(R.id.doctor_city);
            imgBookApp=itemView.findViewById(R.id.book_appoitment);
        }
    }
}

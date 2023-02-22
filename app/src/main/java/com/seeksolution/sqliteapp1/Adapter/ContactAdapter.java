package com.seeksolution.sqliteapp1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seeksolution.sqliteapp1.Model.ContactModal;
import com.seeksolution.sqliteapp1.R;
import com.seeksolution.sqliteapp1.UpdateCourse;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ContactModal> modalArrayList;

    public ContactAdapter(Context context, ArrayList<ContactModal> modalArrayList) {
        this.context = context;
        this.modalArrayList = modalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_rv_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      ContactModal modal = modalArrayList.get(position);
        holder.tv_name.setText(modal.getName());
        holder.tv_email.setText(modal.getEmail());
        holder.tv_password.setText(modal.getPassword());
        holder.tv_mobile.setText(modal.getMobile());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateCourse.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("email", modal.getEmail());
                i.putExtra("password", modal.getPassword());
                i.putExtra("mobile", modal.getMobile());
                Toast.makeText(context, "Update ", Toast.LENGTH_SHORT).show();
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                // starting our activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_email,tv_password,tv_mobile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.id_tv_name);
            tv_email = itemView.findViewById(R.id.id_tv_email);
            tv_password = itemView.findViewById(R.id.id_tv_password);
            tv_mobile = itemView.findViewById(R.id.id_tv_mobile);

        }
    }
}

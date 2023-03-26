package com.example.th6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserGridAdapter extends RecyclerView.Adapter<UserGridAdapter.UserGridViewHolder>{
    ArrayList<User> lstUser;

    Context context;
    UserGridCallback userGridCallback;

    public UserGridAdapter(ArrayList<User> lstUser,UserGridCallback userGridCallback) {
        this.lstUser = lstUser;
        this.userGridCallback= userGridCallback;
    }

    @NonNull
    @Override
    public UserGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.layoutitemgrid, parent,false);
        UserGridViewHolder viewHolder = new UserGridViewHolder(userView);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull UserGridViewHolder holder, int position) {
        User item= lstUser.get(position);
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context,item.getAvatar()));
        holder.itemView.setOnClickListener(view ->userGridCallback.onItemClick(item.getId()));


    }

    @Override
    public int getItemCount() {
        return lstUser.size();
    }

    class UserGridViewHolder extends RecyclerView.ViewHolder{
        ImageView imAvatar;

        public UserGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar = itemView.findViewById(R.id.ivAvatar);
        }
    }
    public interface UserGridCallback{
        void onItemClick(String id);
    }
}


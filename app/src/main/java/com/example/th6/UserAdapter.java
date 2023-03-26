package com.example.th6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder >{
    ArrayList<User> lsUser;
    Context context;
    UserCallback userCallback;
    public UserAdapter(ArrayList<User> lsUser, UserCallback userCallback) {
        this.lsUser = lsUser;
        this.userCallback=userCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        //Nập layout cho view để biểu diễn phần tử user
        View userView=inflater.inflate(R.layout.layoutitem, parent,false);
        //
        UserViewHolder viewHolder = new UserViewHolder(userView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //Lấy item từng dữ liệu
        User item=lsUser.get(position);
        //gán vào item của view
        holder.imAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context,item.getAvatar()));
        holder.tvName.setText(item.getName());
        // lấy sự kiện
          holder.itemView.setOnClickListener(view -> userCallback.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {
        return lsUser.size();
    }

     class UserViewHolder extends RecyclerView.ViewHolder{
         ImageView imAvatar;
         TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvatar =itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
    public interface  UserCallback{
        void onItemClick(String id);
    }
}

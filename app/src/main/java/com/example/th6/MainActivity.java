package com.example.th6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserAdapter.UserCallback{
RecyclerView rvListC;
ArrayList<User> lstUser;
UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvListC=findViewById(R.id.rvList);
        //
        LoadData();
        userAdapter = new UserAdapter(lstUser,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvListC.setAdapter(userAdapter);
        rvListC.setLayoutManager(linearLayoutManager);

    }
    @Override
    public void onItemClick(String id){
        Intent i =new Intent(this, DetailActivity.class);
        i.putExtra("userId",id);
        startActivity(i);
    }

    void LoadData()
    {
        lstUser = new ArrayList<>();
        lstUser.add(new User("1","Trà sữa 1","TS_01.png"));
        lstUser.add(new User("2","Trà sữa 2", "ts_02.png"));
    }
}
package com.example.th6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements UserGridAdapter.UserGridCallback{
    RecyclerView rvGridC;
    ArrayList<User>lstUser;
    UserGridAdapter userGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvGridC = findViewById(R.id.rvGrid);
        LoadData();
        userGridAdapter = new UserGridAdapter(lstUser,this   );
        //
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        rvGridC.setAdapter(userGridAdapter);
        rvGridC.setLayoutManager(gridLayoutManager);

    }
    @Override
    public void onItemClick(String id){
        Intent i =new Intent(this, DetailActivity.class);
        i.putExtra("userId",id);
        startActivity(i);
    }
    void LoadData(){
        lstUser = new ArrayList<>();
        lstUser.add(new User("1","Trà sữa 1", "TS_01.png"));
        lstUser.add(new User("2","Trà sữa 2", "ts_02.png"));


    }
}
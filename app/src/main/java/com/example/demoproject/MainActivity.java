package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        List<Integer> imagelist=new ArrayList<>();
        imagelist.add(R.drawable.number1);
        imagelist.add(R.drawable.number2);
        imagelist.add(R.drawable.number3);
        imagelist.add(R.drawable.number4);
        imagelist.add(R.drawable.number5);
        imagelist.add(R.drawable.number6);
        imagelist.add(R.drawable.number7);
        imagelist.add(R.drawable.number8);
        imagelist.add(R.drawable.number9);

        recyclerViewAdapter=new RecyclerViewAdapter(this,imagelist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}
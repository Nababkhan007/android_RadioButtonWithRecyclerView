package com.example.radiobuttonwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView selectionRecyclerView;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        setAdapterData();
    }

    private void setAdapterData() {
        personList = Arrays.asList(
                new Person("Larry"),
                new Person("Moe"),
                new Person("Curly"));

        selectionRecyclerView.setAdapter(new PersonAdapter(this, personList));
    }

    private void initialization() {
        selectionRecyclerView = findViewById(R.id.selectionRecyclerViewId);
        selectionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personList = new ArrayList<>();
    }
}

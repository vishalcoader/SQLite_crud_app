package com.seeksolution.sqliteapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.seeksolution.sqliteapp1.Adapter.ContactAdapter;
import com.seeksolution.sqliteapp1.Model.ContactModal;

import java.util.ArrayList;

public class ViewCourse extends AppCompatActivity {

    private ArrayList<ContactModal> arrayList;
    private DBHandler handler;
    private ContactAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.idRVContact);

        handler = new DBHandler(this);
        arrayList = new ArrayList<>();

        arrayList = handler.readCourses();

        adapter=new ContactAdapter(getApplicationContext(),arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourse.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

    }
}
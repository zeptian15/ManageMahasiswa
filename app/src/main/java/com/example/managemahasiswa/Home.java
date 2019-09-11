package com.example.managemahasiswa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity{

    private RecyclerView rvMahasiswa;
    RecyclerView.LayoutManager layoutManager;
    private List<Mahasiswa> list = new ArrayList<>();
    Context context;
    ImageButton tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Manage Mahasiswa");

        rvMahasiswa = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        rvMahasiswa.setLayoutManager(layoutManager);

        tambah = (ImageButton) findViewById(R.id.tambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(getApplicationContext(),InputActivity.class);
                add.putExtra("UPDATE_ACTION","Insert");
                startActivity(add);
            }
        });

        setupRecyclerView();
    }

    public void setupRecyclerView(){
        DatabaseHelper db = new DatabaseHelper(this);
        list = db.selectUserData();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, list);
        rvMahasiswa.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

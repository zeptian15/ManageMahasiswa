package com.example.managemahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button lihatData,inputData, informasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        inputData = (Button) findViewById(R.id.inputdata);

        inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lihatData = new Intent(DashboardActivity.this,InputActivity.class);
                startActivity(lihatData);
            }
        });

        lihatData = (Button) findViewById(R.id.lihatdata);

        lihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lihatData = new Intent(DashboardActivity.this,Home.class);
                startActivity(lihatData);
            }
        });

        informasi = (Button) findViewById(R.id.informasi);

        informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent informasi = new Intent(DashboardActivity.this,About.class);
                startActivity(informasi);
            }
        });


    }
}

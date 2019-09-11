package com.example.managemahasiswa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private EditText nomor,nama,alamat,jenkel,tanggal;
    private Button simpan;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Input Data");

        Bundle detail = getIntent().getExtras();

        context = this;
        simpan = findViewById(R.id.simpan);
        nomor = findViewById(R.id.inputNomor);
        nama = findViewById(R.id.inputNama);
        alamat = findViewById(R.id.inputAlamat);
        jenkel = findViewById(R.id.inputJenkel);
        tanggal = findViewById(R.id.inputTanggal);

        if(detail.getString("UPDATE_ACTION").equals("Update")) {
            getSupportActionBar().setTitle("Edit Data");
            Mahasiswa mahasiswa = getIntent().getParcelableExtra("UPDATE_INTENT");

            nomor.setText(String.valueOf(mahasiswa.getId_mahasiswa()));
            nama.setText(mahasiswa.getNama());
            tanggal.setText(mahasiswa.getTanggal());
            jenkel.setText(mahasiswa.getKelamin());
            alamat.setText(mahasiswa.getAlamat());
        }
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setNama(nama.getText().toString());
                mahasiswa.setAlamat(alamat.getText().toString());
                mahasiswa.setId_mahasiswa(Integer.parseInt(nomor.getText().toString()));
                mahasiswa.setKelamin(jenkel.getText().toString());
                mahasiswa.setTanggal(tanggal.getText().toString());

                Bundle detail = getIntent().getExtras();
                if(detail.getString("UPDATE_ACTION").equals("Update")){
                    db.update(mahasiswa);
                    Toast.makeText(getApplicationContext(), "Data Berhasil Di Update", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(InputActivity.this, Home.class);
                    startActivity(home);
                    finish();
                } if(detail.getString("UPDATE_ACTION").equals("Insert")) {
                    db.insert(mahasiswa);
                    Toast.makeText(getApplicationContext(), "Data Berhasil Dimasukan", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(InputActivity.this, Home.class);
                    startActivity(home);
                    finish();
                }

            }
        });

    }
}

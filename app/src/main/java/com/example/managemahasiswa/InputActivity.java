package com.example.managemahasiswa;

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

        context = this;
        simpan = findViewById(R.id.simpan);
        nomor = findViewById(R.id.inputNomor);
        nama = findViewById(R.id.inputNama);
        alamat = findViewById(R.id.inputAlamat);
        jenkel = findViewById(R.id.inputJenkel);
        tanggal = findViewById(R.id.inputTanggal);

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

                db.insert(mahasiswa);
                Toast.makeText(getApplicationContext(), "Data Berhasil Dimasukan", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

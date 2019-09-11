package com.example.managemahasiswa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    private EditText edtId, edtNama, edtTanggal, edtkelamin, edtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Detail Mahasiswa");

        Mahasiswa mahasiswa = getIntent().getParcelableExtra("DETAIL_INTENT");

        edtId = findViewById(R.id.inputNomor);
        edtNama = findViewById(R.id.inputNama);
        edtTanggal = findViewById(R.id.inputTanggal);
        edtkelamin = findViewById(R.id.inputJenkel);
        edtAlamat = findViewById(R.id.inputAlamat);

        edtId.setText(String.valueOf(mahasiswa.getId_mahasiswa()));
        edtNama.setText(mahasiswa.getNama());
        edtTanggal.setText(mahasiswa.getTanggal());
        edtkelamin.setText(mahasiswa.getKelamin());
        edtAlamat.setText(mahasiswa.getAlamat());

        edtId.setEnabled(false);
        edtNama.setEnabled(false);
        edtTanggal.setEnabled(false);
        edtkelamin.setEnabled(false);
        edtAlamat.setEnabled(false);

    }
}

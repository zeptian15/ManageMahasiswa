package com.example.managemahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME = "UserInfo";
    private static final String TABLE_NAME = "tbl_mahasiswa";
    private static final String KEY_ID = "id_mahasiswa";
    private static final String KEY_NAME = "nama";
    private static final String KEY_DATE = "tanggal";
    private static final String KEY_GENDER = "kelamin";
    private static final String KEY_ADDRESS = "alamat";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = " Create Table " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT," + KEY_DATE + " TEXT," + KEY_GENDER + " TEXT," + KEY_ADDRESS + " TEXT)";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("drop table if exists " + TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    // Select Data
    public List<Mahasiswa> selectUserData(){
        ArrayList<Mahasiswa> userList = new ArrayList<Mahasiswa>();

        SQLiteDatabase db = getReadableDatabase();
        String [] columns = {KEY_ID, KEY_NAME, KEY_DATE, KEY_GENDER, KEY_ADDRESS};
        Cursor c = db.query(TABLE_NAME, columns, null, null, null, null, null);

        while (c.moveToNext()){
            int id = c.getInt(0);
            String name = c.getString(1);
            String date = c.getString(2);
            String gender = c.getString(3);
            String address = c.getString(4);

            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setId_mahasiswa(id);
            mahasiswa.setNama(name);
            mahasiswa.setTanggal(date);
            mahasiswa.setKelamin(gender);
            mahasiswa.setAlamat(address);
            userList.add(mahasiswa);
        }
        return userList;
    }
    // Delete Data
    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String WhereClause = KEY_ID + "='" + id + "'";
        db.delete(TABLE_NAME, WhereClause, null);
    }

    //Insert Data
    public void insert(Mahasiswa mahasiswa){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues konten = new ContentValues();

        konten.put(KEY_ID,mahasiswa.getId_mahasiswa());
        konten.put(KEY_NAME,mahasiswa.getNama());
        konten.put(KEY_ADDRESS,mahasiswa.getAlamat());
        konten.put(KEY_DATE,mahasiswa.getTanggal());
        konten.put(KEY_GENDER,mahasiswa.getKelamin());

        db.insert(TABLE_NAME,null,konten);
    }

    //Update Data
    public void update(Mahasiswa mahasiswa){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues konten = new ContentValues();

        konten.put(KEY_ID,mahasiswa.getId_mahasiswa());
        konten.put(KEY_NAME,mahasiswa.getNama());
        konten.put(KEY_ADDRESS,mahasiswa.getAlamat());
        konten.put(KEY_DATE,mahasiswa.getTanggal());
        konten.put(KEY_GENDER,mahasiswa.getKelamin());

        String indikatorHapus = KEY_ID + " = '"+mahasiswa.getId_mahasiswa()+"'";

        db.update(TABLE_NAME,konten,indikatorHapus,null);
    }
}

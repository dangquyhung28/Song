package com.example.baihat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    ListView lstBaiHat;
    Button btnAdd;

    BaiHatAdapter baiHatAdapter;
    List<BaiHat> listBaiHat;
    ArrayList<BaiHat> arrayListBH = new ArrayList<BaiHat>();
    MyDBHelper myDBHelper= new MyDBHelper(this);
    BaiHat baiHat;
    @Override
    protected void onStart() {
        super.onStart();
        myDBHelper.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myDBHelper.closeDB();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initwiget();

        myDBHelper.openDB();
        Cursor cursor = myDBHelper.DisplayAll();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            arrayListBH.add(new BaiHat(cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.getID())),
                    cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.getNAME())),
                    cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.getSinger())),
                    cursor.getFloat(cursor.getColumnIndexOrThrow(MyDBHelper.getTime()))));
        }
        baiHatAdapter = new BaiHatAdapter(MainActivity.this, R.layout.items, arrayListBH);
        lstBaiHat.setAdapter(baiHatAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void initwiget() {
        lstBaiHat = (ListView) findViewById(R.id.listView);
        edtSearch = (EditText) findViewById(R.id.editTextText);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
    }
}
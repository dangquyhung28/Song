package com.example.baihat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText edtName, edtSinger, edtTime;
    Button btnAddBH, btnBack;
    MyDBHelper myDBHelper= new MyDBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initwiget();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnAddBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultAdd = myDBHelper.insertData(
                        edtName.getText().toString(),
                        edtSinger.getText().toString(),
                        Float.parseFloat(edtTime.getText().toString())
                );
                if (resultAdd == -1){
                    Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity2.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initwiget() {
        edtName = (EditText) findViewById(R.id.editTextText2);
        edtSinger = (EditText) findViewById(R.id.editTextText3);
        edtTime = (EditText) findViewById(R.id.editTextText4);
        btnAddBH = (Button) findViewById(R.id.buttonAddBaiHat);
        btnBack = (Button) findViewById(R.id.buttonBack);
    }
}
package com.example.bigexample;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bigexample.Data.DataBaseUser;

import java.util.ArrayList;

public class DangKy extends AppCompatActivity {

    DataBaseUser data;
    private EditText txtName;
    private EditText txtTenDangNhap;
    private EditText address;
    private EditText phone;
    private EditText date_of_birth;
    private ImageView cancelDangKy;
    private TextView submitDangKy;
    private static final int PICK_IMAGE = 222;
    private String GetValue(EditText e){
        return e.getText().toString().trim();
    }

    protected void onStart(){
        super.onStart();
        data.openDB();
    }
    protected void onStop(){
        super.onStop();
        data.close();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        txtName = findViewById(R.id.txtNameDangKy);
        txtTenDangNhap =findViewById(R.id.txtTenDangNhap);
        address = findViewById(R.id.txtAddressDangKy);
        phone = findViewById(R.id.txtPhoneDangKy);
        date_of_birth = findViewById(R.id.txtDateOfBirth);
        cancelDangKy = findViewById(R.id.cancelDangKy);
        submitDangKy = findViewById(R.id.submitDangKy);
        data = new DataBaseUser(DangKy.this);



        submitDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxId  = 0;
                Cursor cursor = data.ALLRecord();
                ArrayList<Integer> users = getIdUser(cursor);
                maxId = users.get(0);
                long resultAdd = data.Insert(maxId + 1, GetValue(txtTenDangNhap),1, GetValue(address),GetValue(phone));
                if(resultAdd == -1){
                    Toast.makeText(DangKy.this, "Lỗi rồi!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DangKy.this, "Đã thêm user", Toast.LENGTH_SHORT).show();
                }
                openLogin();
            }
        });
        cancelDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

    }

    public void openLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public ArrayList<Integer> getIdUser(Cursor cursor) {
        ArrayList<Integer> users = new ArrayList<Integer>();

        while (cursor.moveToNext()) {
            users.add(Integer.parseInt(cursor.getString(0)));
        }
        return users;
    }
}

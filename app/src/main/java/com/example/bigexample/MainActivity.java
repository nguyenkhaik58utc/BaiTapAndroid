package com.example.bigexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bigexample.Data.DataBaseComment;
import com.example.bigexample.Data.DataBaseLike;
import com.example.bigexample.Data.DataBaseUser;
import com.example.bigexample.Golobal.Golobal;
import com.example.bigexample.models.Account;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText txtPassWord;
    private TextView txtDangKy;
    private EditText txtNameUser;
    DataBaseUser data;
    DataBaseLike dataLike;
    DataBaseComment dataCmt;

    @Override
    protected void onStart() {
        super.onStart();
        data.openDB();
        dataLike.openDB();
        dataCmt.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        data.closeDB();
        dataLike.closeDB();
        dataCmt.closeDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BtnLogin);
        txtPassWord = (EditText) findViewById(R.id.passWord);
        txtDangKy = findViewById(R.id.txtDangKy);
        txtNameUser = findViewById(R.id.username);
        data = new DataBaseUser(MainActivity.this);
        dataLike = new DataBaseLike(MainActivity.this);
        dataCmt = new DataBaseComment(MainActivity.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passWord = txtPassWord.getText().toString();
                String userName = txtNameUser.getText().toString();
                if (passWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    if(userName.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "nhập tài khoản", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String query = "SELECT * FROM Account WHERE nameaccounts = '" + userName + "' and passWord = " + passWord;
                        Cursor cursor = data.ALLRecord(query);
                        Account accountLogin = getAccount(cursor);
                        if (accountLogin.getIdUser() != 0)
                        {
                            Golobal.setIdUser(accountLogin.getIdUser());
                            Golobal.setNameUser(accountLogin.getNameUser());
                            Golobal.setAddress(accountLogin.getAddress());
                            Golobal.setPhone(accountLogin.getPhone());
                            Golobal.setYearob(accountLogin.getYearob());
                            Golobal.setImgAvatar(accountLogin.getImgAvatar());
                            Golobal.setImgBackground(accountLogin.getImgBackground());
                            Golobal.setNameAccounts(accountLogin.getNameAccounts());
                            Golobal.setPassWord(accountLogin.getPassWord());
                            openHomeApp();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Tào khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDangKy();
            }
        });
    }

    public void openHomeApp() {
        Intent intent = new Intent(this, MainPagesActivity.class);
        startActivity(intent);
    }

    public void openDangKy() {
        Intent intent = new Intent(this, DangKy.class);
        startActivity(intent);
    }
    public Account getAccount(Cursor cursor)
    {
        Account account = new Account();
        while (cursor.moveToNext())
        {
            account =  new Account(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8));
        }
        return account;
    }
}

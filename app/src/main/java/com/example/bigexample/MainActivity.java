package com.example.bigexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText txtPassWord;
    private TextView txtDangKy;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BtnLogin);
        txtPassWord = (EditText) findViewById(R.id.passWord);
        txtDangKy = findViewById(R.id.txtDangKy);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passWord = txtPassWord.getText().toString();
                if (passWord.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    if (passWord.equalsIgnoreCase("abc")) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("userLogin", passWord);
                        editor.commit();
                        openHomeApp();
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
}

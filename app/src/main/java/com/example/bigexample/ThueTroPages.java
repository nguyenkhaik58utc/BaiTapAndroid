package com.example.bigexample;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigexample.Data.DataBasePost;
import com.example.bigexample.Golobal.Golobal;

import java.io.IOException;
import java.util.ArrayList;

public class ThueTroPages extends Fragment {
    ImageView cancelThueTro;
    TextView submitThueTro;
    EditText txtKhuVucThueTro;
    EditText txtGiaPhongThueTro;
    EditText txtMoTaThueTro;
    ImageView imgThueTro;
    ImageView imgThueTro2;
    Uri imageUri;
    ImageView imgSelectMaps;
    int checkClick = 0;
    String urlImage = "";
    String urlImage2 = "";
    private static final int PICK_IMAGE = 222;

    DataBasePost data;

    @Override
    public void onStart() {
        super.onStart();
        data.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        data.closeDB();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.thuetro_pages, container, false);
        cancelThueTro = (ImageView) view.findViewById(R.id.cancelThueTro);
        submitThueTro = (TextView) view.findViewById(R.id.submitThueTro);
        txtKhuVucThueTro = (EditText) view.findViewById(R.id.txtKhuVucThueTro);
        txtGiaPhongThueTro = (EditText) view.findViewById(R.id.txtGiaPhongThueTro);
        txtMoTaThueTro = (EditText) view.findViewById(R.id.txtMoTaThueTro);
        imgThueTro = (ImageView) view.findViewById(R.id.imgHomeThueTro);
        imgThueTro2 = (ImageView) view.findViewById(R.id.imgHomeThueTro2);
        imgSelectMaps = view.findViewById(R.id.imgSelectMaps);

        data = new DataBasePost(getActivity());

        cancelThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Golobal.setCheckEditPost(0);
                UploadPages uploadPages = new UploadPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, uploadPages);
                transaction.commit();
            }
        });

        if(Golobal.getCheckEditPost() == 1 )
        {
            Bundle  bundle = getArguments();
            txtKhuVucThueTro.setText(bundle.getString("address"));
            txtGiaPhongThueTro.setText(bundle.getString("price"));
            txtMoTaThueTro.setText(bundle.getString("describe"));
            imgThueTro.setImageURI(Uri.parse(bundle.getString("imgAddress1")));
            imgThueTro2.setImageURI(Uri.parse(bundle.getString("imgAddress2")));
        }

        imgThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkClick = 1;
                openPicture();
            }
        });
        imgThueTro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkClick = 2;
                openPicture();
            }
        });
        imgSelectMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMaps fragmentMaps = new fragmentMaps();
                fragmentMaps.show(getFragmentManager(),"fragmentMaps");
            }
        });
        submitThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Golobal.setCheckEditPost(0);
                if(Golobal.getCheckEditPost() == 1 )
                {
                    Bundle bundle = getArguments();
                    long resultUpdate = data.Update(bundle.getInt("idPost"), txtKhuVucThueTro.getText().toString(), txtGiaPhongThueTro.getText().toString(),txtMoTaThueTro.getText().toString(),urlImage,urlImage2);
                    if (resultUpdate == 0) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    } else if (resultUpdate == 1) {
                        Toast.makeText(getActivity(), "Successsfully updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Error, multiple records updated", Toast.LENGTH_SHORT).show();
                    }
                    FragmentHome fragmentHome = new FragmentHome();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragmentHome);
                    transaction.commit();
                }
                else{
                    String query = "SELECT *  FROM Post";
                    int maxId  = 0;
                    Cursor cursor = data.ALLRecord(query);
                    ArrayList<Integer> post = getIdPost(cursor);
                    for (int i = 0; i < post.size() ; i++ )
                    {
                        if (maxId < post.get(i)) maxId = post.get(i);
                    }

                    long resultAdd = data.Insert(maxId +1, Golobal.idUser, txtKhuVucThueTro.getText().toString(), txtGiaPhongThueTro.getText().toString(),txtMoTaThueTro.getText().toString(),urlImage,urlImage2);
                    if(resultAdd == -1){
                        Toast.makeText(getActivity(), "Lỗi rồi!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getActivity(), "Đã thêm bài viết", Toast.LENGTH_SHORT).show();
                    }
                    FragmentHome fragmentHome = new FragmentHome();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, fragmentHome);
                    transaction.commit();
                }
            }
        });
        return view;
    }

    public void openPicture()
    {
        Intent openPicture = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(openPicture,PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            imageUri = data.getData();
            if(checkClick == 1)
            {
                imgThueTro.setImageURI(imageUri);
                urlImage = imageUri.toString();
                checkClick = 0;
            }
            else
            {
                if(checkClick == 2)
                {
                    imgThueTro2.setImageURI(imageUri);
                    urlImage2 = imageUri.toString();
                    checkClick =0;
                }
            }
      }
    }

    public static ArrayList<Integer> getIdPost(Cursor cursor) {
        ArrayList<Integer> post = new ArrayList<Integer>();

        while (cursor.moveToNext()) {
            post.add(Integer.parseInt(cursor.getString(0)));
        }
        return post;
    }
}

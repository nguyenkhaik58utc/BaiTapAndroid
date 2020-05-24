package com.example.bigexample;

import android.database.Cursor;
import android.os.Bundle;
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

import java.util.ArrayList;

public class TimTroPages extends Fragment {
    ImageView cancelTimTro;
    TextView submitTimTro;
    EditText txtKhuVucTimTro;
    EditText txtGiaPhongTimTro;
    EditText txtMoTaTimTro;


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
        final View view = inflater.inflate(R.layout.timtro_pages, container, false);
        cancelTimTro = (ImageView) view.findViewById(R.id.cancelTimTro);
        submitTimTro = (TextView) view.findViewById(R.id.submitTimTro);
        txtKhuVucTimTro = (EditText) view.findViewById(R.id.txtKhuVucTimTro);
        txtGiaPhongTimTro = (EditText) view.findViewById(R.id.txtGiaPhongTimTro);
        txtMoTaTimTro = (EditText) view.findViewById(R.id.txtMoTaTimTro);

        data = new DataBasePost(getActivity());

        submitTimTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "SELECT *  FROM Post";
                int maxId  = 0;
                Cursor cursor = data.ALLRecord(query);
                ArrayList<Integer> post = ThueTroPages.getIdPost(cursor);
                for (int i = 0; i < post.size() ; i++ )
                {
                    if (maxId < post.get(i)) maxId = post.get(i);
                }

                long resultAdd = data.Insert(maxId +1, Golobal.idUser, txtKhuVucTimTro.getText().toString(), txtGiaPhongTimTro.getText().toString(),txtMoTaTimTro.getText().toString(),"","");
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
        });

        cancelTimTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPages uploadPages = new UploadPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, uploadPages);
                transaction.commit();
            }
        });
        return view;
    }
}

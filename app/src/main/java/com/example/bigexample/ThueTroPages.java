package com.example.bigexample;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ThueTroPages extends Fragment {
    ImageView cancelThueTro;
    TextView submitThueTro;
    EditText txtKhuVucThueTro;
    EditText txtGiaPhongThueTro;
    EditText txtMoTaThueTro;
    ImageView imgThueTro;

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

        cancelThueTro.setOnClickListener(new View.OnClickListener() {
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

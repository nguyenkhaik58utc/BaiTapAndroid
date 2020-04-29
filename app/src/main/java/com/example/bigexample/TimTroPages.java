package com.example.bigexample;

import android.os.Bundle;
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

public class TimTroPages extends Fragment {
    ImageView cancelTimTro;
    TextView submitTimTro;
    EditText txtKhuVucTimTro;
    EditText txtGiaPhongTimTro;
    EditText txtMoTaTimTro;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.timtro_pages, container, false);
        cancelTimTro = (ImageView) view.findViewById(R.id.cancelTimTro);
        submitTimTro = (TextView) view.findViewById(R.id.submitTimTro);
        txtKhuVucTimTro = (EditText) view.findViewById(R.id.txtKhuVucTimTro);
        txtGiaPhongTimTro = (EditText) view.findViewById(R.id.txtGiaPhongTimTro);
        txtMoTaTimTro = (EditText) view.findViewById(R.id.txtMoTaTimTro);

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

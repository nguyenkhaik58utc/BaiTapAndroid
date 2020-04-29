package com.example.bigexample;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigexample.models.Post;

import java.util.ArrayList;

import static com.example.bigexample.R.layout.thuetro_pages;
import static com.example.bigexample.R.layout.upload_pages;

public class UploadPages extends Fragment {

    public TextView txtEdit;
    public Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(upload_pages, container, false);

        ImageView imgThueTro = (ImageView) view.findViewById(R.id.ImageThueTro);
        ImageView imgTimTro = (ImageView) view.findViewById(R.id.ImageTimTro);
        TextView txtThueTro = (TextView) view.findViewById(R.id.txtThueTro);
        TextView txtTimTro = (TextView) view.findViewById(R.id.txtTimTro);
        imgThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThueTroPages thueTroPages = new ThueTroPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, thueTroPages);
                transaction.commit();
            }
        });
        imgTimTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimTroPages timTroPages = new TimTroPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, timTroPages);
                transaction.commit();
            }
        });
        txtThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThueTroPages thueTroPages = new ThueTroPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, thueTroPages);
                transaction.commit();
            }
        });
        txtTimTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimTroPages timTroPages = new TimTroPages();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, timTroPages);
                transaction.commit();
            }
        });
        return view;

    }


}

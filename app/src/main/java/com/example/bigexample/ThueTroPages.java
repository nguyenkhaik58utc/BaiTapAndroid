package com.example.bigexample;

import android.app.Activity;
import android.content.Intent;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.IOException;

public class ThueTroPages extends Fragment {
    ImageView cancelThueTro;
    TextView submitThueTro;
    EditText txtKhuVucThueTro;
    EditText txtGiaPhongThueTro;
    EditText txtMoTaThueTro;
    ImageView imgThueTro;
    private static final int PICK_IMAGE = 222;

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

        imgThueTro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent,
                        getString(R.string.app_name));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

//            try {
//                Uri imageUri = data.getData();
//                Bitmap photo = MediaStore.Images.Media.getBitmap(this.getR)
//            } catch (IOException e) {
//
//            }

            return;    }
    }
}

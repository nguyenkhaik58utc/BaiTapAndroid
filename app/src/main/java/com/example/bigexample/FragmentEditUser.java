package com.example.bigexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bigexample.Data.DataBaseUser;
import com.example.bigexample.Golobal.Golobal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEditUser extends Fragment
{
    private CircleImageView imageUserEditUser;
    private TextView nameUserEditUser;
    private TextView txtNameUserEditUser;
    private TextView txtTenDangNhapEditUser;
    private TextView txtAddressEditUser;
    private TextView txtPhoneEditUser;
    private TextView txtDateEditUser;
    private FloatingActionButton btnEdit;
    private FloatingActionButton btnCancel;
    private FloatingActionButton btnSubmit;
    Uri imageUri;
    String urlImageAvatar= "";
    private static final int PICK_IMAGE = 222;
    DataBaseUser dataUser;

    @Override
    public void onStart() {
        super.onStart();
        dataUser.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataUser.closeDB();
    }

    public FragmentEditUser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_user, container, false);

        imageUserEditUser = view.findViewById(R.id.imageUserEditUser);
        nameUserEditUser = view.findViewById(R.id.nameUserEditUser);
        txtNameUserEditUser = view.findViewById(R.id.txtNameUserEditUser);
        txtTenDangNhapEditUser = view.findViewById(R.id.txtTenDangNhapEditUser);
        txtAddressEditUser = view.findViewById(R.id.txtAddressEditUser);
        txtPhoneEditUser = view.findViewById(R.id.txtPhoneEditUser);
        txtDateEditUser = view.findViewById(R.id.txtDateEditUser);
        btnCancel = view.findViewById(R.id.btnCancelEdit);
        btnSubmit = view.findViewById(R.id.btnSubmitEdit);
        btnEdit = view.findViewById(R.id.floatingActionButton);
        dataUser = new DataBaseUser(getActivity());

        imageUserEditUser.setImageURI(Uri.parse(Golobal.getImgAvatar()));
        nameUserEditUser.setText(Golobal.getNameUser());
        txtNameUserEditUser.setText(Golobal.getNameUser());
        txtTenDangNhapEditUser.setText(Golobal.getNameAccounts());
        txtAddressEditUser.setText(Golobal.getAddress());
        txtPhoneEditUser.setText(Golobal.getPhone());
        txtDateEditUser.setText(Golobal.getYearob());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNameUserEditUser.setEnabled(true);
                txtTenDangNhapEditUser.setEnabled(true);
                txtAddressEditUser.setEnabled(true);
                txtPhoneEditUser.setEnabled(true);
                btnSubmit.setVisibility(View.VISIBLE);
                btnCancel.setVisibility(View.VISIBLE);
                btnEdit.setEnabled(false);
                imageUserEditUser.setEnabled(true);
                imageUserEditUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPicture();
                    }
                });

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageUserEditUser.setEnabled(false);
                btnEdit.setEnabled(true);
                btnCancel.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.INVISIBLE);

                txtNameUserEditUser.setEnabled(false);
                txtTenDangNhapEditUser.setEnabled(false);
                txtAddressEditUser.setEnabled(false);
                txtPhoneEditUser.setEnabled(false);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageUserEditUser.setEnabled(false);
                btnEdit.setEnabled(true);
                btnCancel.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.INVISIBLE);

                txtNameUserEditUser.setEnabled(false);
                txtTenDangNhapEditUser.setEnabled(false);
                txtAddressEditUser.setEnabled(false);
                txtPhoneEditUser.setEnabled(false);

                long resultUpdate = dataUser.Update(Golobal.getIdUser(), txtNameUserEditUser.getText().toString(), txtAddressEditUser.getText().toString(),txtPhoneEditUser.getText().toString(),txtDateEditUser.getText().toString(),urlImageAvatar,txtTenDangNhapEditUser.getText().toString());
                if (resultUpdate == 0) {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                } else if (resultUpdate == 1) {
                    Toast.makeText(getActivity(), "Successsfully updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Error, multiple records updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        nameUserEditUser.setText(Golobal.getNameUser());
        txtNameUserEditUser.setText(Golobal.getNameUser());
        txtTenDangNhapEditUser.setText(Golobal.getNameAccounts());
        txtAddressEditUser.setText(Golobal.getAddress());
        txtPhoneEditUser.setText(Golobal.getPhone());
        txtDateEditUser.setText(Golobal.getYearob());

        return view;
    }

    public void openPicture()
    {
        Intent openPicture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(openPicture,PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            imageUri = data.getData();
            imageUserEditUser.setImageURI(imageUri);
            urlImageAvatar = imageUri.toString();


        }
    }
}

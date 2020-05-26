package com.example.bigexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.bigexample.Data.DataBaseComment;
import com.example.bigexample.Golobal.Golobal;

public class FragmentEditDeletCmt extends DialogFragment {

    TextView txtXoaCmt;
    TextView txtSuaCmt;
    DataBaseComment dataCmt;

    @Override
    public void onStart() {
        super.onStart();
        dataCmt.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataCmt.closeDB();
    }

    public FragmentEditDeletCmt() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_delet_cmt, container, false);
        txtXoaCmt = view.findViewById(R.id.txtXoaCmt);
        txtSuaCmt = view.findViewById(R.id.txtSuaCmt);
        dataCmt = new DataBaseComment(getActivity());
        final Bundle myBundleCmt = getArguments();

        txtXoaCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultDelete = dataCmt.Delete(myBundleCmt.getInt("idCmt"));
                if (resultDelete == 0) {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data is successfully deleted", Toast.LENGTH_SHORT).show();
                }
                getDialog().cancel();
            }
        });

        txtSuaCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Golobal.setCheckEditCmt(1);
                getDialog().cancel();
                fragment_content_post.txtNewComment.setText(Golobal.getContentCmt());
                fragment_content_post.txtCancelEditCmt.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}

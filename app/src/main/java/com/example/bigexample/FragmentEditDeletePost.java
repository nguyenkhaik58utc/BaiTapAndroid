package com.example.bigexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.bigexample.Data.DataBasePost;
import com.example.bigexample.Golobal.Golobal;


public class FragmentEditDeletePost extends DialogFragment {

    TextView txtDeletePost;
    TextView txtEditPost;
    DataBasePost dataPost;

    public FragmentEditDeletePost() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        dataPost.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataPost.closeDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_delete_post, container, false);
        dataPost = new DataBasePost(getActivity());
        txtEditPost = view.findViewById(R.id.txtEditPost);
        txtDeletePost = view.findViewById(R.id.txtDeletePost);

        final Bundle bundle = getArguments();

        final int id = bundle.getInt("idPost");
        txtDeletePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long resultDelete = dataPost.Delete(id);
                if (resultDelete == 0) {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Data is successfully deleted", Toast.LENGTH_SHORT).show();
                }
                getDialog().cancel();
            }
        });
        txtEditPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Golobal.setCheckEditPost(1);
                getDialog().cancel();
                if(bundle.getString("imgAddress1").equals("") && bundle.getString("imgAddress2").equals(""))
                {
                    TimTroPages timTroPages = new TimTroPages();
                    timTroPages.setArguments(bundle);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,timTroPages).addToBackStack("AccountPages")
                            .commit();
                }
                else
                {
                    ThueTroPages thueTroPages = new ThueTroPages();
                    thueTroPages.setArguments(bundle);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,thueTroPages).addToBackStack("AccountPages")
                            .commit();
                }

            }
        });


        return view;
    }
}

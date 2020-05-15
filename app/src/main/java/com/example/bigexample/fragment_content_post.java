package com.example.bigexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigexample.Data.BaseComment;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_content_post extends Fragment {

    ImageView imageContentPost;
    TextView nameUserContentPost;
    TextView phoneUserContentPost;
    TextView addressContentPost;
    TextView describeContentPost;
    ImageView imageAddressContentPost1;
    ImageView imageAddressContentPost2;
    ListView lst;

    public fragment_content_post() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_content_post, container, false);

        nameUserContentPost = view.findViewById(R.id.nameUserContentPost);
        addressContentPost = view.findViewById(R.id.addressContentPost);
        phoneUserContentPost = view.findViewById(R.id.phoneUserContentPost);
        describeContentPost = view.findViewById(R.id.describeContentPost);
        imageAddressContentPost1 = view.findViewById(R.id.imageAddressContentPost1);
        imageAddressContentPost2 = view.findViewById(R.id.imageAddressContentPost2);


        lst = view.findViewById(R.id.lstComment);
        lst.setAdapter(new BaseComment(getActivity()));

        Bundle bundle = getArguments();
        if(bundle != null)
        {
            nameUserContentPost.setText(bundle.getString("hoten"));
            addressContentPost.setText(bundle.getString("address"));
            phoneUserContentPost.setText(bundle.getString("phone"));
            describeContentPost.setText(bundle.getString("describe"));
        }
        nameUserContentPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundleUser = new Bundle();
                bundleUser.putString("nameUserPost",nameUserContentPost.getText().toString());
                ProfireUser profireUser = new ProfireUser();
                profireUser.setArguments(bundleUser);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,profireUser).addToBackStack("FragmentHome")
                        .commit();
            }
        });
        imageAddressContentPost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_image_popup imagePopup = new fragment_image_popup();
                imagePopup.show(getFragmentManager(), "ImagePopup");
            }
        });

        imageAddressContentPost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_image_popup imagePopup = new fragment_image_popup();
                imagePopup.show(getFragmentManager(), "ImagePopup");
            }
        });

        return view;
    }

}

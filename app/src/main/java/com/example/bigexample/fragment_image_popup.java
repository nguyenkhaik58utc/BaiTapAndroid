package com.example.bigexample;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_image_popup extends DialogFragment {

    ImageView imagePopup;

    public fragment_image_popup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =  inflater.inflate(R.layout.fragment_image_popup, container, false);

        imagePopup = view.findViewById(R.id.imagePopup);
        Bundle bundle = getArguments();
        imagePopup.setImageURI(Uri.parse(bundle.getString("image")));
        return view;
    }
}

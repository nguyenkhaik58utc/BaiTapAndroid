package com.example.bigexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_details extends Fragment {

    private ImageView imgCall;
    private TextView nameUserDetails;
    private ImageView imageUserDetails;

    public fragment_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_details, container, false);
        imgCall = view.findViewById(R.id.imagePhoneDetails);
        imageUserDetails = view.findViewById(R.id.imageUserDetails);
        nameUserDetails = view .findViewById(R.id.nameUserDetails);
        Bundle bundle = getArguments();
        nameUserDetails.setText(bundle.getString("nameUserPost"));
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallPopup callPopup = new CallPopup();
                callPopup.show(getFragmentManager(), "CallPopup");
            }
        });
        return view;
    }

}

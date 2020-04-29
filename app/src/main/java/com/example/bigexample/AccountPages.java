package com.example.bigexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class AccountPages extends Fragment {
    private ImageView imgCall;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.account_pages, container, false);
        imgCall = (ImageView) view.findViewById(R.id.imagePhoneAccountPages);
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

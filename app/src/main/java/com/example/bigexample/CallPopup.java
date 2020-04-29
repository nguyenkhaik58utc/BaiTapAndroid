package com.example.bigexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CallPopup extends DialogFragment {
    TextView txtCall;
    TextView txtSms;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.call_popup, container, false);
        txtCall = (TextView) view.findViewById(R.id.txtCall);
        txtSms = (TextView) view.findViewById(R.id.txtSms);

        txtCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "0904556735", null));
                startActivity(intent);
            }
        });
        txtSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0904556735"));
                startActivity(intent);
            }
        });
        return view;
    }
}

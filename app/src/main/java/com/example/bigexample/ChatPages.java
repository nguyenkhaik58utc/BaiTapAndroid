package com.example.bigexample;


import android.os.Bundle;
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

public class ChatPages extends Fragment {

    ImageView imgSearchChat;
    EditText txtSearchChat;
    TextView txtAllChat;
    ImageView imgAllChat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_pages, container, false);
        imgSearchChat = (ImageView) view.findViewById(R.id.imgSearchChatPages);
        txtSearchChat = (EditText) view.findViewById(R.id.txtSearchChatPages);
        txtAllChat = (TextView) view.findViewById(R.id.txtAllChat);
        imgAllChat = (ImageView) view.findViewById(R.id.imgAllChat);

        txtAllChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatPopup chatPopup = new ChatPopup();
                chatPopup.show(getFragmentManager(), "ChatPopup");
            }
        });
        imgAllChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatPopup chatPopup = new ChatPopup();
                chatPopup.show(getFragmentManager(), "ChatPopup");
            }
        });

        return view;
    }
}

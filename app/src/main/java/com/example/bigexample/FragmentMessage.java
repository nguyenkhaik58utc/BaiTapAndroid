package com.example.bigexample;

import android.database.Cursor;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bigexample.Data.BaseMessage;
import com.example.bigexample.Data.DataBaseUser;
import com.example.bigexample.Data.DataChat;
import com.example.bigexample.Golobal.Golobal;
import com.example.bigexample.models.Message;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMessage extends Fragment {

    EditText txtNewMessage;
    ImageView imgSendMessage;
    DataChat dataChat;
    ListView lstAllMessage;
    DataBaseUser dataBaseUser;
    public ArrayList<Message> lstMess;
    public Bundle bundle;

    public FragmentMessage() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        dataChat.openDB();
        dataBaseUser.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataChat.closeDB();
        dataBaseUser.closeDB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        txtNewMessage=  view.findViewById(R.id.txtNewMessage);
        imgSendMessage = view.findViewById(R.id.imgSendMessage);
        lstAllMessage = view.findViewById(R.id.lstMessage);
        dataChat = new DataChat(getActivity());
        dataBaseUser = new DataBaseUser(getActivity());

        bundle = getArguments();

        String queryMessage = "SELECT iduser1,contentchat from tableChat WHERE (iduser1 = " + Golobal.getIdUser() +" AND iduser2 = " + bundle.getInt("idUser") +" ) OR (iduser1 = " + Golobal.getIdUser() +" AND iduser2 = " + bundle.getInt("idUser") + " ) ";

        Cursor cursor = dataChat.getWritableDatabase().rawQuery(queryMessage,null);
        lstMess = lstMessage(cursor);
        BaseMessage baseMessage = new BaseMessage(getActivity(),lstMess);
        lstAllMessage.setAdapter(baseMessage);

        imgSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDate date = LocalDate.now();
                LocalTime time = LocalTime.now();

                String query = "SELECT *  FROM tableChat";
                int maxId  = 0;
                Cursor cursor2 = dataChat.ALLRecord(query);
                ArrayList<Integer> id = getIdMessage(cursor2);
                for (int i = 0; i < id.size() ; i++ )
                {
                    if (maxId < id.get(i)) maxId = id.get(i);
                }


                long resultAdd = dataChat.Insert(maxId+1,Golobal.getIdUser(),bundle.getInt("idUser"),txtNewMessage.getText().toString(),date.toString() + " " + time.toString());
                if(resultAdd == -1){
                    Toast.makeText(getActivity(), "Lỗi rồi!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "send", Toast.LENGTH_SHORT).show();
                }
                txtNewMessage.setText("");
                String queryMessage = "SELECT iduser1,contentchat from tableChat WHERE (iduser1 = " + Golobal.getIdUser() +" AND iduser2 = " + bundle.getInt("idUser") +" ) OR (iduser1 = " + Golobal.getIdUser() +" AND iduser2 = " + bundle.getInt("idUser") + " ) ";

                Cursor cursor = dataChat.getWritableDatabase().rawQuery(queryMessage,null);
                lstMess = lstMessage(cursor);
                BaseMessage baseMessage = new BaseMessage(getActivity(),lstMess);
                lstAllMessage.setAdapter(baseMessage);
            }
        });
        return view;

    }

    public ArrayList<Message> lstMessage(Cursor cursor)
    {
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Message> users = new ArrayList<>();

        while (cursor.moveToNext())
        {
            users.add(new Message(cursor.getInt(0),cursor.getString(1)));
        }
        for(int i = 0; i < users.size(); i++)
        {
            String sql = "SELECT imageavataruser FROM Account WHERE _id = " + users.get(i).getIdUser();
            Cursor cursor1 = dataBaseUser.getWritableDatabase().rawQuery(sql,null);
            while (cursor1.moveToNext())
            {
                messages.add(new Message(users.get(i).getIdUser(),users.get(i).getContent(),cursor1.getString(0)));
            }
        }
        return messages;
    }

    public ArrayList<Integer> getIdMessage(Cursor cursor) {
        ArrayList<Integer> idMessages = new ArrayList<Integer>();

        while (cursor.moveToNext()) {
            idMessages.add(Integer.parseInt(cursor.getString(0)));
        }
        return idMessages;
    }

}

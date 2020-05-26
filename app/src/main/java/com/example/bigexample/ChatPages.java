package com.example.bigexample;


import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bigexample.Data.Base;
import com.example.bigexample.Data.BaseChat;
import com.example.bigexample.Data.DataChat;
import com.example.bigexample.Golobal.Golobal;
import com.example.bigexample.models.Account;

import java.util.ArrayList;

public class ChatPages extends Fragment {

    ImageView imgSearchChat;
    EditText txtSearchChat;
    DataChat dataChat;
    ListView lstChat;

    @Override
    public void onStart() {
        super.onStart();
        dataChat.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataChat.closeDB();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_pages, container, false);
        imgSearchChat = (ImageView) view.findViewById(R.id.imgSearchChatPages);
        txtSearchChat = (EditText) view.findViewById(R.id.txtSearchChatPages);
        lstChat = view.findViewById(R.id.lstChat);
        dataChat = new DataChat(getActivity());

        final ArrayList<Account> lst = lstAccountChat(getAllChat());
        BaseChat baseChat = new BaseChat(getActivity(),lst);
        lstChat.setAdapter(baseChat);

        lstChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("idUser",lst.get(position).getIdUser());
                bundle.putString("nameUser",lst.get(position).getNameUser());
                bundle.putString("imageUser",lst.get(position).getImgAvatar());

                FragmentMessage fragmentMessage = new FragmentMessage();
                fragmentMessage.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,fragmentMessage).addToBackStack("ChatPages")
                        .commit();
            }
        });

        return view;
    }
    public ArrayList<Integer> getAllChat()
    {
        ArrayList<Integer> users = new ArrayList<>();
        String selectUserChat = "SELECT DISTINCT iduser1,iduser2 FROM tableChat WHERE iduser1 =" +  Golobal.getIdUser();
        Cursor cursor = dataChat.getWritableDatabase().rawQuery(selectUserChat,null);
        while (cursor.moveToNext())
        {
            if(users.size() == 0) users.add(Integer.parseInt(cursor.getString(1)));
            else
            {
                int check = 0;
                for( int i = 0; i < users.size(); i++)
                {
                    if(Integer.parseInt(cursor.getString(1)) != users.get(i))
                    {
                        check = 1;
                    }
                    else {
                        check = 0;
                        break;
                    }
                }
                if(check == 1) users.add(Integer.parseInt(cursor.getString(1)));
            }
        }

        String selectUserChat2 = "SELECT DISTINCT iduser1,iduser2 FROM tableChat WHERE iduser2 =" +  Golobal.getIdUser();
        Cursor cursor2 = dataChat.getWritableDatabase().rawQuery(selectUserChat2,null);
        while (cursor2.moveToNext())
        {
            if(users.size() == 0) users.add(Integer.parseInt(cursor2.getString(1)));
            else
            {
                int check = 0;
                for( int i = 0; i < users.size(); i++)
                {
                    if(Integer.parseInt(cursor2.getString(0)) != users.get(i))
                    {
                        check = 1;
                    }
                    else {
                        check = 0;
                        break;
                    }
                }
                if(check == 1) users.add(Integer.parseInt(cursor2.getString(1)));
            }
        }

        return  users;
    }

    public ArrayList<Account> lstAccountChat(ArrayList<Integer> lst)
    {
        ArrayList<Account> lstAccount = new ArrayList<>();
        for(int i = 0 ;i < lst.size(); i++)
        {
            String select = "SELECT _id,nameuser,imageavataruser FROM Account where _id = " + lst.get(i);
            Cursor cursor = dataChat.getWritableDatabase().rawQuery(select,null);
            while (cursor.moveToNext())
            {
                lstAccount.add(new Account(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        }
        return lstAccount;
    }
}

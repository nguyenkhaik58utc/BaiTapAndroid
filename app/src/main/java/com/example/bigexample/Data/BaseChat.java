package com.example.bigexample.Data;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bigexample.R;
import com.example.bigexample.models.Account;
import com.example.bigexample.models.Comment;
import com.example.bigexample.models.RowPost;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseChat extends BaseAdapter {

    ArrayList<Account> list;
    Context context;

    public BaseChat(Context c,ArrayList<Account> lstChat) {
        context = c;
        list = lstChat;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_chat, parent, false);

        CircleImageView imageChat = view.findViewById(R.id.imageUserChatPages);
        TextView txtNameUserChatPages = (TextView) view.findViewById(R.id.txtNameUserChatPages);
        Account temp = list.get(position);
        String image = temp.getImgAvatar();
        String name = temp.getNameUser();

        imageChat.setImageURI(Uri.parse(image));
        txtNameUserChatPages.setText(name);
        return view;


    }
}

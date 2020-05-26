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
import com.example.bigexample.models.Message;
import com.example.bigexample.models.RowPost;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseMessage extends BaseAdapter {

    ArrayList<Message> list;
    Context context;

    public BaseMessage(Context c,ArrayList<Message> lstMessage) {
        context = c;
        list = lstMessage;
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
        View view = inflater.inflate(R.layout.activity_row_message, parent, false);

        CircleImageView imageChat = view.findViewById(R.id.imageUserMessage);
        TextView txtNameUserChatPages = (TextView) view.findViewById(R.id.txtContentMessage);
        Message temp = list.get(position);
        String image = temp.getImage();
        String content = temp.getContent();

        imageChat.setImageURI(Uri.parse(image));
        txtNameUserChatPages.setText(content);
        return view;


    }
}

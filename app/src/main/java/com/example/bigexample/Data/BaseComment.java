package com.example.bigexample.Data;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bigexample.R;
import com.example.bigexample.models.Comment;
import com.example.bigexample.models.RowPost;

import java.util.ArrayList;

public class BaseComment extends BaseAdapter {

    ArrayList<Comment> list;
    Context context;

    public BaseComment(Context c,ArrayList<Comment> lstCmt) {
        context = c;
        list = lstCmt;
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
        View view = inflater.inflate(R.layout.activity_row_comment, parent, false);

        TextView nameUserCmt = (TextView) view.findViewById(R.id.nameUserComment);
        TextView contextCmt = (TextView) view.findViewById(R.id.txtComment);
        Comment temp = list.get(position);
        String a = temp.getNameUserCmt();
        String c = temp.getContentCmt();

        nameUserCmt.setText(a);
        contextCmt.setText(c);
        return view;


    }
}

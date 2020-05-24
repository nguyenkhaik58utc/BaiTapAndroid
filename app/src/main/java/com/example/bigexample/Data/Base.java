package com.example.bigexample.Data;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bigexample.R;
import com.example.bigexample.models.Post;
import com.example.bigexample.models.RowPost;

import java.util.ArrayList;

public class Base extends BaseAdapter {

    ArrayList<Post> list;
    Context context;

    public Base(Context c, ArrayList<Post> posts) {
        context = c;
        list = posts;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_new_post, parent, false);

        ImageView imageUserPost = view.findViewById(R.id.imageUserPost);
        TextView nameUserPost = view.findViewById(R.id.nameUserPost);
        TextView priceUserPost = view.findViewById(R.id.phoneUserPost);
        TextView describe = view.findViewById(R.id.describe);
        TextView addressPost = view.findViewById(R.id.addressPost);
        ImageView imageAddress1 = view.findViewById(R.id.imageAddress1);
        ImageView imageAddress2 = view.findViewById(R.id.imageAddress2);
        TextView txtLikeNewPost = view.findViewById(R.id.txtLikeNewPost);
        TextView txtCommentNewPost = view.findViewById(R.id.txtCommentNewPost);

        Post temp = list.get(position);
        imageUserPost.setImageURI(Uri.parse(temp.getImageUserPost()));
        nameUserPost.setText(temp.getNameUserPost());
        priceUserPost.setText(temp.getPricePost());
        describe.setText(temp.getDescribe());
        addressPost.setText(temp.getAddressPost());
        txtLikeNewPost.setText(String.valueOf( temp.getNumberLike()));
        txtCommentNewPost.setText(String.valueOf(temp.getNumberComment()));
        if(temp.getImageAddress().equals("") && temp.getImageAddress2().equals(""))
        {
            imageAddress1.setVisibility(View.GONE);
            imageAddress2.setVisibility(View.GONE);
        }
        else
        {
            Uri UriAddr1 = Uri.parse(temp.getImageAddress());
            imageAddress1.setImageURI(UriAddr1);
            Uri UriAddr2 = Uri.parse(temp.getImageAddress2());
            imageAddress2.setImageURI(UriAddr2);
        }
        return view;


    }
}

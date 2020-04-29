package com.example.bigexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.bigexample.models.Post;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private FragmentActivity context; //context
    private ArrayList<Post> players; //data source of the list adapter


    public CustomAdapter(FragmentActivity context, ArrayList<Post> players) {
        this.context = context;
        this.players = players;
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = convertView;

        Post p = (Post) getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            ImageView imageUserPost = (ImageView) view.findViewById(R.id.imageUserPost);
            imageUserPost.setImageResource(p.getImageUserPost());
            TextView nameUserPost = (TextView) view.findViewById(R.id.nameUserPost);
            nameUserPost.setText(p.getNameUserPost());
            TextView describe = (TextView) view.findViewById(R.id.describe);
            describe.setText(p.getDescribe());
            TextView addressPost = (TextView) view.findViewById(R.id.addressPost);
            addressPost.setText(p.getAddressPost());
            TextView phoneUserPost = (TextView) view.findViewById(R.id.phoneUserPost);
            phoneUserPost.setText(p.getPhoneUserPost());
            ImageView imageAddress = (ImageView) view.findViewById(R.id.imageAddress);
            imageAddress.setImageResource(p.getImageAddress());

        }
        return view;
    }


}


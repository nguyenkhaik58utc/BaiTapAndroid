package com.example.bigexample;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bigexample.models.RowPost;

import java.util.ArrayList;

public class Base extends BaseAdapter {

    ArrayList<RowPost> list;
    Context context;

    Base(Context c) {
        context = c;
        list = new ArrayList<RowPost>();
        Resources resources = c.getResources();
        String[] nameUserPost = {"chim sẻ", "nsnd văn ver", "hải mario"};
        int[] idUserPost = {1, 2, 3};
        String[] addressPost = {"12 Dương Quảng Hàm", "đam phượng", "nam định"};
        String[] priceUserPost = {"1000", "2000-2500", "1200"};
        String[] describe = {"khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,.."};
        for (int i = 0; i < idUserPost.length; i++) {
            list.add(new RowPost(idUserPost[i], nameUserPost[i], addressPost[i], priceUserPost[i], describe[i],idUserPost[i]));
        }
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
        View view = inflater.inflate(R.layout.activity_new_post, parent, false);

        TextView nameUserPost = (TextView) view.findViewById(R.id.nameUserPost);
        TextView priceUserPost = (TextView) view.findViewById(R.id.phoneUserPost);
        TextView describe = (TextView) view.findViewById(R.id.describe);
        TextView addressPost = (TextView) view.findViewById(R.id.addressPost);
        RowPost temp = list.get(position);
        String a = temp.getNameUserPost();
        String b = temp.getPhoneUserPost();
        String c = temp.getDescribe();
        String d = temp.getAddressPost();
        nameUserPost.setText(a);
        priceUserPost.setText(b);
        describe.setText(c);
        addressPost.setText(d);
        return view;


    }
}

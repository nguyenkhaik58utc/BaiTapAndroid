package com.example.bigexample;


import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bigexample.Data.Base;
import com.example.bigexample.Data.DataBaseComment;
import com.example.bigexample.Data.DataBaseLike;
import com.example.bigexample.Data.DataBasePost;
import com.example.bigexample.models.Account;
import com.example.bigexample.models.Post;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    DataBasePost dataPost;
    DataBaseLike dataLike;
    DataBaseComment dataComment;
    ListView lst;
    String[] nameUserPost = {"chim sẻ", "nsnd văn ver", "hải mario"};
    int[] imgUserPost = {R.drawable.ribi, R.drawable.ribi, R.drawable.ribi};
    String[] addressPost = {"12 Dương Quảng Hàm", "đam phượng", "nam định"};
    String[] phoneUserPost = {"1000", "2000-2500", "1200"};
    String[] describe = {"khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,.."};
    int[] imageAddress = {R.drawable.ribi, R.drawable.button_focused, R.drawable.custom_button};

    @Override
    public void onStart() {
        super.onStart();
        dataPost.openDB();
        dataLike.openDB();
        dataComment.openDB();
    }

    @Override
    public void onStop() {
        super.onStop();
        dataPost.closeDB();
        dataLike.closeDB();
        dataComment.closeDB();
    }

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lst = view.findViewById(R.id.lstPost);
        dataPost = new DataBasePost(getActivity());
        dataLike = new DataBaseLike(getActivity());
        dataComment = new DataBaseComment(getActivity());

        Cursor cursor = dataPost.getWritableDatabase().rawQuery("SELECT * FROM Post",null);

        final ArrayList<Post> lstPost = getPost(cursor);

        lst.setAdapter(new Base(getActivity(),lstPost));
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("idPost",lstPost.get(position).getIdPost());
                bundle.putInt("idUser",lstPost.get(position).getIdUser());
                bundle.putString("imgUser",lstPost.get(position).getImageUserPost());
                bundle.putString("name",lstPost.get(position).getNameUserPost());
                bundle.putString("address",lstPost.get(position).getAddressPost());
                bundle.putString("price",lstPost.get(position).getPricePost());
                bundle.putString("describe",lstPost.get(position).getDescribe());
                bundle.putString("imgAddress1",lstPost.get(position).getImageAddress());
                bundle.putString("imgAddress2",lstPost.get(position).getImageAddress2());
                bundle.putInt("numberLike",lstPost.get(position).getNumberLike());
                bundle.putInt("numberCmt",lstPost.get(position).getNumberComment());
                fragment_content_post contentPost = new fragment_content_post();
                contentPost.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,contentPost).addToBackStack("FragmentHome")
                        .commit();
            }
        });
        return view;
    }

    public ArrayList<Post> getPost(Cursor cursor) {
        ArrayList<Post> arrayPosts = new ArrayList<Post>();
        ArrayList<Post> posts = new ArrayList<Post>();
        ArrayList<Integer> likes = new ArrayList<Integer>();
        ArrayList<Integer> comments = new ArrayList<Integer>();
        ArrayList<Account> accounts = new ArrayList<Account>();

        while (cursor.moveToNext()) {
            posts.add(new Post(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
        }

        for(int i = 0; i < posts.size(); i++)
        {
            String queryLike = "SELECT count(_id) FROM tableLike WHERE idpost = " + posts.get(i).getIdPost();
            Cursor cursor1 = dataLike.getWritableDatabase().rawQuery(queryLike,null);
            if(cursor1 == null)
            {
                likes.add(0);
            }
            else {
                while (cursor1.moveToNext()) {
                    likes.add(Integer.parseInt(cursor1.getString(0)));
                }
            }
            String queryCmt = "SELECT count(_id) FROM tableComment WHERE idpost = " + posts.get(i).getIdPost();
            Cursor cursor2 = dataLike.getWritableDatabase().rawQuery(queryCmt,null);
            if(cursor2 == null)
            {
                comments.add(0);
            }
            else {
                while (cursor2.moveToNext()) {
                    comments.add(Integer.parseInt(cursor2.getString(0)));
                }
            }

            String queryAccount = "SELECT _id,nameuser,imageavataruser FROM Account  WHERE _id = " + posts.get(i).getIdUser();
            Cursor cursor3 = dataLike.getWritableDatabase().rawQuery(queryAccount,null);

                while (cursor3.moveToNext()) {
                    accounts.add(new Account(Integer.parseInt(cursor3.getString(0)),cursor3.getString(1),cursor3.getString(2)));
                }

        }

        for(int i = 0; i < posts.size(); i++)
        {
            arrayPosts.add(new Post(posts.get(i).getIdPost(),posts.get(i).getIdUser(),accounts.get(i).getImgAvatar(),accounts.get(i).getNameUser(),posts.get(i).getAddressPost(),posts.get(i).getPricePost(),posts.get(i).getDescribe(),likes.get(i),comments.get(i),posts.get(i).getImageAddress(),posts.get(i).getImageAddress2()));
        }
        return arrayPosts;
    }


}

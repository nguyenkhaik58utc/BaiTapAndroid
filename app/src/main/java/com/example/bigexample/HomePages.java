package com.example.bigexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bigexample.models.Post;

import java.util.ArrayList;

import static com.example.bigexample.R.layout.home_pages;

public class HomePages extends Fragment {

    ListView lst;
    String[] nameUserPost = {"chim sẻ", "nsnd văn ver", "hải mario"};
    int[] imgUserPost = {R.drawable.ribi, R.drawable.ribi, R.drawable.ribi};
    String[] addressPost = {"12 Dương Quảng Hàm", "đam phượng", "nam định"};
    String[] phoneUserPost = {"1000", "2000-2500", "1200"};
    String[] describe = {"khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,.."};
    int[] imageAddress = {R.drawable.ribi, R.drawable.button_focused, R.drawable.custom_button};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(home_pages, container, false);
        lst = (ListView) view.findViewById(R.id.listPostABC);
        final CustomAdapter adapter = new CustomAdapter(getActivity(), getNewPost());
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProfireUser profireUser = new ProfireUser();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, profireUser);
                transaction.commit();
            }
        });
        return inflater.inflate(home_pages, container, false);
    }

    public ArrayList<Post> getNewPost() {
        ArrayList<Post> posts = new ArrayList<Post>();

        Post p;
        for (int i = 0; i <= imgUserPost.length - 1; i++) {
            p = new Post(imgUserPost[i], nameUserPost[i], addressPost[i], phoneUserPost[i], describe[i], imageAddress[i]);
            posts.add(p);
        }
        return posts;
    }

}

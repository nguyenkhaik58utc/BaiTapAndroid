package com.example.bigexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bigexample.Data.Base;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    ListView lst;
    String[] nameUserPost = {"chim sẻ", "nsnd văn ver", "hải mario"};
    int[] imgUserPost = {R.drawable.ribi, R.drawable.ribi, R.drawable.ribi};
    String[] addressPost = {"12 Dương Quảng Hàm", "đam phượng", "nam định"};
    String[] phoneUserPost = {"1000", "2000-2500", "1200"};
    String[] describe = {"khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,..", "khép kín, giường, tử, nóng lạnh,.."};
    int[] imageAddress = {R.drawable.ribi, R.drawable.button_focused, R.drawable.custom_button};
    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lst = view.findViewById(R.id.lstPost);
        lst.setAdapter(new Base(getActivity()));
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("hoten",nameUserPost[position]);
                bundle.putString("address",addressPost[position]);
                bundle.putString("phone",phoneUserPost[position]);
                bundle.putString("describe",describe[position]);
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

}

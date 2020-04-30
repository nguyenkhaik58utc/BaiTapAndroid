package com.example.bigexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


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
    ArrayAdapter<String> adapter;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        lst = view.findViewById(R.id.lstPost);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,nameUserPost);
        lst.setAdapter(adapter);
        return view;
    }
}

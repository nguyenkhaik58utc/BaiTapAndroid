package com.example.bigexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfireUser extends Fragment {

    TextView nameUserInformationUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.profire_user, container, false);

        nameUserInformationUser = view.findViewById(R.id.nameUserInformationUser);
        Bundle mybundleProfireUser = getArguments();
        nameUserInformationUser.setText(mybundleProfireUser.getString("nameUserPost"));
        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation_information_user);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_friend:
                        Toast.makeText(getActivity(),"Enter nav_friend",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_follow:
                        Toast.makeText(getActivity(),"Enter follow",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_chat_friend:
                        Toast.makeText(getActivity(),"Enter chat friend",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_information_friend:
                        Bundle bundleProfireUser = new Bundle();
                        bundleProfireUser.putString("nameUserPost",nameUserInformationUser.getText().toString());
                        fragment_details detailsPages = new fragment_details();
                        detailsPages.setArguments(bundleProfireUser);
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,detailsPages).addToBackStack("fragment_content_post")
                                .commit();
                        break;
                }
                return true;
            }
        });
        return view;
    }

}

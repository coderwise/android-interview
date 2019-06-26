package com.interview.twoscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.interview.twoscreen.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showListFragment();
    }

    private void showListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, new UserListFragment())
                .addToBackStack(UserListFragment.TAG)
                .commit();
    }
}

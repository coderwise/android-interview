package com.interview.twoscreen.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.interview.twoscreen.R;
import com.interview.twoscreen.apis.User;
import com.interview.twoscreen.apis.UserResponse;
import com.interview.twoscreen.apis.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {


    public static final String TAG = "contact_list_fragment";
    private UserService userService;
    private View view;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userService = UserService.Creator.create();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadUsers();
    }

    private void loadUsers() {
        userService.getUsers("50").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call,
                                   @NonNull Response<UserResponse> response) {
                List<User> users = response.body().results;

                for (User user : users) {
                    Log.i("test", user.email);
                }

                setTestText("Loaded " + users.size() + " users");
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("test", "error!");
                setTestText(t.getMessage());
            }
        });

    }

    private void setTestText(String testText) {
        TextView textView = view.findViewById(R.id.test_text_view);
        textView.setText(testText);
    }
}

package com.interview.twoscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.interview.twoscreen.apis.User;
import com.interview.twoscreen.apis.UserResponse;
import com.interview.twoscreen.apis.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testLoadUsers();
    }

    private void testLoadUsers() {
        UserService service = UserService.Creator.create();

        service.getUsers("50").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                List<User> users = response.body().results;

                for (User user : users) {
                    Log.i("test", user.email);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("test", "error!");
            }
        });
    }
}

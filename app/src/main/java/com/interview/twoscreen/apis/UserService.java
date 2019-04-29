package com.interview.twoscreen.apis;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * https://randomuser.me/documentation#howto
 */
public interface UserService {
    String API_URL = "https://randomuser.me/";

    @GET("api")
    Call<UserResponse> getUsers(@Query("results") String numberOfResults);

    class Creator {
        public static UserService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(UserService.class);
        }
    }
}

package com.example.loginappexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("register.php")
    Call<UserModel> performRegistration(@Query("name") String name, @Query("user_name") String username, @Query("user_password") String password);

    @GET("login.php")
    Call<UserModel> performUserLogin(@Query("user_name") String username, @Query("user_password") String password);
}

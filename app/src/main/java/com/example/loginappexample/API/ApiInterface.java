package com.example.loginappexample.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("register.php")
    Call<UserModel> performRegistration(@Query("name") String name, @Query("username") String username, @Query("password") String password);

    @GET("login.php")
    Call<UserModel> performUserLogin(@Query("username") String username, @Query("password") String password);
}

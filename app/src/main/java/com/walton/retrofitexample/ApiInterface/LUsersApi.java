package com.walton.retrofitexample.ApiInterface;



import com.walton.retrofitexample.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LUsersApi {


    @Headers("Content-Type: application/json")
    @POST("/salesAPIdev/api/login")
    Call<Users> getUsers(@Body String login);

}
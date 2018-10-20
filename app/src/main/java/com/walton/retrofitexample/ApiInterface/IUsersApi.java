package com.walton.retrofitexample.ApiInterface;



import com.walton.retrofitexample.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IUsersApi  {


    @Headers("Content-Type: application/json")
    @POST("/salesAPIdev/customers.json")
 // Call<User> getUser(@Body String login);

   Call<User>createUser(@Header("Authorization") String tokenn,
                        @Body String login);

}
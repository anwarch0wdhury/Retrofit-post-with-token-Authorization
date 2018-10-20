package com.walton.retrofitexample.Api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.walton.retrofitexample.Activity.SharedPreference;
import com.walton.retrofitexample.ApiInterface.IUsersApi;
import com.walton.retrofitexample.ApiInterface.LUsersApi;
//import com.walton.retrofitexample.SharedPrefManager;
import com.walton.retrofitexample.User;
import com.walton.retrofitexample.Users;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiManager {
    private static LUsersApi services;
    private static IUsersApi service;
    private static ApiManager apiManager;



    private ApiManager() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "http://192.168...../" )
                .addConverterFactory( ScalarsConverterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        service = retrofit.create( IUsersApi.class );

        services = retrofit.create( LUsersApi.class );



    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;

    }


    public void createUser(JSONObject login,String valuetoken,Callback<User> callback) {

//        String getPreferencee=SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
//        Log.e("access get value",getPreferencee);

       // tokenn = "Bearer "+SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
       /* String sharedAccessKey = SharedPreference.getStringValue( mContext, SharedPreference.ACCESS_KEY );
        Log.e( "value of sharedpreffernce", sharedAccessKey );*/
        //"eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTTVU4VVFSajlkams4SWdtQ2lTWVUwSWlkMlV1MHZBb1FqV1k5RE9jMW1HRG1kalwvV2dkbVpjV1lXN2hwemxSWVVHSVhFeE5hU2Y2S05OU0ZhMkZMYjhzMGVzS2NOY2FySm03ZnZ2ZTk5ZTNRSzQ5YkFnOHd3TG15a1JaRnhHVmx0dU13c0pvWGhyaDhWRmsyS3JtUThMb2tkUW1CNGdoQ0NHRUtlT3JnWmI3RWQxaEJNWm8zVjdoWW1ydGt6Y0YrWjdGeHgwN0FjZDVYWmppNjFFMlh3TDROS092Z2FRbjBkWmxpU3FFSzZscElyUGMwTnB1c3dYV0d4U3JZOWRDdWhGNVNPTTJGSHFYV1VyQ3N3aldHU0ZlNjFJbGVPMXNHTllkakNjZEZvbzJ2R01LR1p0WlR1bjBuYXprZjM3ejZtcEFuZXdGdW85WFJBaDdxNzY2bVIxNG1XbFJBME5WZlNMblJrcmxLK3liMDU2UVwvbVB2N1lcL3pMb2hBRFV5YjJydjZudzJTVVlmTnY0TTE4V0hTUU9ibzlFcjJqTm5xWTBNNVh5QzRQZStlVHo4MCtIcCs5ZmpwR3paeno2XC8zMHNMSjQzMTE5V3VXYUdPVFd5STVMZHJkRTlKUEdscThVdnR0Q1AyanpYQXVtUGtnN1RTNHRLbU1hdEdTVXUrblp3ZlcwMVhubTErUERaazViMTRKU0RlZ20xMVwvenpoR1VDTGRPY2dreVZQZmdGUnJHaTllMzlcL3ZCOVwvODVQRW4wSzR6dE1GRWhybUs1SXJTTHZvbmwzZERnM2VmQnJyeHhxR09UYThSbVhBQjE5SkFNQUFBPT0iLCJzdWIiOiJzYWxlc2FwaSIsInJvbGVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1NSIl0sImlzcyI6IlNwcmluZyBTZWN1cml0eSBSRVNUIEdyYWlscyBQbHVnaW4iLCJleHAiOjE1Mzk4NTUyMzcsImlhdCI6MTUzOTg1MTYzN30.oDaMkTfb8_8VUcodGpCH-_gKx8tTHZvOn9A4kBjCL5k" ;

      //  Log.e( "token value", token );

        Call<User> loginCall = service.createUser(String.valueOf(valuetoken), String.valueOf( login ) );
        loginCall.enqueue( callback );
    }


    public void getUsers(JSONObject login, Callback<Users> callback) {
        Call<Users> loginCall = services.getUsers( String.valueOf( login ) );
        loginCall.enqueue( callback );
    }
}

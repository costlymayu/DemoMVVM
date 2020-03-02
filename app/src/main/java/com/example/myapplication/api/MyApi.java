package com.example.myapplication.api;

import com.example.myapplication.model.MyList;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyApi {
    @GET("androidwebmvvm.php")
    abstract Call<ArrayList<MyList>> getartistdata();
}

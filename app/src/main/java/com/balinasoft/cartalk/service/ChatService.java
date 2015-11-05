package com.balinasoft.cartalk.service;

import com.google.gson.JsonObject;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.POST;
import retrofit.http.Query;

public interface ChatService {

    @POST("/upload/photo")
    Call<JsonObject> uploadImage(@Query("image") RequestBody image);
}

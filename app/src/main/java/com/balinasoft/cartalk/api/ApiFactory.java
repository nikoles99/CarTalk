package com.balinasoft.cartalk.api;

import android.support.annotation.NonNull;

import com.balinasoft.cartalk.constans.Constans;
import com.balinasoft.cartalk.service.ChatService;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiFactory {

    private static final OkHttpClient CLIENT = new OkHttpClient();

    static {
        CLIENT.setConnectTimeout(Constans.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setWriteTimeout(Constans.WRITE_TIMEOUT, TimeUnit.SECONDS);
        CLIENT.setReadTimeout(Constans.TIMEOUT, TimeUnit.SECONDS);
    }

    @NonNull
    public static ChatService getChatService() {
        return getRetrofit().create(ChatService.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constans.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }
}

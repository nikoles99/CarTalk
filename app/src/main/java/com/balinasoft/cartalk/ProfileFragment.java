package com.balinasoft.cartalk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.balinasoft.cartalk.api.ApiFactory;
import com.balinasoft.cartalk.constans.Constans;
import com.balinasoft.cartalk.model.Auto;
import com.balinasoft.cartalk.service.ChatService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

import okio.BufferedSink;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ProfileFragment extends Fragment implements Callback<JsonObject> {

    Activity a;
    ImageView iv_img;

    public ProfileFragment() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Gson gson = new Gson();

        if (requestCode == 1 && resultCode == Constans.RESULT_OK) {
            Uri selectedImageUri = data.getData();
            uploadImg(selectedImageUri.getPath());

        }
    }

    public void uploadImg(String path) {
        RequestBody f = RequestBody.create(MediaType.parse("image/*"), path);
        ChatService service = ApiFactory.getChatService();
        Call<JsonObject> call = service.uploadImage(new RequestBody() {
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        });
        call.enqueue(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        iv_img = (ImageView) v.findViewById(R.id.iv_profile_image);
        iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), 1);
            }
        });
//        ChatService service = ApiFactory.getChatService();
//        Call<List<String>> call = service.uploadImage(new TypedFile("image/jpg",));
//        call.enqueue(this);
        return v;
    }

    @Override
    public void onResponse(Response<JsonObject> response, Retrofit retrofit) {
        Log.d("Retrofit", String.valueOf(response.body()));
        if (response.isSuccess()) {
            JsonObject airports = response.body();
            //do something here
        }
    }

    @Override
    public void onFailure(Throwable t) {
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}

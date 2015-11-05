package com.balinasoft.cartalk;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ChatFragment extends Fragment implements Callback<List<String>> {

    Activity a;
    ListView listView;
    ArrayAdapter<String> adapter;
    ImageView iv_img;

    public ChatFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        a = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        listView = (ListView) v.findViewById(R.id.lv_chat_fragment);
        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2"};
        adapter = new ChatAdapter(v.getContext(), values);
        listView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onResponse(Response<List<String>> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            List<String> airports = response.body();
            //do something here
        }
    }

    @Override
    public void onFailure(Throwable t) {
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

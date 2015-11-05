package com.balinasoft.cartalk;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class HomeActivity extends Activity implements OnClickListener {

    Button btn_find, btn_diallog, btn_profil, btn_chat;
    EditText et_find;
    ProfileFragment profileFragment;
    ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        btn_find = (Button) findViewById(R.id.btn_home_find);
        btn_find.setOnClickListener(this);
        btn_diallog = (Button) findViewById(R.id.btn_home_dialog);
        btn_diallog.setOnClickListener(this);
        btn_chat = (Button) findViewById(R.id.btn_home_chat);
        btn_chat.setOnClickListener(this);
        btn_profil = (Button) findViewById(R.id.btn_home_profile);
        btn_profil.setOnClickListener(this);

        btn_profil.setActivated(true);

        et_find = (EditText) findViewById(R.id.et_home_find);
        profileFragment = new ProfileFragment();
        chatFragment = new ChatFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(R.id.fl_home_fragment, profileFragment);
        fragmentTransaction.commit();
    }

    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        switch (v.getId()) {
            case R.id.btn_home_find: {
                et_find.setVisibility(View.VISIBLE);
            }
            case R.id.btn_home_profile: {

                fragmentTransaction.replace(R.id.fl_home_fragment, profileFragment);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btn_home_chat: {
                fragmentTransaction.replace(R.id.fl_home_fragment, chatFragment);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btn_home_dialog: {
                Intent intent = new Intent(this, NewChat.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

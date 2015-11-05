package com.balinasoft.cartalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class ChatActivity extends Activity implements OnClickListener {

    Button btn_back, btn_more, btn_add, btn_send;
    RelativeLayout rl_add, rl_more;
    boolean flag_add_file = false, flag_add_more = false;
    ListView lv;
    MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat);
        btn_back = (Button) findViewById(R.id.btn_chat_back);
        btn_back.setOnClickListener(this);
        btn_more = (Button) findViewById(R.id.btn_chat_more);
        btn_more.setOnClickListener(this);
        btn_add = (Button) findViewById(R.id.btn_chat_add_file);
        btn_add.setOnClickListener(this);
        btn_send = (Button) findViewById(R.id.btn_chat_send_msg);
        btn_send.setOnClickListener(this);

        rl_add = (RelativeLayout) findViewById(R.id.rl_chat_add_file);
        rl_more = (RelativeLayout) findViewById(R.id.rl_chat_menu);

        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2"};
        lv = (ListView) findViewById(R.id.lv_chat);
        adapter = new MessageAdapter(this, values);
        lv.setDividerHeight(16);
        lv.setAdapter(adapter);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_chat_back: {
                finish();
                break;
            }
            case R.id.btn_chat_more: {
                if (!flag_add_more) {
                    rl_more.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.menu);
                    rl_more.startAnimation(animation);
                    flag_add_more = true;
                } else {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.nomenu);
                    rl_more.startAnimation(animation);
                    rl_more.setVisibility(View.INVISIBLE);
                    flag_add_more = false;
                }
                break;

            }
            case R.id.btn_chat_add_file: {
                if (!flag_add_file) {
                    rl_add.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.swim);
                    rl_add.startAnimation(animation);
                    flag_add_file = true;
                } else {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.noswim);
                    rl_add.startAnimation(animation);
                    rl_add.setVisibility(View.INVISIBLE);
                    flag_add_file = false;
                }
                break;
            }
            case R.id.btn_chat_add_member: {
                break;
            }
            case R.id.btn_chat_to_leave_discussion: {
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}

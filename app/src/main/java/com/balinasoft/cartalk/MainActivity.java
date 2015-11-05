package com.balinasoft.cartalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    Button btn_signin, btn_registration, btn_forgot_pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btn_signin = (Button) findViewById(R.id.btn_main_signin);
        btn_signin.setOnClickListener(this);
        btn_forgot_pas = (Button) findViewById(R.id.btn_main_forgot);
        btn_forgot_pas.setOnClickListener(this);
        btn_registration = (Button) findViewById(R.id.btn_main_registration);
        btn_registration.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_main_signin: {
                intent = new Intent(this, HomeActivity.class);
                break;
            }
            case R.id.btn_main_forgot: {
                intent = new Intent(this, ForgotPassword.class);
                break;
            }
            case R.id.btn_main_registration: {
                intent = new Intent(this, RegistrationActivity.class);
                break;
            }
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

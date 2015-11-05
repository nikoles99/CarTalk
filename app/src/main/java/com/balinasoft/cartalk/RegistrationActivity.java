package com.balinasoft.cartalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.view.View.OnClickListener;


public class RegistrationActivity extends Activity implements OnClickListener {

    Button btn_back, btn_ok, btn_download_image, btn_add_auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registration);

        btn_back = (Button) findViewById(R.id.btn_registration_back);
        btn_back.setOnClickListener(this);
        btn_ok = (Button) findViewById(R.id.btn_registration_ok);
        btn_ok.setOnClickListener(this);
        btn_download_image = (Button) findViewById(R.id.btn_regisstration_download_img);
        btn_download_image.setOnClickListener(this);
        btn_add_auto = (Button) findViewById(R.id.btn_registration_add_auto);
        btn_add_auto.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_registration_back: {
                finish();
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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

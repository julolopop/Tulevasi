package com.example.julolopop.tulevasi.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.julolopop.tulevasi.R;
import com.example.julolopop.tulevasi.about.AboutActivity;
import com.example.julolopop.tulevasi.ui.MesasActivity;
import com.example.julolopop.tulevasi.ui.pref.PreferentLogin;
import com.github.clans.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fabbd;
    FloatingActionButton fababout;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.fabbd = (FloatingActionButton) findViewById(R.id.fabbd);
        this.fababout = (FloatingActionButton) findViewById(R.id.fabadbout);
        this.btn_Login = (Button) findViewById(R.id.btn_Login);

        this.fabbd.setOnClickListener(this);
        this.fababout.setOnClickListener(this);
        this.btn_Login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabbd:
                startActivity(new Intent(MainActivity.this, PreferentLogin.class));
                break;
            case R.id.fabadbout:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.btn_Login:
                startActivity(new Intent(MainActivity.this, MesasActivity.class));
                break;
        }
    }
}

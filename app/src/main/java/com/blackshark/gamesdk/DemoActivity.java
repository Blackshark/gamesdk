package com.blackshark.gamesdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        findViewById(R.id.button_gameeventinterface).setOnClickListener(this);
        Button lightbtn = findViewById(R.id.button_lightmanager);
        if (LightManager.isLightManagerSupported()) {
            lightbtn.setOnClickListener(this);
        } else {
            lightbtn.setVisibility(View.GONE);
        }
    }

    private void onClickGameEventInterface() {
        startActivity(new Intent(this, GameEventInterfaceDemoActivity.class));
    }

    private void onClickLightManager() {
        startActivity(new Intent(this, LightManagerDemoActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_gameeventinterface:
                onClickGameEventInterface();
                break;
            case R.id.button_lightmanager:
                onClickLightManager();
                break;
        }
    }
}

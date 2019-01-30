package com.blackshark.gamesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class LightManagerDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtLightOn;
    private Button mbtLightOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_manager_demo);
        mbtLightOn = findViewById(R.id.button_lighton);
        mbtLightOff = findViewById(R.id.button_lightoff);
        mbtLightOn.setOnClickListener(this);
        mbtLightOff.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        HashMap<String, String> event = new HashMap<>();
        switch (view.getId()) {
            case R.id.button_lighton:
                event.put(LightManager.EVENT_KEY_HUB_ID, LightManager.EVENT_HUB_ID_SIDE);
                event.put(LightManager.EVENT_KEY_NAME, LightManager.EVENT_NAME_SIDES_START);
                event.put(LightManager.EVENT_KEY_ANIMATION_ID, LightManager.EVENT_ANIMATION_SIDES_FLOW);
                event.put(LightManager.EVENT_KEY_LOOP, "0");
                LightManager.notifyLightEvent(event);
                break;
            case R.id.button_lightoff:
                event.put(LightManager.EVENT_KEY_HUB_ID, LightManager.EVENT_HUB_ID_SIDE);
                event.put(LightManager.EVENT_KEY_NAME, LightManager.EVENT_NAME_SIDES_END);
                LightManager.notifyLightEvent(event);
                break;
            default:
                break;
        }
    }
}

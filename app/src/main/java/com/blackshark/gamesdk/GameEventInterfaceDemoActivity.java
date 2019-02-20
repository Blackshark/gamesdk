package com.blackshark.gamesdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GameEventInterfaceDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditTextEvent;
    private EditText mEditTextScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_event_interface_demo);
        mEditTextEvent = findViewById(R.id.editText_event);
        mEditTextScene = findViewById(R.id.editText_scene);
        findViewById(R.id.button_event).setOnClickListener(this);
        findViewById(R.id.button_scene).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_event:
                GameEventInterface.notifyEvent(Integer.valueOf(String.valueOf(mEditTextEvent.getText())));
                break;
            case R.id.button_scene:
                GameEventInterface.notifyScene(Integer.valueOf(String.valueOf(mEditTextScene.getText())));
                break;
        }
    }
}

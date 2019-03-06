package com.blackshark.gamesdk;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


import java.io.IOException;

public class HapticDemoActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mPlayer;
    private AssetFileDescriptor mBoomSoundFd;
    private AssetFileDescriptor mAccelSoundFd;
    private CheckBox mCheckboxA2H;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haptic_demo);

        Button buttonCelerate = findViewById(R.id.button_celerate);
        Button buttonBoom = findViewById(R.id.button_boom);
        mCheckboxA2H = findViewById(R.id.checkBox_a2henabled);

        buttonCelerate.setOnClickListener(this);
        buttonBoom.setOnClickListener(this);
        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(this);
        try {
            mBoomSoundFd = getAssets().openFd("bomb.mp3");
            mAccelSoundFd = getAssets().openFd("Car-Accelerating.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playSound(int id, boolean a2hEnabled) {
        AssetFileDescriptor fd = null;
        switch (id) {
            case R.id.button_boom:
                fd = mBoomSoundFd;
                break;
            case R.id.button_celerate:
                fd = mAccelSoundFd;
                break;
        }
        mPlayer.reset();

        HapticManager.setAudio2HapticActive(this, a2hEnabled);


        try {
            mPlayer.setDataSource(fd);
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.start();
    }

    @Override
    public void onClick(View view) {
        playSound(view.getId(), mCheckboxA2H.isChecked());
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        HapticManager.setAudio2HapticActive(this, false);
    }
}

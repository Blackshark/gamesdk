package com.blackshark.gamesdk;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import android.util.Log;

/**
 * Class that operates the haptic effect on device. <br>
 * Requires the {@code android.permission.VIBRATE} permission.
 */
public class HapticManager {
    private static final String TAG = "BsGameSDK";
    private static AudioManager sAudioManager = null;
    private static final boolean DEBUG = Log.isLoggable(TAG, Log.VERBOSE);
    private static Vibrator sVibrator = null;

    /**
     * Returns whether the Audio to Haptic is supported on this device.
     * @return return true if the device support Audio to Haptic.
     */
    public static boolean isAudio2HapticSupported() {
        // TODO: NOT IMPLEMENTED YET
        return true;
    }

    /**
     * enable/disable Audio to Haptic.
     * IMPORTANT: DO'NOT keep Audio2Haptic active all the time, <br>
     * it's better to enable Audio2Haptic just while action/event is happening in the game, <br>
     * like gun shot, boom, engine start. <br>
     * Example: <br>
     * call {@code setAudio2HapticActive(true);} before pull the trigger of the gun, <br>
     * call {@code setAudio2HapticActive(false);} after release the trigger <br>
     * @param context context of the caller
     * @param active {@code true} to enable {@code false} to disable <br>
     */
    public static void setAudio2HapticActive(Context context, boolean active) {
        if (sAudioManager == null) {
            sAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            Log.d(TAG, "first initial sAudioManager");
        }
        if (active) {
            sAudioManager.setParameters("a2h_touch=1");
            if (DEBUG) Log.v(TAG, "setAudio2HapticActive true");
        } else {
            sAudioManager.setParameters("a2h_touch=0");
            if (DEBUG) Log.v(TAG, "setAudio2HapticActive false");
        }
    }

    /**
     * Vibrate with a given pattern. <br>
     * Pass in an array of ints that are the durations for which to turn on or off the vibrator in milliseconds. <br>
     * The first value indicates the number of milliseconds to wait before turning the vibrator on. <br>
     * The next value indicates the number of milliseconds for which to keep the vibrator on before turning it off. <br>
     * Subsequent values alternate between durations in milliseconds to turn the vibrator off or to turn the vibrator on. <br>
     * @param context context of the caller
     * @param pattern an array of longs of times for which to turn the vibrator on or off.
     */
    public static void vibrate(Context context, long[] pattern) {
        if (sVibrator == null) {
            sVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        sVibrator.vibrate(pattern, -1);
        if (DEBUG) Log.v(TAG, "vibrate invoked");
    }
}

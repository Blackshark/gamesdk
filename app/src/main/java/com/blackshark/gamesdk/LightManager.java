package com.blackshark.gamesdk;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * class that perform the rich light effects on Blackshark Gaming Phone.
 *
 */
public class LightManager {
    private static final String TAG = "BsGameSDK";

    /**
     * identifies which light to use, current we have {@link LightManager#EVENT_HUB_ID_LOGO}, {@link LightManager#EVENT_HUB_ID_SIDE}
     */
    public static final String EVENT_KEY_HUB_ID = "hub_id";
    /**
     * identifies event name
     */
    public static final String EVENT_KEY_NAME = "name";
    /**
     * identifies light animation effect id, these are available:
     * {@link LightManager#EVENT_ANIMATION_SIDES_RAINBOW}, {@link LightManager#EVENT_ANIMATION_SIDES_FLOW}, {@link LightManager#EVENT_ANIMATION_SIDES_FLOW_BOTH_WAY},
     * {@link LightManager#EVENT_ANIMATION_SIDES_GATHER}, {@link LightManager#EVENT_ANIMATION_SIDES_SPREAD}, {@link LightManager#EVENT_ANIMATION_SIDES_RHYTHM}
     */
    public static final String EVENT_KEY_ANIMATION_ID = "animate_id";
    /**
     * identifies how many cycles to play, "0" mean infinite
     */
    public static final String EVENT_KEY_LOOP = "loop";


    /**
     * id of side lights
     */
    public static final String EVENT_HUB_ID_SIDE = "SidesEventHub";
    /**
     * id of logo lights
     */
    public static final String EVENT_HUB_ID_LOGO = "LogoEventHub";

    /**
     * event name of light effect play start
     */
    public static final String EVENT_NAME_SIDES_START = "sides_perfect_world_start";
    /**
     * event name of light effect play stop
     */
    public static final String EVENT_NAME_SIDES_END = "sides_perfect_world_ended";

    /**
     * id of light animation, identifies Rainbow
     */
    public static final String EVENT_ANIMATION_SIDES_RAINBOW = "sides_rainbow";
    /**
     * id of light animation, identifies Flow
     */
    public static final String EVENT_ANIMATION_SIDES_FLOW = "sides_flow";
    /**
     * id of light animation, identifies Both-Way
     */
    public static final String EVENT_ANIMATION_SIDES_FLOW_BOTH_WAY = "sides_flow_both_way";
    /**
     * id of light animation, identifies Gather
     */
    public static final String EVENT_ANIMATION_SIDES_GATHER = "sides_gather";
    /**
     * id of light animation, identifies Spread
     */
    public static final String EVENT_ANIMATION_SIDES_SPREAD = "sides_spread";
    /**
     * id of light animation, identifies Rhythm
     */
    public static final String EVENT_ANIMATION_SIDES_RHYTHM = "sides_rhythm";

    private static boolean IS_SUPPORT_BSLIGHT = false;

    private static Class<?> EXLIGHT_CLASS = null;
    private static Method EXLIGHT_NOTIFYEVENT = null;

    static {
        try {
            EXLIGHT_CLASS = Class.forName("com.blackshark.exlight.ExLightManager");
            EXLIGHT_NOTIFYEVENT = EXLIGHT_CLASS.getMethod("notifyEvent", Map.class);
            if (EXLIGHT_CLASS != null && EXLIGHT_NOTIFYEVENT != null) {
                IS_SUPPORT_BSLIGHT = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "ExLightManager not supported.");
        }
    }

    /**
     * send event to LightManager to perform variety light effects.
     * @param event consists of sets of key-value pairs.
     *              <table border="1">
     *                  <thead bgcolor="gainsboro">
     *                      <tr>
     *                          <th>key name</th>
     *                          <th>value</th>
     *                      </tr>
     *                  </thead>
     *                  <tbody>
     *                      <tr>
     *                          <td>{@link LightManager#EVENT_KEY_HUB_ID}</td>
     *                          <td>{@link LightManager#EVENT_HUB_ID_SIDE}<br>
     *                              {@link LightManager#EVENT_HUB_ID_LOGO}</td>
     *                      </tr>
     *                      <tr>
     *                          <td>{@link LightManager#EVENT_KEY_NAME}</td>
     *                          <td>{@link LightManager#EVENT_NAME_SIDES_START}<br>
     *                              {@link LightManager#EVENT_NAME_SIDES_END}</td>
     *                      </tr>
     *                      <tr>
     *                          <td>{@link LightManager#EVENT_KEY_ANIMATION_ID}</td>
     *                          <td>{@link LightManager#EVENT_ANIMATION_SIDES_RAINBOW}<br>
     *                              {@link LightManager#EVENT_ANIMATION_SIDES_FLOW}<br>
     *                              {@link LightManager#EVENT_ANIMATION_SIDES_FLOW_BOTH_WAY}<br>
     *                              {@link LightManager#EVENT_ANIMATION_SIDES_GATHER}<br>
     *                              {@link LightManager#EVENT_ANIMATION_SIDES_SPREAD}<br>
     *                              {@link LightManager#EVENT_ANIMATION_SIDES_RHYTHM}</td>
     *                      </tr>
     *                      <tr>
     *                          <td>{@link LightManager#EVENT_KEY_LOOP}</td>
     *                          <td>integer string, how many cycles to play, "0" means infinite</td>
     *                      </tr>
     *                  </tbody>
     *              </table>
     *
     *
     *  <pre>
     *  sample:
     *  {@code
     *  // play start
     *  HashMap<String, String> startEvent = new HashMap<>();
     *  startEvent.put(LightManager.EVENT_KEY_HUB_ID, LightManager.EVENT_HUB_ID_SIDE);
     *  startEvent.put(LightManager.EVENT_KEY_NAME, LightManager.EVENT_NAME_SIDES_START);
     *  startEvent.put(LightManager.EVENT_KEY_ANIMATION_ID, LightManager.EVENT_ANIMATION_SIDES_FLOW);
     *  startEvent.put(LightManager.EVENT_KEY_LOOP, "0");
     *  LightManager.notifyLightEvent(startEvent);
     *
     *  // play stop
     *  HashMap<String, String> stopEvent = new HashMap<>();
     *  stopEvent.put(LightManager.EVENT_KEY_HUB_ID, LightManager.EVENT_HUB_ID_SIDE);
     *  stopEvent.put(LightManager.EVENT_KEY_NAME, LightManager.EVENT_NAME_SIDES_END);
     *  LightManager.notifyLightEvent(stopEvent);
     *  }</pre>
     */
    public static void notifyLightEvent(Map<String, String> event) {
        if (EXLIGHT_CLASS == null || EXLIGHT_NOTIFYEVENT == null) {
            Log.e(TAG, "not support ExLightManager.notifyEvent");
            return;
        }

        try {
            EXLIGHT_NOTIFYEVENT.invoke(null, event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * weather support Blackshark LightManager
     * @return true if Blackshark LightManager supported
     */
    public static boolean isLightManagerSupported() {
        return IS_SUPPORT_BSLIGHT;
    }
}

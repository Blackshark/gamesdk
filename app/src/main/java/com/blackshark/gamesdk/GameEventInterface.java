package com.blackshark.gamesdk;

import android.util.Log;
import java.lang.reflect.Method;

/**
 * BlackShark Gaming Phone has rich vibration, lighting effects.<br>
 * <code>GameEventInterface</code> is provided for Game vendor.<br>
 * Blackshark team will customize a set of vibration & light effects for your game's dedicated use.<br>
 */
public class GameEventInterface {
    private static final String TAG = "BsGameSDK";
    private static Class<?> GAME_EVENT_IF_CLS;
    private static Method GAME_EVENT_IF_NOTIFYEVENT;
    private static Method GAME_EVENT_IF_NOTIFYSCENE;

    static {
        try {
            GAME_EVENT_IF_CLS = Class.forName("com.blackshark.gamesdkmanager.Manager");
            GAME_EVENT_IF_NOTIFYEVENT = GAME_EVENT_IF_CLS.getMethod("notifyGameEvent", int.class);
            GAME_EVENT_IF_NOTIFYSCENE = GAME_EVENT_IF_CLS.getMethod("notifyGameScene", int.class);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "com.blackshark.gamesdkmanager.manager not supported.");
        }
    }

    /**
     * call this method When an action/event occurs in the game, device will perform corresponding light effect and vibration. <br>
     * The actions/events are defined by Game vendor, like following table. <br>
     * Blackshark team will customize light effect and vibration. <br>
     * actions/events are different for each game. <br>
     * Here is an example of a MOBA game: <br>
     * <table border="1">
     *     <thead bgcolor="gainsboro">
     *         <tr>
     *             <th>event id</th>
     *             <th>description</th>
     *         </tr>
     *     </thead>
     *     <tbody>
     *         <tr>
     *             <td>1</td>
     *             <td>attack</td>
     *         </tr>
     *         <tr>
     *             <td>2</td>
     *             <td>flash</td>
     *         </tr>
     *         <tr>
     *             <td>11</td>
     *             <td>skill 1</td>
     *         </tr>
     *         <tr>
     *             <td>12</td>
     *             <td>skill 2</td>
     *         </tr>
     *         <tr>
     *             <td>13</td>
     *             <td>skill 3</td>
     *         </tr>
     *         <tr>
     *             <td>……</td>
     *             <td>……</td>
     *         </tr>
     *     </tbody>
     * </table>
     *
     * @param eventId id of event
     * @return returns 0 if success, non-0 errorcode for errors.
     */
    public static int notifyEvent(int eventId) {
        if (GAME_EVENT_IF_CLS == null || GAME_EVENT_IF_NOTIFYEVENT == null) {
            return -1;
        }

        try {
            GAME_EVENT_IF_NOTIFYEVENT.invoke(null, eventId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * call this method When entering an specific scene, device will perform corresponding light effect and vibration. <br>
     * The scenes are defined by Game vendor, like following talbe. <br>
     * Blackshark team will customize light effect and vibration. <br>
     * scenes are different for each game. <br>
     * Here is an example of a MOBA game: <br>
     * <table border="1px">
     *     <thead bgcolor="gainsboro">
     *         <tr>
     *             <th>scene id</th>
     *             <th>description</th>
     *         </tr>
     *     </thead>
     *     <tbody>
     *         <tr>
     *             <td>1</td>
     *             <td>Welcome to Summoner's Rift!</td>
     *         </tr>
     *         <tr>
     *             <td>2</td>
     *             <td>You have slain an enemy</td>
     *         </tr>
     *         <tr>
     *             <td>3</td>
     *             <td>An enemy has been slain</td>
     *         </tr>
     *         <tr>
     *             <td>4</td>
     *             <td>You have been slain</td>
     *         </tr>
     *         <tr>
     *             <td>5</td>
     *             <td>An ally has been slain</td>
     *         </tr>
     *         <tr>
     *             <td>……</td>
     *             <td>……</td>
     *         </tr>
     *     </tbody>
     * </table>
     * @param sceneId id of scene
     * @return returns 0 if success, non-0 errorcode for errors.
     */
    public static int notifyScene(int sceneId) {
        if (GAME_EVENT_IF_CLS == null || GAME_EVENT_IF_NOTIFYSCENE == null) {
            return -1;
        }

        try {
            GAME_EVENT_IF_NOTIFYSCENE.invoke(null, sceneId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

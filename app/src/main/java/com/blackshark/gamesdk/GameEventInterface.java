package com.blackshark.gamesdk;

/**
 * ﻿BlackShark Gaming Phone has rich vibration, lighting effects.<br>
 * <code>GameEventInterface</code> is provided for Game vendor.<br>
 * Blackshark team will customize a set of vibration & light effects for your game's dedicated use.<br>
 */
public class GameEventInterface {
    /**
     * ﻿call this method When an action/event occurs in the game, device will perform corresponding light effect and vibration.<br>
     * The actions/events are defined by Game vendor, like following talbe.<br>
     * Blackshark team will customize light effect and vibration.
     * actions/events are different for each game.
     * Here is an example of a MOBA game:
     * <table border="1px">
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
     * @param eventId id of event
     * @return
     */
    public static int notifyEvent(int eventId) {
        return 0;
    }

    /**
     * ﻿call this method When entering an specific scene, device will perform corresponding light effect and vibration.<br>
     * The scenes are defined by Game vendor, like following talbe.<br>
     * Blackshark team will customize light effect and vibration.
     * scenes are different for each game.
     * Here is an example of a MOBA game:
     * <table border="1px">
     *     <thead bgcolor="gainsboro">
     *         <tr>
     *             <th>﻿scene id</th>
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
     * @return
     */
    public static int notifyScene(int sceneId) {
        return 0;
    }
}

### API Docs
https://blackshark.github.io/gamesdk/
### HOW TO USE
#### [LightManager](https://github.com/Blackshark/gamesdk/blob/master/app/src/main/java/com/blackshark/gamesdk/LightManager.java)
1. copy this [file](https://github.com/Blackshark/gamesdk/blob/master/app/src/main/java/com/blackshark/gamesdk/LightManager.java) into your project.
2. call LightManager.notifyEvent to start or stop light effect.
#### [GameEventInterface](https://blackshark.github.io/gamesdk/com/blackshark/gamesdk/GameEventInterface.html)
1. Game vendor defines the actions/events and scenes in game.
2. Blackshark team customize light effects and vibrations for each action/event/scene.
3. copy this [file](https://blackshark.github.io/gamesdk/com/blackshark/gamesdk/GameEventInterface.html) into your project.
4. calls GameEventInterface.notifyEvent and GameEventInterface.notifyScene when entering specific scene or action/event happened.

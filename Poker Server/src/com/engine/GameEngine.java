package com.engine;

import com.engine.event.EventManager;
import com.poker.lobby.Lobby;

/**
 * The game engine, the main class
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class GameEngine
{
    
    /**
     * Starts the game engine
     */
    public void start()
    {
        EventManager.get.initialiseExecutor();
        Lobby.get.initialise();
    }
    
}

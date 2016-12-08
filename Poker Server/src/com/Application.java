package com;

import com.engine.GameEngine;

/**
 * Main class
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class Application
{
    
    /**
     * Static game engine object
     */
    public static GameEngine gameEngine = new GameEngine();
    
    /**
     * The main game
     * @param strings
     */
    public static void main(String...strings)
    {
        gameEngine.start();
    }

}

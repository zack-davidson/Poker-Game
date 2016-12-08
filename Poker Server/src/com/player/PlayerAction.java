package com.player;

/**
 * A player action
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public abstract class PlayerAction
{
    
    /**
     * Gets the state of the action
     */
    public abstract ActionState getState();
    public abstract void process();
    
}

package com.engine.event;

/**
 * Abstract task class
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public abstract class Event
{
    /**
     * Checks if the event is stopped or not
     */
    private boolean stopped;
    
    /**
     * Checks if the event is paused or not
     */
    private boolean pause;
    
    /**
     * Abstract executes method, this gets ran over and over until stopped or paused
     */
    public abstract void execute();
    
    /**
     * Destroys the event
     */
    public void destroy()
    {
        setStopped(true);
    }
    
    /**
     * Pauses the event for further use
     */
    public void pause()
    {
        setPause(true);
    }
    
    /**
     * Resumes the event
     */
    public void resume()
    {
        setPause(false);
    }

    /**
     * Checks if the event has been stopped
     * 
     * @return - true if the event has been stopped
     */
    public boolean isStopped()
    {
        return stopped;
    }

    public void setStopped(boolean stopped)
    {
        this.stopped = stopped;
    }

    public boolean isPause()
    {
        return pause;
    }

    public void setPause(boolean pause)
    {
        this.pause = pause;
    }
    
    
}

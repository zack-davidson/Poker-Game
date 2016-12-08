package com.engine.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.engine.EngineConstants;

/**
 * EventManager class handles all the events<br>
 * This class has a singleton and private constructor
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class EventManager implements Runnable
{

    /**
     * EventManager Singleton
     */
    public static EventManager get = new EventManager();

    /**
     * Private Constructor
     */
    private EventManager()
    {
    }

    /**
     * All the events
     */
    private final Queue<Event> events = new ConcurrentLinkedQueue<>();

    /**
     * The executor object for scheduling tasks
     */
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * Initialises the executor
     */
    public void initialiseExecutor()
    {
        executor.scheduleAtFixedRate(this, EngineConstants.TICK_RATE, EngineConstants.TICK_RATE, TimeUnit.MILLISECONDS);
    }

    /**
     * Submits a task
     * 
     * @param event
     *            - the new task to be submitted
     */
    public void submitEvent(Event event)
    {
        events.add(event);
    }

    /**
     * The amount of engine ticks
     */
    private int engineTicks = 0;

    /**
     * Executes all events if they're required to be executed
     */
    public void execute()
    {
        List<Event> toRemove = new ArrayList<>();

        engineTicks++;
        System.out.println("Game Tick: " + engineTicks);

        for (Event event : events)
        {
            if (event == null || event.isStopped())
            {
                toRemove.add(event);
            }
            else if (!event.isPause())
            {
                event.execute();
            }
        }

        if (events.isEmpty()) return;

        for (Event event : toRemove)
        {
            events.remove(event);
        }

        toRemove.clear();
    }

    /**
     * Run method from {@link Runnable}
     */
    @Override
    public void run()
    {
        execute();
    }

}

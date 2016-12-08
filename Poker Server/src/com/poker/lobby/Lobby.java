package com.poker.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.engine.event.EventManager;
import com.player.Player;
import com.player.TablePlayer;
import com.poker.table.Blinds;
import com.poker.table.Table;

/**
 * The lobby controller, contains methods for finding a game
 * 
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class Lobby
{
    /**
     * Lobby Singleton Object
     */
    public static Lobby get = new Lobby();

    /**
     * Private Constructor
     */
    private Lobby()
    {
    }

    /**
     * All the tables
     */
    private List<Table> tables = new ArrayList<>();

    /**
     * Initialises the tables
     */
    public void initialise()
    {
        tables.add(new Table("Testing 1", new Blinds(15, 30), 6));

        for (Table t : tables)
        {
            t.initialiseTable();
            EventManager.get.submitEvent(t);
        }
    }

    /**
     * Finds a table with a specified name
     * 
     * @param name
     *            - the name of the table
     * @return - optional table
     */
    public Optional<Table> find(String name)
    {
        for (Table t : tables)
        {
            if (t.getTableName().equalsIgnoreCase(name)) { return Optional.of(t); }
        }
        return null;
    }

    /**
     * Joins a table with a name
     * 
     * @param name
     *            - the name of the table
     * @param player
     *            - the player joining the table
     */
    public void joinTable(String name, Player player)
    {
        Optional<Table> table = find(name);
        table.get().addPlayer(TablePlayer.convert(player, 10000));
    }
}

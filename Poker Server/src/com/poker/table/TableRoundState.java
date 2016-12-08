package com.poker.table;

/**
 * All the possible table round states
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public enum TableRoundState
{
    /**
     * The starting round, give all players cards, let them decide what they want to do
     * 
     */
    START,
    FLOP,
    MIDDLE,
    FINAL
}

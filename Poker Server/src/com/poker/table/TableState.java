package com.poker.table;

/**
 * All the possible table states
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public enum TableState
{
    WAITING_FOR_PLAYERS
    {
        @Override
        public String toString()
        {
            return "Waiting For Players";
        }
    },
    IN_ROUND
    {
        @Override
        public String toString()
        {
            return "In Round";
        }
    },
    
    
    
    
}

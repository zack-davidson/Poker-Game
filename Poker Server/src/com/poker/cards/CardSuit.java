package com.poker.cards;

/**
 * All the possible card suits
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public enum CardSuit
{
    /**
     * The hearts suit
     */
    HEARTS
    {
        @Override
        public String toString()
        {
            return "Hearts";
        }
    },

    /**
     * The spades suit
     */
    SPADES
    {
        @Override
        public String toString()
        {
            return "Spades";
        }
    },

    /**
     * The diamonds suit
     */
    DIAMONDS
    {
        @Override
        public String toString()
        {
            return "Diamonds";
        }
    },

    /**
     * The clubs suit
     */
    CLUBS
    {
        @Override
        public String toString()
        {
            return "Clubs";
        }
    }
}

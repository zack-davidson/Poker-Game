package com.poker.cards;

/**
 * The card face
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public enum CardFace
{
    ACE(0)
    {
        @Override
        public String toString()
        {
            return "Ace";
        }
    },
    TWO(1)
    {
        @Override
        public String toString()
        {
            return "Two";
        }
    },
    THREE(2)
    {
        @Override
        public String toString()
        {
            return "Three";
        }
    },
    FOUR(3)
    {
        @Override
        public String toString()
        {
            return "Four";
        }
    },
    FIVE(4)
    {
        @Override
        public String toString()
        {
            return "Five";
        }
    },
    SIX(5)
    {
        @Override
        public String toString()
        {
            return "Six";
        }
    },
    SEVEN(6)
    {
        @Override
        public String toString()
        {
            return "Seven";
        }
    },
    EIGHT(7)
    {
        @Override
        public String toString()
        {
            return "Eight";
        }
    },
    NINE(8)
    {
        @Override
        public String toString()
        {
            return "Nine";
        }
    },
    TEN(9)
    {
        @Override
        public String toString()
        {
            return "Ten";
        }
    },
    JACK(10)
    {
        @Override
        public String toString()
        {
            return "Jack";
        }
    },
    QUEEN(11)
    {
        @Override
        public String toString()
        {
            return "Queen";
        }
    },
    KING(12)
    {
        @Override
        public String toString()
        {
            return "King";
        }
    };
    
    /**
     * The index of the card
     */
    private final int index;

    /**
     * Private Constructor
     * @param index - the index of the card
     */
    private CardFace(int index)
    {
        this.index = index;
    }

    /**
     * Getter for {@link #index}
     * @return - {@link #index}
     */
    public final int getIndex()
    {
        return index;
    }
    
    /**
     * Gets a face by its index
     * 
     * @param index - the index
     * @return - the cardface object
     */
    public static CardFace getByIndex(int index)
    {
        if(index == 13) index = 0;
        for(CardFace face : values())
        {
            if(face.getIndex() == index)
            {
                return face;
            }
        }
        return null;
    }
    
    /**
     * Gets a card by its name
     * 
     * @param name - the name of the card we are looking for
     * @return - the CardFace object of the name
     */
    public static CardFace getByName(String name) 
    {
        for(CardFace face : values()) 
        {
            if(face.toString().equalsIgnoreCase(name))
            {
                return face;
            }
        }
        return null;
    }
    
}

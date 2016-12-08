package com.poker.table;

/**
 * Contains the small blinds and large blinds for a table
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class Blinds
{
    /**
     * The small blinds
     */
    private double smallBlind;

    /**
     * The large blinds
     */
    private double largeBlind;

    /**
     * Constructor
     * 
     * @param smallBlind
     *            - the small blinds
     * @param largeBlind
     *            - the large blinds
     */
    public Blinds(double smallBlind, double largeBlind)
    {
        this.smallBlind = smallBlind;
        this.largeBlind = largeBlind;
    }

    /**
     * Getter for {@link #smallBlind}
     * 
     * @return {@link #smallBlind}
     */
    public double getSmallBlind()
    {
        return smallBlind;
    }

    /**
     * Getter for {@link #largeBlind}
     * 
     * @return {@link #largeBlind}
     */
    public double getLargeBlind()
    {
        return largeBlind;
    }

    /**
     * @param smallBlind the smallBlind to set
     */
    public void setSmallBlind(double smallBlind)
    {
        this.smallBlind = smallBlind;
    }

    /**
     * @param largeBlind the largeBlind to set
     */
    public void setLargeBlind(double largeBlind)
    {
        this.largeBlind = largeBlind;
    }

}

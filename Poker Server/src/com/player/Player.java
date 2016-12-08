package com.player;

/**
 * A player, this will be saved and loaded
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class Player
{
    
    /**
     * A players name
     */
    private String name;
    
    /**
     * A players bank amount, how much they currently have in their bank
     */
    private double bankAmount;
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getBankAmount()
    {
        return bankAmount;
    }
    public void setBankAmount(double bankAmount)
    {
        this.bankAmount = bankAmount;
    }

}

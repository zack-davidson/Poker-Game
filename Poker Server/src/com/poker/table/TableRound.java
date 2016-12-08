package com.poker.table;

import java.util.ArrayList;
import java.util.List;

import com.player.TablePlayer;

/**
 * A table round object
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class TableRound
{
    private Table owner;
    private List<TablePlayer> inRound = new ArrayList<>();
    private List<TablePlayer> completeRound = new ArrayList<>();
    
    private TablePlayer dealer;
    private TablePlayer selectedPlayer;
    private double currentPot;
    private double buyInPot;
    private int timer;
    
    public void playerCheck(TablePlayer player)
    {
        inRound.remove(player);
        completeRound.add(player);
    }
    
    public void startRound()
    {
        dealer = inRound.get(0);
        
    }
    
    public void payBlinds()
    {
        
    }
    
    public void makePayment(TablePlayer player, double amount)
    {
        if(player.getYourChips() - amount <= 0)
        {
            currentPot += player.getYourChips();
            
            player.deductChips(player.getYourChips());
            
        }
    }
    
    public void workBuyInPot(double amount)
    {
        if(amount > buyInPot)
        {
            buyInPot = amount;
        }
    }
    
    public Table getOwner()
    {
        return owner;
    }
    public void setOwner(Table owner)
    {
        this.owner = owner;
    }
    public List<TablePlayer> getInRound()
    {
        return inRound;
    }
    public void setInRound(List<TablePlayer> inRound)
    {
        this.inRound = inRound;
    }
    public TablePlayer getDealer()
    {
        return dealer;
    }
    public void setDealer(TablePlayer dealer)
    {
        this.dealer = dealer;
    }
    public TablePlayer getSelectedPlayer()
    {
        return selectedPlayer;
    }
    public void setSelectedPlayer(TablePlayer selectedPlayer)
    {
        this.selectedPlayer = selectedPlayer;
    }
    public double getCurrentPot()
    {
        return currentPot;
    }
    public void setCurrentPot(double currentPot)
    {
        this.currentPot = currentPot;
    }
    public double getBuyInPot()
    {
        return buyInPot;
    }
    public void setBuyInPot(double buyInPot)
    {
        this.buyInPot = buyInPot;
    }
    public int getTimer()
    {
        return timer;
    }
    public void setTimer(int timer)
    {
        this.timer = timer;
    }

    public List<TablePlayer> getCompleteRound()
    {
        return completeRound;
    }

    public void setCompleteRound(List<TablePlayer> completeRound)
    {
        this.completeRound = completeRound;
    }
    
}

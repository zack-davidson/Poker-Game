package com.player;

import java.util.ArrayList;
import java.util.List;

import com.poker.cards.Card;
import com.poker.table.TableRound;

/**
 * A table player, an object whom is currently on a table
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class TablePlayer
{
    private String name;
    private Player owner;
    private double yourChips;
    private List<Card> handCards;
    private int handStrength;
    private boolean sittingOut;
    private double yourRoundBets;
    private PlayerAction selectedAction;
    private boolean allIn;
    
    public double getYourRoundBets()
    {
        return yourRoundBets;
    }

    public void setYourRoundBets(double yourRoundBets)
    {
        this.yourRoundBets = yourRoundBets;
    }

    public boolean isAllIn()
    {
        return allIn;
    }

    public void setAllIn(boolean allIn)
    {
        this.allIn = allIn;
    }

    public void setAction(PlayerAction action)
    {
        setSelectedAction(action);
    }
    
    public void executeAction(TableRound round)
    {
        if(selectedAction.getState() == ActionState.FOLD)
        {
            round.getInRound().remove(this);
        }
        if(selectedAction.getState() == ActionState.CHECK)
        {
           // round.get
        }
    }
    
    public static TablePlayer convert(Player player, double tableMoney)
    {
        return new TablePlayer(player, tableMoney);
    }
    
    public TablePlayer(Player owner, double tableMoney)
    {
        this.name = owner.getName();
        this.owner = owner;
        this.yourChips = tableMoney;
        this.handCards = new ArrayList<>();
    }
    
    /**
     * Adds a card to the players hand
     * 
     * @param card
     * @return
     */
    public boolean addCard(Card card)
    {
        return handCards.add(card);
    }
    
    /**
     * Gets the players highest card
     * 
     * @return - the highest card object
     */
    public int getHighCard()
    {
        int firstCard = handCards.get(0).getCardFace().getIndex();
        int secondHand = handCards.get(1).getCardFace().getIndex();
        
        if(firstCard == 0) return 13;
        if(secondHand == 0) return 13;
        
        if(firstCard >= secondHand)
        {
            return handCards.get(0).getCardFace().getIndex();
        }
        else
        {
            return handCards.get(1).getCardFace().getIndex();
        }
    }
    
    /**
     * Removes the card the player has
     * 
     * @param index - the index of the card
     * @return
     */
    public Card removeCard(int index)
    {
        return handCards.remove(index);
    }
    
    public void printCards()
    {
        System.out.println("[" + name + "] I have the " + handCards.get(0).toString() + " and the " + handCards.get(1).toString());
    }
    
    public List<Card> getHandCards()
    {
        return handCards;
    }

    public void setHandCards(List<Card> handCards)
    {
        this.handCards = handCards;
    }

    public int getHandStrength()
    {
        return handStrength;
    }

    public void setHandStrength(int handStrength)
    {
        this.handStrength = handStrength;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    public double getYourChips()
    {
        return yourChips;
    }
    
    /**
     * Deducts chips from the player
     * @param amount
     */
    public void deductChips(double amount)
    {
        if(yourChips - amount <= 0) 
        {
            yourChips = 0;
            return;
        }
        yourChips -= amount;
    }

    public void setYourChips(double tableMoney)
    {
        this.yourChips = tableMoney;
    }

    public boolean isSittingOut()
    {
        return sittingOut;
    }

    public void setSittingOut(boolean sittingOut)
    {
        this.sittingOut = sittingOut;
    }

    public PlayerAction getSelectedAction()
    {
        return selectedAction;
    }

    public void setSelectedAction(PlayerAction selectedAction)
    {
        this.selectedAction = selectedAction;
    }
    
}

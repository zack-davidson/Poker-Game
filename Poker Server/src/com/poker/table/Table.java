package com.poker.table;

import java.util.ArrayList;
import java.util.List;

import com.engine.event.Event;
import com.player.TablePlayer;
import com.poker.cards.Card;
import com.poker.cards.CardDeck;
import com.poker.cards.CardEvaluation;

/**
 * A Table object, will contain players
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class Table extends Event
{

    /**
     * The card deck
     */
    private CardDeck cardDeck;
    
    /**
     * The state of the table
     */
    private TableState tableState;

    /**
     * The name of the table
     */
    private String tableName;

    /**
     * The players in the table
     */
    private List<TablePlayer> players = new ArrayList<>();

    /**
     * The table dealer
     */
    private TablePlayer dealer;

    /**
     * The blinds of the table
     */
    private Blinds blinds;

    /**
     * The pot of the table
     */
    private double pot;

    /**
     * The tables middle cards
     */
    private List<Card> middleCards;

    /**
     * The maxiumum amount of players that can join the list
     */
    private final int maxPlayers;
    

    /**
     * Initialises the table
     */
    public void initialiseTable()
    {
        cardDeck.generateNewDeck();
        cardDeck.shuffleDeck();
    }

    /**
     * Gets the players count
     * 
     * @return
     */
    public int getPlayerCount()
    {
        return players.size();
    }

    public Table(String tableName, Blinds blinds, int maxPlayers)
    {
        this.tableName = tableName;
        this.maxPlayers = maxPlayers;
        this.cardDeck = new CardDeck();
        this.blinds = blinds;
        middleCards = new ArrayList<>();
    }

    /**
     * Gives all players on the table cards
     */
    public void drawPlayerCards()
    {
        for (TablePlayer player : players)
        {
            Card c1 = cardDeck.withdrawCard();
            Card c2 = cardDeck.withdrawCard();
            player.addCard(c2);
            player.addCard(c1);
        }
    }

    /**
     * Places all cards on the table
     */
    public void drawTableCards()
    {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            cards.add(cardDeck.withdrawCard());
        }
        middleCards.addAll(cards);
    }

    /**
     * Prints all table cards to the console
     */
    public void printTableCards()
    {
        System.out.println("---- Table Cards -----");
        for (Card c : middleCards)
        {
            System.out.println(c.toString());
        }
    }

    /**
     * Collects all cards from everyone this shuffles the deck again
     */
    public void collectAllCards()
    {
        List<Card> withdrawenCards = new ArrayList<>();

        withdrawenCards.addAll(middleCards);
        middleCards.clear();
        for (TablePlayer player : players)
        {
            withdrawenCards.addAll(player.getHandCards());
            player.getHandCards().clear();
        }

        for (Card c : withdrawenCards)
        {
            cardDeck.addCard(c);
        }

        cardDeck.shuffleDeck();
    }

    /**
     * Picks a winner from the players
     * 
     * @return - a list of winners
     */
    public List<TablePlayer> pickWinner()
    {
        for (TablePlayer p : players)
        {
            System.out.println("checking " + p.getName() + " score");
            CardEvaluation eval = new CardEvaluation(p.getHandCards(), middleCards);
            p.setHandStrength(eval.calculateHandStrength());
            System.out.println("got " + p.getHandStrength() + "");
        }

        List<TablePlayer> possibleWinners = new ArrayList<>();

        int highestStrength = -1;
        for (TablePlayer p : players)
        {
            if (p.getHandStrength() > highestStrength)
            {
                highestStrength = p.getHandStrength();
            }
        }

        for (TablePlayer p : players)
        {
            if (p.getHandStrength() == highestStrength)
            {
                possibleWinners.add(p);
            }
        }
        // Highest card comparisons
        if (possibleWinners.size() > 1 && highestStrength == 0)
        {
            int highest = -1;
            for (TablePlayer e : possibleWinners)
            {
                if (e.getHighCard() > highest)
                {
                    highest = e.getHighCard();
                }
            }

            List<TablePlayer> newWinners = new ArrayList<>();

            for (TablePlayer e : possibleWinners)
            {
                if (e.getHighCard() == highest)
                {
                    newWinners.add(e);
                }
            }
            return newWinners;
        }
        // This is the one pair comparisons
        else if (possibleWinners.size() > 1 && highestStrength == 1)
        {
            int highestPair = -1;
            for (TablePlayer e : possibleWinners)
            {
                int currentValue = CardEvaluation.getPairValue(e.getHandCards(), middleCards);
                if (currentValue > highestPair)
                {
                    highestPair = currentValue;
                }
            }

            List<TablePlayer> newWinners = new ArrayList<>();

            for (TablePlayer e : possibleWinners)
            {
                int currentValue = CardEvaluation.getPairValue(e.getHandCards(), middleCards);
                if (currentValue == highestPair)
                {
                    newWinners.add(e);
                }
            }
            return newWinners;
        }

        return possibleWinners;
    }

    /**
     * Adds a player to the table
     * 
     * @param player
     * @return
     */
    public boolean addPlayer(TablePlayer player)
    {
        if (players.size() >= maxPlayers) return false;

        players.add(player);
        return true;
    }

    public CardDeck getCardDeck()
    {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck)
    {
        this.cardDeck = cardDeck;
    }

    public List<TablePlayer> getPlayers()
    {
        return players;
    }

    public void setPlayers(List<TablePlayer> players)
    {
        this.players = players;
    }

    public TablePlayer getDealer()
    {
        return dealer;
    }

    public void setDealer(TablePlayer dealer)
    {
        this.dealer = dealer;
    }

    public Blinds getBlinds()
    {
        return blinds;
    }

    public void setBlinds(Blinds blinds)
    {
        this.blinds = blinds;
    }

    public double getPot()
    {
        return pot;
    }

    public void setPot(double pot)
    {
        this.pot = pot;
    }

    public List<Card> getMiddleCards()
    {
        return middleCards;
    }

    public void setMiddleCards(List<Card> middleCards)
    {
        this.middleCards = middleCards;
    }

    public String getTableName()
    {
        return tableName;
    }

    public TableState getTableState()
    {
        return tableState;
    }

    public void setTableState(TableState tableState)
    {
        this.tableState = tableState;
    }

    public int getMaxPlayers()
    {
        return maxPlayers;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    @Override
    public void execute()
    {
        tableState = decideState();
        System.out.println(tableState.toString());
        System.out.println("Table " + getTableName() + "'s current state is: " + tableState.toString());
        
        if(tableState == TableState.WAITING_FOR_PLAYERS)
        {
            
        }
    }
    
    /**
     * Decides the state of the table
     * @return
     */
    private TableState decideState()
    {
        if(players.size() <= 1)
        {
            return TableState.WAITING_FOR_PLAYERS;
        }
        
        
        return null;
    }
    
}

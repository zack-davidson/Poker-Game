package com.poker.cards;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A deck object, contains all possible card combinations
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class CardDeck
{

    /**
     * The random object
     */
    private final static Random RANDOM = new SecureRandom();

    /**
     * All the cards
     */
    public List<Card> cards = new ArrayList<>();

    /**
     * Generates a new deck in a-z fashion <br>
     * This clears the already existing deck of cards<br>
     * This method does <b>not</b> shuffle the deck
     */
    public void generateNewDeck()
    {
        cards.clear();
        for (CardSuit suit : CardSuit.values())
        {
            for (CardFace face : CardFace.values())
            {
                cards.add(new Card(face, suit));
            }
        }
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffleDeck()
    {
        Collections.shuffle(cards);
    }

    /**
     * Withdraws a random card from the deck
     * 
     * @return - the withdrawn cards object
     */
    public Card withdrawCard()
    {
        int index = RANDOM.nextInt(cards.size());
        return cards.remove(index);
    }

    /**
     * Adds a card to the deck
     * 
     * @param card
     * @return
     */
    public boolean addCard(Card card)
    {
        if (cards.contains(card)) { return false; }

        return cards.add(card);
    }
    
    /**
     * Prints the cards to the console
     */
    public void print()
    {
        int index = 0;
        for(Card c : cards)
        {
            index++;
            System.out.println(c + " : " + index);
        }
    }
    
}

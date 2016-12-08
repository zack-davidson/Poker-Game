package com.poker.cards;

/**
 * A card data class
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public final class Card
{
    /**
     * The card face
     */
    private final CardFace cardFace;

    /**
     * The card suit
     */
    private final CardSuit cardSuit;

    /**
     * Public Constructor for card
     * 
     * @param cardFace
     *            - the card face
     * @param cardSuit
     *            - the card suit
     */
    public Card(CardFace cardFace, CardSuit cardSuit)
    {
        this.cardFace = cardFace;
        this.cardSuit = cardSuit;
    }

    /**
     * Getter for {@link #cardFace}
     * 
     * @return - {@link #cardFace}
     */
    public CardFace getCardFace()
    {
        return cardFace;
    }

    /**
     * Getter for {@link #cardSuit}
     * 
     * @return - {@link #cardSuit}
     */
    public CardSuit getCardSuit()
    {
        return cardSuit;
    }

    /**
     * Checks if a card is equal to another card <br>
     * Checks if the face and suit are equal to the specific card
     * 
     * @param card
     *            - the card we are checking
     * @return - true if the cards are equal
     */
    public boolean equals(Card card)
    {
        return this.cardFace == card.cardFace && this.cardSuit == card.cardSuit;
    }
    
    /**
     * Converts a card to a string
     * <br>
     * For Example: 7 of Diamonds
     */
    @Override
    public String toString()
    {
        return cardFace.toString() + " of " + cardSuit.toString();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        Card card = (Card) obj;
        return equals(card);
    }
}

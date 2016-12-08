package com.poker.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * A card evaluation system
 * 
 * @author Zack Davidson <zackdavidson2014@outlook.com>
 */
public class CardEvaluation
{

    /**
     * Your cards
     */
    private List<Card> yourCards;

    /**
     * All cards on the board
     */
    private List<Card> boardCards;

    public CardEvaluation(List<Card> yourCards, List<Card> boardCards)
    {
        this.yourCards = yourCards;
        this.boardCards = boardCards;
    }

    /**
     * Gets the winning message
     * 
     * @param cardStrength
     * @return - a string representation of a win
     */
    public static String getWinningMessage(int cardStrength)
    {
        switch (cardStrength)
        {
            case 9:
                return "with A Royal Flush";
            case 7:
                return "with Four of a Kind";
            case 6:
                return "with a Full House";
            case 5:
                return "with a Flush";
            case 3:
                return "with Three of a Kind";
            case 2:
                return "with Two Pair";
            case 1:
                return "with One Pair";
            case 0:
                return "with a High Card";
            default:
                return " didn't get anything ";
        }
    }

    /**
     * Your points
     * 
     * @return - the card strength
     */
    public int calculateHandStrength()
    {
        if (hasRoyalFlush()) return 9;
        else if (hasFourOfAKind()) return 7;
        else if (hasFullHouse()) return 6;
        else if (hasFlush()) return 5;
        else if (hasThreeOfAKind()) return 3;
        else if (hasTwoPair()) return 2;
        else if (hasOnePair()) return 1;
        return 0;
    }

    /**
     * Checks if the player has four of a kind
     * 
     * @return - true if the player has 5 of a kind
     */
    private boolean hasFourOfAKind()
    {
        if (countBoardCards(yourCards.get(0).getCardFace()) == 3)
        {
            return true;
        }
        else if (countBoardCards(yourCards.get(1).getCardFace()) == 3) { return true; }
        return false;
    }

    /**
     * Checks if the person has a full house
     * 
     * @return - true if the person has a full house
     */
    private boolean hasFullHouse()
    {
        if (countBoardCards(yourCards.get(0).getCardFace()) == 2
                && countBoardCards(yourCards.get(1).getCardFace()) == 1)
        {
            return true;
        }
        else if (countBoardCards(yourCards.get(1).getCardFace()) == 2
                && countBoardCards(yourCards.get(0).getCardFace()) == 1) { return true; }
        return false;
    }

    /**
     * Checks if the player has a flush
     * 
     * @return - true if the player has a flush
     */
    private boolean hasFlush()
    {
        List<CardSuit> yourSuits = new ArrayList<>();
        int counter = 1;
        for (Card c : yourCards)
        {
            if (yourSuits.contains(c.getCardSuit()))
            {
                counter++;
            }
            else
            {
                yourSuits.add(c.getCardSuit());
            }
        }

        for (CardSuit u : yourSuits)
        {
            if (hasFlushForSuit(u, counter)) { return true; }
        }
        return false;
    }

    /**
     * Checks if the person has a flush for a specified suit
     * 
     * @param suit
     *            - the suit the person has
     * @param start
     *            - the starting number
     * @return - true if the person has the flush
     */
    private boolean hasFlushForSuit(CardSuit suit, int start)
    {
        int total = 0 + start;

        for (Card c : boardCards)
        {
            if (c.getCardSuit() == suit)
            {
                total++;
            }
        }

        if (total == 5) return true;
        return false;
    }

    /**
     * Checks if the person has three of a kind
     * 
     * @return - true if the person has three of a kind
     */
    private boolean hasThreeOfAKind()
    {
        int counter = 0;
        for (Card u : yourCards)
        {
            for (Card b : boardCards)
            {
                if (u.getCardFace() == b.getCardFace())
                {
                    counter++;
                }
                if (counter == 2) { return true; }
            }
            counter = 0;
        }
        return false;
    }

    /**
     * Checks if the player has two pairs
     * 
     * @return - true if the player has two pairs
     */
    private boolean hasTwoPair()
    {
        boolean hasFirst = false;
        boolean hasSecond = false;

        for (Card u : yourCards)
        {
            for (Card b : boardCards)
            {
                if (!hasFirst)
                {
                    if (u.getCardFace() == b.getCardFace())
                    {
                        hasFirst = true;
                    }
                }
                else
                {
                    if (u.getCardFace() == b.getCardFace())
                    {
                        hasSecond = true;
                    }
                }
            }
        }

        if (yourCards.get(0).getCardFace() == yourCards.get(1).getCardFace())
        {
            for (Card b : boardCards)
            {
                if (b.getCardFace() == yourCards.get(0).getCardFace()) { return true; }
            }
        }

        return hasFirst && hasSecond;
    }

    /**
     * Checks if the person has one pair
     * 
     * @return - true if the person does
     */
    private boolean hasOnePair()
    {
        for (Card u : yourCards)
        {
            for (Card b : boardCards)
            {
                if (u.getCardFace().getIndex() == b.getCardFace().getIndex()) { return true; }
            }
        }
        if (yourCards.get(0).getCardFace().getIndex() == yourCards.get(1).getCardFace().getIndex()) { return true; }
        return false;
    }

    /**
     * Gets pair value
     * 
     * @param yourCards
     *            - your cards vs the board
     * @param boardCards
     *            - the cards on your board
     * @return - an integer value of pairs
     */
    public static int getPairValue(List<Card> yourCards, List<Card> boardCards)
    {
        for (Card u : yourCards)
        {
            for (Card b : boardCards)
            {
                if (u.getCardFace().getIndex() == b.getCardFace().getIndex()) { return u.getCardFace().getIndex(); }
            }
        }
        if (yourCards.get(0).getCardFace().getIndex() == yourCards.get(1).getCardFace()
                .getIndex()) { return yourCards.get(0).getCardFace().getIndex(); }
        return -1;
    }

    /**
     * Checks if the player has a royal flush
     * 
     * @return
     */
    private boolean hasRoyalFlush()
    {
        return hasRoyalFlushForSuit(CardSuit.CLUBS) || hasRoyalFlushForSuit(CardSuit.DIAMONDS)
                || hasRoyalFlushForSuit(CardSuit.HEARTS) || hasRoyalFlushForSuit(CardSuit.SPADES);
    }

    /**
     * Checks if the player has a royal flush for a speicified suit
     * 
     * @param suit
     *            - the suit we are checking
     * @return - true if the player doesn't have a royal flush
     */
    private boolean hasRoyalFlushForSuit(CardSuit suit)
    {
        List<Card> cardsNeeded = new ArrayList<>();
        List<Card> continuedCards = new ArrayList<>();

        cardsNeeded.add(new Card(CardFace.TEN, suit));
        cardsNeeded.add(new Card(CardFace.JACK, suit));
        cardsNeeded.add(new Card(CardFace.QUEEN, suit));
        cardsNeeded.add(new Card(CardFace.KING, suit));
        cardsNeeded.add(new Card(CardFace.ACE, suit));

        int counter = 0;

        for (Card need : cardsNeeded)
        {
            if (yourCards.contains(need))
            {
                counter++;
            }
            else
            {
                continuedCards.add(need);
            }
        }
        if (counter == 0) return false;

        else if (counter == 1)
        {
            int needFour = 0;
            for (Card c : boardCards)
            {
                if (continuedCards.contains(c))
                {
                    needFour++;
                }
                if (needFour == 4) return true;
            }
        }
        else if (counter == 2)
        {
            int needThree = 0;
            for (Card c : boardCards)
            {
                if (continuedCards.contains(c))
                {
                    needThree++;
                }
                if (needThree == 3) return true;
            }
        }
        return false;
    }

    /**
     * Checks if the person has a straight flush
     * 
     * @param suit
     *            - the persons suit of a card
     * @return - true if the person has a straight flush
     */
    // TODO: finish straight flush
    private boolean hasStraightFlushForSuit(CardSuit suit)
    {
        List<Integer> indencies = new ArrayList<>();

        int currentIndex = 0;

        for (Card c : yourCards)
        {
            if (c.getCardSuit() == suit)
            {
                currentIndex++;
                indencies.add(c.getCardFace().getIndex());
            }
        }
        if (currentIndex == 0) return false;
        else
        {
            for (Card c : boardCards)
            {
                if (c.getCardSuit() == suit)
                {
                    indencies.add(c.getCardFace().getIndex());
                }

            }
        }
        if (indencies.size() <= 4) return false;

        indencies.sort(null);

        for (int index = 0; index < indencies.size(); index++)
        {
            // boolean reset = false;
            if (index + 1 < indencies.size())
            {
            }
            if (getNextCardIndex(indencies.get(index)) == indencies.get(index + 1))
            {
            }
        }
        return false;
    }

    /**
     * Counts all board cards
     * 
     * @param face - of all faces
     * @return - the amount of facing cards on the board
     */
    private int countBoardCards(CardFace face)
    {
        int counter = 0;
        for (Card c : boardCards)
        {
            if (c.getCardFace() == face)
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Gets the next card index
     * 
     * @param previousCardIndex
     *            - the previous card index
     * @return - the next card index value
     */
    public int getNextCardIndex(int previousCardIndex)
    {
        return previousCardIndex + 1 == 13 ? 0 : previousCardIndex + 1;
    }

    public List<Card> getYourCards()
    {
        return yourCards;
    }

    public void setYourCards(List<Card> yourCards)
    {
        this.yourCards = yourCards;
    }

    public List<Card> getBoardCards()
    {
        return boardCards;
    }

    public void setBoardCards(List<Card> boardCards)
    {
        this.boardCards = boardCards;
    }

}

package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of card.
 *
 */
public class CardDeck {

  ArrayList<PlayingCard> cardDeck;
  /**
   * The suits of the cards.
   */
  private final char[] suits = {PlayingCard.CLUBS, PlayingCard.HEARTS,
      PlayingCard.DIAMONDS, PlayingCard.SPADES};


  /**
   * Constructor.
   */
  public CardDeck(){
    this.cardDeck = new ArrayList<>();
    this.initCardDeck();
  }

  /**
   * adds a card to the deck of cards.
   * @return boolean for success or failure.
   */
  public boolean addCard(PlayingCard card){
    if (card == null){
      return false;
    }
    this.cardDeck.add(card);

    return true;
  }

  /**
   * Deals a hand of cards from the deck, deals n amount of cards.
   * @param n the amount of cards to deal.
   * @return a list of cards.
   */
    public List<PlayingCard> dealHand(int n){
    if (n > 52 || n < 1){
      throw  new IllegalArgumentException("not a valid number of cards to draw from the deck.");
    }
    ArrayList<PlayingCard> cards = new ArrayList<>(this.cardDeck);
    ArrayList<PlayingCard> hand = new ArrayList<>();
    Random rand = new Random();
    ArrayList<PlayingCard> removedHand = new ArrayList<>();
    for(int i = 1; i <= n; i++){
      int nextRandInt  = rand.nextInt(cards.size()-1);
      PlayingCard nextRandCard = cards.get(nextRandInt);
      hand.add(nextRandCard);
      cards.remove(nextRandCard);
    }
    return hand;
  }


  /**
   * Creates a 52 card deck of cards.
   */
  private void initCardDeck(){
        ;
    for (char suit : this.suits) {
      for (int j = 1; j <= 13; j++) {
        PlayingCard card = new PlayingCard(suit, j);
        this.cardDeck.add(card);
      }
    }
  }
}

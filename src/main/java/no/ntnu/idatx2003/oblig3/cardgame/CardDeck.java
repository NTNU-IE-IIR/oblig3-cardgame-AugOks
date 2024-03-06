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

  HashMap<String, PlayingCard> cardDeck;

  private final char[] suits = {PlayingCard.CLUBS, PlayingCard.HEARTS,
      PlayingCard.DIAMONDS, PlayingCard.SPADES};


  /**
   * Constructor.
   */
  public CardDeck(){
    this.cardDeck = new HashMap<>();
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

    String key =  String.valueOf(card.getSuit()) + card.getFace();
    cardDeck.put(key, card);

    return true;

  }
  public PlayingCard getCardByValue(String key){
    if (key == null){
      throw new IllegalArgumentException("key is null");
    }
   return cardDeck.get(key);
  }
  public void printAllCards(){

    for (PlayingCard playingCard : cardDeck.values()) {
      System.out.println(playingCard.getAsString());

    }
  }
  public void shuffle(){

  }
    public List<PlayingCard> dealHand(int n){
    if (n > 52 || n < 1){
      throw  new IllegalArgumentException("not a valid number of cards to draw from the deck.");
    }
    Object[] cards = this.cardDeck.values().toArray();
    List<PlayingCard> hand = new ArrayList<>();
    HashMap<String,PlayingCard> removedHand = new HashMap<>();
    Random rand = new Random();
    for(int i = 1; i <= n; i++){
      PlayingCard nextRandCard = (PlayingCard)cards[rand.nextInt(52-i)];
      hand.add(nextRandCard);
      removedHand.put(nextRandCard.getAsString(), nextRandCard);
      this.cardDeck.remove(nextRandCard.getAsString());

    }
    this.cardDeck.putAll(removedHand);
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
        this.cardDeck.put(card.getAsString(), card);
      }
    }
  }
}

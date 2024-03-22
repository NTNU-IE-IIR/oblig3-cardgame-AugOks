package no.ntnu.idatx2003.oblig3.cardgame;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CardHand {
  private HashMap<String, PlayingCard> hand;

  /**
   * Constructor for the CardHand class.
   */
  public CardHand(){
    this.hand = new HashMap<>();
  }

  /**
   * Constructor for testing methods.
   * @param otherHand a hand of cards.
   */
  public CardHand(HashMap<String, PlayingCard> otherHand){
    this();
    this.hand = otherHand;
  }

  /**
   * Creates a new hand of cards.
   * @param n
   * @param deck
   */
  public void createHand(int n, CardDeck deck){
    for(PlayingCard card : deck.dealHand(n)){
      this.hand.put(card.getAsString(), card);
    }
  }

  /**
   * Removes the hand of cards.
   */
  public void removeHand(){
    hand.clear();
  }

  /**
   * Returns the hand of cards.
   * @return a list of cards.
   */
  public List<PlayingCard> returnHand(){

    return this.hand.values().stream().toList();
  }

  /**
   * Checks the sum of the cards in the hand.
   * @return the sum of the cards.
   */
  public int checkSum(){
    int sum = 0;
    for (PlayingCard card : hand.values()){
      sum += card.getFace();
    }
    return sum;
  }

  /**
   * Checks if the hand contains hearts.
   * @return
   */
  public List<String> checkHearts(){
    List<String> suits = new ArrayList<>();
    for(PlayingCard card : hand.values()){
      if (card.getSuit() == PlayingCard.HEARTS){
        suits.add(card.getAsString());
      }
    }
    return suits;
  }

  /**
   * Checks if the hand contains a queen of spades.
   * @return
   */
  public boolean checkQueenSpades(){
    boolean success = false;
    if(this.hand.containsKey("S12")){
      success = true;
    }
    return  success;
  }

  /**
   *
   * @return true if flush was found.
   */
  public boolean checkFlush(){
    boolean flush = false;
    int n = (int) this.hand.values().stream().map(PlayingCard::getSuit).distinct().count();
    if (n == this.hand.size() - 4){ //If there are more than 5 cards on the hand it allows one more
      flush = true;                 // suit per card over 5 in the hand.
    }
    return flush;
  }
}

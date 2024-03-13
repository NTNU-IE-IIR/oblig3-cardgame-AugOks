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

  public CardHand(){
    this.hand = new HashMap<>();
  }
  public void createHand(int n, CardDeck deck){
    for(PlayingCard card : deck.dealHand(n)){
      this.hand.put(card.getAsString(), card);
    }
  }
  public void removeHand(){
    hand.clear();
  }
  public List<PlayingCard> returnHand(){

    return this.hand.values().stream().toList();
  }

  public int checkSum(){
    int sum = 0;
    for (PlayingCard card : hand.values()){
      sum += card.getFace();
    }
    return sum;
  }
  public List<String> checkHearts(){
    List<String> suits = new ArrayList<>();
    for(PlayingCard card : hand.values()){
      if (card.getSuit() == PlayingCard.HEARTS){
        suits.add(card.getAsString());
      }
    }
    return suits;
  }
  public boolean checkQueenSpades(){
    boolean success = false;
    if(this.hand.containsKey("S12")){
      success = true;
    }
    return  success;
  }

  /**
   * Streams would be better here, but I don't understand streams and hate it.
   * @return true if flush was found.
   */
  public boolean checkFlush(){
    boolean flush = false;
    int n = (int) this.hand.values().stream().map(PlayingCard::getSuit).distinct().count();
    if (n == 1){
      flush = true;
    }
    return flush;
  }
}

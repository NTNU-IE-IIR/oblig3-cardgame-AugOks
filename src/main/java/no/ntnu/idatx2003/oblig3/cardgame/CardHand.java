package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.List;


public class CardHand {
  ArrayList<PlayingCard> hand;

  public CardHand(){
    this.hand = new ArrayList<>();
  }
  public void createHand(int n, CardDeck deck){

    this.hand.addAll(deck.dealHand(n));
  }
  public void removeHand(){
    ArrayList<PlayingCard> remove;
    remove = this.hand;
    hand.removeAll(remove);
  }
  public List<PlayingCard> returnHand(){

    List<PlayingCard> hand = this.hand;
    return hand;
  }
}

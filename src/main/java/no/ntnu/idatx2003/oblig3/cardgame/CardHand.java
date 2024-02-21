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
    for(PlayingCard card : this.hand){
      this.hand.remove(card);
    }
  }
  public List<PlayingCard> returnHand(){

    List<PlayingCard> hand = this.hand;
    return hand;
  }
}

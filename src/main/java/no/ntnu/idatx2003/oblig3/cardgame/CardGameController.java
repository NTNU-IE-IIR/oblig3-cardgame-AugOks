package no.ntnu.idatx2003.oblig3.cardgame;


import java.util.List;

public class CardGameController {
  private CardDeck deckOfCards;
  private CardHand hand;

  private Ui cardGame;

  public CardGameController(Ui game){
    this.deckOfCards = new CardDeck();
    this.hand = new CardHand();
    this.cardGame = game;
  }

  public void DealNewHand(){
    this.hand.createHand(5, deckOfCards);
    this.cardGame.showHand(hand);
    this.hand.removeHand();
  }
}

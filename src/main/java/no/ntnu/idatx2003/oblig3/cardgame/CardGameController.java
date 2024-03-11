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
    this.hand.removeHand();
    this.hand.createHand(5, deckOfCards);
    this.cardGame.showHand(hand);

  }

  public void checkHand(){
    this.cardGame.displaySum(this.hand.checkSum());
    this.cardGame.displayFlush(checkFlush());
    this.cardGame.displayHearts(checkHearts());
    this.cardGame.displayQSpade(checkQOfSpades());
  }
  private String checkFlush(){
    String flush = "no";
    if (this.hand.checkFlush()){
      flush = "yes";
    }
    return  flush;
  }
  private String checkHearts(){
    StringBuilder string = new StringBuilder();
    List<String> hearts;
    hearts = this.hand.checkHearts();
    if(!hearts.isEmpty()){
      for (String cards : hearts){
        string.append(cards);
        string.append(" ");
      }
    }
    return String.valueOf(string);
  }
  private String checkQOfSpades(){
    String spades = "no";
    if(this.hand.checkQueenSpades()){
      spades = "yes";
    }
    return spades;
  }

}

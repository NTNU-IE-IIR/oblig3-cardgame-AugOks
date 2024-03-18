package no.ntnu.idatx2003.oblig3.cardgame;


import java.util.List;
/**
 * The CardGameController class is the controller for the card game.
 */

public class CardGameController {
  private CardDeck deckOfCards;
  private CardHand hand;

  private Ui cardGame;

  /**
   * Constructor for the CardGameController class.
   * @param game the game to play.
   */

  public CardGameController(Ui game){
    this.deckOfCards = new CardDeck();
    this.hand = new CardHand();
    this.cardGame = game;
  }

  /**
   * Deals a new hand of cards and removes the old hand.
   */
  public void DealNewHand(){
    this.hand.removeHand();
    this.hand.createHand(5, deckOfCards);
    this.cardGame.showHand(hand);

  }

  /**
   * Checks the hand of cards for sum, flush, hearts and queen of spade.
   */
  public void checkHand(){
    this.cardGame.displaySum(this.hand.checkSum());
    this.cardGame.displayFlush(checkFlush());
    this.cardGame.displayHearts(checkHearts());
    this.cardGame.displayQSpade(checkQOfSpades());
  }

  /**
   * Checks if the hand of cards is a flush.
   * @return
   */
  private String checkFlush(){
    String flush = "no";
    if (this.hand.checkFlush()){
      flush = "yes";
    }
    return  flush;
  }

  /**
   * Checks if the hand of cards contains hearts.
   * @return
   */
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
  /**
   * Checks if the hand of cards contains the queen of spades.
   * @return
   */
  private String checkQOfSpades(){
    String spades = "no";
    if(this.hand.checkQueenSpades()){
      spades = "yes";
    }
    return spades;
  }

}

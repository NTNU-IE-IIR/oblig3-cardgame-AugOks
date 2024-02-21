package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Represents a deck of card.
 *
 */
public class CardDeck {

  HashMap<String, PlayingCard> cardDeck;


  /**
   * Constructor.
   */
  public CardDeck(){
    this.cardDeck = new HashMap<>();
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
    Iterator<PlayingCard> it = cardDeck.values().iterator();

    while (it.hasNext()){
      System.out.println(it.next().getAsString());

    }
    System.out.println(cardDeck.size());
  }

  /**
   * Creates a 52 card deck of cards.
   */
  public void initCardDeck(){
    char[] suits = {PlayingCard.CLUBS, PlayingCard.HEARTS, PlayingCard.DIAMONDS, PlayingCard.SPADES}
        ;
    for(int i = 0; i < suits.length; i++){
      for (int j = 1; j <= 13; j++){
        PlayingCard card = new PlayingCard(suits[i], j);
        this.cardDeck.put(card.getAsString(), card);
      }
    }
  }
}

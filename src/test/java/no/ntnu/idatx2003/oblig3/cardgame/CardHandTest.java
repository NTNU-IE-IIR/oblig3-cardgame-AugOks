package no.ntnu.idatx2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardHandTest {

  private CardDeck deck;
  private CardHand hand;
  @Test
  public void testCardhand(){
    deck = new CardDeck();
    hand = new CardHand();
    hand.createHand(5, deck);
    hand.checkFlush();

  }

}
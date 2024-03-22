package no.ntnu.idatx2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CardHandTest {

  private CardDeck deck;
  private CardHand hand;
  @Test
  public void testCardhand(){
    deck = new CardDeck();
    HashMap<String, PlayingCard> otherHand = new HashMap<>();
    PlayingCard card1 = new PlayingCard(PlayingCard.HEARTS, 10);
    PlayingCard card2 = new PlayingCard(PlayingCard.HEARTS, 9);
    PlayingCard card3 = new PlayingCard(PlayingCard.HEARTS, 8);
    PlayingCard card4 = new PlayingCard(PlayingCard.HEARTS, 7);
    PlayingCard card5 = new PlayingCard(PlayingCard.HEARTS, 6);
    PlayingCard card6 = new PlayingCard(PlayingCard.SPADES, 6);
    PlayingCard card7 = new PlayingCard(PlayingCard.SPADES, 4);
    otherHand.put(card1.getAsString(), card1);
    otherHand.put(card2.getAsString(), card2);
    otherHand.put(card3.getAsString(), card3);
    otherHand.put(card4.getAsString(), card4);
    otherHand.put(card5.getAsString(), card5);
    otherHand.put(card6.getAsString(), card6);
    otherHand.put(card7.getAsString(), card7);

    hand = new CardHand(otherHand);
    assertTrue(hand.checkFlush());

  }

}
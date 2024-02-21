package no.ntnu.idatx2003.oblig3.cardgame;

import java.nio.file.Path;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Ui extends Application {
  /**
   * Construct the main window.
   *
   * @param stage
   * @throws Exception
   */
  @Override
  public void start(Stage stage) throws Exception {
    CardDeck deckOfCards = new CardDeck();
    CardHand hand = new CardHand();
    hand.createHand(5, deckOfCards);
    List<PlayingCard> cardsInHand =  hand.returnHand();
    Button card1 = new Button(cardsInHand.get(0).getAsString());
    Button card2 = new Button(cardsInHand.get(1).getAsString());
    Button card3 = new Button(cardsInHand.get(2).getAsString());
    Button card4 = new Button(cardsInHand.get(3).getAsString());
    Button card5 = new Button(cardsInHand.get(4).getAsString());
    FlowPane cardNode = new FlowPane();
    cardNode.getChildren().add(card1);
    cardNode.getChildren().add(card2);
    cardNode.getChildren().add(card3);
    cardNode.getChildren().add(card4);
    cardNode.getChildren().add(card5);
    cardNode.setPadding(new Insets(5));

    try {

      Image image = new Image("C1.PNG");
      ImageView cardImage = new ImageView();
      cardImage.setImage(image);
      cardNode.getChildren().add(cardImage);
      cardNode.setHgap(5);
      cardNode.setVgap(5);
      Scene cardScene = new Scene(cardNode, 200, 300);

      stage.setScene(cardScene);
      stage.setTitle("Card game");
      stage.show();
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public static void appMain(String[] args){
    launch();
  }
}

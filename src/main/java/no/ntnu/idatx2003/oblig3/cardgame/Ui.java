package no.ntnu.idatx2003.oblig3.cardgame;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Ui extends Application {

  private CardGameController controller;

  private FlowPane cardsNode;
  private BorderPane rootNode;
  private Label sumLabel;
  private Label hearts;
  private Label spade;
  private Label flush;

  /**
   * Construct the main window.
   *
   * @param stage
   * @throws Exception
   */
  @Override
  public void start(Stage stage) throws Exception {
    controller = new CardGameController(this);
    cardsNode = new FlowPane();

    rootNode = new BorderPane();

    VBox rightPane = new VBox();


    Button DealHand = new Button("Deal hand");
    Button checkHand = new Button("Check hand");

    DealHand.setOnAction(actionEvent -> {
      controller.DealNewHand();
    });
    checkHand.setOnAction(actionEvent -> {
      controller.checkHand();

    });
    VBox fields = new VBox();
    HBox topBox = new HBox();
    HBox botBox = new HBox();

    HBox sumBox = new HBox();
    HBox heartBox = new HBox();
    HBox flushBox = new HBox();
    HBox spadeBox = new HBox();

    Text sumCards = new Text("sum of all cards: ");
    sumLabel = new Label("-");
    sumBox.getChildren().addAll(sumCards,sumLabel);


    Text cardsHearts = new Text( " cards of hearts: ");
    hearts = new Label("-");
    heartBox.getChildren().addAll(cardsHearts, hearts);


    Text flushCards = new Text("Flush: ");
    flush = new Label("-");
    flushBox.getChildren().addAll(flushCards, flush);

    Text qSpade = new Text("queen of spades: ");
    spade = new Label("-");
    spadeBox.getChildren().addAll(qSpade, spade);

    topBox.setSpacing(50);
    topBox.getChildren().addAll(sumBox, heartBox);
    fields.getChildren().add(topBox);

    botBox.setSpacing(50);
    botBox.getChildren().addAll(flushBox, spadeBox);
    fields.getChildren().add(botBox);
    botBox.setPadding(new Insets(50));
    topBox.setPadding(new Insets(50));
    rootNode.setBottom(fields);
    rightPane.getChildren().add(DealHand);
    rightPane.getChildren().add(checkHand);
    rootNode.setRight(rightPane);
    rootNode.setCenter(cardsNode);


    try {
      Scene scene = new Scene(rootNode,500, 500);
      stage.setScene(scene);
      stage.setTitle("Card game");
      stage.show();
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public static void appMain(String[] args){
    launch();
  }

  /**
   * Shows the hand of cards. Not made to be run as a package.
   * @param hand The hand to show.
   */
  public void showHand(CardHand hand){
    List<PlayingCard> cards = hand.returnHand();
    try{
      String path;
      this.cardsNode.getChildren().clear();

      for (PlayingCard card : cards){
        path = "file:src/resources/";
        path = path + card.getAsString() + ".png";
        Image image = new Image(path);
        ImageView cardImage = new ImageView();

        cardImage.setImage(image);
        cardImage.setFitHeight(200);
        cardImage.setPreserveRatio(true);

        cardsNode.getChildren().add(cardImage);
      }
      System.out.println("dealing new Hand");
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  /**
   * Displays the sum of the cards in the hand.
   * @param n the sum of the cards.
   */
  public void displaySum(int n){
    this.sumLabel.setText(String.valueOf(n));
  }
  /**
   * Displays the number of hearts in the hand.
   * @param s all the cards of hearts.
   */
  public void displayHearts(String s){
    this.hearts.setText(s);
  }
  /**
   * Displays if the hand is a flush or not.
   * @param s yes or no
   */
  public void displayFlush(String s){
    this.flush.setText(s);
  }
    /**
     * Displays if the hand contains the queen of spades.
     * @param s yes or no
     */
  public void displayQSpade(String s){
   this.spade.setText(s);
  }
}

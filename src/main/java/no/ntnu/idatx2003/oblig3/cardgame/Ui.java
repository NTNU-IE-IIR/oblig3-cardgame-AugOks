package no.ntnu.idatx2003.oblig3.cardgame;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ui extends Application {

  private CardGameController controller;

  private FlowPane cardsNode;
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

    BorderPane rootNode = new BorderPane();

    VBox rightPane = new VBox();
    HBox bottomPane = new HBox();

    Button DealHand = new Button("Deal hand");
    Button checkHand = new Button("Check hand");

    DealHand.setOnAction(actionEvent -> {
      controller.DealNewHand();
    });
    checkHand.setOnAction(actionEvent -> {

    });

    rightPane.getChildren().add(DealHand);
    rightPane.getChildren().add(checkHand);
    rootNode.setRight(rightPane);
    rootNode.setCenter(cardsNode);


    try {
      /*

      Image image = new Image("file:src/resources/C1.png");
      ImageView cardImage = new ImageView();
      cardImage.setImage(image);
      cardNode.getChildren().add(cardImage);
      cardNode.setHgap(5);
      cardNode.setVgap(5);
      Scene cardScene = new Scene(cardNode, 200, 300);

       */
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

  public void showHand(CardHand hand){
    List<PlayingCard> cards = hand.returnHand();
    try{
      String path;
      this.cardsNode.getChildren().clear();

      for (PlayingCard card : cards){
        path = "file:src/resources/";
        path = path + card.getAsString() + ".png";
        System.out.println(path);
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
}

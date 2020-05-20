package view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DOT;
//import model.DotAttribute;

import model.Vector;


import java.util.ArrayList;

public class GameViewController {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage primaryStage;
    private ImageView dot;
    ArrayList<Vector> dotList = new ArrayList<Vector>();
    Vector position = new Vector();
//    ArrayList<Integer> position = new ArrayList<Integer>();
    ArrayList<Integer> status = new ArrayList<Integer>(4);
//    Vector dotVector;
    private static final int GAME_WIDTH = 1200;
    private static final int GAME_HEIGHT = 800;
    private final static int DASHBOARD_START_X = 400;
    private final static int DASHBOARD_START_Y = 50;

    public GameViewController(){
        initializeStage();
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
    }


    public void createNewGame(Stage primaryStage, DOT choosenDot){
        this.primaryStage = primaryStage;
        this.primaryStage.hide();
        gameStage.show();
        createDot(choosenDot);
    }

//    private void dotPosition(int positionX,int positionY){
//        position.add(positionX, positionY);
//    }


    private void createDot(DOT choosenDot){
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 8; j++) {
                dot = new ImageView(choosenDot.getUrl());
                position.set(i,j);
                dotList.add(position);
//                System.out.println("DotList " +dotList);
                System.out.println("dot = " + dot);
                System.out.println("choosenDot = " + choosenDot);
                dot.setLayoutX(DASHBOARD_START_X + 100 * i);
                dot.setLayoutY(DASHBOARD_START_Y + 100* j);
                gamePane.getChildren().add(dot);
                dot.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        dot.setEffect(new DropShadow());
                    }
                });
                dot.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        dot.setEffect(null);
                    }
                });
            }
        }

    }

}

package view;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;
import javafx.application.Application;
import org.w3c.dom.ls.LSOutput;
import view.GameViewController;

import java.util.ArrayList;
import java.util.List;

public class ViewController {

    private static final int HEIGHT = 800;
    private static final int WIDTH = 1200;
    private final static int MENU_BUTTON_START_X = 150;
    private final static int MENU_BUTTON_START_Y = 600;
    List<DotsButton> menuButtons;
    List<DotPicker> dotsList;
    private DOT choosenDot;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private DotsSubScene optionsSubScene;


    public ViewController() {
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
        createBackground();
        createLogo();
        createSubScenes();

    }

    private void createSubScenes(){

        createDotChooserSubScene();
    }

    private void createDotChooserSubScene() {
        optionsSubScene = new DotsSubScene();
        mainPane.getChildren().add(optionsSubScene);

        InfoLabel chooseDotLabel = new InfoLabel("CHOOSE COLOR!!!");
        chooseDotLabel.setLayoutX(110);
        chooseDotLabel.setLayoutY(25);
        optionsSubScene.getPane().getChildren().add(chooseDotLabel);
        optionsSubScene.getPane().getChildren().add(createDotsToChoose());
    }

    private HBox createDotsToChoose(){
        HBox box = new HBox();
        box.setSpacing(120);
        dotsList = new ArrayList<>();
        for(DOT dot : DOT.values()){
            DotPicker dotToPick = new DotPicker(dot);
            dotsList.add(dotToPick);
            box.getChildren().add(dotToPick);
            dotToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (DotPicker dot : dotsList){
                        dot.setIsCheckMarkChoosen(false);
                    }
                    dotToPick.setIsCheckMarkChoosen(true);
                    choosenDot = dotToPick.getDot();
                }
            });
        }
        box.setLayoutX(300 - (118*2));
        box.setLayoutY(100);
        return box;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createButtons() {
        createExitButton();
        createStartButton();
        createGuideButton();
        createOptionButton();
    }

    private void createBackground() {
        Image backgroundImage = new Image("view/resources/grey_panel2.png", 256, 256, false, true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));
    }

    private void addMenuButton(DotsButton button) {
        button.setLayoutX(MENU_BUTTON_START_X + menuButtons.size() * 250);
        button.setLayoutY(MENU_BUTTON_START_Y);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createStartButton() {
        DotsButton startButton = new DotsButton("Play");
        addMenuButton(startButton);
        startButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                startButton.setEffect(new DropShadow());
            }
        });
        startButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                startButton.setEffect(null);
            }
        });
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if( choosenDot != null) {
                    GameViewController gameController = new GameViewController();
                    gameController.createNewGame(mainStage, choosenDot);
                }
            }
        });
    }

    private void createExitButton() {
        DotsButton exitButton = new DotsButton("Quit");
        addMenuButton(exitButton);
        exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                exitButton.setEffect(new DropShadow());
            }
        });
        exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                exitButton.setEffect(null);
            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createGuideButton() {
        DotsButton guideButton = new DotsButton("Guide");
        addMenuButton(guideButton);
        guideButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                guideButton.setEffect(new DropShadow());
            }
        });
        guideButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                guideButton.setEffect(null);
            }
        });
    }

    private void createOptionButton() {
        DotsButton optionButton = new DotsButton("Option");
        addMenuButton(optionButton);
        optionButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                optionButton.setEffect(new DropShadow());
            }
        });
        optionButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                optionButton.setEffect(null);
            }
        });

        optionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                optionsSubScene.moveSubScene();
            }
        });
    }

    private void createLogo() {
        ImageView logo = new ImageView("view/resources/dots_big_logo.png");
        logo.setLayoutX(100);
        logo.setLayoutY(50);
        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow());
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });
        mainPane.getChildren().add(logo);
    }




}

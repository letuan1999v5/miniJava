package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import view.ViewController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            ViewController controller = new ViewController();
            primaryStage = controller.getMainStage();
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

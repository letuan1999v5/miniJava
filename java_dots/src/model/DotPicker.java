package model;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DotPicker extends VBox {

    private ImageView checkMarkImage;
    private ImageView dotImage;

    private String checkMarkNotChoosen = "view/resources/dotchooser/white_checkmark1.png";
    private String checkMarkIsChoosen = "view/resources/dotchooser/grey_checkmark1.png";

    private DOT dot;

    private boolean isCheckMarkChoosen;

    public DotPicker(DOT dot){
        checkMarkImage = new ImageView(checkMarkNotChoosen);
        dotImage = new ImageView(dot.getUrl());
        this.dot = dot;
        isCheckMarkChoosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(100);
        this.getChildren().add(checkMarkImage);
        this.getChildren().add(dotImage);

    }

    public DOT getDot(){
        return dot;
    }

//    public boolean getIsCheckMarkChoosen(){
//        return isCheckMarkChoosen;
//    }

    public void setIsCheckMarkChoosen(boolean isCheckMarkChoosen){
        this.isCheckMarkChoosen = isCheckMarkChoosen;
        String imageToSet = this.isCheckMarkChoosen ? checkMarkIsChoosen : checkMarkNotChoosen;
        checkMarkImage.setImage(new Image(imageToSet));
    }
}

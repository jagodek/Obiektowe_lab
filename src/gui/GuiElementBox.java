package agh.ics.oop.gui;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Object;

import agh.ics.oop.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class GuiElementBox{

    private VBox box = new VBox();

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        String url = "src/main/resources/";

        url = url + element.looks() +".png";
        Image image = new Image(new FileInputStream(url));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        box.getChildren().addAll(imageView, new Label(((IMapElement) element).getPosition().toString()));
        box.setAlignment(Pos.BASELINE_CENTER);
    }

    public VBox getBox() {
        return box;
    }
}

package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lefreks extends Application {
    @Override
    public void start(Stage stage) {
        // setting resolution
        int RESX = 1024,
            RESY = 768;
        stage.setResizable(false);

        //game setting variables
        int targetSize = 40; //TODO -- DEBUG VALUE

        Rectangle guiBar = new Rectangle(RESX, 90, Color.rgb(71,59,59)); //ingame menu background
        Circle target = new Circle(RESX/2, RESY/2, targetSize, Color.INDIANRED); //target

        // mouse click event handler
        target.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                target.setCenterX((int)(Math.random() * (RESX - 2*targetSize) + targetSize)); //Math so target wouldn't go outside playing area
                target.setCenterY((int)(Math.random() * (RESY - 2*targetSize - 90) + targetSize + 90));
            }
        });

        //add shapes to a group
        Group pane = new Group(target,guiBar);

        // game window styling
        Scene gameScene = new Scene(pane, 1024, 768);
        gameScene.setFill(Color.rgb(255,251,235));
        stage.setTitle("Lefreks");
        stage.setScene(gameScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
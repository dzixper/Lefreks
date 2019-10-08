package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Lefreks extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        int difficulty = 40;

        Circle target = new Circle(250, 250, difficulty, Color.INDIANRED);
        target.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                target.setCenterX((int)(Math.random() * (1024 - 2*difficulty) + difficulty));
                target.setCenterY((int)(Math.random() * (768 - 2*difficulty) + difficulty));
                System.out.println(target.getCenterY());
            }
        });

        pane.getChildren().addAll(target);


        Scene gameScene = new Scene(pane, 1024, 768);
        gameScene.setFill(Color.rgb(255,255,248));
        stage.setTitle("Lefreks");
        stage.setScene(gameScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
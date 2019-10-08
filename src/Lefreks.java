import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Lefreks extends Application {
    @Override
    public void start(Stage stage) {
        // Resolution variables
        int RESX = 1024,
            RESY = 768,
            INGAME_MENU_SIZE = 90;
        stage.setResizable(false);

        // Playing area
        Pane playingArea = new Pane();


        // Game setting variables
        int targetSize = 40; //TODO -- DEBUG VALUE
        NumberHandler numberHandler = new NumberHandler();

        // Ingame menu background
        Rectangle guiBar = new Rectangle(RESX, INGAME_MENU_SIZE, Color.rgb(71,59,59));

        // TODO -- menu button
        Button menuButton = new Button("Menu");
        menuButton.setLayoutX(RESX - 70);
        menuButton.setLayoutY(10);

        // Points text
        Text textPoints = new Text(10, 20, "Points: " + numberHandler.getPoints());
        // Timer text
        // TODO
        Text textTimer = new Text(10, 60, "Timer: " + numberHandler.getTimer());

        // Target
        Circle target = new Circle(RESX/2, RESY/2, targetSize, Color.INDIANRED);
        // Mouse click event handler
        target.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                target.setCenterX((int)(Math.random() * (RESX - 2*targetSize) + targetSize)); //Math so target wouldn't go outside playing area
                target.setCenterY((int)(Math.random() * (RESY - 2*targetSize - INGAME_MENU_SIZE) + targetSize + INGAME_MENU_SIZE));
                numberHandler.setPoints(numberHandler.getPoints()+1);
                textPoints.setText("Points: " + numberHandler.getPoints());
            }
        });

        // Add shapes to a group
        playingArea.getChildren().addAll(guiBar, menuButton, target, textPoints, textTimer);

        // Game window styling
        Scene gameScene = new Scene(playingArea, 1024, 768);
        gameScene.setFill(Color.rgb(255,251,235));
        stage.setTitle("Lefreks");
        stage.setScene(gameScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
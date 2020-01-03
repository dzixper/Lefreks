import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.util.Duration;

public class GameSection {
    static int INGAME_MENU_SIZE = 90;
    public static Circle target;

    public static Scene gameScene(Stage stage) {
        NumberHandler numberHandler = new NumberHandler();
        numberHandler.reset();
        numberHandler.reset();

        // Playing area init
        Pane playingArea = new Pane();

        // Ingame menu background
        Rectangle guiBar = new Rectangle(Lefreks.RESX, INGAME_MENU_SIZE, Color.rgb(71, 59, 59));

        // Menu button
        Button menuButton = new Button("Menu");
        menuButton.setLayoutX(Lefreks.RESX - 100);
        menuButton.setLayoutY(25);
        menuButton.setOnAction(e -> {stage.setScene(MenuSection.menuScene(stage)); numberHandler.reset();});

        // Points text
        Text textPoints = new Text(10, 35, "");
        textPoints.setFont(Font.font("Verdana", FontWeight.BLACK, 20));
        textPoints.setFill(Color.INDIANRED);
        textPoints.textProperty().bind(numberHandler.getPointsText());

        // Timer text
        Text textTimer = new Text(10, 65, "");
        textTimer.setFont(Font.font("Verdana", FontWeight.BLACK, 20));
        textTimer.setFill(Color.INDIANRED);
        textTimer.textProperty().bind(numberHandler.getTimerText());

        playingArea.setOnMouseMoved(e -> {
            if (numberHandler.getTimePassed() >= 5) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game Over");
                alert.setHeaderText(null);
                alert.setContentText("Your score: " + numberHandler.getPoints());
                numberHandler.reset();
                alert.showAndWait();
                stage.setScene(LeaderboardsSection.leaderboardsScene(stage));
            }
        });


        // Target placed at the centre of the screen
        target = new Circle(Lefreks.RESX / 2, Lefreks.RESY / 2, 10, Color.INDIANRED);
        // Mouse click event handler
        target.setOnMouseClicked(e -> {

            numberHandler.setStartTimer(true);

            // Difficulty variable
            target.setRadius(numberHandler.getTargetSize());

            // Changing target image after starting the game
            Image im = new Image("goal-2.png",false);
            target.setFill(new ImagePattern(im));
            int randX = (int) (Math.random() * (Lefreks.RESX - 2 * numberHandler.getTargetSize()) + numberHandler.getTargetSize());
            int randY = (int) (Math.random() * (Lefreks.RESY - 2 * numberHandler.getTargetSize() - INGAME_MENU_SIZE) + numberHandler.getTargetSize() + INGAME_MENU_SIZE); //Math so target wouldn't go outside playing area

            // Target animation
            Line path = new Line(target.getCenterX(),target.getCenterY(),randX,randY);
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.millis(3*(target.getCenterX()+randX)));
            pathTransition.setPath(path);
            pathTransition.setNode(target);
            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
            pathTransition.setAutoReverse(true);
            pathTransition.play();


            // Set physical position of the target
            target.setCenterX(randX);
            target.setCenterY(randY);



            numberHandler.setPoints(numberHandler.getPoints() + 1);

            if (numberHandler.isStartTimer() && !numberHandler.isStartedTimer()) {
                numberHandler.timer.scheduleAtFixedRate(numberHandler.startCounting, 0, 1);
                numberHandler.setStartedTimer(true);
            }
        });

        // Add shapes to a group
        playingArea.getChildren().addAll(guiBar, menuButton, target, textPoints, textTimer);

        // Area styling
        playingArea.getStylesheets().add("menuSection.css");
        return new Scene(playingArea, Lefreks.RESX, Lefreks.RESY);
    }
}

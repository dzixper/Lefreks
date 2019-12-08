import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameSection {

    /*public void writeScore() {
        int score = NumberHandler.getPoints();
        PrintWriter out = new PrintWriter("filename.txt");
        out.println(score);
    }*/ // TODO

    static int INGAME_MENU_SIZE = 90;
    public static Circle target; // TODO -- make it private

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


        // Target placed at the centre of the screen
        target = new Circle(Lefreks.RESX / 2, Lefreks.RESY / 2, 10, Color.INDIANRED);
        // Mouse click event handler
        target.setOnMouseClicked(e -> {

            numberHandler.setStartTimer(true);

            // Difficulty variable
            target.setRadius(numberHandler.getTargetSize());

            // Changing target color after starting the game
            target.setFill(Color.INDIANRED);

            target.setCenterX((int) (Math.random() * (Lefreks.RESX - 2 * numberHandler.getTargetSize()) + numberHandler.getTargetSize())); //Math so target wouldn't go outside playing area
            target.setCenterY((int) (Math.random() * (Lefreks.RESY - 2 * numberHandler.getTargetSize() - INGAME_MENU_SIZE) + numberHandler.getTargetSize() + INGAME_MENU_SIZE));

            numberHandler.setPoints(numberHandler.getPoints() + 1);

            if (numberHandler.isStartTimer() && !numberHandler.isStartedTimer()) {
                numberHandler.timer.scheduleAtFixedRate(numberHandler.startCounting, 0, 1);
                numberHandler.setStartedTimer(true);
            }
            /*if (numberHandler.getTimePassed() >= 3) {
                int score = NumberHandler.getPoints();
                PrintWriter out = new PrintWriter("filename.txt");
                out.println(score);
                stage.setScene(MenuSection.menuScene(stage));
            }*/ // TODO
        });

        // Add shapes to a group
        playingArea.getChildren().addAll(guiBar, menuButton, target, textPoints, textTimer);

        // Area styling
        playingArea.getStylesheets().add("menuSection.css");
        return new Scene(playingArea, Lefreks.RESX, Lefreks.RESY);
    }
}
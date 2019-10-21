import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lefreks extends Application {
    NumberHandler numberHandler = new NumberHandler();

    Scene menuScene, gameScene, scoreboardScene;

    @Override
    public void start(Stage stage) {
        // Resolution variables
        int RESX = 1024,
            RESY = 768,
            INGAME_MENU_SIZE = 90;
        stage.setResizable(false);


        //
        // MENU SECTION
        //

        BorderPane menuArea = new BorderPane();

        Button playButton = new Button("Play");
        Button leaderboardButton = new Button("Leaderboard");
        Button exitButton = new Button("Exit");

        VBox vbox = new VBox();
        vbox.setSpacing(15);

        vbox.getChildren().addAll(playButton, leaderboardButton, exitButton);
        vbox.setAlignment(Pos.CENTER);
        menuArea.setCenter(vbox);

        // Area styling
        menuArea.setBackground(new Background(new BackgroundFill(Color.rgb(255,251,235), CornerRadii.EMPTY, Insets.EMPTY)));
        menuScene = new Scene (menuArea, RESX, RESY);




        //
        // PLAYING AREA SECTION
        //

        // Playing area init
        Pane playingArea = new Pane();


        // Game setting variables
        int targetSize = 100;

        // Ingame menu background
        Rectangle guiBar = new Rectangle(RESX, INGAME_MENU_SIZE, Color.rgb(71, 59, 59));

        // TODO -- menu button
        Button menuButton = new Button("Menu");
        menuButton.setLayoutX(RESX - 70);
        menuButton.setLayoutY(10);

        // Points text
        Text textPoints = new Text(10, 35, "POINTS: " + numberHandler.getPoints());
        textPoints.setFont(Font.font("Verdana", FontWeight.BLACK, 20));
        textPoints.setFill(Color.INDIANRED);

        // Timer text
        Text textTimer = new Text(10, 65, "");
        textTimer.setFont(Font.font("Verdana", FontWeight.BLACK, 20));
        textTimer.setFill(Color.INDIANRED);
        textTimer.textProperty().bind(numberHandler.getText());

        // Target placed at the centre of the screen
        Circle target = new Circle(RESX / 2, RESY / 2, targetSize, Color.INDIANRED);

        // Mouse click event handler
        target.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {

                numberHandler.setStartTimer(true);

                target.setCenterX((int) (Math.random() * (RESX - 2 * targetSize) + targetSize)); //Math so target wouldn't go outside playing area
                target.setCenterY((int) (Math.random() * (RESY - 2 * targetSize - INGAME_MENU_SIZE) + targetSize + INGAME_MENU_SIZE));

                numberHandler.setPoints(numberHandler.getPoints() + 1);
                textPoints.setText("POINTS: " + numberHandler.getPoints());


                if (numberHandler.isStartTimer() && !numberHandler.isStartedTimer()) {
                    numberHandler.timer.scheduleAtFixedRate(numberHandler.startCounting, 0, 1000);
                    numberHandler.setStartedTimer(true);
                }
            }
        });

        // Add shapes to a group
        playingArea.getChildren().addAll(guiBar, menuButton, target, textPoints, textTimer);

        // Area styling
        playingArea.setBackground(new Background(new BackgroundFill(Color.rgb(255,251,235), CornerRadii.EMPTY, Insets.EMPTY)));
        gameScene = new Scene(playingArea, RESX, RESY);

        //
        // STAGE CONFIG
        //

        stage.setTitle("Lefreks");
        stage.setScene(menuScene);
        stage.show();
    }

    @Override
    public void stop() {
        numberHandler.timer.cancel();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
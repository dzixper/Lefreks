import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuSection {
    public static Scene menuScene(Stage stage) {
        BorderPane menuArea = new BorderPane();


        Button playButton = new Button("Play");
        playButton.setOnAction(e -> stage.setScene(DifficultySection.difficultyScene(stage)));

        Button leaderboardButton = new Button("Leaderboard"); // TODO

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> stage.close());

        VBox menuVbox = new VBox();
        menuVbox.setSpacing(20);

        menuVbox.getChildren().addAll(playButton, leaderboardButton, exitButton);
        menuVbox.setAlignment(Pos.CENTER);
        menuArea.setCenter(menuVbox);

        // Area styling
        menuArea.setBackground(new Background(new BackgroundFill(Color.rgb(255, 251, 235), CornerRadii.EMPTY, Insets.EMPTY)));
        return new Scene(menuArea, Lefreks.RESX, Lefreks.RESY);
    }
}

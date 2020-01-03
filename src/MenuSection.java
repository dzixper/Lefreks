import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuSection {
    public static Scene menuScene(Stage stage) {
        BorderPane menuArea = new BorderPane();


        Button playButton = new Button("Play");
        playButton.setOnAction(e -> stage.setScene(DifficultySection.difficultyScene(stage)));

        Button leaderboardButton = new Button("Leaderboard");
        leaderboardButton.setOnAction(e -> stage.setScene(LeaderboardsSection.leaderboardsScene(stage)));

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> stage.close());

        VBox menuVbox = new VBox();
        menuVbox.setSpacing(20);

        menuVbox.getChildren().addAll(playButton, leaderboardButton, exitButton);
        menuVbox.setAlignment(Pos.CENTER);
        menuArea.setCenter(menuVbox);

        menuArea.getStylesheets().add("menuSection.css");
        return new Scene(menuArea, Lefreks.RESX, Lefreks.RESY);
    }
}

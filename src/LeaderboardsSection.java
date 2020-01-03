import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LeaderboardsSection {
    private static int bestScore;

    public static int getBestScore() {
        return bestScore;
    }

    public static void setBestScore(int bestScore) {
        LeaderboardsSection.bestScore = bestScore;
    }

    public static Scene leaderboardsScene(Stage stage) {
        BorderPane leaderboardsArea = new BorderPane();

        Button menuButton = new Button("Menu");
        menuButton.setOnAction(e -> stage.setScene(MenuSection.menuScene(stage)));

        Text bestScor = new Text();
        bestScor.setText("Your best score: " + bestScore);
        bestScor.setFont(Font.font("Verdana", FontWeight.BLACK, 20));
        bestScor.setFill(Color.INDIANRED);

        VBox menuVbox = new VBox();
        menuVbox.setSpacing(20);
        menuVbox.getChildren().addAll(menuButton, bestScor);
        menuVbox.setAlignment(Pos.CENTER);
        leaderboardsArea.setCenter(menuVbox);

        leaderboardsArea.getStylesheets().add("menuSection.css");
        return new Scene(leaderboardsArea, Lefreks.RESX, Lefreks.RESY);

    }
}

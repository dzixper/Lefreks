import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LeaderboardsSection {
    public static Scene leaderboardsScene(Stage stage) {
        BorderPane leaderboardsArea = new BorderPane();
        leaderboardsArea.setBackground(new Background(new BackgroundFill(Color.rgb(255, 251, 235), CornerRadii.EMPTY, Insets.EMPTY)));
        return new Scene(leaderboardsArea, Lefreks.RESX, Lefreks.RESY);
    }
}

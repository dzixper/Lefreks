import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DifficultySection {
    public static Scene difficultyScene(Stage stage) {
        NumberHandler numberHandler = new NumberHandler();

        BorderPane difficultyArea = new BorderPane();


        Button easyButton = new Button("Easy");
        easyButton.setOnAction(e -> {
            numberHandler.setTargetSize(45);
            numberHandler.setTargetDuration(1000); //ms value
            stage.setScene(GameSection.gameScene(stage));
            numberHandler.reset();
        });


        Button normalButton = new Button("Medium");
        normalButton.setOnAction(e -> {
            numberHandler.setTargetSize(30);
            numberHandler.setTargetDuration(825); //ms value
            stage.setScene(GameSection.gameScene(stage));
            numberHandler.reset();
        });

        Button hardButton = new Button("Hard");
        hardButton.setOnAction(e -> {
            numberHandler.setTargetSize(15);
            numberHandler.setTargetDuration(650); //ms value
            stage.setScene(GameSection.gameScene(stage));
            numberHandler.reset();
        });


        VBox difficultyVbox = new VBox();
        difficultyVbox.setSpacing(20);

        difficultyVbox.getChildren().addAll(easyButton, normalButton, hardButton);
        difficultyVbox.setAlignment(Pos.CENTER);
        difficultyArea.setCenter(difficultyVbox);
        difficultyArea.getStylesheets().add("menuSection.css");
        return new Scene(difficultyArea, Lefreks.RESX, Lefreks.RESY);
    }
}

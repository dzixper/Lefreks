import javafx.application.Application;
import javafx.stage.Stage;

public class Lefreks extends Application {

    NumberHandler numberHandler = new NumberHandler();

    static int RESX = 600, RESY = 690;

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle("Lefreks");
        stage.setScene(MenuSection.menuScene(stage));
        stage.show();
    }

    @Override
    public void stop() {
        numberHandler.timer.cancel(); // TODO -- do it without throwing an error
    }

    public static void main(String[] args) {
        launch(args);
    }

}
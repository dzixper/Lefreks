import javafx.application.Application;
import javafx.stage.Stage;

public class Lefreks extends Application {

    static int RESX = 600, RESY = 690;
    NumberHandler numberHandler = new NumberHandler();

    public static void main(String[] args) {
        launch(args);
    }

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

}
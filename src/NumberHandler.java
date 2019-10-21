import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Timer;
import java.util.TimerTask;

public class NumberHandler {
    // Variables
    private int points;
    private int timePassed = 0;
    private int targetSize;
    private StringProperty timerText = new SimpleStringProperty("TIMER: " + getTimePassed());
    private boolean startTimer = false,
            startedTimer = false;

    // Getters and setters
    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    public int getTimePassed() {
        return timePassed;
    }

    public void setStartedTimer(boolean startedTimer) {
        this.startedTimer = startedTimer;
    }

    public boolean isStartedTimer() {
        return startedTimer;
    }

    public void setStartTimer(boolean startTimer) {
        this.startTimer = startTimer;
    }

    public boolean isStartTimer() {
        return startTimer;
    }

    public int getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(int targetSize) {
        this.targetSize = targetSize;
    }

    public StringProperty getText() {
        return timerText;
    }

    // Timer counting method
    Timer timer = new Timer();
    TimerTask startCounting = new TimerTask() {
        @Override
        public void run() {
            setTimePassed(getTimePassed() + 1);
            timerText.set("TIMER: " + getTimePassed());
        }
    };
}

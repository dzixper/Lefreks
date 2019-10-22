import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Timer;
import java.util.TimerTask;

public class NumberHandler {
    // Variables
    Timer timer; // TODO -- make it private
    private int points;
    private int timePassed = 0;
    private static int targetSize;
    private StringProperty timerText = new SimpleStringProperty("TIMER: " + getTimePassed());
    private StringProperty pointsText = new SimpleStringProperty("POINTS: " + getPoints());
    private boolean startTimer = false,
            startedTimer = false;

    // Getters and setters
    public void setPoints(int points) {
        this.points = points;
        pointsText.set("POINTS: " + getPoints());
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

    public StringProperty getTimerText() {
        return timerText;
    }
    public StringProperty getPointsText() {
        return pointsText;
    }

    public void reset() {
        startCounting.cancel();
        setPoints(0);
        setTimePassed(0);
        setStartTimer(false);
        setStartedTimer(false);
        timerText.set("TIMER: " + getTimePassed());
        timer = new Timer();
        startCounting = new TimerTask() {
            @Override
            public void run() {
                setTimePassed(getTimePassed() + 1);
                timerText.set("TIMER: " + getTimePassed());
            }
        };
    }


    // Timer counting method
    TimerTask startCounting = new TimerTask() {
        @Override
        public void run() {
            setTimePassed(getTimePassed() + 1);
            timerText.set("TIMER: " + getTimePassed());
        }
    };
}

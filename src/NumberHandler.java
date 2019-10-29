import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class NumberHandler {
    // Variables
    Timer timer; // TODO -- make it private
    private int points;
    private int timePassed = 0;
    private static int targetSize;
    private static int targetDuration = 4;
    private int targetDurationTempTime;
    private int timePassedTemp;
    private StringProperty timerText = new SimpleStringProperty("TIMER: " + getTimePassed());
    private StringProperty pointsText = new SimpleStringProperty("POINTS: " + getPoints());
    private boolean startTimer = false;
    private boolean startedTimer = false;

    // Getters and setters

    public void setTimePassedTemp(int timePassedTemp) {
        this.timePassedTemp = timePassedTemp;
    }

    public int getTimePassedTemp() {
        return timePassedTemp;
    }

    public void setTargetDuration(int targetDuration) {
        this.targetDuration = targetDuration;
    }

    public int getTargetDuration() {
        return targetDuration;
    }

    public void setPoints(int points) {
        this.points = points;
        pointsText.set("POINTS: " + getPoints());
    }

    public int getTargetDurationTempTime() {
        return targetDurationTempTime;
    }

    public void setTargetDurationTempTime(int targetDurationTempTime) {
        this.targetDurationTempTime = targetDurationTempTime;
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

    // Methods
    public void reset() {
        startCounting.cancel();
        setPoints(0);
        setTimePassed(0);
        setTargetDurationTempTime(0);
        setStartTimer(false);
        setStartedTimer(false);
        timerText.set("TIMER: " + getTimePassed());
        timer = new Timer();
        startCounting = new TimerTask() {
            @Override
            public void run() {
                setTargetDurationTempTime(getTargetDurationTempTime() + 1);
                setTimePassedTemp(getTimePassedTemp() + 1);
                if (getTimePassedTemp() == 1000) {
                    setTimePassed(getTimePassed() + 1);
                    timerText.set("TIMER: " + getTimePassed());
                    setTimePassedTemp(0);
                }
                if (getTargetDurationTempTime() == getTargetDuration()) {
                    GameSection.target.setCenterX((int) (Math.random() * (Lefreks.RESX - 2 * getTargetSize()) + getTargetSize())); //Math so target wouldn't go outside playing area
                    GameSection.target.setCenterY((int) (Math.random() * (Lefreks.RESY - 2 * getTargetSize() - GameSection.INGAME_MENU_SIZE) + getTargetSize() + GameSection.INGAME_MENU_SIZE));
                    setTargetDurationTempTime(0);
                }
            }
        };
    }


    // Timer counting method
    TimerTask startCounting = new TimerTask() {
        @Override
        public void run() {
        }
    };


}

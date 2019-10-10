import java.util.Timer;
import java.util.TimerTask;

public class NumberHandler {
    private int points;
    private int timePassed = 0;
    private boolean startTimer = false,
                    startedTimer = false;

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

    public boolean isStartedTimer() { return startedTimer; }

    public void setStartTimer(boolean startTimer) {
        this.startTimer = startTimer;
    }

    public boolean isStartTimer() { return startTimer; }

    Timer timer = new Timer();
    TimerTask startCounting = new TimerTask() {
        @Override
        public void run() {
            setTimePassed(getTimePassed() + 1);
            System.out.println(getTimePassed());
        }
    };
}

public class NumberHandler {

    private int points;
    private int timer;

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    /*public void runTimer() {
        while (getTimer() < 60) {
            long startTime = System.currentTimeMillis();
            if (System.currentTimeMillis() - startTime == 1000) {
                setTimer(getTimer() + 1);
                startTime = System.currentTimeMillis();
            }
        }
    }*/
}

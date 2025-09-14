package organizer;

public class PomodoroTimer {
    private int completedPomodoros = 0;
    private boolean running = false;

    public void startPomodoro() {
        int minutes = 25;
        running = true;

        System.out.println(" Pomodoro started! Focus for 25 minutes..");

        try {
            for (int i = minutes; i > 0 && running; i--) {
                Thread.sleep(60 * 1000); // 1 minute
                System.out.println(" " + (i - 1) + " minutes left..");
            }
        } catch (InterruptedException e) {
            System.out.println(" Pomodoro stopped early.");
        }

        if (running) {
            completedPomodoros++;
            System.out.println(" Time’s up! Take a short break.");
        }

        running = false;
    }

    public void stopPomodoro() {
        running = false;
    }

    public int getCompletedPomodoros() {
        return completedPomodoros;
    }
}


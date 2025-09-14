package organizer;

public class Dashboard {
    private TaskManager taskManager;
    private PomodoroTimer timer;
    private QuotesManager quotesManager;

    public Dashboard(TaskManager taskManager, PomodoroTimer timer, QuotesManager quotesManager) {
        this.taskManager = taskManager;
        this.timer = timer;
        this.quotesManager = quotesManager;
    }

    public void showDailySummary() {
        System.out.println("\n===== Daily Summary =====");
        
        // Tasks due today (simplified: show all pending tasks)
        System.out.println("\n Tasks Pending:");
        taskManager.listTasks();

        // Completed Pomodoros
        System.out.println("\n Pomodoros completed today: " + timer.getCompletedPomodoros());

        // Motivation
        System.out.println("\n Motivation of the Day: " + quotesManager.getRandomQuote());

        System.out.println("============================\n");
    }
}

package organizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuotesManager quotesManager = new QuotesManager("src/data/quotes.json");
        TaskManager taskManager = new TaskManager();
        PomodoroTimer timer = new PomodoroTimer();  
        Dashboard dashboard = new Dashboard(taskManager, timer, quotesManager);
        Scanner sc = new Scanner(System.in);

        System.out.println("This is Productivity App!!");
        System.out.println("Quote of the day: " + quotesManager.getRandomQuote());
        dashboard.showDailySummary(); // show once at startup

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task Done");
            System.out.println("6. Start Pomodoro");
            System.out.println("7. Exit");
            System.out.println("8. Show Daily Summary"); 
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> taskManager.listTasks();
                case 2 -> {
                    System.out.print("Task title: ");
                    String title = sc.nextLine();
                    System.out.print("Category (Work/Study/Personal): ");
                    String cat = sc.nextLine();
                    taskManager.addTask(title, cat);
                }
                case 3 -> {
                    taskManager.listTasks();
                    System.out.print("Index to edit: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("New title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("New category: ");
                    String newCat = sc.nextLine();
                    taskManager.editTask(idx, newTitle, newCat);
                }
                case 4 -> {
                    taskManager.listTasks();
                    System.out.print("Index to delete: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    taskManager.deleteTask(idx);
                }
                case 5 -> {
                    taskManager.listTasks();
                    System.out.print("Index to mark done: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    taskManager.markTaskDone(idx);
                }
                case 6 -> {
                    Thread t = new Thread(() -> {
                        timer.startPomodoro();
                        System.out.println("Pomodoros completed today: " + timer.getCompletedPomodoros());
                    });
                    t.start();

                    System.out.println("Type 'stop' to end Pomodoro early:");
                    String input = sc.nextLine();
                    if (input.equalsIgnoreCase("stop")) {
                        timer.stopPomodoro();
                        System.out.println("Pomodoro stopped early.");
                    }
                }
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                case 8 -> dashboard.showDailySummary(); 
            }
        }
    }
}

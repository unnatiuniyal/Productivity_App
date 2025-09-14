package organizer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private final String filePath = "src/data/tasks.json";

    public TaskManager() {
        tasks = loadTasks();
    }

    public void addTask(String title, String category) {
        tasks.add(new Task(title, category));
        saveTasks();
    }

    public void editTask(int index, String newTitle, String newCategory) {
        if (index >= 0 && index < tasks.size()) {
            Task t = tasks.get(index);
            t.setTitle(newTitle);
            t.setCategory(newCategory);
            saveTasks();
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
            saveTasks();
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    private void saveTasks() {
        try (FileWriter writer = new FileWriter(filePath)) {
            new Gson().toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private List<Task> loadTasks() {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Task>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}

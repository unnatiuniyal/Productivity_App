package organizer;

public class Task {
    private String title;
    private String category; // Work, Study, Personal
    private boolean done;

    public Task(String title, String category) {
        this.title = title;
        this.category = category;
        this.done = false;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public boolean isDone() { return done; }

    public void markDone() { this.done = true; }
    public void setTitle(String newTitle) { this.title = newTitle; }
    public void setCategory(String newCategory) { this.category = newCategory; }

    @Override
    public String toString() {
        return (done ? "[✅] " : "[ ] ") + title + " (" + category + ")";
    }
}

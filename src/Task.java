import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task
{
    private String title;
    private String description;
    private final LocalDateTime createdAt;
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Task(String title, String description)
    {
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() {return createdAt; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }

    public String toString()
    {
        return title + " - " + description + " (створенно: " + createdAt + ").";
    }
}

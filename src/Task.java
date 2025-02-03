public class Task  {

    private int id;
    private String name;
    private String description;
    private String category;
    private String deadline;

    public Task(int id, String name, String description, String category, String deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.deadline = deadline;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getCategory() { return category; }

    public String getDeadline() { return deadline; }
}

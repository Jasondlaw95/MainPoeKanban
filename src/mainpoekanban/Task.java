package mainpoekanban;

public class Task {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String description;
    private String developerFirstName;
    private String developerLastName;
    private int duration;
    private String status;

    public Task(String name, String description, String developerFirstName, String developerLastName, int duration) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.duration = duration;
        this.status = "todo";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String printTaskDetails() {
        return "Task: " + name + "\n"
                + "Description: " + description + "\n"
                + "Developer: " + developerFirstName + " " + developerLastName + "\n"
                + "Duration: " + duration + " hours";
    }
}

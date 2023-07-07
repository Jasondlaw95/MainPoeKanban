package mainpoekanban;

import java.util.List;
import javax.swing.JOptionPane;

public class MainPoeKanban {
    private static Login login;
    private static TaskManager taskManager;
    private static String[] developers;
    private static String[] taskNames;
    private static int[] taskIds;
    private static int[] taskDurations;
    private static String[] taskStatus;

    public static void main(String[] args) { // WE eed to ensure the necessary variables are initialized
        taskManager = new TaskManager();
        developers = new String[100];
        taskNames = new String[100];
        taskIds = new int[100];
        taskDurations = new int[100];
        taskStatus = new String[100];

        JOptionPane.showMessageDialog(null, "Welcome to your EasyKanban");

        while (true) { //We need to have the user input by prompting them.
            String input = JOptionPane.showInputDialog(null, """
                                                             Please choose from the below option:?
                                                             Press "r" to register, "l" to login, or "q" to quit.""");

            if (input == null || input.equals("q")) { //This allows for the user to exit  the program by allowing them to quit.
                break;
            }

            switch (input) {
                case "r" -> { //  We need to provide the user with steps to register.
                    String username = JOptionPane.showInputDialog(null, "Enter username: Please ensure it does not exceed 5 characters and contains an underscore.");
                    String password = JOptionPane.showInputDialog(null, "Enter password: Please ensure that it contains an underscore, a numeric and at least 1 uppercase:");
                    String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
                    String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
                    login = new Login(username, password, firstName, lastName);
                    JOptionPane.showMessageDialog(null, login.registerUser());
                }
                case "l" -> {
                    if (login == null) { //   User needs to be prompted to create a username an password with parameters.
                        JOptionPane.showMessageDialog(null, "Please register first.");
                    } else { //prompt the user to enter the username and password
                        String enteredUsername = JOptionPane.showInputDialog(null, "Enter username:");
                        String enteredPassword = JOptionPane.showInputDialog(null, "Enter password:");
                        //We need to show the login status and also present the task selections
                        if (login.loginUser(enteredUsername, enteredPassword)) {
                            JOptionPane.showMessageDialog(null, login.returnLoginStatus(enteredUsername, enteredPassword));
                            showTaskOptions();
                        } else {
                            JOptionPane.showMessageDialog(null, "The username and/or password is ot valid");
                        }
                    }
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid input.");
            }
        }
    }

   private static void showTaskOptions() {
    int choice = 0;
    do {
        //  We need to display the entire menu which shows the selections the user can choose from
        String menu = """
                Choose an option:
                1) Add tasks
                2) Display tasks with status 'done'
                3) Display task with longest duration
                4) Search task by name
                5) Search tasks by developer
                6) Delete task by name
                7) Display full task details
                8) Quit
                Enter your choice:
                """;
        String choiceString = JOptionPane.showInputDialog(null, menu);

        try {
            choice = Integer.parseInt(choiceString);
            switch (choice) {
                case 1 -> addTasks();
                case 2 -> displayTasksWithStatus("done");
                case 3 -> displayTaskWithLongestDuration();
                case 4 -> searchTaskByName();
                case 5 -> searchTasksByDeveloper();
                case 6 -> deleteTaskByName();
                case 7 -> displayFullTaskDetails();
                case 8 -> JOptionPane.showMessageDialog(null, "Cheerio!");
                default -> JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid choice, please enter a number.");
        }
    } while (choice != 8);
}




    private static void addTasks() {
        //We need to prompt the user to enter the number of tasks needed
        String taskCountString = JOptionPane.showInputDialog(null, "Please enter the number of tasks:");
        int taskCount = Integer.parseInt(taskCountString);
        for (int i = 0; i < taskCount; i++) {
            
            //Prompt the user to enter specifics into the task
            String taskName = JOptionPane.showInputDialog(null, "Task name:");
            String taskDescription = JOptionPane.showInputDialog(null, "Task description (max 50 characters):");
            String developerFirstName = JOptionPane.showInputDialog(null, "Enter th developer's first name:");
            String developerLastName = JOptionPane.showInputDialog(null, "Enter the developer's last name:");
            String taskDurationString = JOptionPane.showInputDialog(null, "Enter the task duration in hours:");
            int taskDuration = Integer.parseInt(taskDurationString);

            Task task = new Task(taskName, taskDescription, developerFirstName, developerLastName, taskDuration);
            taskManager.addTask(task);

            developers[i] = developerFirstName + " " + developerLastName;
            taskNames[i] = taskName;
            taskIds[i] = task.getId();
            taskDurations[i] = task.getDuration();
            taskStatus[i] = task.getStatus();

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }
        JOptionPane.showMessageDialog(null, "All tasks have been entered.");
    }
    
    private static void displayTasksWithStatus(String status) {
        System.out.println("Tasks with status '" + status + "':");
        List<Task> tasks = taskManager.getTasks();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                System.out.println("Task Name: " + task.getName());
                System.out.println("Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName());
                System.out.println("Duration: " + task.getDuration() + " hours");
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks fond with the status '" + status + "'.");
        }
    }

    private static void displayTaskWithLongestDuration() {
        int longestDuration = 0;
        Task longestTask = null;
        List<Task> tasks = taskManager.getTasks();
        for (Task task : tasks) {
            if (task.getDuration() > longestDuration) {
                longestDuration = task.getDuration();
                longestTask = task;
            }
        }
        if (longestTask != null) {
            System.out.println("Task with the longest duration:");
            System.out.println("Develper: " + longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName());
            System.out.println("Duration: " + longestTask.getDuration() + " hours");
        } else {
            System.out.println("No tasks found.");
        }
    }
    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog(null, "Enter the task name to search:");
        System.out.println("Search results for task name: " + taskName);
        List<Task> tasks = taskManager.getTasks();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                System.out.println("Task Name: " + task.getName());
                System.out.println("Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName());
                System.out.println("Status: " + task.getStatus());
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with the specified task name.");
        }
    }

    private static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog(null, "Enter the developer name to search:");
        System.out.println("Tasks assigned to developer: " + developerName);
        List<Task> tasks = taskManager.getTasks();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDeveloperFirstName().equalsIgnoreCase(developerName) || task.getDeveloperLastName().equalsIgnoreCase(developerName)) {
                System.out.println("Task Name: " + task.getName());
                System.out.println("Status: " + task.getStatus());
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found assgned to the specified developer.");
        }
    }

    private static void deleteTaskByName() {
    String taskName = JOptionPane.showInputDialog(null, "Enter the task name to delete:");
    boolean deleted = false;
    List<Task> tasks = taskManager.getTasks();
    for (int i = tasks.size() - 1; i >= 0; i--) {
        Task task = tasks.get(i);
        if (task.getName().equalsIgnoreCase(taskName)) {
            tasks.remove(i);
            deleted = true;
        }
    }
    if (deleted) {
        System.out.println("Task with the name '" + taskName + "' deleted successfully.");
    } else {
        System.out.println("No tasks found with the specified tak name.");
    }
}

    private static void displayFullTaskDetails() {
    System.out.println("Full task details:");
    List<Task> tasks = taskManager.getTasks();
    for (Task task : tasks) {
        System.out.println(task.printTaskDetails());
        System.out.println("--------------------");
    }
}

}
    

    

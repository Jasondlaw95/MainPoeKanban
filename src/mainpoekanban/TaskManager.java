
package mainpoekanban;

import java.util.ArrayList;
import java.util.List;

//The taks manager class handles the collections and calculations of the "tasks'
//We need to ensure that the task list is initialised accordingly
//We need to be able to retrieve a list of taks.

//We need to allow for the status of the task to be displayed a swell as the durations.
//We need to be able tosearch for task specifically be it by developer or task name.
//We also need to be able to have the user pull a report withg all the task details/information.
/**
 *
 * @author jason
 */
public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void displayTasksWithStatusDone() {
        System.out.println("Tasks with status 'done':");
        for (Task task : tasks) {
            if (task.getStatus().equals("done")) {
                System.out.println("Task Name: " + task.getName());
                System.out.println("Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName());
                System.out.println("Duration: " + task.getDuration() + " hours");
                System.out.println("--------------------");
            }
        }
    }

    public void displayTaskWithLongestDuration() {
        int longestDuration = 0;
        Task longestTask = null;
        for (Task task : tasks) {
            if (task.getDuration() > longestDuration) {
                longestDuration = task.getDuration();
                longestTask = task;
            }
        }

        if (longestTask != null) {
            System.out.println("Task with longest duration:");
            System.out.println("Developer: " + longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName());
            System.out.println("Duration: " + longestTask.getDuration() + " hours");
        } else {
            System.out.println("No tasks found.");
        }
    }

    public void searchTaskByName(String taskName) {
        System.out.println("Search results for task name: " + taskName);
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

    public void searchTasksByDeveloper(String developerName) {
        System.out.println("Tasks assigned to developer: " + developerName);
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
            System.out.println("No tasks assigned to the specified developer.");
        }
    }

    public void deleteTaskByName(String taskName) {
        boolean deleted = false;
        for (int i = tasks.size() - 1; i >= 0; i--) {
            Task task = tasks.get(i);
            if (task.getName().equalsIgnoreCase(taskName)) {
                tasks.remove(i);
                deleted = true;
            }
        }

        if (deleted) {
            System.out.println("Task  '" + taskName + "' deleted successfully.");
        } else {
            System.out.println("No tasks found with the specified task name.");
        }
    }

    public void displayTaskReport() {
        System.out.println("Task Report:");
        for (Task task : tasks) {
            System.out.println(task.printTaskDetails());
            System.out.println("--------------------");
        }
    }
}



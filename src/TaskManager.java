/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;

import java.util.List;
import mainpoekanban.Task;

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
            System.out.println("No tasks found assigned to the specified developer.");
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
            System.out.println("Task with the name '" + taskName + "' deleted successfully.");
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


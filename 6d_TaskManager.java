package tasks.task6.t1;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add task to the list
    public void addTask(String task) {
        tasks.add(task);
    }

    // Update a task's description by index
    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Remove a task by its index
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Display all tasks
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.addTask("Finish project report");
        tm.addTask("Buy groceries");
        tm.displayTasks();
        tm.updateTask(1, "Buy vegetables");
        tm.removeTask(0);
        tm.displayTasks();
    }
}

package tasks.task6.t1;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(String task) {
        tasks.add(task);
    }

    // Update a task's description
    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Remove a task by index
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Display all tasks
    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Study for exams");
        toDoList.addTask("Go for a walk");
        toDoList.displayTasks();
        toDoList.updateTask(1, "Go jogging");
        toDoList.removeTask(0);
        toDoList.displayTasks();
    }
}

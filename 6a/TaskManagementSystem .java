
import java.util.ArrayList;
import java.util.Scanner;
 class TaskManagementSystem {

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        tms.addTask("Finish assignment");
        tms.addTask("Read a book");
        tms.updateTask(1, "Read two books");
        tms.displayTasks();
        tms.removeTask(0);
        tms.displayTasks();
    }
   
    private ArrayList<String> tasks;

    public TaskManagementSystem() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            System.out.println("Task updated at position " + index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            System.out.println("Task removed: " + tasks.remove(index));
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

   
}


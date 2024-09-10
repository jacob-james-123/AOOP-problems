import java.util.ArrayList;
import java.util.List;

class ToDoList {
    private List<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void updateTask(int index, String newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
            System.out.println("Task updated at index " + index);
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
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addTask("Buy groceries");
        toDoList.addTask("Clean the house");
        toDoList.updateTask(1, "Clean the entire house");
        toDoList.displayTasks();
        toDoList.removeTask(0);
        toDoList.displayTasks();
    }
}

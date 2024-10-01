package tasks.Task5.t2;

// Worker interface for working behavior
interface Worker {
    void work();
}

// Eater interface for eating behavior
interface Eater {
    void eat();
}

// Robot class only works
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

// Human class works and eats
class Human implements Worker, Eater {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }
}

// Main class to demonstrate Interface Segregation Principle
public class ISPDemo {
    public static void main(String[] args) {
        Worker robot = new Robot();
        robot.work();

        Human human = new Human();
        human.work();
        human.eat();
    }
}

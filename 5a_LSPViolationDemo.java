package tasks.Task5.t2;

// Bird class
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

// Ostrich class (Ostrich can't fly, LSP violation)
class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly!");
    }
}

// Main class to demonstrate LSP violation
public class LSPViolationDemo {
    public static void main(String[] args) {
        Bird bird = new Ostrich(); // LSP violation, Ostrich can't fly
        bird.fly(); // This will cause an exception
    }
}

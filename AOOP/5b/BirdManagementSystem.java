//Liskvo substitution principle
public class BirdManagementSystem {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        // This works fine
        makeBirdFly(sparrow);

        // This causes an issue, illustrating the violation of LSP
        makeBirdFly(ostrich);
    }

    public static void makeBirdFly(Bird bird) {
        bird.fly(); // Will throw an exception for Ostrich
    }
}

// Base class representing a Bird

class Bird {
    public void fly() {
        System.out.println("This bird is flying.");
    }
}

// Subclass representing a Sparrow (a bird that can fly)
class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("The sparrow is flying high in the sky.");
    }
}

// Subclass representing an Ostrich (a bird that cannot fly)
class Ostrich extends Bird {
    @Override
    public void fly() {
        // Violates LSP because Ostrich cannot fly, but the method implies it can
        throw new UnsupportedOperationException("Ostriches cannot fly.");
    }
}


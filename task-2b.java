package tasks.task2;

public class t2 {
    
        public static void main(String[] args) {
            // Manage user login with Singleton
            UserSession userSession = UserSession.getInstance();
            userSession.login("User123");
    
            if (userSession.isUserLoggedIn()) {
                // Choose vehicle type (Car, Bike, or Scooter)
                VehicleFactory vehicleFactory;
                String vehicleType = "Car";  // Can be "Car", "Bike", or "Scooter"
    
                switch (vehicleType) {
                    case "Car":
                        vehicleFactory = new CarFactory();
                        break;
                    case "Bike":
                        vehicleFactory = new BikeFactory();
                        break;
                    case "Scooter":
                        vehicleFactory = new ScooterFactory();
                        break;
                    default:
                        vehicleFactory = new CarFactory(); // Default to Car
                        break;
                }
    
                // Create and start ride with the chosen vehicle
                Vehicle vehicle = vehicleFactory.createVehicle();
                vehicle.ride();
    
                // Choose payment method (Credit Card, PayPal, Cash)
                PaymentFactory paymentFactory;
                String paymentType = "PayPal";  // Can be "CreditCard", "PayPal", or "Cash"
    
                switch (paymentType) {
                    case "CreditCard":
                        paymentFactory = new CreditCardFactory();
                        break;
                    case "PayPal":
                        paymentFactory = new PayPalFactory();
                        break;
                    case "Cash":
                        paymentFactory = new CashFactory();
                        break;
                    default:
                        paymentFactory = new CreditCardFactory(); // Default to Credit Card
                        break;
                }
    
                // Create and process payment
                PaymentMethod paymentMethod = paymentFactory.createPaymentMethod();
                paymentMethod.pay(25.0); // Assuming the fare is $25
    
            } else {
                System.out.println("Please log in to request a ride.");
            }
    
            // Logout after ride
            userSession.logout();
        }
    
    
    
}
 class UserSession {
    private static UserSession instance;
    private String userId;
    private boolean isLoggedIn;

    private UserSession() {
        this.isLoggedIn = false;
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void login(String userId) {
        if (!isLoggedIn) {
            this.userId = userId;
            this.isLoggedIn = true;
            System.out.println("User " + userId + " logged in successfully.");
        } else {
            System.out.println("User already logged in.");
        }
    }

    public void logout() {
        if (isLoggedIn) {
            System.out.println("User " + userId + " logged out.");
            this.isLoggedIn = false;
            this.userId = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public boolean isUserLoggedIn() {
        return isLoggedIn;
    }

    public String getUserId() {
        return userId;
    }
}
// Vehicle Interface
 interface Vehicle {
    void ride();
}

// Concrete Vehicle Classes
class Car implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Car is arriving for your ride!");
    }
}

class Bike implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Bike is arriving for your ride!");
    }
}

class Scooter implements Vehicle {
    @Override
    public void ride() {
        System.out.println("Scooter is arriving for your ride!");
    }
}

// Vehicle Factory
 abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

// Concrete Factories
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

class ScooterFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Scooter();
    }
}

// PaymentMethod Interface
 interface PaymentMethod {
    void pay(double amount);
}

// Concrete Payment Methods
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Cash.");
    }
}

// Abstract Factory for Payment
 interface PaymentFactory {
    PaymentMethod createPaymentMethod();
}

// Concrete Factories for Payment Methods
class CreditCardFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

class PayPalFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}

class CashFactory implements PaymentFactory {
    @Override
    public PaymentMethod createPaymentMethod() {
        return new CashPayment();
    }
}

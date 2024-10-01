package tasks.task1;

public class t2 {
   
        public static void main(String[] args) {
            // Create the banking operations class with an initial balance
            BankOperations bank = new BankOperations(1000);
    
            // Try to perform operations without logging in
            bank.viewBalance(); // Should ask to log in
            bank.deposit(200);  // Should ask to log in
            bank.withdraw(100); // Should ask to log in
    
            // Log in the user
            UserSession.getInstance().login("User123");
    
            // Perform banking operations after login
            bank.viewBalance(); // Should show the balance
            bank.deposit(200);  // Should deposit the money
            bank.withdraw(150); // Should withdraw the money
    
            // Attempt to log in again (shouldn't allow)
            UserSession.getInstance().login("User456");
    
            // Log out the user
            UserSession.getInstance().logout();
    
            // Try to perform operations after logout
            bank.viewBalance(); // Should ask to log in again
        }
    }
    
    class BankOperations {
        private double balance;
    
        // Constructor to initialize balance
        public BankOperations(double initialBalance) {
            this.balance = initialBalance;
        }
    
        // Method to view balance
        public void viewBalance() {
            if (UserSession.getInstance().isUserLoggedIn()) {
                System.out.println("User " + UserSession.getInstance().getUserId() + " Balance: $" + balance);
            } else {
                System.out.println("Please login to view your balance.");
            }
        }
    
        // Method to deposit money
        public void deposit(double amount) {
            if (UserSession.getInstance().isUserLoggedIn()) {
                balance += amount;
                System.out.println("Deposited $" + amount + " successfully. New Balance: $" + balance);
            } else {
                System.out.println("Please login to deposit money.");
            }
        }
    
        // Method to withdraw money
        public void withdraw(double amount) {
            if (UserSession.getInstance().isUserLoggedIn()) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrew $" + amount + " successfully. New Balance: $" + balance);
                } else {
                    System.out.println("Insufficient balance to withdraw $" + amount);
                }
            } else {
                System.out.println("Please login to withdraw money.");
            }
        }
    }
    
   class UserSession {
        // Static instance of the class (Singleton)
        private static UserSession instance;
        
        // Field to track if the user is logged in
        private boolean isLoggedIn;
        
        // Field to hold the logged-in user information (for example, user ID)
        private String userId;
    
        // Private constructor to prevent instantiation
        private UserSession() {
            isLoggedIn = false; // Initially, no user is logged in
        }
    
        // Static method to get the single instance of UserSession (global access point)
        public static UserSession getInstance() {
            if (instance == null) {
                instance = new UserSession();
            }
            return instance;
        }
    
        // Method to log in the user
        public void login(String userId) {
            if (!isLoggedIn) {
                this.userId = userId;
                this.isLoggedIn = true;
                System.out.println("User " + userId + " logged in successfully.");
            } else {
                System.out.println("User already logged in.");
            }
        }
    
        // Method to log out the user
        public void logout() {
            if (isLoggedIn) {
                System.out.println("User " + userId + " logged out.");
                this.userId = null;
                this.isLoggedIn = false;
            } else {
                System.out.println("No user is currently logged in.");
            }
        }
    
        // Method to check if a user is logged in
        public boolean isUserLoggedIn() {
            return isLoggedIn;
        }
    
        // Method to get the logged-in user ID
        public String getUserId() {
            return userId;
        }
    }
    
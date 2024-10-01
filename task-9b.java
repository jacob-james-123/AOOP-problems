package tasks.task9;

public class t2  {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initialize the account with $1000

        // Create multiple threads for deposit and withdrawal transactions
        Thread t1 = new Thread(new Transaction(account, true, 200.00));  // Deposit $200
        Thread t2 = new Thread(new Transaction(account, false, 150.00)); // Withdraw $150
        Thread t3 = new Thread(new Transaction(account, true, 300.00));  // Deposit $300
        Thread t4 = new Thread(new Transaction(account, false, 500.00)); // Withdraw $500
        Thread t5 = new Thread(new Transaction(account, false, 1000.00)); // Withdraw $1000 (should fail)

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final balance
        System.out.printf("Final Balance: %.2f%n", account.getBalance());
    }
}

    

class BankAccount {
    private double balance;

    // Constructor to initialize the bank account with a balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: %.2f | New Balance: %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Synchronized method to withdraw money
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: %.2f | New Balance: %.2f%n", amount, balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount!");
        }
    }

    // Method to get the current balance
    public synchronized double getBalance() {
        return balance;
    }
}

class Transaction implements Runnable {
    private final BankAccount account;
    private final boolean isDeposit;
    private final double amount;

    // Constructor to initialize the transaction
    public Transaction(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}


package tasks.task9;

public class t1 {
     public static void main(String[] args) {
            // Shared range of numbers from 1 to 15
            for (int i = 1; i <= 15; i++) {
                int number = i;
    
                // Create threads for each condition
                Thread t1 = new Thread(() -> printTwo(number));
                Thread t2 = new Thread(() -> printThree(number));
                Thread t3 = new Thread(() -> printFour(number));
                Thread t4 = new Thread(() -> printFive(number));
                Thread t5 = new Thread(() -> printNumber(number));
    
                // Start all threads
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
    
                // Join threads to ensure correct order
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    
        // Function to print if divisible by 2
        public static void printTwo(int number) {
            if (number % 2 == 0 && number % 3 != 0 && number % 4 != 0 && number % 5 != 0) {
                System.out.println(number + " is divisible by 2");
            }
        }
    
        // Function to print if divisible by 3
        public static void printThree(int number) {
            if (number % 3 == 0 && number % 4 != 0 && number % 5 != 0) {
                System.out.println(number + " is divisible by 3");
            }
        }
    
        // Function to print if divisible by 4
        public static void printFour(int number) {
            if (number % 4 == 0 && number % 5 != 0) {
                System.out.println(number + " is divisible by 4");
            }
        }
    
        // Function to print if divisible by 5
        public static void printFive(int number) {
            if (number % 5 == 0) {
                System.out.println(number + " is divisible by 5");
            }
        }
    
        // Function to print the number if none of the above conditions are met
        public static void printNumber(int number) {
            if (number % 2 != 0 && number % 3 != 0 && number % 4 != 0 && number % 5 != 0) {
                System.out.println(number);
            }
        }
    }
    


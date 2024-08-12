package AOOP;
public class bankaccount{
    public static void main(String[] args) {
        Account a = Account.getAccount(new String("jacob"), new String("1234"));
        a.deposit(1000);
        a.withDraw(10000);
        a.withDraw(5);
    }
}

  class Account{
    private static Account instance = null;
    private String name;
    private String DOB;
    private static int  balance = 9000;

    private Account(String name, String DOB) {
        this.name = name;
        this.DOB = DOB;
        
    }
    public static synchronized Account getAccount(String name, String DOB) {
        if (instance == null) {
            instance = new Account(name, DOB);
            System.out.println("Login successful");
        } else if (!instance.name.equals(name) || !instance.DOB.equals(DOB)) {
            System.out.println("Invalid credentials");
            return null;
        } else {
            System.out.println("Login successful");
        }
        return instance;
    }
   
    public static void deposit(int a){
        balance+=a;
        System.out.println("the new balance is "+ balance);
    }
    public static void withDraw(int x){
        if(x<=balance){
            balance-=x;
        }
        else{
            System.out.println("amount not sufficient ");
        }
        System.out.println("balance is"+ balance);
    }



}
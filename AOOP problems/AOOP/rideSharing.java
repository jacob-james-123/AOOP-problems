package AOOP;
import java.util.Scanner;

public class rideSharing {
    public static void main(String[] args) {
        passenger p1 = passenger.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name and id to login");
        p1.Name = sc.nextLine();
        p1.id = sc.nextInt();
        sc.nextLine();
        System.out.println(" Enter vechile type : car or bike ");
        String vechileType = sc.nextLine();
        Vechile v ;
        Vechilefactory vf = new Vechilefactory();
        v = vf.getInstance(vechileType);
        v.Vechiletype();
        System.out.println("Enter source and destination");
        p1.source = sc.nextLine();
        p1.destination = sc.nextLine();
        System.out.println("Entre true to share ride , else enter false");
        p1.shareRide = sc.nextBoolean();
        System.out.println("Ur ride -> " + vechileType  + "  ,shared ->" + (p1.shareRide ? "may u meet kind and good strangers " : "have a good time alone ") +
        " ,from -> "+ p1.source +" to " + p1.destination +" will arrive soon");
        sc.close();
    }
}
//singleton pattern
class passenger{
    private static passenger p;
    public String  Name;
    public int id;
    public String source;
    public String destination;
    public boolean shareRide;

    private passenger(){

    }
    public static passenger getInstance(){
       if(p == null){
        p = new passenger();
       }
       return p;
    }
}


 interface Vechile  {
    void Vechiletype();
}
//car 
class Car implements Vechile{
    public void Vechiletype(){
        System.out.println("U have chosen a car ");
    }
}
//bike 
class Bike implements Vechile{
    public void Vechiletype(){
        System.err.println("U have chosen a bike");
    }
}
// Vechile factory
 class Vechilefactory{
    public Vechile getInstance(String str){
        if(str.equalsIgnoreCase("car")){
            return new Car();
        }
        else if(str.equalsIgnoreCase("bike")){
            return new Bike();
        }
        else return null;

    }

 }
import java.util.ArrayList;

public class Employ_salaryManager {
   public static void main(String[] args) {
    //single responsibility principle
    Employ e  = new Employ("jacob", "ceo");
    Employ e1  = new Employ("abel", "manager");
    Employ e2  = new Employ("alex", "employee");

   SalaryCalculation s  = new SalaryCalculation();
   s.CalculateSalary(e);
   s.CalculateSalary(e2);
   s.CalculateSalary(e1);
System.out.println("-------------------------------");
System.out.println("OCP-->");
   // Open/Closed Principle (OCP)
    
   circle circle = new circle();
   circle.calculateArea(12);
   rectangle r = new rectangle();
   r.calculateArea(12.3, 13.2);

   }
}

//only one responsibility i.e to create employees
class Employ{
    String name;
    String role;
    
    Employ(String name,String role){
        this.name = name;
        this.role = role;
    }
}
// to calculate salary structure
class SalaryCalculation{
    public  void CalculateSalary(Employ e){
        if(e.role.equalsIgnoreCase("employee")){
            System.out.println("the salary structure for employee is --");
            System.out.println("the ctc is 3.5lakhs per annum");
            System.out.println("the salary per month is 29,166.166");
            System.out.println("the tax is 10% ---> 2900");
            System.out.println("the insurance is --> 3000");
            System.out.println("the salary in hand is 24,100");
            System.out.println("-------------------------------");
        }else if(e.role.equalsIgnoreCase("ceo")){
            System.out.println("the salary structure for CEO is --");
            System.out.println("the ctc is 7cr per annum");
            System.out.println("the salary per month is 58,33,333.33");
            System.out.println("the tax is 15% ---> 8,70,000");
            System.out.println("the insurance is --> 3000");
            System.out.println("the salary in hand is 51,00,000");
            System.out.println("-------------------------------");
        }else if(e.role.equalsIgnoreCase("manager")){
            System.out.println("the salary structure for manager is --");
            System.out.println("the ctc is 1cr per annum");
            System.out.println("the salary per month is 8,00,000");
            System.out.println("the tax is 15% ---> 120000");
            System.out.println("the insurance is --> 3000");
            System.out.println("the salary in hand is 6,80,000");
            System.out.println("-------------------------------");
        }
    }
}

//open close principle
interface Shape{
    void GetArea();
}

//circle
class circle implements Shape {
    float Area;
    void calculateArea(int radius){
        this.Area = (float)Math.PI*radius*radius;
        GetArea();
    }
     
    public void GetArea(){
        System.out.println("the area of circle is "+ Area);
    }
}

class rectangle implements Shape {
    double Area;
    void calculateArea(double l,double b){
        this.Area = l*b;
        GetArea();
    }
     
    public void GetArea(){
        System.out.println("the area of circle is "+ Area);
    }
}
package AOOP;
public class logger{
    public static void main(String[] args) {
        Single s = Single.getInstance();
        StringBuilder name = new StringBuilder("jacob James");
        StringBuilder mail = new StringBuilder("jacobl1234@gmail.com");
        StringBuilder password = new StringBuilder("linx@112!&");
      
        s.enterDeatils(name, mail, password);
        s.getDetails();
    }
}

class Single {
    private static Single s ;
        private  StringBuilder name;
        private  StringBuilder mail;
        private  StringBuilder password;
        
       
  private  Single(){
        
    }
   
   public static Single getInstance(){
   if(s==null){
    s= new Single();
   }
   return s;
   }

   public  void enterDeatils(StringBuilder name,StringBuilder mail,StringBuilder password){
   this.name = name;
   this.password = password;
   this.mail = mail;
   }
   public void getDetails(){
    System.out.println("name = " + name);
    System.out.println("password = "+ password);
    System.err.println("mailid = " + mail);
   }
       

}

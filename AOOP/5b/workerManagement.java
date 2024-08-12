public class workerManagement {
    public static void main(String[] args) {
        // method are called implicitly in consturctor
        human person =new human();
        robot humanoid =new robot();
    }
}
// ISP
// we created 2 interfaces for seperate tasks
interface worker{
    void works();
}

interface eater{
    void eats();
}

class human implements worker,eater{
    human(){
        // A human has to work and eat
        eats();
        works();
    }

  public  void eats(){
        System.out.println("the worker eats");
    }
    public void works(){
        System.out.println("the worker works ");
    }
}

class robot implements worker{
    robot(){
        // A robot can work without eating
        works();
    }

   public void works(){
        System.out.println("the robot only works ");
    }
}
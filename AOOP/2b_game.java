import java.util.Scanner;

public class game {
  public static void main(String[] args) {
  gameState gs = gameState.getGamestate();
  factoryEnemy ft = new createThanos();
  ft.fight();
  factoryEnemy ft1 = new createDarkWidow();
  ft1.fight();
  }
}

interface enemies{
    public void fight();
}
class thanos implements enemies{
    public void fight(){
        System.out.println("ur going to fight thanos");
    }
}
class darkwidow implements enemies{
    public void fight(){
        System.out.println("ur going to fight darkwidow");
    }
}

abstract class factoryEnemy{
    abstract enemies creatEnemies();

    public void fight(){
        enemies e =creatEnemies();
        e.fight();
    }
}

class createThanos extends factoryEnemy{
    @Override
    enemies creatEnemies() {
        thanos t = new thanos();

        return t;
    }
}

class createDarkWidow extends factoryEnemy{
    @Override
    enemies creatEnemies() {
        darkwidow t = new darkwidow();

        return t;
    }
}

  
class gameState{
    private static gameState g= null;
    static int  levels= 1;
    String mode ;
    Scanner sc = new Scanner (System.in); 
    private gameState(){
       System.out.println("the default level is 1 "+"easy mode");
       System.out.println("enter between easy and hard mode");
       String s = sc.nextLine();
       changemood(s);
    }
    public static void nextLevel(){
        System.out.println("you moved to next level"+ levels+1);
        levels++;
    }
    public static gameState getGamestate(){
        if(g==null){
            g =new gameState();
           
        }
        return g;
    }
    public void changemood(String mode){
        this.mode = mode;
        System.out.println("current mode is "+mode);
    }
}
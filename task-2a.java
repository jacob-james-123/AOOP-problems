package tasks.task2;

public class t1 {
    
        public static void main(String[] args) {
            // Manage game state with Singleton
            GameState gameState = GameState.getInstance();
            gameState.displayState();
    
            // Set level and difficulty
            gameState.setCurrentLevel(2);
            gameState.setDifficulty("Hard");
            gameState.displayState();
    
            // Create enemies based on difficulty
            EnemyFactory enemyFactory;
            GameItemFactory itemFactory;
    
            if (gameState.getDifficulty().equals("Easy")) {
                enemyFactory = new EasyEnemyFactory();
                itemFactory = new EasyItemFactory();
            } else {
                enemyFactory = new HardEnemyFactory();
                itemFactory = new HardItemFactory();
            }
    
            // Create and use enemy
            Enemy enemy = enemyFactory.createEnemy();
            enemy.attack();
    
            // Create and use weapon and power-up
            Weapon weapon = itemFactory.createWeapon();
            PowerUp powerUp = itemFactory.createPowerUp();
    
            weapon.use();
            powerUp.activate();
        }
    }
    

 class GameState {
    private static GameState instance;
    private int currentLevel;
    private String difficulty;

    private GameState() {
        currentLevel = 1; // Start at level 1
        difficulty = "Easy"; // Default difficulty
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int level) {
        currentLevel = level;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void displayState() {
        System.out.println("Current Level: " + currentLevel + ", Difficulty: " + difficulty);
    }
}

// Enemy Interface
 interface Enemy {
    void attack();
}

// Concrete Enemy classes
class EasyEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Easy enemy attacks weakly!");
    }
}

class HardEnemy implements Enemy {
    @Override
    public void attack() {
        System.out.println("Hard enemy attacks strongly!");
    }
}

// Enemy Factory
 abstract class EnemyFactory {
    public abstract Enemy createEnemy();
}

// Factory for Easy Enemies
class EasyEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new EasyEnemy();
    }
}

// Factory for Hard Enemies
class HardEnemyFactory extends EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new HardEnemy();
    }
}

// Weapon Interface
interface Weapon {
    void use();
}

// PowerUp Interface
interface PowerUp {
    void activate();
}

// Concrete Weapons
class EasyWeapon implements Weapon {
    @Override
    public void use() {
        System.out.println("Easy weapon used with basic damage.");
    }
}

class HardWeapon implements Weapon {
    @Override
    public void use() {
        System.out.println("Hard weapon used with high damage.");
    }
}

// Concrete PowerUps
class EasyPowerUp implements PowerUp {
    @Override
    public void activate() {
        System.out.println("Easy power-up activated with basic boost.");
    }
}

class HardPowerUp implements PowerUp {
    @Override
    public void activate() {
        System.out.println("Hard power-up activated with strong boost.");
    }
}

// Abstract Factory for Weapons and PowerUps
 interface GameItemFactory {
    Weapon createWeapon();
    PowerUp createPowerUp();
}

// Factory for Easy Level Items
class EasyItemFactory implements GameItemFactory {
    @Override
    public Weapon createWeapon() {
        return new EasyWeapon();
    }

    @Override
    public PowerUp createPowerUp() {
        return new EasyPowerUp();
    }
}

// Factory for Hard Level Items
class HardItemFactory implements GameItemFactory {
    @Override
    public Weapon createWeapon() {
        return new HardWeapon();
    }

    @Override
    public PowerUp createPowerUp() {
        return new HardPowerUp();
    }
}

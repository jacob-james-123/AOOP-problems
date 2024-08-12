package AOOP;
// Main Class to run the program
public class Investment_Portfolio
 {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();

        // Conservative Strategy
        portfolio.setStrategy(new ConservativeStrategy());
        portfolio.invest(1000);

        // Balanced Strategy
        portfolio.setStrategy(new BalancedStrategy());
        portfolio.invest(2000);

        // Aggressive Strategy
        portfolio.setStrategy(new AggressiveStrategy());
        portfolio.invest(3000);
    }
}
// InvestmentStrategy Interface
 interface InvestmentStrategy {
    void invest(double amount);
}

// Concrete Strategy: Conservative
class ConservativeStrategy implements InvestmentStrategy {
    @Override
    public void invest(double amount) {
        System.out.println("Investing conservatively: " + amount + " in bonds and blue-chip stocks.");
    }
}

// Concrete Strategy: Balanced
 class BalancedStrategy implements InvestmentStrategy {
    @Override
    public void invest(double amount) {
        System.out.println("Investing balanced: " + amount + " equally in stocks and bonds.");
    }
}

// Concrete Strategy: Aggressive
 class AggressiveStrategy implements InvestmentStrategy {
    @Override
    public void invest(double amount) {
        System.out.println("Investing aggressively: " + amount + " in high-risk stocks.");
    }
}

// Portfolio Class
 class Portfolio {
    private InvestmentStrategy strategy;

    public void setStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void invest(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Investment strategy is not set.");
        }
        strategy.invest(amount);
    }
}

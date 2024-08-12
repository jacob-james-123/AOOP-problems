
package AOOP;
// JUnit Tests
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PortfolioTest {

    @Test
    public void testConservativeStrategy() {
        Portfolio portfolio = new Portfolio();
        portfolio.setStrategy(new ConservativeStrategy());
        portfolio.invest(1000);
    }

    @Test
    public void testBalancedStrategy() {
        Portfolio portfolio = new Portfolio();
        portfolio.setStrategy(new BalancedStrategy());
        portfolio.invest(2000);
    }

    @Test
    public void testAggressiveStrategy() {
        Portfolio portfolio = new Portfolio();
        portfolio.setStrategy(new AggressiveStrategy());
        portfolio.invest(3000);
    }

    
}



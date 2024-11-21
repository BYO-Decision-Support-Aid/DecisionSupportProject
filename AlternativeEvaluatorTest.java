import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlternativeEvaluatorTest {

    @Test
    public void testSingleAlternative() {
        AlternativeEvaluator evaluator = new AlternativeEvaluator();
        String[] alternatives = {"Option 1"};
        double[][] values = {{10.0}};

        String result = evaluator.getOptimalAlternative(alternatives, values);
        assertEquals("Option 1", result);
    }

    @Test
    public void testMultipleAlternativesSingleCriterion() {
        AlternativeEvaluator evaluator = new AlternativeEvaluator();
        String[] alternatives = {"Option 1", "Option 2", "Option 3"};
        double[][] values = {
            {5.0},
            {10.0},
            {7.5}
        };

        String result = evaluator.getOptimalAlternative(alternatives, values);
        assertEquals("Option 2", result);
    }

    @Test
    public void testTiedAlternatives() {
        AlternativeEvaluator evaluator = new AlternativeEvaluator();
        String[] alternatives = {"Option 1", "Option 2", "Option 3"};
        double[][] values = {
            {5.0, 5.0},
            {5.0, 5.0},
            {3.0, 3.0}
        };

        String result = evaluator.getOptimalAlternative(alternatives, values);
        assertTrue(result.equals("Option 1") || result.equals("Option 2"), 
                   "Either Option 1 or Option 2 is acceptable as the optimal choice in case of a tie.");
    }

    @Test
    public void testZeroValues() {
        AlternativeEvaluator evaluator = new AlternativeEvaluator();
        String[] alternatives = {"Option 1", "Option 2"};
        double[][] values = {
            {0.0, 0.0},
            {0.0, 0.0}
        };

        String result = evaluator.getOptimalAlternative(alternatives, values);
        assertTrue(result.equals("Option 1") || result.equals("Option 2"), 
                   "Either Option 1 or Option 2 is acceptable when all values are zero.");
    }

    @Test
    public void testNegativeValues() {
        AlternativeEvaluator evaluator = new AlternativeEvaluator();
        String[] alternatives = {"Option 1", "Option 2", "Option 3"};
        double[][] values = {
            {-5.0, -3.0},
            {-4.0, -6.0},
            {-7.0, -2.0}
        };

        String result = evaluator.getOptimalAlternative(alternatives, values);
        assertEquals("Option 1", result);
    }
}

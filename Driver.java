
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AlternativeEvaluator evaluator = new AlternativeEvaluator();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Input number of alternatives
                int numAlternatives = inputHandler.getNumberOfAlternatives(scanner);
                if (numAlternatives == -1) {
                    break;
                }

                String[] alternatives = inputHandler.getAlternatives(scanner, numAlternatives);

                // Input number of criteria
                int numCriteria = inputHandler.getNumberOfCriteria(scanner);

                String[] criteria = inputHandler.getCriteria(scanner, numCriteria);

                // Input values for each alternative and criterion
                double[][] values = inputHandler.getValues(scanner, numAlternatives, numCriteria);

                // Print the criteria and values for each alternative
                inputHandler.printCriteriaAndValues(criteria, values);

                // Determine the optimal alternative based on the criteria
                String optimalAlternative = evaluator.getOptimalAlternative(alternatives, values);
                System.out.println("According to the criteria, the optimal alternative is: " + optimalAlternative);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

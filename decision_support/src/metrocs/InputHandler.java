import java.util.Scanner;

public class InputHandler {
    public int getNumberOfAlternatives(Scanner scanner) {
        try {
            System.out.println("Enter the number of options (or type 'stop' to exit):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                return -1;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid number.");
            return getNumberOfAlternatives(scanner);
        }
    }

    public String[] getAlternatives(Scanner scanner, int numAlternatives) {
        String[] alternatives = new String[numAlternatives];
        for (int i = 0; i < numAlternatives; i++) {
            System.out.println("Enter option " + (i + 1) + ":");
            alternatives[i] = scanner.nextLine();
        }
        return alternatives;
    }

    public int getNumberOfCriteria(Scanner scanner) {
        try {
            System.out.println("Enter the number of criteria:");
            int numCriteria = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return numCriteria;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid number.");
            return getNumberOfCriteria(scanner);
        }
    }

    public String[] getCriteria(Scanner scanner, int numCriteria) {
        String[] criteria = new String[numCriteria];
        for (int i = 0; i < numCriteria; i++) {
            System.out.println("Enter criterion " + (i + 1) + ":");
            criteria[i] = scanner.nextLine();
        }
        return criteria;
    }

    public double[][] getValues(Scanner scanner, int numAlternatives, int numCriteria) {
        double[][] values = new double[numAlternatives][numCriteria];
        for (int i = 0; i < numAlternatives; i++) {
            for (int j = 0; j < numCriteria; j++) {
                try {
                    System.out.println("Enter the value for option " + (i + 1) + " and criterion " + (j + 1) + ":");
                    values[i][j] = scanner.nextDouble();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter a valid number.");
                    j--; // Retry the current criterion
                }
            }
            scanner.nextLine(); // Consume newline after reading the last double value
        }
        return values;
    }

    public void printCriteriaAndValues(String[] criteria, double[][] values) {
        System.out.println("Criteria and values for each alternative:");
        for (String criterion : criteria) {
            System.out.print(criterion + "\t");
        }
        System.out.println();
        for (double[] valueRow : values) {
            for (double value : valueRow) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
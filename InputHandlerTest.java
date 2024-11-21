import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputHandlerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetNumberOfAlternatives() {
        String simulatedInput = "3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        int numAlternatives = inputHandler.getNumberOfAlternatives(scanner);
        assertEquals(3, numAlternatives);
    }

    @Test
    public void testGetNumberOfAlternativesStop() {
        String simulatedInput = "stop\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        int result = inputHandler.getNumberOfAlternatives(scanner);
        assertEquals(-1, result);
    }

    @Test
    public void testGetAlternatives() {
        String simulatedInput = "Option 1\nOption 2\nOption 3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        String[] alternatives = inputHandler.getAlternatives(scanner, 3);
        assertArrayEquals(new String[]{"Option 1", "Option 2", "Option 3"}, alternatives);
    }

    @Test
    public void testGetNumberOfCriteria() {
        String simulatedInput = "2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        int numCriteria = inputHandler.getNumberOfCriteria(scanner);
        assertEquals(2, numCriteria);
    }

    @Test
    public void testGetCriteria() {
        String simulatedInput = "Criterion 1\nCriterion 2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        String[] criteria = inputHandler.getCriteria(scanner, 2);
        assertArrayEquals(new String[]{"Criterion 1", "Criterion 2"}, criteria);
    }

    @Test
    public void testGetValues() {
        String simulatedInput = "1.5\n2.5\n3.5\n4.5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHandler inputHandler = new InputHandler();

        double[][] values = inputHandler.getValues(scanner, 2, 2);
        double[][] expectedValues = {
            {1.5, 2.5},
            {3.5, 4.5}
        };

        assertArrayEquals(expectedValues, values);
    }

}

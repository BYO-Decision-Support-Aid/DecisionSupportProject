package helloCS3250.src.metrocs;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for class HelloWorld.
 *
 * @author  Dr. Jody Paul
 * @version 1.1.1
 */
public class HelloWorldTest {
    @Test
    public void sayHelloBasicsTest() {
        HelloWorld hW1 = new HelloWorld();
        assertEquals("Hello world", hW1.sayHello("world"));
        assertEquals("Hello earth", hW1.sayHello("earth"));
    }

    @Test
    public void sayHelloEmptyStringTest() {
        HelloWorld hW1 = new HelloWorld();
        assertEquals("Hello", hW1.sayHello(""));
    }

    @Test
    public void sayHelloNullTest() {
        HelloWorld hW1 = new HelloWorld();
        assertEquals("Hello!", hW1.sayHello(null));
    }

    @Test
    public void unnecessaryTest() {
        assertNotNull(new HelloWorld());
    }

    @Test
    public void groupedAssertionTest() {
        HelloWorld hW1 = new HelloWorld();
        assertAll("hello someone",
                  () -> assertEquals("Hello world", hW1.sayHello("world")),
                  () -> assertEquals("Hello", hW1.sayHello("")),
                  () -> assertEquals("Hello earth", hW1.sayHello("earth")),
                  () -> assertEquals("Hello!", hW1.sayHello(null)));
    }
}

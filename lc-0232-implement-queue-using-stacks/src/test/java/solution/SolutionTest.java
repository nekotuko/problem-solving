/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @ParameterizedTest
    @CsvSource({
            "1, 2, 1, 1"
    })
    void templateTestCases(int push1, int push2, int expected1, int expected2) {
        MyQueue s = new MyQueue();
        
        s.push(push1);
        s.push(push2);
        assertFalse(s.empty());
        assertEquals(s.peek(),expected1);
        assertEquals(s.pop(), expected2);
        assertFalse(s.empty());
        s.pop();
        assertTrue(s.empty());
        
    }
}
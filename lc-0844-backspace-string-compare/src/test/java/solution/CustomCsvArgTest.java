package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyBoolean {
        public final boolean value;

        MyBoolean(String s) {
            value = Boolean.parseBoolean(s);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "ab#c; ad#c; true",
            "ab##; c#d#; true",
            "a#c; b; false",
            "a##c; #a#c; true",
            "#fo##f; y#f#o##f; true"
    }, delimiter = ';')
    void testWithMyArgs(String inputString1, String inputString2, MyBoolean expected) {
        Solution s = new Solution();
        assertEquals(expected.value, s.backspaceCompare(inputString1, inputString2));
    }

}

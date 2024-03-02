package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    @ParameterizedTest
    @CsvSource(value = {
            "A man, a plan, a canal: Panama; true",
            "race a car; false",
            "''; true",
            "()(); false",
            ")(((); true",
            "())(; true"
    }, delimiter = ';')
    void testWithMyArgs(String str, boolean expected) {
        Solution s = new Solution();
        assertEquals(expected, s.isPalindrome(str));
    }

}
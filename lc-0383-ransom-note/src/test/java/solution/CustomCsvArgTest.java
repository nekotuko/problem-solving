package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyBoolean {
        final boolean value;

        MyBoolean(String s) {
            value = Boolean.parseBoolean(s);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a; b; false",
            "aa; ab; false",
            "aa; aab; true",
            "helloworld; thisworldishell; false",
            "helloworld; thisworldisnothell; true"
    }, delimiter = ';')
    void testWithMyArgs1(String ransomNote, String magazine, MyBoolean expected) {
        Solution s = new Solution();

        // Use !XOR to get true if expected and actual are both either false or true.
        assertTrue(!Boolean.logicalXor(expected.value, s.canConstruct(ransomNote, magazine)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "a; b; false",
            "aa; ab; false",
            "aa; aab; true",
            "helloworld; thisworldishell; false",
            "helloworld; thisworldisnothell; true"
    }, delimiter = ';')
    void testWithMyArgs2(String ransomNote, String magazine, MyBoolean expected) {
        Solution2 s = new Solution2();

        // Use !XOR to get true if expected and actual are both either false or true.
        assertTrue(!Boolean.logicalXor(expected.value, s.canConstruct(ransomNote, magazine)));
    }

}

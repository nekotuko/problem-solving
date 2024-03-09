package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyBoolean {
        public boolean value;

        MyBoolean(String s) {
            if (s.equals("true")) {
                value = true;
            } else if (s.equals("false")) {
                value = false;
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "anagram; nagaram; true",
            "rat; car; false",
            "clinteastwood; oldwestaction; true"
    }, delimiter = ';')
    void testWithMyArgs(String str1, String str2, MyBoolean expected) {
        Solution s = new Solution();
        assertEquals(s.isAnagram(str1, str2), expected.value);
    }

}

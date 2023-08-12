package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyArg {
        MyArg(String s) {
            String[] tokens = s.split(";");
            int n = tokens.length;

            values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = Integer.parseInt(tokens[i]);
            }
        }

        public final int[] values;
    }

    @ParameterizedTest
    @CsvSource({
            "4;1;2, 1;3;4;2, -1;3;-1",
            "2;4, 1;2;3;4, 3;-1",
            "1, 1;2, 2",
            "1, 2;1, -1",
    })
    void testWithMyArgs(MyArg nums1, MyArg nums2, MyArg expected) {
        Solution s = new Solution();
        assertArrayEquals(expected.values, s.nextGreaterElement(nums1.values, nums2.values));
    }

}

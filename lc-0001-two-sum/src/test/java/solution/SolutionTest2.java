/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest2 {
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
            "2;7;11;15, 9, 0;1",
            "3;2;4, 6, 1;2",
            "3;3, 6, 0;1"
    })
    void test(MyArg a, MyArg b, MyArg c) {
        Solution2 s = new Solution2();
        assertArrayEquals(c.values, s.twoSum(a.values, b.values[0]));
    }
}
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
            "1;2;3,10;10;10,11;12;13",
            "1;2;3,19;18;17,20;20;20",
    })
    void testWithMyArgs(MyArg a, MyArg b, MyArg c) {
        Solution s = new Solution();
        assertArrayEquals(c.values, s.addAll(a.values, b.values));
    }

}

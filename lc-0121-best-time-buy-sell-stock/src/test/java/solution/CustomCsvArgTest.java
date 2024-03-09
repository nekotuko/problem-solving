package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyArg {
        MyArg(String s) {
            s = s.replaceAll("\\[", "");
            s = s.replaceAll("\\]", "");
            String[] tokens = s.split(",");
            int n = tokens.length;

            values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = Integer.parseInt(tokens[i]);
            }
        }

        public final int[] values;
    }

    @ParameterizedTest
    @CsvSource(value = {
            "[7,1,5,3,6,4]; 5",
            "[7,6,4,3,1]; 0",
            "[11,13,20,5,19]; 14",
    }, delimiter = ';')
    void testWithMyArgs(MyArg a, int ans) {
        Solution s = new Solution();
        assertEquals(ans, s.maxProfit(a.values));
    }

}

package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class MyIntArr {
        MyIntArr(String s) {
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
            "[-1,0,3,5,9,12]; -1; 0",
            "[-1,0,3,5,12]; 12; 4",
            "[-1,0,3,9,12]; 2; -1",
            "[-1,0,3,9,12]; 3; 2",
            "[-1,0,3,5,9,12]; 15; -1",
            "[-1,0,3,5,9,12]; -15; -1",
            "[5]; 5; 0",
            "[5]; 1; -1"
    }, delimiter = ';')
    void test(MyIntArr inputArr, int inputTarget, int expected) {
        Solution s = new Solution();
        assertEquals(expected, s.search(inputArr.values, inputTarget));
    }

}

package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvArgTest {

    static class My2DArray {
        public final int[][] values;

        My2DArray(String s) {
            s = s.replaceAll("\\[", "");
            s = s.replaceAll("\\]", "");
            String[] tokens = s.split(" ");

            int rows = tokens.length;
            int cols;

            if (rows != 0) {
                String[] temp = tokens[0].split(",");
                cols = temp.length;
                values = new int[rows][cols];

                for (int i = 0; i < rows; i++) {
                    String[] rowVals = tokens[i].split(",");

                    for (int j = 0; j < cols; j++) {
                        values[i][j] = Integer.parseInt(rowVals[j]);
                    }
                }

            } else {
                values = new int[0][0];
            }
        }
    }

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

    // Template to test 1D array inputs/outputs:
    @ParameterizedTest
    @CsvSource(value = {
            "[1,2,3]; [10,10,10]; [11,12,13]",
            "[1,2,3]; [19,18,17]; [20,20,20]"
    }, delimiter = ';')
    void testWithMyArgs(MyArg a, MyArg b, MyArg c) {
        Solution s = new Solution();
        assertArrayEquals(c.values, s.addAll(a.values, b.values));
    }

    // Template to test 2D array inputs/outputs:
    @ParameterizedTest
    @CsvSource(value = {
            "[] []; 0",
            "[1,2,3] [4,5,6] [7,8,9]; 45"
    }, delimiter = ';')
    void testWith2DArrays(My2DArray input, int expected) {
        Solution s = new Solution();
        assertEquals(expected, s.addAll2DArray(input.values));
    }
}

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

    @ParameterizedTest
    @CsvSource(value = {
            "[1,1,1] [1,1,0] [1,0,1]; 1; 1; 2;[2,2,2] [2,2,0] [2,0,1]",
            "[1,1,1] [1,1,1]; 0; 0; 10; [10,10,10] [10,10,10]",
            "[1,1,1] [1,0,1]; 1; 1; 10; [1,1,1] [1,10,1]"
    }, delimiter = ';')
    void testBFS(My2DArray image, int sr, int sc, int color, My2DArray expected) {
        SolutionBFS s = new SolutionBFS();

        assertArrayEquals(expected.values, s.floodFill(image.values, sr, sc, color));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "[1,1,1] [1,1,0] [1,0,1]; 1; 1; 2;[2,2,2] [2,2,0] [2,0,1]",
            "[1,1,1] [1,1,1]; 0; 0; 10; [10,10,10] [10,10,10]",
            "[1,1,1] [1,0,1]; 1; 1; 10; [1,1,1] [1,10,1]"
    }, delimiter = ';')
    void testDFS(My2DArray image, int sr, int sc, int color, My2DArray expected) {
        SolutionDFS s = new SolutionDFS();

        assertArrayEquals(expected.values, s.floodFill(image.values, sr, sc, color));
    }

}

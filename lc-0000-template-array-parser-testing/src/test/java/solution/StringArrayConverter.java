package solution;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringArrayConverter extends SimpleArgumentConverter {

    // Each LINE of csv data is one SET of arrays. Each ARRAY is split
    // by '|'. Each VALUE of arrays is split by ','.
    // LAST ARRAY is always EXPECTED ARRAY.

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[][].class.isAssignableFrom(targetType)) {
            String[] testCases = ((String) source).split(",");

            List<List<Integer>> resultAsList = new ArrayList<>();
            for (int i = 0; i < testCases.length; i++) {
                String[] testCase = testCases[i].split("\\|"); // Escaped "|"

                List<Integer> singleResultAsList = new ArrayList<>();
                for (int j = 0; j < testCase.length; j++) {
                    singleResultAsList.add(Integer.parseInt(testCase[j]));
                }

                resultAsList.add(singleResultAsList);
            }

            int[][] resultAsArr = new int[resultAsList.size()][resultAsList.get(0).size()];

            for (int i = 0; i < resultAsArr.length; i++) {
                resultAsArr[i] = resultAsList.get(i).stream().mapToInt(Integer::intValue).toArray();
            }

            return resultAsArr;
        }
        throw new ArgumentConversionException("Cannot convert " + source + " to " + targetType);
    }

}
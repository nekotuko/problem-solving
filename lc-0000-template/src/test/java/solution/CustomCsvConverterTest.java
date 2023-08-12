package solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CustomCsvConverterTest {

    static class ToArrayArgumentConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) {
            assertEquals(int[].class, targetType, "Can only convert to int[]");
            String s = (String) source;
            String[] tokens = s.split(";");
            int n = tokens.length;

            int[] values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = Integer.parseInt(tokens[i]);
            }
            return values;
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1;2;3,10;10;10,11;12;13",
            "1;2;3,19;18;17,20;20;20",
    })
    void testWithCustomConverter(
            @ConvertWith(ToArrayArgumentConverter.class) int[] a,
            @ConvertWith(ToArrayArgumentConverter.class) int[] b,
            @ConvertWith(ToArrayArgumentConverter.class) int[] c) {
        Solution s = new Solution();
        assertArrayEquals(c, s.addAll(a, b));
    }

}

package solution;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToIntArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
            String[] sourceStr = ((String) source).split(";");

            int[] ans = new int[sourceStr.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = Integer.parseInt(sourceStr[i]);
            }
            return ans;
        }
        throw new ArgumentConversionException("Cannot convert " + source + " to " + targetType);
    }
}
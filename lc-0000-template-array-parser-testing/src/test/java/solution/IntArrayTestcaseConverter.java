package solution;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

public class IntArrayTestcaseConverter implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == int[][].class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        Method testMethod = extensionContext.getRequiredTestMethod();
        CsvSource csvSourceAnnotation = testMethod.getAnnotation(CsvSource.class);

        if (csvSourceAnnotation != null) {
            String[] testCases = csvSourceAnnotation.value();

            return Stream.of(testCases)
                    .map(testCase -> Stream.of(testCase.split("\\|"))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
        }

        throw new IllegalArgumentException("@CsvSource annotation not found on test method");
    }
}

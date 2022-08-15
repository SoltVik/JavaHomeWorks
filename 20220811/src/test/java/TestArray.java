import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestArray {
    CheckArray checkArray = new CheckArray();

    @BeforeEach
    public void init() {
        checkArray = new CheckArray();
    }

    @ParameterizedTest
    @MethodSource("dataForArrayCheckOperation")
    public void testArrayCheck(Integer[] array, int number, Integer[] result) {
        Assertions.assertArrayEquals(result, checkArray.getAllAfterLastNumber(array, number));
    }

    public static Stream<Arguments> dataForArrayCheckOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[] { 1, 2, 4, 4, 2, 3, 4, 1, 7 }, 4, new Integer[] { 1, 7 }));
        out.add(Arguments.arguments(new Integer[] { 1, 2, 3, 5, 2, 3, 6, 1, 7 }, 4, new Integer[] { 1, 7 }));
        out.add(Arguments.arguments(new Integer[] { 1, 2, 4, 4, 2, 3, 4, 1, 4 }, 4, new Integer[] { }));
        out.add(Arguments.arguments(new Integer[] { 1, 2, 4, 3, 2, 3, 8, 1, 7 }, 4, new Integer[] { 3, 2, 3, 8, 1, 7 }));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForNotInArrayCheckOperation")
    public void testArrayCheck(Integer[] array, boolean result) {
        Assertions.assertEquals(result, checkArray.isArrayOnlyFromNumbers(array, 1, 4));
    }

    public static Stream<Arguments> dataForNotInArrayCheckOperation() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[] { 1, 1, 1, 4, 4, 1, 4, 4 }, true));
        out.add(Arguments.arguments(new Integer[] { 1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new Integer[] { 4, 4, 4, 4  }, false));
        out.add(Arguments.arguments(new Integer[] { 1, 4, 4, 1, 1, 4, 3 }, false));
        return out.stream();
    }
}

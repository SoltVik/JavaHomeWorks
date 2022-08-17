import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "7, 5, 12",
            "12, 12, 24"
    })

    @ParameterizedTest
    public void parametrizedTestAdd(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @Test
    public void testAdd(){
        Assertions.assertEquals(4, calculator.add(2,2));
    }

    @Test
    @Disabled
    public void testSub(){
        Assertions.assertEquals(-2, calculator.sub(2,4));
    }
}

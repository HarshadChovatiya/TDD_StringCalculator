package stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCalculator {

    private static StringCalculator stringCalculator;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    void test() {
        int output = stringCalculator.Add("1234");
        assertEquals(0, output);
    }
}

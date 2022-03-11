package stringcalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCalculator {

    private static StringCalculator stringCalculator;

    @BeforeAll
    static void setUpBeforeClass() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testEmptyString() {
        int output = stringCalculator.Add("");
        assertEquals(0, output);
    }
}

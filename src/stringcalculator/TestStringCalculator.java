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

    @Test
    void testSingleNumber() {
        int output = stringCalculator.Add("5");
        assertEquals(5, output);
    }

    @Test
    void testTwoNumbersWithDefaultDelimiter() {
        int output = stringCalculator.Add("5,4");
        assertEquals(9, output);
    }

    @Test
    void testMultipleNumbersWithDefaultDelimiter() {
        int output = stringCalculator.Add("5,4,3,2,1");
        assertEquals(15, output);
    }

    @Test
    void testTwoNumbersWithNewlineAndCommaDelimiter() {
        int output = stringCalculator.Add("1\n2");
        assertEquals(3, output);
    }

    @Test
    void testMultipleNumbersWithNewlineAndCommaDelimiter() {
        int output = stringCalculator.Add("5\n4,3,2\n1");
        assertEquals(15, output);
    }

    @Test
    void testSingleDelimiterWithoutBrackets() {
        int output = stringCalculator.Add("//;\n1;2");
        assertEquals(3, output);
    }
    
}

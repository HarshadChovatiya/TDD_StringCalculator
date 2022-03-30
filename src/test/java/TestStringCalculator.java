import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.SaveLogRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

public class TestStringCalculator {

    private StringCalculator stringCalculator;

    private SaveLogRepository saveLogRepository;

    @BeforeEach
    void setUpBeforeClass() {
        saveLogRepository = mock(SaveLogRepository.class);
        stringCalculator = new StringCalculator(saveLogRepository);
        when(saveLogRepository.saveLog(Mockito.anyString())).thenAnswer(returnsFirstArg());
    }

    @Test
    void testEmptyString() {
        int output = stringCalculator.Add("");
        assertEquals(0, output);
        verify(saveLogRepository).saveLog("");

    }

    @Test
    void testSingleNumber() {
        int output = stringCalculator.Add("5");
        assertEquals(5, output);
        verify(saveLogRepository).saveLog("5");

    }

    @Test
    void testTwoNumbersWithDefaultDelimiter() {
        int output = stringCalculator.Add("5,4");
        assertEquals(9, output);
        verify(saveLogRepository).saveLog("5,4");

    }

    @Test
    void testMultipleNumbersWithDefaultDelimiter() {
        int output = stringCalculator.Add("5,4,3,2,1");
        assertEquals(15, output);
        verify(saveLogRepository).saveLog("5,4,3,2,1");

    }

    @Test
    void testTwoNumbersWithNewlineAndCommaDelimiter() {
        int output = stringCalculator.Add("1\n2");
        assertEquals(3, output);
        verify(saveLogRepository).saveLog("1\n2");

    }

    @Test
    void testMultipleNumbersWithNewlineAndCommaDelimiter() {
        int output = stringCalculator.Add("5\n4,3,2\n1");
        assertEquals(15, output);
        verify(saveLogRepository).saveLog("5\n4,3,2\n1");

    }

    @Test
    void testSingleDelimiterWithoutBrackets() {
        int output = stringCalculator.Add("//;\n1;2");
        assertEquals(3, output);
        verify(saveLogRepository).saveLog("//;\n1;2");

    }

    @Test
    void testNegativeNumbers() {
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> stringCalculator.Add("1,-23"));
        assertTrue(thrown.getMessage().contains("negatives not allowed : -23,"));
        verify(saveLogRepository).saveLog("1,-23");

    }

    @Test
    void testNumberBiggerThanThousand() {
        int output = stringCalculator.Add("1001,2");
        assertEquals(2, output);
        verify(saveLogRepository).saveLog("1001,2");

    }

    @Test
    void testDelimiterOfAnyLength() {
        int output = stringCalculator.Add("//[***]\n1***2***3");
        assertEquals(6, output);
        verify(saveLogRepository).saveLog("//[***]\n1***2***3");

    }

    @Test
    void testMultipleDelimiter() {
        int output = stringCalculator.Add("//[*][%]\n1*2%3");
        assertEquals(6, output);
        verify(saveLogRepository).saveLog("//[*][%]\n1*2%3");

    }

    @Test
    void testMultipleDelimiterOfAnyLength() {
        int output = stringCalculator.Add("//[***][%%%]\n1***2%%%3");
        assertEquals(6, output);
        verify(saveLogRepository).saveLog("//[***][%%%]\n1***2%%%3");
    }

    @Test
    void testSaveLogsWhileAddingNumbers() {
        String input = "1001,2";
        when(saveLogRepository.saveLog(input)).thenReturn(input);
        int output = stringCalculator.Add(input);
        assertEquals(2, output);
        verify(saveLogRepository).saveLog(input);
    }
}

package stringcalculator;

public class StringCalculator {

    private int answer;

    // constructor
    StringCalculator() {
        answer = 0;
    }

    private String getDefaultDelimiter() {
        return ",|\n";
    }

    private String[] getNumberAsStringArrayFromGivenInput(String numberString, String delimiter) {
        String[] numbers = numberString.split(delimiter, 0);
        return numbers;
    }

    private int calculateSum(String[] operands) {
        answer = 0;
        for(String number: operands) {
            answer += Integer.parseInt(number);
        }

        return answer;
    }

    public int Add(String numbers) {
        String delimiter = "";
        if(numbers.isEmpty()) {
            return 0;
        }

        delimiter = getDefaultDelimiter();

        String[] operands = getNumberAsStringArrayFromGivenInput(numbers, delimiter);

        answer = calculateSum(operands);

        return answer;
    }

}

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

    private String getSingleDelimiterWithoutBrackets(String first_line) {
        return first_line.substring(2);
    }

    private String[] getNumberAsStringArrayFromGivenInput(String numberString, String delimiter) {
        String[] numbers = numberString.split(delimiter, 0);
        return numbers;
    }

    private int calculateSum(String[] operands) {
        answer = 0;
        String negativeNumbers = "";

        for(String number: operands) {
            if(!number.isEmpty()) {
                int temp = Integer.parseInt(number);
                if(temp < 0) {
                    negativeNumbers += number;
                    negativeNumbers += ",";
                }
                else {
                    answer += temp;
                }
            }
        }

        if(!negativeNumbers.isEmpty()) {
            throw new ArithmeticException("negatives not allowed : " + negativeNumbers);
        }

        return answer;
    }

    public int Add(String numbers) {
        String delimiter = "";
        if(numbers.isEmpty()) {
            return 0;
        }

        if(numbers.startsWith("//")) {
            String first_line = numbers.split("\n")[0];
            numbers = numbers.split("\n")[1];

            if(first_line.charAt(2) != '[') {
                delimiter = getSingleDelimiterWithoutBrackets(first_line);
            }
        }
        else {
            delimiter = getDefaultDelimiter();
        }

        String[] operands = getNumberAsStringArrayFromGivenInput(numbers, delimiter);

        answer = calculateSum(operands);

        return answer;
    }

}

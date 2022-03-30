import repository.SaveLogRepository;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private int answer;

    private SaveLogRepository saveLogRepository;

    // constructor
    StringCalculator(SaveLogRepository saveLogRepository) {
        answer = 0;
        this.saveLogRepository = saveLogRepository;
    }

    private String getDefaultDelimiter() {
        return ",|\n";
    }

    private String getSingleDelimiterWithoutBrackets(String first_line) {
        return first_line.substring(2);
    }

    private String getDelimiterOfAnyLength(String first_line) {
        String delimeter = "";
        List<String> list=new ArrayList<String>();
        for(int i=2; i<first_line.length(); i++) {
            String temp = "";
            temp += first_line.charAt(i);
            int j=i+1;
            while(j < first_line.length() && first_line.charAt(j) != ']') {
                temp += first_line.charAt(j);
                j++;
            }
            temp += "]";
            i = j;
            list.add(temp);
        }
        for(String x: list) {
            delimeter += x;
            delimeter += "|";
        }
        delimeter = delimeter.substring(0, delimeter.length()-1);

        return delimeter;
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
                    if(temp <= 1000) {
                        answer += temp;
                    }
                }
            }
        }

        if(!negativeNumbers.isEmpty()) {
            throw new ArithmeticException("negatives not allowed : " + negativeNumbers);
        }

        return answer;
    }

    public int Add(String numbers) {
        saveLogRepository.saveLog(numbers);
        String delimiter = "";
        if(numbers.isEmpty()) {
            return 0;
        }

        if(numbers.startsWith("//")) {
            String first_line = numbers.split("\n")[0];
            numbers = numbers.split("\n")[1];

            if(first_line.charAt(2) != '[') {
                delimiter = getSingleDelimiterWithoutBrackets(first_line);
            } else {
                delimiter = getDelimiterOfAnyLength(first_line);
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

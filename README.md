# TDD_StringCalculator

## A Simple String Calculator with Test Driven Development in Java

### Problem Definition
- Create a simple String calculator with a method signature:
  int Add(string numbers)
  The method can take up to two numbers, separated by commas, and will return their sum.
  for example “” or “1” or “1,2” as inputs.
  (for an empty string it will return 0)

- Allow the Add method to handle an unknown amount of numbers.

- Allow the Add method to handle new lines between numbers (instead of commas).
  the following input is ok: “1\n2,3” (will equal 6)
  the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)

- Support different delimiters
  to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
  the first line is optional. all existing scenarios should still be supported

- Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.
  if there are multiple negatives, show all of them in the exception message.

- Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2.

- Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[\*\*\*]\n1\*\*\*2\*\*\*3” should return 6.

- Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[\*][%]\n1*2%3” should return 6.

- Make sure you can also handle multiple delimiters with length longer than one char.

- Make sure you only test for correct inputs. there is no need to test for invalid inputs.

### Environment Information
    Java Version : JavaSE-11(jre)
    Junit version: Junit5 (5.7.0)
    Tool Used: IntelliJ IDEA

### Assumption
> User will not enter any alphabet character in numbers string to perform addition.

> As mentioned in the problem definition not tested the code for invalid inputs.
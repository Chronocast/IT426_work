package calculator;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class runs all of the math equations for the Calculator App.
 *
 * <p>
 * It reads the entered data and the operator chosen as Strings.
 *
 * @author      Nate Hascup
 * @since       2.0
 */
public class Calculator
{
    /**
     * It converts the strings to relevant data types,
     * performs the required function,
     * converts the result back to string and returns answer to be displayed
     * <p>
     * The switch/case checks for the matching operator.
     * There is a check to ensure users don't divide by zero.
     * Pi just returns a String of Pi up to 12 digits
     *
     * @param storedNumber the String holding the first entered value
     * @param currentNumber the String holding the second entered value
     * @param operator the String holding the operator for the function
     *
     * @since       2.0
     */
    public String compute(String storedNumber, String currentNumber, String operator)
    {
        int result = 0;
        String solution = "";
        switch (operator)
        {
            case "+":
                result = Integer.parseInt(storedNumber) + Integer.parseInt(currentNumber);
                break;

            case "-":
                result = Integer.parseInt(storedNumber) - Integer.parseInt(currentNumber);
                break;

            case "*":
                result = Integer.parseInt(storedNumber) * Integer.parseInt(currentNumber);
                break;

            case "/":
                if (currentNumber.equals("0"))
                {
                    return solution = "Don't divide by 0!";
                }else if (!(currentNumber == "0"))
                {
                    result = Integer.parseInt(storedNumber) / Integer.parseInt(currentNumber);
                    break;
                }

            case "\u03c0":
                solution = "3.14159265359";
                return solution;

            case "x\u00B2":
                result = Integer.parseInt(storedNumber) * Integer.parseInt(storedNumber);
                break;

            case "\u221A":
                double square = Math.sqrt(Integer.parseInt(storedNumber));
                solution = Double.toString(square);
                return solution;
        }

        solution = Integer.toString(result);

        return solution;
    }



}

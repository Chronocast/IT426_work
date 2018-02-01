package calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator
{
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
                Double.toString(square);
                return solution;
        }

        solution = Integer.toString(result);

        return solution;
    }



}

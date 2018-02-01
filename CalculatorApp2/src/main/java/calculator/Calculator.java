package calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Calculator
{
    public String compute(String storedNumber, String currentNumber, String operator)
    {
        int result = 0;

        if("+".equals(operator))
        {
            result = Integer.parseInt(storedNumber) + Integer.parseInt(currentNumber);
        }

        String solution = Integer.toString(result);

        return solution;
    }



}

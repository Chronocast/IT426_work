package rankings;

import strategies.IStrategy;
import strategies.SelectiveStrategy;
import strategies.TotalStrategy;
import strategies.WeightedStrategy;

public class ReportingConsoleApp
{
    public static void main(String[] args)
    {
        Console console = new Console();



        /*
            1: display a welcome message for the user
            2: Prompt the user for a strategy: TotalStrategy, WeightedStrategy or SelectiveStrategy.
            3: Create the requested strategy object
            4: Create a RankingsCalculator object and print out the reviews using printRankings()
         */
        System.out.println("Welcome to the Employee Rankings Application");
        System.out.println("********************************************");
        System.out.println("Please select a strategy");
        System.out.println("1. Total");
        System.out.println("2. Weighted");
        System.out.println("3. Selective");

        menu(console.getInt());

    }

    private static void menu(int userInput){
        RankingsCalculator calculator = new RankingsCalculator();
        final int year = 2017;

        switch(userInput){
            case 1:
                calculator.printRankings(new TotalStrategy(), year);
                break;
            case 2:
                calculator.printRankings(new WeightedStrategy(), year);
                break;
            case 3:
                calculator.printRankings(new SelectiveStrategy(), year);
                break;
    }





    }
}

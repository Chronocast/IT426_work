package launcher;

import javafx.application.Application;
import ui.CalculatorUI;

/**
 * This class launches the Calculator App.
 * It currently calls the CalculatorUI class.
 * <p>
 * It will later call the rest of the app's classes.
 *
 * @author      Nate Hascup
 * @since       1.0
 */
public class Launcher {
    public static void main(String args[])
    {
        Application.launch(CalculatorUI.class, args);




    }


}

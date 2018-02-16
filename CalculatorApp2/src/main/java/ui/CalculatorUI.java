package ui;

import calculator.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class generates the UI for the Calculator App.
 * It sets a stage and scene, placing Buttons and a label in a GridPane.
 * <p>
 * The dose uses a String array of symbols which it cycles through to
 * ensure efficient and clean code.
 *
 * @author      Nate Hascup
 * @since       1.0
 */
public class CalculatorUI extends Application
{
    /**
     * This is the String array which holds
     * all of the symbols on the calculator.
     * <p>
     * String is static and final, and should not be altered
     * unless the UI is expanded beyond the planned functionality
     *
     * @since       1.0
     */
    public static final String[] faceButtons =
            {
                    "\u03c0", "x\u00B2", "\u221A", "C",
                    "7", "8", "9", "+",
                    "4", "5", "6", "-",
                    "1", "2", "3", "*",
                    "0", "ENTER" , "/", ":P"
            };

    /**
     * This is the String which holds
     * the first number entered by the user
     * <p>
     * If user is calling a function that only needs one variable,
     * this is the one that will be used.
     *
     * @since       2.0
     */
    public String currentNumber = "";

    /**
     * This is the String which holds
     * the second number entered by the user
     * <p>
     *
     * @since       2.0
     */
    public String storedNumumber = "";

    /**
     * This is the String which holds
     * the symbol selected on the calculator.
     * <p>
     *
     * @since       2.0
     */
    public String operator = "";

    /**
     * This is the Label which displays the values enterd
     * It will also display the answer for the function
     * <p>
     *
     * @since       2.0
     */
    final Label numberLabel = labelGenerate();

    /**
     * This is where the Stage and Scene are set.
     * Everything with relation to the UI is created through here.
     * <p>
     * The stylesheets are added here, along with the app's title and ICON
     * App uses a Google web-friendly font
     *
     * @param stage the platform where the app is displayed
     * @since       1.0
     */
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Calculator");



        Scene scene = calculatorDisplay(numberLabel);

        stage.setScene(scene);
        stage.getIcons().add(new Image("images/calculator-icon.png"));
        scene.getStylesheets().add("stylesheet.css");
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Gruppo");
        stage.show();
    }

    private Scene calculatorDisplay(Label numberLabel)
    {
        GridPane grid = buildGridPane();
        generateLayout(grid);

        grid.add(numberLabel, 0, 5, 4, 1);
        return new Scene(grid, 325, 325);
    }

    private GridPane buildGridPane()
    {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        grid.setAlignment(Pos.TOP_CENTER);

        return grid;
    }

    private void generateLayout(GridPane grid)
    {
        int lengthCounter = 0;
        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                Button button = new Button(faceButtons[lengthCounter]);
                button.setPrefWidth(55);

                if(lengthCounter == 3)
                {
                    generateClearButton(grid, button, col, row);
                }
                else if(lengthCounter == 0 ||
                        lengthCounter == 1 ||
                        lengthCounter == 2 ||
                        lengthCounter == 7 ||
                        lengthCounter == 11 ||
                        lengthCounter == 15)
                {
                    generateOperatorButton(grid, button, col, row);
                }
                else if(lengthCounter == 17)
                {
                    generateEnterButton(grid, button, col, row);
                }
                else if(lengthCounter == 18)
                {
                    generateOperatorButton(grid, button, 3, row);
                }
                else if(lengthCounter == 19)
                {
                    //do nothing
                }else{
                    generateNumberButton(grid, button, col, row);
                }
                lengthCounter++;
            }
        }
    }

    private void generateClearButton(GridPane grid, Button button, int col, int row)
    {

        button.setOnAction(event -> {
            clearKeyPress(event);
        });

        grid.add(button, col, row);
    }

    private void generateNumberButton(GridPane grid, Button button, int col, int row)
    {
        
        button.setOnAction(event -> {
            numKeyPress(event);
        });

        grid.add(button, col, row);
    }

    private void generateOperatorButton(GridPane grid, Button button, int col, int row)
    {

        button.setOnAction(event -> {
            operatorKeyPress(event);
        });

        grid.add(button, col, row);
    }

    private void generateEnterButton(GridPane grid, Button button, int col, int row)
    {
        button.setPrefWidth(120);

        button.setOnAction(event -> {
            enterKeyPress(event);
        });

        grid.add(button, col, row, 2, 1);
    }

    private Label labelGenerate()
    {
        Label numberLabel = new Label("_");
        numberLabel.setPrefWidth(250);
        numberLabel.setAlignment(Pos.BOTTOM_RIGHT);
        numberLabel.setPadding(new Insets(10));

        return numberLabel;
    }

    private void clearKeyPress(ActionEvent event)
    {
        currentNumber = "";
        storedNumumber = "";
        numberLabel.setText("_");
    }

    private void numKeyPress(ActionEvent event)
    {
        if(!("".equals(currentNumber)))
        {
            storedNumumber = currentNumber;
        }
        currentNumber += ((Button)event.getSource()).getText();
        numberLabel.setText(currentNumber);
    }

    private void operatorKeyPress(ActionEvent event)
    {
        storedNumumber = currentNumber;
        currentNumber = "";

        operator = ((Button)event.getSource()).getText();

        numberLabel.setText(currentNumber);
    }

    private void enterKeyPress(ActionEvent event)
    {
        Calculator calculator = new Calculator();
        String calculation = calculator.compute(storedNumumber, currentNumber, operator);
        numberLabel.setText(calculation);
        currentNumber = calculation;
    }
}

package ui;

import javafx.application.Application;
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
                    "7", "8", "9", "+",
                    "4", "5", "6", "-",
                    "1", "2", "3", "*",
                    "0", "ENTER" , "/", ":P"
            };

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
        Scene scene = calculatorDisplay();
        stage.setScene(scene);
        stage.getIcons().add(new Image("images/calculator-icon.png"));
        scene.getStylesheets().add("stylesheet.css");
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Gruppo");
        stage.show();
    }

    private Scene calculatorDisplay()
    {
        GridPane grid = buildGridPane();
        generateLayout(grid);
        grid.add(labelGenerate(), 0, 5, 4, 1);
        return new Scene(grid, 300, 300);
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
        for (int row = 0; row < 4; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                Button button = new Button(faceButtons[lengthCounter]);
                button.setPrefWidth(50);

                if(lengthCounter == 13)
                {
                    button.setPrefWidth(110);
                    grid.add(button, col, row, 2, 1);
                }
                else if(lengthCounter == 14)
                {
                    generateStandardButton(grid, button, 3, row);
                }
                else if(lengthCounter == 15)
                {
                    //do nothing
                }else{
                    generateStandardButton(grid, button, col, row);
                }
                lengthCounter++;
            }
        }
    }

    private void generateStandardButton(GridPane grid, Button button, int col, int row)
    {
        grid.add(button, col, row);
    }

    private Label labelGenerate()
    {
        Label label = new Label("1234567890");
        label.setPrefWidth(230);
        label.setAlignment(Pos.BOTTOM_RIGHT);
        label.setPadding(new Insets(10));

        return label;
    }
}

package controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PracticeWithControlsOLD extends Application
{
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception
    {
        this.stage = stage;

        stage.setTitle("Practicing with controls and layouts");
        stage.show();

        useButtons();
    }

    public void useButtons()
    {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button previous = new Button("Previous");
        Button next = new Button("Next");

        hBox.getChildren().addAll(previous, next, new Button("Cancel"));

        stage.setScene(new Scene(hBox, 500, 500));
    }
}

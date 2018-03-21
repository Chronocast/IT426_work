package launchers;

import adapters.CircleAdapter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.Circle;

public class AdamDriver extends Application
{

    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Compu-Doodle");
        stage.setScene(StartScreen());
        stage.show();
    }

    public Scene StartScreen()
    {
        VBox vox = new VBox();
        vox.setAlignment(Pos.CENTER);
        vox.setPadding(new Insets(10));

        Circle circle = new Circle(3, 50, 50, 2, Color.BLUE);

        CircleAdapter adapter = new CircleAdapter(circle);

        Adam adam = new Adam();
        adam.printShape(adapter);

        return new Scene(vox, 1024, 768);
    }
}
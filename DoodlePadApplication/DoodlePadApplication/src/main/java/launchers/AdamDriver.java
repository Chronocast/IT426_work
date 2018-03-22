package launchers;

import adapters.CircleAdapter;
import adapters.TriangleAdapter;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Triangle;

public class AdamDriver extends Application
{
    private CircleAdapter circleAdapter = new CircleAdapter(new Circle(200, 125, 125, 2, Color.BLUE));
    private TriangleAdapter triangleAdapter = new TriangleAdapter((new Triangle(100, 120, 15, 15, 2,Color.RED)));

    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Compu-Doodle");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc)
    {
        //circleAdapter.drawShape(gc);
        triangleAdapter.drawShape(gc);
    }
}
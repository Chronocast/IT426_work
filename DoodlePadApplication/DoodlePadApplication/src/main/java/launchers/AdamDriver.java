package launchers;

import adapters.CircleAdapter;
import adapters.LineAdapter;
import adapters.RectangleAdapter;
import adapters.TriangleAdapter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;

import java.awt.*;

public class AdamDriver extends Application
{
    public static final int imgSize = 25;
    private CircleAdapter circleAdapter = new CircleAdapter(new Circle(200, 125, 125, 2, Color.BLUE));
    private TriangleAdapter triangleAdapter = new TriangleAdapter((new Triangle(100, 120, 15, 15, 2,Color.RED)));
    private RectangleAdapter rectangleAdapter = new RectangleAdapter(new Rectangle(400, 300, 64, 32, 3, Color.YELLOW));
    private LineAdapter lineAdapter = new LineAdapter(new Line(222, 400, 322, 400, 5, Color.GREEN));

    private GraphicsContext gc;

    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Compu-Doodle");

        VBox ox = ox();
        HBox hox = hawks();

        Button roundBtn = circleButton();
        Button triangleBtn = triangleButton();
        Button rectangleBtn = rectangleButton();
        Button lineBtn = lineButton();

        hox.getChildren().add(roundBtn);
        hox.getChildren().add(triangleBtn);
        hox.getChildren().add(rectangleBtn);
        hox.getChildren().add(lineBtn);

        Canvas canvas = new Canvas(500, 500);
        gc = canvas.getGraphicsContext2D();

        ox.getChildren().add(hox);
        ox.getChildren().add(canvas);
        primaryStage.setScene(new Scene(ox));
        primaryStage.show();
    }

    private HBox hawks() {
        HBox hox = new HBox();
        hox.setAlignment(Pos.CENTER);
        hox.setPadding(new Insets(10));
        hox.setSpacing(10);
        return hox;
    }

    private VBox ox() {
        VBox vox = new VBox();
        vox.setAlignment(Pos.CENTER);
        vox.setPadding(new Insets(10));
        vox.setSpacing(10);
        return vox;
    }

    private Button circleButton() {
        Button button = new Button();

        button.setPrefWidth(imgSize);
        button.setPrefHeight(imgSize);
        Image images = new Image("img/oval.png");
        ImageView imageView = new ImageView(images);
        imageView.setFitWidth(imgSize);
        imageView.setFitHeight(imgSize);
        button.setGraphic(imageView);

        button.setOnAction(event -> {
            drawCircle();
        });

        return button;
    }

    private Button triangleButton() {
        Button button = new Button();

        button.setPrefWidth(imgSize);
        button.setPrefHeight(imgSize);
        Image images = new Image("img/triangle.png");
        ImageView imageView = new ImageView(images);
        imageView.setFitWidth(imgSize);
        imageView.setFitHeight(imgSize);
        button.setGraphic(imageView);

        button.setOnAction(event -> {
            drawTriangle();
        });

        return button;
    }

    private Button rectangleButton() {
        Button button = new Button();

        button.setPrefWidth(imgSize);
        button.setPrefHeight(imgSize);
        Image images = new Image("img/rectangle.png");
        ImageView imageView = new ImageView(images);
        imageView.setFitWidth(imgSize);
        imageView.setFitHeight(imgSize);
        button.setGraphic(imageView);

        button.setOnAction(event -> {
            drawRectangle();
        });

        return button;
    }

    private Button lineButton() {
        Button button = new Button();

        button.setPrefWidth(imgSize);
        button.setPrefHeight(imgSize);
        Image images = new Image("img/line.png");
        ImageView imageView = new ImageView(images);
        imageView.setFitWidth(imgSize);
        imageView.setFitHeight(imgSize);
        button.setGraphic(imageView);

        button.setOnAction(event -> {
            drawLine();
        });

        return button;
    }

    private void drawCircle() { circleAdapter.drawShape(gc); }

    private void drawTriangle() { triangleAdapter.drawShape(gc); }

    private void drawRectangle() { rectangleAdapter.drawShape(gc); }

    private void drawLine() { lineAdapter.drawShape(gc); }
}
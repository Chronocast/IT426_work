package layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class PracticeWithLayouts extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Practicing with layouts");

        //stage.setScene(useGridPane());
        //stage.setScene(useStackPane());
        stage.setScene(useBorderPane());

        stage.show();
    }

    //GridPane - rows & columns
    public Scene useGridPane()
    {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));

        //create a 3 column layout
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        //create some controls
        RadioButton button1 = new RadioButton("Options 1");
        RadioButton button2 = new RadioButton("Options 2");
        RadioButton button3 = new RadioButton("Options 3");

        button1.setMaxWidth(90);
        button2.setMaxWidth(90);
        button3.setMaxWidth(90);

        ToggleGroup group = new ToggleGroup();
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);

        Button button = new Button("Please click here!!!");
        button.setPrefWidth(280);

        TextArea area = new TextArea();
        Text banner = new Text("Lots of interesting information located here...");
        banner.setWrappingWidth(80);
        banner.setTextAlignment(TextAlignment.CENTER);

        //arrange them
        grid.add(button1, 0, 0);
        grid.add(button2, 1, 0);
        grid.add(button3, 2, 0);

        grid.add(button, 0, 1, 3, 1);

        grid.add(area, 0, 2, 2, 1);
        grid.add(banner, 2, 2, 1, 1);

        return new Scene(grid, 300, 300);
    }

    //StackPane - place elements on top of each other
    public Scene useStackPane()
    {
        StackPane pane = new StackPane();

        //create a few controls
        Circle circle1 = new Circle(170);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(120);

        circle1.setFill(Color.ANTIQUEWHITE);
        circle2.setFill(Color.ALICEBLUE);
        circle3.setFill(Color.ORANGERED);

        //add controls to the layout
        pane.getChildren().addAll(circle1, circle2, circle3);

        //you can place complex controls over other controls
        Button button = new Button("Click me");
        pane.getChildren().add(button);

        //move elements on the stack pane
        StackPane.setAlignment(circle1, Pos.TOP_RIGHT);
        StackPane.setAlignment(circle2, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(circle3, Pos.BOTTOM_RIGHT);

        StackPane.setMargin(button, new Insets(0, 100, 0, 0));

        return new Scene(pane, 300, 300);
    }

    //BorderPane - place elements in regions - north, south, east, west and center
    public Scene useBorderPane() throws MalformedURLException {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        //north
        HBox northPanel = new HBox();
        northPanel.setAlignment(Pos.CENTER);
        northPanel.setSpacing(10);

        northPanel.getChildren().addAll(new Button("Please"),
                new Button("Click"), new Button("Here"), new Button("Now"),
                new Button("!"));

        pane.setTop(northPanel);


        //west
        VBox westPanel = new VBox();
        westPanel.setAlignment(Pos.CENTER);
        westPanel.setPadding(new Insets(10));
        westPanel.setSpacing(10);

        String[] choices = {"Blue", "Purple", "Pink", "Orange", "White"};
        CheckBox[] checkBoxes = new CheckBox[choices.length];
        for (int i = 0; i < choices.length; i++)
        {
            CheckBox chkBox = new CheckBox(choices[i]);
            westPanel.setAlignment(Pos.CENTER_LEFT);
            westPanel.setSpacing(10);

            checkBoxes[i] = chkBox;
            westPanel.getChildren().add(chkBox);
        }

        pane.setLeft(westPanel);

        //east
        VBox eastPanel = new VBox();
        eastPanel.setAlignment(Pos.CENTER);
        eastPanel.setSpacing(10);
        eastPanel.setPadding(new Insets(10));

        //display a list
        ObservableList<String> items = FXCollections.observableArrayList(
                "Videogames", "Reading", "Shooting", "Martial Arts", "Archery");
        ListView list = new ListView(items);
        list.setPrefWidth(100);

        eastPanel.getChildren().addAll(list);
        pane.setRight(eastPanel);

        //south
        Label lotsOfText = new Label("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset " +
                "sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like " +
                "Aldus PageMaker including versions of Lorem Ipsum.");
        lotsOfText.setWrapText(true);
        pane.setBottom(lotsOfText);

        //center
        Image image = new Image(new File("images/pattern.jpg")
                .toURI().toURL().toString());
        ImageView imageControl = new ImageView(image);

        //resize the view control
        imageControl.setFitHeight(300);
        imageControl.setFitWidth(300);

        pane.setCenter(imageControl);

        return new Scene(pane, 600, 600);
    }

    //others - FlowPane, TilePane, AnchorPane
}

package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import java.util.Random;

public class PracticeWithControls extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        //stage.setScene(createButtons());
        stage.setScene(createTextElements());
        stage.setTitle("Practicing with controls");
        stage.show();
    }

    //buttons
    public Scene createButtons()
    {
        //crating a new button
        Button button = new Button("Click me!");
        button.setPrefHeight(30);
        button.setPrefWidth(300);
        button.setAlignment(Pos.BOTTOM_RIGHT);

        //this is out layout for controls
        VBox box = new VBox();
        box.getChildren().add(button);

        //set the spacing with my layout
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(20));

        //assign an event handler
        Random random = new Random();
        button.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                button.setText("you clicked, here is a random #: " + random.nextInt(100));

            }
        });

        return new Scene(box, 500, 500);
    }

    //text elements - Text, Label, TextField, TextArea
    public Scene createTextElements()
    {
        VBox verticalStack = new VBox();
        verticalStack.setAlignment(Pos.CENTER);
        verticalStack.setPadding(new Insets(10));
        verticalStack.setSpacing(10);

        //add a banner using the Text class
        /*Text banner = TextBuilder.create()
                .text("Enter information")
                .font(Font.font("Vani", FontWeight.BOLD, 30))
                .underline(true).build();*/

        Text banner = new Text();
        banner.setText("Enter information");
        banner.setFont(Font.font("Vani", FontWeight.BOLD, 30));
        banner.setUnderline(true);

        verticalStack.getChildren().add(banner);

        //lets add a few label/entry fields
        Label nameLabel = new Label("Name: ");
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setPrefWidth(50);

        TextField nameEntry = new TextField();
        nameEntry.setPrefWidth(200);

        //group together my controls and add them to a parent layout
        HBox horizontalStack = new HBox();
        horizontalStack.setAlignment(Pos.CENTER);
        horizontalStack.getChildren().addAll(nameLabel, nameEntry);
        verticalStack.getChildren().add(horizontalStack);

        //lets add a few label/entry fields
        Label bioLabel = new Label("Bio: ");
        bioLabel.setAlignment(Pos.CENTER_LEFT);
        bioLabel.setPrefWidth(50);

        TextArea bioEntry = new TextArea();
        bioEntry.setPrefWidth(200);
        bioEntry.setWrapText(true);

        //group together my controls and add them to a parent layout
        horizontalStack = new HBox();
        horizontalStack.setAlignment(Pos.CENTER);
        horizontalStack.getChildren().addAll(bioLabel, bioEntry);
        verticalStack.getChildren().add(horizontalStack);

        return new Scene(verticalStack, 500, 500);
    }

    //checkboxes, radio buttons
    public Scene createOptionalElements()
    {
        return null;
    }

    //display images?
    public Scene createOrShowImages()
    {
        return null;
    }

    //lists - dropdown lists (ComboBox)m, ListView
    public Scene createLists()
    {
        return null;
    }

    //dialog boxes - Color picker, date picker
    public Scene createDialogs()
    {
        return null;
    }
}

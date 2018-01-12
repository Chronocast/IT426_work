package scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.util.Duration;

public class StoryBook extends Application
{
    public static final int PADDING = 10;
    public static final int SPACING = 10;
    //save our stage
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Working with scenes!");
        stage.setScene(getWaitingScene());
        stage.show();

        //we are going to wait on the current screen using
        //animation (key frame)
        KeyFrame frame = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>()
        {
            private String name;

            @Override
            public void handle(ActionEvent event)
            {
                stage.setScene(getStorySceneOne());
            }
        });

        Timeline waitAnimation = new Timeline(frame);
        waitAnimation.play();
    }

    private Scene getWaitingScene()
    {
        //create a layout
        VBox waitingLayout = new VBox();

        //center child elements of the layout
        waitingLayout.setAlignment(Pos.CENTER);

        //space between child elements and edge of layout
        waitingLayout.setPadding(new Insets(PADDING));

        //space between child elements
        waitingLayout.setSpacing(SPACING);

        //add a few elements
        ProgressIndicator progressIndicator = new ProgressIndicator();
        Text waitingMessage = new Text("PLEASE WAIT...");
        waitingMessage.setFont(Font.font("Ariel Black", FontWeight.BOLD, 30));

        waitingLayout.getChildren().add(progressIndicator);
        waitingLayout.getChildren().add(waitingMessage);

        return new Scene(waitingLayout, 500, 500);
    }

    private Scene getStorySceneOne()
    {
        //create a layout with spacing
        VBox sceneOneLayout = new VBox();
        sceneOneLayout.setAlignment(Pos.CENTER);
        sceneOneLayout.setPadding(new Insets(PADDING));
        sceneOneLayout.setSpacing(SPACING);

        //add controls
        Text message = new Text("Smaug was picking flowers");
        message.setFont(Font.font("Fantasy", FontWeight.MEDIUM, 20));


        Button acknowledged = new Button("Acknowledged HQ");
        acknowledged.setMaxHeight(50);
        acknowledged.setMaxWidth(300);


        acknowledged.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

            }
        });

        sceneOneLayout.getChildren().add(message);
        sceneOneLayout.getChildren().add(acknowledged);

        return new Scene(sceneOneLayout, 500, 500);
    }
}

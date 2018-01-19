package image_viewer;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class ImageViewerLayout extends Application
{

    public void start(Stage stage) throws Exception
    {

        stage.setScene(imageViewer());
        stage.setTitle("Animal Image Viewer");
        stage.show();
    }

    public Scene imageViewer() throws MalformedURLException {
        VBox vox = new VBox();

        vox.setAlignment(Pos.CENTER);
        vox.setPadding(new Insets(10));

        Image image = new Image(new File("images/bear.jpg").toURI().toURL().toString());
        final ImageView myImageView = new ImageView(image);
        myImageView.setFitWidth(380);
        myImageView.setFitHeight(350);

        HBox hawks = new HBox();

        hawks.setAlignment(Pos.CENTER);
        hawks.setPadding(new Insets(10));
        hawks.setSpacing(10);

        String[] animals = {"bear", "cat", "owl", "parrot"};
        RadioButton[] radioButtonGroup = new RadioButton[animals.length];
        ToggleGroup radioGroup = new ToggleGroup();

        for(int i =0; i < animals.length; i++)
        {
            RadioButton radioButton = new RadioButton(animals[i]);
            radioButton.setFont(Font.font("Ariel", FontWeight.NORMAL, 20));

            radioButtonGroup[i] = radioButton;

            radioButton.setToggleGroup(radioGroup);

            hawks.getChildren().add(radioButton);
        }

        for(int i = 0; i < radioButtonGroup.length; i++)
        {
            final RadioButton radioButton = radioButtonGroup[i];

            radioButton.selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean newValue) {
                    try {

                        Image newImage = new Image(new File("images/" + radioButton.getText() + ".jpg")
                                .toURI().toURL().toString(), true);

                        myImageView.setImage(newImage);
                        myImageView.setFitWidth(380);
                        myImageView.setFitHeight(350);


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        }



        //put hawks in vox
        vox.getChildren().add(hawks);
        vox.getChildren().add(myImageView);

        return new Scene(vox, 400,420);
    }




}

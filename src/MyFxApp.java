
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.scene.web.WebView;
public class MyFxApp extends Application  {
    double barStatus = 0.1;
    @Override
    public void start(Stage primaryStage)


            throws Exception {

        primaryStage.setTitle("HBox Experiment 1");

        Button button1 = new Button("Add Progress");
        Button button2 = new Button("Subtract Progress");

        Text text = new Text("This is a JavaFX text.");

        ProgressBar progressBar = new ProgressBar(0);
        Label label = new Label("My Label Jawn - Progress Bar");


        progressBar.setProgress(barStatus);

        button1.setOnAction(actionEvent -> {
            barStatus = barStatus + 0.1;
            progressBar.setProgress(barStatus);


        });

        button2.setOnAction(actionEvent -> {
            barStatus = barStatus - 0.1;
            progressBar.setProgress(barStatus);
        });

        MenuItem menuItem1 = new MenuItem("Jawn 1");
        MenuItem menuItem2 = new MenuItem("Jawn 2");
        MenuItem menuItem3 = new MenuItem("Jawn 3");

        MenuButton menuButton = new MenuButton("Pick a jawn", null, menuItem1, menuItem2, menuItem3);


        CheckBox checkBox1 = new CheckBox("Green");
        RadioButton radioButton1 = new RadioButton("Left");
        //    TextArea textArea = new TextArea();
       // TextField textField = new TextField();
        Text text2 = new Text("Change Progress Bar Color: ");
        Button button3 = new Button("Confirm Color Change");

        ColorPicker colorPicker = new ColorPicker();


        button3.setOnAction(actionEvent -> {
            Color value = colorPicker.getValue();
            String colorValue = value.toString();
            String newColor = colorValue.substring(2);
            progressBar.setStyle("-fx-accent:" + "#" +newColor);
        });


        FileInputStream input = new FileInputStream("Images/WeUpBoys!!!!!!.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(350);


        HBox hbox = new HBox(button1, button2);
        VBox h2box = new VBox(radioButton1,text2,colorPicker,button3,checkBox1);

        VBox Vbox1 = new VBox(text,label, progressBar,hbox,h2box,imageView);


        Scene scene = new Scene(Vbox1, 500, 400);




        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;

public class MyFxApp extends Application  {
    int imageROll = 0;
    int height = 100;
    int width = 100;
    String Meme;
    String FontString = "arial";
    @Override
    public void start(Stage primaryStage)


            throws Exception {

        primaryStage.setTitle("HBox Experiment 1");

        Text texthe = new Text("Width");
        TextField textFieldHeight = new TextField();
        Text textwe = new Text("Height");
        TextField textFieldWidth = new TextField();

        Text textMeme = new Text("Enter Meme");
        TextField textFieldMeme = new TextField();



        Button button1 = new Button("Next Image ");
        Button button2 = new Button("Previous Image");
        Button button3 = new Button("Save Width And Height");
        Button button4 = new Button("Save Meme");

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("arial");
        choiceBox.getItems().add("Comic sans MS");
        choiceBox.getItems().add("Times New Roman");




        Text text = new Text("To change image height and width, enter values like 200, default is 100");


        ArrayList<Object> ImagesList = new ArrayList<>();

        ImagesList.add("Images/WeUpBoys!!!!!!.png");
        ImagesList.add("Images/graph.png");
        ImagesList.add("Images/survey.png");
        ImagesList.add("Images/setting.png");
        ImagesList.add("Images/calendar.png");



        choiceBox.setOnAction((event) -> {
            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            FontString = selectedItem.toString();


        });






        button4.setOnAction(action -> {
            Meme = textFieldMeme.getText();


            Object imageFromList = ImagesList.get(imageROll);
            String newImageString = imageFromList.toString();
            FileInputStream input = null;
            try {
                input = new FileInputStream(newImageString);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);


            savenewWindow(imageView, height, width, button1,button2,button3,texthe,textFieldHeight,textwe,textFieldWidth,text,textMeme,textFieldMeme,primaryStage,button4,choiceBox);

        });









        button3.setOnAction(action -> {
            String newHE = textFieldHeight.getText();
            String newWI = textFieldWidth.getText();
            height = Integer.parseInt(newWI);
            width = Integer.parseInt(newHE);

            Object imageFromList = ImagesList.get(imageROll);
            String newImageString = imageFromList.toString();
            FileInputStream input = null;
            try {
                input = new FileInputStream(newImageString);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);


            savenewWindow(imageView, height, width, button1,button2,button3,texthe,textFieldHeight,textwe,textFieldWidth,text,textMeme,textFieldMeme,primaryStage,button4,choiceBox);

        });


        button2.setOnAction(actionEvent -> {
            imageROll = imageROll - 1;
            FileInputStream input = null;
            try {
                Object imageFromList = ImagesList.get(imageROll);

                String newImageString = imageFromList.toString();
                input = new FileInputStream(newImageString);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            savenewWindow(imageView, height, width, button1,button2,button3,texthe,textFieldHeight,textwe,textFieldWidth,text,textMeme,textFieldMeme,primaryStage,button4,choiceBox);

        });


        button1.setOnAction(actionEvent -> {
            imageROll = imageROll +1;
            FileInputStream input = null;
            try {
                Object imageFromList = ImagesList.get(imageROll);
                String newImageString = imageFromList.toString();
                input = new FileInputStream(newImageString);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            savenewWindow(imageView, height, width, button1,button2,button3,texthe,textFieldHeight,textwe,textFieldWidth,text,textMeme,textFieldMeme,primaryStage,button4,choiceBox);


        });



        Object imageFromList = ImagesList.get(imageROll);
        String newImageString = imageFromList.toString();
        FileInputStream input = new FileInputStream(newImageString);
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


        savenewWindow(imageView, height, width, button1,button2,button3,texthe,textFieldHeight,textwe,textFieldWidth,text,textMeme,textFieldMeme,primaryStage,button4,choiceBox);

    }


    public void  savenewWindow
            (ImageView imageView,
             int height,
             int width,
             Button button1,
             Button button2,
             Button button3,
             Text texthe,
             TextField textFieldHeight,
             Text textwe,
             TextField textFieldWidth,
             Text text,
             Text textMeme,
             TextField textFieldMeme,
             Stage primaryStage,
             Button button4,
             ChoiceBox choiceBox
            )  {

        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

       System.out.println(Meme);
        Label label = new Label(Meme);

        label.setFont(Font.font (FontString, 20));

        HBox hbox = new HBox(button1, button2,button3);
        HBox hbox1 = new HBox(texthe, textFieldHeight);
        HBox hbox2 = new HBox(textwe, textFieldWidth);
        HBox hbox3 = new HBox(textMeme, textFieldMeme, button4,choiceBox);

        Text ImagerollJawn = new Text("Image: "+imageROll +"/4");

        StackPane stack_pane = new StackPane(imageView, label);


        try {

        FileInputStream input = new FileInputStream("Images/graph.png");
        Image image = new Image(input);

        FileInputStream input2 = new FileInputStream("Images/survey.png");
        Image image2 = new Image(input2);

        ScrollPane scrollPane = new ScrollPane();
         ImageView mainImageView = new ImageView(image);
         ImageView bgImageView = new ImageView(image2);
            mainImageView.setFitHeight(100);
            mainImageView.setFitWidth(300);
            bgImageView.setFitHeight(200);
            bgImageView.setFitWidth(300);



            FlowPane imagePane = new FlowPane();
            imagePane.getChildren().addAll(bgImageView, mainImageView);
            scrollPane.setContent(imagePane);
            scrollPane.setPrefSize(400, 400);


        HBox hboxImageScroll = new HBox(scrollPane);
        VBox Vbox1 = new VBox(text, ImagerollJawn, hbox, hbox1, hbox2,hbox3, stack_pane,hboxImageScroll);
        Scene scene = new Scene(Vbox1, 550, 450);
        scene.getStylesheets().add("Style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}

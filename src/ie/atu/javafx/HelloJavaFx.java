package ie.atu.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloJavaFx extends Application {
    // Constants for literals
    private static final String TITLE = "Hello World!";
    private static final String BUTTON_TEXT = "Say 'Hello World'";
    private static final String OUTPUT_TEXT = "Hello World!";
    private static final int SCENE_WIDTH = 300;
    private static final int SCENE_HEIGHT = 250;

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle(TITLE);

        // Create a new button and set the text on it
        Button btn = new Button();
        btn.setText(BUTTON_TEXT);

        // Set the action to perform when the button is clicked
        btn.setOnAction(event -> System.out.println(OUTPUT_TEXT));

        // Create a new StackPane and add the button to it
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Set the scene on the primaryStage and show it
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.show();
    }

    // Main method
    public static void main(String[] args) {
		launch(args);
	} // End Main
}
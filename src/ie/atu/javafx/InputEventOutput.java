package ie.atu.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InputEventOutput extends Application {
	// Constants for literals
	private static final String TITLE = "Say Hello to Someone";
	private static final String LABEL_TEXT = "Enter a name in the text box below then press the button to say hello!";
	private static final String PROMPT_TEXT = "Enter your name here";
	private static final String BUTTON_TEXT = "Say Hello Button";
	private static final String DEFAULT_OUTPUT = "Hello to nobody!";
	private static final int SCENE_WIDTH = 470;
	private static final int SCENE_HEIGHT = 200;

	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		Label labelHello = new Label(LABEL_TEXT);
		labelHello.setTextFill(Color.RED);
		Button buttonHello = new Button(BUTTON_TEXT);
		// Create a text file for the user to enter their name
		TextField inputTextBox = new TextField();
		// Set the prompt text to appear in the text box. This is a hint to the user.
		// Display prompty text when the txt box has the blinking cursor and no text
		inputTextBox.setPromptText(PROMPT_TEXT);
		// Create a text box area just for output
		TextField outputTextBox = new TextField();
		outputTextBox.setEditable(false);
		// set the colour fill of the text box to light grey
		outputTextBox.setStyle("-fx-background-color: lightgrey;");

		// If the button is pressed take the input text and display it in the output
		// text box
		buttonHello.setOnAction(event -> {
			String inputText = inputTextBox.getText();
			// If the input text is empty then display the default output.
			// The ? : is a ternary operator. It is a shorthand for an if-else statement.
			outputTextBox.setText(inputText.isEmpty() ? DEFAULT_OUTPUT : "Hello " + inputText + "!");
		});

		// Add the nodes to the GridPane.
		root.add(labelHello, 0, 0); // Column 0, Row 0
		root.add(inputTextBox, 0, 1); // Column 0, Row 1
		root.add(buttonHello, 0, 2); // Column 0, Row 2
		root.add(outputTextBox, 0, 3); // Column 0, Row 3

		// Create Scene and set it then show Stage
		Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// Launch the application
		launch(args);
	}
} // End Class
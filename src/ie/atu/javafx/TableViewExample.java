package ie.atu.javafx;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableViewExample extends Application {
    // Constants for literals
    private static final String STAGE_TITLE = "Student Table";
    private static final String NAME_COLUMN_TITLE = "Name";
    private static final String ID_COLUMN_TITLE = "ID";
    private static final int SCENE_WIDTH = 300;
    private static final int SCENE_HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {
        // Create a TableView
        TableView<Student> tableView = new TableView<>();

        // Create a TableColumn for the IDs of the students
        TableColumn<Student, Integer> idColumn = new TableColumn<>(ID_COLUMN_TITLE);
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());

        // Create a TableColumn for the names of the students
        TableColumn<Student, String> nameColumn = new TableColumn<>(NAME_COLUMN_TITLE);
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
       
        // Create a TableColumn for the ages of the students
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()).asObject());

        // Add the columns to the TableView
        tableView.getColumns().addAll(idColumn, nameColumn, ageColumn);

        // Create a list of Student objects
        List<Student> students = Arrays.asList(
                new Student("John", 12345, 20),
                new Student("Jane", 54321, 21));

        // Set the items of the TableView to the list of students
        tableView.setItems(FXCollections.observableArrayList(students));

        // Display the TableView
        stage.setTitle(STAGE_TITLE);
        stage.setScene(new Scene(tableView, SCENE_WIDTH, SCENE_HEIGHT));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
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

    @Override
    public void start(Stage stage) throws Exception {
        // Create a TableView
        TableView<Student> tableView = new TableView<>();

        // Create a TableColumn for each field of the Student object
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());

        // Add the columns to the TableView
        tableView.getColumns().addAll(nameColumn, idColumn);

        // Create a list of Student objects
        List<Student> students = Arrays.asList(
                new Student("John Doe", 12345),
                new Student("Jane Doe", 54321));

        // Set the items of the TableView to the list of students
        tableView.setItems(FXCollections.observableArrayList(students));

        // Display the TableView
        stage.setScene(new Scene(tableView));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
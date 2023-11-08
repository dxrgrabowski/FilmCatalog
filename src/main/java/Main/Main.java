package Main;

import Controller.FilmController;
import Model.Film;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.CycleMethod;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.StageStyle;

/**
 * The Main class is the entry point of the Film Catalog application.
 *
 * @author Dawid
 * @version 1.0
 */
public class Main extends Application {

    private TableView<Film> filmTable;
    private TextArea outputTextArea;
    private TextArea filmTextArea;
    private TextField searchField;
    private TextField addFilmField;
    private Button searchButton;
    private Button addButton;
    private Button exitButton;

    private static FilmController filmController;

    public static void main(String[] args) {

        filmController = new FilmController();
        //filmController.runApplication(args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Film Catalog");

        HBox topPanel = new HBox();
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setSpacing(20);
        topPanel.setStyle("-fx-background-color: #1f1f1f; -fx-padding: 10px;");

        addFilmField = new TextField();
        addFilmField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");

        searchField = new TextField();
        searchField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        searchButton.setOnAction(e -> handleSearch());

        addButton = new Button("Add Film");
        addButton.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: #ffffff;");
        addButton.setOnAction(e -> addFilm());

        exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        exitButton.setOnAction(e -> primaryStage.close());

        topPanel.getChildren().addAll(addFilmField, addButton, searchField, searchButton, exitButton);

        HBox bottomPanel = new HBox();
        bottomPanel.setSpacing(10);

        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setStyle("-fx-background-color: #333; -fx-text-fill: #363636;");
        outputTextArea.setPrefWidth(600); // Ustaw preferowaną szerokość dla pola tekstowego

        TableColumn<Film, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Film, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        TableColumn<Film, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));

        TableColumn<Film, Double> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));


        filmTable = new TableView<>();
        filmTable.getColumns().addAll(titleColumn, yearColumn, directorColumn, ratingColumn);
        filmTable.setStyle("-fx-background-color: #333; -fx-text-fill: #363636;");
        filmTable.setPrefWidth(600);

        bottomPanel.getChildren().addAll(outputTextArea, filmTable);

        BorderPane root = new BorderPane();
        root.setTop(topPanel);
        root.setCenter(bottomPanel); // Używamy bottomPanel jako dolnej części BorderPane

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addFilm() {
        String input = addFilmField.getText().trim();

        if (!input.isEmpty()) {
            Film newFilm = filmController.addFilm(input);
            if (newFilm != null) {
                filmTable.getItems().add(newFilm);
                displayMessage("Film added successfully: " + input);
            } else {
                displayMessage("Failed to add the film. Please enter all film attributes.");
            }
        } else {
            displayMessage("Please enter a film title.");
        }

        addFilmField.clear();
    }




    private void viewFilmCatalog() {
        // Implement viewing film catalog logic here
        displayMessage("View Film Catalog option selected.");
    }

    private void handleSearch() {
        // Implement searching by title logic here
        displayMessage("Search by option selected.");
    }

    private void displayMessage(String message) {
        outputTextArea.appendText(message + "\n");
    }


}

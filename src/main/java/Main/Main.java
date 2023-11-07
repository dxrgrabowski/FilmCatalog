package Main;

import Controller.FilmController;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TextArea outputTextArea;
    private TextField searchField;
    private Button searchButton;
    private Button addButton;
    private Button exitButton;

    public static void main(String[] args) {

        FilmController filmController = new FilmController();
        filmController.runApplication(args);
        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Film Catalog");

        HBox topPanel = new HBox();
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setSpacing(20);
        topPanel.setStyle("-fx-background-color: #1f1f1f; -fx-padding: 10px;");

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

        topPanel.getChildren().addAll(addButton, searchField, searchButton, exitButton);

        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setStyle("-fx-background-color: #333; -fx-text-fill: #363636;");

        BorderPane root = new BorderPane();
        root.setTop(topPanel);
        root.setCenter(outputTextArea);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void addFilm() {
        // Implement adding a film logic here
        displayMessage("Add a Film option selected.");
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

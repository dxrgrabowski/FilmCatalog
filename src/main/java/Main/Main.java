package Main;

import Controller.FilmController;
import Controller.Gui;
import Model.Film;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.CycleMethod;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * The Main class is the entry point of the Film Catalog application.
 *
 * @author Dawid
 * @version 1.0
 */
public class Main extends Application {

    private static Gui gui;

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) {
        gui = new Gui(primaryStage);
        gui.initialize();
    }

//    private void addFilm() {
//        String input = addFilmField.getText().trim();
//
//        if (!input.isEmpty()) {
//            Film newFilm = filmController.addFilm(input);
//            if (newFilm != null) {
//                filmTable.getItems().add(newFilm);
//                displayMessage("Film added successfully: " + input);
//            } else {
//                displayMessage("Failed to add the film. Please enter all film attributes.");
//            }
//        } else {
//            displayMessage("Please enter a film title.");
//        }
//
//        addFilmField.clear();
//    }




    private void viewFilmCatalog() {
        // Implement viewing film catalog logic here
        displayMessage("View Film Catalog option selected.");
    }

    private void handleSearch() {
        // Implement searching by title logic here
        displayMessage("Search by option selected.");
    }

    private void displayMessage(String message) {
        //outputTextArea.appendText(message + "\n");
    }


}

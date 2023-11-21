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

}

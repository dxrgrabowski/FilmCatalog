package Controller;

import Model.Film;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.net.URI;

public class Gui {
    private Stage primaryStage;
    private TextField titleField;
    private TextField yearField;
    private TextField directorField;
    private TextField ratingField;
    private Button addButton;
    private Button searchButton;
    private TextArea outputTextArea;
    private TableView<Film> filmTable;

    private boolean errorAlertShown;

    public Gui(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    // constructor for tests
    public Gui() {};
    public void initialize() {

        primaryStage.setTitle("Film Catalog");

        Scene secondScene = createSecondScene();
        Scene firstScene = createFirstScene(secondScene);

        primaryStage.setScene(firstScene);
        primaryStage.show();

    }

    public Scene createFirstScene(Scene secondScene) {
        Label filmcatLabel = new Label("FILMCAT");
        Font customFont = Font.font("Open Sans", FontWeight.BOLD, 150);
        filmcatLabel.setFont(customFont);
        filmcatLabel.setTextFill(Color.WHITE);
        filmcatLabel.setTextAlignment(TextAlignment.CENTER);

        Label madeByLabel = new Label("made by");
        Font customFont2 = Font.font("Open Sans", FontWeight.THIN, 20);
        madeByLabel.setFont(customFont2);
        madeByLabel.setTextFill(Color.WHITE);
        madeByLabel.setTextAlignment(TextAlignment.CENTER);

        Label author = new Label("Dawid Grabowski");
        Font customFontAuthor = Font.font("Open Sans", FontWeight.THIN, 40);
        author.setFont(customFontAuthor);
        author.setTextFill(Color.WHITE);
        author.setTextAlignment(TextAlignment.CENTER);



        Label arrowLabel = new Label(">>>");
        arrowLabel.setFont(customFont);
        arrowLabel.setTextFill(Color.WHITE);

        StackPane.setMargin(author, new javafx.geometry.Insets(-10, 0, 50, 0));
        StackPane.setMargin(madeByLabel, new javafx.geometry.Insets(-90, 0, 50, 0));
        StackPane.setMargin(filmcatLabel, new javafx.geometry.Insets(-240, 0, 50, 0));

        StackPane.setMargin(arrowLabel, new javafx.geometry.Insets(350, 0, 0, 0));

        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), arrowLabel);
        transition.setByX(100);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.play();

        Image githubImage = new Image("https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/github-512.png");
        ImageView githubImageView = new ImageView(githubImage);
        githubImageView.setFitWidth(50);
        githubImageView.setPreserveRatio(true);
        StackPane.setAlignment(githubImageView, Pos.BOTTOM_LEFT);
        StackPane.setMargin(githubImageView, new javafx.geometry.Insets(50, 50, 50, 50));

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");
        root.getChildren().addAll(filmcatLabel, author, madeByLabel, arrowLabel, githubImageView);

        Scene firstScene = new Scene(root, 1600, 900);

        firstScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                transition.stop();
                handleSecondSceneJump(firstScene, secondScene);
            }
        });

        arrowLabel.setOnMouseClicked(event -> {
            transition.stop();
            handleSecondSceneJump(firstScene, secondScene);
        });

        githubImageView.setOnMouseClicked(event -> {
            try {

                Desktop.getDesktop().browse(new URI("https://github.com/dxrgrabowski"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return firstScene;
    }

    private void handleSecondSceneJump(Scene firstScene, Scene secondScene) {

        TranslateTransition transitionScene1 = new TranslateTransition(Duration.seconds(1), firstScene.getRoot());
        transitionScene1.setToX(-1600); // Przesunięcie sceny pierwszej w lewo
        transitionScene1.play();

        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(0.5), secondScene.getRoot());
        fadeInTransition.setFromValue(0);
        fadeInTransition.setToValue(1);// Zwiększenie przezroczystości sceny drugiej

        transitionScene1.setOnFinished(e -> {
            primaryStage.setScene(secondScene);
            fadeInTransition.play();
        });
    }

    public Scene createSecondScene() {

        HBox topPanel = new HBox();
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setSpacing(20);
        topPanel.setStyle("-fx-background-color: #1f1f1f; -fx-padding: 10px;");

        titleField = new TextField("");
        titleField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        titleField.setPromptText("Title *"); // Ustawienie podpowiedzi (Tooltip)
        Tooltip titleTooltip = new Tooltip("Enter the film's title (mandatory)");
        titleField.setTooltip(titleTooltip);

        yearField = new TextField("");
        yearField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        yearField.setPromptText("Year");
        Tooltip yearTooltip = new Tooltip("Enter the film's release year");
        yearField.setTooltip(yearTooltip);

        directorField = new TextField("");
        directorField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        directorField.setPromptText("Director");
        Tooltip directorTooltip = new Tooltip("Enter the film's director");
        directorField.setTooltip(directorTooltip);

        ratingField = new TextField("");
        ratingField.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
        ratingField.setPromptText("Rating");
        Tooltip ratingTooltip = new Tooltip("Enter the film's rating (0-10)");
        ratingField.setTooltip(ratingTooltip);

        addButton = new Button("Add Film");
        addButton.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: #ffffff;");
        addButton.setOnAction(e -> addFilm());
        addButton.setMnemonicParsing(true);
        addButton.setText("_Add Film");
        Tooltip addButtonTooltip = new Tooltip("Click to add a new film");
        addButton.setTooltip(addButtonTooltip);

//        searchButton = new Button("Search");
//        searchButton.setStyle("-fx-background-color: #4d4d4d; -fx-text-fill: white;");
//        searchButton.setOnAction(e -> handleSearch());
//        searchButton.setMnemonicParsing(true);
//        searchButton.setText("_Search");
//        Tooltip searchButtonTooltip = new Tooltip("Click to search films");
//        searchButton.setTooltip(searchButtonTooltip);

        topPanel.getChildren().addAll(titleField, yearField, directorField, ratingField, addButton);

        HBox bottomPanel = new HBox();
        bottomPanel.setSpacing(10);

        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setStyle("-fx-background-color: #333; -fx-text-fill: #363636;");
        outputTextArea.setPrefWidth(600);

        TableColumn<Film, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setPrefWidth(500);

        TableColumn<Film, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        yearColumn.setPrefWidth(150);

        TableColumn<Film, String> directorColumn = new TableColumn<>("Director");
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        directorColumn.setPrefWidth(250);

        TableColumn<Film, Double> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        ratingColumn.setPrefWidth(100);


        filmTable = new TableView<>();
        filmTable.getColumns().addAll(titleColumn, yearColumn, directorColumn, ratingColumn);
        filmTable.setStyle("-fx-background-color: #333; -fx-text-fill: #363636;");


        bottomPanel.getChildren().addAll(outputTextArea, filmTable);

        BorderPane root2 = new BorderPane();
        root2.setTop(topPanel);
        root2.setCenter(bottomPanel);

        Scene scene2 = new Scene(root2, 1600, 900);
        root2.setOpacity(0);
        return scene2;
    }



    public void addFilm() {
        String title = titleField.getText();
        String yearText = yearField.getText();
        String director = directorField.getText();
        String ratingText = ratingField.getText();


        if (title.isEmpty()) {
            showAlert("Error", "Pole tytułu nie może być puste!", Alert.AlertType.ERROR);
            return;
        }

        int year = 0;
        if (!yearText.isEmpty()) {
            try {
                year = Integer.parseInt(yearText);
                if (year < 0) {
                    showAlert("Error", "Nieprawidłowy rok!", Alert.AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Nieprawidłowy format roku!", Alert.AlertType.ERROR);
                return;
            }
        }

        double rating = 0;
        if (!ratingText.isEmpty()) {
            try {
                rating = Double.parseDouble(ratingText);
                // Sprawdzenie, czy ocena mieści się w odpowiednim zakresie
                if (rating < 0 || rating > 10) {
                    showAlert("Error", "Ocena powinna być między 0 a 10!", Alert.AlertType.ERROR);
                    return;
                }
            } catch (NumberFormatException e) {
                // Obsługa błędu - nieprawidłowy format oceny
                showAlert("Error", "Nieprawidłowy format oceny!", Alert.AlertType.ERROR);
                return;
            }
        }

        // Utworzenie nowego obiektu Film na podstawie wprowadzonych danych
        Film newFilm = new Film(title, year, director, rating);

        // Dodanie nowego obiektu Film do tabeli
        filmTable.getItems().add(newFilm);

        // Czyszczenie pól tekstowych po dodaniu filmu
        titleField.clear();
        yearField.clear();
        directorField.clear();
        ratingField.clear();
    }


    public void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setOnCloseRequest(event -> {
            errorAlertShown = false;
        });
        alert.showAndWait();
        errorAlertShown = true;
    }

    public boolean isErrorAlertShown() {
        return errorAlertShown;
    }

    public int getFilmTableSize() {
        if (filmTable != null && filmTable.getItems() != null) {
            return filmTable.getItems().size();
        } else {
            return 0;
        }
    }
}
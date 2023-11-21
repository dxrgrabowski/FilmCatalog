/**
 *
 * @author Dawid
 */
import Model.Film;
import Controller.Gui;
import View.FilmView;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test methods for the FilmController class, focusing on adding films with different input scenarios.
 */
public class UserInputTest {
    private Gui gui;

    private TextField titleField;
    private TextField yearField;
    private TextField directorField;
    private TextField ratingField;

    @BeforeEach
    public void setUp() throws Exception {

        gui = new Gui();


    }

    public void testAddFilm() {
        // Ustawienie danych w polach tekstowych
        titleField.setText("Film testowy");
        yearField.setText("2023");
        directorField.setText("Reżyser testowy");
        ratingField.setText("8.5");

        // Wywołanie metody addFilm()
        gui.addFilm();

        // Sprawdzenie, czy lista filmów w Gui zawiera dodany film
        assertEquals(1, gui.getFilmTableSize());
        // Możesz również przetestować czy pola tekstowe zostały wyczyszczone po dodaniu filmu
        assertTrue(titleField.getText().isEmpty());
        assertTrue(yearField.getText().isEmpty());
        assertTrue(directorField.getText().isEmpty());
        assertTrue(ratingField.getText().isEmpty());
    }

    @Test
    public void testIsErrorAlertShown() {
        // Tutaj możesz przetestować zachowanie metody isErrorAlertShown()
        // na przykład w zależności od wyświetlania alertu o błędzie
        assertFalse(gui.isErrorAlertShown());

        // Symulacja wyświetlenia alertu o błędzie
        gui.showAlert("Error", "Testowy komunikat błędu", Alert.AlertType.ERROR);

        assertTrue(gui.isErrorAlertShown());
    }
}

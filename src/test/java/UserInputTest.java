/**
 *
 * @author Dawid
 */
import Model.Film;
import Controller.FilmController;
import View.FilmView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains test methods for the FilmController class, focusing on adding films with different input scenarios.
 */
public class UserInputTest {
    private FilmController filmController;

    /**
     * Sets up the test environment before each test method is executed.
     */
    @BeforeEach
    public void setUp() {
        filmController = new FilmController();
    }

    /**
     * Test method for adding a film to the film catalog under various input conditions.
     */
    @Test
    public void testAddFilm() {
        // Given
        FilmViewMock filmViewMock = new FilmViewMock("Film1", "2020", "Director1", "8.5");
        filmController.setFilmView(filmViewMock);

        // When
        filmController.addFilm();

        // Then
        assertEquals(1, filmController.getFilmCatalog().size());
        Film addedFilm = filmController.getFilmCatalog().get(0);
        assertEquals("Film1", addedFilm.getTitle());
        assertEquals(2020, addedFilm.getReleaseYear());
        assertEquals("Director1", addedFilm.getDirector());
        assertEquals(8.5, addedFilm.getRating(), 0.01);
    }

    /**
     * Test method for adding a film with different parameters, using parameterized testing.
     *
     * @param title       The title of the film.
     * @param releaseYear The release year of the film.
     * @param director    The director of the film.
     * @param rating      The rating of the film.
     */
    @ParameterizedTest
    @CsvSource({
            "Film1, 2020, Director1, 8.5",
            "Film2, 2019, Director2, 7.8",
            "Film3, 2021, Director3, 9.0",
            "InvalidTitle, 2022, Director4, 8.0",       // Invalid title
            "Film5, InvalidYear, Director5, 8.0",       // Invalid year
            "Film6, 2023, Director6, InvalidRating",    // Invalid rating
            ", 2024, Director7, 9.5",                   // Empty title
            "Film8, 2025, , 7.5",                       // Empty director
            "Film9, 2026, Director9, InvalidRating2",   // Invalid rating
            "Film10, 2027, Director10, 11.5",           // Invalid rating
            "Film11, 2028, Director11, -1.0",           // Invalid rating
            "Film12, 2029, Director12, ,",              // Empty rating
            "Film13, 2030, ,",                          // Empty director and rating
            ", InvalidYear2, Director14, 8.5",          // Invalid year
            ", 2031, Director15, InvalidRating3",       // Invalid rating
            "Film16, 2032, , 8.0",                      // Empty director
            ", , , ",                                   // All fields empty
            "Film18, , , ",                             // Only title provided
            "Film19, , Director19, ",                   // Only title and director provided
            ", 2033, , 8.5",                            // Only year provided
            "Film21, 2034, Director21, ",               // Only year and director provided
            "Film22, 2035, , 9.0",                      // Only year and rating provided
            "Film23, , Director23, 9.0",                // Only director and rating provided
            ", , Director24, 9.5"                       // Only rating provided
    })
    public void testAddFilmParameterized(String title, String releaseYear, String director, String rating) {
        // Given
        FilmViewMock filmViewMock = new FilmViewMock(title, releaseYear, director, rating);
        filmController.setFilmView(filmViewMock);

        // When
        filmController.addFilm();

        // Then
        assertEquals(1, filmController.getFilmCatalog().size());

        if (title != null && releaseYear != null && director != null && rating != null) {
            Film addedFilm = filmController.getFilmCatalog().get(0);
            assertEquals(title, addedFilm.getTitle());
            try {
                int expectedReleaseYear = releaseYear.isEmpty() ? 0 : Integer.parseInt(releaseYear);
                assertEquals(expectedReleaseYear, addedFilm.getReleaseYear());
            } catch (NumberFormatException e) {
                assertEquals(0, addedFilm.getReleaseYear());
            }
            assertEquals(director, addedFilm.getDirector());

            try {
                double expectedRating = rating.isEmpty() ? 0.0 : Double.parseDouble(rating);
                assertEquals(expectedRating, addedFilm.getRating(), 0.01);
            } catch (NumberFormatException e) {
                assertEquals(0.0, addedFilm.getRating(), 0.01);
            }
        }
    }

    /**
     * A mock class for FilmView to simulate user input during testing.
     */
    private static class FilmViewMock extends FilmView {
        private String[] inputs;
        private int index;

        public FilmViewMock(String... inputs) {
            this.inputs = inputs;
            this.index = 0;
        }

        /**
         * Simulates user input by returning predefined input strings based on the index.
         *
         * @param prompt The user input prompt.
         * @return The simulated user input.
         */
        @Override
        public String getUserInput(String prompt) {
            return inputs[index++];
        }
    }
    
    
}

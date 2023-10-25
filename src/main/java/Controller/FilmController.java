package Controller;

/**
 * The FilmController class manages the core logic of the Film Catalog application.
 *
 * @author Dawid
 * @version 1.0
 */
import Model.Film;
import View.FilmView;

import java.util.ArrayList;
import java.util.List;

/**
 * The FilmController class manages the core logic of the Film Catalog application.
 *
 * @author Dawid
 */
public class FilmController {
    private FilmView filmView;
    private List<Film> filmCatalog;

    /**
     * Constructs a FilmController object and initializes the FilmView and filmCatalog.
     */
    public FilmController() {
        filmView = new FilmView();
        filmCatalog = new ArrayList<>();
    }

    /**
     * Allows the user to add a film to the catalog.
     */
    public void addFilm() {
        filmView.displayMessage("Add a Film:");
        String title = filmView.getUserInput("Enter the title of the film: ");
        int releaseYear = Integer.parseInt(filmView.getUserInput("Enter the release year: "));
        String director = filmView.getUserInput("Enter the director of the film: ");
        double rating = Double.parseDouble(filmView.getUserInput("Enter the rating of the film: "));

        Film film = new Film(title, releaseYear, director, rating);
        filmCatalog.add(film);
        filmView.displayMessage("Film added to the catalog.");
    }

    /**
     * Displays the film catalog to the user.
     */
    public void viewFilmCatalog() {
        filmView.displayMessage("Film Catalog:");
        filmView.displayFilmList(filmCatalog);
    }

    /**
     * Runs the Film Catalog application and handles user interactions.
     */
    public void runApplication() {
        boolean isRunning = true;
        while (isRunning) {
            int choice = filmView.getMenuChoice();
            switch (choice) {
                case 1:
                    addFilm();
                    break;
                case 2:
                    viewFilmCatalog();
                    break;
                case 3:
                    isRunning = false;
                    filmView.displayMessage("Exiting the application.");
                    break;
                default:
                    filmView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }
}

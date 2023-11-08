package Controller;

/**
 * The FilmController class manages the core logic of the Film Catalog application.
 *
 * @author Dawid
 * @version 1.0
 */
import Model.Film;
import Model.FilmValidationException;
import View.FilmView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


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
        try {
            String title = filmView.getUserInput("Enter the title of the film: ");
            int releaseYear = Integer.parseInt(filmView.getUserInput("Enter the release year: "));
            String director = filmView.getUserInput("Enter the director of the film: ");
            double rating = Double.parseDouble(filmView.getUserInput("Enter the rating of the film: "));

            Film film = new Film(title, releaseYear, director, rating);
            film.validate();  // Validate film data
            filmCatalog.add(film);
            filmView.displayMessage("Film added to the catalog.");
        } catch (NumberFormatException e) {
            filmView.displayMessage("Invalid numeric format. Please enter a valid number.");
        } catch (FilmValidationException e) {
            filmView.displayMessage("Invalid input: " + e.getMessage());
        }
    }

    public Film addFilm(String filmData) {
        String title = "";
        int releaseYear = 0;
        String director = "";
        double rating = 0.0;

        Scanner scanner = new Scanner(filmData);
        scanner.useDelimiter(",");

        if (scanner.hasNext()) {
            title = scanner.next().trim();
        } else {
            scanner.close();
            return null;
        }

        if (scanner.hasNextInt()) {
            releaseYear = scanner.nextInt();
        } else {
            scanner.close();
            return null;
        }

        if (scanner.hasNext()) {
            director = scanner.next().trim();
        } else {
            scanner.close();
            return null;
        }

        if (scanner.hasNextDouble()) {
            rating = scanner.nextDouble();
        } else {
            scanner.close();
            return null;
        }

        scanner.close();

        return new Film(title, releaseYear, director, rating);
    }



    /**
     * Displays the film catalog to the user.
     */
    public void viewFilmCatalog() {
        filmView.displayMessage("Film Catalog:");
        filmView.displayFilmList(filmCatalog);
    }

    /**
     * Provide an option to search for films by title.
     *
     * If the user chooses to search for films
     * by title, it prompts the user to enter a search phrase and displays matching films.
     * If the user skips the search by pressing Enter, it displays the full catalog.
     */
    public void handleSearchCatalog() {
        String prompt = "Enter a search phrase (or press Enter to skip):";
        String searchPhrase = filmView.getUserInput(prompt);

        if (!searchPhrase.isEmpty()) {
            filmView.displayMessage("Search Results:");
            List<Film> matchingFilms = filmCatalog.stream()
                    .filter(film -> film.getTitle().toLowerCase().contains(searchPhrase.toLowerCase()))
                    .collect(Collectors.toList());

            if (matchingFilms.isEmpty()) {
                filmView.displayMessage("No films matching the search criteria.");
            } else {
                filmView.displayFilmList(matchingFilms);
            }
        } else {
            filmView.displayFilmList(filmCatalog);
        }
    }

    /**
     * Sets the FilmView for the controller.
     *
     * @param filmView The FilmView to set.
     */
    public void setFilmView(FilmView filmView) {
        this.filmView = filmView;
    }
    
    /**
     * Gets the film catalog.
     *
     * @return The film catalog.
     */
    public List<Film> getFilmCatalog() {
        return filmCatalog;
    }
    
    /**
     * Runs the Film Catalog application and handles user interactions.
     */
    public void runApplication(String[] args) {
        // Check if there are command line arguments for adding a film
        if (args.length > 0 && args[0].equalsIgnoreCase("addFilm")) {
            addFilmFromCommandLine(args);
        } else {
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
                        handleSearchCatalog();
                        break;
                    case 4:
                        isRunning = false;
                        filmView.displayMessage("Exiting the application.");
                        break;
                    default:
                        filmView.displayMessage("Invalid choice. Please try again.");
                }
            }
        }
    }
    
     private void addFilmFromCommandLine(String[] args) {
        // Check if there are enough command line arguments
        if (args.length < 5) {
            filmView.displayMessage("Insufficient arguments for adding a film.");
            return;
        }

        try {
            // Parse command line arguments
            String title = args[1];
            int releaseYear = Integer.parseInt(args[2]);
            String director = args[3];
            double rating = Double.parseDouble(args[4]);

            // Create Film object and add to the catalog
            Film film = new Film(title, releaseYear, director, rating);
            filmCatalog.add(film);
            filmView.displayMessage("Film added to the catalog.");
        } catch (NumberFormatException e) {
            filmView.displayMessage("Invalid numeric format in command line arguments.");
        }
    }
}


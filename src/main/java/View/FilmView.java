package View;

import java.util.Scanner;
import Model.Film;
import java.util.List;

/**
 * The FilmView class is responsible for handling the user interface and displaying information to the user.
 *
 * @author Dawid
 * @version 1.0
 */
public class FilmView {
    private Scanner scanner;

    /**
     * Constructs a FilmView object and initializes the Scanner for user input.
     */
    public FilmView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Display a message to the user.
     *
     * @param message The message to be displayed.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Get user input with a provided prompt.
     *
     * @param prompt The prompt for the user.
     * @return The user's input as a String.
     */
    public String getUserInput(String prompt) {
        displayMessage(prompt);
        return scanner.nextLine();
    }

    /**
     * Display details of a film, including title, release year, director, and rating.
     *
     * @param film The Film object to display details for.
     */
    public void displayFilmDetails(Film film) {
        displayMessage("Film Details:");
        displayMessage("Title: " + film.getTitle());
        displayMessage("Release Year: " + film.getReleaseYear());
        displayMessage("Director: " + film.getDirector());
        displayMessage("Rating: " + film.getRating());
        // Add more film properties as needed
    }

    /**
     * Display a list of films in the catalog.
     *
     * @param filmList The list of films to be displayed.
     */
    public void displayFilmList(List<Film> filmList) {
        if (filmList.isEmpty()) {
            displayMessage("The film catalog is empty.");
        } else {
            displayMessage("Film Catalog:");
            filmList.forEach(film -> displayMessage("Title: " + film.getTitle() + ", Release Year: " + film.getReleaseYear()));
        }
    }

    /**
     * Get the user's menu choice, including options to add a film, view the catalog, or exit.
     *
     * @return The user's menu choice as an integer.
     */
    public int getMenuChoice() {
        displayMessage("Menu:");
        displayMessage("1. Add a Film");
        displayMessage("2. View Film Catalog");
        displayMessage("3. Search by");
        displayMessage("4. Exit");
        String choice = getUserInput("Enter your choice: ");
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }
}

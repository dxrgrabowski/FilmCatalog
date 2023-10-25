package Main;

import Controller.FilmController;

/**
 * The Main class is the entry point of the Film Catalog application.
 *
 * @author Dawid
 * @version 1.0
 */
public class Main {
    /**
     * The main method where the application starts.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        FilmController filmController = new FilmController();
        filmController.runApplication();
    }
}

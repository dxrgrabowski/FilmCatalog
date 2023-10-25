package Model;

/**
 * The Film class represents a film with various properties.
 *
 * @author Dawid
 */
public class Film {
    private String title;
    private int releaseYear;
    private String director;
    private double rating;
    // Add other film properties such as genre, duration, description, etc.

    /**
     * Constructs a Film object with the specified properties.
     *
     * @param title       The title of the film.
     * @param releaseYear The year of the film's release.
     * @param director    The director of the film.
     * @param rating      The rating of the film.
     */
    public Film(String title, int releaseYear, String director, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.rating = rating;
    }

    /**
     * Get the title of the film.
     *
     * @return The title of the film.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the film.
     *
     * @param title The title of the film.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the release year of the film.
     *
     * @return The release year of the film.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Set the release year of the film.
     *
     * @param releaseYear The release year of the film.
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * Get the director of the film.
     *
     * @return The director of the film.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Set the director of the film.
     *
     * @param director The director of the film.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Get the rating of the film.
     *
     * @return The rating of the film.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Set the rating of the film.
     *
     * @param rating The rating of the film.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title +
               "\nRelease Year: " + releaseYear +
               "\nDirector: " + director +
               "\nRating: " + rating;
    }
}

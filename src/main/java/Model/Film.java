package Model;

import java.util.Set;
import java.util.HashSet;
import Model.FilmValidationException;
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

    private Set<String> tags;

    /**a
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
        this.tags = new HashSet<>();
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

    /**
     * Add a tag to the film for searching purposes.
     *
     * @param tag The tag to add.
     */
    public void addTag(String tag) {
        tags.add(tag);
    }

    /**
     * Remove a tag from the film.
     *
     * @param tag The tag to remove.
     */
    public void removeTag(String tag) {
        tags.remove(tag);
    }

    /**
     * Get all tags associated with the film.
     *
     * @return A set of tags.
     */
    public Set<String> getTags() {
        return tags;
    }
    
    /**
     * Validates the data of the film.
     *
     * @throws FilmValidationException if the data is invalid.
     */
    public void validate() throws FilmValidationException {
        if (title == null || title.trim().isEmpty()) {
            throw new FilmValidationException("Title cannot be empty.");
        }
        if (releaseYear < 1900 || releaseYear > 2100) {
            throw new FilmValidationException("Invalid release year.");
        }
        if (director == null || director.trim().isEmpty()) {
            throw new FilmValidationException("Director cannot be empty.");
        }
        if (rating < 0.0 || rating > 10.0) {
            throw new FilmValidationException("Invalid rating. Must be between 0.0 and 10.0.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title +
               "\nRelease Year: " + releaseYear +
               "\nDirector: " + director +
               "\nRating: " + rating +
               "\nTags: " + tags;
    }
}

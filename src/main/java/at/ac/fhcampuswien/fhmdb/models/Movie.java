package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;


    // TODO add more properties here

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }


    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        movies.add(new Movie("The Godfather", "...", List.of(Genre.CRIME)));
        movies.add(new Movie("Fight Club", "...", List.of(Genre.DRAMA, Genre.ACTION)));
        movies.add( new Movie("The Matrix", "...", List.of(Genre.SCIENCE_FICTION,Genre.ACTION)));

        return movies;
    }
}

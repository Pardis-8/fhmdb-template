package at.ac.fhcampuswien.fhmdb.helpers;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class MovieDisplayHelper {

     public static List<Movie> sortMoviesAscending(ObservableList<Movie> observableMovies) {
         List<Movie> sortedMovies = new ArrayList<>(observableMovies);
         sortedMovies.sort(Comparator.comparing(Movie::getTitle));
         return sortedMovies;
     };

     public static List<Movie> sortMoviesDescending(ObservableList<Movie> observableMovies) {
         List<Movie> sortedMovies = new ArrayList<>(observableMovies);
         sortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
         return sortedMovies;

    }
    public static List<Movie>filterMoviesBySearch(List<Movie> moviesToFilter, String title) {

        if (title == null || title.isEmpty()) {
            return new ArrayList<>(moviesToFilter);
        }

        List<Movie> filteredMovies = new ArrayList<>();
        String sanitizedQuery = title.toLowerCase().trim().replaceAll("\\s+", " ");

        for (Movie movie : moviesToFilter) {
            if (movie.getTitle().toLowerCase().contains(sanitizedQuery) || movie.getDescription().toLowerCase().contains(sanitizedQuery)) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }
    public static List<Movie>filterMoviesByGenre(List<Movie> moviesToFilter, Genre genre) {
    if (genre == Genre.NONE || genre == null) {
        return moviesToFilter;
    }
    List<Movie> filteredMovies = new ArrayList<>(moviesToFilter);

    for (Movie movie : moviesToFilter) {
        if(movie.getGenres().contains(genre)) {
            filteredMovies.add(movie);
        }
    }
    return filteredMovies;
    }
    public static List<Movie>filterMovies(List<Movie> moviesToFilter, String title, Genre genre) {
        List<Movie> filteredMovies = filterMoviesByGenre(moviesToFilter, genre);
        return filterMoviesBySearch(filteredMovies, title);
    }

    }


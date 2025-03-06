package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.helpers.MovieDisplayHelper;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterBySearchTest {

    private List<Movie> movies;

    @BeforeEach
    public void movies() {
        movies = new ArrayList<Movie>();

        movies.add(new Movie("The Godfather", "...", List.of(Genre.CRIME)));
        movies.add(new Movie("The Matrix", "....", List.of(Genre.ACTION)));
        movies.add(new Movie("Fight Club", ".....", List.of(Genre.ACTION)));

    }

    @Test
    void filter_Movies_By_Title() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesBySearch(movies, "Fight");

        assertEquals(1, actual.size(), "Search 'Fight' needs to match only one movie");
        assertTrue(actual.contains(new Movie("Fight Club", "...", List.of(Genre.ACTION))));

    }

    @Test
    void no_matching_movies_by_title() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesBySearch(movies, "Matrix");
        assertTrue(actual.isEmpty(), "Search 'Matrix' needs to return an empty list as no movies match it.");

    }

    @Test
    void filter_of_partial_title() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesBySearch(movies, "The");

        assertEquals(1, actual.size(), "Search 'The' needs to match only one movie");
        assertTrue(actual.contains(new Movie("The Matrix", "...", List.of(Genre.CRIME))),
                "Filtered list needs to contain 'The Matrix'.");

    }

    @Test
    void movies_by_description_filter() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesBySearch(movies, ".....");
        assertEquals(1, actual.size(), "Search '.....' needs to match only one movie");
        assertTrue(actual.contains(new Movie("Fight Club",".....", List.of(Genre.ACTION))),
                "Filtered list needs to contain 'Fight Club'.");

    }
    @Test
    void filtered_movies_when_no_search_given() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesBySearch(movies, "");

        assertEquals(1, actual.size(), "Empty search needs to return all movies");
    }
}

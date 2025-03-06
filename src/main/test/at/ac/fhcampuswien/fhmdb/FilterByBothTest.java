package at.ac.fhcampuswien.fhmdb;


import at.ac.fhcampuswien.fhmdb.helpers.MovieDisplayHelper;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterByBothTest {

    private List<Movie> movies;

    @BeforeEach
    public void movies() {
        movies = new ArrayList<>();

        movies.add(new Movie("The Godfather", "...", List.of(Genre.CRIME)));
        movies.add(new Movie("Fight Club", "...", List.of(Genre.DRAMA, Genre.ACTION)));
        movies.add(new Movie("The Matrix", "...", List.of(Genre.SCIENCE_FICTION, Genre.ACTION)));
    }

    @Test
    void return_all_movies_when_search_and_genre_are_null() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, null, null);
        assertEquals(movies, actual, "Are both search and genre null must the full unmodified list be returned.");
    }
    @Test
    void filter_by_genre_when_search_is_null() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, null, Genre.ACTION);
        List<Movie> expected = MovieDisplayHelper.filterMovies(movies, null, Genre.ACTION);
        assertEquals(expected, actual, "Only Action movies need to be returned.");

    }
    @Test
    void filter_by_search_when_genre_is_null_() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        List<Movie> expected = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        assertEquals(expected, actual, "Only movies with 'Fight' in Title or description need to be returned.");
    }
    @Test
    void filters_by_genre_and_search() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        String actualTitle = actual.get(0).getTitle();
        String expectedTitle = "Fight Club";

        assertEquals(expectedTitle, actualTitle, "Only title contains 'Fight Club'");
    }

    @Test
    void searched_title_matches_but_incorrect_genre_then_return_empty_list() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ANIMATION);
        assertTrue(actual.isEmpty(), "Non matching search title returned.");

    }

    @Test
    void both_filters_match_subset_of_movies_returned() {
        List<Movie> actual = MovieDisplayHelper.filterMovies(movies, "an", Genre.ACTION);
        List<String> actualTitle = actual.stream().map(Movie::getTitle).toList();
        List<String> expectedTitle = List.of("The Matrix", "The Godfather.");

        assertEquals(expectedTitle,actualTitle, "Only The Matrix and The Godfather need to be returned because both match 'an'.");

    }
}

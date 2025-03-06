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
    void search_null_and_genre_null_returns_unmodified_list() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, null, null);
        assertEquals(movies, in_real, "Null search title and null genre need to be returned to unmodified list.");
    }
    @Test
    void search_null_and_genre_valid_filters_by_genre() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, null, Genre.ACTION);
        List<Movie> expected = MovieDisplayHelper.filterMovies(movies, null, Genre.ACTION);
        assertEquals(expected, in_real, "Only Action movies need to be returned.");

    }
    @Test
    void search_valid_and_genre_null_filters_by_search() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        List<Movie> expected = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        assertEquals(expected, in_real, "Only movies with 'Fight' in Title or description need to be returned.");
    }
    @Test
    void search_valid_and_genre_valid_filters_by_genre_and_search() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ACTION);
        String in_realTitle = in_real.get(0).getTitle();
        String expectedTitle = "Fight Club";

        assertEquals(expectedTitle, in_realTitle, "Only title contains 'Fight Club'");
    }

    @Test
    void searched_title_matches_but_incorrect_genre_and_returns_empty_list() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, "Fight", Genre.ANIMATION);
        assertTrue(in_real.isEmpty(), "Non matching search title returned.");

    }

    @Test
    void both_filters_match_subset_of_movies_returned() {
        List<Movie> in_real = MovieDisplayHelper.filterMovies(movies, "an", Genre.ACTION);
        List<String> in_realTitle = in_real.stream().map(Movie::getTitle).toList();
        List<String> expectedTitle = List.of("The Matrix", "The Godfather.");

        assertEquals(expectedTitle, in_realTitle, "Only The Matrix and The Godfather need to be returned because both match 'an'.");

    }
}

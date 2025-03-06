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

public class SearchByGenreTest {

    private List<Movie> movies;

    @BeforeEach
    void movies() {
        movies = new ArrayList<>();

        movies.add(new Movie("The Godfather", "...", List.of(Genre.CRIME)));
        movies.add(new Movie("Fight Club", "...", List.of(Genre.DRAMA, Genre.ACTION));
        movies.add( new Movie("The Matrix", "...", List.of(Genre.SCIENCE_FICTION, Genre.ACTION));

    }

    @Test
    void when_genre_null_return_all_movies() {
        List<Movie> actual = MovieDisplayHelper.filterMoviesByGenre(movies, null);
        assertEquals(actual, movies, "A genre when filtered that is null needs to be returned by an unmodified list.");
    }

    @Test
    void empty_list_when_movies_match_no_genre_returned() {

        movies = new ArrayList<>();

        movies.add(new Movie("The Godfather", "...", List.of(Genre.CRIME)),
        movies.add(new Movie("Fight Club", "...", List.of(Genre.DRAMA, Genre.ACTION)),
        movies.add( new Movie("The Matrix", "...", List.of(Genre.SCIENCE_FICTION, Genre.ACTION))),


        List<Movie> actual = MovieDisplayHelper.filterMoviesByGenre(movies, Genre.DRAMA);
        assertTrue(actualMovies.isEmpty(), "Genre not included in the movie list needs to return an emptly list.");

    }
    @Test
    void exclusion_of_non_matching_movies_by_filter() {

        List<Movie> movies = List.of(

                new Movie("The Godfather", "...", List.of(Genre.CRIME)),

                new Movie("Fight Club", "...", List.of(Genre.DRAMA, Genre.ACTION)),

                new Movie("The Matrix", "...", List.of(Genre.SCIENCE_FICTION, Genre.ACTION)));


        List<Movie> actual = MovieDisplayHelper.filterMoviesByGenre(movies, Genre.SCIENCE_FICTION);
        assertEquals(1, actual.size(), "Filtered list needs to contain only one movie");
        assertFalse(actual.contains(new Movie("The Godfather", "...", List.of(Genre.CRIME));
    }

    @Test
    void all_matching_movies_included_by_filter() {

        Movie TheGodfather = new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his " +
                        "clandestine empire to his reluctant son.", List.of(Genre.CRIME));

        Movie FightClub = new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap " +
                "maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA, Genre.ACTION));

        Movie TheMatrix = new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers" +
                "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.SCIENCE_FICTION, Genre.ACTION));


        List<Movie> movies = List.of(TheGodfather,FightClub,TheMatrix);

    };


}


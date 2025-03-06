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
        movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his " +
                "clandestine empire to his reluctant son.", List.of(Genre.CRIME), 1972));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his " +
                "gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", List.of(Genre.CRIME, Genre.ADVENTURE, Genre.FANTASY), 2003));
        movies.add(new Movie("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned " +
                "for his Jewish workforce after witnessing their persecution by the Nazis.", List.of(Genre.HISTORY, Genre.DRAMA, Genre.CRIME), 1993));
        movies.add(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap " +
                "maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA, Genre.ACTION), 1999));
        movies.add(new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers" +
                "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.SCIENCE_FICTION, Genre.ACTION), 1999));
        movies.add(new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is" +
                "tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE, Genre.ADVENTURE), 2014));
        movies.add(new Movie("The Silence of the Lambs", "A young F.B.I. cadet must receive the help of an incarcerated and manipulative " +
                "cannibal killer to help catch another serial killer, a madman who skins his victims.", List.of(Genre.CRIME, Genre.HORROR, Genre.THRILLER), 1991));
        movies.add(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an" +
                " idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION), 2010));
    }

    @Test
    void when_genre_null_return_all_movies() {
        List<Movie> in_real = MovieDisplayHelper.filterMoviesByGenre(movies, null);
        assertEquals(in_real, movies, "A genre when filtered that is null needs to be returned by an unmodified list.");
    }

    @Test
    void empty_list_when_movies_match_no_genre_returned() {
        movies = new ArrayList<>();

        movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his " +
                "clandestine empire to his reluctant son.", List.of(Genre.CRIME), 1972));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his " +
                "gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", List.of(Genre.CRIME, Genre.ADVENTURE, Genre.FANTASY), 2003));
        movies.add(new Movie("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned " +
                "for his Jewish workforce after witnessing their persecution by the Nazis.", List.of(Genre.HISTORY, Genre.DRAMA, Genre.CRIME), 1993));
        movies.add(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap " +
                "maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA, Genre.ACTION), 1999));
        movies.add(new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers" +
                "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.SCIENCE_FICTION, Genre.ACTION), 1999));
        movies.add(new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is" +
                "tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE, Genre.ADVENTURE), 2014));
        movies.add(new Movie("The Silence of the Lambs", "A young F.B.I. cadet must receive the help of an incarcerated and manipulative " +
                "cannibal killer to help catch another serial killer, a madman who skins his victims.", List.of(Genre.CRIME, Genre.HORROR, Genre.THRILLER), 1991));
        movies.add(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an" +
                " idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION), 2010));

        List<Movie> is_real = MovieDisplayHelper.filterMoviesByGenre(movies, Genre.FANTASY);
        assertTrue(is_real.isEmpty(), "Genre not included in the movie list needs to return an emptly list.");

    }

    @Test
    void exclusion_of_genre_filter_by_non_matching_movies() {

        Movie TheGodfather = new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his " +
                        "clandestine empire to his reluctant son.", List.of(Genre.CRIME), 1972);

        Movie TheLordOftheRings= new Movie("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his " +
                "gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", List.of(Genre.CRIME, Genre.ADVENTURE, Genre.FANTASY), 2003);

        Movie SchindlersList = new Movie("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned " +
                "for his Jewish workforce after witnessing their persecution by the Nazis.", List.of(Genre.HISTORY, Genre.DRAMA, Genre.CRIME), 1993);

        Movie FightClub = new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap " +
                "maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA, Genre.ACTION), 1999);

        Movie TheMatrix = new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers" +
                "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.SCIENCE_FICTION, Genre.ACTION), 1999);

        Movie Interstellar = new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is" +
                "tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE, Genre.ADVENTURE), 2014);

        Movie TheSilenceoftheLambs = new Movie("The Silence of the Lambs", "A young F.B.I. cadet must receive the help of an incarcerated and manipulative " +
                "cannibal killer to help catch another serial killer, a madman who skins his victims.", List.of(Genre.CRIME, Genre.HORROR, Genre.THRILLER), 1991);

        Movie Inception = new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an" +
                " idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION), 2010);

        List<Movie> movies = List.of(TheGodfather,TheLordOftheRings,SchindlersList,FightClub,TheMatrix,Interstellar,TheSilenceoftheLambs,Inception);

    }
    List<Movie> in_real = MovieDisplayHelper.filterMoviesByGenre(movies, Genre.ACTION);
    assertEquals(in_real.size());


}


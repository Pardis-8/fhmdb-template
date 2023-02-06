package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;
    private int releaseYear;

    // TODO add more properties here

    public Movie(String title, String description, List<Genre> genres, int releaseYear) {
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        movies.add(new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his " +
                "clandestine empire to his reluctant son.", List.of(Genre.CRIME),1972 ));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his " +
                "gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", List.of(Genre.CRIME, Genre.ADVENTURE, Genre.FANTASY),2003));
        movies.add(new Movie("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned " +
                "for his Jewish workforce after witnessing their persecution by the Nazis.", List.of(Genre.HISTORY, Genre.DRAMA, Genre.CRIME),1993));
        movies.add(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap " +
                "maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA, Genre.ACTION),1999 ));
        movies.add(new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers" +
                "the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.SCIENCE_FICTION, Genre.ACTION),1999 ));
        movies.add(new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is" +
                "tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE, Genre.ADVENTURE),2014 ));
        movies.add(new Movie("The Silence of the Lambs", "A young F.B.I. cadet must receive the help of an incarcerated and manipulative " +
                "cannibal killer to help catch another serial killer, a madman who skins his victims.", List.of(Genre.CRIME,Genre.HORROR,Genre.THRILLER),1991));
        movies.add(new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an" +
                " idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.ACTION,Genre.ADVENTURE,Genre.SCIENCE_FICTION),2010));


        return movies;
    }
}

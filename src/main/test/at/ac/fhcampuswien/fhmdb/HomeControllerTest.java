package at.ac.fhcampuswien.fhmdb;

import static org.junit.jupiter.api.Assertions.*;

import at.ac.fhcampuswien.fhmb.models.Genre;
import at.ac.fhcampuswien.fhmb.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;


class HomeControllerTest {
    private HomeController homeController;

    void setUp{
        homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();
    }

    void TestForMovieByTitleSearch() {
        String[] titles = {"The Godfather", "Lord of the Rings: The Return of the King", "Matrix"
                "Schindler's List", "Fight Club", "Interstellar", "The Silence of the Lambs", "Inception"};

        for (String title : titles) {
            homeController.searchField.setText(title);
            homeController.searchBtn.fire();
            assertFalse(homeController.movieListView.getItems().isEmpty());
            assertEquals(title, homeController.movieListView.getItems().get(0).getTitle());
        }

        void testSearchByDescription () {
            String[] keywords = {"Godfather", "Rings", "helps", "computer", "spacecraft", "office worker",
                    "occupied", "son", "serial killer", "evolves", "intelligence", "thief"};

            for (String keyword : keywords) {
                homeController.searchField.setText(keyword);
                List<Movie> results = homeController.movieListView.getItems();
                assertTrue(results.stream().anyMatch(m -> m.getDescription().toLowerCase().contains(keyword)));
                assertFalse(results.isEmpty(), "No results found for " + keyword);
            }
        }
        void testFilterByGenre () {
            Genre[] genres = Genre.values();

            String[] genres = {Genre.ACTION, Genre.ADVENTURE, Genre.ANIMATION, Genre.BIOGRAPHY,
                    Genre.COMEDY, Genre.CRIME, Genre.DRAMA, Genre.DOCUMENTARY, Genre.FAMILY,
                    Genre.FANTASY, Genre.HISTORY, Genre.HORROR, Genre.MUSICAL, Genre.MYSTERY,
                    Genre.ROMANCE, Genre.SCIENCE_FICTION, Genre.SPORT, Genre.THRILLER, Genre.WAR,
                    Genre.WESTERN};

            for (Genre genre : genres) {
                homeController.genreComboBox.setValue(genre);
                homeController.searchBtn.fire();
                List<Movie> results = homeController.movieListView.getItems();
                assertTrue(results.stream().allMatch(m -> m.getGenres().contains(genre)));
                assertFalse(results.isEmpty(), "No results found for " + genre);
            }
        }

            void testSearchByAscending () {

                homeController.sortBtn.setText("Sort (asc)");
                homeController.sortBtn.fire();

                List<Movie> sortedMovies = homeController.movieListView.getItems();
                List<String> sortedTitles = sortedMovies.stream().Map(Movie::getTitle).collect(Collectors.toList());
                List<String> expectedSortedTitles = sortedTitles.stream().sorted().collect(Collectors.toList());
                assertEquals(expectedSortedTitles, sortedTitles);
            }

            void testSearchByDescending () {

                homeController.sortBtn.setText("Sort (desc)");
                homeController.sortBtn.fire();

                List<Movie> sortedMovies = homeController.movieListView.getItems();
                List<String> sortedTitles = sortedMovies.stream().Map(Movie::getTitle).collect(Collectors.toList());

                List<String> expectedSortedTitles = sortedTitles.stream().sorted(a, b) -> b.compareTo(a)).
                collect(Collectors.toList());

                assertEquals(expectedSortedTitles, sortedTitles);
            }

        }

    }


}
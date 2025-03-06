package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.TableColumnSortTypeWrapper.isAscending;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes
    private boolean isAscending = true; //Sorting

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies); // add dummy data to observable list


        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().clear();
        genreComboBox.getItems().addAll(FXCollections.observableArrayList(Genre.values()));

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (isAscending) {
                observableMovies.sort(Comparator.comparing(Movie::getTitle));
                sortBtn.setText("Sort (desc)");
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                observableMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
                sortBtn.setText("Sort (asc)");
            }
            isAscending = !isAscending;
        });

        searchBtn.setOnAction(actionEvent -> applyFilter());//Suchfunktion

        searchField.setOnKeyPressed(event -> { //ENTER - Taste
            if (event.getCode() == KeyCode.ENTER) {
                applyFilter();
            }
        });
    }

    private void applyFilter() {
        String query = searchField.getText().trim().toLowerCase(); // Texteingabe des Benutzers im Suchfeld
        Genre selectedGenre = (Genre) genreComboBox.getValue();

        //Movies filtered based on search and genre selection
        List<Movie> filteredMovies = allMovies.stream().
                filter(movie -> movie.getTitle().toLowerCase().contains(query) || movie.getDescription().toLowerCase().
                        contains(query)).filter(movie -> selectedGenre == null || (movie.getGenres() != null &&
                        movie.getGenres().contains(selectedGenre))).toList();

        if (filteredMovies.isEmpty()) {
            System.out.println("No movies found");
        } else {
            observableMovies.setAll(filteredMovies); //Liste ersetzt anstatt neue Elemente hinzugefügt
            System.out.println("Filtered movies count : " + filteredMovies.size());
        }

        movieListView.refresh(); //IU-Refresh
    }
}



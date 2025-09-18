package movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        movies.add(new Movie("미니언즈", 123, 18000, 1));
        movies.add(new Movie("명탐정코난", 120, 18000, 2));
        movies.add(new Movie("아이언맨", 130, 18000, 3));
        movies.add(new Movie("어벤저스", 150, 18000, 4));
        movies.add(new Movie("아바타", 180, 18000, 5));

    }

    public List<Movie> findAll() {
        return movies;
    }

    public Movie findById(int id) {
        for(Movie movie : movies) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
}

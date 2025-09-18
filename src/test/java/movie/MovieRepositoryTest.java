package movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MovieRepositoryTest {

    @Test
    @DisplayName("영화 목록 가져오기")
    void findAllMovie() {
        MovieRepository movieRepository = new MovieRepository();

        List<Movie> movies = movieRepository.findAll();

        assertThat(movies).hasSize(5);
    }

    @Test
    @DisplayName("Id로 특정 영화 선택하기")
    void findByMovieId() {
        MovieRepository movieRepository = new MovieRepository();
        int movieId = 1;

        Movie movie = movieRepository.findById(movieId);

        assertThat(movie.getId()).isEqualTo(movieId);
        assertThat(movie.getTitle()).isEqualTo("미니언즈");

    }
}

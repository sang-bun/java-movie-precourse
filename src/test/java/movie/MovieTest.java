package movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MovieTest {

    @Test
    @DisplayName("영화 제목, 상영시간, 가격을 생성하고 정보를 가져올 수 있다.")
    void createMovie() {
        Movie movie = new Movie("미니언즈", 123, 18000);

        assertThat(movie.getTitle()).isEqualTo("미니언즈");
        assertThat(movie.getRuntime()).isEqualTo(123);
        assertThat(movie.getPrice()).isEqualTo(18000);
    }
}

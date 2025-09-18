package movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayScheduleTest {

    @Test
    @DisplayName("상영 스케줄 생성")
    void createPlaySchedule() {

        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 18, 14, 0);
        int seatSize = 80;

        PlaySchedule schedule = new PlaySchedule(movie, startTime, seatSize);

        assertThat(schedule.getMovie().getTitle()).isEqualTo("미니언즈");
        assertThat(schedule.getStartTime()).isEqualTo(startTime);
    }
}

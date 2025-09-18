package movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ReservationTest {

    @Test
    @DisplayName("특정 영화 예매 생성")
    void createReservation(){
        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 18, 14, 0);
        PlaySchedule schedule = new PlaySchedule(movie, startTime, 80);
        int headCount = 2;

        Reservation reservation = new Reservation(schedule, headCount);

        assertThat(reservation.getPlaySchedule().getMovie().getTitle()).isEqualTo("미니언즈");
        assertThat(reservation.getHeadCount()).isEqualTo(headCount);
    }

}

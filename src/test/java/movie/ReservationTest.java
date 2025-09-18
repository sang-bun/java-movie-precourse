package movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("예약할 좌석 추가")
    void addSeat(){
        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 18, 14, 0);
        PlaySchedule schedule = new PlaySchedule(movie, startTime, 80);
        Reservation reservation = new Reservation(schedule, 2);
        Seat seatA1 = new Seat("A", 1);
        Seat seatA2 = new Seat("A", 2);

        reservation.addSeat(seatA1);
        reservation.addSeat(seatA2);

        assertThat(reservation.getSeats()).hasSize(2);
        assertThat(reservation.getSeats()).contains(seatA1, seatA2);

    }

    @Test
    @DisplayName("무비데이 할인 적용")
    void MovieDayDiscount(){
        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 10, 14, 0);
        PlaySchedule schedule = new PlaySchedule(movie, startTime, 80);
        Reservation reservation = new Reservation(schedule, 2);
        int price = 20000;

        int discountedPrice = reservation.movieDayDiscount(price);

        assertThat(discountedPrice).isEqualTo(18000);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    @DisplayName("시간 조건 할인")
    void TimeDiscount(int hour){
        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 11, hour, 0);
        PlaySchedule schedule = new PlaySchedule(movie, startTime, 80);
        Reservation reservation = new Reservation(schedule, 2);
        int price = 20000;

        int discountedPrice = reservation.timeDiscount(price);

        assertThat(discountedPrice).isEqualTo(18000);
    }

    @Test
    @DisplayName("포인트 사용 포인트가 돈보다 작을때")
    void Points(){
        Reservation reservation = new Reservation(null, 0);
        int price = 20000;
        int point = 5000;

        int finalPrice = reservation.points(price, point);

        assertThat(finalPrice).isEqualTo(price-point);
    }

    @Test
    @DisplayName("포인트 사용 포인트가 돈보다 많을때")
    void PriceOverPoints(){
        Reservation reservation = new Reservation(null, 0);
        int price = 20000;
        int point = 30000;

        int finalPrice = reservation.points(price, point);

        assertThat(finalPrice).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"CREDIT_CARD, 19000", "CASH, 19600"})
    @DisplayName("결제 수단에 따른 할인")
    void PaymentDiscount(String payment, int expectedPrice){
        Reservation reservation = new Reservation(null, 0);
        int price = 20000;

        int finalPrice = reservation.paymentDiscount(price, payment);

        assertThat(finalPrice).isEqualTo(expectedPrice);

    }

    @Test
    @DisplayName("최종 결제")
    void finalPrice(){
        Movie movie = new Movie("미니언즈", 123, 18000, 1);
        LocalDateTime startTime = LocalDateTime.of(2025, 9, 10, 20, 0);
        PlaySchedule schedule = new PlaySchedule(movie, startTime, 80);
        Reservation reservation = new Reservation(schedule, 2);

        reservation.addSeat(new Seat("A", 1));
        int finalPrice = reservation.finalPrice(200, "CREDIT_CARD");

        assertThat(finalPrice).isEqualTo(13300);
    }
}

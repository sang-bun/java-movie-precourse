package movie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlaySchedule {

    private final Movie movie;
    private final LocalDateTime startTime;
    private final int seatSize;

    private final List<Seat> bookedSeats = new ArrayList<>();

    public PlaySchedule(Movie movie, LocalDateTime startTime, int seatSize) {
        this.movie = movie;
        this.startTime = startTime;
        this.seatSize = seatSize;
    }

    public Movie getMovie() {
        return movie;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public int getSeatSize() {
        return seatSize;
    }

    public void processReservation(Reservation reservation) {
        for(Seat seat : reservation.getSeats()) {
            if (this.bookedSeats.contains(seat)) {
                throw new IllegalArgumentException("이미 예약된 좌석입니다.");
            }
        }

        this.bookedSeats.addAll(reservation.getSeats());
    }

}

package movie;

import java.time.LocalDateTime;

public class PlaySchedule {

    private final Movie movie;
    private final LocalDateTime startTime;
    private final int seatSize;

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

}

package movie;

import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private final PlaySchedule playSchedule;
    private final int headCount;
    private final List<Seat> seats = new ArrayList<>();

    public Reservation(PlaySchedule schedule, int headCount) {
        playSchedule = schedule;
        this.headCount = headCount;
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }
    public int getHeadCount() {
        return headCount;
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
    }
    public List<Seat> getSeats() {
        return seats;
    }


}

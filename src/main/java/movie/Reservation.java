package movie;

public class Reservation {

    private final PlaySchedule playSchedule;
    private final int headCount;

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


}

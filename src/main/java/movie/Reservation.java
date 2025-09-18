package movie;

import java.time.LocalDateTime;
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

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Seat seat : this.seats) {
            totalPrice += getPriceForSeat(seat);
        }
        return totalPrice;
    }

    public int getPriceForSeat(Seat seat) {
        String row = seat.getRow();

        // S등급을 A, B열이라고 가정
        if("A".equals(row) || "B".equals(row)) {
            return 18000;
        }
        // A등급을 C, D열이라고 가정
        if("C".equals(row) || "D".equals(row)) {
            return 15000;
        }

        return 12000;

    }

    public int movieDayDiscount(int price){
        LocalDateTime startTime = this.playSchedule.getStartTime();

        int dayOfMonth = startTime.getDayOfMonth();

        if (dayOfMonth == 10 || dayOfMonth == 20 || dayOfMonth == 30) {
            return price * 90 / 100;
        }

        return price;
    }

    public int timeDiscount(int price){
        LocalDateTime startTime = this.playSchedule.getStartTime();

        int hour = startTime.getHour();

        if(hour < 11 || hour >= 20){
            return price - 2000;
        }
        return price;
    }


}

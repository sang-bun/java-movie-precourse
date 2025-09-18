package movie;

import java.util.Objects;

public class Seat {

    private final String row;
    private final int column;

    public Seat(String row, int column){
        this.row = row;
        this.column = column;
    }
    public String getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row.equals(seat.row) && column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }


}

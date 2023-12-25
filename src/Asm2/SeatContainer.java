package Asm2;

import java.util.ArrayList;
import java.util.List;

public class SeatContainer {
    private List<Seat> seats;
    public SeatContainer() {
        this.seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat("i"));
        }
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
    }
    public Seat getSeat(int i){
        return seats.get(i);
    }
    public List<Seat> getSeats() {
        return seats;
    }

}


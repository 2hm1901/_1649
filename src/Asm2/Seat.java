package Asm2;

    public class Seat {
        private String name;
        private boolean isBooked;
        public Seat(String name) {
            this.name = name;
            this.isBooked = false;
        }
        public String getName() {
            return name;
        }
        public boolean isBooked() {
            return isBooked;
        }
        public void bookSeat() {
            this.isBooked = true;
        }
    }

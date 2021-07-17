

//public class FlightReservasionSystem {
    public abstract class FlightReservasionSystem {

        public FlightReservasionSystem(){

        }

        public FlightReservasionSystem(int seatCounts){

        }
        private int seatCounts;
        private boolean[] seats;

        public int getSeatCounts() {
          int seatCounts = -1;
        return seatCounts;
        }

        public void setSeatCounts(int seatCounts) {
            this.seatCounts = seatCounts;
        }

        public void setSeats(boolean[] seats) {
             this.seats = seats;
        }

        public boolean[] getSeats() {
        return seats;
    }

        public boolean isEkonomikfull() {
            return false;
        }
        public boolean isBusinessfull() {
            return false;
        }
        public boolean isAirplanFull() {
            return false;
        }

        public  abstract void takeRezervasion();
    }



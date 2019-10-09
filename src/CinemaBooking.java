public class CinemaBooking {
    //seat row
    //[5]  [5]
    private String[][] bookings = new String[9][8];
    private final int frontRowCost = 25, middleRowCost = 35, backRowCost = 31;
    private int totalCost;

    public boolean isSeat(int row, int seat) {
        if (bookings[row][seat] == "x") {
            return true;
        }
        return  false;
    }
    public boolean bookSeat(int row, int seat) {
        if (bookings[row][seat] == "#") {
            bookings[row][seat] = "x";
            if (row >= 1 && row <= 3) {
                totalCost += frontRowCost;
            }
            else if (row >= 4 && row <= 6) {
                totalCost += middleRowCost;
            }
            else if (row >= 7 && row <= 10) {
                totalCost += backRowCost;
            }
            return true;
        }
        return false;
    }
    public void show() {
        System.out.println("--screen--");
        for (int i = 0; i < bookings.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < bookings[i].length; j++) {
                System.out.print(bookings[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < bookings.length; i++) {
            System.out.print((i+1));
        }
    }
    public void clear() {
        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                bookings[i][j] = "#";
            }
        }
        System.out.println("All bookings cleared");
    }
    public int totalIncome() {
        int seatsbooked = 0;
        int frontSeats = 0, midSeats =0, backSeats = 0;

        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                if (bookings[i][j] == "x") {
                    if (i >= 0 && i <= 3) {
                        frontSeats++;
                    }
                    if (i >= 4 && i <= 6) {
                        midSeats++;
                    }
                    if (i >= 7 && i <= 10) {
                        backSeats++;
                    }
                    seatsbooked++;
                }
            }
        }
        return seatsbooked*(frontSeats+midSeats+backSeats);
    }
    public int totalBookings() {
        int seatsbooked = 0;

        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                if (bookings[i][j] == "x") {
                    seatsbooked++;
                }
            }
        }
        return seatsbooked;
    }

    public static void main(String[] args) {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.bookSeat(5,7);
        System.out.println(cinemaBooking.isSeat(5,5));
        System.out.println(cinemaBooking.totalBookings());
        cinemaBooking.show();
    }
}

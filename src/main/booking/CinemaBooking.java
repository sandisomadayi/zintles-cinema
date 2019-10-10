package booking;

public class CinemaBooking {
    //seat row
    //[5]  [5]
    private String[][] bookings = new String[9][15];
    private static final int FRONT_ROW_COST = 25, MIDDLE_ROW_COST = 35, BACK_ROW_COST = 31;
    private int totalCost;

    //checks if a seat is booked
    public boolean isSeat(int row, int seat) {
        if (bookings[row][seat].equals("x")) {
            return true;
        }
        return  false;
    }

    //books a seat
    public boolean bookSeat(int row, int seat) {
        if (bookings[row][seat] == "#") {
            bookings[row][seat] = "x";
            return true;
        }
        return false;
    }

    //shows all seats in the cinema
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
        System.out.println();
    }

    //clears all bookings made
    public void clear() {
        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                bookings[i][j] = "#";
            }
        }
        System.out.println("All bookings cleared");
    }

    //shows the income from booked seats
    public int totalIncome() {
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
                }
            }
        }
        return (frontSeats*FRONT_ROW_COST) + (midSeats*MIDDLE_ROW_COST) + (backSeats*BACK_ROW_COST);
    }
    //shows the number of booked seats
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

    //books seats in specified row
    public boolean book(int tickets, String location) {
        int unbooked = 0;
        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                if (location.equals("front")) {
                    while (i <= 2) {
                        if (bookings[i][j].equals("#")) {

                        }
                    }
                }
                if (location.equals("middle")) {}
                if (location.equals("back")) {}
                if (bookings[i][j] == "#") {
                    unbooked++;
                }
            }
        }
        if (tickets <= unbooked) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.bookSeat(5,7);
        cinemaBooking.bookSeat(2,1);
        System.out.println(cinemaBooking.isSeat(5,3));
        System.out.println(cinemaBooking.totalBookings());
        cinemaBooking.show();
//        System.out.println(cinemaBooking.totalIncome());

    }
}

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
        if (bookings[row][seat].equals("#")) {
            bookings[row][seat] = "x";
            return true;
        }
        return false;
    }

    //shows all seats in the cinema
    public void show() {
        System.out.println("----screen----");
        for (int i = 0; i < bookings.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < bookings[i].length; j++) {
                System.out.print(bookings[i][j] + " ");
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
//        System.out.println("All bookings cleared");
    }

    //shows the income from booked seats
    public int totalIncome() {
        int frontSeats = 0, midSeats =0, backSeats = 0;

        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                if (bookings[i][j].equals("x")) {
                    if (i >= 0 && i <= 2) {
                        frontSeats++;
                    }
                    if (i >= 3 && i <= 6) {
                        midSeats++;
                    }
                    if (i >= 7 && i <= 8) {
                        backSeats++;
                    }
                }
            }
        }
        return frontSeats*FRONT_ROW_COST + midSeats*MIDDLE_ROW_COST + backSeats*BACK_ROW_COST;
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
        int unbookedSeats = 0, lastSeatPosition = 0, rowPosition = 0;
        if (location.equals("front")) {
            outside:
            for (int i = 0; i <= 2; i++) {
                inside:
                for (int j = 0; j < bookings[i].length; j++) {
                    if (bookings[i][j].equals("#")) {
                        unbookedSeats++;
                        bookings[i][j] = "X";
                        if (unbookedSeats == tickets) {
                            break outside;
                        }

                    } else {
                        unbookedSeats = 0;
                    }
                }
            }
        }
        if (location.equals("middle")) {
            rowLoop:
            for (int i = 3; i <= 5; i++) {
                seatLoop:
                for (int j = 0; j < bookings[i].length; j++) {
                    if (bookings[i][j].equals("#")) { //if a seat is unbooked
                        unbookedSeats++;//increase the number of unbooked seats

                        if (unbookedSeats == tickets) {//if unbooked seats are equal to the number of tickets, stop looking for unbooked seats
                            lastSeatPosition = j;
                            rowPosition = i;
                            break rowLoop;
                        }
                        if (j == bookings[i].length -1 && unbookedSeats < tickets) {//if you are in the last seat
                            unbookedSeats = 0; //reset the number of unbooked seats
                            continue rowLoop; //go to the next row
                        }
                    } else {
                        unbookedSeats = 0;
                    }
                }
            }
        }
        if (location.equals("back")) {
            outside:
            for (int i = 6; i <= 8; i++) {
                inside:
                for (int j = 0; j < bookings[i].length; j++) {
                    if (bookings[i][j].equals("#")) {
                        unbookedSeats++;
                        bookings[i][j] = "X";
                        if (unbookedSeats == tickets) {
                            break outside;
                        }
                        if (j == bookings[i].length -1) {
                            unbookedSeats = 0;
                            continue outside;
                        }
                    } else {
                        unbookedSeats = 0;
                    }
                }
            }
        }

        if (unbookedSeats == tickets) {
            for (int i = rowPosition; i <= rowPosition; i++) { //row that had required number of seats
                for (int j = lastSeatPosition; j >= 0; j--) { //start from the last seat
                    bookings[i][j] = "X";
                }
            }
            return true;
        }
        return false;
    }
//    public boolean findSimilarConsecutiveSeats(int number) {
//        String[] seats = {"x","#","x","x","#","x","#","#","#","#"};
//        int seatsCounter = 0;
//
//        for (int i = 0; i < seats.length; i++) {
//            if (seats[i].equals("#")) {
//                seatsCounter++;
//                if (seatsCounter == number) {
//                    break;
//                }
//            }
//            else {
//                seatsCounter = 0;
//            }
//        }
//        //Need to be able to get to the next row if there are not enough seats
//
//        System.out.println(seatsCounter);
//        if (seatsCounter == number) {
//
//            return true;
//        }
//        return false;
//    }
    public static void main(String[] args) {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.show();
        System.out.println(cinemaBooking.book(4, "middle"));
        System.out.println(cinemaBooking.book(7, "middle"));
        System.out.println(cinemaBooking.book(9, "middle"));
        cinemaBooking.show();
    }
}

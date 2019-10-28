package booking;

import java.util.Arrays;

public class CinemaBooking {
    public CinemaBooking() {
        this.clear();
    }
    private String[][] bookings = new String[9][8];
    private static final int FRONT_ROW_COST = 25, MIDDLE_ROW_COST = 35, BACK_ROW_COST = 31;
    private int totalCost;

    //checks if a seat is booked
    public boolean isSeat(int row, int seat) {
        return bookings[row][seat].equals("X");
    }

    //books a seat
    public boolean bookSeat(int row, int seat) {
        if (bookings[row][seat].equals("#")) {
            bookings[row][seat] = "X";
            return true;
        }
        return false;
    }

    //shows all seats in the cinema
    public void show() {
        System.out.println("------screen------");
        for (int i = 0; i < bookings.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < bookings[i].length; j++) {
                System.out.print(bookings[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < bookings[8].length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
    }

    //clears all bookings made
    public void clear() {
        for (int i = 0; i < bookings.length; i++) {
            Arrays.fill(bookings[i], "#");
        }
    }

    //shows the income from booked seats
    public int totalIncome() {
        int frontSeats = 0, midSeats = 0, backSeats = 0;

        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < bookings[i].length; j++) {
                if (bookings[i][j].equals("X")) {
                    if (i >= 0 && i <= 2) {
                        frontSeats++;
                    }
                    if (i >= 3 && i <= 5) {
                        midSeats++;
                    }
                    if (i >= 6 && i <= 8) {
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
                if (bookings[i][j].equals("X")) {
                    seatsbooked++;
                }
            }
        }
        return seatsbooked;
    }

    //books number of seats in a specified row
    public boolean book(int tickets, String location) {
        int unbookedSeats = 0, lastSeatPosition = 0, rowPosition = 0, startRow = 0, endRow = 0;;
        if (location.equalsIgnoreCase("front")) {
            startRow = 0; endRow = 2;
        }
        if (location.equalsIgnoreCase("middle")) {
            startRow = 3; endRow = 5;
        }
        if (location.equalsIgnoreCase("back")) {
            startRow = 6; endRow = 8;
        }

        rowLoop:
        for (int i = startRow; i <= endRow; i++) {
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

        if (unbookedSeats == tickets) {
            for (int i = rowPosition; i <= rowPosition; i++) { //row that has required number of seats
                for (int j = lastSeatPosition; j >= 0; j--) { //start from the last seat
                    bookings[i][j] = "X";
                }
            }
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.show();
        System.out.println(cinemaBooking.isSeat(5,4));
        System.out.println(cinemaBooking.book(4, "middle"));
        System.out.println(cinemaBooking.book(7, "middle"));
        System.out.println(cinemaBooking.book(4, "middle"));
        System.out.println(cinemaBooking.book(4, "middle"));
        System.out.println(cinemaBooking.book(1, "middle"));
        System.out.println(cinemaBooking.book(4, "middle"));

        cinemaBooking.show();
    }
}

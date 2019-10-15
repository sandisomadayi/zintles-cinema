package booking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaBookingTest {

    @Test
    void shouldCheckIfASeatIsBookedOrNot() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.bookSeat(4,3);
        cinemaBooking.bookSeat(4,4);
        cinemaBooking.bookSeat(4,6);

        assertEquals(false, cinemaBooking.isSeat(4,5));
    }

    @Test
    void shouldReturnTrue() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(4,3);
        cinemaBooking.bookSeat(4,4);
        cinemaBooking.bookSeat(4,6);

        assertEquals(true, cinemaBooking.isSeat(4,4));
    }

    @Test
    void shouldBookSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(4,3);
        cinemaBooking.bookSeat(4,4);
        cinemaBooking.bookSeat(4,6);

        assertEquals(true, cinemaBooking.bookSeat(5,4));
    }

    @Test
    void shouldShowNumberOfBookedSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(5,4);
        cinemaBooking.bookSeat(6,4);
        cinemaBooking.bookSeat(7,4);
        cinemaBooking.bookSeat(8,4);

        assertEquals(7, cinemaBooking.totalBookings());
    }

    @Test
    void shouldShowZeroBookedSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(5,4);
        cinemaBooking.bookSeat(6,4);
        cinemaBooking.bookSeat(7,4);
        cinemaBooking.bookSeat(8,4);
        cinemaBooking.clear();

        assertEquals(0, cinemaBooking.totalBookings());
    }

    @Test
    void shouldShowCostOfBookedSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(5,4);
        cinemaBooking.bookSeat(6,4);
        cinemaBooking.bookSeat(7,4);
        cinemaBooking.bookSeat(8,4);

        assertEquals(217, cinemaBooking.totalIncome());
    }

    @Test
    void shouldBookSeatsAndReturnTrue() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(1, 1);
        cinemaBooking.bookSeat(2, 2);
        cinemaBooking.bookSeat(3, 3);
        cinemaBooking.bookSeat(5, 4);
        cinemaBooking.bookSeat(6, 4);
        cinemaBooking.bookSeat(7, 4);
        cinemaBooking.bookSeat(8, 4);
        cinemaBooking.book(4, "middle");
        cinemaBooking.book(4, "middle");

        assertEquals(false, cinemaBooking.book(7, "middle"));
    }

    @Test
    void shouldNotBookSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();

        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(5,4);
        cinemaBooking.bookSeat(6,4);
        cinemaBooking.bookSeat(7,4);
        cinemaBooking.bookSeat(8,4);
        cinemaBooking.book(4,"middle");

        assertEquals(true, cinemaBooking.book(7,"middle"));
    }
}

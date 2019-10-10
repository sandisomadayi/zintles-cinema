package booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemaBookingTest {

    @Test
    void shouldReturnFalse() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();

        assertEquals(false, cinemaBooking.isSeat(4,5));
    }

    @Test
    void shouldReturnFalse2() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.bookSeat(4,4);

        assertEquals(false, cinemaBooking.isSeat(4,4));
    }

    @Test
    void shouldBookSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();

        assertEquals(true, cinemaBooking.bookSeat(5,4));
    }

    @Test
    void shouldShowNumberOfBookedSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(4,4);

        assertEquals(4, cinemaBooking.totalBookings());
    }

    @Test
    void shouldShowCostOfBookedSeats() {
        CinemaBooking cinemaBooking = new CinemaBooking();
        cinemaBooking.clear();
        cinemaBooking.bookSeat(1,1);
        cinemaBooking.bookSeat(2,2);
        cinemaBooking.bookSeat(3,3);
        cinemaBooking.bookSeat(4,4);

        assertEquals(110, cinemaBooking.totalIncome());
    }
}

package parking;

import org.junit.Test;
import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_get_ticket_when_park_car_on_one_available_parkinglot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1)));

        Ticket ticket = parkingBoy.parkCar(new Car());

        assertThat(ticket, notNullValue());
    }

    @Test(expected = NotAvailableException.class)
    public void should_throw_exception_when_park_car_on_parkinglot_unavailable() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0)));

        parkingBoy.parkCar(new Car());
    }

    @Test
    public void should_park_car_when_the_secondary_parkinglot_is_available() throws Exception {

        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(1)));

        Ticket ticket = parkingBoy.parkCar(new Car());

        assertThat(ticket, notNullValue());
    }

    @Test
    public void should_park_car_on_first_unailable_when_more_parkinglot_are_available() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(1), new ParkingLot(1)));

        Ticket ticket = parkingBoy.parkCar(new Car());

        assertThat(ticket, notNullValue());

    }

    @Test
    public void should_get_my_car_when_ticket_valid() throws NotAvailableException, InvalidTicketException {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(1)));
        Car myCar = new Car();
        Ticket ticket = parkingBoy.parkCar(myCar);
        Car car = parkingBoy.pickCar(ticket);

        assertThat(car,is(myCar));

    }
}

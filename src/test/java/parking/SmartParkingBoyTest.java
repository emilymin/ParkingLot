package parking;

import org.junit.Test;
import parking.exception.NotAvailableException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    @Test
    public void should_park_car_where_lot_has_most_capacity() throws Exception {
        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));

        smartParkingBoy.parkCar(new Car());

        assertThat(parkingLot_2.getAvailableLot(), is(4));
    }

    @Test(expected = NotAvailableException.class)
    public void should_throw_notAvailable_exception_when_no_capacity_for_all_parking_lot() throws Exception {
        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));

        smartParkingBoy.parkCar(new Car());
        smartParkingBoy.parkCar(new Car());
        smartParkingBoy.parkCar(new Car());
    }
}
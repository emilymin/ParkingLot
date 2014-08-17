package parking;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SmartParkingBoyTest {

    @Test
    public void should_park_car_where_lot_has_most_capacity() throws Exception {
        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));
        Car car = new Car();

        smartParkingBoy.parkCar(car);

        assertThat(parkingLot_2.getAvailableLot(), is(4));
    }
}
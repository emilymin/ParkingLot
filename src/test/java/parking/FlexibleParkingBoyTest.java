package parking;

import org.junit.Test;
import parking.exception.NotAvailableException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlexibleParkingBoyTest {
 
    @Test
    public void should_return_most_available_percent_parkingLot() throws Exception {
        ParkingLot parkingLot_1 = new ParkingLot(2);
        ParkingLot parkingLot_2 = new ParkingLot(3);
        FlexibleParkingBoy flexibleParkingBoy = new FlexibleParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());

        assertThat(flexibleParkingBoy.getMostAvailablePercentParkingLot(), is(parkingLot_2));
    }

    @Test(expected = NotAvailableException.class)
    public void should_throw_NotAvailableException_when_all_parkingLot_not_available() throws Exception {
        ParkingLot parkingLot_1 = new ParkingLot(1);
        ParkingLot parkingLot_2 = new ParkingLot(1);
        FlexibleParkingBoy flexibleParkingBoy = new FlexibleParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
    }
}
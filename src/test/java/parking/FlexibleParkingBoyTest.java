package parking;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlexibleParkingBoyTest {
    private FlexibleParkingBoy flexibleParkingBoy;
    private ParkingLot parkingLot_1;
    private ParkingLot parkingLot_2;

    @Before
    public void setUp() throws Exception {
        parkingLot_1 = new ParkingLot(2);
        parkingLot_2 = new ParkingLot(3);
        flexibleParkingBoy = new FlexibleParkingBoy(Arrays.asList(parkingLot_1, parkingLot_2));
    }

    @Test
    public void testParkCar() throws Exception {

    }

    @Test
    public void shouldReturnMostAvailablePercentParkingLot() throws Exception {
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());
        flexibleParkingBoy.parkCar(new Car());

        assertThat(flexibleParkingBoy.getMostAvailablePercentParkingLot(), is(parkingLot_2));
    }
}
package parking;

import parking.exception.NotAvailableException;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLots;
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    @Override
    public Ticket parkCar(Car car) throws NotAvailableException {
        ParkingLot parkingLot = getMaxCapacityLot();
        return parkingLot.park(car);
    }

    private ParkingLot getMaxCapacityLot(){
        ParkingLot parkingLot = null;
        int capacity = 0;
        for (ParkingLot lot : parkingLots) {
            if (lot.getAvailableLot() > capacity){
                capacity = lot.getAvailableLot();
                parkingLot = lot;
            }
        }
        return parkingLot;
    }
}

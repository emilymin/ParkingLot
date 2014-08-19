package parking;

import parking.exception.NotAvailableException;

import java.util.List;

public class FlexibleParkingBoy extends ParkingBoy{
    private List<ParkingLot> parkingLots;

    public FlexibleParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket parkCar(Car car) throws NotAvailableException {
        ParkingLot parkingLot = getMostAvailablePercentParkingLot();
        return parkingLot.park(car);
    }

    public ParkingLot getMostAvailablePercentParkingLot() throws NotAvailableException {
        ParkingLot myParkingLot = null;
        double percent = 0.0;
        for (ParkingLot parkingLot : parkingLots){
            double parkingPercent = (double)parkingLot.getAvailableLot()/(double)parkingLot.getTicketCarMap().size();
            if (parkingPercent > percent){
                percent = parkingPercent;
                myParkingLot = parkingLot;
            }
        }
        if (myParkingLot == null) throw new NotAvailableException();
        return myParkingLot;
    }
}

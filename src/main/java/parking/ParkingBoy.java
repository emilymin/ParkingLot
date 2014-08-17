package parking;

import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> parkingLotTicketMap;

    public ParkingBoy(List<ParkingLot> parkingLots) {

        this.parkingLots = parkingLots;
        parkingLotTicketMap = new HashMap<Ticket, ParkingLot>();
    }

    public Ticket parkCar(Car car) throws NotAvailableException {
        for (ParkingLot lot : parkingLots) {
            if (lot.available()){
                Ticket ticket = lot.park(car);
                parkingLotTicketMap.put(ticket, lot);
                return ticket;
            }
        }
        throw new NotAvailableException();
    }

    public Car pickCar(Ticket ticket) throws InvalidTicketException {
        ParkingLot parkingLot = parkingLotTicketMap.get(ticket);
        Car car = parkingLot.getCar(ticket);
        if (car != null){
            return car;
        }
        throw new InvalidTicketException();
    }
}

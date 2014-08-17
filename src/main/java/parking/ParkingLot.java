package parking;

import parking.exception.InvalidTicketException;
import parking.exception.NotAvailableException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int availableLot;
    private final Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.availableLot = capacity;
        this.ticketCarMap = new HashMap<Ticket, Car>(capacity);
    }

    public int getAvailableLot() {
        return availableLot;
    }

    public Map<Ticket, Car> getTicketCarMap() {
        return ticketCarMap;
    }

    public Ticket park(Car car) throws NotAvailableException {
        if (!available()) {
            throw new NotAvailableException();
        }
        return doPark(car);
    }

    public boolean available() {
        return availableLot > 0;
    }

    private Ticket doPark(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        availableLot--;
        return ticket;
    }

    public Car getCar(Ticket ticket) throws InvalidTicketException {
        final Car car = ticketCarMap.get(ticket);
        if (car == null) {
            throw new InvalidTicketException();
        }
        return car;
    }
}
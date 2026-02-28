import java.util.*;


public class Reservationsystem {
    private List<Bus> buses = new ArrayList<>();
    private Map<Integer, List<Passenger>> reservations = new HashMap<>();

    public void addBus(Bus bus) {
        buses.add(bus);
        reservations.put(bus.getBusNo(), new ArrayList<>());
    }

    public void displayBuses() {
        System.out.println("\nAvailable Buses:");
        for (Bus bus : buses) {
            bus.displayBusInfo();
        }
    }

    public boolean cancelReservation(int busNo, String passengerName) {
        List<Passenger> passengerList = reservations.get(busNo);
        if (passengerList == null) {
            System.out.println("❌ Bus number not found.");
            return false;
        }

        for (Passenger p : passengerList) {
            if (p.getName().equalsIgnoreCase(passengerName)) {
                passengerList.remove(p);
                System.out.println("✅ Reservation cancelled for " + passengerName + " on Bus " + busNo);
                return true;
            }
        }

        System.out.println("❌ No reservation found for " + passengerName + " on Bus " + busNo);
        return false;
    }

    public void searchBuses(String from, String to) {
        boolean found = false;
        for (Bus bus : buses) {
            if (bus.getFrom().equalsIgnoreCase(from) && bus.getTo().equalsIgnoreCase(to)) {
                bus.displayBusInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No buses found from " + from + " to " + to);
        }
    }

    public boolean reserveSeat(int busNo, Passenger passenger) {
        List<Passenger> passengerList = reservations.get(busNo);
        Bus selectedBus = null;

        for (Bus b : buses) {
            if (b.getBusNo() == busNo) {
                selectedBus = b;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("❌ Bus not found!");
            return false;
        }

        if (passengerList.size() < selectedBus.getCapacity()) {
            passengerList.add(passenger);
            System.out.println("✅ Seat booked successfully for " + passenger.getName());
            System.out.println("🧾 Fare to pay: ₹" + selectedBus.getFare());
            return true;
        } else {
            System.out.println("❌ Bus is full.");
            return false;
        }
    }

    public void showPassengers(int busNo) {
        List<Passenger> passengerList = reservations.get(busNo);
        if (passengerList != null && !passengerList.isEmpty()) {
            System.out.println("Passengers in Bus " + busNo + ":");
            for (Passenger p : passengerList) {
                System.out.println("- " + p.getName() + " (Age: " + p.getAge() + ")");
            }
        } else {
            System.out.println("No bookings found for this bus.");
        }
    }

    // ✅ For GUI use — fetch passengers list
    public List<Passenger> getAllPassengers(int busNo) {
        return reservations.getOrDefault(busNo, new ArrayList<>());
    }

    // ✅ For GUI use — fetch buses list
    public List<Bus> getAllBuses() {
        return buses;
    }
}

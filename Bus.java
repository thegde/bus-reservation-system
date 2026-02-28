public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    private String from;
    private String to;
    private double fare;
    private String time; // e.g. "6:30 AM"

    public Bus(int busNo, boolean ac, int capacity, String from, String to, double fare, String time) {
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.fare = fare;
        this.time = time;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo +
                " | AC: " + (ac ? "Yes" : "No") +
                " | Capacity: " + capacity +
                " | From: " + from +
                " → To: " + to +
                " | Time: " + time +
                " | Fare: ₹" + fare);
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getFare() {
        return fare;
    }

    public String getTime() {
        return time;
    }
}

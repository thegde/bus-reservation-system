import java.util.*;

public class main {
    public static void main(String[] args) {
        Reservationsystem system = new Reservationsystem();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Add some default buses
       // Add some default buses with route info
system.addBus(new Bus(101, true, 40, "Bangalore", "Chennai",500.0,"6.30 Am"));
system.addBus(new Bus(102, false, 35, "Mumbai", "Pune",300.0,"8:00 Am"));
system.addBus(new Bus(103, true, 50, "Delhi", "Jaipur",450.0,"7.30 AM"));
system.addBus(new Bus(104, false, 60, "Hyderabad", "Vijayawada",350,"9:00 AM"));
system.addBus(new Bus(105, true, 45, "Kolkata", "Durgapur",400.0,"5:30 PM"));
system.addBus(new Bus(106, false, 55, "Chandigarh", "Amritsar",350.0,"4:00 Pm"));
system.addBus(new Bus(107, true, 30, "Ahmedabad", "Surat",600.0,"3:30 Pm"));





        while (true) {
            System.out.println("1. View All Buses");
System.out.println("2. Book Seat");
System.out.println("3. View Passengers");
System.out.println("4. Search Buses by Route");
System.out.println("5. Cancel Reservation");
System.out.println("6. Exit");


            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayBuses();
                    break;
                case 2:
                    System.out.print("Enter Bus Number: ");
                    int busNo = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    Passenger p = new Passenger(name, age);
                    system.reserveSeat(busNo, p);
                    break;
                case 3:
                    System.out.print("Enter Bus Number: ");
                    int bNo = scanner.nextInt();
                    system.showPassengers(bNo);
                    break;
                    case 4:
                scanner.nextLine(); // flush input
                 System.out.print("Enter departure city (From): ");
                 String from = scanner.nextLine();
                System.out.print("Enter destination city (To): ");
                String to = scanner.nextLine();
                 system.searchBuses(from, to);
    break;
    case 5:
    System.out.print("Enter Bus Number: ");
    int cancelBusNo = scanner.nextInt();
    scanner.nextLine(); // flush
    System.out.print("Enter Passenger Name to Cancel: ");
    String cancelName = scanner.nextLine();
    system.cancelReservation(cancelBusNo, cancelName);
    break;
case 6:
      
    System.out.println("🚍 Thank you for using the Bus Reservation System!");
    System.exit(0);

    

                
            }
        }
    }
}

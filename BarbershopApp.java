import java.util.*;
import java.time.LocalDateTime;

public class BarbershopApp {
    private static List<Client> clients = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n--- Barbershop App ---");
            System.out.println("1. Register Client");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. List Clients");
            System.out.println("4. List Appointments");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1 -> registerClient();
                case 2 -> scheduleAppointment();
                case 3 -> listClients();
                case 4 -> listAppointments();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }
        } while (option != 0);
    }

    private static void registerClient() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Client client = new Client(name, phone, email);
        clients.add(client);
        System.out.println("Client registered successfully!");
    }

    private static void scheduleAppointment() {
        System.out.print("Client's name: ");
        String clientName = scanner.nextLine();
        Client client = findClientByName(clientName);

        if (client == null) {
            System.out.println("Client not found. Please register first.");
            return;
        }

        System.out.print("Date and time (YYYY-MM-DDTHH:MM): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);

        System.out.print("Service: ");
        String service = scanner.nextLine();

        Appointment appointment = new Appointment(client, dateTime, service);
        appointments.add(appointment);
        System.out.println("Appointment scheduled!");
    }

    private static Client findClientByName(String name) {
        for (Client c : clients) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    private static void listClients() {
        System.out.println("\n--- Clients ---");
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    private static void listAppointments() {
        System.out.println("\n--- Appointments ---");
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}

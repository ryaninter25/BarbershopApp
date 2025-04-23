import java.time.LocalDateTime;

public class Appointment {
    private Client client;
    private LocalDateTime dateTime;
    private String service;

    public Appointment(Client client, LocalDateTime dateTime, String service) {
        this.client = client;
        this.dateTime = dateTime;
        this.service = service;
    }

    public String toString() {
        return "Client: " + client.getName() +
               ", Date: " + dateTime +
               ", Service: " + service;
    }
}

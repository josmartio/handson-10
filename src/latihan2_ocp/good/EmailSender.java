package latihan2_ocp.good;

// Implementation untuk EMAIL channel
public class EmailSender implements NotificationSender {

    // Implement method send()
    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL] Sending to: " + recipient + " | Content: " + message);
    }

    // Implement method getType()
    @Override
    public String getType() {
        return "EMAIL";
    }
}

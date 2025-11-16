package latihan2_ocp.good;

// Implementation untuk SMS channel
public class SmsSender implements NotificationSender {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] Sending to: " + recipient + " | Content: " + message);
    }

    @Override
    public String getType() {
        return "SMS";
    }
}

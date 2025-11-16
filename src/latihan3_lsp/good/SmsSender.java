package latihan3_lsp.good;

// Implementation yang FOLLOWS contract
public class SmsSender extends NotificationSender {

    // 1. Call super("SMS")
    public SmsSender() {
        super("SMS");
    }

    @Override
    public boolean send(String recipient, String message) {
        // 2. Validate preconditions
        if (recipient == null || message == null) {
            return false; // sesuai kontrak LSP
        }

        // 3. Simulate sending
        System.out.println("[SmsSender] ✓ Notification sent to: " + recipient);
        System.out.println("   Content: " + message);

        return true; // sesuai kontrak GOOD
    }
}

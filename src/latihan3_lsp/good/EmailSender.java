package latihan3_lsp.good;

// Implementation yang FOLLOWS contract
public class EmailSender extends NotificationSender {

    // 1. Call super("EMAIL")
    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        // 2. Validate preconditions
        if (recipient == null || message == null) {
            return false; // sesuai kontrak GOOD (tidak boleh throw exception)
        }

        // 3. Simulate sending
        System.out.println("[EmailSender] ✓ Notification sent to: " + recipient);
        System.out.println("   Content: " + message);

        return true; // sesuai kontrak: return true jika berhasil
    }
}

package latihan3_lsp.bad;

// Implementation yang BENAR - follows parent contract
public class EmailSender extends NotificationSender {

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        // Implementasi yang proper - benar-benar mengikuti kontrak di superclass
        System.out.println("✓ Notification sent via EMAIL to " + recipient);
        System.out.println("   Content: " + message);
        return true; // mengikuti kontrak dengan baik
    }
}

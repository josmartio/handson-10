package latihan1_srp.bad;

// Class ini MELANGGAR SRP karena memiliki terlalu banyak tanggung jawab
public class NotificationService {

    public NotificationService() {
    }

    public void sendNotification(String message, String type, String recipient) {
        // 1. Validasi message
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        // 2. Format message
        String formattedMessage = message.toUpperCase() + " [SENT AT: " +
                System.currentTimeMillis() + "]";

        // 3. Kirim berdasarkan type (EMAIL atau SMS)
        if (type.equalsIgnoreCase("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        } else if (type.equalsIgnoreCase("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + formattedMessage);
        } else {
            System.out.println("Unsupported notification type: " + type);
        }

        // 4. Logging
        System.out.println("LOG: Notification sent - Type: " + type);

        // 5. Simpan ke database
        System.out.println("DB: Saving notification record...");
    }
}

package latihan2_ocp.bad;

// Class ini MELANGGAR OCP karena setiap channel baru harus modify code ini
public class NotificationService {

    public void sendNotification(String message, String type, String recipient) {

        // Masalah: If-else chain yang terus bertambah
        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + message);

        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + message);

        } else if (type.equals("WHATSAPP")) {   // Tambahan
            System.out.println("Sending WhatsApp to: " + recipient);
            System.out.println("Content: " + message);

        } else if (type.equals("TELEGRAM")) {   // Tambahan
            System.out.println("Sending Telegram message to: " + recipient);
            System.out.println("Content: " + message);

        } else {
            System.out.println("Unknown notification type!");
        }

        // Setiap channel baru harus tambah else-if baru → MELANGGAR OCP
    }
}

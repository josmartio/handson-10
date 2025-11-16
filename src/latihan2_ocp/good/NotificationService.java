package latihan2_ocp.good;

import java.util.List;

// Service yang MENGIKUTI OCP
// Class ini TIDAK PERLU DIMODIFIKASI ketika ada channel baru
public class NotificationService {

    private List<NotificationSender> senders;

    // Menerima list NotificationSender via constructor
    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    // Loop through semua senders dan panggil send()
    public void sendNotification(String message, String recipient) {
        for (NotificationSender sender : senders) {
            sender.send(recipient, message);
        }
    }
}

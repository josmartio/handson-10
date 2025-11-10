package latihan1_srp.good;

// TANGGUNG JAWAB 4: Kirim SMS
public class SmsSender {

    // Method send untuk mengirim SMS
    public void send(String recipient, String message) {
        System.out.println("[SmsSender] Sending SMS to: " + recipient);
        System.out.println("[SmsSender] Content: " + message);
    }
}

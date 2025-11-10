package latihan1_srp.good;

// TANGGUNG JAWAB 3: Kirim email
public class EmailSender {

    // Method send untuk mengirim email
    public void send(String recipient, String message) {
        System.out.println("[EmailSender] Sending EMAIL to: " + recipient);
        System.out.println("[EmailSender] Content: " + message);
    }
}

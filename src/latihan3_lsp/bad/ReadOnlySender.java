package latihan3_lsp.bad;

// Implementation yang MELANGGAR LSP
// Class ini throw exception padahal parent expect send() to work
public class ReadOnlySender extends NotificationSender {

    public ReadOnlySender() {
        super("READONLY");
    }

    @Override
    public boolean send(String recipient, String message) {
        // MASALAH 1: Throw exception - TIDAK mengikuti kontrak parent class
        // Parent class mengharapkan "send()" mengembalikan boolean, BUKAN error.
        throw new UnsupportedOperationException("This sender is read-only!");

        // MASALAH 2: Tidak bisa disubstitusi dengan NotificationSender
        // Kode yang menggunakan NotificationSender akan crash saat memakai ReadOnlySender.
    }
}

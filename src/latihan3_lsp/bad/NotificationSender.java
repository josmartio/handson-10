package latihan3_lsp.bad;

// Parent class untuk semua notification sender
// Masalah: Kontrak tidak jelas, memungkinkan subclass melanggar LSP
public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    // Method yang HARUS diimplementasikan oleh subclass,
    // tapi return boolean MEMBUAT subclass bebas melanggar kontrak.
    // Ini yang menyebabkan LSP VIOLATION.
    public abstract boolean send(String recipient, String message);

    // Tidak ada masalah besar di sini, tapi tetap bagian dari desain buruk.
    public String getType() {
        return senderName;
    }
}

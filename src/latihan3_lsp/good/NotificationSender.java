package latihan3_lsp.good;

// Parent class dengan CLEAR CONTRACT
// Semua subclass HARUS follow contract ini
public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    /*
     * Method send() dengan clear contract:
     *
     * Precondition:
     * - recipient tidak boleh null
     * - message tidak boleh null
     *
     * Postcondition:
     * - Return true jika berhasil kirim notification
     * - Return false jika gagal (TANPA throw exception)
     * - Subclass HARUS mengikuti kontrak ini
     *
     * Dengan kontrak jelas → TIDAK melanggar LSP.
     */
    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}

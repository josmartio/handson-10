package latihan1_srp.good;

// TANGGUNG JAWAB 2: Format message
public class MessageFormatter {

    // Method format untuk memformat message
    public String format(String message) {
        String formatted = message.toUpperCase() + " [SENT AT: " +
                System.currentTimeMillis() + "]";
        System.out.println("[Formatter] Message formatted: " + formatted);
        return formatted;
    }
}

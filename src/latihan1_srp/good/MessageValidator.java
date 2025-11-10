package latihan1_srp.good;

// TANGGUNG JAWAB 1: Validasi message
public class MessageValidator {

    // Method validate untuk memeriksa message
    public boolean validate(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("[Validator] Message validation failed: null or empty");
            return false;
        }
        System.out.println("[Validator] Message validated successfully");
        return true;
    }
}

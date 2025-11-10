package latihan1_srp;

import java.time.Instant;

public class SRPPractice {

    // ===== BAD PRACTICE =====
    static class BadNotificationService {
        public void sendNotification(String message, String type, String recipient) {
            // Validasi
            if (message == null || message.trim().isEmpty()) {
                System.out.println("[BAD] Message invalid!");
                return;
            }

            // Format message
            String formatted = message.toUpperCase() + " [SENT AT: " + Instant.now().getEpochSecond() + "]";

            // Kirim notification
            if (type.equalsIgnoreCase("EMAIL")) {
                System.out.println("[BAD] Sending EMAIL to: " + recipient);
                System.out.println("[BAD] Content: " + formatted);
            } else if (type.equalsIgnoreCase("SMS")) {
                System.out.println("[BAD] Sending SMS to: " + recipient);
                System.out.println("[BAD] Content: " + formatted);
            } else {
                System.out.println("[BAD] Unknown notification type!");
            }

            // Logging
            System.out.println("[BAD] LOG: Notification sent - Type: " + type);

            // Simpan ke "database"
            System.out.println("[BAD] DB: Saving notification record...");
        }
    }

    // ===== GOOD PRACTICE =====
    static class MessageValidator {
        public boolean validate(String message) {
            if (message == null || message.trim().isEmpty()) {
                System.out.println("[Validator] Message is invalid!");
                return false;
            }
            System.out.println("[Validator] Message validated successfully");
            return true;
        }
    }

    static class MessageFormatter {
        public String format(String message) {
            String formatted = message.toUpperCase() + " [SENT AT: " + Instant.now().getEpochSecond() + "]";
            System.out.println("[Formatter] Message formatted: " + formatted);
            return formatted;
        }
    }

    static class EmailSender {
        public void send(String recipient, String message) {
            System.out.println("[EmailSender] Sending EMAIL to: " + recipient);
            System.out.println("[EmailSender] Content: " + message);
        }
    }

    static class SmsSender {
        public void send(String recipient, String message) {
            System.out.println("[SmsSender] Sending SMS to: " + recipient);
            System.out.println("[SmsSender] Content: " + message);
        }
    }

    static class NotificationLogger {
        public void log(String type, String recipient) {
            System.out.println("[Logger] LOG: Notification sent - Type: " + type);
        }
    }

    static class NotificationRepository {
        public void save(String type, String recipient, String message) {
            System.out.println("[Repository] DB: Saving notification record...");
        }
    }

    static class NotificationService {
        private final MessageValidator validator;
        private final MessageFormatter formatter;
        private final EmailSender emailSender;
        private final SmsSender smsSender;
        private final NotificationLogger logger;
        private final NotificationRepository repository;

        public NotificationService(MessageValidator validator,
                                   MessageFormatter formatter,
                                   EmailSender emailSender,
                                   SmsSender smsSender,
                                   NotificationLogger logger,
                                   NotificationRepository repository) {
            this.validator = validator;
            this.formatter = formatter;
            this.emailSender = emailSender;
            this.smsSender = smsSender;
            this.logger = logger;
            this.repository = repository;
        }

        public void sendNotification(String message, String type, String recipient) {
            if (!validator.validate(message)) return;

            String formattedMessage = formatter.format(message);

            switch (type.toUpperCase()) {
                case "EMAIL" -> emailSender.send(recipient, formattedMessage);
                case "SMS" -> smsSender.send(recipient, formattedMessage);
                default -> System.out.println("Unknown notification type!");
            }

            logger.log(type, recipient);
            repository.save(type, recipient, formattedMessage);
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        // --- BAD PRACTICE ---
        System.out.println("=== BAD PRACTICE: Melanggar SRP ===\n");
        BadNotificationService badService = new BadNotificationService();
        badService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("NotificationService memiliki TERLALU BANYAK tanggung jawab:");
        System.out.println("1. Validasi message");
        System.out.println("2. Format message");
        System.out.println("3. Kirim via EMAIL");
        System.out.println("4. Kirim via SMS");
        System.out.println("5. Logging");
        System.out.println("6. Simpan ke database");
        System.out.println("\nSatu class, BANYAK alasan untuk berubah = MELANGGAR SRP!");
        System.out.println("\n" + "=".repeat(70));

        // --- GOOD PRACTICE ---
        System.out.println("\n=== GOOD PRACTICE: Mengikuti SRP ===\n");
        MessageValidator validator = new MessageValidator();
        MessageFormatter formatter = new MessageFormatter();
        EmailSender emailSender = new EmailSender();
        SmsSender smsSender = new SmsSender();
        NotificationLogger logger = new NotificationLogger();
        NotificationRepository repository = new NotificationRepository();

        NotificationService goodService = new NotificationService(
                validator, formatter, emailSender, smsSender, logger, repository
        );

        goodService.sendNotification("Hello World", "EMAIL", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Easy to understand - Setiap class punya fokus jelas");
        System.out.println("✓ Easy to test - Bisa test setiap komponen terpisah");
        System.out.println("✓ Easy to maintain - Perubahan di satu area tidak affect yang lain");
        System.out.println("✓ Reusable - MessageFormatter bisa dipakai di tempat lain");
        System.out.println("✓ Low coupling - Komponen tidak saling bergantung berlebihan");
    }
}

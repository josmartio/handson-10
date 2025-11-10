package latihan1_srp.good;

// TANGGUNG JAWAB 7: Orchestration (koordinasi semua class)
public class NotificationService {

    private final MessageValidator validator;
    private final MessageFormatter formatter;
    private final EmailSender emailSender;
    private final SmsSender smsSender;
    private final NotificationLogger logger;
    private final NotificationRepository repository;

    // Menerima semua dependencies via constructor
    public NotificationService(
            MessageValidator validator,
            MessageFormatter formatter,
            EmailSender emailSender,
            SmsSender smsSender,
            NotificationLogger logger,
            NotificationRepository repository
    ) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    // Mengkoordinasikan semua class untuk mengirim notification
    public void sendNotification(String message, String type, String recipient) {
        // 1. Validate
        if (!validator.validate(message)) {
            return;
        }

        // 2. Format
        String formattedMessage = formatter.format(message);

        // 3. Send based on type
        switch (type.toUpperCase()) {
            case "EMAIL":
                emailSender.send(recipient, formattedMessage);
                break;
            case "SMS":
                smsSender.send(recipient, formattedMessage);
                break;
            default:
                System.out.println("Unsupported notification type: " + type);
                return;
        }

        // 4. Log
        logger.log(type, recipient);

        // 5. Save to database
        repository.save(type, recipient, formattedMessage);
    }
}

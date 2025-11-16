package latihan2_ocp.good;

// Interface untuk abstraksi notification sender
// Dengan interface, kita bisa extend dengan implementation baru
// tanpa modify existing code
public interface NotificationSender {

    // Interface ini harus punya:
    // 1. Method send(String recipient, String message)
    // 2. Method getType() yang return String (untuk identifikasi channel)

    void send(String recipient, String message);
    String getType();
}

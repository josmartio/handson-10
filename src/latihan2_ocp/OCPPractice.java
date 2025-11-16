package latihan2_ocp;

import latihan2_ocp.good.NotificationService; // import versi GOOD
import latihan2_ocp.good.NotificationSender;
import latihan2_ocp.good.EmailSender;
import latihan2_ocp.good.SmsSender;
import latihan2_ocp.good.WhatsAppSender;

import java.util.ArrayList;
import java.util.List;

public class OCPPractice {
    public static void main(String[] args) {

        /*
         * LATIHAN 2: OPEN/CLOSED PRINCIPLE (OCP)
         */

        // ===== PART 1: BAD PRACTICE - Melanggar OCP =====
        System.out.println("=== BAD PRACTICE: Melanggar OCP ===\n");

        // NOTE: menggunakan fully-qualified name untuk versi "bad" supaya tidak conflict
        latihan2_ocp.bad.NotificationService badService = new latihan2_ocp.bad.NotificationService();
        badService.sendNotification("Hello", "EMAIL", "user@example.com");
        badService.sendNotification("Hello", "SMS", "081234567890");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Bagaimana kalau kita ingin menambah channel baru (WhatsApp)?");
        System.out.println("❌ Harus modify method sendNotification()");
        System.out.println("❌ Harus tambah else if baru");
        System.out.println("❌ Risk merusak existing functionality");
        System.out.println("❌ Setiap channel baru = modify existing code");
        System.out.println("\nIni MELANGGAR OCP: tidak bisa extend tanpa modify!");

        // kompatibel dengan semua JDK: buat pembatas manual
        System.out.println();
        System.out.println(repeatChar('=', 70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti OCP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti OCP ===\n");

        // Setup senders (dependency injection)
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());
        senders.add(new WhatsAppSender()); // tambah channel baru tanpa modify NotificationService

        NotificationService goodService = new NotificationService(senders);
        goodService.sendNotification("Hello", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Extensible - Mudah tambah channel baru");
        System.out.println("✓ Stable - Code existing tidak dimodifikasi");
        System.out.println("✓ Safe - Risiko bug di fitur existing sangat kecil");
        System.out.println("✓ Scalable - Bisa unlimited channels");
        System.out.println("\nMenambah WhatsAppSender:");
        System.out.println("  → Buat class baru WhatsAppSender");
        System.out.println("  → Add ke list senders");
        System.out.println("  → ZERO modification ke NotificationService");
    }

    // helper: ulangi char n kali (agar tidak pakai String.repeat agar kompatibel JDK8+)
    private static String repeatChar(char c, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) sb.append(c);
        return sb.toString();
    }
}

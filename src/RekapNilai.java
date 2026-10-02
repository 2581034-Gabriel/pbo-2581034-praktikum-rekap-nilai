import java.util.Scanner;

// Praktikum 5 — Rekap Nilai Kelas (PBO, Pertemuan 6: Control Flow Statements)
public class RekapNilai {

    // Sentinel: penanda "sudah selesai", bukan nilai kelas.
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int nilai;           // nilai yang sedang dibaca
        int jumlahSah = 0;   // pencacah: hanya naik kalau nilainya diterima

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik " + SELESAI + " kalau sudah selesai.");

        // do-while lebih pas daripada while: nilai pertama harus diminta dulu sebelum ada yang bisa dinilai.
        do {
            System.out.print("Nilai ke-" + (jumlahSah + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue; // bukan nilai kelas: lompat ke kondisi while, di situ loop berhenti
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak — nilai harus 0..100");
                continue; // lompat ke kondisi while; jumlahSah tidak naik, jadi nomor yang diminta tetap sama
            }

            // Ladder if / else if / else — dicek dari atas dan berhenti di cabang pertama yang true.
            // Catatan percobaan urutan dibalik (nilai >= 60 ditaruh paling atas, sudah dijalankan):
            // nilai 85 jadi Grade D — Kurang, bukan B — Baik. Sebab 85 >= 60 sudah true di cabang pertama,
            // jadi cabang >= 90, >= 80, dan >= 70 tidak pernah dicek. Semua nilai >= 60 berakhir di D,
            // dan grade A, B, C tidak akan pernah muncul. Karena itu urutan harus dari syarat paling ketat.
            char grade;
            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            }  if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            // Keterangan grade: switch lambda (Java 14+), tanpa break dan tanpa fall-through.
            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 85'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default  -> "Tidak Lulus";
            };

            System.out.println("  Grade " + grade + " — " + keterangan);

            jumlahSah++;      // baru naik setelah nilai lolos semua pengecekan
        } while (nilai != SELESAI);

        System.out.println();
        System.out.println("Nilai sah   : " + jumlahSah);

        input.close();
    }
}
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

            System.out.println("  nilai diterima"); // sementara, grade ditambahkan di commit 2
            jumlahSah++;
        } while (nilai != SELESAI);

        System.out.println();
        System.out.println("Nilai sah   : " + jumlahSah);

        input.close();
    }
}
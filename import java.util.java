import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    String alamat;
    String kelas;

    Mahasiswa(String nim, String nama, String alamat, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.kelas = kelas;
    }

    public String toString() {
        return "NIM   : " + nim + "\n" +
               "Nama  : " + nama + "\n" +
               "Alamat: " + alamat + "\n" +
               "Kelas : " + kelas + "\n";
    }
}

public class MenuMahasiswa {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = input.nextInt();
            input.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
    }

    static void tambahData() {
        String nim, nama, alamat, kelas;

        // Validasi NIM
        do {
            System.out.print("Masukkan NIM (11 digit): ");
            nim = input.nextLine();
            if (!nim.matches("\\d{11}")) {
                System.out.println(" NIM harus 11 digit angka.");
            }
        } while (!nim.matches("\\d{11}"));

        // Validasi Nama
        do {
            System.out.print("Masukkan Nama (minimal 6 karakter): ");
            nama = input.nextLine();
            if (nama.length() < 6) {
                System.out.println(" Nama harus minimal 6 karakter.");
            }
        } while (nama.length() < 6);

        // Validasi Alamat
        do {
            System.out.print("Masukkan Alamat (minimal 10 karakter): ");
            alamat = input.nextLine();
            if (alamat.length() < 10) {
                System.out.println(" Alamat harus minimal 10 karakter.");
            }
        } while (alamat.length() < 10);

        // Validasi Kelas
        do {
            System.out.print("Masukkan Kelas (TI23 / TI24): ");
            kelas = input.nextLine().toUpperCase();
            if (!kelas.equals("TI23") && !kelas.equals("TI24")) {
                System.out.println(" Kelas hanya boleh TI23 atau TI24.");
            }
        } while (!kelas.equals("TI23") && !kelas.equals("TI24"));

        daftarMahasiswa.add(new Mahasiswa(nim, nama, alamat, kelas));
        System.out.println(" Data berhasil ditambahkan.");
    }

    static void tampilkanData() {
        System.out.println("\n=== DAFTAR MAHASISWA ===");
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data.");
        } else {
            for (int i = 0; i < daftarMahasiswa.size(); i++) {
                System.out.println("Mahasiswa ke-" + (i + 1));
                System.out.println(daftarMahasiswa.get(i));
            }
        }
    }
}

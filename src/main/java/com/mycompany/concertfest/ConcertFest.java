import java.util.Scanner;

public class ConcertFest {
    public static void cariTiket(String kataKunci, TiketKonser[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Teks: \"" + kataKunci + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getKodeTiket().equalsIgnoreCase(kataKunci) || 
                daftar[i].getNamaKonser().toLowerCase().contains(kataKunci.toLowerCase())) {
                daftar[i].tampilkanInfo(); 
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tiket konser dengan kata kunci tersebut tidak ditemukan.");
        }
    }

    public static void cariTiket(double maxHarga, TiketKonser[] daftar, int total) {
        System.out.printf("%n--- Hasil Pencarian Tiket <= Rp %,10.2f ---%n", maxHarga);
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getHargaDasar() <= maxHarga) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada tiket konser di bawah budget tersebut.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TiketKonser[] daftarTiket = new TiketKonser[20]; 
        int totalTiket = 0;
        boolean isRunning = true;

        daftarTiket[totalTiket++] = new TiketFestival("TKT-COLD-FEST", "Coldplay Music of the Spheres Tour", 2500000, "Festival Standing (Front Zone)");
        daftarTiket[totalTiket++] = new TiketVIP("TKT-IU-VIP", "IU HEREH World Tour", 3800000, "VIP-12", "Soundcheck Pass & Official Photocard");
        daftarTiket[totalTiket++] = new TiketFestival("TKT-BM-FEST", "Bruno Mars Live in Concert", 1750000, "Festival B (Standing Ground)");
        daftarTiket[totalTiket++] = new TiketVIP("TKT-TS-VIP", "Taylor Swift The Eras Tour", 6500000, "VIP-08", "Early Entry & Exclusive VIP Merch Pack");

        System.out.println("==================================================");
        System.out.println("      SISTEM MANAJEMEN TIKET KONSER MUSIK        ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Transaksi Tiket Baru");
            System.out.println("2. Tampilkan Seluruh Data Tiket Terjual");
            System.out.println("3. Cari Tiket Konser");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1 -> {
                    if (totalTiket < daftarTiket.length) {
                        System.out.println("\nPilih Kategori Tiket:");
                        System.out.println("1. Tiket Festival (Standing)");
                        System.out.println("2. Tiket VIP (Seating + Benefit)");
                        System.out.print("Pilihan (1/2): ");
                        int kategori = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Kode Tiket    : ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Konser   : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Harga Tiket   : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        switch (kategori) {
                            case 1 -> {
                                System.out.print("Masukkan Zona Berdiri  : ");
                                String zona = scanner.nextLine();
                                daftarTiket[totalTiket++] = new TiketFestival(kode, nama, harga, zona);
                                System.out.println("[SUKSES] Tiket Festival berhasil ditambahkan!");
                            }
                            case 2 -> {
                                System.out.print("Masukkan Nomor Kursi   : ");
                                String kursi = scanner.nextLine();
                                System.out.print("Masukkan Bonus Benefit: ");
                                String bonus = scanner.nextLine();
                                daftarTiket[totalTiket++] = new TiketVIP(kode, nama, harga, kursi, bonus);
                                System.out.println("[SUKSES] Tiket VIP berhasil ditambahkan!");
                            }
                            default -> System.out.println("[ERROR] Kategori tiket tidak valid!");
                        }
                    } else {
                        System.out.println("[ERROR] Kapasitas sistem tiket penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n======================== DAFTAR TIKET TERJUAL ========================");
                    if (totalTiket == 0) {
                        System.out.println("Belum ada data tiket.");
                    } else {
                        for (int i = 0; i < totalTiket; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarTiket[i].tampilkanInfo();
                        }
                    }
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Total Objek Tiket Dibuat: " + TiketKonser.totalTiketTerjual);
                }

                case 3 -> {
                    System.out.println("\n---------- FITUR PENCARIAN TIKET  ----------");
                    System.out.println("1. Cari berdasarkan Kode Tiket / Nama Konser");
                    System.out.println("2. Cari berdasarkan Budget Maksimal Harga");
                    System.out.print("Pilih Mode (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();

                switch (mode) {
                    case 1 -> {
                        System.out.print("Masukkan Kode / Nama Konser: ");
                        String kataKunci = scanner.nextLine();
                        cariTiket(kataKunci, daftarTiket, totalTiket);
                    }
                    case 2 -> {
                        System.out.print("Masukkan Budget Maksimal Harga Tiket: ");
                        double hargaMax = scanner.nextDouble();
                        scanner.nextLine();
                        cariTiket(hargaMax, daftarTiket, totalTiket);
                    }
                    default -> System.out.println("Mode pencarian tidak valid.");
                }
                }

                case 4 -> {
                    System.out.println("\nTerima kasih telah menggunakan Sistem Tiket Konser!");
                    isRunning = false;
                }

                default -> System.out.println("\n[ERROR] Pilihan menu tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
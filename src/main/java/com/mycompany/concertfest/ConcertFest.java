import java.util.Scanner;

public class ConcertFest {

    public static void prosesSimulasiCheckIn(TiketKonser item) {
        System.out.println("\n--- PROSES SIMULASI CHECK-IN TIKET ---");
        item.tampilkanInfo();     
        item.cetakTiketFisik();  
    }

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
        if (!ditemukan) System.out.println("Tiket tidak ditemukan.");
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
        if (!ditemukan) System.out.println("Tidak ada tiket di bawah budget tersebut.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TiketKonser[] daftarTiket = new TiketKonser[20]; 
        int totalTiket = 0;
        boolean isRunning = true;

        daftarTiket[totalTiket++] = new TiketVIP("TKT-IU-VIP", "IU HEREH World Tour", 3800000, "VIP-12", "Soundcheck Pass + Official Photocard");
        daftarTiket[totalTiket++] = new TiketFestival("TKT-BM-FEST", "Bruno Mars Live in Concert", 1750000, "Festival B (Standing Ground)");
        daftarTiket[totalTiket++] = new TiketCAT("TKT-CP-CAT3", "Coldplay Music of the Spheres", 1250000, "CAT 3 (Numbered Seating)");
        daftarTiket[totalTiket++] = new TiketCAT("TKT-SO7-CAT1", "Sheila on 7 Tunggu Aku Di", 450000, "CAT 1 (Tribun Lower Deck)");

        System.out.println("==================================================");
        System.out.println("         SISTEM MANAJEMEN TIKET KONSER MUSIK      ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--------- MENU UTAMA ---------");
            System.out.println("1. Tambah Transaksi Tiket Baru");
            System.out.println("2. Tampilkan Seluruh Data Tiket Terjual");
            System.out.println("3. Cari Tiket Konser");
            System.out.println("4. Simulasi Check-In Gate");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (totalTiket < daftarTiket.length) {
                        System.out.println("\nPilih Kategori Tiket:");
                        System.out.println("1. Tiket VIP (Seating + Benefit)");
                        System.out.println("2. Tiket Festival (Standing)");
                        System.out.println("3. Tiket CAT / Tribun (Seating Standar)");
                        System.out.print("Pilihan (1/2/3): ");
                        int kat = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Kode Tiket    : ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan Nama Konser   : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Harga Tiket   : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();

                        switch (kat) {
                            case 1 -> {
                                System.out.print("Masukkan Nomor Kursi   : ");
                                String kursi = scanner.nextLine();
                                System.out.print("Masukkan Bonus Benefit : ");
                                String bonus = scanner.nextLine();
                                daftarTiket[totalTiket++] = new TiketVIP(kode, nama, harga, kursi, bonus);
                            }
                            case 2 -> {
                                System.out.print("Masukkan Zona Berdiri  : ");
                                String zona = scanner.nextLine();
                                daftarTiket[totalTiket++] = new TiketFestival(kode, nama, harga, zona);
                            }
                            case 3 -> {
                                System.out.print("Masukkan Nomor Tribun  : ");
                                String tribun = scanner.nextLine();
                                daftarTiket[totalTiket++] = new TiketCAT(kode, nama, harga, tribun);
                            }
                            default -> {
                            }
                        }
                        System.out.println("[SUKSES] Tiket berhasil ditambahkan!");
                    } else {
                        System.out.println("[ERROR] Array Penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n================================== DAFTAR TIKET  ==================================");
                    for (int i = 0; i < totalTiket; i++) {
                        System.out.print((i + 1) + ". ");
                        daftarTiket[i].tampilkanInfo(); 
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("Total Tiket Terjual (Static Counter): " + TiketKonser.totalTiketTerjual);
                }

                case 3 -> {
                    System.out.println("\n--------- PENCARIAN TIKET ---------");
                    System.out.println("1. Cari Berdasarkan Kode / Nama Konser");
                    System.out.println("2. Cari Berdasarkan Budget Maksimal");
                    System.out.print("Pilih Mode (1/2): ");
                    int mode = scanner.nextInt();
                    scanner.nextLine();

                    if (mode == 1) {
                        System.out.print("Masukkan Kode / Nama Konser: ");
                        cariTiket(scanner.nextLine(), daftarTiket, totalTiket);
                    } else if (mode == 2) {
                        System.out.print("Masukkan Budget Maksimal: ");
                        cariTiket(scanner.nextDouble(), daftarTiket, totalTiket);
                        scanner.nextLine();
                    }
                }

                case 4 -> {
                    System.out.println("\n--------- SIMULASI CHECK-IN ---------");
                    System.out.print("Masukkan Nomor Urut Tiket (1-" + totalTiket + "): ");
                    int idx = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (idx >= 0 && idx < totalTiket) {
                        prosesSimulasiCheckIn(daftarTiket[idx]); 
                    } else {
                        System.out.println("Nomor tiket tidak valid!");
                    }
                }

                case 5 -> {
                    System.out.println("\nTerima kasih!");
                    isRunning = false;
                }

                default -> System.out.println("\n[ERROR] Pilihan menu tidak valid.");
            }
        }
        scanner.close();
    }
}
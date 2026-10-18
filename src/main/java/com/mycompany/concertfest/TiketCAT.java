public class TiketCAT extends TiketKonser implements DapatDisimpan {
    private String nomorTribun; 

    public TiketCAT(String kodeTiket, String namaKonser, double hargaDasar, String nomorTribun) {
        super(kodeTiket, namaKonser, hargaDasar);
        this.nomorTribun = nomorTribun;
    }

    public String getNomorTribun() { return this.nomorTribun; }
    public void setNomorTribun(String nomorTribun) { this.nomorTribun = nomorTribun; }

    @Override
    public void tampilkanInfo() {
        System.out.print("[ TRIBUN/CAT] ");
        super.tampilkanInfo();
        System.out.printf(" | Lokasi: %s (Kategori Seating Standar)%n", this.nomorTribun);
    }

    @Override
    public void cetakTiketFisik() {
        System.out.println("-> E-Ticket QR Code dicetak di Mesin Mandiri Gate Tribun.");
    }

    @Override
    public void hitungBiayaLayanan() {
        System.out.println("Biaya Layanan CAT/Tribun: Rp 15.000");
    }

    @Override
    public void simpanKeWallet() {
        System.out.println("Tiket CAT berhasil disimpan ke Wallet.");
    }
}
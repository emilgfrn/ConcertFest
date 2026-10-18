public class TiketVIP extends TiketKonser implements DapatDirefund, DapatDisimpan {
    private String nomorKursi;
    private String bonusMerch;

    public TiketVIP(String kodeTiket, String namaKonser, double hargaDasar, String nomorKursi, String bonusMerch) {
        super(kodeTiket, namaKonser, hargaDasar);
        this.nomorKursi = nomorKursi;
        this.bonusMerch = bonusMerch;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[ V I P    ] ");
        super.tampilkanInfo();
        System.out.printf(" | Kursi: %-4s | Benefit: %s%n", this.nomorKursi, this.bonusMerch);
    }

    @Override
    public void cetakTiketFisik() {
        System.out.println("-> Wristband VIP dicetak + Pengambilan/Klaim benefit '" + this.bonusMerch + "' di Desk Khusus VIP.");
    }

    @Override
    public void hitungBiayaLayanan() {
        System.out.println("Biaya Layanan VIP: Rp 50.000 (Termasuk Fast Track & VIP Lounge)");
    }

    @Override
    public void ajukanRefund(String alasan) {
        System.out.println("Refund Tiket VIP BERHASIL disetujui 100% full amount. Alasan: " + alasan);
    }

    @Override
    public void simpanKeWallet() {
        System.out.println("Tiket VIP berhasil disimpan ke Wallet.");
    }
}
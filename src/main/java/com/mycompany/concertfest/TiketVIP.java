public class TiketVIP extends TiketKonser {
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
        System.out.println("-> [AKSI] Wristband VIP dicetak + Pengambilan/Klaim benefit '" + this.bonusMerch + "' di Desk Khusus VIP.");
    }
}
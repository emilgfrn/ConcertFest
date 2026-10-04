public class TiketVIP extends TiketKonser {
    private String nomorKursi;
    private String bonusMerch; 

    public TiketVIP(String kodeTiket, String namaKonser, double hargaDasar, String nomorKursi, String bonusMerch) {
        super(kodeTiket, namaKonser, hargaDasar);
        this.nomorKursi = nomorKursi;
        this.bonusMerch = bonusMerch;
    }

    public String getNomorKursi() {
        return this.nomorKursi;
    }

    public void setNomorKursi(String nomorKursi) {
        this.nomorKursi = nomorKursi;
    }

    public String getBonusMerch() {
        return this.bonusMerch;
    }

    public void setBonusMerch(String bonusMerch) {
        this.bonusMerch = bonusMerch;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.print("[ V I P    ] ");
        super.tampilkanInfo();
        System.out.printf(" | Kursi: %-4s | Benefit: %s%n", this.nomorKursi, this.bonusMerch);
    }
}
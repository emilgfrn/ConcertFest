public class TiketKonser {
    private String kodeTiket;
    private String namaKonser;
    private double hargaDasar;

    public static int totalTiketTerjual = 0;

    public TiketKonser(String kodeTiket, String namaKonser, double hargaDasar) {
        this.kodeTiket = kodeTiket;
        this.namaKonser = namaKonser;
        setHargaDasar(hargaDasar);
        totalTiketTerjual++;
    }

    public String getKodeTiket() { return this.kodeTiket; }
    public void setKodeTiket(String kodeTiket) { this.kodeTiket = kodeTiket; }

    public String getNamaKonser() { return this.namaKonser; }
    public void setNamaKonser(String namaKonser) { this.namaKonser = namaKonser; }

    public double getHargaDasar() { return this.hargaDasar; }
    public void setHargaDasar(double hargaDasar) {
        if (hargaDasar > 0) {
            this.hargaDasar = hargaDasar;
        } else {
            this.hargaDasar = 200000;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Kode: %-6s | Konser: %-22s | Harga: Rp %,10.2f", 
                          this.kodeTiket, this.namaKonser, this.hargaDasar);
    }

    public void cetakTiketFisik() {
        System.out.println("-> Mencetak tiket standar di gate masuk.");
    }
}
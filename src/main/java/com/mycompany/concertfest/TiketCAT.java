public class TiketCAT extends TiketKonser {
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
        System.out.println("-> [AKSI] E-Ticket QR Code dicetak di Mesin Mandiri Gate Tribun.");
    }
}
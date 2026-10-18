public class TiketFestival extends TiketKonser implements DapatDirefund {
    private String zonaBerdiri;

    public TiketFestival(String kodeTiket, String namaKonser, double hargaDasar, String zonaBerdiri) {
        super(kodeTiket, namaKonser, hargaDasar);
        this.zonaBerdiri = zonaBerdiri;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[ FESTIVAL ] ");
        super.tampilkanInfo();
        System.out.printf(" | Zona: %s%n", this.zonaBerdiri);
    }

    @Override
    public void cetakTiketFisik() {
        System.out.println("-> Wristband Festival dicetak + Scan QR Code Gate Masuk.");
    }

    @Override
    public void hitungBiayaLayanan() {
        System.out.println("Biaya Layanan Festival: Rp 20.000");
    }

    @Override
    public void ajukanRefund(String alasan) {
        System.out.println("Refund Tiket Festival BERHASIL (Dipotong biaya admin 20%). Alasan: " + alasan);
    }
}
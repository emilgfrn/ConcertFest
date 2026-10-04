public class TiketFestival extends TiketKonser {
    private String zonaBerdiri;

    public TiketFestival(String kodeTiket, String namaKonser, double hargaDasar, String zonaBerdiri) {
        super(kodeTiket, namaKonser, hargaDasar); 
        this.zonaBerdiri = zonaBerdiri;
    }

    public String getZonaBerdiri() {
        return this.zonaBerdiri;
    }

    public void setZonaBerdiri(String zonaBerdiri) {
        this.zonaBerdiri = zonaBerdiri;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[ FESTIVAL ] ");
        super.tampilkanInfo();
        System.out.printf(" | Zona: %s%n", this.zonaBerdiri);
    }
}
public class Herec {
    private int pocetFilmu;

    public Herec(int pocetFilmu) {
        this.pocetFilmu = pocetFilmu;
    }

    public Herec(){
        this.pocetFilmu = 0;
    }

    public void pridatFilm(){
        this.pocetFilmu++;
    }

    public void odstranitFilm(){
        this.pocetFilmu--;
    }

    public int getPocetFilmu() {
        return this.pocetFilmu;
    }

    public void setPocetFilmu(int pocetFilmu) {
        this.pocetFilmu = pocetFilmu;
    }
}
public class Herec {
    private int pocetFilmu;
    private String Jmeno;

    public Herec(String jmeno, int pocetFilmu) {
        this.Jmeno= jmeno;
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

    public String getJmeno(){
        return this.Jmeno;
    }

    public int getPocetFilmu() {
        return this.pocetFilmu;
    }

    public void setPocetFilmu(int pocetFilmu) {
        this.pocetFilmu = pocetFilmu;
    }
}
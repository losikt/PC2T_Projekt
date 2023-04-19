public abstract class Film {
    private String Nazev;
    private String Reziser;
    private int RokVydani;
    

    public Film(String nazev,String reziser,int rokVydani)
    {
        this.Nazev = nazev;
        this.Reziser = reziser;
        this.RokVydani = rokVydani;
    }
    
    public String filmToString()
    {
        return(
        "    Název: "+this.Nazev+
        "\n    Režisér: "+this.Reziser+
        "\n    Rok vydání: "+ this.RokVydani
        );
    }

    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String nazev) {
        this.Nazev = nazev;
    }

    public String getReziser() {
        return Reziser;
    }

    public void setReziser(String reziser) {
        this.Reziser = reziser;
    }

    public int getRokVydani() {
        return RokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.RokVydani = rokVydani;
    }
}

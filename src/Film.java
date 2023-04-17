import java.util.List;

public abstract class Film {
    private String Nazev;
    private String Reziser;
    private int RokVydani;
    List<String> SeznamHercu;

    public Film(String nazev,String reziser,int rokVydani,List<String>seznamHercu)
    {
        this.Nazev = nazev;
        this.Reziser = reziser;
        this.RokVydani = rokVydani;
        this.SeznamHercu = seznamHercu;
    }
}

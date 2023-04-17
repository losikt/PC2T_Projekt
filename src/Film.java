import java.util.List;

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
}

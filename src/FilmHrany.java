import java.util.List;

public class FilmHrany extends Film{
    List<String>SeznamHercu;
    private int Hodnoceni;

    public FilmHrany(String nazev,String reziser, int rokVydani){
        super(nazev, reziser, rokVydani);
    }
    public FilmHrany(String nazev,String reziser, int rokVydani, List<String>seznamHercu){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
    }
    public FilmHrany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.Hodnoceni = hodnoceni;
    }
}

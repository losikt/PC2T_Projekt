import java.util.List;

public class FilmHrany extends Film{
    private int Hodnoceni;

    public FilmHrany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni){
        super(nazev, reziser, rokVydani, seznamHercu);
        this.Hodnoceni = hodnoceni;
    }
}

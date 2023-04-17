import java.util.List;

public class FilmAnimovany extends Film{
    private int Hodnoceni;
    private int DoporucenyVek;


    public FilmAnimovany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni, int doporucenyVek){
        super(nazev, reziser, rokVydani, seznamHercu);
        this.Hodnoceni = hodnoceni;
        this.DoporucenyVek = doporucenyVek;
    }
}


import java.util.List;

public class FilmAnimovany extends Film{
    private int Hodnoceni;
    private int DoporucenyVek;
    List<String> SeznamHercu;

    public FilmAnimovany(String nazev,String reziser, int rokVydani, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.DoporucenyVek = doporucenyVek;
    }

    public FilmAnimovany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.DoporucenyVek = doporucenyVek;
    }

    public FilmAnimovany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.Hodnoceni = hodnoceni;
        this.DoporucenyVek = doporucenyVek;
    }

    @Override
    public String filmToString()
    {
        String herci = "\nSeznam herců: \n";
        if(this.SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+=jmeno+"\n";
            }
        }
        return(super.filmToString()+herci+"Doporučený věk: "+this.DoporucenyVek);
    }

}


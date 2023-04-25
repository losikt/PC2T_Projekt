import java.util.List;
import java.util.Scanner;

public class FilmHrany extends Film{
    List<String>SeznamHercu;
    private int Hodnoceni;
    private String SlovniHodnoceni;

    public FilmHrany(String nazev,String reziser, int rokVydani){
        super(nazev, reziser, rokVydani);
    }
    public FilmHrany(String nazev,String reziser, int rokVydani, List<String>seznamHercu){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
    }
    public FilmHrany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni, String slovniHodnoceni){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.Hodnoceni = hodnoceni;
    }

    @Override
    public String filmToString()
    {
        String herci = "\n    Seznam herců: \n";
        if(SeznamHercu!=null){
            for (String jmeno : this.SeznamHercu) {
                herci+="              "+jmeno+"\n";
            }
        }
        return(super.filmToString()+herci);
    }

    public List<String> getSeznamHercu() {
        return SeznamHercu;
    }

    public void setSeznamHercu(List<String> seznamHercu) {
        this.SeznamHercu = seznamHercu;
    }

    public int getHodnoceni() {
        return Hodnoceni;
    }

    public void setHodnoceni(Scanner sc) {
        System.out.print("Zadej hodnoceni (0-5): ");
        int hodnoceni = InputChecker.getInt(sc);
        if(hodnoceni <6 && hodnoceni >-1)
        this.Hodnoceni = hodnoceni;
        else
        setHodnoceni(sc);
    }

    public String getSlovniHodnoceni()
    {
        return this.SlovniHodnoceni;
    }

    public void setSlovniHodnoceni(String slovniHodnoceni)
    {
        this.SlovniHodnoceni = slovniHodnoceni;
    }
    
}

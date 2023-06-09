import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmAnimovany extends Film{
    private int Hodnoceni;
    private int DoporucenyVek;
    private String SlovniHodnoceni;
    List<String> SeznamHercu;

    public FilmAnimovany(String nazev,String reziser, int rokVydani, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.DoporucenyVek = doporucenyVek;
        this.SeznamHercu = new ArrayList<String>();
    }

    public FilmAnimovany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.DoporucenyVek = doporucenyVek;
    }

    public FilmAnimovany(String nazev,String reziser, int rokVydani, List<String>seznamHercu, int hodnoceni,String slovniHodnoceni, int doporucenyVek){
        super(nazev, reziser, rokVydani);
        this.SeznamHercu= seznamHercu;
        this.Hodnoceni = hodnoceni;
        this.DoporucenyVek = doporucenyVek;
        this.SlovniHodnoceni = slovniHodnoceni;
    }

    @Override
    public String filmToString()
    {
        String herci ="\n";
        if(this.SeznamHercu!=null){
            herci ="\n    Seznam herců: \n";
            for (String jmeno : this.SeznamHercu) {
                herci+="    "+jmeno+"\n";
            }
        }
        return(super.filmToString()+herci+"    Doporučený věk: "+this.DoporucenyVek);
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
        System.out.print("Zadej hodnoceni (0-10): ");
        int hodnoceni = InputChecker.getInt(sc);
        if(hodnoceni <11 && hodnoceni >-1)
        this.Hodnoceni = hodnoceni;
        else
        setHodnoceni(sc);
    }

    public int getDoporucenyVek() {
        return DoporucenyVek;
    }

    public void setDoporucenyVek(int doporucenyVek) {
        this.DoporucenyVek = doporucenyVek;
    }

    public String getSlovniHodnoceni()
    {
        if(SlovniHodnoceni==null){
            return "";
        }
        else{
            return this.SlovniHodnoceni;
        }
    }

    public void setSlovniHodnoceni(String slovniHodnoceni)
    {
        this.SlovniHodnoceni = slovniHodnoceni;
    }
}


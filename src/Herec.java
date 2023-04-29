import java.util.List;

public class Herec {
    private int pocetFilmu;
    private String Jmeno;

    public Herec(String jmeno, int pocetFilmu) {
        this.Jmeno= jmeno;
        this.pocetFilmu = pocetFilmu;
    }

    public static void vypsatFilmy(List<FilmAnimovany> animovaneFilmy, List<FilmHrany>hraneFilmy,String Jmeno)
    {
        System.out.println("    Filmy s "+Jmeno+": ");
        for (FilmHrany film : hraneFilmy) {
            if(film.SeznamHercu.contains(Jmeno)){
                System.out.println("      "+film.getNazev());
            }
        }
        for (FilmAnimovany film : animovaneFilmy) {
            if(film.SeznamHercu.contains(Jmeno)){
                System.out.println("      "+film.getNazev());
            }
        }
    }

    public static String vytvoritSeznam(List<String> seznamHercu){
        String seznam="";
        if(seznamHercu!=null){
            for (String jmeno : seznamHercu){
                seznam+=jmeno+";";
            }
            seznam= seznam.substring(0, seznam.length()-1);
        }
        return seznam;
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
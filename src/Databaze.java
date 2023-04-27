import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Databaze {
    public static Connection dbConnect()
    {
        try {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:Filmy.db";
        Connection con = DriverManager.getConnection(url);
        return con;
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return null;
    }
    public static void nactiData(Connection con, List<FilmAnimovany> animovanefilmy, List<FilmHrany> hranefilmy, List<Herec> herci)
    {   try
        {
            Statement statement = con.createStatement();
            String query = "SELECT * FROM filmy";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int druh = rs.getInt(2);
                if(druh == 1)
                {
                    String nazev = rs.getString(3);
                    String reziser = rs.getString(4);
                    int rokVydani = rs.getInt(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    for (String herec : herciText.split(";")){
                        herec = InputChecker.upravJmeno(herec);
                        seznamHercu.add(herec);
                        Boolean nalezeno = false;
                        for (Herec her : herci){
                            if(her.getJmeno().equals(herec)){
                                her.pridatFilm();
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herec(herec,1));
                        }
                    }
                    int hodnoceni = rs.getInt(7);
                    String slovniHodnoceni = rs.getString(8);
                    FilmHrany film =new FilmHrany(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni);
                    hranefilmy.add(film);
                }
                else
                {
                    String nazev = rs.getString(3);
                    String reziser = rs.getString(4);
                    int rokVydani = rs.getInt(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    for (String herec : herciText.split(";")){
                        herec = InputChecker.upravJmeno(herec);
                        seznamHercu.add(herec);
                        Boolean nalezeno = false;
                        for (Herec her : herci){
                            if(her.getJmeno().equals(herec)){
                                her.pridatFilm();
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herec(herec,1));
                        }
                    }
                    int hodnoceni = rs.getInt(7);
                    String slovniHodnoceni = rs.getString(8);
                    int doporucenyVek = rs.getInt(9);
                    FilmAnimovany film =new FilmAnimovany(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni,doporucenyVek);
                    animovanefilmy.add(film);
                }
            }
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void zapisData(Connection con, List<FilmAnimovany> animovanefilmy, List<FilmHrany> hranefilmy, List<Herec> herci)
    {   try
        {
            Statement statement = con.createStatement();
            String query = "SELECT * FROM filmy";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int druh = rs.getInt(2);
                if(druh == 1)
                {
                    String nazev = rs.getString(3);
                    String reziser = rs.getString(4);
                    int rokVydani = rs.getInt(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    for (String herec : herciText.split(";")){
                        herec = InputChecker.upravJmeno(herec);
                        seznamHercu.add(herec);
                        Boolean nalezeno = false;
                        for (Herec her : herci){
                            if(her.getJmeno().equals(herec)){
                                her.pridatFilm();
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herec(herec,1));
                        }
                    }
                    int hodnoceni = rs.getInt(7);
                    String slovniHodnoceni = rs.getString(8);
                    FilmHrany film =new FilmHrany(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni);
                    hranefilmy.add(film);
                }
                else
                {
                    String nazev = rs.getString(3);
                    String reziser = rs.getString(4);
                    int rokVydani = rs.getInt(5);
                    List<String> seznamHercu= new ArrayList<String>(); 
                    String herciText = rs.getString(6);
                    for (String herec : herciText.split(";")){
                        herec = InputChecker.upravJmeno(herec);
                        seznamHercu.add(herec);
                        Boolean nalezeno = false;
                        for (Herec her : herci){
                            if(her.getJmeno().equals(herec)){
                                her.pridatFilm();
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herec(herec,1));
                        }
                    }
                    int hodnoceni = rs.getInt(7);
                    String slovniHodnoceni = rs.getString(8);
                    int doporucenyVek = rs.getInt(9);
                    FilmAnimovany film =new FilmAnimovany(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni,doporucenyVek);
                    animovanefilmy.add(film);
                }
            }
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }




    public static void dbEndConnection(Connection con)
    {
        try{
        con.close();
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

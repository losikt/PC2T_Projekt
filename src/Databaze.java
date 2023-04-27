import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Databaze {
    public static void nactiData(List<FilmAnimovany> animovanefilmy, List<FilmHrany> hranefilmy, List<Herec> herci)
    {   try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:PC2T_Projekt/Filmy.db";
            Connection con = DriverManager.getConnection(url);
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
            con.close();
        }
        }catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void zapisData(List<FilmAnimovany> animovanefilmy, List<FilmHrany> hranefilmy){   
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:PC2T_Projekt/Filmy.db";
            Connection con = DriverManager.getConnection(url);
            String sql = "DELETE FROM filmy";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            sql = "INSERT INTO filmy (druh, nazev, reziser, rok, herci, hodnoceni, slovhodnoceni) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql); 
            for (FilmHrany film : hranefilmy){
                statement.setInt(1, 1);
                statement.setString(2, film.getNazev());
                statement.setString(3, film.getReziser());
                statement.setInt(4, film.getRokVydani());
                statement.setString(5, Herec.vytvoritSeznam(film.getSeznamHercu()));
                statement.setInt(6, film.getHodnoceni());
                statement.setString(7, film.getSlovniHodnoceni());
                statement.executeUpdate();
            }
            sql = "INSERT INTO filmy(druh,nazev,reziser,rok,herci,hodnoceni,slovhodnoceni,vek)VALUES(?,?,?,?,?,?,?,?)";
            statement = con.prepareStatement(sql); 
            for (FilmAnimovany film : animovanefilmy) {
                statement.setInt(1, 2);
                statement.setString(2, film.getNazev());
                statement.setString(3, film.getReziser());
                statement.setInt(4, film.getRokVydani());
                statement.setString(5, Herec.vytvoritSeznam(film.getSeznamHercu()));
                statement.setInt(6, film.getHodnoceni());
                statement.setString(7, film.getSlovniHodnoceni());
                statement.setInt(8, film.getDoporucenyVek());
                statement.executeUpdate();
            }
            statement.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error executing SQL statement.");
            e.printStackTrace();
        }
    }
}

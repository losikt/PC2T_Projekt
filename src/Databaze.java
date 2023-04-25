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
                    List<String> seznamHercu= new ArrayList<String>(); //vymyslet formát + udělat split do listu
                    int hodnoceni = rs.getInt(7);
                    String slovniHodnoceni = rs.getString(8);
                    FilmHrany film =new FilmHrany(nazev, reziser, rokVydani, seznamHercu, hodnoceni, slovniHodnoceni);
                }
                else
                {

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

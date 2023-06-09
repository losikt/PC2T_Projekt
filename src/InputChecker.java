import java.util.Scanner;
import java.util.List;
public class InputChecker {
    public static int getInt(Scanner input)
    {
        int cislo = 0;
        try{
            cislo = input.nextInt();
            input.nextLine();
        }
        catch(Exception e)
        {
            System.out.print("    Zadej cislo!! :");
            input.nextLine();
            cislo =getInt(input);
        }
        return cislo;
    }

    public static boolean dotupnyNazev(String nazev, List<FilmHrany> hraneFilmy, List<FilmAnimovany> animovaneFilmy){
        for (FilmAnimovany film : animovaneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        for (FilmHrany film : hraneFilmy) {
            if(film.getNazev().equals(nazev)){
                return false;
            }
        }
        return true;
    }

    public static String upravJmeno(String jmeno)
    {
        try{
            jmeno=jmeno.toLowerCase();
            String[] slova  = jmeno.split(" ");
            jmeno="";
            for (String slovo : slova) {
                jmeno += slovo.substring(0, 1).toUpperCase()+slovo.substring(1)+" ";

            }
            jmeno = jmeno.substring(0, jmeno.length()-1);
            return jmeno;
        }catch(Exception e)
        {
            return "";
        }
}

}

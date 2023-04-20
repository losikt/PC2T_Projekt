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
}

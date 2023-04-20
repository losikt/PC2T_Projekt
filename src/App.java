import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<FilmAnimovany> animovaneFilmy = new ArrayList<FilmAnimovany>();
        List<FilmHrany> hraneFilmy = new ArrayList<FilmHrany>();
        int volba;
        Scanner sc = new Scanner(System.in);
        System.out.print(
            "[1]   Přidání filmu\n"+
            "[2]   Upravení filmu\n"+
            "[3]   Smazání filmu\n"+
            "[4]   Přidání hodnocení filmu\n"+
            "[5]   Výpis filmů\n"+
            "[6]   Vyhledání filmu\n"+
            "[7]   Výpis herců/animátorů kteří se podíleli na více dílech\n"+
            "[8]   Výpis filmů podle herců/animátorů\n"+
            "[9]   Uložení informací o filmu\n"+
            "[10]  Přidání filmu souborem\n"+
            "[0]   Konec\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
        while(volba !=0){
            switch(volba){
                case 0:
                break;
                case 1:
                    FilmEditor.vytvorFilm(animovaneFilmy, hraneFilmy);
                break;
                case 2:
                    FilmEditor.upravFilm(animovaneFilmy, hraneFilmy);
                break;
                case 3:
                    FilmEditor.odstranFilm(animovaneFilmy, hraneFilmy);
                break;
                case 4:
                    FilmEditor.pridejHodnoceni(animovaneFilmy, hraneFilmy);
                break;
                case 5:
                    System.out.println("    Hrané filmy: ");
                    for (FilmHrany film : hraneFilmy) {
                        System.out.println(film.filmToString());
                    }
                    System.out.println("    Animované filmy: ");
                    for (FilmAnimovany film : animovaneFilmy) {
                        System.out.println(film.filmToString());
                    }
                break;
                case 6:
                
                break;
                case 7:
                
                break;
                case 8:
                
                break;
                case 9:
                
                break;
                case 10:
                
                break;
            }
            System.out.print(
            "[1]   Přidání filmu\n"+
            "[2]   Upravení filmu\n"+
            "[3]   Smazání filmu\n"+
            "[4]   Přidání hodnocení filmu\n"+
            "[5]   Výpis filmů\n"+
            "[6]   Vyhledání filmu\n"+
            "[7]   Výpis herců/animátorů kteří se podíleli na více dílech\n"+
            "[8]   Výpis filmů podle herců/animátorů\n"+
            "[9]   Uložení informací o filmu\n"+
            "[10]  Přidání filmu souborem\n"+
            "[0]   Konec\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<FilmAnimovany> animovaneFilmy = new ArrayList<FilmAnimovany>();
        List<FilmHrany> hraneFilmy = new ArrayList<FilmHrany>();
        List<Herec> herci = new ArrayList<Herec>();
        int volba;
        Scanner sc = new Scanner(System.in);
        Databaze.nactiData(animovaneFilmy, hraneFilmy, herci);
        
        do{
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
            switch(volba){
                case 0:
                    Databaze.zapisData(animovaneFilmy, hraneFilmy);
                break;
                case 1:
                    FilmEditor.vytvorFilm(animovaneFilmy, hraneFilmy);
                break;
                case 2:
                    FilmEditor.upravFilm(animovaneFilmy, hraneFilmy);
                break;
                case 3:
                    FilmEditor.odstranFilm(animovaneFilmy, hraneFilmy);
                    sc.nextLine();
                break;
                case 4:
                    FilmEditor.pridejHodnoceni(animovaneFilmy, hraneFilmy);
                break;
                case 5:
                    FilmEditor.vypisFilmy(animovaneFilmy, hraneFilmy);
                    sc.nextLine();
                break;
                case 6:
                    FilmEditor.vypisFilm(animovaneFilmy, hraneFilmy);
                    sc.nextLine();
                break;
                case 7:
                    for (Herec herec : herci) {
                        if(herec.getPocetFilmu()>1){
                            Herec.vypsatFilmy(animovaneFilmy, hraneFilmy, herec.getJmeno());
                        }
                    }
                    sc.nextLine();
                break;
                case 8:
                    System.out.print("    Zadej jméno herce / animátora : ");
                    String jmeno=sc.nextLine();
                    Herec.vypsatFilmy(animovaneFilmy, hraneFilmy, InputChecker.upravJmeno(jmeno));
                    sc.nextLine();
                break;
                case 9:
                    //zápis do souboru
                break;
                case 10:
                   //načtení ze souboru
                break;
            }
        }while(volba !=0);
    }
}

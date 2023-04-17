import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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
            "[0] Konec\n"+
            "Vyber akci: ");
            volba = InputChecker.getInt(sc);
        while(volba !=0){
            switch(volba){
                case 0:
                break;
                case 1:
                System.out.print(
                    "Vyber druh filmu\n"+
                    "[1]   Hraný film\n"+
                    "[2]   Animovný film\n"+
                    "[0]   Zpět\n"+
                    "Vyber akci: ");
                volba = InputChecker.getInt(sc);
                String nazev;
                String reziser;
                int rokVydani;
                int doporucenyVek;
                String herec;
                
                switch(volba){
                    case 0:
                    break;
                    case 1:
                    System.out.print("Zadej název filmu: ");
                    nazev = sc.nextLine();
                    System.out.print("Zadej jméno režiséra filmu: ");
                    reziser = sc.nextLine();
                    System.out.print("Zadej rok vydání filmu: ");
                    rokVydani=InputChecker.getInt(sc);
                    System.out.print(
                    "Chceš zadat seznam herců?\n"+
                    "[1]   Ano\n"+
                    "[2]   Ne\n"+
                    "Vyber akci: ");
                    volba=InputChecker.getInt(sc);
                    if(volba==1){
                        List<String> seznamhercu=new ArrayList<String>();
                        System.out.print("Zadej jméno herce (pro ukončení zápisu zadej 0)");
                        herec = sc.nextLine();
                        while(herec!="0"){
                            seznamhercu.add(herec);
                            System.out.print("Zadej jméno herce (pro ukončení zápisu zadej 0)");
                            herec = sc.nextLine();
                        }
                        FilmHrany suiii = new FilmHrany(nazev, reziser, rokVydani, seznamhercu) ;
                    }
                    else{
                        FilmHrany suiii = new FilmHrany(nazev, reziser, rokVydani);
                    }
                    break;
                    case 2:
                    System.out.print("Zadej název filmu: ");
                    nazev = sc.nextLine();
                    System.out.print("Zadej jméno režiséra filmu: ");
                    reziser = sc.nextLine();
                    System.out.print("Zadej rok vydání filmu: ");
                    rokVydani=InputChecker.getInt(sc);
                    System.out.print("Zadej dopručený věk diváka filmu: ");
                    doporucenyVek=InputChecker.getInt(sc);
                    System.out.print(
                    "Chceš zadat seznam animátorů?\n"+
                    "[1]   Ano\n"+
                    "[2]   Ne\n"+
                    "Vyber akci: ");
                    volba=InputChecker.getInt(sc);
                    if(volba==1){
                        List<String> seznamhercu=new ArrayList<String>();
                        System.out.print("Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                        herec = sc.nextLine();
                        while(herec!="0"){
                            seznamhercu.add(herec);
                            System.out.print("Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                            herec = sc.nextLine();
                        }
                        FilmAnimovany suiii = new FilmAnimovany(nazev, reziser, rokVydani, seznamhercu,doporucenyVek) ;
                    }
                    else{
                        FilmAnimovany suiii = new FilmAnimovany(nazev, reziser, rokVydani,doporucenyVek);
                    }
                    break;
                }
                break;
                case 2:
                
                break;
                case 3:
                
                break;
                case 4:
                
                break;
                case 5:
                
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
            "[0] Konec\n"+
            "Vyber akci: ");
            volba = InputChecker.getInt(sc);
        }
    }
}

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FilmEditor {
    public static void vytvorFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy)
    {
        String nazev;
        String reziser;
        int rokVydani;
        int doporucenyVek;
        String herec;
        int volba;
        Scanner sc= new Scanner(System.in);
        System.out.print(
                    "    Vyber druh filmu\n"+
                    "[1]   Hraný film\n"+
                    "[2]   Animovný film\n"+
                    "[0]   Zpět\n"+
                    "    Vyber akci: ");
                volba = InputChecker.getInt(sc);
                
                
        switch(volba){
            case 0:
            break;
            case 1:
            System.out.print("    Zadej název filmu: ");
            nazev = sc.nextLine();
            System.out.print("    Zadej jméno režiséra filmu: ");
            reziser = sc.nextLine();
            System.out.print("    Zadej rok vydání filmu: ");
            rokVydani=InputChecker.getInt(sc);
            System.out.print(
            "    Chceš zadat seznam herců?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba=InputChecker.getInt(sc);
            if(volba==1){
                List<String> seznamhercu=new ArrayList<String>();
                System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                herec = sc.nextLine();
                while(!herec.equals("0")){
                    seznamhercu.add(herec);
                    System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                    herec = sc.nextLine();
                }
                hraneFilmy.add(new FilmHrany(nazev, reziser, rokVydani, seznamhercu)) ;
                System.out.println( hraneFilmy.get(0).filmToString());
            }
            else{
                hraneFilmy.add(new FilmHrany(nazev, reziser, rokVydani));
            }
            break;
            case 2:
            System.out.print("    Zadej název filmu: ");
            nazev = sc.nextLine();
            System.out.print("    Zadej jméno režiséra filmu: ");
            reziser = sc.nextLine();
            System.out.print("    Zadej rok vydání filmu: ");
            rokVydani=InputChecker.getInt(sc);
            System.out.print("    Zadej dopručený věk diváka filmu: ");
            doporucenyVek=InputChecker.getInt(sc);
            System.out.print(
            "    Chceš zadat seznam animátorů?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba=InputChecker.getInt(sc);
            if(volba==1){
                List<String> seznamhercu=new ArrayList<String>();
                System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                herec = sc.nextLine();
                while(!herec.equals("0")){
                    seznamhercu.add(herec);
                    System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                    herec = sc.nextLine();
                }
                animovaneFilmy.add(new FilmAnimovany(nazev, reziser, rokVydani, seznamhercu,doporucenyVek)) ;
            }
            else{
                animovaneFilmy.add(new FilmAnimovany(nazev, reziser, rokVydani,doporucenyVek));
            }
            break;
        }
    }

    public static void upravFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy){
        String nazev;
        String herec;
        int volba;
        Scanner sc= new Scanner(System.in);
        System.out.print("    Zadej název filmu: ");
                    nazev=sc.nextLine();
                    int i = 0;
                    int nalezeno = 0;
                    for (FilmHrany film : hraneFilmy) {
                        if(film.getNazev().equals(nazev)){
                            nalezeno = 1;
                            break;
                        }
                        i++;
                    }
                    if(nalezeno==0){
                        i = 0;
                        for (FilmAnimovany film : animovaneFilmy) {
                            if(film.getNazev().equals(nazev)){
                                nalezeno = 2;
                                break;
                            }   
                            i++;
                        }
                    }
                    switch(nalezeno)
                    {
                        case 1:
                            System.out.print(
                                    "[1]   Upravit název\n"+
                                    "[2]   Upravit režiséra\n"+
                                    "[3]   Upravit rok vydání\n"+
                                    "[4]   Upravit seznam herců\n"+
                                    "[5]   Upravit hodnocení\n"+
                                    "[0]   Hotovo\n"+
                                    "    Vyber akci: ");
                                volba=InputChecker.getInt(sc);
                            while(volba!=0&&volba!=9){
                                FilmHrany vybranyFilm = hraneFilmy.get(i);
                                switch(volba){
                                    case 1:
                                        System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
                                        vybranyFilm.setNazev(sc.nextLine());
                                    break;
                                    case 2:
                                        System.out.print("    Současný režisér "+vybranyFilm.getNazev()+"\n    Nový režisér: ");
                                        vybranyFilm.setReziser(sc.nextLine());
                                    break;
                                    case 3:
                                        System.out.print("    Současný rok vydání "+vybranyFilm.getNazev()+"\n    Nový rok vydání: ");
                                        vybranyFilm.setRokVydani(InputChecker.getInt(sc));
                                    break;
                                    case 4:
                                        if(vybranyFilm.SeznamHercu!=null);
                                        System.out.println("    Současný seznam herců: "+vybranyFilm.SeznamHercu.get(0));
                                        for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
                                        {
                                            System.out.println("                           "+vybranyFilm.SeznamHercu.get(j));
                                        }
                                        List<String> novySeznamHercu = new ArrayList<String>();
                                        System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                                        herec = sc.nextLine();
                                        while(!herec.equals("0")){
                                            novySeznamHercu.add(herec);
                                            System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                                            herec = sc.nextLine();
                                        }
                                        vybranyFilm.setSeznamHercu(novySeznamHercu);
                                    break;
                                    case 5:
                                        System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
                                        vybranyFilm.setHodnoceni(sc);
                                        System.out.print(
                                        "    Chceš zadat slovní hodnocení?\n"+
                                        "[1]   Ano\n"+
                                        "[2]   Ne\n"+
                                        "    Vyber akci: ");
                                        volba=InputChecker.getInt(sc);
                                        if(volba ==1){
                                            System.out.print("    Zadej slovní hodnocení: ");
                                            vybranyFilm.setSlovniHodnoceni(sc.nextLine());
                                        }
                                    break;
                                    case 0:
                                        hraneFilmy.set(i, vybranyFilm);
                                    break;
                                    case 9:
                                    break;
                                }
                                System.out.print(
                                    "[1]   Upravit název\n"+
                                    "[2]   Upravit režiséra\n"+
                                    "[3]   Upravit rok vydání\n"+
                                    "[4]   Upravit seznam herců\n"+
                                    "[5]   Upravit hodnocení\n"+
                                    "[0]   Hotovo\n"+
                                    "[9]   Zrušit změny\n"+
                                    "    Vyber akci: ");
                                volba=InputChecker.getInt(sc);
                            }
                        break;
                        case 2:
                            System.out.print(
                                    "[1]   Upravit název\n"+
                                    "[2]   Upravit režiséra\n"+
                                    "[3]   Upravit rok vydání\n"+
                                    "[4]   Upravit seznam herců\n"+
                                    "[5]   Upravit hodnocení\n"+
                                    "[6]   Upravit Doporučný věk\n"+
                                    "[0]   Hotovo\n"+
                                    "    Vyber akci: ");
                    volba=InputChecker.getInt(sc);
                while(volba!=0&&volba!=9){
                    FilmAnimovany vybranyFilm = animovaneFilmy.get(i);
                    switch(volba){
                        case 1:
                            System.out.print("    Současný název "+vybranyFilm.getNazev()+"\n    Nový název: ");
                            vybranyFilm.setNazev(sc.nextLine());
                        break;
                        case 2:
                            System.out.print("    Současný režisér "+vybranyFilm.getNazev()+"\n    Nový režisér: ");
                            vybranyFilm.setReziser(sc.nextLine());
                        break;
                        case 3:
                            System.out.print("    Současný rok vydání "+vybranyFilm.getNazev()+"\n    Nový rok vydání: ");
                            vybranyFilm.setRokVydani(InputChecker.getInt(sc));
                        break;
                        case 4:
                            if(vybranyFilm.SeznamHercu!=null);
                            System.out.println("    Současný seznam animátorů: "+vybranyFilm.SeznamHercu.get(0));
                            for(int j =1; j<vybranyFilm.SeznamHercu.size();j++)
                            {
                                System.out.println("                               "+vybranyFilm.SeznamHercu.get(j));
                            }
                            List<String> novySeznamHercu = new ArrayList<String>();
                            System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                            herec = sc.nextLine();
                            while(!herec.equals("0")){
                                novySeznamHercu.add(herec);
                                System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                                herec = sc.nextLine();
                            }
                            vybranyFilm.setSeznamHercu(novySeznamHercu);
                        break;
                        case 5:
                            System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
                            vybranyFilm.setHodnoceni(sc);
                            System.out.print(
                            "    Chceš zadat slovní hodnocení?\n"+
                            "[1]   Ano\n"+
                            "[2]   Ne\n"+
                            "    Vyber akci: ");
                            volba=InputChecker.getInt(sc);
                            if(volba ==1){
                                System.out.print("    Zadej slovní hodnocení: ");
                                vybranyFilm.setSlovniHodnoceni(sc.nextLine());
                            }
                        break;
                        case 6:
                            System.out.print("    Současný doporučený věk diváka "+vybranyFilm.getNazev()+"\n    Nový doporučený věk diváka: ");
                            vybranyFilm.setDoporucenyVek(InputChecker.getInt(sc));
                        break;
                        case 0:
                            animovaneFilmy.set(i, vybranyFilm);
                        break;
                        case 9:
                        break;
                    }
                    System.out.print(
                        "[1]   Upravit název\n"+
                        "[2]   Upravit režiséra\n"+
                        "[3]   Upravit rok vydání\n"+
                        "[4]   Upravit seznam herců\n"+
                        "[5]   Upravit hodnocení\n"+
                        "[6]   Upravit Doporučný věk\n"+
                        "[0]   Hotovo\n"+
                        "[9]   Zrušit změny\n"+
                        "    Vyber akci: ");
                    volba=InputChecker.getInt(sc);
                }
            break;
            case 0:
                System.out.println("    Film nenalezen");
            break;
        }
    }

    public static void pridejHodnoceni(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy)
    {
        String nazev;
        int volba;
        Scanner sc= new Scanner(System.in);
        System.out.print("    Zadej název filmu: ");
        nazev=sc.nextLine();
        int i = 0;
        int nalezeno = 0;
        for (FilmHrany film : hraneFilmy) {
            if(film.getNazev().equals(nazev)){
                nalezeno = 1;
                break;
            }
            i++;
        }
        if(nalezeno==0){
            i = 0;
            for (FilmAnimovany film : animovaneFilmy) {
                if(film.getNazev().equals(nazev)){
                    nalezeno = 2;
                    break;
                }   
                i++;
            }
        }
        switch(nalezeno){
        case 1:
            FilmHrany vybranyFilm = hraneFilmy.get(i);
            System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
            vybranyFilm.setHodnoceni(sc);
            System.out.print(
            "    Chceš zadat slovní hodnocení?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
            if(volba ==1){
                System.out.print("    Zadej slovní hodnocení: ");
                vybranyFilm.setSlovniHodnoceni(sc.nextLine());
            }
        break;
        case 2:
            FilmAnimovany vybranyFilm = animovaneFilmy.get(i);
            System.out.println("    Současné hodnocení "+vybranyFilm.getHodnoceni());
            vybranyFilm.setHodnoceni(sc);
            System.out.print(
            "    Chceš zadat slovní hodnocení?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
            if(volba ==1){
                System.out.print("    Zadej slovní hodnocení: ");
                vybranyFilm.setSlovniHodnoceni(sc.nextLine());
            }
        break;
        case 0:
            System.out.println("    Film nenalezen");
        break;
        }
    }

    public static void odstranFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy){
        String nazev;
        int volba;
        int i=0;
        int nalezeno=0;
        Scanner sc= new Scanner(System.in);
        System.out.print("    Zadej název filmu: ");
        nazev=sc.nextLine();
        for (FilmHrany film : hraneFilmy) {
            if(film.getNazev().equals(nazev)){
                nalezeno = 1;
                break;
            }
            i++;
        }
        if(nalezeno==0){
            i = 0;
            for (FilmAnimovany film : animovaneFilmy) {
                if(film.getNazev().equals(nazev)){
                    nalezeno = 2;
                    break;
                }   
                i++;
            }
        }
        switch(nalezeno)
        {
            case 1:
                System.out.print("[1]     Potvrď odstranění filmu "+hraneFilmy.get(i).getNazev()+": ");
                volba = InputChecker.getInt(sc);
                if(volba == 1){
                hraneFilmy.remove(i);
                System.out.println("    Úspěšně odstraněno ");
                }
            break;
            case 2:
                System.out.print("[1]     Potvrď odstranění filmu "+animovaneFilmy.get(i).getNazev()+": ");
                volba = InputChecker.getInt(sc);
                if(volba == 1){
                animovaneFilmy.remove(i);
                System.out.println("    Úspěšně odstraněno ");
            }
            break;
            case 0:
                System.out.println("    Film nenalezen");
            break;
        }
    }
}

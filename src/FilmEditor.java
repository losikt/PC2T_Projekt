import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FilmEditor {
    public static void vytvorFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy, List<Herec> herci)
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
                nazev=sc.nextLine();
                if(InputChecker.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)){
                    System.out.print("    Zadej jméno režiséra filmu: ");
                    reziser = InputChecker.upravJmeno(sc.nextLine());
                    System.out.print("    Zadej rok vydání filmu: ");
                    rokVydani=InputChecker.getInt(sc);
                    System.out.print(
                    "    Chceš zadat seznam herců?\n"+
                    "[1]   Ano\n"+
                    "[2]   Ne\n"+
                    "    Vyber akci: ");
                    volba=InputChecker.getInt(sc);
                    if(volba==1){
                        List<String> seznamHercu=new ArrayList<String>();
                        System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                        herec = InputChecker.upravJmeno(sc.nextLine());
                        while(!herec.equals("0")){
                            seznamHercu.add(herec);
                            System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                            herec = InputChecker.upravJmeno(sc.nextLine());
                        }
                        hraneFilmy.add(new FilmHrany(nazev, reziser, rokVydani, seznamHercu)) ;
                        boolean nalezeno = false;
                        for (String herec1 : seznamHercu) {
                            for (Herec herec2 : herci){
                                if(herec2.getJmeno().equals(herec1)){
                                    herec2.pridatFilm();
                                    nalezeno = true;
                                    break;
                                }
                            }
                            if(!nalezeno){
                                herci.add(new Herec(herec1,1));
                            }
                        }
                        System.out.println( hraneFilmy.get(0).filmToString());
                    }
                    else{
                        hraneFilmy.add(new FilmHrany(nazev, reziser, rokVydani));
                    }
                }
                else{
                    System.out.println("    Název je již použit!!!");
                }   
            break;
            case 2:
                System.out.print("    Zadej název filmu: ");
                nazev = sc.nextLine();
                System.out.print("    Zadej jméno režiséra filmu: ");
                reziser = InputChecker.upravJmeno(sc.nextLine());
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
                    List<String> seznamHercu=new ArrayList<String>();
                    System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                    herec = InputChecker.upravJmeno(sc.nextLine());
                    while(!herec.equals("0")){
                        seznamHercu.add(herec);
                        System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                        herec = InputChecker.upravJmeno(sc.nextLine());
                    }
                    animovaneFilmy.add(new FilmAnimovany(nazev, reziser, rokVydani, seznamHercu,doporucenyVek)) ;
                    boolean nalezeno = false;
                    for (String herec1 : seznamHercu) {
                        for (Herec herec2 : herci){
                            if(herec2.getJmeno().equals(herec1)){
                                herec2.pridatFilm();
                                nalezeno = true;
                                break;
                            }
                        }
                        if(!nalezeno){
                            herci.add(new Herec(herec1,1));
                        }
                    }
                }
                else{
                    animovaneFilmy.add(new FilmAnimovany(nazev, reziser, rokVydani,doporucenyVek));
                }
            break;
        }
    }

    public static void upravFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy, List<Herec> herci){
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
        switch(nalezeno){
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
                    nazev=sc.nextLine();
                    if(InputChecker.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)){
                        vybranyFilm.setNazev(nazev);
                    }
                    else{
                        System.out.println("    Název je již použit");
                    }
                break;
                case 2:
                    System.out.print("    Současný režisér "+vybranyFilm.getNazev()+"\n    Nový režisér: ");
                    vybranyFilm.setReziser(InputChecker.upravJmeno(sc.nextLine()));
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
                    herec = InputChecker.upravJmeno(sc.nextLine());
                    while(!herec.equals("0")){
                        novySeznamHercu.add(herec);
                        System.out.print("    Zadej jméno herce (pro ukončení zápisu zadej 0)");
                        herec = InputChecker.upravJmeno(sc.nextLine());
                    }
                    if(!vybranyFilm.SeznamHercu.isEmpty()){
                        for (String herec1 : vybranyFilm.SeznamHercu) {
                            for (Herec herec2 : herci) {
                                if(herec1.equals(herec2.getJmeno())){
                                    herec2.odstranitFilm();
                                }
                            }
                        }
                    }
                    vybranyFilm.setSeznamHercu(novySeznamHercu);
                    boolean nalezeno2 = false;
                    for (String herec1 : novySeznamHercu) {
                        for (Herec herec2 : herci){
                            if(herec2.getJmeno().equals(herec1)){
                                herec2.pridatFilm();
                                nalezeno2 = true;
                                break;
                            }
                        }
                        if(!nalezeno2){
                            herci.add(new Herec(herec1,1));
                        }
                    }
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
                        }
                        System.out.print(
                            "[1]   Upravit název\n"+
                            "[2]   Upravit režiséra\n"+
                            "[3]   Upravit rok vydání\n"+
                            "[4]   Upravit seznam herců\n"+
                            "[5]   Upravit hodnocení\n"+
                            "[0]   Hotovo\n"+
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
                        vybranyFilm.setReziser(InputChecker.upravJmeno(sc.nextLine()));
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
                        herec = InputChecker.upravJmeno(sc.nextLine());
                        while(!herec.equals("0")){
                            novySeznamHercu.add(herec);
                            System.out.print("    Zadej jméno animátora (pro ukončení zápisu zadej 0)");
                            herec = InputChecker.upravJmeno(sc.nextLine());
                        }
                        if(!vybranyFilm.SeznamHercu.isEmpty()){
                            for (String herec1 : vybranyFilm.SeznamHercu) {
                                for (Herec herec2 : herci) {
                                    if(herec1.equals(herec2.getJmeno())){
                                        herec2.odstranitFilm();
                                    }
                                }
                            }
                        }
                        vybranyFilm.setSeznamHercu(novySeznamHercu);
                        boolean nalezeno2 = false;
                        for (String herec1 : novySeznamHercu) {
                            for (Herec herec2 : herci){
                                if(herec2.getJmeno().equals(herec1)){
                                    herec2.pridatFilm();
                                    nalezeno2 = true;
                                    break;
                                }
                            }
                            if(!nalezeno2){
                                herci.add(new Herec(herec1,1));
                            }
                        }
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
            System.out.println("    Současné hodnocení "+hraneFilmy.get(i).getHodnoceni());
            hraneFilmy.get(i).setHodnoceni(sc);
            System.out.print(
            "    Chceš zadat slovní hodnocení?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
            if(volba ==1){
                System.out.print("    Zadej slovní hodnocení: ");
                hraneFilmy.get(i).setSlovniHodnoceni(sc.nextLine());
            }
        break;
        case 2:
            System.out.println("    Současné hodnocení "+animovaneFilmy.get(i).getHodnoceni());
            animovaneFilmy.get(i).setHodnoceni(sc);
            System.out.print(
            "    Chceš zadat slovní hodnocení?\n"+
            "[1]   Ano\n"+
            "[2]   Ne\n"+
            "    Vyber akci: ");
            volba = InputChecker.getInt(sc);
            if(volba ==1){
                System.out.print("    Zadej slovní hodnocení: ");
                animovaneFilmy.get(i).setSlovniHodnoceni(sc.nextLine());
            }
        break;
        case 0:
            System.out.println("    Film nenalezen");
        break;
        }
    }

    public static void odstranFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy, List<Herec> herci){
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
                    if(!hraneFilmy.get(i).SeznamHercu.isEmpty()){
                        for (String herec : hraneFilmy.get(i).SeznamHercu) {
                            for (Herec herec2 : herci) {
                                if(herec.equals(herec2.getJmeno())){
                                    herec2.odstranitFilm();
                                }
                            }
                        }
                    }
                hraneFilmy.remove(i);
                System.out.println("    Úspěšně odstraněno ");
                }
            break;
            case 2:
                System.out.print("[1]     Potvrď odstranění filmu "+animovaneFilmy.get(i).getNazev()+": ");
                volba = InputChecker.getInt(sc);
                if(volba == 1){
                    if(!animovaneFilmy.get(i).SeznamHercu.isEmpty()){
                        for (String herec : animovaneFilmy.get(i).SeznamHercu) {
                            for (Herec herec2 : herci) {
                                if(herec.equals(herec2.getJmeno())){
                                    herec2.odstranitFilm();
                                }
                            }
                        }
                    }
                animovaneFilmy.remove(i);
                System.out.println("    Úspěšně odstraněno ");
            }
            break;
            case 0:
                System.out.println("    Film nenalezen");
            break;
        }
    }

    public static void vypisFilmy(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy){
        System.out.println(" HRANÉ FILMY: ");
        for (FilmHrany film : hraneFilmy) {
            System.out.print(film.filmToString());
        }
        System.out.println(" ANIMOVANÉ FILMY: ");
        for (FilmAnimovany film : animovaneFilmy) {
            System.out.print(film.filmToString());
        }
    }

    public static void vypisFilm(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy){
        String nazev;
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
        switch(nalezeno){
        case 1:
            System.out.print(hraneFilmy.get(i).filmToString());
            System.out.print("    Hodnocení filmu: ");
            for(int j=0;j<hraneFilmy.get(i).getHodnoceni();j++){
                System.out.print("*");
            }
            System.out.println("");
            if(!hraneFilmy.get(i).getSlovniHodnoceni().equals(""))
            System.out.println("    Slovní hodnocení: "+ hraneFilmy.get(i).getSlovniHodnoceni());
        break;
        case 2:
            System.out.println(animovaneFilmy.get(i).filmToString());
            System.out.println("    Hodnocení filmu: "+animovaneFilmy.get(i).getHodnoceni());
            if(!animovaneFilmy.get(i).getSlovniHodnoceni().equals(""))
            System.out.println("    Slovní hodnocení: "+ animovaneFilmy.get(i).getSlovniHodnoceni());
        break;
        case 0:
            System.out.println("    Film nenalezen");
        break;
        }
    }
}

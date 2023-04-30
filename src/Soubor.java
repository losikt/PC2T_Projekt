import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Soubor {
    public static void vypsat(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy){
        String nazev;
        int i=0;
        int nalezeno=0;
        Scanner sc= new Scanner(System.in,"UTF-8");
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
            try{
                FileWriter fw = new FileWriter(("filmy/"+hraneFilmy.get(i).getNazev()+".txt"),Charset.forName("UTF-8"));
                fw.write(
                    " Název: "+hraneFilmy.get(i).getNazev()+
                    "\n Druh: Hraný film"+
                    "\n Režisér: "+hraneFilmy.get(i).getReziser()+
                    "\n Rok vydání: "+hraneFilmy.get(i).getRokVydani()+
                    "\n Seznam herců:"
                    );
                if(hraneFilmy.get(i).SeznamHercu!=null){
                    for (String jmeno : hraneFilmy.get(i).SeznamHercu) {
                        fw.append("\n "+jmeno);
                    }
                }
                fw.append(
                    "\n Hodnocení: "+hraneFilmy.get(i).getHodnoceni()+
                    "\n Slovní hodnocení: "+hraneFilmy.get(i).getSlovniHodnoceni()
                );
                fw.close();
            }catch (Exception e) {
                System.out.println("aaaaaaa");
            }
        break;
        case 2:
            try{
                FileWriter fw = new FileWriter(("filmy/"+animovaneFilmy.get(i).getNazev()+".txt"),Charset.forName("UTF-8"));
                fw.write(
                    " Název: "+animovaneFilmy.get(i).getNazev()+
                    "\n Druh: Animovaný film"+
                    "\n Režisér: "+animovaneFilmy.get(i).getReziser()+
                    "\n Rok vydání: "+animovaneFilmy.get(i).getRokVydani()+
                    "\n Seznam herců:"
                    );
                if(animovaneFilmy.get(i).SeznamHercu!=null){
                    for (String jmeno : animovaneFilmy.get(i).SeznamHercu) {
                        fw.append("\n "+jmeno);
                    }
                }
                fw.append(
                    "\n Hodnocení: "+animovaneFilmy.get(i).getHodnoceni()+
                    "\n Slovní hodnocení: "+animovaneFilmy.get(i).getSlovniHodnoceni()+
                    "\n Doporučený věk diváka: "+animovaneFilmy.get(i).getDoporucenyVek()
                );
                fw.close();
            }catch (Exception e) {
                System.out.println("aaaaaaa");
                
            }
        break;
        case 0:
            System.out.println("    Film nenalezen");
        break;
        }
    }
    public static void nacist(List<FilmAnimovany> animovaneFilmy, List<FilmHrany> hraneFilmy, List<Herec> herci){
        try {
            Scanner sc = new Scanner(System.in);
            String soubor = sc.next();
            File file = new File("filmy/nahravani/"+soubor+".txt");
            Scanner scanner = new Scanner(file);
            List<String> seznamHercu = new ArrayList<>();
            while (scanner.hasNext()) {
                String hodnota=scanner.nextLine();
                int druh = Integer.parseInt(hodnota);
                String nazev = scanner.nextLine();
                if(InputChecker.dotupnyNazev(nazev, hraneFilmy, animovaneFilmy)){
                    switch(druh){
                        case 1:
                            String reziser = scanner.nextLine();
                            int rok = Integer.parseInt(scanner.nextLine());
                            String herciText = scanner.nextLine();
                            for (String herec : herciText.split(";")){
                                if(herec !=""){
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
                            }
                            int hodnoceni = Integer.parseInt(scanner.nextLine());
                            String slovHodnoceni = scanner.nextLine();

                            hraneFilmy.add(new FilmHrany(nazev, reziser, rok, seznamHercu, hodnoceni, slovHodnoceni));
                        break;
                        case 2:
                            reziser = scanner.nextLine();
                            rok = Integer.parseInt(scanner.nextLine());
                            herciText = scanner.nextLine();
                            for (String herec : herciText.split(";")){
                                if(herec !=""){
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
                            }
                            hodnoceni = Integer.parseInt(scanner.nextLine());
                            slovHodnoceni = scanner.nextLine();
                            int vek = Integer.parseInt(scanner.nextLine());
                            animovaneFilmy.add(new FilmAnimovany(nazev, reziser, rok, seznamHercu, hodnoceni, slovHodnoceni,vek));
                        break;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen :(");
        }
    }
}

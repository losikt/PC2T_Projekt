import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int volba;
        Scanner sc = new Scanner(System.in);
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
            "[0] Konec\n"+
            "Vyber akci: ");
            volba = sc.nextInt();
        }while(volba !=0);
    }
}

import java.util.Scanner;
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
            System.out.print("Zadej cislo!! :");
            input.nextLine();
            cislo =getInt(input);
        }
        return cislo;
    }

}

import java.util.Scanner;
public class InputChecker {
    public static int getInt(Scanner input)
    {
        int cislo = 0;
        try{
            cislo = input.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("\nZadej cislo!! :");
            input.nextLine();
            cislo =getInt(input);
        }
        return cislo;
    }


}

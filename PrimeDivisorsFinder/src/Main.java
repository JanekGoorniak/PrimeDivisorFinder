import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        int a;
        boolean noQuit = true;
        PrimeList primeList = new PrimeList(true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileHandler fileHandler = new FileHandler("SaveFile");
        while(noQuit)
        {
            try
            {
                a = Integer.parseInt(reader.readLine());
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }

            switch (a)
            {
                case 0:
                    noQuit = false; break;

                case -1:
                    if (Debug.debug)
                    {
                        Debug.debug = false;
                        System.out.println("Debug mode OFF");
                    }
                    else
                    {
                        Debug.debug = true;
                        System.out.println("Debug mode ON");
                    }
                    break;


                case -2:
                    System.out.println("Saving...");
                    try
                    {
                        fileHandler.overwrite(primeList);
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ready!");
                     break;

                case -3:
                    System.out.println("Loading...");
                    try
                    {
                        primeList = fileHandler.loadFile();
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ready!");
                    break;

                default:
                    if(a < 0)
                    {
                        System.out.println("Invalid input");
                    }
                    else
                    {
                        System.out.println("Please wait...");
                        System.out.println(primeList.findDivisors(a).stringMaker());
                    }
            }
        }
    }
}
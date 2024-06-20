import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        int a;
        boolean noQuit = true;
        PrimeList primeList = new PrimeList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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

            if(a == 0)
            {
                noQuit = false;
            }
            else if(a == -1)
            {
                Debug.debug = true;
            }
            else if(a < 0)
            {
                System.out.println("Invalid input");
            }
            else
            {
                System.out.println(primeList.findDivisors(a).stringMaker());
            }
        }
    }
}
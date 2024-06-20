import java.util.ArrayList;
import java.util.List;

public class DivisorList
{
    List<PrimeInt> divisorList = new ArrayList<>();

    String stringMaker()
    {
        String temp = "";
        for (PrimeInt primeInt : divisorList)
        {
            temp += primeInt.pint + ", ";
        }
        return temp;
    }
}

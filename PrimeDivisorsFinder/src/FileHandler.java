import java.io.*;

public class FileHandler
{
    String path;


    public FileHandler(String path)
    {
        this.path = path;
    }

    void overwrite(PrimeList primeList) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for(int i = 0; i < primeList.primeList.size(); i++)
        {
            writer.write(String.valueOf(primeList.primeList.get(i).pint) + "\n");
        }
    }

    PrimeInt loadLine(BufferedReader reader) throws IOException
    {
        String temp = reader.readLine();
        if(temp == null)
            return new PrimeInt(0);
        return new PrimeInt(Integer.parseInt(temp));
    }

    PrimeList loadFile() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrimeInt loadedInt;
        PrimeList loadedList = new PrimeList(false);
        do
        {
            loadedInt = loadLine(reader);
            loadedList.primeList.add(loadedInt);
            if(Debug.debug)
                System.out.println(loadedInt.pint);
        }
        while(loadedInt.pint != 0);
        loadedList.largestCheckedNumber = loadedList.primeList.getLast().pint;
        return loadedList;
    }
}

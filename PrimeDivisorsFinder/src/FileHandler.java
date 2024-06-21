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
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.path));
        for(int i = 0; i < primeList.primeList.size(); i++)
        {
            if(Debug.debug)
                System.out.println(primeList.primeList.get(i).pint);
            writer.write(primeList.primeList.get(i).pint + "\n");
            if(Debug.debug)
                writer.write("TEST STRING\n");

        }
        writer.flush();
        writer.close();
    }

    PrimeInt loadLine(BufferedReader reader) throws IOException
    {
        String temp = reader.readLine();
        if(temp == null)
            return new PrimeInt(0);
        if(temp.equals("TEST STRING"))
            temp = reader.readLine();
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
            if(loadedInt.pint != 0)
                loadedList.primeList.add(loadedInt);
            if(Debug.debug)
                System.out.println(loadedInt.pint);
        }
        while(loadedInt.pint != 0);
        if(!loadedList.primeList.isEmpty())
            loadedList.largestCheckedNumber = loadedList.primeList.getLast().pint;
        return loadedList;
    }
}

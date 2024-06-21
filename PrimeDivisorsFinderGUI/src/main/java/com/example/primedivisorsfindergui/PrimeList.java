package com.example.primedivisorsfindergui;

import java.util.ArrayList;
import java.util.List;

public class PrimeList
{
    List<PrimeInt> primeList = new ArrayList<>();
    int largestCheckedNumber = 3;

    public PrimeList(boolean notLoaded)
    {
        if(notLoaded)
        {
            primeList.add(new PrimeInt(2));
            primeList.add(new PrimeInt(3));
        }
    }

    boolean isOnList(int a)
    {
        for (PrimeInt primeInt : primeList)
        {
            if (primeInt.pint == a)
                return true;
        }
        return false;
    }

    boolean primeCheck(int a)
    {
        for (PrimeInt primeInt : primeList)
        {
            if (a % primeInt.pint == 0)
                return false;
        }
        return true;
    }

    void expand(int a)
    {
        for(int i = largestCheckedNumber + 2; i <= a + (a % 2); i+=2)
        {
            if(primeCheck(i))
                primeList.add(new PrimeInt(i));
        }
        largestCheckedNumber = a + (a % 2);
    }

    DivisorList findDivisors(int a)
    {
        if (primeList.isEmpty())
        {
            this.primeList = new PrimeList(true).primeList;
        }

        if(a > largestCheckedNumber)
            expand(a);

        DivisorList divisorList = new DivisorList();
        int i = 0;
        while(i < primeList.size())
        {
            if(isOnList(a))
            {
                divisorList.divisorList.add(new PrimeInt(a));
                i = primeList.size();
            }
            else if(a % primeList.get(i).pint == 0)
            {
                divisorList.divisorList.add(primeList.get(i));
                a = a/primeList.get(i).pint;
            }
            else
                i++;
        }
        return divisorList;
    }
}

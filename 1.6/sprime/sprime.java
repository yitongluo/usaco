/*
ID: 100021881
LANG: JAVA
PROG: sprime
*/

import java.io.*;
import java.util.*;

public class sprime {
    public static void main(String[] args) throws Exception 
    {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int leng = Integer.parseInt(f.readLine());
        int[] x = {2,3,5,7};
        for (int a : getAllSpri(leng))
        {
            out.println(a);
        }

        f.close();
        out.close();
        
    }
    public static int[] getAllSpri(int totaldigit)
    {
        int[] firstprime = {2, 3, 5,7};
        int[] temp = firstprime;
        for (int i = 2; i <= totaldigit; i++)
        {
            if (i == 2)
            {
                temp = constructtemp(getnext(firstprime));
            }
            else
            {
                temp = constructtemp(getnext(temp));
            }
        }
        return temp;
    }

    public static int[] constructtemp (int[] input)
    {
        int count = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == 0)
            {
                break;
            }
            count++;
        }
        int[]result = new int[count];
        for (int i = 0; i < count; i++)
        {
            result[i] = input[i];
        }
        return result;
    }

    public static int[] getnext(int[] input) 
    {
        int[]output = new int[input.length * 4];
        int count = 0;
        for (int i = 0; i < input.length; i++)
        {
            int base = input[i] * 10;
            if (isPrime(base + 1))
            {
                output[count] = base + 1;
                count++;
            }
            if (isPrime(base + 3))
            {
                output[count] = base + 3;
                count++;
            }
            if (isPrime(base + 7))
            {
                output[count] = base + 7;
                count++;
            }
            if (isPrime(base + 9))
            {
                output[count] = base + 9;
                count++;
            }  
        }
        return output;
    }
    public static boolean isPrime(int x)
    {
        if (x == 2 || x == 3)
        {
            return true;
        }
        if (x % 2==0 || x % 3 == 0)
        {
            return false;
        }
        if (!(x % 6 == 1) && ! (x % 6 == 5))
        {
            return false;
        }
        int i = 6;
        while (true)
        {
            if ( i < x /2 + 1)
            {
                boolean t = x % (i - 1) !=0 && x %(i + 1)!=0;
                if (!t)
                {
                    return false;
                }
            }
            else
            {
                break;
            }
            i+=6;   
        }
        return true;
    }
}
/*
ID: yitongl1
LANG: JAVA
TASK: airprog
*/
import java.io.*;
import java.util.*;

class airprog
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("airprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("airprog.out")));
        int proglength = Integer.parseInt(f.readLine());   
        int b = Integer.parseInt(f.readLine());   
        boolean[] allbisquare = new boolean[2 * b * b + 17];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 1;
        for (int i = 0; i <= b; i++)
        {
            for (int j = 0; j <= b; j++)
            {
                allbisquare[i * i + j * j] = true;
            }
        }
        for (int i = 1; i < allbisquare.length; i++)
        {
            if(allbisquare[i])
            {
                list.add(i);
                count++;
            }
        }
        //out.println(Arrays.toString(allbisquare));
        boolean[][] result = new boolean[2 * (b + 1) * (b + 1)][2 * (b + 1) * (b + 1)];
        boolean have = false;
        for (int x : list)
        {
            out.println(x);
        }
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (formsequence(allbisquare, list.get(i), list.get(j) - list.get(i), proglength))
                {
                    result[list.get(j) - list.get(i)][list.get(i)] = true;
                }
            }
        }
        for (int i = 1; i < result.length; i++)
        {
            for (int k = 1; k < result.length; k++)
            {
                if (result[i][k])
                {
                    have =true;
                    out.println(i + " " + k);
                }
            }
        }
        if (!have)
        {
            out.println("NONE");
        }
        out.close();                                  
        f.close();
    }

    public static boolean formsequence (boolean[] allbisquare, int start, int interval, int length)
    {
        int count = 1;
        for (int k = 0; k < length && start + k *interval < allbisquare.length; k++)
        {
            if (!allbisquare[start + k * interval])
            {
                return false;
            }
            count++;
        }
        return count == length;
    }
}
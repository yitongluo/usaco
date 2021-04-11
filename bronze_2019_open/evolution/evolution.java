/*
ID: yitongl1
LANG: JAVA
TASK: evolution
*/
import java.io.*;
import java.util.*;

class evolution
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("evolution.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int n = Integer.parseInt(f.readLine());
        String [][] subpop = new String [n][n];
        String [] character = new String[n];
        int [][] belong = new int[n][n];
        int index = 0;
        int[] belongIndex = new int[n];
        for (int a = 0; a < n; a++)
        {
            for (int b = 0; b < n; b++)
            {
                belong[a][b] = -1;
            }
        }
        for (int i = 0; i < n; i++) // i is the location of subpopulation
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++)
            {
                String current = st.nextToken();
                subpop [i][j] = current;
                if (current != null && isNew(current, character))
                {
                    character[index] = current;
                    index++;
                }
                if (current != null)
                {
                    int currentplace = getIndex(current, character);
                    belong[currentplace][belongIndex[currentplace]] = i;
                    belongIndex[currentplace]++;
                }
            }
        }
        int[] a1 = {1, 7, 8, -1, -1};
        int[] b1 = {1, 2, 3, 4, 5, -1};
        System.out.println(determineUnrelated(a1, b1));
        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(subpop[i]));
        }

        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(belong[i]));
        }
        System.out.println(Arrays.toString(character));
        if(compute(belong))
        {
            out.println("yes");
        }
        else
        {
            out.println("no");
        }
        out.close();                                 
        f.close();
    }

    public static boolean isNew(String input, String[] character)
    {
        for (int i = 0; i < character.length; i++)
        {
            if (input.equals(character[i]))
            {
                return false;
            }
        }
        return true;
    }

    public static int getIndex(String input, String[] character)
    {
        for (int i = 0; i < character.length; i++)
        {
            if (input.equals(character[i]))
            {
                return i;
            }
        }
        return -1;
    }

    public static boolean compute(int[][] belong)
    {
        for (int i = 0; i < belong.length; i++)
        {
            for (int j = 0; j < belong.length; j++)
            {
                if (!(determineSubset(belong[i], belong[j]) || determineSubset(belong[j], belong[i]) ||
                determineUnrelated(belong[i], belong[j])))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean determineUnrelated(int[]a, int[]b)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != -1 && isPart(a[i], b))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean determineSubset(int[]a, int[]b)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != -1 && !isPart(a[i], b))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPart(int x, int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (x == a[i])
            {
                return true;
            }
        }
        return false;
    }
}
/*
ID: yitongl1
LANG: JAVA
TASK: lineup
*/
import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

class lineup
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        String[] name = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
        int[] list = {0, 1, 2, 3, 4, 5, 6, 7};
        boolean[] used = {false, false, false, false, false, false, false, false};
        int[] current = new int[8]; 
        int n = Integer.parseInt(f.readLine());  
        int[][] requirement = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer s = new StringTokenizer(f.readLine());
            for (int j = 0; j < 6; j++)
            {
                String word = s.nextToken();
                if (j == 0)
                {
                    requirement[i][0] = getindex(name, word);
                }
                if (j == 5)
                {
                    requirement[i][1] = getindex(name, word);
                }
            }
        }  
        // for (int a = 0; a < requirement.length; a++)
        // {
        //     System.out.println(Arrays.toString(requirement[a]));
        // }
        // int[] input = {0, 7, 1, 3, 4, 5, 2, 6};
        // System.out.println(isok(requirement, input));
        getpermu(list, used, current, 0, requirement, out, name);
        f.close();
        out.close();
    }

    public static void getpermu(int[]list, boolean[] used, int[] current, int idx,
    int[][] requirement, PrintWriter out, String[] namelist)
    {
        if (idx == list.length && isok(requirement, current))
        {
            for (int x : current)
            {
                out.println(namelist[x]);
            } 
            out.close(); 
        }
        for (int i = 0; i < list.length; i++)
        {
            if (used[i] == false)
            {
                int[] current2 = Arrays.copyOf(current, current.length);
                boolean[] used2 = Arrays.copyOf(used, used.length);
                current2[idx] = list[i];
                used2[i] = true;
                getpermu(list, used2, current2, idx + 1, requirement, out, namelist);
            }
            if (idx == 8)
            {
                break;
            }
        }
    }

    public static int getindex (String[] namelist, String name)
    {
        for (int i = 0; i < namelist.length; i++)
        {
            if (namelist[i].equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    public static int getintidx(int[] list, int n)
    {
        for (int i = 0; i < 8; i++)
        {
            if (list[i] == n)
            {
                return i;
            }
        }
        return -1;
    }

    public static boolean isok(int[][] requirement, int[] name)
    {
        for (int i = 0; i < requirement.length; i++)
        {
            int first = getintidx(name, requirement[i][0]);
            int second = getintidx(name, requirement[i][1]);
            if (!(first - second == 1 || second - first == 1))
            {
                return false;
            }
        }
        return true;
    }
}